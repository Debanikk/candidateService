package com.wazo.services.candidate.validation;

import com.wazo.models.candidate.UpdateCandidateCommentRequest;

import java.util.HashMap;
import java.util.Map;

public class ValidateUpdateCandidateCommentRequest {
    Map<String, String> validationErrors = new HashMap<>();
    public boolean isValid(UpdateCandidateCommentRequest updateCandidateCommentRequest) {
        boolean validFlag = true;

        /*if (updateCandidateCommentRequest == null) {
            validFlag = false;
            validationErrors.put("Comment", "Please make sure the length of the comment does not exceed 500 characters!");
        }*/

        if (updateCandidateCommentRequest.getCandidateNoticePeriod() == null) {
            validFlag = false;
            validationErrors.put("candidateNoticePeriod", "candidateNoticePeriod is required!");
        }

        if (updateCandidateCommentRequest.getCandidateInterviewAvailability() == null) {
            validFlag = false;
            validationErrors.put("candidateInterviewAvailability", "candidateInterviewAvailability is required!");
        }
        return validFlag;
    }

    public Map<String, String> getErrors() {
        return validationErrors;
    }

}
