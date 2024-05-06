package com.wazo.services.candidate.utils;

import com.wazo.models.candidate.*;
import com.wazo.services.candidate.dao.entity.CandidateEntity;
import java.util.*;

public class CreateCandidateJsonObject {

    public static CreateCandidateRequest getCreateCandidateRequestObject() {
        CreateCandidateRequest cReq = new CreateCandidateRequest();
        cReq.setRequisitionIdList(new ArrayList<>(List.of("requisition 1", "requisition 2")));
        cReq.setFirstName("Debanik");
        cReq.setLastName("Kundu");
        cReq.setDateOfBirth("30121987");
        cReq.setGender("Male");
        cReq.setNationality("Indian");
        cReq.setDocuments(getDocuments());
        cReq.setIsPresentAddressSameAsPermanent(true);
        cReq.setProfessionalExperience(getProfExp());
        cReq.setEducation(getEducation());
        cReq.setContact(getContactList());
        cReq.setSkillSet(getSkillSetDetails());
        cReq.setIsUnderProcess(false);
        cReq.setApplicationSource("linkedIn");
        cReq.setProfessionalReference(getProfessionalReference());
        cReq.setEeoDetails_discrimination("no");
        cReq.setEeoDetails_race("Indian");
        cReq.setEeoDetails_ethnicity("Asian");
        cReq.setEeoDetails_gender("Male");
        cReq.setEeoDetails_age("37");
        cReq.setEeoDetails_disabilities("None");
        cReq.setEeoDetails_militaryExperience("None");
        cReq.setEeoDetails_religion("Hindu");
        cReq.setEeoDetails_maritalStatus("Married");
        cReq.setEeoDetails_sexualOrientation("Straight");
        cReq.setEeoDetails_protectedClass("No");
        cReq.setCustomCandidateFields(getCustomCandidateFields());
        cReq.setAddressList(getAddressList());
        cReq.setCandidateNoticePeriod("30 days");
        cReq.setCandidateInterviewAvailability("04452024 - Datetime converted to string");
        cReq.setSocialMediaProfile(getSocialMediaList());
        cReq.setPortfolio(getPortFolioList());
        cReq.setComments("Candidate is ready for interview");

        return cReq;
    }

    private static List<String> getDocuments() {
        List<String> docList = new ArrayList<>();
        docList.add("Doc_1");

        return docList;
    }

    private static List<PortFolio> getPortFolioList() {
        List<PortFolio> pfList = new ArrayList<>();

        PortFolio pf1 = new PortFolio();
        pf1.setPortfolioLink("pf URL 1");
        pf1.setPortFolioDescription("desc 1");
        pfList.add(pf1);

        PortFolio pf2 = new PortFolio();
        pf2.setPortfolioLink("pf URL 2");
        pf2.setPortFolioDescription("desc 2");
        pfList.add(pf2);

        return pfList;
    }

    private static List<SocialMedia> getSocialMediaList() {
        List<SocialMedia> smList = new ArrayList<>();

        SocialMedia sm1 = new SocialMedia();
        sm1.setSocialMediaName("FACEBOOK");
        sm1.setLink("facebook URL");
        smList.add(sm1);

        SocialMedia sm2 = new SocialMedia();
        sm2.setSocialMediaName("INSTAGRAM");
        sm2.setLink("instagram URL");
        smList.add(sm2);

        return smList;
    }

    private static List<Address> getAddressList() {
        List<Address> addrList = new ArrayList<>();
        Address addr1 = Address.builder()
                .addressLine1("apt no 1")
                .addressLine2("street name 1")
                .addressType("PRESENT")
                .city("city 1")
                .state("TX")
                .zipCode("75038")
                .country("USA")
                .build();

        addrList.add(addr1);

        Address addr2 = Address.builder()
                .addressLine1("apt no 41")
                .addressLine2("street name 2")
                .addressType("PERMANENT")
                .city("Kolkata")
                .state("West Bengal")
                .zipCode("700003")
                .country("INDIA")
                .build();

        addrList.add(addr2);

        return addrList;
    }

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

    private static List<Contact> getContactList(){
        List<Contact> contacts = new ArrayList<>();

        Contact con1 = Contact.builder()
                .system("Mobile")
                .value("9876543210")
                .rank(1)
                .build();

        contacts.add(con1);

        Contact con2 = Contact.builder()
                .system("email")
                .value("debanik@wazoworld.com")
                .rank(2)
                .build();

        contacts.add(con2);

        Contact con3 = Contact.builder()
                .system("whatsapp")
                .value("9158314321")
                .rank(3)
                .build();

        contacts.add(con3);

        Contact con4 = Contact.builder()
                .system("alternate number")
                .value("8017014027")
                .rank(4)
                .build();

        contacts.add(con4);

        return contacts;
    }
}
