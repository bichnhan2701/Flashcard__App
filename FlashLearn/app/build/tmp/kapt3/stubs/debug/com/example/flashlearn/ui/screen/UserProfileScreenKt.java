package com.example.flashlearn.ui.screen;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0003\u001a\b\u0010\u0004\u001a\u00020\u0001H\u0003\u001a\u0010\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0003\u001a@\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0003\u001a=\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\u0013\b\u0002\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\u00010\u000e\u00a2\u0006\u0002\b\u0016H\u0007\u001a\"\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0007\u00a8\u0006\u001e"}, d2 = {"ProfileAvatar", "", "photoUrl", "Landroid/net/Uri;", "ProfileHeader", "ProfileName", "name", "", "ProfileSettings", "isDarkMode", "", "onDarkModeChange", "Lkotlin/Function1;", "onHelpClick", "Lkotlin/Function0;", "onAboutClick", "SettingItem", "icon", "Landroidx/compose/ui/graphics/painter/Painter;", "title", "onClick", "trailing", "Landroidx/compose/runtime/Composable;", "UserProfileScreen", "navController", "Landroidx/navigation/NavController;", "preferences", "Lcom/example/flashlearn/data/repository/PreferencesRepository;", "authViewModel", "Lcom/example/flashlearn/ui/viewmodel/AuthViewModel;", "app_debug"})
public final class UserProfileScreenKt {
    
    @androidx.compose.runtime.Composable()
    public static final void UserProfileScreen(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull()
    com.example.flashlearn.data.repository.PreferencesRepository preferences, @org.jetbrains.annotations.NotNull()
    com.example.flashlearn.ui.viewmodel.AuthViewModel authViewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ProfileHeader() {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ProfileName(java.lang.String name) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ProfileSettings(boolean isDarkMode, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onDarkModeChange, kotlin.jvm.functions.Function0<kotlin.Unit> onHelpClick, kotlin.jvm.functions.Function0<kotlin.Unit> onAboutClick) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ProfileAvatar(android.net.Uri photoUrl) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void SettingItem(@org.jetbrains.annotations.NotNull()
    androidx.compose.ui.graphics.painter.Painter icon, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> trailing) {
    }
}