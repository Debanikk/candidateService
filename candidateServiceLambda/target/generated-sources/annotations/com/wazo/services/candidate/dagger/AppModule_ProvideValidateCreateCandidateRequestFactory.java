package com.wazo.services.candidate.dagger;

import com.wazo.services.candidate.validation.ValidateCreateCandidateRequest;
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
public final class AppModule_ProvideValidateCreateCandidateRequestFactory implements Factory<ValidateCreateCandidateRequest> {
  private final AppModule module;

  public AppModule_ProvideValidateCreateCandidateRequestFactory(AppModule module) {
    this.module = module;
  }

  @Override
  public ValidateCreateCandidateRequest get() {
    return provideValidateCreateCandidateRequest(module);
  }

  public static AppModule_ProvideValidateCreateCandidateRequestFactory create(AppModule module) {
    return new AppModule_ProvideValidateCreateCandidateRequestFactory(module);
  }

  public static ValidateCreateCandidateRequest provideValidateCreateCandidateRequest(
      AppModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.provideValidateCreateCandidateRequest());
  }
}
