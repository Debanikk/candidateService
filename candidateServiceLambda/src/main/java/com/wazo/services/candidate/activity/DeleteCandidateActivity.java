package com.wazo.services.candidate.activity;

import com.wazo.services.candidate.dao.CandidateDao;
import com.wazo.services.candidate.model.response.ApiResponse;

public class DeleteCandidateActivity {
    private final CandidateDao candidateDao;
    //private final S3Helper s3Helper;

    public DeleteCandidateActivity(CandidateDao candidateDao) {
        this.candidateDao = candidateDao;
        //this.s3Helper = s3Helper;
    }

    public ApiResponse run(String orgId, String candidateId) {
        if (orgId != null && candidateId != null) {
            candidateDao.deleteCandidateEntity(orgId, candidateId);

            return ApiResponse.builder()
                    .status(203)
                    .message("Data delete success!")
                    .build();
        } else {
            return ApiResponse.builder().status(200).message("Pk Sk is required!").build();
        }
    }

}