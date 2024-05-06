package com.wazo.services.candidate.validation;

import com.wazo.models.candidate.UpdateCandidateUnderProcessRequest;

import java.util.HashMap;
import java.util.Map;

public class ValidateUpdateCandidateUnderProcessRequest {
    Map<String, String> validationErrors = new HashMap<>();

    public boolean isValid(UpdateCandidateUnderProcessRequest updateCandidateUnderProcessRequest) {
        boolean validFlag = true;

        if (updateCandidateUnderProcessRequest.getIsUnderProcess() == null) {
            validFlag = false;
            validationErrors.put("isUnderProcess", "isUnderProcess is required field!");
        }

        return validFlag;
    }

    public Map<String, String> getErrors() {
        return validationErrors;
    }
}
