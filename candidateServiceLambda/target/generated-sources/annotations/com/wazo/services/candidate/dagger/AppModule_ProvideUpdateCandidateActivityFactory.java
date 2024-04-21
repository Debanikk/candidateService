package com.wazo.services.candidate.dagger;

import com.wazo.services.candidate.activity.UpdateCandidateActivity;
import com.wazo.services.candidate.dao.CandidateDao;
import com.wazo.services.candidate.validation.ValidateUpdateCandidateRequest;
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
public final class AppModule_ProvideUpdateCandidateActivityFactory implements Factory<UpdateCandidateActivity> {
  private final AppModule module;

  private final Provider<CandidateDao> candidateDaoProvider;

  private final Provider<ValidateUpdateCandidateRequest> validateUpdatecandidateRequestProvider;

  public AppModule_ProvideUpdateCandidateActivityFactory(AppModule module,
      Provider<CandidateDao> candidateDaoProvider,
      Provider<ValidateUpdateCandidateRequest> validateUpdatecandidateRequestProvider) {
    this.module = module;
    this.candidateDaoProvider = candidateDaoProvider;
    this.validateUpdatecandidateRequestProvider = validateUpdatecandidateRequestProvider;
  }

  @Override
  public UpdateCandidateActivity get() {
    return provideUpdateCandidateActivity(module, candidateDaoProvider.get(), validateUpdatecandidateRequestProvider.get());
  }

  public static AppModule_ProvideUpdateCandidateActivityFactory create(AppModule module,
      Provider<CandidateDao> candidateDaoProvider,
      Provider<ValidateUpdateCandidateRequest> validateUpdatecandidateRequestProvider) {
    return new AppModule_ProvideUpdateCandidateActivityFactory(module, candidateDaoProvider, validateUpdatecandidateRequestProvider);
  }

  public static UpdateCandidateActivity provideUpdateCandidateActivity(AppModule instance,
      CandidateDao candidateDao, ValidateUpdateCandidateRequest validateUpdatecandidateRequest) {
    return Preconditions.checkNotNullFromProvides(instance.provideUpdateCandidateActivity(candidateDao, validateUpdatecandidateRequest));
  }
}
