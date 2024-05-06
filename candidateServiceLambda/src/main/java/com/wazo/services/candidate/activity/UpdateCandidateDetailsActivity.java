package com.wazo.services.candidate.activity;

import com.google.gson.Gson;
import com.wazo.models.candidate.Address;
import com.wazo.models.candidate.Contact;
import com.wazo.models.candidate.UpdateCandidateDetailsRequest;
import com.wazo.services.candidate.dao.CandidateDao;
import com.wazo.services.candidate.dao.entity.CandidateEntity;
import com.wazo.services.candidate.model.response.ApiResponse;
import com.wazo.services.candidate.validation.ValidateUpdateCandidateDetailsRequest;
import lombok.AllArgsConstructor;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import static com.wazo.services.candidate.utils.Constants.*;

@AllArgsConstructor(onConstructor = @__(@Inject))
public class UpdateCandidateDetailsActivity {

    private final CandidateDao candidateDao;
    private final ValidateUpdateCandidateDetailsRequest validateUpdateCandidateDetailsRequest;
    private static final Gson gson = new Gson();

    public ApiResponse run(String orgId, String candidateId, String requestBody) {

        UpdateCandidateDetailsRequest updateCandidateDetailsRequest = gson.fromJson(requestBody, UpdateCandidateDetailsRequest.class);

        if (validateUpdateCandidateDetailsRequest.isValid(updateCandidateDetailsRequest)) {
            try {
                CandidateEntity candidateEntity = CandidateEntity.builder()
                        .orgId(orgId)
                        .candidateId(candidateId)
                        .firstName(updateCandidateDetailsRequest.getFirstName())
                        .lastName(updateCandidateDetailsRequest.getLastName())
                        .dateOfBirth(updateCandidateDetailsRequest.getDateOfBirth())
                        .gender(updateCandidateDetailsRequest.getGender())
                        .nationality(updateCandidateDetailsRequest.getNationality())
                        .professionalExperience(updateCandidateDetailsRequest.getProfessionalExperience())
                        .education(updateCandidateDetailsRequest.getEducation())
                        .skillSet(updateCandidateDetailsRequest.getSkillSet())
                        .applicationSource(updateCandidateDetailsRequest.getApplicationSource())
                        .portfolio(updateCandidateDetailsRequest.getPortfolio())
                        .socialMediaProfile(updateCandidateDetailsRequest.getSocialMediaProfile())
                        .professionalReference(updateCandidateDetailsRequest.getProfessionalReference())
                        .eeoDetails_discrimination(updateCandidateDetailsRequest.getEeoDetails_discrimination())
                        .eeoDetails_race(updateCandidateDetailsRequest.getEeoDetails_race())
                        .eeoDetails_ethnicity(updateCandidateDetailsRequest.getEeoDetails_ethnicity())
                        .eeoDetails_gender(updateCandidateDetailsRequest.getEeoDetails_gender())
                        .eeoDetails_age(updateCandidateDetailsRequest.getEeoDetails_age())
                        .eeoDetails_disabilities(updateCandidateDetailsRequest.getEeoDetails_disabilities())
                        .eeoDetails_militaryExperience(updateCandidateDetailsRequest.getEeoDetails_militaryExperience())
                        .eeoDetails_religion(updateCandidateDetailsRequest.getEeoDetails_religion())
                        .eeoDetails_maritalStatus(updateCandidateDetailsRequest.getEeoDetails_maritalStatus())
                        .eeoDetails_sexualOrientation(updateCandidateDetailsRequest.getEeoDetails_sexualOrientation())
                        .eeoDetails_protectedClass(updateCandidateDetailsRequest.getEeoDetails_protectedClass())
                        .customCandidateFields(updateCandidateDetailsRequest.getCustomCandidateFields())
                        .build();

                CandidateEntity updateCandidateEntityObj = candidateDao.updateCandidateDetails(candidateEntity);
                return ApiResponse.builder()
                        .status(200)
                        .message(UPDATE_DETAILS_SUCCESS)
                        .data(updateCandidateEntityObj)
                        .build();

            } catch (Exception e) {
                e.printStackTrace();
                return ApiResponse.builder()
                        .status(400)
                        .data(e.getMessage())
                        .message(ERROR_MESSAGE)
                        .build();
            }
        } else {
            return ApiResponse.builder()
                    .status(403)
                    .message(UPDATE_DETAILS_VALIDATION_ERROR)
                    .errors(validateUpdateCandidateDetailsRequest.getErrors())
                    .build();
        }
    }
}