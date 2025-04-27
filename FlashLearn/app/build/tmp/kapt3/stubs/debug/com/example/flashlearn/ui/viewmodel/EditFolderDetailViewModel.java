package com.example.flashlearn.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0016\u001a\u00020\u0011H\u0002J\u0018\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0013H\u0002J$\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/example/flashlearn/ui/viewmodel/EditFolderDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "getCategoryWithFlashcardsUseCase", "Lcom/example/flashlearn/domain/usecase/GetCategoryWithFlashcardsUseCase;", "updateCategoryWithFlashcardsUseCase", "Lcom/example/flashlearn/domain/usecase/UpdateCategoryWithFlashcardsUseCase;", "deleteCategoryWithFlashcardsUseCase", "Lcom/example/flashlearn/domain/usecase/DeleteCategoryWithFlashcardsUseCase;", "syncAllDataUseCase", "Lcom/example/flashlearn/domain/usecase/SyncAllDataUseCase;", "(Lcom/example/flashlearn/domain/usecase/GetCategoryWithFlashcardsUseCase;Lcom/example/flashlearn/domain/usecase/UpdateCategoryWithFlashcardsUseCase;Lcom/example/flashlearn/domain/usecase/DeleteCategoryWithFlashcardsUseCase;Lcom/example/flashlearn/domain/usecase/SyncAllDataUseCase;)V", "folderDetail", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/flashlearn/ui/viewmodel/FolderDetailUiState;", "getFolderDetail", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "deleteCategoryOnFirebase", "", "categoryId", "", "deleteFolder", "loadFolderDetail", "syncAllData", "updateCategoryCardCount", "newCardCount", "updateFolder", "updatedName", "", "updatedCards", "", "Lcom/example/flashlearn/domain/model/Flashcard;", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class EditFolderDetailViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.flashlearn.domain.usecase.GetCategoryWithFlashcardsUseCase getCategoryWithFlashcardsUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.flashlearn.domain.usecase.UpdateCategoryWithFlashcardsUseCase updateCategoryWithFlashcardsUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.flashlearn.domain.usecase.DeleteCategoryWithFlashcardsUseCase deleteCategoryWithFlashcardsUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.flashlearn.domain.usecase.SyncAllDataUseCase syncAllDataUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.flashlearn.ui.viewmodel.FolderDetailUiState> folderDetail = null;
    
    @javax.inject.Inject()
    public EditFolderDetailViewModel(@org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.usecase.GetCategoryWithFlashcardsUseCase getCategoryWithFlashcardsUseCase, @org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.usecase.UpdateCategoryWithFlashcardsUseCase updateCategoryWithFlashcardsUseCase, @org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.usecase.DeleteCategoryWithFlashcardsUseCase deleteCategoryWithFlashcardsUseCase, @org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.usecase.SyncAllDataUseCase syncAllDataUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<com.example.flashlearn.ui.viewmodel.FolderDetailUiState> getFolderDetail() {
        return null;
    }
    
    public final void loadFolderDetail(int categoryId) {
    }
    
    public final void updateFolder(int categoryId, @org.jetbrains.annotations.NotNull()
    java.lang.String updatedName, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.flashlearn.domain.model.Flashcard> updatedCards) {
    }
    
    public final void deleteFolder(int categoryId) {
    }
    
    private final void syncAllData() {
    }
    
    private final void deleteCategoryOnFirebase(int categoryId) {
    }
    
    private final void updateCategoryCardCount(int categoryId, int newCardCount) {
    }
}