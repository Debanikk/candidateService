package com.wazo.services.candidate.dagger;

import com.wazo.services.candidate.ConfigurationServiceClient.impl.ConfigurationRestClientImpl;
import com.wazo.services.candidate.activity.*;
import com.wazo.services.candidate.clients.DynamoDb;
import com.wazo.services.candidate.dao.CandidateDao;
import com.wazo.services.candidate.dao.impl.CandidateDaoImpl;
import com.wazo.services.candidate.validation.*;
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
    public ConfigurationRestClientImpl provideConfigurationRestClientImpl() {
        return new ConfigurationRestClientImpl();
    }

    @Provides
    @Singleton
    public CandidateDao provideCandidateDao(DynamoDb dynamoDb, ConfigurationRestClientImpl configurationRestClient) {
        return new CandidateDaoImpl(dynamoDb, configurationRestClient);
    }

    @Provides
    @Singleton
    public ValidateCreateCandidateRequest provideValidateCreateCandidateRequest() {
        return new ValidateCreateCandidateRequest();
    }

    @Provides
    @Singleton
    public ValidateUpdateCandidateDetailsRequest provideValidateUpdateCandidateDetailsRequest() {
        return new ValidateUpdateCandidateDetailsRequest();
    }

    @Provides
    @Singleton
    public ValidateUpdateCandidateAddressRequest provideValidateUpdateCandidateAddressRequest() {
        return new ValidateUpdateCandidateAddressRequest();
    }

    @Provides
    @Singleton
    public ValidateUpdateCandidateCommentRequest provideValidateUpdateCandidateCommentRequest() {
        return new ValidateUpdateCandidateCommentRequest();
    }

    @Provides
    @Singleton
    public ValidateUpdateCandidateContactRequest provideValidateUpdateCandidateContactRequest() {
        return new ValidateUpdateCandidateContactRequest();
    }

    @Provides
    @Singleton
    public ValidateUpdateCandidateDocumentRequest provideValidateUpdateCandidateDocumentRequest() {
        return new ValidateUpdateCandidateDocumentRequest();
    }

    @Provides
    @Singleton
    public ValidateUpdateCandidateUnderProcessRequest provideValidateUpdateCandidateUnderProcessRequest() {
        return new ValidateUpdateCandidateUnderProcessRequest();
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
    public GetCandidateByIdActivity provideGetByIdCandidateActivity(CandidateDao candidateDao) {
        return new GetCandidateByIdActivity(candidateDao);
    }

    @Provides
    @Singleton
    public UpdateCandidateAddressActivity provideUpdateCandidateAddressActivity(CandidateDao candidateDao, ValidateUpdateCandidateAddressRequest validateUpdateCandidateAddressRequest) {
        return new UpdateCandidateAddressActivity(candidateDao, validateUpdateCandidateAddressRequest);
    }
    @Provides
    @Singleton
    public UpdateCandidateCommentActivity provideUpdateCandidateCommentActivity(CandidateDao candidateDao, ValidateUpdateCandidateCommentRequest validateUpdateCandidateCommentRequest) {
        return new UpdateCandidateCommentActivity(candidateDao, validateUpdateCandidateCommentRequest);
    }
    @Provides
    @Singleton
    public UpdateCandidateUnderProcessActivity provideUpdateCandidateUnderProcessActivity(CandidateDao candidateDao, ValidateUpdateCandidateUnderProcessRequest validateUpdateCandidateUnderProcessRequest) {
        return new UpdateCandidateUnderProcessActivity(candidateDao, validateUpdateCandidateUnderProcessRequest);
    }
    @Provides
    @Singleton
    public UpdateCandidateDocumentActivity provideUpdateCandidateDocumentActivity(CandidateDao candidateDao, ValidateUpdateCandidateDocumentRequest validateUpdateCandidateDocumentRequest) {
        return new UpdateCandidateDocumentActivity(candidateDao, validateUpdateCandidateDocumentRequest);
    }
    @Provides
    @Singleton
    public UpdateCandidateContactActivity provideUpdateCandidateContactActivity(CandidateDao candidateDao, ValidateUpdateCandidateContactRequest validateUpdateCandidateContactRequest) {
        return new UpdateCandidateContactActivity(candidateDao, validateUpdateCandidateContactRequest);
    }
    @Provides
    @Singleton
    public UpdateCandidateDetailsActivity provideUpdateCandidateDetailsActivity(CandidateDao candidateDao, ValidateUpdateCandidateDetailsRequest validateUpdateCandidateDetailsRequest) {
        return new UpdateCandidateDetailsActivity(candidateDao, validateUpdateCandidateDetailsRequest);
    }

    @Provides
    @Singleton
    public DeleteCandidateActivity provideDeleteCandidateActivity(CandidateDao candidateDao) {
        return new DeleteCandidateActivity(candidateDao);
    }

}