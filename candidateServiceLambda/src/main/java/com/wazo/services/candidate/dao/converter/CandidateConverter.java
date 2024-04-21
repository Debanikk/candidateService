package com.wazo.services.candidate.dao.converter;

import com.wazo.services.candidate.dao.entity.CandidateEntity;
import com.wazo.services.candidate.model.request.*;
import software.amazon.awssdk.enhanced.dynamodb.AttributeConverter;
import software.amazon.awssdk.enhanced.dynamodb.AttributeValueType;
import software.amazon.awssdk.enhanced.dynamodb.EnhancedType;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CandidateConverter implements AttributeConverter<CandidateEntity> {
    @Override
    public AttributeValue transformFrom(CandidateEntity candidateEntity) {
        Map<String, AttributeValue> avm = new HashMap<>();
        avm.put("firstName", AttributeValue.fromS(candidateEntity.getFirstName()));
        avm.put("lastName", AttributeValue.fromS(candidateEntity.getLastName()));
        avm.put("dateOfBirth", AttributeValue.fromS(candidateEntity.getDateOfBirth()));
        avm.put("gender", AttributeValue.fromS(candidateEntity.getGender()));
        avm.put("nationality", AttributeValue.fromS(candidateEntity.getNationality()));
        avm.put("orgId", AttributeValue.fromS(candidateEntity.getOrgId()));
        avm.put("candidateId", AttributeValue.fromS(candidateEntity.getCandidateId()));
        avm.put("requisitionList", AttributeValue.fromNs(candidateEntity.getRequisitionList()));
        avm.put("contactList", AttributeValue.fromNs(candidateEntity.getContactList()));
        avm.put("isPresentSameAsPermanentAddress", AttributeValue.fromNul(candidateEntity.getIsPresentSameAsPermanentAddress()));
        avm.put("addressList", AttributeValue.fromNs(candidateEntity.getAddressList()));
        avm.put("professionalExperience", AttributeValue.fromM(convertProfessionalExperience(candidateEntity.getProfessionalExperience())));
        avm.put("education", AttributeValue.fromL(convertEducation(candidateEntity.getEducation())));
        avm.put("skillSet", AttributeValue.fromL(convertSkillSetDetails(candidateEntity.getSkillSet())));
        avm.put("documentList", AttributeValue.fromSs(candidateEntity.getDocumentList()));
        avm.put("applicationSource", AttributeValue.fromS(candidateEntity.getApplicationSource()));
        avm.put("candidateNoticePeriod", AttributeValue.fromS(candidateEntity.getCandidateNoticePeriod()));
        avm.put("candidateInterviewAvailability", AttributeValue.fromS(candidateEntity.getCandidateNoticePeriod()));
        avm.put("eeoDetails_discrimination", AttributeValue.fromS(candidateEntity.getCandidateNoticePeriod()));
        avm.put("eeoDetails_race", AttributeValue.fromS(candidateEntity.getCandidateNoticePeriod()));
        avm.put("eeoDetails_ethnicity", AttributeValue.fromS(candidateEntity.getCandidateNoticePeriod()));
        avm.put("eeoDetails_gender", AttributeValue.fromS(candidateEntity.getCandidateNoticePeriod()));
        avm.put("eeoDetails_age", AttributeValue.fromS(candidateEntity.getCandidateNoticePeriod()));
        avm.put("eeoDetails_disabilities", AttributeValue.fromS(candidateEntity.getCandidateNoticePeriod()));
        avm.put("eeoDetails_militaryExperience", AttributeValue.fromS(candidateEntity.getCandidateNoticePeriod()));
        avm.put("eeoDetails_religion", AttributeValue.fromS(candidateEntity.getCandidateNoticePeriod()));
        avm.put("eeoDetails_maritalStatus", AttributeValue.fromS(candidateEntity.getCandidateNoticePeriod()));
        avm.put("eeoDetails_sexualOrientation", AttributeValue.fromS(candidateEntity.getCandidateNoticePeriod()));
        avm.put("eeoDetails_protectedClass", AttributeValue.fromS(candidateEntity.getCandidateNoticePeriod()));
        avm.put("isUnderProcess", AttributeValue.fromBool(candidateEntity.getIsUnderProcess()));

        avm.put("portfolio", AttributeValue.fromL(convertPortfolio(candidateEntity.getPortfolio())));
        avm.put("SocialMedia", AttributeValue.fromL(convertSocialMediaProfile(candidateEntity.getSocialMediaProfile())));
        avm.put("ProfessionalReference", AttributeValue.fromL(convertProfessionalReference(candidateEntity.getProfessionalReference())));
        avm.put("CustomCandidateField", AttributeValue.fromL(convertCustomCandidateField(candidateEntity.getCustomCandidateFields())));
        return AttributeValue.fromM(avm);
    }

    @Override
    public CandidateEntity transformTo(AttributeValue attributeValue) {
        Map<String, AttributeValue> avm = attributeValue.m();
        CandidateEntity candidate = new CandidateEntity();
        candidate.setOrgId(avm.get("orgId").s());
        candidate.setCandidateId(avm.get("candidateId").s());
        candidate.setRequisitionList(avm.get("requisitionList").ss());
        candidate.setFirstName(avm.get("firstName").s());
        candidate.setLastName(avm.get("lastName").s());
        candidate.setDateOfBirth(avm.get("dateOfBirth").s());
        candidate.setGender(avm.get("gender").s());
        candidate.setNationality(avm.get("nationality").s());
        candidate.setContactList(avm.get("contactList").ss());
        candidate.setIsPresentSameAsPermanentAddress(avm.get("isPresentSameAsPermanentAddress").bool());
        candidate.setAddressList(avm.get("addressList").ss());
        candidate.setProfessionalExperience(revertToProfessionalExperience(avm.get("professionalExperience").m()));
        candidate.setEducation(revertEducation(avm.get("education").l()));
        candidate.setSkillSet(revertSkillSetDetails(avm.get("skillSet").l()));
        candidate.setDocumentList(avm.get("documentList").ss());
        candidate.setApplicationSource(avm.get("applicationSource").s());
        candidate.setCandidateNoticePeriod(avm.get("candidateNoticePeriod").s());
        candidate.setCandidateInterviewAvailability(avm.get("candidateInterviewAvailability").s());
        candidate.setPortfolio(revertPortfolio(avm.get("portfolio").l()));
        candidate.setSocialMediaProfile(revertSocialMedia(avm.get("socialMediaProfile").l()));
        candidate.setProfessionalReference(revertProfessionalReference(avm.get("professionalReference").l()));
        candidate.setEeoDetails_discrimination(avm.get("eeoDetails_discrimination").s());
        candidate.setEeoDetails_race(avm.get("eeoDetails_race").s());
        candidate.setEeoDetails_ethnicity(avm.get("eeoDetails_ethnicity").s());
        candidate.setEeoDetails_gender(avm.get("eeoDetails_gender").s());
        candidate.setEeoDetails_age(avm.get("eeoDetails_age").s());
        candidate.setEeoDetails_disabilities(avm.get("eeoDetails_disabilities").s());
        candidate.setEeoDetails_militaryExperience(avm.get("eeoDetails_militaryExperience").s());
        candidate.setEeoDetails_religion(avm.get("eeoDetails_religion").s());
        candidate.setEeoDetails_maritalStatus(avm.get("eeoDetails_maritalStatus").s());
        candidate.setEeoDetails_sexualOrientation(avm.get("eeoDetails_sexualOrientation").s());
        candidate.setEeoDetails_protectedClass(avm.get("eeoDetails_protectedClass").s());
        candidate.setIsUnderProcess(avm.get("isUnderProcess").bool());
        candidate.setCustomCandidateFields(revertCustomCandidateField(avm.get("customCandidateFields").l()));
        return null;
    }

    @Override
    public EnhancedType<CandidateEntity> type() {
        return EnhancedType.of(CandidateEntity.class);
    }

    @Override
    public AttributeValueType attributeValueType() {
        return AttributeValueType.M;
    }

    private List<AttributeValue> convertCertificates(List<Certificate> certificateList) {
        List<AttributeValue> attributeValues = new ArrayList<>();
        for (Certificate cert : certificateList) {
            Map<String, AttributeValue> avm = new HashMap<>();
            avm.put("certificateId", AttributeValue.fromS(cert.getCertificateId()));
            avm.put("certificateName", AttributeValue.fromS(cert.getCertificateName()));
            avm.put("certificateIssuer", AttributeValue.fromS(cert.getCertificateIssuer()));
            avm.put("yearObtained", AttributeValue.fromS(cert.getYearObtained()));
            attributeValues.add(AttributeValue.fromM(avm));
        }
        return attributeValues;
    }

    private List<AttributeValue> convertPastExperience(List<PastProfessionalExperience> pastExperienceList) {
        List<AttributeValue> attributeValues = new ArrayList<>();
        for(PastProfessionalExperience pastProfessionalExperience : pastExperienceList) {
            Map<String, AttributeValue> avm = new HashMap<>();
            avm.put("jobTitle", AttributeValue.fromS(pastProfessionalExperience.getJobTitle()));
            avm.put("employer", AttributeValue.fromS(pastProfessionalExperience.getEmployer()));
            avm.put("duration", AttributeValue.fromS(pastProfessionalExperience.getDuration()));
            avm.put("fromDate", AttributeValue.fromS(pastProfessionalExperience.getFromDate()));
            avm.put("toDate", AttributeValue.fromS(pastProfessionalExperience.getToDate()));
            attributeValues.add(AttributeValue.fromM(avm));
        }
        return attributeValues;
    }

    private Map<String, AttributeValue> convertProfessionalExperience(ProfessionalExperience experience) {
        Map<String, AttributeValue> avm = new HashMap<>();
        avm.put("currentOrganization", AttributeValue.fromS(experience.getCurrentOrganization()));
        avm.put("currentPosition", AttributeValue.fromS(experience.getCurrentPosition()));
        avm.put("fromDate", AttributeValue.fromS(experience.getFromDate()));
        avm.put("pastExperience", AttributeValue.fromL(convertPastExperience(experience.getPastExperience())));
        avm.put("certificates", AttributeValue.fromL(convertCertificates(experience.getCertificates())));
        return avm;
    }

    private List<AttributeValue> convertEducation(List<Education> educationList) {
        List<AttributeValue> attributeValues = new ArrayList<>();
        for(Education education : educationList) {
            Map<String, AttributeValue> avm = new HashMap<>();
            avm.put("nameOfInstitute", AttributeValue.fromS(education.getNameOfInstitute()));
            avm.put("nameOfUniversityBoard", AttributeValue.fromS(education.getNameOfUniversityBoard()));
            avm.put("fromYear", AttributeValue.fromS(education.getFromYear()));
            avm.put("toYear", AttributeValue.fromS(education.getToYear()));
            avm.put("cgpa", AttributeValue.fromS(education.getCgpa()));
            avm.put("isHighestEducation", AttributeValue.fromNul(education.getIsHighestEducation()));
            attributeValues.add(AttributeValue.fromM(avm));
        }
        return attributeValues;
    }

    private List<AttributeValue> convertSkillDetail(List<SkillDetail> skillDetailList) {
        List<AttributeValue> attributeValues = new ArrayList<>();
        for(SkillDetail sd : skillDetailList) {
            Map<String, AttributeValue> avm = new HashMap<>();
            avm.put("skillName", AttributeValue.fromS(sd.getSkillName()));
            avm.put("expInYears", AttributeValue.fromS(sd.getExpInYears()));
            attributeValues.add(AttributeValue.fromM(avm));
        }
        return attributeValues;
    }

    private List<AttributeValue> convertSkillSetDetails(List<SkillSetDetails> skillSetDetailsList) {
        List<AttributeValue> attributeValues = new ArrayList<>();
        for(SkillSetDetails ssd : skillSetDetailsList) {
            Map<String, AttributeValue> avm = new HashMap<>();
            avm.put("skillType", AttributeValue.fromS(ssd.getSkillType()));
            avm.put("skillDetailList", AttributeValue.fromL(convertSkillDetail(ssd.getSkillDetailList())));
            attributeValues.add(AttributeValue.fromM(avm));
        }
        return attributeValues;
    }

    private List<AttributeValue> convertPortfolio(List<PortFolio> portFolioList) {
        List<AttributeValue> attributeValues = new ArrayList<>();
        for(PortFolio pf : portFolioList) {
            Map<String, AttributeValue> avm = new HashMap<>();
            avm.put("portFolioDescription", AttributeValue.fromS(pf.getPortFolioDescription()));
            avm.put("portfolioLink", AttributeValue.fromS(pf.getPortfolioLink()));
            attributeValues.add(AttributeValue.fromM(avm));
        }
        return attributeValues;
    }

    private List<AttributeValue> convertSocialMediaProfile(List<SocialMedia> socialMediaList) {
        List<AttributeValue> attributeValues = new ArrayList<>();
        for(SocialMedia sm : socialMediaList) {
            Map<String, AttributeValue> avm = new HashMap<>();
            avm.put("socialMediaName", AttributeValue.fromS(sm.getSocialMediaName()));
            avm.put("link", AttributeValue.fromS(sm.getLink()));
            attributeValues.add(AttributeValue.fromM(avm));
        }
        return attributeValues;
    }

    private List<AttributeValue> convertProfessionalReference(List<ProfessionalReference> professionalReferences) {
        List<AttributeValue> attributeValues = new ArrayList<>();
        for(ProfessionalReference sm : professionalReferences) {
            Map<String, AttributeValue> avm = new HashMap<>();
            avm.put("referenceName", AttributeValue.fromS(sm.getReferenceName()));
            avm.put("phone", AttributeValue.fromS(sm.getPhone()));
            avm.put("email", AttributeValue.fromS(sm.getEmail()));
            avm.put("company", AttributeValue.fromS(sm.getCompany()));
            avm.put("relation", AttributeValue.fromS(sm.getRelation()));
            attributeValues.add(AttributeValue.fromM(avm));
        }
        return attributeValues;
    }

    private List<AttributeValue> convertCustomCandidateField(List<CustomCandidateField> customCandidateFields) {
        List<AttributeValue> attributeValues = new ArrayList<>();
        for(CustomCandidateField customCandidateField : customCandidateFields) {
            Map<String, AttributeValue> avm = new HashMap<>();
            avm.put("attributeName", AttributeValue.fromS(customCandidateField.getAttributeName()));
            avm.put("attributeValue", AttributeValue.fromS(customCandidateField.getAttributeValue()));
            avm.put("attributeType", AttributeValue.fromS(customCandidateField.getAttributeType()));
            attributeValues.add(AttributeValue.fromM(avm));
        }
        return attributeValues;
    }


    private ProfessionalExperience revertToProfessionalExperience(Map<String, AttributeValue> experience) {
        ProfessionalExperience profExp = new ProfessionalExperience();
        profExp.setCurrentOrganization(experience.get("currentOrganization").s());
        profExp.setCurrentPosition(experience.get("currentPosition").s());
        profExp.setFromDate(experience.get("fromDate").s());
        profExp.setPastExperience(revertPastProfessionalExperience(experience.get("pastExperience").l()));
        profExp.setCertificates(revertCertificate(experience.get("Certificate").l()));
        return profExp;
    }

    private List<PastProfessionalExperience> revertPastProfessionalExperience(List<AttributeValue> pastExpList) {
        List<PastProfessionalExperience> resultList = new ArrayList<>();
        for(AttributeValue attVal : pastExpList) {
            Map<String, AttributeValue> atValMap = attVal.m();
            PastProfessionalExperience pastExp = new PastProfessionalExperience();
            pastExp.setJobTitle(atValMap.get("jobTitle").s());
            pastExp.setEmployer(atValMap.get("employer").s());
            pastExp.setDuration(atValMap.get("duration").s());
            pastExp.setFromDate(atValMap.get("fromDate").s());
            pastExp.setToDate(atValMap.get("toDate").s());
            resultList.add(pastExp);
        }
        return resultList;
    }

    private List<Certificate> revertCertificate(List<AttributeValue> certList) {
        List<Certificate> resultList = new ArrayList<>();
        for(AttributeValue attVal : certList) {
            Map<String, AttributeValue> atValMap = attVal.m();
            Certificate cert = new Certificate();
            cert.setCertificateId(atValMap.get("certificateId").s());
            cert.setCertificateName(atValMap.get("certificateName").s());
            cert.setCertificateIssuer(atValMap.get("certificateIssuer").s());
            cert.setYearObtained(atValMap.get("yearObtained").s());
            resultList.add(cert);
        }
        return resultList;
    }

    private List<Education> revertEducation(List<AttributeValue> certList) {
        List<Education> resultList = new ArrayList<>();
        for(AttributeValue attVal : certList) {
            Map<String, AttributeValue> atValMap = attVal.m();
            Education education = new Education();
            education.setIsHighestEducation(atValMap.get("isHighestEducation").bool());
            education.setNameOfInstitute(atValMap.get("nameOfInstitute").s());
            education.setNameOfUniversityBoard(atValMap.get("fromYear").s());
            education.setToYear(atValMap.get("toYear").s());
            education.setCgpa(atValMap.get("cgpa").s());
            resultList.add(education);
        }
        return resultList;
    }

    private List<SkillSetDetails> revertSkillSetDetails(List<AttributeValue> ssDetails) {
        List<SkillSetDetails> resultList = new ArrayList<>();
        for(AttributeValue attVal : ssDetails) {
            Map<String, AttributeValue> atValMap = attVal.m();
            SkillSetDetails cert = new SkillSetDetails();
            cert.setSkillType(atValMap.get("skillType").s());
            cert.setSkillDetailList(revertSkillDetails(atValMap.get("skillDetailList").l()));
            resultList.add(cert);
        }
        return resultList;
    }

    private List<SkillDetail> revertSkillDetails(List<AttributeValue> skillDetailList) {
        List<SkillDetail> resultList = new ArrayList<>();
        for(AttributeValue attVal : skillDetailList) {
            Map<String, AttributeValue> atValMap = attVal.m();
            SkillDetail sd = new SkillDetail();
            sd.setSkillName(atValMap.get("skillName").s());
            sd.setExpInYears(atValMap.get("expInYears").s());
            resultList.add(sd);
        }
        return resultList;
    }

    private List<PortFolio> revertPortfolio(List<AttributeValue> portfolioList) {
        List<PortFolio> resultList = new ArrayList<>();
        for(AttributeValue attVal : portfolioList) {
            Map<String, AttributeValue> atValMap = attVal.m();
            PortFolio portFolio = new PortFolio();
            portFolio.setPortFolioDescription(atValMap.get("portFolioDescription").s());
            portFolio.setPortfolioLink(atValMap.get("portfolioLink").s());
            resultList.add(portFolio);
        }
        return resultList;
    }

    private List<SocialMedia> revertSocialMedia(List<AttributeValue> smList) {
        List<SocialMedia> resultList = new ArrayList<>();
        for(AttributeValue attVal : smList) {
            Map<String, AttributeValue> atValMap = attVal.m();
            SocialMedia socialMedia = new SocialMedia();
            socialMedia.setSocialMediaName(atValMap.get("socialMediaName").s());
            socialMedia.setLink(atValMap.get("link").s());
            resultList.add(socialMedia);
        }
        return resultList;
    }

    private List<ProfessionalReference> revertProfessionalReference(List<AttributeValue> prList) {
        List<ProfessionalReference> resultList = new ArrayList<>();
        for(AttributeValue attVal : prList) {
            Map<String, AttributeValue> atValMap = attVal.m();
            ProfessionalReference reference = new ProfessionalReference();
            reference.setReferenceName(atValMap.get("referenceName").s());
            reference.setCompany(atValMap.get("company").s());
            reference.setRelation(atValMap.get("relation").s());
            reference.setPhone(atValMap.get("phone").s());
            reference.setEmail(atValMap.get("email").s());
            resultList.add(reference);
        }
        return resultList;
    }

    private List<CustomCandidateField> revertCustomCandidateField(List<AttributeValue> ccfList) {
        List<CustomCandidateField> resultList = new ArrayList<>();
        for(AttributeValue attVal : ccfList) {
            Map<String, AttributeValue> atValMap = attVal.m();
            CustomCandidateField cAttr = new CustomCandidateField();
            cAttr.setAttributeName(atValMap.get("attributeName").s());
            cAttr.setAttributeValue(atValMap.get("attributeValue").s());
            cAttr.setAttributeType(atValMap.get("attributeType").s());
            resultList.add(cAttr);
        }
        return resultList;
    }
}
