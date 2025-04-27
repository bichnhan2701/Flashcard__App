package com.example.flashlearn.di;

import com.example.flashlearn.data.remote.FirebaseRemoteDataSource;
import com.example.flashlearn.domain.repository.CategoryRepository;
import com.example.flashlearn.domain.repository.FlashcardRepository;
import com.example.flashlearn.domain.repository.MiniQuizRepository;
import com.example.flashlearn.domain.repository.SharedPreferencesRepository;
import com.example.flashlearn.domain.usecase.SyncAllDataUseCase;
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
    "KotlinInternalInJava",
    "cast"
})
public final class UseCaseModule_ProvideSyncAllDataUseCaseFactory implements Factory<SyncAllDataUseCase> {
  private final Provider<CategoryRepository> categoryRepositoryProvider;

  private final Provider<FlashcardRepository> flashcardRepositoryProvider;

  private final Provider<MiniQuizRepository> miniQuizRepositoryProvider;

  private final Provider<FirebaseRemoteDataSource> firebaseRemoteDataSourceProvider;

  private final Provider<SharedPreferencesRepository> sharedPreferencesRepositoryProvider;

  public UseCaseModule_ProvideSyncAllDataUseCaseFactory(
      Provider<CategoryRepository> categoryRepositoryProvider,
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
    return provideSyncAllDataUseCase(categoryRepositoryProvider.get(), flashcardRepositoryProvider.get(), miniQuizRepositoryProvider.get(), firebaseRemoteDataSourceProvider.get(), sharedPreferencesRepositoryProvider.get());
  }

  public static UseCaseModule_ProvideSyncAllDataUseCaseFactory create(
      Provider<CategoryRepository> categoryRepositoryProvider,
      Provider<FlashcardRepository> flashcardRepositoryProvider,
      Provider<MiniQuizRepository> miniQuizRepositoryProvider,
      Provider<FirebaseRemoteDataSource> firebaseRemoteDataSourceProvider,
      Provider<SharedPreferencesRepository> sharedPreferencesRepositoryProvider) {
    return new UseCaseModule_ProvideSyncAllDataUseCaseFactory(categoryRepositoryProvider, flashcardRepositoryProvider, miniQuizRepositoryProvider, firebaseRemoteDataSourceProvider, sharedPreferencesRepositoryProvider);
  }

  public static SyncAllDataUseCase provideSyncAllDataUseCase(CategoryRepository categoryRepository,
      FlashcardRepository flashcardRepository, MiniQuizRepository miniQuizRepository,
      FirebaseRemoteDataSource firebaseRemoteDataSource,
      SharedPreferencesRepository sharedPreferencesRepository) {
    return Preconditions.checkNotNullFromProvides(UseCaseModule.INSTANCE.provideSyncAllDataUseCase(categoryRepository, flashcardRepository, miniQuizRepository, firebaseRemoteDataSource, sharedPreferencesRepository));
  }
}
