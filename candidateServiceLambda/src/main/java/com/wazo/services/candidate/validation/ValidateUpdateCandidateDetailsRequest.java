package com.wazo.services.candidate.validation;

import com.wazo.models.candidate.UpdateCandidateDetailsRequest;

import java.util.HashMap;
import java.util.Map;

public class ValidateUpdateCandidateDetailsRequest {
    Map<String, String> validationErrors = new HashMap<>();

    public boolean isValid(UpdateCandidateDetailsRequest updateCandidateDetailsRequest) {
        boolean validFlag = true;

        if (updateCandidateDetailsRequest.getFirstName() == null) {
            validFlag = false;
            validationErrors.put("firstName", "firstName is required field!");
        }

        if (updateCandidateDetailsRequest.getLastName() == null) {
            validFlag = false;
            validationErrors.put("lastName", "lastName is required field!");
        }

        if (updateCandidateDetailsRequest.getDateOfBirth() == null) {
            validFlag = false;
            validationErrors.put("dateOfBirth", "dateOfBirth is required field!");
        }

        if (updateCandidateDetailsRequest.getGender() == null) {
            validFlag = false;
            validationErrors.put("gender", "gender is required field!");
        }

        if (updateCandidateDetailsRequest.getNationality() == null) {
            validFlag = false;
            validationErrors.put("nationality", "nationality is required field!");
        }

        if (updateCandidateDetailsRequest.getProfessionalExperience() == null) {
            validFlag = false;
            validationErrors.put("professionalExperience", "professionalExperience is required!");
        }

        if (updateCandidateDetailsRequest.getEducation() == null) {
            validFlag = false;
            validationErrors.put("education", "education is required!");
        }

        if (updateCandidateDetailsRequest.getSkillSet() == null) {
            validFlag = false;
            validationErrors.put("skillSet", "skillSet is required!");
        }

        if (updateCandidateDetailsRequest.getApplicationSource() == null) {
            validFlag = false;
            validationErrors.put("applicationSource", "applicationSource is required!");
        }

        if (updateCandidateDetailsRequest.getPortfolio() == null) {
            validFlag = false;
            validationErrors.put("portfolio", "portfolio is required!");
        }

        if (updateCandidateDetailsRequest.getSocialMediaProfile() == null) {
            validFlag = false;
            validationErrors.put("socialMediaProfile", "socialMediaProfile is required!");
        }

        if (updateCandidateDetailsRequest.getProfessionalReference() == null) {
            validFlag = false;
            validationErrors.put("professionalReference", "professionalReference is required!");
        }

        if (updateCandidateDetailsRequest.getEeoDetails_discrimination() == null) {
            validFlag = false;
            validationErrors.put("eeoDetails_discrimination", "eeoDetails_discrimination is required!");
        }

        if (updateCandidateDetailsRequest.getEeoDetails_race() == null) {
            validFlag = false;
            validationErrors.put("eeoDetails_race", "eeoDetails_race is required!");
        }

        if (updateCandidateDetailsRequest.getEeoDetails_ethnicity() == null) {
            validFlag = false;
            validationErrors.put("eeoDetails_ethnicity", "eeoDetails_ethnicity is required!");
        }

        if (updateCandidateDetailsRequest.getEeoDetails_gender() == null) {
            validFlag = false;
            validationErrors.put("eeoDetails_gender", "eeoDetails_gender is required!");
        }

        if (updateCandidateDetailsRequest.getEeoDetails_age() == null) {
            validFlag = false;
            validationErrors.put("eeoDetails_age", "eeoDetails_age is required!");
        }

        if (updateCandidateDetailsRequest.getEeoDetails_disabilities() == null) {
            validFlag = false;
            validationErrors.put("eeoDetails_disabilities", "eeoDetails_disabilities is required!");
        }

        if (updateCandidateDetailsRequest.getEeoDetails_militaryExperience() == null) {
            validFlag = false;
            validationErrors.put("eeoDetails_militaryExperience", "eeoDetails_militaryExperience is required!");
        }

        if (updateCandidateDetailsRequest.getEeoDetails_religion() == null) {
            validFlag = false;
            validationErrors.put("eeoDetails_religion", "eeoDetails_religion is required!");
        }

        if (updateCandidateDetailsRequest.getEeoDetails_maritalStatus() == null) {
            validFlag = false;
            validationErrors.put("eeoDetails_maritalStatus", "eeoDetails_maritalStatus is required!");
        }

        if (updateCandidateDetailsRequest.getEeoDetails_sexualOrientation() == null) {
            validFlag = false;
            validationErrors.put("eeoDetails_sexualOrientation", "eeoDetails_sexualOrientation is required!");
        }

        if (updateCandidateDetailsRequest.getEeoDetails_protectedClass() == null) {
            validFlag = false;
            validationErrors.put("eeoDetails_protectedClass", "eeoDetails_protectedClass is required!");
        }

        return validFlag;
    }

    public Map<String, String> getErrors() {
        return validationErrors;
    }
}