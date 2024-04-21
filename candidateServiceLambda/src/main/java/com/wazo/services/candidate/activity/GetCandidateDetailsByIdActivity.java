package com.wazo.services.candidate.activity;

import com.wazo.services.candidate.dao.CandidateDao;
import com.wazo.services.candidate.dao.entity.CandidateEntity;
import com.wazo.services.candidate.model.response.ApiResponse;
import com.wazo.services.candidate.model.response.CandidateResponse;
import lombok.AllArgsConstructor;

import javax.inject.Inject;

import static com.wazo.services.candidate.utils.Constants.GENERIC_CANDIDATE_ERROR_MESSAGE;
import static com.wazo.services.candidate.utils.Constants.GET_CANDIDATE_BY_ID_SUCCESS;

@AllArgsConstructor(onConstructor = @__(@Inject))
public class GetCandidateDetailsByIdActivity {

    private final CandidateDao candidateDao;

    public ApiResponse run(String orgId, String candidateId) {
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
                    .message(GENERIC_CANDIDATE_ERROR_MESSAGE)
                    .build();
        }
    }
}
