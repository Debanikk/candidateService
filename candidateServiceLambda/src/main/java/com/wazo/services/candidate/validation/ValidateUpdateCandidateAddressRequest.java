package com.wazo.services.candidate.validation;

import com.wazo.models.candidate.UpdateCandidateAddressRequest;

import java.util.HashMap;
import java.util.Map;

public class ValidateUpdateCandidateAddressRequest {
    Map<String, String> validationErrors = new HashMap<>();
    public boolean isValid(UpdateCandidateAddressRequest updateCandidateAddressRequest) {
        boolean validFlag = true;

        if (updateCandidateAddressRequest.getIsPresentAddressSameAsPermanent() == null) {
            validFlag = false;
            validationErrors.put("IsPresentAddressSameAsPermanent", "Please make sure that the checkbox for Is Present address same as permanent is checked!");
        }

        if (updateCandidateAddressRequest.getAddressList().size() > 0) {
            validFlag = false;
            validationErrors.put("Address", "At least 1 Address need to be added");
        }

        return validFlag;
    }

    public Map<String, String> getErrors() {
        return validationErrors;
    }
}
