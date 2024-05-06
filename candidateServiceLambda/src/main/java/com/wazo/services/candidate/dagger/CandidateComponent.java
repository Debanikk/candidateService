package com.wazo.services.candidate.dagger;

import com.wazo.services.candidate.activity.*;
import com.wazo.services.candidate.handler.CandidateLambdaMainHandler;
import dagger.Component;

import javax.inject.Singleton;


@Singleton
@Component(modules = {EnvModule.class, AppModule.class})
public interface CandidateComponent {

    void inject(CandidateLambdaMainHandler candidateLambdaMainHandler);

    CreateCandidateActivity createCandidateActivity();

    DeleteCandidateActivity deletecandidateActivity();

    GetAllCandidatesActivity getAllCandidatesActivity();

    GetCandidateByIdActivity getCandidateByIdActivity();

    UpdateCandidateDetailsActivity updateCandidateDetailsActivity();

    UpdateCandidateAddressActivity updateCandidateAddressActivity();

    UpdateCandidateCommentActivity updateCandidateCommentActivity();

    UpdateCandidateContactActivity updateCandidateContactActivity();

    UpdateCandidateDocumentActivity updateCandidateDocumentActivity();

    UpdateCandidateUnderProcessActivity updateCandidateUnderProcessActivity();

    GetCandidateDetailsByIdActivity getCandidateDetailsByIdActivity();
}