
package com.wazo.services.candidate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wazo.services.candidate.clients.DynamoDb;
import com.wazo.services.candidate.dao.CandidateDao;
import com.wazo.services.candidate.dao.entity.CandidateEntity;
import com.wazo.services.candidate.dao.impl.CandidateDaoImpl;
import com.wazo.services.candidate.model.response.CandidateResponse;

import static com.wazo.services.candidate.utils.CreateCandidateJsonObject.getCandidateEntityObject;

// -- UNCOMMENT IF PRODUCING JSON FOR CANDIDATE ENTITY
/*
import com.fasterxml.jackson.databind.ObjectMapper;
*/
// add exception signature if producing JSON - <throws JsonProcessingException> in main method

public class App {
    public static void main(String[] args) throws JsonProcessingException {
        System.out.println("Hello World!");

        /*
        // GENERATE JSON AS STRING FOR CANDIDATE DATA
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(getCandidateEntityObject());
        System.out.println(json);
        */

        // -- UNCOMMENT FOR LOCAL TESTING
        CandidateDao candidateDao = new CandidateDaoImpl(new DynamoDb());
        //List<CandidateEntity> lf = candidateDao.getAllCandidatesEntity("org_wazo_1");
        CandidateResponse lf = candidateDao.getCandidateDetailsByIdEntity("org_wazo_1", "can_1");
        //CandidateEntity candidate = candidateDao.saveCandidateEntity(getCandidateEntityObject());
        //System.out.println(lf.size());
        System.out.println(lf);
        //System.out.println(candidate.toString());
    }
}