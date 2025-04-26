package com.example.flashlearn.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0014\u001a\u00020\u0015J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u0016\u0010\u0016\u001a\u00020\u00152\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u000e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0006J\u0016\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u000bJ\u0006\u0010\u001c\u001a\u00020\bR,\u0010\u0003\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00070\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R/\u0010\f\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00070\u00050\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/example/flashlearn/ui/viewmodel/FlashcardFormViewModel;", "Lcom/example/flashlearn/ui/viewmodel/UnsavedChangesViewModel;", "()V", "_errors", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "", "Lkotlin/Pair;", "", "_flashcards", "", "Lcom/example/flashlearn/domain/model/Flashcard;", "errors", "Lkotlinx/coroutines/flow/StateFlow;", "getErrors", "()Lkotlinx/coroutines/flow/StateFlow;", "flashcards", "getFlashcards", "now", "", "addCard", "", "initFlashcards", "initial", "removeCard", "index", "updateCard", "updated", "validate", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class FlashcardFormViewModel extends com.example.flashlearn.ui.viewmodel.UnsavedChangesViewModel {
    private final long now = 0L;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.flashlearn.domain.model.Flashcard>> _flashcards = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.flashlearn.domain.model.Flashcard>> flashcards = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.Map<java.lang.Integer, kotlin.Pair<java.lang.Boolean, java.lang.Boolean>>> _errors = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.Map<java.lang.Integer, kotlin.Pair<java.lang.Boolean, java.lang.Boolean>>> errors = null;
    
    @javax.inject.Inject()
    public FlashcardFormViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.flashlearn.domain.model.Flashcard>> getFlashcards() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.Map<java.lang.Integer, kotlin.Pair<java.lang.Boolean, java.lang.Boolean>>> getErrors() {
        return null;
    }
    
    public final void initFlashcards(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.flashlearn.domain.model.Flashcard> initial) {
    }
    
    public final void updateCard(int index, @org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.model.Flashcard updated) {
    }
    
    public final void addCard() {
    }
    
    public final boolean removeCard(int index) {
        return false;
    }
    
    public final boolean validate() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.flashlearn.domain.model.Flashcard> getFlashcards() {
        return null;
    }
}