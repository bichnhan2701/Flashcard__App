package com.example.flashlearn.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/example/flashlearn/ui/viewmodel/ProgressDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "getFlashcardsByCategory", "Lcom/example/flashlearn/domain/usecase/GetFlashcardsByCategoryUseCase;", "syncAllDataUseCase", "Lcom/example/flashlearn/domain/usecase/SyncAllDataUseCase;", "networkObserver", "Lcom/example/flashlearn/ui/network/NetworkObserver;", "(Lcom/example/flashlearn/domain/usecase/GetFlashcardsByCategoryUseCase;Lcom/example/flashlearn/domain/usecase/SyncAllDataUseCase;Lcom/example/flashlearn/ui/network/NetworkObserver;)V", "_flashcards", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/example/flashlearn/domain/model/Flashcard;", "flashcards", "Lkotlinx/coroutines/flow/StateFlow;", "getFlashcards", "()Lkotlinx/coroutines/flow/StateFlow;", "isNetworkAvailable", "", "loadFlashcards", "", "categoryId", "", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class ProgressDetailViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.flashlearn.domain.usecase.GetFlashcardsByCategoryUseCase getFlashcardsByCategory = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.flashlearn.domain.usecase.SyncAllDataUseCase syncAllDataUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.flashlearn.ui.network.NetworkObserver networkObserver = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.flashlearn.domain.model.Flashcard>> _flashcards = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.flashlearn.domain.model.Flashcard>> flashcards = null;
    private boolean isNetworkAvailable = false;
    
    @javax.inject.Inject()
    public ProgressDetailViewModel(@org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.usecase.GetFlashcardsByCategoryUseCase getFlashcardsByCategory, @org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.usecase.SyncAllDataUseCase syncAllDataUseCase, @org.jetbrains.annotations.NotNull()
    com.example.flashlearn.ui.network.NetworkObserver networkObserver) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.flashlearn.domain.model.Flashcard>> getFlashcards() {
        return null;
    }
    
    public final void loadFlashcards(int categoryId) {
    }
}