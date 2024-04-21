package com.wazo.services.candidate.utils;

import com.wazo.services.candidate.dao.entity.CandidateEntity;
import com.wazo.services.candidate.model.request.*;
import java.util.ArrayList;
import java.util.List;

public class CreateCandidateJsonObject {

    public static CandidateEntity getCandidateEntityObject() {
        CandidateEntity can = new CandidateEntity();
        can.setOrgId("org_wazo_1");
        can.setCandidateId("can_1");
        can.setFirstName("Debanik");
        can.setLastName("Kundu");
        can.setDateOfBirth("30121987");
        can.setGender("Male");
        can.setNationality("Indian");
        can.setIsPresentSameAsPermanentAddress(true);
        can.setProfessionalExperience(getProfExp());
        can.setEducation(getEducation());
        can.setSkillSet(getSkillSetDetails());
        can.setIsUnderProcess(false);
        can.setApplicationSource("linkedIn");
        can.setProfessionalReference(getProfessionalReference());
        can.setEeoDetails_discrimination("no");
        can.setEeoDetails_race("Indian");
        can.setEeoDetails_ethnicity("Asian");
        can.setEeoDetails_gender("Male");
        can.setEeoDetails_age("37");
        can.setEeoDetails_disabilities("None");
        can.setEeoDetails_militaryExperience("None");
        can.setEeoDetails_religion("Hindu");
        can.setEeoDetails_maritalStatus("Married");
        can.setEeoDetails_sexualOrientation("Straight");
        can.setEeoDetails_protectedClass("No");
        can.setCustomCandidateFields(getCustomCandidateFields());
        return can;
    }

    private static List<CustomCandidateField> getCustomCandidateFields() {
        List<CustomCandidateField> fieldList = new ArrayList<>();

        CustomCandidateField ccf1 = new CustomCandidateField();
        ccf1.setAttributeName("Karmachari ka baap na naam");
        ccf1.setAttributeValue("Daddy");
        ccf1.setAttributeType("Personal data");
        fieldList.add(ccf1);

        CustomCandidateField ccf2 = new CustomCandidateField();
        ccf2.setAttributeName("dependent Information");
        ccf2.setAttributeValue("2");
        ccf2.setAttributeType("Insurance and tax data");
        fieldList.add(ccf2);

        return fieldList;
    }

    private static List<ProfessionalReference> getProfessionalReference() {
        List<ProfessionalReference> ref = new ArrayList<>();
        ProfessionalReference ref1 = new ProfessionalReference();
        ref1.setReferenceName("Samrat");
        ref1.setCompany("Amazon");
        ref1.setRelation("Manager");
        ref1.setEmail("abc@samrat.com");
        ref1.setPhone("1234567890");

        ref.add(ref1);

        ProfessionalReference ref2 = new ProfessionalReference();
        ref2.setReferenceName("Akhtar");
        ref2.setCompany("wazo-world");
        ref2.setRelation("Team lead");
        ref2.setEmail("akh@wazo.com");
        ref2.setPhone("9087654321");

        ref.add(ref2);

        return ref;
    }

    private static List<SkillSetDetails> getSkillSetDetails() {
        List<SkillSetDetails> skillSetDetails = new ArrayList<>();

        // SKILL 1
        List<SkillDetail> skillDetailsTech = new ArrayList<>();
        SkillDetail sd1 = new SkillDetail();
        sd1.setSkillName("Java");
        sd1.setExpInYears("13");
        skillDetailsTech.add(sd1);
        SkillDetail sd2 = new SkillDetail();
        sd2.setSkillName("AWS");
        sd2.setExpInYears("1");
        skillDetailsTech.add(sd2);

        SkillSetDetails ssd1 = new SkillSetDetails();
        ssd1.setSkillDetailList(skillDetailsTech);
        ssd1.setSkillType("TECHNICAL");
        skillSetDetails.add(ssd1);

        //SKILL - 2
        List<SkillDetail> skillDetailsKey = new ArrayList<>();
        SkillDetail sd3 = new SkillDetail();
        sd3.setSkillName("MANAGEMENT");
        sd3.setExpInYears("13");
        skillDetailsKey.add(sd3);
        SkillDetail sd4 = new SkillDetail();
        sd4.setSkillName("LEAD");
        sd4.setExpInYears("5");
        skillDetailsKey.add(sd4);

        SkillSetDetails ssd2 = new SkillSetDetails();
        ssd2.setSkillDetailList(skillDetailsKey);
        ssd2.setSkillType("KEY");
        skillSetDetails.add(ssd2);

        return skillSetDetails;
    }


    private static List<Education> getEducation() {
        List<Education> edList = new ArrayList<>();
        // ed1
        Education ed1 = new Education();
        ed1.setIsHighestEducation(true);
        ed1.setNameOfInstitute("IIIT-Bangalore");
        ed1.setNameOfUniversityBoard("IIIT-Bangalore");
        ed1.setFromYear("2020");
        ed1.setToYear("2021");
        ed1.setCgpa("3.48");
        edList.add(ed1);
        Education ed2 = new Education();
        ed2.setIsHighestEducation(false);
        ed2.setNameOfInstitute("DIET");
        ed2.setNameOfUniversityBoard("WBUT");
        ed2.setFromYear("2006");
        ed2.setToYear("2010");
        ed2.setCgpa("7.76");
        edList.add(ed2);

        return edList;
    }

    private static ProfessionalExperience getProfExp() {
        ProfessionalExperience professionalExperience = new ProfessionalExperience();
        professionalExperience.setCurrentOrganization("Acme Corp");
        professionalExperience.setCurrentPosition("Software Engineer");
        professionalExperience.setFromDate("2020-01-01");

        // Create a list of PastProfessionalExperience instances
        List<PastProfessionalExperience> pastExperienceList = new ArrayList<>();
        PastProfessionalExperience pastExperience1 = new PastProfessionalExperience();
        pastExperience1.setJobTitle("Senior Developer");
        pastExperience1.setEmployer("Tech Solutions Inc");
        pastExperience1.setDuration("2 years");
        pastExperience1.setFromDate("2018-01-01");
        pastExperience1.setToDate("2020-01-01");
        pastExperienceList.add(pastExperience1);

        PastProfessionalExperience pastExperience2 = new PastProfessionalExperience();
        pastExperience2.setJobTitle("Junior Developer");
        pastExperience2.setEmployer("Software Co");
        pastExperience2.setDuration("1 year");
        pastExperience2.setFromDate("2017-01-01");
        pastExperience2.setToDate("2018-01-01");
        pastExperienceList.add(pastExperience2);

        professionalExperience.setPastExperience(pastExperienceList);

        // Create a list of Certificate instances
        List<Certificate> certificateList = new ArrayList<>();
        Certificate certificate1 = new Certificate();
        certificate1.setCertificateName("AWS Certified Developer - Associate");
        certificate1.setCertificateIssuer("Amazon Web Services");
        certificate1.setYearObtained("2020-05-01");
        certificateList.add(certificate1);

        Certificate certificate2 = new Certificate();
        certificate2.setCertificateName("Oracle Certified Professional - Java SE Programmer");
        certificate2.setCertificateIssuer("Oracle Corporation");
        certificate2.setYearObtained("2019-07-15");
        certificateList.add(certificate2);

        professionalExperience.setCertificates(certificateList);

        return professionalExperience;
    }
}
