package com.wazo.services.candidate.dagger;

import com.wazo.services.candidate.clients.DynamoDb;
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
public final class AppModule_ProvideDynamoDbFactory implements Factory<DynamoDb> {
  private final AppModule module;

  public AppModule_ProvideDynamoDbFactory(AppModule module) {
    this.module = module;
  }

  @Override
  public DynamoDb get() {
    return provideDynamoDb(module);
  }

  public static AppModule_ProvideDynamoDbFactory create(AppModule module) {
    return new AppModule_ProvideDynamoDbFactory(module);
  }

  public static DynamoDb provideDynamoDb(AppModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.provideDynamoDb());
  }
}
