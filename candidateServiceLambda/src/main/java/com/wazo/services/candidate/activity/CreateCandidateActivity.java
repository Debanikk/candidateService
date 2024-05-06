package com.wazo.services.candidate.activity;

import com.google.gson.Gson;
import com.wazo.models.candidate.Address;
import com.wazo.models.candidate.Contact;
import com.wazo.models.candidate.CreateCandidateRequest;
import com.wazo.services.candidate.Exceptions.type.AddressUploadException;
import com.wazo.services.candidate.Exceptions.type.ContactUploadException;
import com.wazo.services.candidate.dao.CandidateDao;
import com.wazo.services.candidate.dao.entity.CandidateEntity;
import com.wazo.services.candidate.handler.CandidateLambdaMainHandler;
import com.wazo.services.candidate.model.response.ApiResponse;
import com.wazo.services.candidate.validation.ValidateCreateCandidateRequest;
import lombok.AllArgsConstructor;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.wazo.services.candidate.Exceptions.type.ErrorCode.ADDRESS_NOT_SAVED;
import static com.wazo.services.candidate.Exceptions.type.ErrorCode.CONTACT_NOT_CREATED;
import static com.wazo.services.candidate.utils.Constants.*;

@AllArgsConstructor(onConstructor = @__(@Inject))
public class CreateCandidateActivity {
    private static final Gson gson = new Gson();
    private final CandidateDao candidateDao;
    private final ValidateCreateCandidateRequest validateCreateCandidateRequest;
    private static final Logger log = LoggerFactory.getLogger(CandidateLambdaMainHandler.class);

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
                        //.contactList(processContact(createcandidateRequest.getContact(), partitionKey))
                        //.isPresentSameAsPermanentAddress(createcandidateRequest.getIsPresentAddressSameAsPermanent())
                        //.addressList(ProcessCandidateAddress(createcandidateRequest.getAddressList(), partitionKey))
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
                        .comments(createcandidateRequest.getComments())
                        .build();

                CandidateEntity createCandidateEntityObj = candidateDao.saveCandidateEntity(candidateEntity);
                return ApiResponse.builder().status(201).message(CREATE_CANDIDATE_SUCCESS).data(createCandidateEntityObj).build();

            } catch (Exception e) {
                e.printStackTrace();
                return ApiResponse.builder().status(500).message(CREATE_CANDIDATE_ERROR).build();
            }
        } else {
            return ApiResponse.builder().status(HttpStatus.SC_FORBIDDEN).message(CREATE_CANDIDATE_VALIDATION_ERROR).errors(validateCreateCandidateRequest.getErrors()).build();
        }
    }

    private List<String> ProcessCandidateAddress(List<Address> addressList, String orgId) {
        List<String> addressIdList = new ArrayList<>();

        for (Address addr : addressList) {
            addressIdList.add(saveAddress(addr, orgId));
        }
        return addressIdList;
    }

    private String saveAddress(Address address, String orgId) {
        String result = "";
        try {
            result = candidateDao.createAddressToConfigServer(address, orgId);
        } catch (Exception ex) {
            throw new AddressUploadException(ADDRESS_NOT_SAVED);
        }
        return result;
    }

    private List<String> processContact(List<Contact> contactList, String orgId) {
        List<String> cIdList = new ArrayList<>();
        for (Contact c : contactList) {

            cIdList.add(saveContact(c, orgId));

        }
        return cIdList;
    }

    private String saveContact(Contact contact, String orgId) {
        String result = "";
        try {
            result = candidateDao.createContactToConfigServer(contact, orgId);
        } catch (Exception ex) {
            throw new ContactUploadException(CONTACT_NOT_CREATED);
        }
        return result;
    }
}