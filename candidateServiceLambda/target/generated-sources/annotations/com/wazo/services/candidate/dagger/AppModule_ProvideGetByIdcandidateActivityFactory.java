package com.wazo.services.candidate.dagger;

import com.wazo.services.candidate.activity.GetCandidateByIdActivity;
import com.wazo.services.candidate.dao.CandidateDao;
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
public final class AppModule_ProvideGetByIdCandidateActivityFactory implements Factory<GetCandidateByIdActivity> {
  private final AppModule module;

  private final Provider<CandidateDao> candidateDaoProvider;

  public AppModule_ProvideGetByIdCandidateActivityFactory(AppModule module,
      Provider<CandidateDao> candidateDaoProvider) {
    this.module = module;
    this.candidateDaoProvider = candidateDaoProvider;
  }

  @Override
  public GetCandidateByIdActivity get() {
    return provideGetByIdCandidateActivity(module, candidateDaoProvider.get());
  }

  public static AppModule_ProvideGetByIdCandidateActivityFactory create(AppModule module,
      Provider<CandidateDao> candidateDaoProvider) {
    return new AppModule_ProvideGetByIdCandidateActivityFactory(module, candidateDaoProvider);
  }

  public static GetCandidateByIdActivity provideGetByIdCandidateActivity(AppModule instance,
      CandidateDao candidateDao) {
    return Preconditions.checkNotNullFromProvides(instance.provideGetByIdCandidateActivity(candidateDao));
  }
}
