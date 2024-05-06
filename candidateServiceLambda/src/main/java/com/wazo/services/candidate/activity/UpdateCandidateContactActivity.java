package com.wazo.services.candidate.activity;

import com.google.gson.Gson;
import com.wazo.services.candidate.dao.CandidateDao;
import com.wazo.services.candidate.model.response.ApiResponse;
import com.wazo.services.candidate.model.response.CandidateResponse;
import com.wazo.services.candidate.validation.ValidateUpdateCandidateContactRequest;
import com.wazo.services.candidate.validation.ValidateUpdateCandidateDetailsRequest;
import lombok.AllArgsConstructor;

import javax.inject.Inject;

import static com.wazo.services.candidate.utils.Constants.*;

@AllArgsConstructor(onConstructor = @__(@Inject))
public class UpdateCandidateContactActivity {
    private final CandidateDao candidateDao;
    private final ValidateUpdateCandidateContactRequest validateUpdateCandidateContactRequest;
    private static final Gson gson = new Gson();

    public ApiResponse run(String orgId, String candidateId, String requestBody) {
        try {
            CandidateResponse getCandidateDetailsByIdEntityObj = candidateDao.getCandidateDetailsByIdEntity(orgId, candidateId);
            return ApiResponse.builder()
                    .status(200)
                    .message(GET_CANDIDATE_BY_ID_SUCCESS)
                    .data(getCandidateDetailsByIdEntityObj)
                    .build();

        } catch (Exception e) {
            e.printStackTrace();
            return ApiResponse.builder()
                    .status(400)
                    .message(ERROR_MESSAGE)
                    .build();
        }
    }
}
