package com.example.flashlearn.domain.usecase;

import com.example.flashlearn.domain.repository.CategoryRepository;
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
public final class GetAllCategoriesUseCase_Factory implements Factory<GetAllCategoriesUseCase> {
  private final Provider<CategoryRepository> repositoryProvider;

  public GetAllCategoriesUseCase_Factory(Provider<CategoryRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetAllCategoriesUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetAllCategoriesUseCase_Factory create(
      Provider<CategoryRepository> repositoryProvider) {
    return new GetAllCategoriesUseCase_Factory(repositoryProvider);
  }

  public static GetAllCategoriesUseCase newInstance(CategoryRepository repository) {
    return new GetAllCategoriesUseCase(repository);
  }
}
