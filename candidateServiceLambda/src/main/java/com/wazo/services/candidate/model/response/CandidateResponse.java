package com.wazo.services.candidate.model.response;

import com.wazo.models.candidate.*;
import com.wazo.services.candidate.dao.entity.ContactEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CandidateResponse {
    private String orgId;
    private String candidateId;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String gender;
    private String nationality;
    private List<ContactEntity> contactList;
    private Boolean isPresentSameAsPermanentAddress;
    private List<Address> addressList;
    private ProfessionalExperience professionalExperience;
    private List<Education> education;
    private List<SkillSetDetails> skillSet;
    private List<String> documentList;
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
