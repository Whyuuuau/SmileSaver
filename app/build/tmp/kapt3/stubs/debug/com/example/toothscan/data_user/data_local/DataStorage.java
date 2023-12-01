package com.example.toothscan.data_user.data_local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\b"}, d2 = {"Lcom/example/toothscan/data_user/data_local/DataStorage;", "Landroidx/room/RoomDatabase;", "()V", "remoteKeysDao", "Lcom/example/toothscan/data_user/data_local/RemotePaginationKeysDao;", "storyDao", "Lcom/example/toothscan/data_user/data_local/DataAccess;", "Companion", "app_debug"})
@androidx.room.Database(entities = {com.example.toothscan.data_user.api_manager.api_response.ListStoryItem.class, com.example.toothscan.data_user.data_local.RemotePaginationKeys.class}, version = 1, exportSchema = false)
public abstract class DataStorage extends androidx.room.RoomDatabase {
    @kotlin.jvm.Volatile
    @org.jetbrains.annotations.Nullable
    private static volatile com.example.toothscan.data_user.data_local.DataStorage INSTANCE;
    @org.jetbrains.annotations.NotNull
    public static final com.example.toothscan.data_user.data_local.DataStorage.Companion Companion = null;
    
    public DataStorage() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract com.example.toothscan.data_user.data_local.DataAccess storyDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.example.toothscan.data_user.data_local.RemotePaginationKeysDao remoteKeysDao();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/toothscan/data_user/data_local/DataStorage$Companion;", "", "()V", "INSTANCE", "Lcom/example/toothscan/data_user/data_local/DataStorage;", "buildDatabase", "context", "Landroid/content/Context;", "getDatabase", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.toothscan.data_user.data_local.DataStorage getDatabase(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
            return null;
        }
        
        private final com.example.toothscan.data_user.data_local.DataStorage buildDatabase(android.content.Context context) {
            return null;
        }
    }
}