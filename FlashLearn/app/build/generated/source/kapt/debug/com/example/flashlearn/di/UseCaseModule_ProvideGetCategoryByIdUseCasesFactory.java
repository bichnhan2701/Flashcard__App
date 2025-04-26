package com.example.flashlearn.di;

import com.example.flashlearn.domain.repository.CategoryRepository;
import com.example.flashlearn.domain.usecase.GetCategoryByIdUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class UseCaseModule_ProvideGetCategoryByIdUseCasesFactory implements Factory<GetCategoryByIdUseCase> {
  private final Provider<CategoryRepository> repositoryProvider;

  public UseCaseModule_ProvideGetCategoryByIdUseCasesFactory(
      Provider<CategoryRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetCategoryByIdUseCase get() {
    return provideGetCategoryByIdUseCases(repositoryProvider.get());
  }

  public static UseCaseModule_ProvideGetCategoryByIdUseCasesFactory create(
      Provider<CategoryRepository> repositoryProvider) {
    return new UseCaseModule_ProvideGetCategoryByIdUseCasesFactory(repositoryProvider);
  }

  public static GetCategoryByIdUseCase provideGetCategoryByIdUseCases(
      CategoryRepository repository) {
    return Preconditions.checkNotNullFromProvides(UseCaseModule.INSTANCE.provideGetCategoryByIdUseCases(repository));
  }
}
