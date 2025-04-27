package com.example.flashlearn.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010H\u0002R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/example/flashlearn/ui/viewmodel/QuizHistoryViewModel;", "Landroidx/lifecycle/ViewModel;", "getQuizHistory", "Lcom/example/flashlearn/domain/usecase/GetQuizHistoryByCategoryUseCase;", "syncAllDataUseCase", "Lcom/example/flashlearn/domain/usecase/SyncAllDataUseCase;", "networkObserver", "Lcom/example/flashlearn/ui/network/NetworkObserver;", "(Lcom/example/flashlearn/domain/usecase/GetQuizHistoryByCategoryUseCase;Lcom/example/flashlearn/domain/usecase/SyncAllDataUseCase;Lcom/example/flashlearn/ui/network/NetworkObserver;)V", "_quizHistory", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/example/flashlearn/domain/model/MiniQuizResult;", "isNetworkAvailable", "", "lastLoadedCategoryId", "", "Ljava/lang/Integer;", "quizHistory", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "loadHistory", "", "categoryId", "reloadHistory", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class QuizHistoryViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.flashlearn.domain.usecase.GetQuizHistoryByCategoryUseCase getQuizHistory = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.flashlearn.domain.usecase.SyncAllDataUseCase syncAllDataUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.flashlearn.ui.network.NetworkObserver networkObserver = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.flashlearn.domain.model.MiniQuizResult>> _quizHistory = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.flashlearn.domain.model.MiniQuizResult>> quizHistory = null;
    private boolean isNetworkAvailable = false;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer lastLoadedCategoryId;
    
    @javax.inject.Inject()
    public QuizHistoryViewModel(@org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.usecase.GetQuizHistoryByCategoryUseCase getQuizHistory, @org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.usecase.SyncAllDataUseCase syncAllDataUseCase, @org.jetbrains.annotations.NotNull()
    com.example.flashlearn.ui.network.NetworkObserver networkObserver) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.flashlearn.domain.model.MiniQuizResult>> getQuizHistory() {
        return null;
    }
    
    public final void loadHistory(int categoryId) {
    }
    
    private final void reloadHistory(int categoryId) {
    }
}