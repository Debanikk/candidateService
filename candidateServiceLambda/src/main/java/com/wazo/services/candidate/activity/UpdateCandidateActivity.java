package com.wazo.services.candidate.activity;

import com.google.gson.Gson;
import com.wazo.services.candidate.dao.CandidateDao;
import com.wazo.services.candidate.dao.entity.CandidateEntity;
import com.wazo.services.candidate.model.request.Address;
import com.wazo.services.candidate.model.request.Contact;
import com.wazo.services.candidate.model.request.UpdateCandidateRequest;
import com.wazo.services.candidate.model.response.ApiResponse;
import com.wazo.services.candidate.validation.ValidateUpdateCandidateRequest;
import lombok.AllArgsConstructor;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import static com.wazo.services.candidate.utils.Constants.GENERIC_CANDIDATE_ERROR_MESSAGE;
import static com.wazo.services.candidate.utils.Constants.UPDATE_CANDIDATE_SUCCESS;

@AllArgsConstructor(onConstructor = @__(@Inject))
public class UpdateCandidateActivity {

    private final CandidateDao candidateDao;
    private final ValidateUpdateCandidateRequest validateUpdateCandidateRequest;
    private static final Gson gson = new Gson();

    public ApiResponse run(String orgId, String candidateId, String requestBody) {

        UpdateCandidateRequest updateCandidateRequest = gson.fromJson(requestBody, UpdateCandidateRequest.class);

        if (validateUpdateCandidateRequest.isValid(updateCandidateRequest)) {
            try {

                CandidateEntity candidateEntity = CandidateEntity.builder()
                        .orgId(orgId)
                        .candidateId(candidateId)
                        .firstName(updateCandidateRequest.getFirstName())
                        .lastName(updateCandidateRequest.getLastName())
                        .dateOfBirth(updateCandidateRequest.getDateOfBirth())
                        .gender(updateCandidateRequest.getGender())
                        .nationality(updateCandidateRequest.getNationality())
                        .contactList(getContactList(updateCandidateRequest.getContact()))
                        .isPresentSameAsPermanentAddress(updateCandidateRequest.getIsPresentAddressSameAsPermanent())
                        .addressList(getAddressList(updateCandidateRequest.getAddressList()))
                        .professionalExperience(updateCandidateRequest.getProfessionalExperience())
                        .education(updateCandidateRequest.getEducation())
                        .skillSet(updateCandidateRequest.getSkillSet())
                        .documentList(updateCandidateRequest.getDocuments())
                        .applicationSource(updateCandidateRequest.getApplicationSource())
                        .candidateNoticePeriod(updateCandidateRequest.getCandidateNoticePeriod())
                        .candidateInterviewAvailability(updateCandidateRequest.getCandidateInterviewAvailability())
                        .portfolio(updateCandidateRequest.getPortfolio())
                        .socialMediaProfile(updateCandidateRequest.getSocialMediaProfile())
                        .professionalReference(updateCandidateRequest.getProfessionalReference())
                        .eeoDetails_discrimination(updateCandidateRequest.getEeoDetails_discrimination())
                        .eeoDetails_race(updateCandidateRequest.getEeoDetails_race())
                        .eeoDetails_ethnicity(updateCandidateRequest.getEeoDetails_ethnicity())
                        .eeoDetails_gender(updateCandidateRequest.getEeoDetails_gender())
                        .eeoDetails_age(updateCandidateRequest.getEeoDetails_age())
                        .eeoDetails_disabilities(updateCandidateRequest.getEeoDetails_disabilities())
                        .eeoDetails_militaryExperience(updateCandidateRequest.getEeoDetails_militaryExperience())
                        .eeoDetails_religion(updateCandidateRequest.getEeoDetails_religion())
                        .eeoDetails_maritalStatus(updateCandidateRequest.getEeoDetails_maritalStatus())
                        .eeoDetails_sexualOrientation(updateCandidateRequest.getEeoDetails_sexualOrientation())
                        .eeoDetails_protectedClass(updateCandidateRequest.getEeoDetails_protectedClass())
                        .isUnderProcess(updateCandidateRequest.getIsUnderProcess())
                        .customCandidateFields(updateCandidateRequest.getCustomCandidateFields())
                        .build();

                CandidateEntity updateCandidateEntityObj = candidateDao.saveCandidateEntity(candidateEntity);
                return ApiResponse.builder()
                        .status(200)
                        .message(UPDATE_CANDIDATE_SUCCESS)
                        .data(updateCandidateEntityObj)
                        .build();

            } catch (Exception e) {
                e.printStackTrace();
                return ApiResponse.builder()
                        .status(400)
                        .message(GENERIC_CANDIDATE_ERROR_MESSAGE)
                        .build();
            }
        } else {
            return ApiResponse.builder()
                    .status(200)
                    .message("Invalid request data!")
                    .errors(validateUpdateCandidateRequest.getErrors())
                    .build();
        }
    }

    private List<String> getContactList(List<Contact> contacts) {
        List<String> result = new ArrayList<>();

        return result;
    }

    private List<String> getAddressList(List<Address> AddressList) {
        List<String> result = new ArrayList<>();

        return result;
    }
}