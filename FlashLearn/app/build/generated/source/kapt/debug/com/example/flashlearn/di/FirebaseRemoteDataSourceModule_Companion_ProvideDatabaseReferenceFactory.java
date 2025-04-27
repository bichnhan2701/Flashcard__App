package com.example.flashlearn.di;

import com.google.firebase.database.DatabaseReference;
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
    "KotlinInternalInJava",
    "cast"
})
public final class FirebaseRemoteDataSourceModule_Companion_ProvideDatabaseReferenceFactory implements Factory<DatabaseReference> {
  @Override
  public DatabaseReference get() {
    return provideDatabaseReference();
  }

  public static FirebaseRemoteDataSourceModule_Companion_ProvideDatabaseReferenceFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static DatabaseReference provideDatabaseReference() {
    return Preconditions.checkNotNullFromProvides(FirebaseRemoteDataSourceModule.Companion.provideDatabaseReference());
  }

  private static final class InstanceHolder {
    private static final FirebaseRemoteDataSourceModule_Companion_ProvideDatabaseReferenceFactory INSTANCE = new FirebaseRemoteDataSourceModule_Companion_ProvideDatabaseReferenceFactory();
  }
}
