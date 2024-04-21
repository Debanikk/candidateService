package com.wazo.services.candidate.dagger;

import com.wazo.services.candidate.activity.CreateCandidateActivity;
import com.wazo.services.candidate.dao.CandidateDao;
import com.wazo.services.candidate.validation.ValidateCreateCandidateRequest;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class AppModule_ProvideCreateCandidateActivityFactory implements Factory<CreateCandidateActivity> {
  private final AppModule module;

  private final Provider<CandidateDao> candidateDaoProvider;

  private final Provider<ValidateCreateCandidateRequest> validateCreateCandidateRequestProvider;

  public AppModule_ProvideCreateCandidateActivityFactory(AppModule module,
      Provider<CandidateDao> candidateDaoProvider,
      Provider<ValidateCreateCandidateRequest> validateCreateCandidateRequestProvider) {
    this.module = module;
    this.candidateDaoProvider = candidateDaoProvider;
    this.validateCreateCandidateRequestProvider = validateCreateCandidateRequestProvider;
  }

  @Override
  public CreateCandidateActivity get() {
    return provideCreateCandidateActivity(module, candidateDaoProvider.get(), validateCreateCandidateRequestProvider.get());
  }

  public static AppModule_ProvideCreateCandidateActivityFactory create(AppModule module,
      Provider<CandidateDao> candidateDaoProvider,
      Provider<ValidateCreateCandidateRequest> validateCreateCandidateRequestProvider) {
    return new AppModule_ProvideCreateCandidateActivityFactory(module, candidateDaoProvider, validateCreateCandidateRequestProvider);
  }

  public static CreateCandidateActivity provideCreateCandidateActivity(AppModule instance,
      CandidateDao candidateDao, ValidateCreateCandidateRequest validateCreateCandidateRequest) {
    return Preconditions.checkNotNullFromProvides(instance.provideCreateCandidateActivity(candidateDao, validateCreateCandidateRequest));
  }
}
