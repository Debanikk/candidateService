package com.wazo.services.candidate.validation;

import com.wazo.services.candidate.model.request.UpdateCandidateRequest;

import java.util.HashMap;
import java.util.Map;

public class ValidateUpdateCandidateRequest {
    Map<String, String> validationErrors = new HashMap<>();

    public boolean isValid(UpdateCandidateRequest updatecandidateRequest) {
        boolean validFlag = true;

        if (updatecandidateRequest.getFirstName() == null) {
            validFlag = false;
            validationErrors.put("firstName", "firstName is required field!");
        }

        if (updatecandidateRequest.getLastName() == null) {
            validFlag = false;
            validationErrors.put("lastName", "lastName is required field!");
        }

        if (updatecandidateRequest.getDateOfBirth() == null) {
            validFlag = false;
            validationErrors.put("dateOfBirth", "dateOfBirth is required field!");
        }

        if (updatecandidateRequest.getGender() == null) {
            validFlag = false;
            validationErrors.put("gender", "gender is required field!");
        }

        if (updatecandidateRequest.getNationality() == null) {
            validFlag = false;
            validationErrors.put("nationality", "nationality is required field!");
        }

        if (updatecandidateRequest.getContact() == null) {
            validFlag = false;
            validationErrors.put("contact", "contact is required field!");
        }

        if (updatecandidateRequest.getAddressList() == null) {
            validFlag = false;
            validationErrors.put("AddressList", "At least 1 address is required to be present!");
        }

        if (updatecandidateRequest.getProfessionalExperience() == null) {
            validFlag = false;
            validationErrors.put("professionalExperience", "professionalExperience is required!");
        }

        if (updatecandidateRequest.getEducation() == null) {
            validFlag = false;
            validationErrors.put("education", "education is required!");
        }

        if (updatecandidateRequest.getSkillSet() == null) {
            validFlag = false;
            validationErrors.put("skillSet", "skillSet is required!");
        }

        if (updatecandidateRequest.getDocuments().size() < 1 || updatecandidateRequest.getDocuments() == null) {
            validFlag = false;
            validationErrors.put("document", "At least 1 document/ID proof is needed for Candidate!");
        }

        if (updatecandidateRequest.getApplicationSource() == null) {
            validFlag = false;
            validationErrors.put("applicationSource", "applicationSource is required!");
        }

        if (updatecandidateRequest.getCandidateNoticePeriod() == null) {
            validFlag = false;
            validationErrors.put("candidateNoticePeriod", "candidateNoticePeriod is required!");
        }

        if (updatecandidateRequest.getCandidateInterviewAvailability() == null) {
            validFlag = false;
            validationErrors.put("candidateInterviewAvailability", "candidateInterviewAvailability is required!");
        }

        if (updatecandidateRequest.getPortfolio() == null) {
            validFlag = false;
            validationErrors.put("portfolio", "portfolio is required!");
        }

        if (updatecandidateRequest.getSocialMediaProfile() == null) {
            validFlag = false;
            validationErrors.put("socialMediaProfile", "socialMediaProfile is required!");
        }

        if (updatecandidateRequest.getProfessionalReference() == null) {
            validFlag = false;
            validationErrors.put("professionalReference", "professionalReference is required!");
        }

        if (updatecandidateRequest.getEeoDetails_discrimination() == null) {
            validFlag = false;
            validationErrors.put("eeoDetails_discrimination", "eeoDetails_discrimination is required!");
        }

        if (updatecandidateRequest.getEeoDetails_race() == null) {
            validFlag = false;
            validationErrors.put("eeoDetails_race", "eeoDetails_race is required!");
        }

        if (updatecandidateRequest.getEeoDetails_ethnicity() == null) {
            validFlag = false;
            validationErrors.put("eeoDetails_ethnicity", "eeoDetails_ethnicity is required!");
        }

        if (updatecandidateRequest.getEeoDetails_gender() == null) {
            validFlag = false;
            validationErrors.put("eeoDetails_gender", "eeoDetails_gender is required!");
        }

        if (updatecandidateRequest.getEeoDetails_age() == null) {
            validFlag = false;
            validationErrors.put("eeoDetails_age", "eeoDetails_age is required!");
        }

        if (updatecandidateRequest.getEeoDetails_disabilities() == null) {
            validFlag = false;
            validationErrors.put("eeoDetails_disabilities", "eeoDetails_disabilities is required!");
        }

        if (updatecandidateRequest.getEeoDetails_militaryExperience() == null) {
            validFlag = false;
            validationErrors.put("eeoDetails_militaryExperience", "eeoDetails_militaryExperience is required!");
        }

        if (updatecandidateRequest.getEeoDetails_religion() == null) {
            validFlag = false;
            validationErrors.put("eeoDetails_religion", "eeoDetails_religion is required!");
        }

        if (updatecandidateRequest.getEeoDetails_maritalStatus() == null) {
            validFlag = false;
            validationErrors.put("eeoDetails_maritalStatus", "eeoDetails_maritalStatus is required!");
        }

        if (updatecandidateRequest.getEeoDetails_sexualOrientation() == null) {
            validFlag = false;
            validationErrors.put("eeoDetails_sexualOrientation", "eeoDetails_sexualOrientation is required!");
        }

        if (updatecandidateRequest.getEeoDetails_protectedClass() == null) {
            validFlag = false;
            validationErrors.put("eeoDetails_protectedClass", "eeoDetails_protectedClass is required!");
        }

        return validFlag;
    }

    public Map<String, String> getErrors() {
        return validationErrors;
    }
}