package com.example.flashlearn.di;

import com.example.flashlearn.domain.repository.CategoryRepository;
import com.example.flashlearn.domain.usecase.CreateCategoryUseCase;
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
public final class UseCaseModule_ProvideCreateCategoryUseCaseFactory implements Factory<CreateCategoryUseCase> {
  private final Provider<CategoryRepository> repositoryProvider;

  public UseCaseModule_ProvideCreateCategoryUseCaseFactory(
      Provider<CategoryRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public CreateCategoryUseCase get() {
    return provideCreateCategoryUseCase(repositoryProvider.get());
  }

  public static UseCaseModule_ProvideCreateCategoryUseCaseFactory create(
      Provider<CategoryRepository> repositoryProvider) {
    return new UseCaseModule_ProvideCreateCategoryUseCaseFactory(repositoryProvider);
  }

  public static CreateCategoryUseCase provideCreateCategoryUseCase(CategoryRepository repository) {
    return Preconditions.checkNotNullFromProvides(UseCaseModule.INSTANCE.provideCreateCategoryUseCase(repository));
  }
}
