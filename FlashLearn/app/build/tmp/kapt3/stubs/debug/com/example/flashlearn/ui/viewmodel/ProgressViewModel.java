package com.example.flashlearn.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0016J\u0016\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aR\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u000b0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012\u00a8\u0006\u001c"}, d2 = {"Lcom/example/flashlearn/ui/viewmodel/ProgressViewModel;", "Landroidx/lifecycle/ViewModel;", "getAllQuizResults", "Lcom/example/flashlearn/domain/usecase/GetAllQuizResultsUseCase;", "getQuizResultsBetween", "Lcom/example/flashlearn/domain/usecase/GetQuizResultsBetweenUseCase;", "getAllCategoriesProgress", "Lcom/example/flashlearn/domain/usecase/GetAllCategoriesProgressUseCase;", "(Lcom/example/flashlearn/domain/usecase/GetAllQuizResultsUseCase;Lcom/example/flashlearn/domain/usecase/GetQuizResultsBetweenUseCase;Lcom/example/flashlearn/domain/usecase/GetAllCategoriesProgressUseCase;)V", "_categoryProgress", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/example/flashlearn/domain/model/CategoryProgress;", "_quizStats", "Lcom/example/flashlearn/domain/model/MiniQuizResult;", "categoryProgress", "Lkotlinx/coroutines/flow/StateFlow;", "getCategoryProgress", "()Lkotlinx/coroutines/flow/StateFlow;", "quizStats", "getQuizStats", "loadAllQuizResults", "", "loadProgress", "loadQuizResultsBetween", "start", "", "end", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class ProgressViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.flashlearn.domain.usecase.GetAllQuizResultsUseCase getAllQuizResults = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.flashlearn.domain.usecase.GetQuizResultsBetweenUseCase getQuizResultsBetween = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.flashlearn.domain.usecase.GetAllCategoriesProgressUseCase getAllCategoriesProgress = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.flashlearn.domain.model.CategoryProgress>> _categoryProgress = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.flashlearn.domain.model.CategoryProgress>> categoryProgress = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.flashlearn.domain.model.MiniQuizResult>> _quizStats = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.flashlearn.domain.model.MiniQuizResult>> quizStats = null;
    
    @javax.inject.Inject()
    public ProgressViewModel(@org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.usecase.GetAllQuizResultsUseCase getAllQuizResults, @org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.usecase.GetQuizResultsBetweenUseCase getQuizResultsBetween, @org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.usecase.GetAllCategoriesProgressUseCase getAllCategoriesProgress) {
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
}