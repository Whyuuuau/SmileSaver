package com.example.toothscan.preferences;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0001\rB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\tR\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/example/toothscan/preferences/UserManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "preferences", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getToken", "", "setToken", "", "token", "Companion", "app_debug"})
public final class UserManager {
    private final android.content.SharedPreferences preferences = null;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String PREFS_NAME = "pref";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String TOKEN = "token";
    @org.jetbrains.annotations.NotNull
    public static final com.example.toothscan.preferences.UserManager.Companion Companion = null;
    
    public UserManager(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    public final void setToken(@org.jetbrains.annotations.Nullable
    java.lang.String token) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getToken() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/example/toothscan/preferences/UserManager$Companion;", "", "()V", "PREFS_NAME", "", "TOKEN", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}