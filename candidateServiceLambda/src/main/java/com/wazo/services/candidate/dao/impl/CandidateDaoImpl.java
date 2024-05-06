package com.wazo.services.candidate.dao.impl;

import com.amazonaws.HttpMethod;
import com.google.gson.Gson;
import com.wazo.models.candidate.Address;
import com.wazo.models.candidate.Contact;
import com.wazo.services.candidate.ConfigurationServiceClient.impl.ConfigurationRestClientImpl;
import com.wazo.services.candidate.Exceptions.type.*;
import com.wazo.services.candidate.clients.DynamoDb;
import com.wazo.services.candidate.dao.CandidateDao;
import com.wazo.services.candidate.dao.entity.AddressEntity;
import com.wazo.services.candidate.dao.entity.CandidateEntity;
import com.wazo.services.candidate.dao.entity.ContactEntity;
import com.wazo.services.candidate.handler.CandidateLambdaMainHandler;
import com.wazo.services.candidate.model.response.CandidateResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.*;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;
import software.amazon.awssdk.services.dynamodb.model.ResourceNotFoundException;
import software.amazon.awssdk.utils.StringUtils;

import java.util.*;

import static com.wazo.services.candidate.Exceptions.type.ErrorCode.*;
import static com.wazo.services.candidate.utils.Constants.*;


public class CandidateDaoImpl implements CandidateDao {
    private static final String TABLE_NAME = CANDIDATE_TABLE_NAME;
    private final DynamoDb dynamoDb;
    private static final Gson gson = new Gson();
    private static final Logger log = LoggerFactory.getLogger(CandidateLambdaMainHandler.class);

    private final ConfigurationRestClientImpl configurationRestClient;

    public CandidateDaoImpl(DynamoDb dynamoDb, ConfigurationRestClientImpl configurationRestClient) {
        this.dynamoDb = dynamoDb;
        this.configurationRestClient = configurationRestClient;
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
    public CandidateEntity updateCandidateDetails(CandidateEntity candidate) {
        try {
            DynamoDbTable<CandidateEntity> tableObj = dynamoDb.getEnhanceClient().table(TABLE_NAME, TableSchema.fromBean(CandidateEntity.class));

            Key candidateKey = Key.builder()
                    .partitionValue(candidate.getOrgId())
                    .sortValue(candidate.getCandidateId())
                    .build();
            CandidateEntity updateEntity = tableObj.getItem(r -> r.key(candidateKey));

            updateEntity.setFirstName(candidate.getFirstName());
            updateEntity.setLastName(candidate.getLastName());
            updateEntity.setDateOfBirth(candidate.getDateOfBirth());
            updateEntity.setGender(candidate.getGender());
            updateEntity.setNationality(candidate.getNationality());
            updateEntity.setProfessionalExperience(candidate.getProfessionalExperience());
            updateEntity.setEducation(candidate.getEducation());
            updateEntity.setSkillSet(candidate.getSkillSet());
            updateEntity.setApplicationSource(candidate.getApplicationSource());
            updateEntity.setCandidateNoticePeriod(candidate.getCandidateNoticePeriod());
            updateEntity.setCandidateInterviewAvailability(candidate.getCandidateInterviewAvailability());
            updateEntity.setPortfolio(candidate.getPortfolio());
            updateEntity.setSocialMediaProfile(candidate.getSocialMediaProfile());
            updateEntity.setProfessionalReference(candidate.getProfessionalReference());
            updateEntity.setEeoDetails_discrimination(candidate.getEeoDetails_discrimination());
            updateEntity.setEeoDetails_race(candidate.getEeoDetails_race());
            updateEntity.setEeoDetails_ethnicity(candidate.getEeoDetails_ethnicity());
            updateEntity.setEeoDetails_gender(candidate.getEeoDetails_gender());
            updateEntity.setEeoDetails_age(candidate.getEeoDetails_age());
            updateEntity.setEeoDetails_disabilities(candidate.getEeoDetails_disabilities());
            updateEntity.setEeoDetails_militaryExperience(candidate.getEeoDetails_militaryExperience());
            updateEntity.setEeoDetails_religion(candidate.getEeoDetails_religion());
            updateEntity.setEeoDetails_maritalStatus(candidate.getEeoDetails_maritalStatus());
            updateEntity.setEeoDetails_sexualOrientation(candidate.getEeoDetails_sexualOrientation());
            updateEntity.setEeoDetails_protectedClass(candidate.getEeoDetails_protectedClass());
            updateEntity.setCustomCandidateFields(candidate.getCustomCandidateFields());

            tableObj.updateItem(updateEntity);
            return updateEntity;
        }
        catch (DynamoDbException dex) {
            throw new UpdateCandidateDetailsException(DYNAMODB_CONNECTION_ERROR);
        }
        catch (Exception ex) {
            throw new UpdateCandidateDetailsException(CANDIDATE_DETAILS_NOT_UPDATED);
        }
    }

    @Override
    public CandidateEntity updateCandidateUnderProcess(CandidateEntity candidate) {
        try {
            DynamoDbTable<CandidateEntity> tableObj = dynamoDb.getEnhanceClient().table(TABLE_NAME, TableSchema.fromBean(CandidateEntity.class));

            Key candidateKey = Key.builder()
                    .partitionValue(candidate.getOrgId())
                    .sortValue(candidate.getCandidateId())
                    .build();
            CandidateEntity updateEntity = tableObj.getItem(r -> r.key(candidateKey));

            List<String> updateReqList = updateEntity.getRequisitionList();
            Set<String> updateReqSet = new HashSet<>(updateReqList);


            if(candidate.getRequisitionList().size() > updateReqList.size()) {
                for (String s : candidate.getRequisitionList()) {
                    updateReqSet.add(s);
                }
                updateEntity.setRequisitionList(new ArrayList<>(updateReqSet));
            }
            else{
                updateEntity.setRequisitionList(candidate.getRequisitionList());
            }

            updateEntity.setIsUnderProcess(candidate.getIsUnderProcess());
            tableObj.updateItem(updateEntity);
            return updateEntity;
        }
        catch (DynamoDbException dex) {
            throw new UpdateCandidateDetailsException(DYNAMODB_CONNECTION_ERROR);
        }
        catch (Exception ex) {
            throw new UpdateCandidateDetailsException(CANDIDATE_UNDER_PROCESS_UPDATE_FAILED);
        }
    }

    @Override
    public String updateCandidateComments(CandidateEntity candidate) {
        try{
            DynamoDbTable<CandidateEntity> tableObj = dynamoDb.getEnhanceClient().table(TABLE_NAME, TableSchema.fromBean(CandidateEntity.class));

            Key candidateKey = Key.builder()
                    .partitionValue(candidate.getOrgId())
                    .sortValue(candidate.getCandidateId())
                    .build();
            CandidateEntity updateEntity = tableObj.getItem(r -> r.key(candidateKey));

            updateEntity.setComments(StringUtils.isEmpty(candidate.getComments()) ? "" : candidate.getComments());
            updateEntity.setCandidateInterviewAvailability(StringUtils.isEmpty(candidate.getCandidateInterviewAvailability()) ? "" : candidate.getCandidateInterviewAvailability());
            updateEntity.setCandidateNoticePeriod(StringUtils.isEmpty(candidate.getCandidateNoticePeriod()) ? "" : candidate.getCandidateNoticePeriod());

            tableObj.updateItem(updateEntity);
            return UPDATE_SUCCESS_MSG_REMARKS;
        }
        catch(DynamoDbException dex) {
            throw new UpdateCandidateDetailsException(DYNAMODB_CONNECTION_ERROR);
        }
        catch(Exception ex) {
            throw new UpdateCandidateDetailsException(CANDIDATE_REMARKS_UPDATE_FAILED);
        }
    }

    @Override
    public String updateCandidateDocuments(CandidateEntity candidate) {
        try{
            DynamoDbTable<CandidateEntity> tableObj = dynamoDb.getEnhanceClient().table(TABLE_NAME, TableSchema.fromBean(CandidateEntity.class));

            Key candidateKey = Key.builder()
                    .partitionValue(candidate.getOrgId())
                    .sortValue(candidate.getCandidateId())
                    .build();

            CandidateEntity updateEntity = tableObj.getItem(r -> r.key(candidateKey));
            updateEntity.setDocumentList(candidate.getDocumentList());

            tableObj.updateItem(updateEntity);
            return UPDATE_SUCCESS_MSG_DOCUMENTS;
        }
        catch(DynamoDbException dex) {
            throw new UpdateCandidateDetailsException(DYNAMODB_CONNECTION_ERROR);
        }
        catch(Exception ex) {
            throw new UpdateCandidateDetailsException(CANDIDATE_REMARKS_UPDATE_FAILED);
        }
    }

    @Override
    public CandidateEntity updateCandidateAddress(CandidateEntity candidateEntity) {
        return null;
    }

    @Override
    public String updateCandidateContact(CandidateEntity candidateEntity) {
        return null;
    }

    @Override
    public ContactEntity getContactFromConfigServer(String contactId, String orgId) {
        String urlForGetContact = CONFIG_SERVICE_ENDPOINT_BASE_URL + orgId + "/" + CONFIG_SERVICE_ENDPOINT_CONFIG + CONFIG_SERVICE_ENDPOINT_CONFIG_TYPE_ADDRESS
                + contactId + "/" + CONFIG_SERVICE_ENDPOINT_VERSIONS + "0";

        try {
            String result =  configurationRestClient.executeRequestConfigurationServiceClient(urlForGetContact, "", HttpMethod.GET.toString());
            ContactEntity responseEntity = gson.fromJson(result, ContactEntity.class);
            ContactEntity resultEntity = ContactEntity.builder()
                    .entityId(responseEntity.getEntityId())
                    .system(responseEntity.getSystem())
                    .value(responseEntity.getValue())
                    .rank(responseEntity.getRank())
                    .build();

            return resultEntity;
        } catch (Exception ex) {
            throw new ContactNotPresentException(CONTACT_NOT_FOUND);
        }
    }

    @Override
    public String createContactToConfigServer(Contact contact, String orgId) {
        String urlForCreateContact = CONFIG_SERVICE_ENDPOINT_BASE_URL + orgId + "/" + CONFIG_SERVICE_ENDPOINT_CONFIG + CONFIG_SERVICE_ENDPOINT_CONFIG_TYPE_CONTACT;
        log.info("url for config server contact create is : " + urlForCreateContact);
        Contact requestEntity = Contact.builder()
                .system(contact.getSystem())
                .value(contact.getValue())
                .rank(contact.getRank())
                .build();
        try {
            String result =  configurationRestClient.executeRequestConfigurationServiceClient(urlForCreateContact, gson.toJson(requestEntity), HttpMethod.POST.toString());
            ContactEntity responseEntity = gson.fromJson(result, ContactEntity.class);
            return responseEntity.getEntityId();
        } catch (Exception ex) {
            throw new CandidateNotSavedException(CANDIDATE_NOT_SAVED);
        }
    }

    @Override
    public Address getAddressFromConfigServer(String addressId, String orgId) {
        String urlForGetAddress = CONFIG_SERVICE_ENDPOINT_BASE_URL + orgId + "/" + CONFIG_SERVICE_ENDPOINT_CONFIG + CONFIG_SERVICE_ENDPOINT_CONFIG_TYPE_ADDRESS
                + addressId + "/" + CONFIG_SERVICE_ENDPOINT_VERSIONS + "0";

        try {
            String result =  configurationRestClient.executeRequestConfigurationServiceClient(urlForGetAddress, "", HttpMethod.GET.toString());
            AddressEntity responseEntity = gson.fromJson(result, AddressEntity.class);
            Address resultEntity = Address.builder()
                    .addressId(responseEntity.getEntityId())
                    .addressLine1(responseEntity.getAddress())
                    .addressLine1(responseEntity.getLocationName())
                    .addressId(responseEntity.getLocationId())
                    .addressType(responseEntity.getAddressType())
                    .city(responseEntity.getCity())
                    .state(responseEntity.getState())
                    .zipCode(responseEntity.getZipCode())
                    .country(responseEntity.getCountry()).build();

            return resultEntity;
        } catch (Exception ex) {
            throw new AddressNotPresentException(ADDRESS_NOT_FOUND);
        }
    }

    @Override
    public String createAddressToConfigServer(Address address, String orgId) {
        String urlForCreateAddress = CONFIG_SERVICE_ENDPOINT_BASE_URL + orgId + "/" + CONFIG_SERVICE_ENDPOINT_CONFIG + CONFIG_SERVICE_ENDPOINT_CONFIG_TYPE_ADDRESS;
        log.info("url for config server address create is : " + urlForCreateAddress);
        AddressEntity requestEntity = AddressEntity.builder()
                .locationId(address.getAddressId())
                .locationName(address.getAddressLine2())
                .address(address.getAddressLine1())
                .AddressType(address.getAddressType())
                .City(address.getCity())
                .State(address.getState())
                .ZipCode(address.getZipCode())
                .Country(address.getCity())
                .build();
        try {
            String result =  configurationRestClient.executeRequestConfigurationServiceClient(urlForCreateAddress, gson.toJson(requestEntity), HttpMethod.POST.toString());
            AddressEntity responseEntity = gson.fromJson(result, AddressEntity.class);
            return responseEntity.getEntityId();
        } catch (Exception ex) {
            throw new AddressUploadException(ADDRESS_NOT_SAVED);
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
                //.isPresentSameAsPermanentAddress(candidate.getIsPresentSameAsPermanentAddress())
                //.addressList(getAddressList(candidate.getAddressList(), candidate.getOrgId()))
                .professionalExperience(candidate.getProfessionalExperience())
                .education(candidate.getEducation())
                .skillSet(candidate.getSkillSet())
                .documentList(candidate.getDocumentList())
                //.contactList(getContactList(candidate.getContactList(), candidate.getOrgId()))
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

    private List<ContactEntity> getContactList(List<String> contactList, String orgId) {
        List<ContactEntity> result = new ArrayList<>();
        for(String addrId : contactList) {
            ContactEntity contact = getContactFromConfigServer(addrId, orgId);
            result.add(contact);
        }
        return result;
    }

    private List<Address> getAddressList(List<String> addressList, String orgId) {
        List<Address> result = new ArrayList<>();
            for(String addrId : addressList) {
                Address address = getAddressFromConfigServer(addrId, orgId);
                result.add(address);
            }
        return result;
    }

}