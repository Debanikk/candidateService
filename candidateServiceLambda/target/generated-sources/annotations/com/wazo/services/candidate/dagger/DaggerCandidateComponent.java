package com.wazo.services.candidate.dagger;

import com.wazo.services.candidate.ConfigurationServiceClient.impl.ConfigurationRestClientImpl;
import com.wazo.services.candidate.activity.CreateCandidateActivity;
import com.wazo.services.candidate.activity.DeleteCandidateActivity;
import com.wazo.services.candidate.activity.GetAllCandidatesActivity;
import com.wazo.services.candidate.activity.GetCandidateByIdActivity;
import com.wazo.services.candidate.activity.GetCandidateDetailsByIdActivity;
import com.wazo.services.candidate.activity.UpdateCandidateAddressActivity;
import com.wazo.services.candidate.activity.UpdateCandidateCommentActivity;
import com.wazo.services.candidate.activity.UpdateCandidateContactActivity;
import com.wazo.services.candidate.activity.UpdateCandidateDetailsActivity;
import com.wazo.services.candidate.activity.UpdateCandidateDocumentActivity;
import com.wazo.services.candidate.activity.UpdateCandidateUnderProcessActivity;
import com.wazo.services.candidate.clients.DynamoDb;
import com.wazo.services.candidate.dao.CandidateDao;
import com.wazo.services.candidate.handler.CandidateLambdaMainHandler;
import com.wazo.services.candidate.validation.ValidateCreateCandidateRequest;
import com.wazo.services.candidate.validation.ValidateUpdateCandidateAddressRequest;
import com.wazo.services.candidate.validation.ValidateUpdateCandidateCommentRequest;
import com.wazo.services.candidate.validation.ValidateUpdateCandidateContactRequest;
import com.wazo.services.candidate.validation.ValidateUpdateCandidateDetailsRequest;
import com.wazo.services.candidate.validation.ValidateUpdateCandidateDocumentRequest;
import com.wazo.services.candidate.validation.ValidateUpdateCandidateUnderProcessRequest;
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

    private Provider<ConfigurationRestClientImpl> provideConfigurationRestClientImplProvider;

    private Provider<CandidateDao> provideCandidateDaoProvider;

    private Provider<ValidateCreateCandidateRequest> provideValidateCreateCandidateRequestProvider;

    private Provider<CreateCandidateActivity> provideCreateCandidateActivityProvider;

    private Provider<DeleteCandidateActivity> provideDeleteCandidateActivityProvider;

    private Provider<GetAllCandidatesActivity> provideGetAllCandidatesActivityProvider;

    private Provider<GetCandidateByIdActivity> provideGetByIdCandidateActivityProvider;

    private Provider<ValidateUpdateCandidateDetailsRequest> provideValidateUpdateCandidateDetailsRequestProvider;

    private Provider<UpdateCandidateDetailsActivity> provideUpdateCandidateDetailsActivityProvider;

    private Provider<ValidateUpdateCandidateAddressRequest> provideValidateUpdateCandidateAddressRequestProvider;

    private Provider<UpdateCandidateAddressActivity> provideUpdateCandidateAddressActivityProvider;

    private Provider<ValidateUpdateCandidateCommentRequest> provideValidateUpdateCandidateCommentRequestProvider;

    private Provider<UpdateCandidateCommentActivity> provideUpdateCandidateCommentActivityProvider;

    private Provider<ValidateUpdateCandidateContactRequest> provideValidateUpdateCandidateContactRequestProvider;

    private Provider<UpdateCandidateContactActivity> provideUpdateCandidateContactActivityProvider;

    private Provider<ValidateUpdateCandidateDocumentRequest> provideValidateUpdateCandidateDocumentRequestProvider;

    private Provider<UpdateCandidateDocumentActivity> provideUpdateCandidateDocumentActivityProvider;

    private Provider<ValidateUpdateCandidateUnderProcessRequest> provideValidateUpdateCandidateUnderProcessRequestProvider;

    private Provider<UpdateCandidateUnderProcessActivity> provideUpdateCandidateUnderProcessActivityProvider;

    private Provider<GetCandidateDetailsByIdActivity> provideGetCandidateDetailsByIdActivityProvider;

    private CandidateComponentImpl(AppModule appModuleParam) {

      initialize(appModuleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final AppModule appModuleParam) {
      this.provideDynamoDbProvider = DoubleCheck.provider(AppModule_ProvideDynamoDbFactory.create(appModuleParam));
      this.provideConfigurationRestClientImplProvider = DoubleCheck.provider(AppModule_ProvideConfigurationRestClientImplFactory.create(appModuleParam));
      this.provideCandidateDaoProvider = DoubleCheck.provider(AppModule_ProvideCandidateDaoFactory.create(appModuleParam, provideDynamoDbProvider, provideConfigurationRestClientImplProvider));
      this.provideValidateCreateCandidateRequestProvider = DoubleCheck.provider(AppModule_ProvideValidateCreateCandidateRequestFactory.create(appModuleParam));
      this.provideCreateCandidateActivityProvider = DoubleCheck.provider(AppModule_ProvideCreateCandidateActivityFactory.create(appModuleParam, provideCandidateDaoProvider, provideValidateCreateCandidateRequestProvider));
      this.provideDeleteCandidateActivityProvider = DoubleCheck.provider(AppModule_ProvideDeleteCandidateActivityFactory.create(appModuleParam, provideCandidateDaoProvider));
      this.provideGetAllCandidatesActivityProvider = DoubleCheck.provider(AppModule_ProvideGetAllCandidatesActivityFactory.create(appModuleParam, provideCandidateDaoProvider));
      this.provideGetByIdCandidateActivityProvider = DoubleCheck.provider(AppModule_ProvideGetByIdCandidateActivityFactory.create(appModuleParam, provideCandidateDaoProvider));
      this.provideValidateUpdateCandidateDetailsRequestProvider = DoubleCheck.provider(AppModule_ProvideValidateUpdateCandidateDetailsRequestFactory.create(appModuleParam));
      this.provideUpdateCandidateDetailsActivityProvider = DoubleCheck.provider(AppModule_ProvideUpdateCandidateDetailsActivityFactory.create(appModuleParam, provideCandidateDaoProvider, provideValidateUpdateCandidateDetailsRequestProvider));
      this.provideValidateUpdateCandidateAddressRequestProvider = DoubleCheck.provider(AppModule_ProvideValidateUpdateCandidateAddressRequestFactory.create(appModuleParam));
      this.provideUpdateCandidateAddressActivityProvider = DoubleCheck.provider(AppModule_ProvideUpdateCandidateAddressActivityFactory.create(appModuleParam, provideCandidateDaoProvider, provideValidateUpdateCandidateAddressRequestProvider));
      this.provideValidateUpdateCandidateCommentRequestProvider = DoubleCheck.provider(AppModule_ProvideValidateUpdateCandidateCommentRequestFactory.create(appModuleParam));
      this.provideUpdateCandidateCommentActivityProvider = DoubleCheck.provider(AppModule_ProvideUpdateCandidateCommentActivityFactory.create(appModuleParam, provideCandidateDaoProvider, provideValidateUpdateCandidateCommentRequestProvider));
      this.provideValidateUpdateCandidateContactRequestProvider = DoubleCheck.provider(AppModule_ProvideValidateUpdateCandidateContactRequestFactory.create(appModuleParam));
      this.provideUpdateCandidateContactActivityProvider = DoubleCheck.provider(AppModule_ProvideUpdateCandidateContactActivityFactory.create(appModuleParam, provideCandidateDaoProvider, provideValidateUpdateCandidateContactRequestProvider));
      this.provideValidateUpdateCandidateDocumentRequestProvider = DoubleCheck.provider(AppModule_ProvideValidateUpdateCandidateDocumentRequestFactory.create(appModuleParam));
      this.provideUpdateCandidateDocumentActivityProvider = DoubleCheck.provider(AppModule_ProvideUpdateCandidateDocumentActivityFactory.create(appModuleParam, provideCandidateDaoProvider, provideValidateUpdateCandidateDocumentRequestProvider));
      this.provideValidateUpdateCandidateUnderProcessRequestProvider = DoubleCheck.provider(AppModule_ProvideValidateUpdateCandidateUnderProcessRequestFactory.create(appModuleParam));
      this.provideUpdateCandidateUnderProcessActivityProvider = DoubleCheck.provider(AppModule_ProvideUpdateCandidateUnderProcessActivityFactory.create(appModuleParam, provideCandidateDaoProvider, provideValidateUpdateCandidateUnderProcessRequestProvider));
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
      return provideGetByIdCandidateActivityProvider.get();
    }

    @Override
    public UpdateCandidateDetailsActivity updateCandidateDetailsActivity() {
      return provideUpdateCandidateDetailsActivityProvider.get();
    }

    @Override
    public UpdateCandidateAddressActivity updateCandidateAddressActivity() {
      return provideUpdateCandidateAddressActivityProvider.get();
    }

    @Override
    public UpdateCandidateCommentActivity updateCandidateCommentActivity() {
      return provideUpdateCandidateCommentActivityProvider.get();
    }

    @Override
    public UpdateCandidateContactActivity updateCandidateContactActivity() {
      return provideUpdateCandidateContactActivityProvider.get();
    }

    @Override
    public UpdateCandidateDocumentActivity updateCandidateDocumentActivity() {
      return provideUpdateCandidateDocumentActivityProvider.get();
    }

    @Override
    public UpdateCandidateUnderProcessActivity updateCandidateUnderProcessActivity() {
      return provideUpdateCandidateUnderProcessActivityProvider.get();
    }

    @Override
    public GetCandidateDetailsByIdActivity getCandidateDetailsByIdActivity() {
      return provideGetCandidateDetailsByIdActivityProvider.get();
    }
  }
}
