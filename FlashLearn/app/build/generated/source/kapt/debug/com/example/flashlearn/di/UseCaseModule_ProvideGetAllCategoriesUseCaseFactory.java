package com.example.flashlearn.di;

import com.example.flashlearn.domain.repository.CategoryRepository;
import com.example.flashlearn.domain.usecase.GetAllCategoriesUseCase;
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
public final class UseCaseModule_ProvideGetAllCategoriesUseCaseFactory implements Factory<GetAllCategoriesUseCase> {
  private final Provider<CategoryRepository> repositoryProvider;

  public UseCaseModule_ProvideGetAllCategoriesUseCaseFactory(
      Provider<CategoryRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetAllCategoriesUseCase get() {
    return provideGetAllCategoriesUseCase(repositoryProvider.get());
  }

  public static UseCaseModule_ProvideGetAllCategoriesUseCaseFactory create(
      Provider<CategoryRepository> repositoryProvider) {
    return new UseCaseModule_ProvideGetAllCategoriesUseCaseFactory(repositoryProvider);
  }

  public static GetAllCategoriesUseCase provideGetAllCategoriesUseCase(
      CategoryRepository repository) {
    return Preconditions.checkNotNullFromProvides(UseCaseModule.INSTANCE.provideGetAllCategoriesUseCase(repository));
  }
}
