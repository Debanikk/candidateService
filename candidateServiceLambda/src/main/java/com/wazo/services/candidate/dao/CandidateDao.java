package com.wazo.services.candidate.dao;

import com.wazo.services.candidate.dao.entity.CandidateEntity;
import com.wazo.services.candidate.model.response.CandidateResponse;

import java.util.List;

public interface CandidateDao {

    CandidateEntity saveCandidateEntity(CandidateEntity candidateEntity);

    List<CandidateEntity> getAllCandidatesEntity(String orgId);

    CandidateResponse getCandidateDetailsByIdEntity(String orgId, String candidateId);

    CandidateEntity getCandidateByIdEntity(String orgId, String candidateId);

    void deleteCandidateEntity(String orgId, String candidateId);
}