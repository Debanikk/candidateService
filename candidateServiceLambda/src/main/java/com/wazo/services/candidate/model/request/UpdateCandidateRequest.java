package com.wazo.services.candidate.model.request;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UpdateCandidateRequest {
    private List<String> requisitionIdList;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String gender;
    private String nationality;
    private List<Contact> contact; // This will be used for saving in contact service under config
    private Boolean isPresentAddressSameAsPermanent;
    private List<Address> addressList; // This will be used for saving in address service under config
    private ProfessionalExperience professionalExperience;
    private List<Education> education;
    private List<SkillSetDetails> skillSet;
    private List<String> documents;
    private String applicationSource;
    private String candidateNoticePeriod;
    private String candidateInterviewAvailability;
    private List<PortFolio> portfolio;
    private List<SocialMedia> socialMediaProfile;
    private List<ProfessionalReference> professionalReference;
    private String eeoDetails_discrimination;
    private String eeoDetails_race;
    private String eeoDetails_ethnicity;
    private String eeoDetails_gender;
    private String eeoDetails_age;
    private String eeoDetails_disabilities;
    private String eeoDetails_militaryExperience;
    private String eeoDetails_religion;
    private String eeoDetails_maritalStatus;
    private String eeoDetails_sexualOrientation;
    private String eeoDetails_protectedClass;
    private Boolean isUnderProcess;
    private List<CustomCandidateField> customCandidateFields;
}