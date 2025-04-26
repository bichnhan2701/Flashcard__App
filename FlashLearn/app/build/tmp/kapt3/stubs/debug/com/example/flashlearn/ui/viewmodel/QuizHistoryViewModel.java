package com.example.flashlearn.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/example/flashlearn/ui/viewmodel/QuizHistoryViewModel;", "Landroidx/lifecycle/ViewModel;", "getQuizHistory", "Lcom/example/flashlearn/domain/usecase/GetQuizHistoryByCategoryUseCase;", "(Lcom/example/flashlearn/domain/usecase/GetQuizHistoryByCategoryUseCase;)V", "_quizHistory", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/example/flashlearn/domain/model/MiniQuizResult;", "quizHistory", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "loadHistory", "", "categoryId", "", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class QuizHistoryViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.flashlearn.domain.usecase.GetQuizHistoryByCategoryUseCase getQuizHistory = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.flashlearn.domain.model.MiniQuizResult>> _quizHistory = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.flashlearn.domain.model.MiniQuizResult>> quizHistory = null;
    
    @javax.inject.Inject()
    public QuizHistoryViewModel(@org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.usecase.GetQuizHistoryByCategoryUseCase getQuizHistory) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.flashlearn.domain.model.MiniQuizResult>> getQuizHistory() {
        return null;
    }
    
    public final void loadHistory(int categoryId) {
    }
}