package com.wazo.services.candidate.dagger;

import com.wazo.services.candidate.activity.CreateCandidateActivity;
import com.wazo.services.candidate.activity.DeleteCandidateActivity;
import com.wazo.services.candidate.activity.GetAllCandidatesActivity;
import com.wazo.services.candidate.activity.GetCandidateByIdActivity;
import com.wazo.services.candidate.activity.GetCandidateDetailsByIdActivity;
import com.wazo.services.candidate.activity.UpdateCandidateActivity;
import com.wazo.services.candidate.clients.DynamoDb;
import com.wazo.services.candidate.dao.CandidateDao;
import com.wazo.services.candidate.handler.CandidateLambdaMainHandler;
import com.wazo.services.candidate.validation.ValidateCreateCandidateRequest;
import com.wazo.services.candidate.validation.ValidateUpdateCandidateRequest;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class DaggerCandidateComponent {
  private DaggerCandidateComponent() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static CandidateComponent create() {
    return new Builder().build();
  }

  public static final class Builder {
    private AppModule appModule;

    private Builder() {
    }

    public Builder appModule(AppModule appModule) {
      this.appModule = Preconditions.checkNotNull(appModule);
      return this;
    }

    public CandidateComponent build() {
      if (appModule == null) {
        this.appModule = new AppModule();
      }
      return new CandidateComponentImpl(appModule);
    }
  }

  private static final class CandidateComponentImpl implements CandidateComponent {
    private final CandidateComponentImpl candidateComponentImpl = this;

    private Provider<DynamoDb> provideDynamoDbProvider;

    private Provider<CandidateDao> provideCandidateDaoProvider;

    private Provider<ValidateCreateCandidateRequest> provideValidateCreateCandidateRequestProvider;

    private Provider<CreateCandidateActivity> provideCreateCandidateActivityProvider;

    private Provider<DeleteCandidateActivity> provideDeleteCandidateActivityProvider;

    private Provider<GetAllCandidatesActivity> provideGetAllCandidatesActivityProvider;

    private Provider<GetCandidateByIdActivity> provideGetByIdcandidateActivityProvider;

    private Provider<ValidateUpdateCandidateRequest> provideValidateUpdateCandidateRequestProvider;

    private Provider<UpdateCandidateActivity> provideUpdateCandidateActivityProvider;

    private Provider<GetCandidateDetailsByIdActivity> provideGetCandidateDetailsByIdActivityProvider;

    private CandidateComponentImpl(AppModule appModuleParam) {

      initialize(appModuleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final AppModule appModuleParam) {
      this.provideDynamoDbProvider = DoubleCheck.provider(AppModule_ProvideDynamoDbFactory.create(appModuleParam));
      this.provideCandidateDaoProvider = DoubleCheck.provider(AppModule_ProvideCandidateDaoFactory.create(appModuleParam, provideDynamoDbProvider));
      this.provideValidateCreateCandidateRequestProvider = DoubleCheck.provider(AppModule_ProvideValidateCreateCandidateRequestFactory.create(appModuleParam));
      this.provideCreateCandidateActivityProvider = DoubleCheck.provider(AppModule_ProvideCreateCandidateActivityFactory.create(appModuleParam, provideCandidateDaoProvider, provideValidateCreateCandidateRequestProvider));
      this.provideDeleteCandidateActivityProvider = DoubleCheck.provider(AppModule_ProvideDeleteCandidateActivityFactory.create(appModuleParam, provideCandidateDaoProvider));
      this.provideGetAllCandidatesActivityProvider = DoubleCheck.provider(AppModule_ProvideGetAllCandidatesActivityFactory.create(appModuleParam, provideCandidateDaoProvider));
      this.provideGetByIdcandidateActivityProvider = DoubleCheck.provider(AppModule_ProvideGetByIdcandidateActivityFactory.create(appModuleParam, provideCandidateDaoProvider));
      this.provideValidateUpdateCandidateRequestProvider = DoubleCheck.provider(AppModule_ProvideValidateUpdateCandidateRequestFactory.create(appModuleParam));
      this.provideUpdateCandidateActivityProvider = DoubleCheck.provider(AppModule_ProvideUpdateCandidateActivityFactory.create(appModuleParam, provideCandidateDaoProvider, provideValidateUpdateCandidateRequestProvider));
      this.provideGetCandidateDetailsByIdActivityProvider = DoubleCheck.provider(AppModule_ProvideGetCandidateDetailsByIdActivityFactory.create(appModuleParam, provideCandidateDaoProvider));
    }

    @Override
    public void inject(CandidateLambdaMainHandler candidateLambdaMainHandler) {
    }

    @Override
    public CreateCandidateActivity createCandidateActivity() {
      return provideCreateCandidateActivityProvider.get();
    }

    @Override
    public DeleteCandidateActivity deletecandidateActivity() {
      return provideDeleteCandidateActivityProvider.get();
    }

    @Override
    public GetAllCandidatesActivity getAllCandidatesActivity() {
      return provideGetAllCandidatesActivityProvider.get();
    }

    @Override
    public GetCandidateByIdActivity getCandidateByIdActivity() {
      return provideGetByIdcandidateActivityProvider.get();
    }

    @Override
    public UpdateCandidateActivity updatecandidateActivity() {
      return provideUpdateCandidateActivityProvider.get();
    }

    @Override
    public GetCandidateDetailsByIdActivity getCandidateDetailsByIdActivity() {
      return provideGetCandidateDetailsByIdActivityProvider.get();
    }
  }
}
