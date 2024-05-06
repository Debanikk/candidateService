package com.wazo.services.candidate.dao;

import com.wazo.models.candidate.Address;
import com.wazo.models.candidate.Contact;
import com.wazo.services.candidate.dao.entity.CandidateEntity;
import com.wazo.services.candidate.dao.entity.ContactEntity;
import com.wazo.services.candidate.model.response.CandidateResponse;

import java.util.List;

public interface CandidateDao {

    CandidateEntity saveCandidateEntity(CandidateEntity candidateEntity);

    List<CandidateEntity> getAllCandidatesEntity(String orgId);

    CandidateResponse getCandidateDetailsByIdEntity(String orgId, String candidateId);

    CandidateEntity getCandidateByIdEntity(String orgId, String candidateId);

    void deleteCandidateEntity(String orgId, String candidateId);

    CandidateEntity updateCandidateDetails(CandidateEntity candidateEntity);

    CandidateEntity updateCandidateUnderProcess(CandidateEntity candidateEntity);

    String updateCandidateComments(CandidateEntity candidateEntity);

    String updateCandidateDocuments(CandidateEntity candidateEntity);

    CandidateEntity updateCandidateAddress(CandidateEntity candidateEntity);

    String updateCandidateContact(CandidateEntity candidateEntity);

    ContactEntity getContactFromConfigServer(String configId, String orgId);

    String createContactToConfigServer(Contact contact, String orgId);

    Address getAddressFromConfigServer(String addressId, String orgId);

    String createAddressToConfigServer(Address address, String orgId);


}