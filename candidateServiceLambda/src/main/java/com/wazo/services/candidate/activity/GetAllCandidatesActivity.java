package com.wazo.services.candidate.activity;

import com.wazo.services.candidate.dao.CandidateDao;
import com.wazo.services.candidate.dao.entity.CandidateEntity;
import com.wazo.services.candidate.model.response.ApiResponse;
import lombok.AllArgsConstructor;

import javax.inject.Inject;
import java.util.List;

import static com.wazo.services.candidate.utils.Constants.*;

@AllArgsConstructor(onConstructor = @__(@Inject))
public class GetAllCandidatesActivity {

    private final CandidateDao candidateDao;

    public ApiResponse run(String orgId) {
        try {
            List<CandidateEntity> getAllCandidatesEntityObj = candidateDao.getAllCandidatesEntity(orgId);
            return ApiResponse.builder()
                    .status(200)
                    .message(GET_ALL_CANDIDATE_SUCCESS)
                    .data(getAllCandidatesEntityObj)
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