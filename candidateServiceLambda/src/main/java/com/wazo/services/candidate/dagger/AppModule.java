package com.wazo.services.candidate.dagger;

import com.wazo.services.candidate.activity.*;
import com.wazo.services.candidate.clients.DynamoDb;
import com.wazo.services.candidate.dao.CandidateDao;
import com.wazo.services.candidate.dao.impl.CandidateDaoImpl;
import com.wazo.services.candidate.validation.ValidateCreateCandidateRequest;
import com.wazo.services.candidate.validation.ValidateUpdateCandidateRequest;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;


@Module()
public class AppModule {

    @Provides
    @Singleton
    public DynamoDb provideDynamoDb() {
        return new DynamoDb();
    }


    @Provides
    @Singleton
    public CandidateDao provideCandidateDao(DynamoDb dynamoDb) {
        return new CandidateDaoImpl(dynamoDb);
    }

    @Provides
    @Singleton
    public ValidateCreateCandidateRequest provideValidateCreateCandidateRequest() {
        return new ValidateCreateCandidateRequest();
    }

    @Provides
    @Singleton
    public ValidateUpdateCandidateRequest provideValidateUpdateCandidateRequest() {
        return new ValidateUpdateCandidateRequest();
    }

    @Provides
    @Singleton
    public CreateCandidateActivity provideCreateCandidateActivity(CandidateDao candidateDao, ValidateCreateCandidateRequest validateCreateCandidateRequest) {
        return new CreateCandidateActivity(candidateDao, validateCreateCandidateRequest);
    }

    @Provides
    @Singleton
    public GetAllCandidatesActivity provideGetAllCandidatesActivity(CandidateDao candidateDao) {
        return new GetAllCandidatesActivity(candidateDao);
    }

    @Provides
    @Singleton
    public GetCandidateDetailsByIdActivity provideGetCandidateDetailsByIdActivity(CandidateDao candidateDao) {
        return new GetCandidateDetailsByIdActivity(candidateDao);
    }

    @Provides
    @Singleton
    public GetCandidateByIdActivity provideGetByIdcandidateActivity(CandidateDao candidateDao) {
        return new GetCandidateByIdActivity(candidateDao);
    }

    @Provides
    @Singleton
    public UpdateCandidateActivity provideUpdateCandidateActivity(CandidateDao candidateDao, ValidateUpdateCandidateRequest validateUpdatecandidateRequest) {
        return new UpdateCandidateActivity(candidateDao, validateUpdatecandidateRequest);
    }

    @Provides
    @Singleton
    public DeleteCandidateActivity provideDeleteCandidateActivity(CandidateDao candidateDao) {
        return new DeleteCandidateActivity(candidateDao);
    }

}