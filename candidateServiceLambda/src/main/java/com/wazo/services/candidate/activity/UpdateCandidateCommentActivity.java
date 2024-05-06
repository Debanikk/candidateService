package com.wazo.services.candidate.activity;

import com.google.gson.Gson;
import com.wazo.models.candidate.UpdateCandidateCommentRequest;
import com.wazo.services.candidate.dao.CandidateDao;
import com.wazo.services.candidate.dao.entity.CandidateEntity;
import com.wazo.services.candidate.model.response.ApiResponse;
import com.wazo.services.candidate.validation.ValidateUpdateCandidateCommentRequest;
import lombok.AllArgsConstructor;

import javax.inject.Inject;

import static com.wazo.services.candidate.utils.Constants.*;

@AllArgsConstructor(onConstructor = @__(@Inject))
public class UpdateCandidateCommentActivity {
    private final CandidateDao candidateDao;
    private final ValidateUpdateCandidateCommentRequest validateUpdateCandidateCommentRequest;
    private static final Gson gson = new Gson();

    public ApiResponse run(String orgId, String candidateId, String requestBody) {
        try {
            UpdateCandidateCommentRequest updateCandidateCommentRequest = gson.fromJson(requestBody, UpdateCandidateCommentRequest.class);
            if (validateUpdateCandidateCommentRequest.isValid(updateCandidateCommentRequest)) {

                CandidateEntity candidateEntity = CandidateEntity.builder()
                        .orgId(orgId)
                        .candidateId(candidateId)
                        .comments(updateCandidateCommentRequest.getRemarks())
                        .candidateNoticePeriod(updateCandidateCommentRequest.getCandidateNoticePeriod())
                        .candidateInterviewAvailability(updateCandidateCommentRequest.getCandidateInterviewAvailability())
                        .build();

                String candidateRemarkResponse = candidateDao.updateCandidateComments(candidateEntity);
                return ApiResponse.builder()
                        .status(200)
                        .message(UPDATE_REMARKS_SUCCESS)
                        .data(candidateRemarkResponse)
                        .build();
            }
            else {
                return ApiResponse.builder()
                        .status(403)
                        .message(UPDATE_REMARKS_VALIDATION_ERROR)
                        .errors(validateUpdateCandidateCommentRequest.getErrors())
                        .build();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ApiResponse.builder()
                    .status(400)
                    .message(ERROR_MESSAGE)
                    .build();
        }

    }
}
