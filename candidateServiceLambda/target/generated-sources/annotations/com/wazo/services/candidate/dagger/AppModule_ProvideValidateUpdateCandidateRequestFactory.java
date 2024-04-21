package com.wazo.services.candidate.dagger;

import com.wazo.services.candidate.validation.ValidateUpdateCandidateRequest;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class AppModule_ProvideValidateUpdateCandidateRequestFactory implements Factory<ValidateUpdateCandidateRequest> {
  private final AppModule module;

  public AppModule_ProvideValidateUpdateCandidateRequestFactory(AppModule module) {
    this.module = module;
  }

  @Override
  public ValidateUpdateCandidateRequest get() {
    return provideValidateUpdateCandidateRequest(module);
  }

  public static AppModule_ProvideValidateUpdateCandidateRequestFactory create(AppModule module) {
    return new AppModule_ProvideValidateUpdateCandidateRequestFactory(module);
  }

  public static ValidateUpdateCandidateRequest provideValidateUpdateCandidateRequest(
      AppModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.provideValidateUpdateCandidateRequest());
  }
}
