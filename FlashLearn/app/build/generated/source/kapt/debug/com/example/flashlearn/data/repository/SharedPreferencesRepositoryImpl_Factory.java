package com.example.flashlearn.data.repository;

import android.content.SharedPreferences;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
    "KotlinInternalInJava",
    "cast"
})
public final class SharedPreferencesRepositoryImpl_Factory implements Factory<SharedPreferencesRepositoryImpl> {
  private final Provider<SharedPreferences> sharedPreferencesProvider;

  public SharedPreferencesRepositoryImpl_Factory(
      Provider<SharedPreferences> sharedPreferencesProvider) {
    this.sharedPreferencesProvider = sharedPreferencesProvider;
  }

  @Override
  public SharedPreferencesRepositoryImpl get() {
    return newInstance(sharedPreferencesProvider.get());
  }

  public static SharedPreferencesRepositoryImpl_Factory create(
      Provider<SharedPreferences> sharedPreferencesProvider) {
    return new SharedPreferencesRepositoryImpl_Factory(sharedPreferencesProvider);
  }

  public static SharedPreferencesRepositoryImpl newInstance(SharedPreferences sharedPreferences) {
    return new SharedPreferencesRepositoryImpl(sharedPreferences);
  }
}
