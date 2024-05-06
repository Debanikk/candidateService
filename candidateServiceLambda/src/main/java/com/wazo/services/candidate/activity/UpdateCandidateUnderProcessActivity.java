package com.wazo.services.candidate.activity;

import com.google.gson.Gson;
import com.wazo.models.candidate.UpdateCandidateUnderProcessRequest;
import com.wazo.services.candidate.dao.CandidateDao;
import com.wazo.services.candidate.dao.entity.CandidateEntity;
import com.wazo.services.candidate.model.response.ApiResponse;
import com.wazo.services.candidate.validation.ValidateUpdateCandidateUnderProcessRequest;
import lombok.AllArgsConstructor;

import javax.inject.Inject;

import static com.wazo.services.candidate.utils.Constants.*;

@AllArgsConstructor(onConstructor = @__(@Inject))
public class UpdateCandidateUnderProcessActivity {

    private final CandidateDao candidateDao;
    private final ValidateUpdateCandidateUnderProcessRequest validateUpdateCandidateUnderProcessRequest;
    private static final Gson gson = new Gson();

    public ApiResponse run(String orgId, String candidateId, String requestBody) {
        UpdateCandidateUnderProcessRequest updateCandidateUnderProcessRequest = gson.fromJson(requestBody, UpdateCandidateUnderProcessRequest.class);

        if (validateUpdateCandidateUnderProcessRequest.isValid(updateCandidateUnderProcessRequest)) {
            try {
                CandidateEntity candidateEntity = CandidateEntity.builder()
                        .orgId(orgId)
                        .candidateId(candidateId)
                        .isUnderProcess(updateCandidateUnderProcessRequest.getIsUnderProcess())
                        .requisitionList(updateCandidateUnderProcessRequest.getRequisitionIdList())
                        .build();

                CandidateEntity updateCandidateEntityObj = candidateDao.updateCandidateUnderProcess(candidateEntity);
                return ApiResponse.builder()
                        .status(200)
                        .message(UPDATE_STATUS_SUCCESS)
                        .data(updateCandidateEntityObj)
                        .build();

            } catch (Exception e) {
                e.printStackTrace();
                return ApiResponse.builder()
                        .status(400)
                        .message(ERROR_MESSAGE)
                        .build();
            }
        } else {
            return ApiResponse.builder()
                    .status(403)
                    .message(UPDATE_STATUS_VALIDATION_ERROR)
                    .errors(validateUpdateCandidateUnderProcessRequest.getErrors())
                    .build();
        }
    }
}
