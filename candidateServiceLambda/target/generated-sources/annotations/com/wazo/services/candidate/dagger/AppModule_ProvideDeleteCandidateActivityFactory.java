package com.wazo.services.candidate.dagger;

import com.wazo.services.candidate.activity.DeleteCandidateActivity;
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
public final class AppModule_ProvideDeleteCandidateActivityFactory implements Factory<DeleteCandidateActivity> {
  private final AppModule module;

  private final Provider<CandidateDao> candidateDaoProvider;

  public AppModule_ProvideDeleteCandidateActivityFactory(AppModule module,
      Provider<CandidateDao> candidateDaoProvider) {
    this.module = module;
    this.candidateDaoProvider = candidateDaoProvider;
  }

  @Override
  public DeleteCandidateActivity get() {
    return provideDeleteCandidateActivity(module, candidateDaoProvider.get());
  }

  public static AppModule_ProvideDeleteCandidateActivityFactory create(AppModule module,
      Provider<CandidateDao> candidateDaoProvider) {
    return new AppModule_ProvideDeleteCandidateActivityFactory(module, candidateDaoProvider);
  }

  public static DeleteCandidateActivity provideDeleteCandidateActivity(AppModule instance,
      CandidateDao candidateDao) {
    return Preconditions.checkNotNullFromProvides(instance.provideDeleteCandidateActivity(candidateDao));
  }
}
