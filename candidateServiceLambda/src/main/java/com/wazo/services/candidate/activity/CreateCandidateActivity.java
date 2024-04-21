package com.wazo.services.candidate.activity;

import com.amazonaws.http.HttpMethodName;
import com.google.gson.Gson;
import com.wazo.services.candidate.Exceptions.type.AddressUploadException;
import com.wazo.services.candidate.Exceptions.type.ContactUploadException;
import com.wazo.services.candidate.dao.CandidateDao;
import com.wazo.services.candidate.dao.entity.*;
import com.wazo.services.candidate.model.request.Address;
import com.wazo.services.candidate.model.request.Contact;
import com.wazo.services.candidate.model.response.ApiGatewayResponse;
import com.wazo.services.candidate.model.response.ApiResponse;
import com.wazo.services.candidate.model.request.CreateCandidateRequest;
import com.wazo.services.candidate.utils.JsonApiGatewayCaller;
import com.wazo.services.candidate.validation.ValidateCreateCandidateRequest;
import lombok.AllArgsConstructor;
import software.amazon.awssdk.utils.StringUtils;

import javax.inject.Inject;
import java.io.ByteArrayInputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.wazo.services.candidate.Exceptions.type.ErrorCode.ADDRESS_NOT_SAVED;
import static com.wazo.services.candidate.Exceptions.type.ErrorCode.CONTACT_NOT_SAVED;
import static com.wazo.services.candidate.utils.Constants.*;

@AllArgsConstructor(onConstructor = @__(@Inject))
public class CreateCandidateActivity {
    private final CandidateDao candidateDao;
    private final ValidateCreateCandidateRequest validateCreateCandidateRequest;

    private static final Gson gson = new Gson();

    public ApiResponse run(String orgId, String requestBody) {
        CreateCandidateRequest createcandidateRequest = gson.fromJson(requestBody, CreateCandidateRequest.class);
        if (validateCreateCandidateRequest.isValid(createcandidateRequest)) {
            try {

                String partitionKey = orgId;
                String sortKey = UUID.randomUUID().toString();


                CandidateEntity candidateEntity = CandidateEntity.builder()
                        .orgId(partitionKey)
                        .candidateId(sortKey)
                        .requisitionList(createcandidateRequest.getRequisitionIdList().size() < 1 ?
                                new ArrayList<>() : createcandidateRequest.getRequisitionIdList())
                        .firstName(createcandidateRequest.getFirstName())
                        .lastName(createcandidateRequest.getLastName())
                        .dateOfBirth(createcandidateRequest.getDateOfBirth())
                        .gender(createcandidateRequest.getGender())
                        .nationality(createcandidateRequest.getNationality())
                        .contactList(processContact(createcandidateRequest.getContact()))
                        .isPresentSameAsPermanentAddress(createcandidateRequest.getIsPresentAddressSameAsPermanent())
                        .addressList(ProcessCandidateAddress(createcandidateRequest.getAddressList(),
                                createcandidateRequest.getIsPresentAddressSameAsPermanent() != null ?
                                        createcandidateRequest.getIsPresentAddressSameAsPermanent() : true))
                        .professionalExperience(createcandidateRequest.getProfessionalExperience())
                        .education(createcandidateRequest.getEducation())
                        .skillSet(createcandidateRequest.getSkillSet())
                        .documentList(createcandidateRequest.getDocuments())
                        .applicationSource(createcandidateRequest.getApplicationSource())
                        .candidateNoticePeriod(createcandidateRequest.getCandidateNoticePeriod())
                        .candidateInterviewAvailability(createcandidateRequest.getCandidateInterviewAvailability())
                        .portfolio(createcandidateRequest.getPortfolio())
                        .socialMediaProfile(createcandidateRequest.getSocialMediaProfile())
                        .professionalReference(createcandidateRequest.getProfessionalReference())
                        .eeoDetails_discrimination(createcandidateRequest.getEeoDetails_discrimination())
                        .eeoDetails_race(createcandidateRequest.getEeoDetails_race())
                        .eeoDetails_ethnicity(createcandidateRequest.getEeoDetails_ethnicity())
                        .eeoDetails_gender(createcandidateRequest.getEeoDetails_gender())
                        .eeoDetails_age(createcandidateRequest.getEeoDetails_age())
                        .eeoDetails_disabilities(createcandidateRequest.getEeoDetails_disabilities())
                        .eeoDetails_militaryExperience(createcandidateRequest.getEeoDetails_militaryExperience())
                        .eeoDetails_religion(createcandidateRequest.getEeoDetails_religion())
                        .eeoDetails_maritalStatus(createcandidateRequest.getEeoDetails_maritalStatus())
                        .eeoDetails_sexualOrientation(createcandidateRequest.getEeoDetails_sexualOrientation())
                        .eeoDetails_protectedClass(createcandidateRequest.getEeoDetails_protectedClass())
                        .isUnderProcess(createcandidateRequest.getIsUnderProcess())
                        .customCandidateFields(createcandidateRequest.getCustomCandidateFields())
                        .build();

                CandidateEntity createCandidateEntityObj = candidateDao.saveCandidateEntity(candidateEntity);
                return ApiResponse.builder()
                        .status(201)
                        .message("Candidate created successfully!")
                        .data(createCandidateEntityObj)
                        .build();

            } catch (Exception e) {
                e.printStackTrace();
                return ApiResponse.builder()
                        .status(500)
                        .message("Something went wrong, try again!")
                        .build();
            }
        } else {
            return ApiResponse.builder()
                    .status(400)
                    .message("Invalid request data! Please check candidate data as it does not meet required fields for a candidate record")
                    .errors(validateCreateCandidateRequest.getErrors())
                    .build();
        }
    }

    private List<String> ProcessCandidateAddress(List<Address> addressList, Boolean isPresentSameAsPermanent) {
        List<String> addressIdList = new ArrayList<>();
        /*addressIdList.add(saveAddress(addr, isPresentSameAsPermanent ?
                    ADDRESS_PRESENT : addr.getAddressType().toUpperCase(Locale.ROOT)));*/
        if(isPresentSameAsPermanent) {
            saveAddress(convertToAddressEntity(addressList.get(0)));
        }
        else {
            for(Address addr : addressList) {
                saveAddress(convertToAddressEntity(addr));
            }
        }

        return addressIdList;
    }

    private AddressEntity convertToAddressEntity(Address address) {
        AddressEntity entity = AddressEntity.builder()
                .Address(StringUtils.trim(address.getAddressLine1()) + " " + StringUtils.trim(address.getAddressLine2()))
                .locationName(address.getCountry())
                .AddressType(address.getAddressType())
                .City(address.getCity())
                .State(address.getState())
                .Country(address.getCountry())
                .ZipCode(address.getZipCode()).build();
        return entity;
    }

    private String saveAddress(AddressEntity addressEntity) {
        try {
            JsonApiGatewayCaller caller = new JsonApiGatewayCaller(
                    AWS_IAM_ACCESS_KEY,
                    AWS_IAM_SECRET_ACCESS_KEY,
                    null,
                    AWS_REGION,
                    new URI(AWS_API_GATEWAY_ENDPOINT_CONFIG_ADDRESS_CREATE)
            );

            ApiGatewayResponse response = caller.execute(HttpMethodName.POST,
                    "/address",
                    new ByteArrayInputStream(addressEntity.toString().getBytes()));

            return response.toString();
        }
        catch(Exception ex) {
            ex.printStackTrace();
            throw new AddressUploadException(ADDRESS_NOT_SAVED);
        }
    }


    //TODO: Process contacts for the candidate by creating new contacts in contact config service
    private List<String> processContact(List<Contact> contactList) {
        List<String> cIdList = new ArrayList<>();
        for(Contact c : contactList) {
            try {
                cIdList.add(saveContact(c));
            }
            catch(Exception ex) {

            }
        }
        return cIdList;
    }

    private String saveContact(Contact contact) {
        try {
            JsonApiGatewayCaller caller = new JsonApiGatewayCaller(
                    AWS_IAM_ACCESS_KEY,
                    AWS_IAM_SECRET_ACCESS_KEY,
                    null,
                    AWS_REGION,
                    new URI(AWS_API_GATEWAY_ENDPOINT_CONFIG_CONTACT_CREATE)
            );

            ApiGatewayResponse response = caller.execute(HttpMethodName.POST,
                    "/contact",
                    new ByteArrayInputStream(contact.toString().getBytes()));

            return response.toString();
        }
        catch(Exception ex) {
            ex.printStackTrace();
            throw new ContactUploadException(CONTACT_NOT_SAVED);
        }
    }
}