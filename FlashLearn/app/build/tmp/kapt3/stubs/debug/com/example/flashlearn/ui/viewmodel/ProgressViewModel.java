package com.example.flashlearn.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001cJ\u0016\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 J\b\u0010\"\u001a\u00020\u001cH\u0002R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u000f0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/example/flashlearn/ui/viewmodel/ProgressViewModel;", "Landroidx/lifecycle/ViewModel;", "getAllQuizResults", "Lcom/example/flashlearn/domain/usecase/GetAllQuizResultsUseCase;", "getQuizResultsBetween", "Lcom/example/flashlearn/domain/usecase/GetQuizResultsBetweenUseCase;", "getAllCategoriesProgress", "Lcom/example/flashlearn/domain/usecase/GetAllCategoriesProgressUseCase;", "syncAllDataUseCase", "Lcom/example/flashlearn/domain/usecase/SyncAllDataUseCase;", "networkObserver", "Lcom/example/flashlearn/ui/network/NetworkObserver;", "(Lcom/example/flashlearn/domain/usecase/GetAllQuizResultsUseCase;Lcom/example/flashlearn/domain/usecase/GetQuizResultsBetweenUseCase;Lcom/example/flashlearn/domain/usecase/GetAllCategoriesProgressUseCase;Lcom/example/flashlearn/domain/usecase/SyncAllDataUseCase;Lcom/example/flashlearn/ui/network/NetworkObserver;)V", "_categoryProgress", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/example/flashlearn/domain/model/CategoryProgress;", "_quizStats", "Lcom/example/flashlearn/domain/model/MiniQuizResult;", "categoryProgress", "Lkotlinx/coroutines/flow/StateFlow;", "getCategoryProgress", "()Lkotlinx/coroutines/flow/StateFlow;", "isNetworkAvailable", "", "quizStats", "getQuizStats", "loadAllQuizResults", "", "loadProgress", "loadQuizResultsBetween", "start", "", "end", "reloadAllData", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class ProgressViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.flashlearn.domain.usecase.GetAllQuizResultsUseCase getAllQuizResults = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.flashlearn.domain.usecase.GetQuizResultsBetweenUseCase getQuizResultsBetween = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.flashlearn.domain.usecase.GetAllCategoriesProgressUseCase getAllCategoriesProgress = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.flashlearn.domain.usecase.SyncAllDataUseCase syncAllDataUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.flashlearn.ui.network.NetworkObserver networkObserver = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.flashlearn.domain.model.CategoryProgress>> _categoryProgress = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.flashlearn.domain.model.CategoryProgress>> categoryProgress = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.flashlearn.domain.model.MiniQuizResult>> _quizStats = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.flashlearn.domain.model.MiniQuizResult>> quizStats = null;
    private boolean isNetworkAvailable = false;
    
    @javax.inject.Inject()
    public ProgressViewModel(@org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.usecase.GetAllQuizResultsUseCase getAllQuizResults, @org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.usecase.GetQuizResultsBetweenUseCase getQuizResultsBetween, @org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.usecase.GetAllCategoriesProgressUseCase getAllCategoriesProgress, @org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.usecase.SyncAllDataUseCase syncAllDataUseCase, @org.jetbrains.annotations.NotNull()
    com.example.flashlearn.ui.network.NetworkObserver networkObserver) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.flashlearn.domain.model.CategoryProgress>> getCategoryProgress() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.flashlearn.domain.model.MiniQuizResult>> getQuizStats() {
        return null;
    }
    
    public final void loadProgress() {
    }
    
    public final void loadAllQuizResults() {
    }
    
    public final void loadQuizResultsBetween(long start, long end) {
    }
    
    private final void reloadAllData() {
    }
}