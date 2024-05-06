package com.wazo.services.candidate.activity;

import com.google.gson.Gson;
import com.wazo.models.candidate.UpdateCandidateAddressRequest;
import com.wazo.services.candidate.dao.CandidateDao;
import com.wazo.services.candidate.model.response.ApiResponse;
import com.wazo.services.candidate.model.response.CandidateResponse;
import com.wazo.services.candidate.validation.ValidateUpdateCandidateAddressRequest;
import lombok.AllArgsConstructor;

import javax.inject.Inject;

import static com.wazo.services.candidate.utils.Constants.*;

@AllArgsConstructor(onConstructor = @__(@Inject))
public class UpdateCandidateAddressActivity {
    private static final Gson gson = new Gson();
    private final CandidateDao candidateDao;
    private final ValidateUpdateCandidateAddressRequest validateUpdateCandidateAddressRequest;

    public ApiResponse run(String orgId, String candidateId, String requestBody) {
        UpdateCandidateAddressRequest updateCandidateAddressRequest = gson.fromJson(requestBody, UpdateCandidateAddressRequest.class);
        if (validateUpdateCandidateAddressRequest.isValid(updateCandidateAddressRequest)) {
            try {
                CandidateResponse getCandidateDetailsByIdEntityObj = candidateDao.getCandidateDetailsByIdEntity(orgId, candidateId);
                return ApiResponse.builder().status(200).message(GET_CANDIDATE_BY_ID_SUCCESS).data(getCandidateDetailsByIdEntityObj).build();

            } catch (Exception e) {
                e.printStackTrace();
                return ApiResponse.builder().status(400).message(ERROR_MESSAGE).build();
            }
        } else {
            return ApiResponse.builder().status(403).message(UPDATE_DETAILS_VALIDATION_ERROR).errors(validateUpdateCandidateAddressRequest.getErrors()).build();
        }
    }
}
