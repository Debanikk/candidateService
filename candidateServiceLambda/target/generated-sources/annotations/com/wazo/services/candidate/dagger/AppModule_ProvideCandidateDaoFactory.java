package com.wazo.services.candidate.dagger;

import com.wazo.services.candidate.ConfigurationServiceClient.impl.ConfigurationRestClientImpl;
import com.wazo.services.candidate.clients.DynamoDb;
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
public final class AppModule_ProvideCandidateDaoFactory implements Factory<CandidateDao> {
  private final AppModule module;

  private final Provider<DynamoDb> dynamoDbProvider;

  private final Provider<ConfigurationRestClientImpl> configurationRestClientProvider;

  public AppModule_ProvideCandidateDaoFactory(AppModule module, Provider<DynamoDb> dynamoDbProvider,
      Provider<ConfigurationRestClientImpl> configurationRestClientProvider) {
    this.module = module;
    this.dynamoDbProvider = dynamoDbProvider;
    this.configurationRestClientProvider = configurationRestClientProvider;
  }

  @Override
  public CandidateDao get() {
    return provideCandidateDao(module, dynamoDbProvider.get(), configurationRestClientProvider.get());
  }

  public static AppModule_ProvideCandidateDaoFactory create(AppModule module,
      Provider<DynamoDb> dynamoDbProvider,
      Provider<ConfigurationRestClientImpl> configurationRestClientProvider) {
    return new AppModule_ProvideCandidateDaoFactory(module, dynamoDbProvider, configurationRestClientProvider);
  }

  public static CandidateDao provideCandidateDao(AppModule instance, DynamoDb dynamoDb,
      ConfigurationRestClientImpl configurationRestClient) {
    return Preconditions.checkNotNullFromProvides(instance.provideCandidateDao(dynamoDb, configurationRestClient));
  }
}
