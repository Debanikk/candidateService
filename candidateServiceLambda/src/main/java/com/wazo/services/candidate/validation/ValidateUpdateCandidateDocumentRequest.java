package com.wazo.services.candidate.validation;

import com.wazo.models.candidate.UpdateCandidateDocumentRequest;

import java.util.HashMap;
import java.util.Map;

public class ValidateUpdateCandidateDocumentRequest {
    Map<String, String> validationErrors = new HashMap<>();

    public boolean isValid(UpdateCandidateDocumentRequest updateCandidateDocumentRequest) {
        boolean validFlag = true;

        if (updateCandidateDocumentRequest.getDocuments().size() < 1) {
            validFlag = false;
            validationErrors.put("document", "candidate should have at least one document as ID proof!");
        }

        return validFlag;
    }

    public Map<String, String> getErrors() {
        return validationErrors;
    }
}
