package com.example.flashlearn.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u000eJ\b\u0010\u001b\u001a\u00020\u0016H\u0002R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/example/flashlearn/ui/viewmodel/CategoryDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "flashcardUseCases", "Lcom/example/flashlearn/domain/usecase/FlashcardUseCases;", "getCategoryByIdUseCase", "Lcom/example/flashlearn/domain/usecase/GetCategoryByIdUseCase;", "syncAllDataUseCase", "Lcom/example/flashlearn/domain/usecase/SyncAllDataUseCase;", "(Lcom/example/flashlearn/domain/usecase/FlashcardUseCases;Lcom/example/flashlearn/domain/usecase/GetCategoryByIdUseCase;Lcom/example/flashlearn/domain/usecase/SyncAllDataUseCase;)V", "_categoryName", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_flashcards", "", "Lcom/example/flashlearn/domain/model/Flashcard;", "categoryName", "Lkotlinx/coroutines/flow/StateFlow;", "getCategoryName", "()Lkotlinx/coroutines/flow/StateFlow;", "flashcards", "getFlashcards", "load", "", "categoryId", "", "toggleFavorite", "card", "triggerSync", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class CategoryDetailViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.flashlearn.domain.usecase.FlashcardUseCases flashcardUseCases = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.flashlearn.domain.usecase.GetCategoryByIdUseCase getCategoryByIdUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.flashlearn.domain.usecase.SyncAllDataUseCase syncAllDataUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.flashlearn.domain.model.Flashcard>> _flashcards = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.flashlearn.domain.model.Flashcard>> flashcards = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _categoryName = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> categoryName = null;
    
    @javax.inject.Inject()
    public CategoryDetailViewModel(@org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.usecase.FlashcardUseCases flashcardUseCases, @org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.usecase.GetCategoryByIdUseCase getCategoryByIdUseCase, @org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.usecase.SyncAllDataUseCase syncAllDataUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.flashlearn.domain.model.Flashcard>> getFlashcards() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getCategoryName() {
        return null;
    }
    
    public final void load(int categoryId) {
    }
    
    public final void toggleFavorite(@org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.model.Flashcard card) {
    }
    
    private final void triggerSync() {
    }
}