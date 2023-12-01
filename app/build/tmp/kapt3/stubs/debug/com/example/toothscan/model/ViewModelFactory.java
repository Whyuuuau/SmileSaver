package com.example.toothscan.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J%\u0010\u0005\u001a\u0002H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\tH\u0016\u00a2\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/example/toothscan/model/ViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "repository", "Lcom/example/toothscan/data_user/data_local/DataRepo;", "(Lcom/example/toothscan/data_user/data_local/DataRepo;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Companion", "app_debug"})
public final class ViewModelFactory extends androidx.lifecycle.ViewModelProvider.NewInstanceFactory {
    @org.jetbrains.annotations.NotNull
    private final com.example.toothscan.data_user.data_local.DataRepo repository = null;
    @kotlin.jvm.Volatile
    @org.jetbrains.annotations.Nullable
    private static volatile com.example.toothscan.model.ViewModelFactory instance;
    @org.jetbrains.annotations.NotNull
    public static final com.example.toothscan.model.ViewModelFactory.Companion Companion = null;
    
    public ViewModelFactory(@org.jetbrains.annotations.NotNull
    com.example.toothscan.data_user.data_local.DataRepo repository) {
        super();
    }
    
    @java.lang.Override
    @kotlin.Suppress(names = {"UNCHECKED_CAST"})
    @org.jetbrains.annotations.NotNull
    public <T extends androidx.lifecycle.ViewModel>T create(@org.jetbrains.annotations.NotNull
    java.lang.Class<T> modelClass) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/example/toothscan/model/ViewModelFactory$Companion;", "", "()V", "instance", "Lcom/example/toothscan/model/ViewModelFactory;", "getInstance", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.toothscan.model.ViewModelFactory getInstance(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
            return null;
        }
    }
}