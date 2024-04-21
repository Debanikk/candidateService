package com.wazo.services.candidate.activity;

import com.wazo.services.candidate.dao.CandidateDao;
import com.wazo.services.candidate.dao.entity.CandidateEntity;
import com.wazo.services.candidate.model.response.ApiResponse;

import static com.wazo.services.candidate.utils.Constants.GENERIC_CANDIDATE_ERROR_MESSAGE;
import static com.wazo.services.candidate.utils.Constants.GET_CANDIDATE_SUCCESS;

public class GetCandidateByIdActivity {

    private final CandidateDao candidateDao;

    public GetCandidateByIdActivity(CandidateDao candidateDao) {
        this.candidateDao = candidateDao;
    }

    public ApiResponse run(String orgId, String candidateId) {
        try {
            CandidateEntity getCandidateByIdEntityObj = candidateDao.getCandidateByIdEntity(orgId, candidateId);
            return ApiResponse.builder()
                    .status(200)
                    .message(GET_CANDIDATE_SUCCESS)
                    .data(getCandidateByIdEntityObj)
                    .build();

        } catch (Exception e) {
            e.printStackTrace();
            return ApiResponse.builder()
                    .status(200)
                    .message(GENERIC_CANDIDATE_ERROR_MESSAGE)
                    .build();
        }
    }
}