package com.wazo.services.candidate.activity;

import com.wazo.services.candidate.dao.CandidateDao;
import com.wazo.services.candidate.dao.entity.CandidateEntity;
import com.wazo.services.candidate.model.response.ApiResponse;
import lombok.AllArgsConstructor;

import javax.inject.Inject;

import static com.wazo.services.candidate.utils.Constants.*;

@AllArgsConstructor(onConstructor = @__(@Inject))
public class GetCandidateByIdActivity {

    private final CandidateDao candidateDao;

    public ApiResponse run(String orgId, String candidateId) {
        try {
            CandidateEntity getCandidateByIdEntityObj = candidateDao.getCandidateByIdEntity(orgId, candidateId);
            return ApiResponse.builder()
                    .status(200)
                    .message(GET_SUCCESS)
                    .data(getCandidateByIdEntityObj)
                    .build();

        } catch (Exception e) {
            e.printStackTrace();
            return ApiResponse.builder()
                    .status(200)
                    .message(ERROR_MESSAGE)
                    .build();
        }
    }
}