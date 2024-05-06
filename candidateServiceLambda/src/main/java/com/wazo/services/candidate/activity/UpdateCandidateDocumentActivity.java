package com.wazo.services.candidate.activity;

import com.google.gson.Gson;
import com.wazo.models.candidate.UpdateCandidateDocumentRequest;
import com.wazo.services.candidate.dao.CandidateDao;
import com.wazo.services.candidate.dao.entity.CandidateEntity;
import com.wazo.services.candidate.model.response.ApiResponse;
import com.wazo.services.candidate.validation.ValidateUpdateCandidateDocumentRequest;
import lombok.AllArgsConstructor;

import javax.inject.Inject;

import static com.wazo.services.candidate.utils.Constants.*;

@AllArgsConstructor(onConstructor = @__(@Inject))
public class UpdateCandidateDocumentActivity {
    private static final Gson gson = new Gson();
    private final CandidateDao candidateDao;
    private final ValidateUpdateCandidateDocumentRequest validateUpdateCandidateDocumentRequest;

    public ApiResponse run(String orgId, String candidateId, String requestBody) {
        UpdateCandidateDocumentRequest candidateDocumentRequest = gson.fromJson(requestBody, UpdateCandidateDocumentRequest.class);

        if (validateUpdateCandidateDocumentRequest.isValid(candidateDocumentRequest)) {
            try {

                CandidateEntity candidate = CandidateEntity.builder()
                        .orgId(orgId)
                        .candidateId(candidateId)
                        .documentList(candidateDocumentRequest.getDocuments())
                        .build();

                String result = candidateDao.updateCandidateDocuments(candidate);
                return ApiResponse.builder()
                        .status(200)
                        .message(GET_CANDIDATE_BY_ID_SUCCESS)
                        .data(result)
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
                    .message(UPDATE_DOCUMENTS_VALIDATION_ERROR)
                    .errors(validateUpdateCandidateDocumentRequest.getErrors())
                    .build();
        }


    }
}
