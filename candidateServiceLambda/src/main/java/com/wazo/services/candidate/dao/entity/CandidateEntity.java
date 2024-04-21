
package com.wazo.services.candidate.dao.entity;

import com.wazo.services.candidate.dao.converter.CandidateConverterProvider;
import com.wazo.services.candidate.model.request.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.DefaultAttributeConverterProvider;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamoDbBean(converterProviders = {CandidateConverterProvider.class, DefaultAttributeConverterProvider.class})
public class CandidateEntity {
    private String orgId;
    private String candidateId;
    private List<String> requisitionList;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String gender;
    private String nationality;
    private List<String> contactList;
    private Boolean isPresentSameAsPermanentAddress;
    private List<String> addressList;
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

    @DynamoDbPartitionKey
    public String getOrgId() {
        return orgId;
    }


    @DynamoDbSortKey
    public String getCandidateId() {
        return candidateId;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "orgId=" + orgId + '\'' +
                ", candidateId='" + candidateId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", nationality=" + nationality +
                ", isUnderProcess=" + isUnderProcess +
                '}';
    }
}