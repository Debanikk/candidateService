package com.wazo.services.candidate.dao.impl;

import com.amazonaws.http.HttpMethodName;
import com.google.gson.Gson;
import com.wazo.services.candidate.Exceptions.type.AddressUploadException;
import com.wazo.services.candidate.Exceptions.type.CandidateNotSavedException;
import com.wazo.services.candidate.Exceptions.type.CandidateResourceNotFoundException;
import com.wazo.services.candidate.Exceptions.type.CandidateTableNotFound;
import com.wazo.services.candidate.clients.DynamoDb;
import com.wazo.services.candidate.dao.CandidateDao;
import com.wazo.services.candidate.dao.entity.AddressEntity;
import com.wazo.services.candidate.dao.entity.CandidateEntity;
import com.wazo.services.candidate.model.request.Address;
import com.wazo.services.candidate.model.request.Contact;
import com.wazo.services.candidate.model.request.CreateCandidateRequest;
import com.wazo.services.candidate.model.response.ApiGatewayResponse;
import com.wazo.services.candidate.model.response.CandidateResponse;
import com.wazo.services.candidate.utils.JsonApiGatewayCaller;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.*;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;
import software.amazon.awssdk.services.dynamodb.model.ResourceNotFoundException;

import java.io.ByteArrayInputStream;
import java.net.URI;
import java.util.*;

import static com.wazo.services.candidate.Exceptions.type.ErrorCode.*;
import static com.wazo.services.candidate.utils.Constants.*;
import static com.wazo.services.candidate.utils.Constants.AWS_API_GATEWAY_ENDPOINT_CONFIG_ADDRESS_CREATE;


public class CandidateDaoImpl implements CandidateDao {
    private static final String TABLE_NAME = "Candidate";//System.getenv("TABLE_NAME");
    private final DynamoDb dynamoDb;
    private static final Gson gson = new Gson();

    public CandidateDaoImpl(DynamoDb dynamoDb) {
        this.dynamoDb = dynamoDb;
    }

    @Override
    public CandidateEntity saveCandidateEntity(CandidateEntity candidateEntity) {
        try {
            DynamoDbTable<CandidateEntity> tableObj = dynamoDb.getEnhanceClient().table(TABLE_NAME, TableSchema.fromBean(CandidateEntity.class));
            tableObj.putItem(candidateEntity);
            return candidateEntity;
        } catch (Exception e) {
            throw new CandidateNotSavedException(CANDIDATE_NOT_SAVED);
        }
    }

    @Override
    public List<CandidateEntity> getAllCandidatesEntity(String orgId) {
        try {
            DynamoDbTable<CandidateEntity> tableObj = dynamoDb.getEnhanceClient().table(TABLE_NAME, TableSchema.fromBean(CandidateEntity.class));

            QueryConditional queryConditional = QueryConditional.keyEqualTo(Key.builder()
                                                    .partitionValue(orgId).build());

            QueryEnhancedRequest request = QueryEnhancedRequest.builder()
                                                    .queryConditional(queryConditional)
                    .addAttributeToProject("orgId")
                    .addAttributeToProject("candidateId")
                    .addAttributeToProject("firstName")
                    .addAttributeToProject("lastName")
                    .addAttributeToProject("gender")
                    .addAttributeToProject("dateOfBirth")
                    .addAttributeToProject("country")
                    .addAttributeToProject("nationality")
                    .addAttributeToProject("isUnderProcess").build();
            // TODO: Should we need to include the contact details in this set
            //  of attributes that we are returning for candidate get records
            Iterator<CandidateEntity> results = tableObj.query(request).items().iterator();
            ArrayList<CandidateEntity> arrayListObj = new ArrayList<>();
            while (results.hasNext()) {
                CandidateEntity oneItem = results.next();
                arrayListObj.add(oneItem);
            }

            if(arrayListObj.isEmpty()) {
                throw new CandidateResourceNotFoundException(RESOURCE_NOT_FOUND);
            }

            return arrayListObj;

        } catch (ResourceNotFoundException e) {
            throw new CandidateResourceNotFoundException(RESOURCE_NOT_FOUND);
        } catch (DynamoDbException e) {
            throw new CandidateTableNotFound(CANDIDATE_TABLE_NOT_FOUND);
        }
    }

    @Override
    public CandidateEntity getCandidateByIdEntity(String orgId, String candidateId) {
        try {
            DynamoDbTable<CandidateEntity> tableObj = dynamoDb.getEnhanceClient().table(TABLE_NAME, TableSchema.fromBean(CandidateEntity.class));

            QueryConditional queryConditional = QueryConditional.keyEqualTo(Key.builder()
                    .partitionValue(orgId).sortValue(candidateId).build());

            QueryEnhancedRequest request = QueryEnhancedRequest.builder()
                    .queryConditional(queryConditional)
                    .addAttributeToProject("orgId")
                    .addAttributeToProject("candidateId")
                    .addAttributeToProject("firstName")
                    .addAttributeToProject("lastName")
                    .addAttributeToProject("gender")
                    .addAttributeToProject("dateOfBirth")
                    .addAttributeToProject("country")
                    .addAttributeToProject("nationality")
                    .addAttributeToProject("isUnderProcess").build();
            // TODO: Should we need to include the contact details in this set
            //  of attributes that we are returning for candidate get records
            Iterator<CandidateEntity> results = tableObj.query(request).items().iterator();
            ArrayList<CandidateEntity> arrayListObj = new ArrayList<>();
            while (results.hasNext()) {
                CandidateEntity oneItem = results.next();
                arrayListObj.add(oneItem);
            }

            if(arrayListObj == null) {
                throw new CandidateResourceNotFoundException(RESOURCE_NOT_FOUND);
            }

             return arrayListObj.get(0);
        } catch (ResourceNotFoundException e) {
            throw new CandidateResourceNotFoundException(RESOURCE_NOT_FOUND);
        } catch (DynamoDbException e) {
            throw new CandidateTableNotFound(CANDIDATE_TABLE_NOT_FOUND);
        }
    }

    @Override
    public CandidateResponse getCandidateDetailsByIdEntity(String orgId, String candidateId) {
        try {
            DynamoDbTable<CandidateEntity> tableObj = dynamoDb.getEnhanceClient().table(TABLE_NAME, TableSchema.fromBean(CandidateEntity.class));

            Key key = Key.builder()
                    .partitionValue(orgId)
                    .sortValue(candidateId)
                    .build();

            CandidateEntity candidateDetails =  tableObj.getItem((GetItemEnhancedRequest.Builder requestBuilder) -> requestBuilder.key(key));
            if(candidateDetails == null) {
                throw new CandidateResourceNotFoundException(RESOURCE_NOT_FOUND);
            }

            return convertToCandidateResponse(candidateDetails);

        } catch (ResourceNotFoundException e) {
            throw new CandidateResourceNotFoundException(RESOURCE_NOT_FOUND);
        } catch (DynamoDbException e) {
            throw new CandidateTableNotFound(CANDIDATE_TABLE_NOT_FOUND);
        }
    }

    @Override
    public void deleteCandidateEntity(String orgId, String candidateId) {
        try {
            DynamoDbTable<CandidateEntity> tableObj = dynamoDb.getEnhanceClient().table(TABLE_NAME, TableSchema.fromBean(CandidateEntity.class));

            Key key = Key.builder()
                    .partitionValue(orgId)
                    .sortValue(candidateId)
                    .build();

            BatchWriteItemEnhancedRequest request = BatchWriteItemEnhancedRequest.builder()
                    .writeBatches(WriteBatch.builder(CandidateEntity.class)
                            .mappedTableResource(tableObj)
                            .addDeleteItem(DeleteItemEnhancedRequest.builder()
                                    .key(key)
                                    .build())
                            .build())
                    .build();

            dynamoDb.getEnhanceClient().batchWriteItem(request);
        } catch (DynamoDbException e) {
            throw new CandidateTableNotFound(CANDIDATE_TABLE_NOT_FOUND);
        }
    }

    private CandidateResponse convertToCandidateResponse(CandidateEntity candidate) {
        CandidateResponse response = CandidateResponse.builder()
                .orgId(candidate.getOrgId())
                .candidateId(candidate.getCandidateId())
                .firstName(candidate.getFirstName())
                .lastName(candidate.getLastName())
                .gender(candidate.getGender())
                .isPresentSameAsPermanentAddress(candidate.getIsPresentSameAsPermanentAddress())
                .addressList(getAddressList(candidate.getAddressList()))
                .professionalExperience(candidate.getProfessionalExperience())
                .education(candidate.getEducation())
                .skillSet(candidate.getSkillSet())
                .documentList(candidate.getDocumentList())
                .contactList(getContactList(candidate.getContactList()))
                .applicationSource(candidate.getApplicationSource())
                .candidateNoticePeriod(candidate.getCandidateNoticePeriod())
                .candidateInterviewAvailability(candidate.getCandidateInterviewAvailability())
                .portfolio(candidate.getPortfolio())
                .socialMediaProfile(candidate.getSocialMediaProfile())
                .professionalReference(candidate.getProfessionalReference())
                .eeoDetails_discrimination(candidate.getEeoDetails_discrimination())
                .eeoDetails_race(candidate.getEeoDetails_race())
                .eeoDetails_ethnicity(candidate.getEeoDetails_ethnicity())
                .eeoDetails_gender(candidate.getEeoDetails_gender())
                .eeoDetails_age(candidate.getEeoDetails_age())
                .eeoDetails_disabilities(candidate.getEeoDetails_disabilities())
                .eeoDetails_militaryExperience(candidate.getEeoDetails_militaryExperience())
                .eeoDetails_religion(candidate.getEeoDetails_religion())
                .eeoDetails_maritalStatus(candidate.getEeoDetails_maritalStatus())
                .eeoDetails_sexualOrientation(candidate.getEeoDetails_sexualOrientation())
                .eeoDetails_protectedClass(candidate.getEeoDetails_protectedClass())
                .isUnderProcess(candidate.getIsUnderProcess())
                .customCandidateFields(candidate.getCustomCandidateFields())
                .build();
        return response;
    }

    private List<Contact> getContactList(List<String> contactList) {
        List<Contact> result = new ArrayList<>();

        return result;
    }

    private List<Address> getAddressList(List<String> addressList) {
        List<Address> result = new ArrayList<>();
            for(String addr : addressList) {
                Address address = getAddress(addr);
                result.add(address);
            }
        return result;
    }

    private Address getAddress(String addressId) {
        try {
            JsonApiGatewayCaller caller = new JsonApiGatewayCaller(
                    AWS_IAM_ACCESS_KEY,
                    AWS_IAM_SECRET_ACCESS_KEY,
                    null,
                    AWS_REGION,
                    new URI(AWS_API_GATEWAY_ENDPOINT_CONFIG_ADDRESS_CREATE)
            );

            ApiGatewayResponse response = caller.execute(HttpMethodName.GET,
                    "/address",
                    new ByteArrayInputStream(addressId.getBytes()));
            Address address = gson.fromJson(response.getContent(), Address.class);

        }
        catch(Exception ex) {
            ex.printStackTrace();
            throw new AddressUploadException(ADDRESS_NOT_SAVED);
        }
    }

}