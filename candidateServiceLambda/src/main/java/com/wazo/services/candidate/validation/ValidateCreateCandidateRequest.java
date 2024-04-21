package com.wazo.services.candidate.validation;

import com.wazo.services.candidate.model.request.CreateCandidateRequest;

import java.util.HashMap;
import java.util.Map;

public class ValidateCreateCandidateRequest {
    Map<String, String> validationErrors = new HashMap<>();

    public boolean isValid(CreateCandidateRequest createcandidateRequest) {
        boolean validFlag = true;

        if (createcandidateRequest.getFirstName() == null) {
            validFlag = false;
            validationErrors.put("firstName", "firstName is required field!");
        }

        if (createcandidateRequest.getLastName() == null) {
            validFlag = false;
            validationErrors.put("lastName", "lastName is required field!");
        }

        if (createcandidateRequest.getDateOfBirth() == null) {
            validFlag = false;
            validationErrors.put("dateOfBirth", "dateOfBirth is required field!");
        }

        if (createcandidateRequest.getGender() == null) {
            validFlag = false;
            validationErrors.put("gender", "gender is required field!");
        }

        if (createcandidateRequest.getNationality() == null) {
            validFlag = false;
            validationErrors.put("nationality", "nationality is required field!");
        }

        if (createcandidateRequest.getContact() == null) {
            validFlag = false;
            validationErrors.put("contact", "contact is required field!");
        }

        if (createcandidateRequest.getAddressList() == null) {
            validFlag = false;
            validationErrors.put("AddressList", "At least 1 address is required to be present!");
        }

        if (createcandidateRequest.getProfessionalExperience() == null) {
            validFlag = false;
            validationErrors.put("professionalExperience", "professionalExperience is required!");
        }

        if (createcandidateRequest.getEducation() == null) {
            validFlag = false;
            validationErrors.put("education", "education is required!");
        }

        if (createcandidateRequest.getSkillSet() == null) {
            validFlag = false;
            validationErrors.put("skillSet", "skillSet is required!");
        }

        if (createcandidateRequest.getDocuments().size() < 1 || createcandidateRequest.getDocuments() == null) {
            validFlag = false;
            validationErrors.put("document", "At least 1 document/ID proof is needed for Candidate!");
        }

        if (createcandidateRequest.getApplicationSource() == null) {
            validFlag = false;
            validationErrors.put("applicationSource", "applicationSource is required!");
        }

        if (createcandidateRequest.getCandidateNoticePeriod() == null) {
            validFlag = false;
            validationErrors.put("candidateNoticePeriod", "candidateNoticePeriod is required!");
        }

        if (createcandidateRequest.getCandidateInterviewAvailability() == null) {
            validFlag = false;
            validationErrors.put("candidateInterviewAvailability", "candidateInterviewAvailability is required!");
        }

        if (createcandidateRequest.getPortfolio() == null) {
            validFlag = false;
            validationErrors.put("portfolio", "portfolio is required!");
        }

        if (createcandidateRequest.getSocialMediaProfile() == null) {
            validFlag = false;
            validationErrors.put("socialMediaProfile", "socialMediaProfile is required!");
        }

        if (createcandidateRequest.getProfessionalReference() == null) {
            validFlag = false;
            validationErrors.put("professionalReference", "professionalReference is required!");
        }

        if (createcandidateRequest.getEeoDetails_discrimination() == null) {
            validFlag = false;
            validationErrors.put("eeoDetails_discrimination", "eeoDetails_discrimination is required!");
        }

        if (createcandidateRequest.getEeoDetails_race() == null) {
            validFlag = false;
            validationErrors.put("eeoDetails_race", "eeoDetails_race is required!");
        }

        if (createcandidateRequest.getEeoDetails_ethnicity() == null) {
            validFlag = false;
            validationErrors.put("eeoDetails_ethnicity", "eeoDetails_ethnicity is required!");
        }

        if (createcandidateRequest.getEeoDetails_gender() == null) {
            validFlag = false;
            validationErrors.put("eeoDetails_gender", "eeoDetails_gender is required!");
        }

        if (createcandidateRequest.getEeoDetails_age() == null) {
            validFlag = false;
            validationErrors.put("eeoDetails_age", "eeoDetails_age is required!");
        }

        if (createcandidateRequest.getEeoDetails_disabilities() == null) {
            validFlag = false;
            validationErrors.put("eeoDetails_disabilities", "eeoDetails_disabilities is required!");
        }

        if (createcandidateRequest.getEeoDetails_militaryExperience() == null) {
            validFlag = false;
            validationErrors.put("eeoDetails_militaryExperience", "eeoDetails_militaryExperience is required!");
        }

        if (createcandidateRequest.getEeoDetails_religion() == null) {
            validFlag = false;
            validationErrors.put("eeoDetails_religion", "eeoDetails_religion is required!");
        }

        if (createcandidateRequest.getEeoDetails_maritalStatus() == null) {
            validFlag = false;
            validationErrors.put("eeoDetails_maritalStatus", "eeoDetails_maritalStatus is required!");
        }

        if (createcandidateRequest.getEeoDetails_sexualOrientation() == null) {
            validFlag = false;
            validationErrors.put("eeoDetails_sexualOrientation", "eeoDetails_sexualOrientation is required!");
        }

        if (createcandidateRequest.getEeoDetails_protectedClass() == null) {
            validFlag = false;
            validationErrors.put("eeoDetails_protectedClass", "eeoDetails_protectedClass is required!");
        }

        return validFlag;
    }

    public Map<String, String> getErrors() {
        return validationErrors;
    }
}