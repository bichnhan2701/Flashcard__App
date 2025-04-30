package com.example.flashlearn;

import android.app.Activity;
import android.app.Service;
import android.content.SharedPreferences;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.example.flashlearn.data.local.AppDatabase;
import com.example.flashlearn.data.local.dao.CategoryDao;
import com.example.flashlearn.data.local.dao.FlashcardDao;
import com.example.flashlearn.data.local.dao.MiniQuizResultDao;
import com.example.flashlearn.data.remote.FirebaseRemoteDataSource;
import com.example.flashlearn.data.remote.FirebaseRemoteDataSourceImpl;
import com.example.flashlearn.data.repository.CategoryRepositoryImpl;
import com.example.flashlearn.data.repository.FlashcardRepositoryImpl;
import com.example.flashlearn.data.repository.MiniQuizRepositoryImpl;
import com.example.flashlearn.data.repository.SharedPreferencesRepositoryImpl;
import com.example.flashlearn.di.AuthModule_ProvideAuthRepositoryFactory;
import com.example.flashlearn.di.AuthModule_ProvideFirebaseAuthFactory;
import com.example.flashlearn.di.DatabaseModule_ProvideCategoryDaoFactory;
import com.example.flashlearn.di.DatabaseModule_ProvideDatabaseFactory;
import com.example.flashlearn.di.DatabaseModule_ProvideFlashcardDaoFactory;
import com.example.flashlearn.di.DatabaseModule_ProvideMiniQuizDaoFactory;
import com.example.flashlearn.di.DatabaseModule_ProvideSharedPreferencesFactory;
import com.example.flashlearn.di.FirebaseRemoteDataSourceModule_Companion_ProvideDatabaseReferenceFactory;
import com.example.flashlearn.di.NetworkModule_ProvideNetworkObserverFactory;
import com.example.flashlearn.di.UseCaseModule_ProvideCreateCategoryUseCaseFactory;
import com.example.flashlearn.di.UseCaseModule_ProvideDeleteFolderWithFlashcardsUseCaseFactory;
import com.example.flashlearn.di.UseCaseModule_ProvideFlashcardUseCasesFactory;
import com.example.flashlearn.di.UseCaseModule_ProvideGenerateMiniQuizQuestionsUseCaseFactory;
import com.example.flashlearn.di.UseCaseModule_ProvideGetAllCategoriesProgressUseCaseFactory;
import com.example.flashlearn.di.UseCaseModule_ProvideGetAllCategoriesUseCaseFactory;
import com.example.flashlearn.di.UseCaseModule_ProvideGetAllQuizResultsUseCaseFactory;
import com.example.flashlearn.di.UseCaseModule_ProvideGetCategoryByIdUseCasesFactory;
import com.example.flashlearn.di.UseCaseModule_ProvideGetFolderWithFlashcardsUseCaseFactory;
import com.example.flashlearn.di.UseCaseModule_ProvideGetQuizResultsBetweenUseCaseFactory;
import com.example.flashlearn.di.UseCaseModule_ProvideLoginWithGoogleUseCaseFactory;
import com.example.flashlearn.di.UseCaseModule_ProvideLogoutUseCaseFactory;
import com.example.flashlearn.di.UseCaseModule_ProvideSaveMiniQuizResultUseCaseFactory;
import com.example.flashlearn.di.UseCaseModule_ProvideSyncAllDataUseCaseFactory;
import com.example.flashlearn.di.UseCaseModule_ProvideUpdateFolderWithFlashcardsUseCaseFactory;
import com.example.flashlearn.domain.repository.AuthRepository;
import com.example.flashlearn.domain.repository.CategoryRepository;
import com.example.flashlearn.domain.repository.MiniQuizRepository;
import com.example.flashlearn.domain.repository.SharedPreferencesRepository;
import com.example.flashlearn.domain.usecase.CreateCategoryUseCase;
import com.example.flashlearn.domain.usecase.DeleteCategoryWithFlashcardsUseCase;
import com.example.flashlearn.domain.usecase.DeleteFlashcardUseCase;
import com.example.flashlearn.domain.usecase.FlashcardUseCases;
import com.example.flashlearn.domain.usecase.GenerateMiniQuizQuestionsUseCase;
import com.example.flashlearn.domain.usecase.GetAllCategoriesProgressUseCase;
import com.example.flashlearn.domain.usecase.GetAllCategoriesUseCase;
import com.example.flashlearn.domain.usecase.GetAllQuizResultsUseCase;
import com.example.flashlearn.domain.usecase.GetCategoryByIdUseCase;
import com.example.flashlearn.domain.usecase.GetCategoryWithFlashcardsUseCase;
import com.example.flashlearn.domain.usecase.GetFlashcardsByCategoryUseCase;
import com.example.flashlearn.domain.usecase.GetQuizResultsBetweenUseCase;
import com.example.flashlearn.domain.usecase.InsertFlashcardsUseCase;
import com.example.flashlearn.domain.usecase.LoginWithGoogleUseCase;
import com.example.flashlearn.domain.usecase.LogoutUseCase;
import com.example.flashlearn.domain.usecase.SaveMiniQuizResultUseCase;
import com.example.flashlearn.domain.usecase.SyncAllDataUseCase;
import com.example.flashlearn.domain.usecase.UpdateCategoryWithFlashcardsUseCase;
import com.example.flashlearn.domain.usecase.UpdateFlashcardUseCase;
import com.example.flashlearn.ui.network.NetworkObserver;
import com.example.flashlearn.ui.viewmodel.AddFolderViewModel;
import com.example.flashlearn.ui.viewmodel.AddFolderViewModel_HiltModules;
import com.example.flashlearn.ui.viewmodel.AuthViewModel;
import com.example.flashlearn.ui.viewmodel.AuthViewModel_HiltModules;
import com.example.flashlearn.ui.viewmodel.CategoryDetailViewModel;
import com.example.flashlearn.ui.viewmodel.CategoryDetailViewModel_HiltModules;
import com.example.flashlearn.ui.viewmodel.EditFolderDetailViewModel;
import com.example.flashlearn.ui.viewmodel.EditFolderDetailViewModel_HiltModules;
import com.example.flashlearn.ui.viewmodel.FlashcardFormViewModel;
import com.example.flashlearn.ui.viewmodel.FlashcardFormViewModel_HiltModules;
import com.example.flashlearn.ui.viewmodel.FlashcardReviewViewModel;
import com.example.flashlearn.ui.viewmodel.FlashcardReviewViewModel_HiltModules;
import com.example.flashlearn.ui.viewmodel.HomeViewModel;
import com.example.flashlearn.ui.viewmodel.HomeViewModel_HiltModules;
import com.example.flashlearn.ui.viewmodel.MiniQuizViewModel;
import com.example.flashlearn.ui.viewmodel.MiniQuizViewModel_HiltModules;
import com.example.flashlearn.ui.viewmodel.ProgressViewModel;
import com.example.flashlearn.ui.viewmodel.ProgressViewModel_HiltModules;
import com.google.firebase.database.DatabaseReference;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory;
import dagger.hilt.android.internal.managers.SavedStateHandleHolder;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideApplicationFactory;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.IdentifierNameString;
import dagger.internal.KeepFieldType;
import dagger.internal.LazyClassKeyMap;
import dagger.internal.MapBuilder;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

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
public final class DaggerFlashLearnApp_HiltComponents_SingletonC {
  private DaggerFlashLearnApp_HiltComponents_SingletonC() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private ApplicationContextModule applicationContextModule;

    private Builder() {
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    public FlashLearnApp_HiltComponents.SingletonC build() {
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      return new SingletonCImpl(applicationContextModule);
    }
  }

  private static final class ActivityRetainedCBuilder implements FlashLearnApp_HiltComponents.ActivityRetainedC.Builder {
    private final SingletonCImpl singletonCImpl;

    private SavedStateHandleHolder savedStateHandleHolder;

    private ActivityRetainedCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ActivityRetainedCBuilder savedStateHandleHolder(
        SavedStateHandleHolder savedStateHandleHolder) {
      this.savedStateHandleHolder = Preconditions.checkNotNull(savedStateHandleHolder);
      return this;
    }

    @Override
    public FlashLearnApp_HiltComponents.ActivityRetainedC build() {
      Preconditions.checkBuilderRequirement(savedStateHandleHolder, SavedStateHandleHolder.class);
      return new ActivityRetainedCImpl(singletonCImpl, savedStateHandleHolder);
    }
  }

  private static final class ActivityCBuilder implements FlashLearnApp_HiltComponents.ActivityC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private Activity activity;

    private ActivityCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ActivityCBuilder activity(Activity activity) {
      this.activity = Preconditions.checkNotNull(activity);
      return this;
    }

    @Override
    public FlashLearnApp_HiltComponents.ActivityC build() {
      Preconditions.checkBuilderRequirement(activity, Activity.class);
      return new ActivityCImpl(singletonCImpl, activityRetainedCImpl, activity);
    }
  }

  private static final class FragmentCBuilder implements FlashLearnApp_HiltComponents.FragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private Fragment fragment;

    private FragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public FragmentCBuilder fragment(Fragment fragment) {
      this.fragment = Preconditions.checkNotNull(fragment);
      return this;
    }

    @Override
    public FlashLearnApp_HiltComponents.FragmentC build() {
      Preconditions.checkBuilderRequirement(fragment, Fragment.class);
      return new FragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragment);
    }
  }

  private static final class ViewWithFragmentCBuilder implements FlashLearnApp_HiltComponents.ViewWithFragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private View view;

    private ViewWithFragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;
    }

    @Override
    public ViewWithFragmentCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public FlashLearnApp_HiltComponents.ViewWithFragmentC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewWithFragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl, view);
    }
  }

  private static final class ViewCBuilder implements FlashLearnApp_HiltComponents.ViewC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private View view;

    private ViewCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public ViewCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public FlashLearnApp_HiltComponents.ViewC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, view);
    }
  }

  private static final class ViewModelCBuilder implements FlashLearnApp_HiltComponents.ViewModelC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private SavedStateHandle savedStateHandle;

    private ViewModelLifecycle viewModelLifecycle;

    private ViewModelCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ViewModelCBuilder savedStateHandle(SavedStateHandle handle) {
      this.savedStateHandle = Preconditions.checkNotNull(handle);
      return this;
    }

    @Override
    public ViewModelCBuilder viewModelLifecycle(ViewModelLifecycle viewModelLifecycle) {
      this.viewModelLifecycle = Preconditions.checkNotNull(viewModelLifecycle);
      return this;
    }

    @Override
    public FlashLearnApp_HiltComponents.ViewModelC build() {
      Preconditions.checkBuilderRequirement(savedStateHandle, SavedStateHandle.class);
      Preconditions.checkBuilderRequirement(viewModelLifecycle, ViewModelLifecycle.class);
      return new ViewModelCImpl(singletonCImpl, activityRetainedCImpl, savedStateHandle, viewModelLifecycle);
    }
  }

  private static final class ServiceCBuilder implements FlashLearnApp_HiltComponents.ServiceC.Builder {
    private final SingletonCImpl singletonCImpl;

    private Service service;

    private ServiceCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public FlashLearnApp_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(singletonCImpl, service);
    }
  }

  private static final class ViewWithFragmentCImpl extends FlashLearnApp_HiltComponents.ViewWithFragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private final ViewWithFragmentCImpl viewWithFragmentCImpl = this;

    private ViewWithFragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;


    }
  }

  private static final class FragmentCImpl extends FlashLearnApp_HiltComponents.FragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl = this;

    private FragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        Fragment fragmentParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return activityCImpl.getHiltInternalFactoryFactory();
    }

    @Override
    public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
      return new ViewWithFragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl);
    }
  }

  private static final class ViewCImpl extends FlashLearnApp_HiltComponents.ViewC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final ViewCImpl viewCImpl = this;

    private ViewCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }
  }

  private static final class ActivityCImpl extends FlashLearnApp_HiltComponents.ActivityC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl = this;

    private ActivityCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, Activity activityParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;


    }

    @Override
    public void injectMainActivity(MainActivity mainActivity) {
    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(getViewModelKeys(), new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl));
    }

    @Override
    public Map<Class<?>, Boolean> getViewModelKeys() {
      return LazyClassKeyMap.<Boolean>of(MapBuilder.<String, Boolean>newMapBuilder(9).put(LazyClassKeyProvider.com_example_flashlearn_ui_viewmodel_AddFolderViewModel, AddFolderViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_example_flashlearn_ui_viewmodel_AuthViewModel, AuthViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_example_flashlearn_ui_viewmodel_CategoryDetailViewModel, CategoryDetailViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_example_flashlearn_ui_viewmodel_EditFolderDetailViewModel, EditFolderDetailViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_example_flashlearn_ui_viewmodel_FlashcardFormViewModel, FlashcardFormViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_example_flashlearn_ui_viewmodel_FlashcardReviewViewModel, FlashcardReviewViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_example_flashlearn_ui_viewmodel_HomeViewModel, HomeViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_example_flashlearn_ui_viewmodel_MiniQuizViewModel, MiniQuizViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_example_flashlearn_ui_viewmodel_ProgressViewModel, ProgressViewModel_HiltModules.KeyModule.provide()).build());
    }

    @Override
    public ViewModelComponentBuilder getViewModelComponentBuilder() {
      return new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public FragmentComponentBuilder fragmentComponentBuilder() {
      return new FragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @Override
    public ViewComponentBuilder viewComponentBuilder() {
      return new ViewCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @IdentifierNameString
    private static final class LazyClassKeyProvider {
      static String com_example_flashlearn_ui_viewmodel_FlashcardReviewViewModel = "com.example.flashlearn.ui.viewmodel.FlashcardReviewViewModel";

      static String com_example_flashlearn_ui_viewmodel_FlashcardFormViewModel = "com.example.flashlearn.ui.viewmodel.FlashcardFormViewModel";

      static String com_example_flashlearn_ui_viewmodel_CategoryDetailViewModel = "com.example.flashlearn.ui.viewmodel.CategoryDetailViewModel";

      static String com_example_flashlearn_ui_viewmodel_MiniQuizViewModel = "com.example.flashlearn.ui.viewmodel.MiniQuizViewModel";

      static String com_example_flashlearn_ui_viewmodel_HomeViewModel = "com.example.flashlearn.ui.viewmodel.HomeViewModel";

      static String com_example_flashlearn_ui_viewmodel_AddFolderViewModel = "com.example.flashlearn.ui.viewmodel.AddFolderViewModel";

      static String com_example_flashlearn_ui_viewmodel_AuthViewModel = "com.example.flashlearn.ui.viewmodel.AuthViewModel";

      static String com_example_flashlearn_ui_viewmodel_ProgressViewModel = "com.example.flashlearn.ui.viewmodel.ProgressViewModel";

      static String com_example_flashlearn_ui_viewmodel_EditFolderDetailViewModel = "com.example.flashlearn.ui.viewmodel.EditFolderDetailViewModel";

      @KeepFieldType
      FlashcardReviewViewModel com_example_flashlearn_ui_viewmodel_FlashcardReviewViewModel2;

      @KeepFieldType
      FlashcardFormViewModel com_example_flashlearn_ui_viewmodel_FlashcardFormViewModel2;

      @KeepFieldType
      CategoryDetailViewModel com_example_flashlearn_ui_viewmodel_CategoryDetailViewModel2;

      @KeepFieldType
      MiniQuizViewModel com_example_flashlearn_ui_viewmodel_MiniQuizViewModel2;

      @KeepFieldType
      HomeViewModel com_example_flashlearn_ui_viewmodel_HomeViewModel2;

      @KeepFieldType
      AddFolderViewModel com_example_flashlearn_ui_viewmodel_AddFolderViewModel2;

      @KeepFieldType
      AuthViewModel com_example_flashlearn_ui_viewmodel_AuthViewModel2;

      @KeepFieldType
      ProgressViewModel com_example_flashlearn_ui_viewmodel_ProgressViewModel2;

      @KeepFieldType
      EditFolderDetailViewModel com_example_flashlearn_ui_viewmodel_EditFolderDetailViewModel2;
    }
  }

  private static final class ViewModelCImpl extends FlashLearnApp_HiltComponents.ViewModelC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ViewModelCImpl viewModelCImpl = this;

    private Provider<AddFolderViewModel> addFolderViewModelProvider;

    private Provider<AuthViewModel> authViewModelProvider;

    private Provider<CategoryDetailViewModel> categoryDetailViewModelProvider;

    private Provider<EditFolderDetailViewModel> editFolderDetailViewModelProvider;

    private Provider<FlashcardFormViewModel> flashcardFormViewModelProvider;

    private Provider<FlashcardReviewViewModel> flashcardReviewViewModelProvider;

    private Provider<HomeViewModel> homeViewModelProvider;

    private Provider<MiniQuizViewModel> miniQuizViewModelProvider;

    private Provider<ProgressViewModel> progressViewModelProvider;

    private ViewModelCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, SavedStateHandle savedStateHandleParam,
        ViewModelLifecycle viewModelLifecycleParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;

      initialize(savedStateHandleParam, viewModelLifecycleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandle savedStateHandleParam,
        final ViewModelLifecycle viewModelLifecycleParam) {
      this.addFolderViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 0);
      this.authViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 1);
      this.categoryDetailViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 2);
      this.editFolderDetailViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 3);
      this.flashcardFormViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 4);
      this.flashcardReviewViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 5);
      this.homeViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 6);
      this.miniQuizViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 7);
      this.progressViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 8);
    }

    @Override
    public Map<Class<?>, javax.inject.Provider<ViewModel>> getHiltViewModelMap() {
      return LazyClassKeyMap.<javax.inject.Provider<ViewModel>>of(MapBuilder.<String, javax.inject.Provider<ViewModel>>newMapBuilder(9).put(LazyClassKeyProvider.com_example_flashlearn_ui_viewmodel_AddFolderViewModel, ((Provider) addFolderViewModelProvider)).put(LazyClassKeyProvider.com_example_flashlearn_ui_viewmodel_AuthViewModel, ((Provider) authViewModelProvider)).put(LazyClassKeyProvider.com_example_flashlearn_ui_viewmodel_CategoryDetailViewModel, ((Provider) categoryDetailViewModelProvider)).put(LazyClassKeyProvider.com_example_flashlearn_ui_viewmodel_EditFolderDetailViewModel, ((Provider) editFolderDetailViewModelProvider)).put(LazyClassKeyProvider.com_example_flashlearn_ui_viewmodel_FlashcardFormViewModel, ((Provider) flashcardFormViewModelProvider)).put(LazyClassKeyProvider.com_example_flashlearn_ui_viewmodel_FlashcardReviewViewModel, ((Provider) flashcardReviewViewModelProvider)).put(LazyClassKeyProvider.com_example_flashlearn_ui_viewmodel_HomeViewModel, ((Provider) homeViewModelProvider)).put(LazyClassKeyProvider.com_example_flashlearn_ui_viewmodel_MiniQuizViewModel, ((Provider) miniQuizViewModelProvider)).put(LazyClassKeyProvider.com_example_flashlearn_ui_viewmodel_ProgressViewModel, ((Provider) progressViewModelProvider)).build());
    }

    @Override
    public Map<Class<?>, Object> getHiltViewModelAssistedMap() {
      return Collections.<Class<?>, Object>emptyMap();
    }

    @IdentifierNameString
    private static final class LazyClassKeyProvider {
      static String com_example_flashlearn_ui_viewmodel_AuthViewModel = "com.example.flashlearn.ui.viewmodel.AuthViewModel";

      static String com_example_flashlearn_ui_viewmodel_MiniQuizViewModel = "com.example.flashlearn.ui.viewmodel.MiniQuizViewModel";

      static String com_example_flashlearn_ui_viewmodel_FlashcardFormViewModel = "com.example.flashlearn.ui.viewmodel.FlashcardFormViewModel";

      static String com_example_flashlearn_ui_viewmodel_HomeViewModel = "com.example.flashlearn.ui.viewmodel.HomeViewModel";

      static String com_example_flashlearn_ui_viewmodel_AddFolderViewModel = "com.example.flashlearn.ui.viewmodel.AddFolderViewModel";

      static String com_example_flashlearn_ui_viewmodel_EditFolderDetailViewModel = "com.example.flashlearn.ui.viewmodel.EditFolderDetailViewModel";

      static String com_example_flashlearn_ui_viewmodel_FlashcardReviewViewModel = "com.example.flashlearn.ui.viewmodel.FlashcardReviewViewModel";

      static String com_example_flashlearn_ui_viewmodel_CategoryDetailViewModel = "com.example.flashlearn.ui.viewmodel.CategoryDetailViewModel";

      static String com_example_flashlearn_ui_viewmodel_ProgressViewModel = "com.example.flashlearn.ui.viewmodel.ProgressViewModel";

      @KeepFieldType
      AuthViewModel com_example_flashlearn_ui_viewmodel_AuthViewModel2;

      @KeepFieldType
      MiniQuizViewModel com_example_flashlearn_ui_viewmodel_MiniQuizViewModel2;

      @KeepFieldType
      FlashcardFormViewModel com_example_flashlearn_ui_viewmodel_FlashcardFormViewModel2;

      @KeepFieldType
      HomeViewModel com_example_flashlearn_ui_viewmodel_HomeViewModel2;

      @KeepFieldType
      AddFolderViewModel com_example_flashlearn_ui_viewmodel_AddFolderViewModel2;

      @KeepFieldType
      EditFolderDetailViewModel com_example_flashlearn_ui_viewmodel_EditFolderDetailViewModel2;

      @KeepFieldType
      FlashcardReviewViewModel com_example_flashlearn_ui_viewmodel_FlashcardReviewViewModel2;

      @KeepFieldType
      CategoryDetailViewModel com_example_flashlearn_ui_viewmodel_CategoryDetailViewModel2;

      @KeepFieldType
      ProgressViewModel com_example_flashlearn_ui_viewmodel_ProgressViewModel2;
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final ViewModelCImpl viewModelCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          ViewModelCImpl viewModelCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.viewModelCImpl = viewModelCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.example.flashlearn.ui.viewmodel.AddFolderViewModel 
          return (T) new AddFolderViewModel(singletonCImpl.provideCreateCategoryUseCaseProvider.get(), singletonCImpl.provideSyncAllDataUseCaseProvider.get());

          case 1: // com.example.flashlearn.ui.viewmodel.AuthViewModel 
          return (T) new AuthViewModel(singletonCImpl.provideLoginWithGoogleUseCaseProvider.get(), singletonCImpl.provideLogoutUseCaseProvider.get(), singletonCImpl.provideSyncAllDataUseCaseProvider.get());

          case 2: // com.example.flashlearn.ui.viewmodel.CategoryDetailViewModel 
          return (T) new CategoryDetailViewModel(singletonCImpl.provideFlashcardUseCasesProvider.get(), singletonCImpl.getCategoryByIdUseCase(), singletonCImpl.provideSyncAllDataUseCaseProvider.get());

          case 3: // com.example.flashlearn.ui.viewmodel.EditFolderDetailViewModel 
          return (T) new EditFolderDetailViewModel(singletonCImpl.provideGetFolderWithFlashcardsUseCaseProvider.get(), singletonCImpl.provideUpdateFolderWithFlashcardsUseCaseProvider.get(), singletonCImpl.provideDeleteFolderWithFlashcardsUseCaseProvider.get(), singletonCImpl.provideSyncAllDataUseCaseProvider.get());

          case 4: // com.example.flashlearn.ui.viewmodel.FlashcardFormViewModel 
          return (T) new FlashcardFormViewModel();

          case 5: // com.example.flashlearn.ui.viewmodel.FlashcardReviewViewModel 
          return (T) new FlashcardReviewViewModel(ApplicationContextModule_ProvideApplicationFactory.provideApplication(singletonCImpl.applicationContextModule), singletonCImpl.provideFlashcardUseCasesProvider.get(), singletonCImpl.getCategoryByIdUseCase());

          case 6: // com.example.flashlearn.ui.viewmodel.HomeViewModel 
          return (T) new HomeViewModel(singletonCImpl.provideGetAllCategoriesUseCaseProvider.get(), singletonCImpl.provideSyncAllDataUseCaseProvider.get(), singletonCImpl.provideNetworkObserverProvider.get());

          case 7: // com.example.flashlearn.ui.viewmodel.MiniQuizViewModel 
          return (T) new MiniQuizViewModel(singletonCImpl.getFlashcardsByCategoryUseCase(), singletonCImpl.provideGenerateMiniQuizQuestionsUseCaseProvider.get(), singletonCImpl.provideSaveMiniQuizResultUseCaseProvider.get(), singletonCImpl.getCategoryByIdUseCase(), singletonCImpl.provideSyncAllDataUseCaseProvider.get(), singletonCImpl.provideNetworkObserverProvider.get());

          case 8: // com.example.flashlearn.ui.viewmodel.ProgressViewModel 
          return (T) new ProgressViewModel(singletonCImpl.provideGetAllQuizResultsUseCaseProvider.get(), singletonCImpl.provideGetQuizResultsBetweenUseCaseProvider.get(), singletonCImpl.provideGetAllCategoriesProgressUseCaseProvider.get(), singletonCImpl.provideSyncAllDataUseCaseProvider.get(), singletonCImpl.provideNetworkObserverProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ActivityRetainedCImpl extends FlashLearnApp_HiltComponents.ActivityRetainedC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl = this;

    private Provider<ActivityRetainedLifecycle> provideActivityRetainedLifecycleProvider;

    private ActivityRetainedCImpl(SingletonCImpl singletonCImpl,
        SavedStateHandleHolder savedStateHandleHolderParam) {
      this.singletonCImpl = singletonCImpl;

      initialize(savedStateHandleHolderParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandleHolder savedStateHandleHolderParam) {
      this.provideActivityRetainedLifecycleProvider = DoubleCheck.provider(new SwitchingProvider<ActivityRetainedLifecycle>(singletonCImpl, activityRetainedCImpl, 0));
    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
      return provideActivityRetainedLifecycleProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // dagger.hilt.android.ActivityRetainedLifecycle 
          return (T) ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory.provideActivityRetainedLifecycle();

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ServiceCImpl extends FlashLearnApp_HiltComponents.ServiceC {
    private final SingletonCImpl singletonCImpl;

    private final ServiceCImpl serviceCImpl = this;

    private ServiceCImpl(SingletonCImpl singletonCImpl, Service serviceParam) {
      this.singletonCImpl = singletonCImpl;


    }
  }

  private static final class SingletonCImpl extends FlashLearnApp_HiltComponents.SingletonC {
    private final ApplicationContextModule applicationContextModule;

    private final SingletonCImpl singletonCImpl = this;

    private Provider<AppDatabase> provideDatabaseProvider;

    private Provider<CategoryDao> provideCategoryDaoProvider;

    private Provider<FlashcardDao> provideFlashcardDaoProvider;

    private Provider<CategoryRepositoryImpl> categoryRepositoryImplProvider;

    private Provider<CategoryRepository> bindCategoryRepositoryProvider;

    private Provider<CreateCategoryUseCase> provideCreateCategoryUseCaseProvider;

    private Provider<MiniQuizResultDao> provideMiniQuizDaoProvider;

    private Provider<MiniQuizRepositoryImpl> miniQuizRepositoryImplProvider;

    private Provider<MiniQuizRepository> bindMiniQuizRepositoryProvider;

    private Provider<DatabaseReference> provideDatabaseReferenceProvider;

    private Provider<FirebaseRemoteDataSourceImpl> firebaseRemoteDataSourceImplProvider;

    private Provider<FirebaseRemoteDataSource> bindFirebaseRemoteDataSourceProvider;

    private Provider<SharedPreferences> provideSharedPreferencesProvider;

    private Provider<SharedPreferencesRepositoryImpl> sharedPreferencesRepositoryImplProvider;

    private Provider<SharedPreferencesRepository> bindSharedPreferencesRepositoryProvider;

    private Provider<SyncAllDataUseCase> provideSyncAllDataUseCaseProvider;

    private Provider<LoginWithGoogleUseCase> provideLoginWithGoogleUseCaseProvider;

    private Provider<LogoutUseCase> provideLogoutUseCaseProvider;

    private Provider<FlashcardUseCases> provideFlashcardUseCasesProvider;

    private Provider<GetCategoryWithFlashcardsUseCase> provideGetFolderWithFlashcardsUseCaseProvider;

    private Provider<UpdateCategoryWithFlashcardsUseCase> provideUpdateFolderWithFlashcardsUseCaseProvider;

    private Provider<DeleteCategoryWithFlashcardsUseCase> provideDeleteFolderWithFlashcardsUseCaseProvider;

    private Provider<GetAllCategoriesUseCase> provideGetAllCategoriesUseCaseProvider;

    private Provider<NetworkObserver> provideNetworkObserverProvider;

    private Provider<GenerateMiniQuizQuestionsUseCase> provideGenerateMiniQuizQuestionsUseCaseProvider;

    private Provider<SaveMiniQuizResultUseCase> provideSaveMiniQuizResultUseCaseProvider;

    private Provider<GetAllQuizResultsUseCase> provideGetAllQuizResultsUseCaseProvider;

    private Provider<GetQuizResultsBetweenUseCase> provideGetQuizResultsBetweenUseCaseProvider;

    private Provider<GetAllCategoriesProgressUseCase> provideGetAllCategoriesProgressUseCaseProvider;

    private SingletonCImpl(ApplicationContextModule applicationContextModuleParam) {
      this.applicationContextModule = applicationContextModuleParam;
      initialize(applicationContextModuleParam);

    }

    private FlashcardRepositoryImpl flashcardRepositoryImpl() {
      return new FlashcardRepositoryImpl(provideFlashcardDaoProvider.get());
    }

    private AuthRepository authRepository() {
      return AuthModule_ProvideAuthRepositoryFactory.provideAuthRepository(AuthModule_ProvideFirebaseAuthFactory.provideFirebaseAuth());
    }

    private InsertFlashcardsUseCase insertFlashcardsUseCase() {
      return new InsertFlashcardsUseCase(flashcardRepositoryImpl());
    }

    private GetFlashcardsByCategoryUseCase getFlashcardsByCategoryUseCase() {
      return new GetFlashcardsByCategoryUseCase(flashcardRepositoryImpl());
    }

    private DeleteFlashcardUseCase deleteFlashcardUseCase() {
      return new DeleteFlashcardUseCase(flashcardRepositoryImpl());
    }

    private UpdateFlashcardUseCase updateFlashcardUseCase() {
      return new UpdateFlashcardUseCase(flashcardRepositoryImpl());
    }

    private GetCategoryByIdUseCase getCategoryByIdUseCase() {
      return UseCaseModule_ProvideGetCategoryByIdUseCasesFactory.provideGetCategoryByIdUseCases(bindCategoryRepositoryProvider.get());
    }

    @SuppressWarnings("unchecked")
    private void initialize(final ApplicationContextModule applicationContextModuleParam) {
      this.provideDatabaseProvider = DoubleCheck.provider(new SwitchingProvider<AppDatabase>(singletonCImpl, 3));
      this.provideCategoryDaoProvider = DoubleCheck.provider(new SwitchingProvider<CategoryDao>(singletonCImpl, 2));
      this.provideFlashcardDaoProvider = DoubleCheck.provider(new SwitchingProvider<FlashcardDao>(singletonCImpl, 4));
      this.categoryRepositoryImplProvider = new SwitchingProvider<>(singletonCImpl, 1);
      this.bindCategoryRepositoryProvider = DoubleCheck.provider((Provider) categoryRepositoryImplProvider);
      this.provideCreateCategoryUseCaseProvider = DoubleCheck.provider(new SwitchingProvider<CreateCategoryUseCase>(singletonCImpl, 0));
      this.provideMiniQuizDaoProvider = DoubleCheck.provider(new SwitchingProvider<MiniQuizResultDao>(singletonCImpl, 7));
      this.miniQuizRepositoryImplProvider = new SwitchingProvider<>(singletonCImpl, 6);
      this.bindMiniQuizRepositoryProvider = DoubleCheck.provider((Provider) miniQuizRepositoryImplProvider);
      this.provideDatabaseReferenceProvider = DoubleCheck.provider(new SwitchingProvider<DatabaseReference>(singletonCImpl, 9));
      this.firebaseRemoteDataSourceImplProvider = new SwitchingProvider<>(singletonCImpl, 8);
      this.bindFirebaseRemoteDataSourceProvider = DoubleCheck.provider((Provider) firebaseRemoteDataSourceImplProvider);
      this.provideSharedPreferencesProvider = DoubleCheck.provider(new SwitchingProvider<SharedPreferences>(singletonCImpl, 11));
      this.sharedPreferencesRepositoryImplProvider = new SwitchingProvider<>(singletonCImpl, 10);
      this.bindSharedPreferencesRepositoryProvider = DoubleCheck.provider((Provider) sharedPreferencesRepositoryImplProvider);
      this.provideSyncAllDataUseCaseProvider = DoubleCheck.provider(new SwitchingProvider<SyncAllDataUseCase>(singletonCImpl, 5));
      this.provideLoginWithGoogleUseCaseProvider = DoubleCheck.provider(new SwitchingProvider<LoginWithGoogleUseCase>(singletonCImpl, 12));
      this.provideLogoutUseCaseProvider = DoubleCheck.provider(new SwitchingProvider<LogoutUseCase>(singletonCImpl, 13));
      this.provideFlashcardUseCasesProvider = DoubleCheck.provider(new SwitchingProvider<FlashcardUseCases>(singletonCImpl, 14));
      this.provideGetFolderWithFlashcardsUseCaseProvider = DoubleCheck.provider(new SwitchingProvider<GetCategoryWithFlashcardsUseCase>(singletonCImpl, 15));
      this.provideUpdateFolderWithFlashcardsUseCaseProvider = DoubleCheck.provider(new SwitchingProvider<UpdateCategoryWithFlashcardsUseCase>(singletonCImpl, 16));
      this.provideDeleteFolderWithFlashcardsUseCaseProvider = DoubleCheck.provider(new SwitchingProvider<DeleteCategoryWithFlashcardsUseCase>(singletonCImpl, 17));
      this.provideGetAllCategoriesUseCaseProvider = DoubleCheck.provider(new SwitchingProvider<GetAllCategoriesUseCase>(singletonCImpl, 18));
      this.provideNetworkObserverProvider = DoubleCheck.provider(new SwitchingProvider<NetworkObserver>(singletonCImpl, 19));
      this.provideGenerateMiniQuizQuestionsUseCaseProvider = DoubleCheck.provider(new SwitchingProvider<GenerateMiniQuizQuestionsUseCase>(singletonCImpl, 20));
      this.provideSaveMiniQuizResultUseCaseProvider = DoubleCheck.provider(new SwitchingProvider<SaveMiniQuizResultUseCase>(singletonCImpl, 21));
      this.provideGetAllQuizResultsUseCaseProvider = DoubleCheck.provider(new SwitchingProvider<GetAllQuizResultsUseCase>(singletonCImpl, 22));
      this.provideGetQuizResultsBetweenUseCaseProvider = DoubleCheck.provider(new SwitchingProvider<GetQuizResultsBetweenUseCase>(singletonCImpl, 23));
      this.provideGetAllCategoriesProgressUseCaseProvider = DoubleCheck.provider(new SwitchingProvider<GetAllCategoriesProgressUseCase>(singletonCImpl, 24));
    }

    @Override
    public void injectFlashLearnApp(FlashLearnApp flashLearnApp) {
    }

    @Override
    public Set<Boolean> getDisableFragmentGetContextFix() {
      return Collections.<Boolean>emptySet();
    }

    @Override
    public ActivityRetainedComponentBuilder retainedComponentBuilder() {
      return new ActivityRetainedCBuilder(singletonCImpl);
    }

    @Override
    public ServiceComponentBuilder serviceComponentBuilder() {
      return new ServiceCBuilder(singletonCImpl);
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.example.flashlearn.domain.usecase.CreateCategoryUseCase 
          return (T) UseCaseModule_ProvideCreateCategoryUseCaseFactory.provideCreateCategoryUseCase(singletonCImpl.bindCategoryRepositoryProvider.get());

          case 1: // com.example.flashlearn.data.repository.CategoryRepositoryImpl 
          return (T) new CategoryRepositoryImpl(singletonCImpl.provideCategoryDaoProvider.get(), singletonCImpl.provideFlashcardDaoProvider.get());

          case 2: // com.example.flashlearn.data.local.dao.CategoryDao 
          return (T) DatabaseModule_ProvideCategoryDaoFactory.provideCategoryDao(singletonCImpl.provideDatabaseProvider.get());

          case 3: // com.example.flashlearn.data.local.AppDatabase 
          return (T) DatabaseModule_ProvideDatabaseFactory.provideDatabase(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 4: // com.example.flashlearn.data.local.dao.FlashcardDao 
          return (T) DatabaseModule_ProvideFlashcardDaoFactory.provideFlashcardDao(singletonCImpl.provideDatabaseProvider.get());

          case 5: // com.example.flashlearn.domain.usecase.SyncAllDataUseCase 
          return (T) UseCaseModule_ProvideSyncAllDataUseCaseFactory.provideSyncAllDataUseCase(singletonCImpl.bindCategoryRepositoryProvider.get(), singletonCImpl.flashcardRepositoryImpl(), singletonCImpl.bindMiniQuizRepositoryProvider.get(), singletonCImpl.bindFirebaseRemoteDataSourceProvider.get(), singletonCImpl.bindSharedPreferencesRepositoryProvider.get());

          case 6: // com.example.flashlearn.data.repository.MiniQuizRepositoryImpl 
          return (T) new MiniQuizRepositoryImpl(singletonCImpl.provideMiniQuizDaoProvider.get());

          case 7: // com.example.flashlearn.data.local.dao.MiniQuizResultDao 
          return (T) DatabaseModule_ProvideMiniQuizDaoFactory.provideMiniQuizDao(singletonCImpl.provideDatabaseProvider.get());

          case 8: // com.example.flashlearn.data.remote.FirebaseRemoteDataSourceImpl 
          return (T) new FirebaseRemoteDataSourceImpl(singletonCImpl.provideDatabaseReferenceProvider.get(), AuthModule_ProvideFirebaseAuthFactory.provideFirebaseAuth());

          case 9: // com.google.firebase.database.DatabaseReference 
          return (T) FirebaseRemoteDataSourceModule_Companion_ProvideDatabaseReferenceFactory.provideDatabaseReference();

          case 10: // com.example.flashlearn.data.repository.SharedPreferencesRepositoryImpl 
          return (T) new SharedPreferencesRepositoryImpl(singletonCImpl.provideSharedPreferencesProvider.get());

          case 11: // android.content.SharedPreferences 
          return (T) DatabaseModule_ProvideSharedPreferencesFactory.provideSharedPreferences(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 12: // com.example.flashlearn.domain.usecase.LoginWithGoogleUseCase 
          return (T) UseCaseModule_ProvideLoginWithGoogleUseCaseFactory.provideLoginWithGoogleUseCase(singletonCImpl.authRepository());

          case 13: // com.example.flashlearn.domain.usecase.LogoutUseCase 
          return (T) UseCaseModule_ProvideLogoutUseCaseFactory.provideLogoutUseCase(singletonCImpl.authRepository());

          case 14: // com.example.flashlearn.domain.usecase.FlashcardUseCases 
          return (T) UseCaseModule_ProvideFlashcardUseCasesFactory.provideFlashcardUseCases(singletonCImpl.insertFlashcardsUseCase(), singletonCImpl.getFlashcardsByCategoryUseCase(), singletonCImpl.deleteFlashcardUseCase(), singletonCImpl.updateFlashcardUseCase());

          case 15: // com.example.flashlearn.domain.usecase.GetCategoryWithFlashcardsUseCase 
          return (T) UseCaseModule_ProvideGetFolderWithFlashcardsUseCaseFactory.provideGetFolderWithFlashcardsUseCase(singletonCImpl.bindCategoryRepositoryProvider.get(), singletonCImpl.flashcardRepositoryImpl());

          case 16: // com.example.flashlearn.domain.usecase.UpdateCategoryWithFlashcardsUseCase 
          return (T) UseCaseModule_ProvideUpdateFolderWithFlashcardsUseCaseFactory.provideUpdateFolderWithFlashcardsUseCase(singletonCImpl.flashcardRepositoryImpl(), singletonCImpl.bindCategoryRepositoryProvider.get());

          case 17: // com.example.flashlearn.domain.usecase.DeleteCategoryWithFlashcardsUseCase 
          return (T) UseCaseModule_ProvideDeleteFolderWithFlashcardsUseCaseFactory.provideDeleteFolderWithFlashcardsUseCase(singletonCImpl.flashcardRepositoryImpl(), singletonCImpl.bindCategoryRepositoryProvider.get());

          case 18: // com.example.flashlearn.domain.usecase.GetAllCategoriesUseCase 
          return (T) UseCaseModule_ProvideGetAllCategoriesUseCaseFactory.provideGetAllCategoriesUseCase(singletonCImpl.bindCategoryRepositoryProvider.get());

          case 19: // com.example.flashlearn.ui.network.NetworkObserver 
          return (T) NetworkModule_ProvideNetworkObserverFactory.provideNetworkObserver(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 20: // com.example.flashlearn.domain.usecase.GenerateMiniQuizQuestionsUseCase 
          return (T) UseCaseModule_ProvideGenerateMiniQuizQuestionsUseCaseFactory.provideGenerateMiniQuizQuestionsUseCase();

          case 21: // com.example.flashlearn.domain.usecase.SaveMiniQuizResultUseCase 
          return (T) UseCaseModule_ProvideSaveMiniQuizResultUseCaseFactory.provideSaveMiniQuizResultUseCase(singletonCImpl.bindMiniQuizRepositoryProvider.get());

          case 22: // com.example.flashlearn.domain.usecase.GetAllQuizResultsUseCase 
          return (T) UseCaseModule_ProvideGetAllQuizResultsUseCaseFactory.provideGetAllQuizResultsUseCase(singletonCImpl.bindMiniQuizRepositoryProvider.get());

          case 23: // com.example.flashlearn.domain.usecase.GetQuizResultsBetweenUseCase 
          return (T) UseCaseModule_ProvideGetQuizResultsBetweenUseCaseFactory.provideGetQuizResultsBetweenUseCase(singletonCImpl.bindMiniQuizRepositoryProvider.get());

          case 24: // com.example.flashlearn.domain.usecase.GetAllCategoriesProgressUseCase 
          return (T) UseCaseModule_ProvideGetAllCategoriesProgressUseCaseFactory.provideGetAllCategoriesProgressUseCase(singletonCImpl.bindCategoryRepositoryProvider.get(), singletonCImpl.flashcardRepositoryImpl());

          default: throw new AssertionError(id);
        }
      }
    }
  }
}
