package com.example.flashlearn.domain.usecase;

import com.example.flashlearn.data.remote.FirebaseRemoteDataSource;
import com.example.flashlearn.domain.repository.CategoryRepository;
import com.example.flashlearn.domain.repository.FlashcardRepository;
import com.example.flashlearn.domain.repository.MiniQuizRepository;
import com.example.flashlearn.domain.repository.SharedPreferencesRepository;
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
public final class SyncAllDataUseCase_Factory implements Factory<SyncAllDataUseCase> {
  private final Provider<CategoryRepository> categoryRepositoryProvider;

  private final Provider<FlashcardRepository> flashcardRepositoryProvider;

  private final Provider<MiniQuizRepository> miniQuizRepositoryProvider;

  private final Provider<FirebaseRemoteDataSource> firebaseRemoteDataSourceProvider;

  private final Provider<SharedPreferencesRepository> sharedPreferencesRepositoryProvider;

  public SyncAllDataUseCase_Factory(Provider<CategoryRepository> categoryRepositoryProvider,
      Provider<FlashcardRepository> flashcardRepositoryProvider,
      Provider<MiniQuizRepository> miniQuizRepositoryProvider,
      Provider<FirebaseRemoteDataSource> firebaseRemoteDataSourceProvider,
      Provider<SharedPreferencesRepository> sharedPreferencesRepositoryProvider) {
    this.categoryRepositoryProvider = categoryRepositoryProvider;
    this.flashcardRepositoryProvider = flashcardRepositoryProvider;
    this.miniQuizRepositoryProvider = miniQuizRepositoryProvider;
    this.firebaseRemoteDataSourceProvider = firebaseRemoteDataSourceProvider;
    this.sharedPreferencesRepositoryProvider = sharedPreferencesRepositoryProvider;
  }

  @Override
  public SyncAllDataUseCase get() {
    return newInstance(categoryRepositoryProvider.get(), flashcardRepositoryProvider.get(), miniQuizRepositoryProvider.get(), firebaseRemoteDataSourceProvider.get(), sharedPreferencesRepositoryProvider.get());
  }

  public static SyncAllDataUseCase_Factory create(
      Provider<CategoryRepository> categoryRepositoryProvider,
      Provider<FlashcardRepository> flashcardRepositoryProvider,
      Provider<MiniQuizRepository> miniQuizRepositoryProvider,
      Provider<FirebaseRemoteDataSource> firebaseRemoteDataSourceProvider,
      Provider<SharedPreferencesRepository> sharedPreferencesRepositoryProvider) {
    return new SyncAllDataUseCase_Factory(categoryRepositoryProvider, flashcardRepositoryProvider, miniQuizRepositoryProvider, firebaseRemoteDataSourceProvider, sharedPreferencesRepositoryProvider);
  }

  public static SyncAllDataUseCase newInstance(CategoryRepository categoryRepository,
      FlashcardRepository flashcardRepository, MiniQuizRepository miniQuizRepository,
      FirebaseRemoteDataSource firebaseRemoteDataSource,
      SharedPreferencesRepository sharedPreferencesRepository) {
    return new SyncAllDataUseCase(categoryRepository, flashcardRepository, miniQuizRepository, firebaseRemoteDataSource, sharedPreferencesRepository);
  }
}
