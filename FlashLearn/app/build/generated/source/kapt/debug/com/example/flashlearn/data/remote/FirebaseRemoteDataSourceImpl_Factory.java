package com.example.flashlearn.data.remote;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
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
public final class FirebaseRemoteDataSourceImpl_Factory implements Factory<FirebaseRemoteDataSourceImpl> {
  private final Provider<DatabaseReference> databaseProvider;

  private final Provider<FirebaseAuth> authProvider;

  public FirebaseRemoteDataSourceImpl_Factory(Provider<DatabaseReference> databaseProvider,
      Provider<FirebaseAuth> authProvider) {
    this.databaseProvider = databaseProvider;
    this.authProvider = authProvider;
  }

  @Override
  public FirebaseRemoteDataSourceImpl get() {
    return newInstance(databaseProvider.get(), authProvider.get());
  }

  public static FirebaseRemoteDataSourceImpl_Factory create(
      Provider<DatabaseReference> databaseProvider, Provider<FirebaseAuth> authProvider) {
    return new FirebaseRemoteDataSourceImpl_Factory(databaseProvider, authProvider);
  }

  public static FirebaseRemoteDataSourceImpl newInstance(DatabaseReference database,
      FirebaseAuth auth) {
    return new FirebaseRemoteDataSourceImpl(database, auth);
  }
}
