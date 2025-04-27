package com.example.flashlearn.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B7\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\u0006\u0010(\u001a\u00020)J\u000e\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\u001aJ\u000e\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020\u001aR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00140#\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001a0\'X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2 = {"Lcom/example/flashlearn/ui/viewmodel/MiniQuizViewModel;", "Landroidx/lifecycle/ViewModel;", "getFlashcardsByCategoryUseCase", "Lcom/example/flashlearn/domain/usecase/GetFlashcardsByCategoryUseCase;", "generateQuizQuestionsUseCase", "Lcom/example/flashlearn/domain/usecase/GenerateMiniQuizQuestionsUseCase;", "saveMiniQuizResultUseCase", "Lcom/example/flashlearn/domain/usecase/SaveMiniQuizResultUseCase;", "getCategoryByIdUseCase", "Lcom/example/flashlearn/domain/usecase/GetCategoryByIdUseCase;", "syncAllDataUseCase", "Lcom/example/flashlearn/domain/usecase/SyncAllDataUseCase;", "networkObserver", "Lcom/example/flashlearn/ui/network/NetworkObserver;", "(Lcom/example/flashlearn/domain/usecase/GetFlashcardsByCategoryUseCase;Lcom/example/flashlearn/domain/usecase/GenerateMiniQuizQuestionsUseCase;Lcom/example/flashlearn/domain/usecase/SaveMiniQuizResultUseCase;Lcom/example/flashlearn/domain/usecase/GetCategoryByIdUseCase;Lcom/example/flashlearn/domain/usecase/SyncAllDataUseCase;Lcom/example/flashlearn/ui/network/NetworkObserver;)V", "_categoryName", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_uiState", "Landroidx/compose/runtime/MutableState;", "Lcom/example/flashlearn/ui/viewmodel/MiniQuizUiState;", "categoryName", "Lkotlinx/coroutines/flow/StateFlow;", "getCategoryName", "()Lkotlinx/coroutines/flow/StateFlow;", "correctAnswers", "", "currentCategoryId", "currentIndex", "isNetworkAvailable", "", "questions", "", "Lcom/example/flashlearn/domain/model/MiniQuizQuestion;", "uiState", "Landroidx/compose/runtime/State;", "getUiState", "()Landroidx/compose/runtime/State;", "wrongFlashcardIds", "", "goToNext", "", "loadQuestions", "categoryId", "selectAnswer", "index", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class MiniQuizViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.flashlearn.domain.usecase.GetFlashcardsByCategoryUseCase getFlashcardsByCategoryUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.flashlearn.domain.usecase.GenerateMiniQuizQuestionsUseCase generateQuizQuestionsUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.flashlearn.domain.usecase.SaveMiniQuizResultUseCase saveMiniQuizResultUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.flashlearn.domain.usecase.GetCategoryByIdUseCase getCategoryByIdUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.flashlearn.domain.usecase.SyncAllDataUseCase syncAllDataUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.flashlearn.ui.network.NetworkObserver networkObserver = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _categoryName = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> categoryName = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.example.flashlearn.domain.model.MiniQuizQuestion> questions;
    private int currentIndex = 0;
    private int currentCategoryId = -1;
    private int correctAnswers = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.Integer> wrongFlashcardIds = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState<com.example.flashlearn.ui.viewmodel.MiniQuizUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.State<com.example.flashlearn.ui.viewmodel.MiniQuizUiState> uiState = null;
    private boolean isNetworkAvailable = false;
    
    @javax.inject.Inject()
    public MiniQuizViewModel(@org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.usecase.GetFlashcardsByCategoryUseCase getFlashcardsByCategoryUseCase, @org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.usecase.GenerateMiniQuizQuestionsUseCase generateQuizQuestionsUseCase, @org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.usecase.SaveMiniQuizResultUseCase saveMiniQuizResultUseCase, @org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.usecase.GetCategoryByIdUseCase getCategoryByIdUseCase, @org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.usecase.SyncAllDataUseCase syncAllDataUseCase, @org.jetbrains.annotations.NotNull()
    com.example.flashlearn.ui.network.NetworkObserver networkObserver) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getCategoryName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.State<com.example.flashlearn.ui.viewmodel.MiniQuizUiState> getUiState() {
        return null;
    }
    
    public final void loadQuestions(int categoryId) {
    }
    
    public final void selectAnswer(int index) {
    }
    
    public final void goToNext() {
    }
}