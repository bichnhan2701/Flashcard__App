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
public final class CreateCategoryUseCase_Factory implements Factory<CreateCategoryUseCase> {
  private final Provider<CategoryRepository> repositoryProvider;

  public CreateCategoryUseCase_Factory(Provider<CategoryRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public CreateCategoryUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static CreateCategoryUseCase_Factory create(
      Provider<CategoryRepository> repositoryProvider) {
    return new CreateCategoryUseCase_Factory(repositoryProvider);
  }

  public static CreateCategoryUseCase newInstance(CategoryRepository repository) {
    return new CreateCategoryUseCase(repository);
  }
}
