package com.example.flashlearn.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010.\u001a\u00020/J\u000e\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020\u001dJ\u0006\u00102\u001a\u00020/J\b\u00103\u001a\u00020/H\u0014J\u0006\u00104\u001a\u00020/J\u0006\u00105\u001a\u00020/J\u0006\u00106\u001a\u00020/J\u000e\u00107\u001a\u00020/2\u0006\u00108\u001a\u00020\u0013J\u0006\u00109\u001a\u00020/R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8F\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00100!8F\u00a2\u0006\u0006\u001a\u0004\b\"\u0010#R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00130\u001c8F\u00a2\u0006\u0006\u001a\u0004\b$\u0010\u001fR\u0011\u0010%\u001a\u00020\u001d8F\u00a2\u0006\u0006\u001a\u0004\b&\u0010\'R\u0011\u0010(\u001a\u00020)8F\u00a2\u0006\u0006\u001a\u0004\b*\u0010+R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006:"}, d2 = {"Lcom/example/flashlearn/ui/viewmodel/FlashcardReviewViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "flashcardUseCases", "Lcom/example/flashlearn/domain/usecase/FlashcardUseCases;", "getCategoryByIdUseCase", "Lcom/example/flashlearn/domain/usecase/GetCategoryByIdUseCase;", "(Landroid/app/Application;Lcom/example/flashlearn/domain/usecase/FlashcardUseCases;Lcom/example/flashlearn/domain/usecase/GetCategoryByIdUseCase;)V", "_categoryName", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_currentIndex", "Landroidx/compose/runtime/MutableIntState;", "_flashcards", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Lcom/example/flashlearn/domain/model/Flashcard;", "_isFlipped", "Landroidx/compose/runtime/MutableState;", "", "categoryName", "Lkotlinx/coroutines/flow/StateFlow;", "getCategoryName", "()Lkotlinx/coroutines/flow/StateFlow;", "currentFlashcard", "getCurrentFlashcard", "()Lcom/example/flashlearn/domain/model/Flashcard;", "currentIndex", "Landroidx/compose/runtime/State;", "", "getCurrentIndex", "()Landroidx/compose/runtime/State;", "flashcards", "", "getFlashcards", "()Ljava/util/List;", "isFlipped", "rememberedCount", "getRememberedCount", "()I", "reviewProgress", "", "getReviewProgress", "()F", "tts", "Landroid/speech/tts/TextToSpeech;", "flipCard", "", "loadFlashcards", "categoryId", "nextFlashcard", "onCleared", "previousFlashcard", "rememberCurrentFlashcard", "resetFlip", "setIsFront", "isFront", "speakTerm", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class FlashcardReviewViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.flashlearn.domain.usecase.FlashcardUseCases flashcardUseCases = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.flashlearn.domain.usecase.GetCategoryByIdUseCase getCategoryByIdUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _categoryName = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> categoryName = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.snapshots.SnapshotStateList<com.example.flashlearn.domain.model.Flashcard> _flashcards = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableIntState _currentIndex = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState<java.lang.Boolean> _isFlipped = null;
    @org.jetbrains.annotations.Nullable()
    private android.speech.tts.TextToSpeech tts;
    
    @javax.inject.Inject()
    public FlashcardReviewViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application, @org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.usecase.FlashcardUseCases flashcardUseCases, @org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.usecase.GetCategoryByIdUseCase getCategoryByIdUseCase) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getCategoryName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.flashlearn.domain.model.Flashcard> getFlashcards() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.State<java.lang.Integer> getCurrentIndex() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.flashlearn.domain.model.Flashcard getCurrentFlashcard() {
        return null;
    }
    
    public final int getRememberedCount() {
        return 0;
    }
    
    public final float getReviewProgress() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.State<java.lang.Boolean> isFlipped() {
        return null;
    }
    
    public final void flipCard() {
    }
    
    public final void resetFlip() {
    }
    
    public final void setIsFront(boolean isFront) {
    }
    
    public final void nextFlashcard() {
    }
    
    public final void previousFlashcard() {
    }
    
    public final void loadFlashcards(int categoryId) {
    }
    
    public final void rememberCurrentFlashcard() {
    }
    
    public final void speakTerm() {
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
}