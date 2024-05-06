package com.wazo.services.candidate.activity;

import com.wazo.services.candidate.dao.CandidateDao;
import com.wazo.services.candidate.model.response.ApiResponse;
import lombok.AllArgsConstructor;

import javax.inject.Inject;

import static com.wazo.services.candidate.utils.Constants.DELETE_SUCCESS;
import static com.wazo.services.candidate.utils.Constants.ERROR_MESSAGE;

@AllArgsConstructor(onConstructor = @__(@Inject))
public class DeleteCandidateActivity {
    private final CandidateDao candidateDao;

    public ApiResponse run(String orgId, String candidateId) {
        if (orgId != null && candidateId != null) {
            candidateDao.deleteCandidateEntity(orgId, candidateId);

            return ApiResponse.builder()
                    .status(203)
                    .message(DELETE_SUCCESS)
                    .build();
        } else {
            return ApiResponse.builder()
                    .status(403)
                    .message(ERROR_MESSAGE)
                    .build();
        }
    }
}