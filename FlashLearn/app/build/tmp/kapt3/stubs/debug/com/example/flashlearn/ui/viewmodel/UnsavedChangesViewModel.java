package com.example.flashlearn.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/example/flashlearn/ui/viewmodel/UnsavedChangesViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_hasUnsavedChanges", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "hasUnsavedChanges", "Lkotlinx/coroutines/flow/StateFlow;", "getHasUnsavedChanges", "()Lkotlinx/coroutines/flow/StateFlow;", "resetChanges", "", "setUnsavedChanges", "changed", "app_debug"})
public abstract class UnsavedChangesViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _hasUnsavedChanges = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> hasUnsavedChanges = null;
    
    public UnsavedChangesViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getHasUnsavedChanges() {
        return null;
    }
    
    public final void setUnsavedChanges(boolean changed) {
    }
    
    public final void resetChanges() {
    }
}