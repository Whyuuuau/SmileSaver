package com.example.toothscan.data_user.data_local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001aB\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\'\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000eH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\'\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000eH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\'\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000eH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0011\u0010\u0012\u001a\u00020\u0013H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J-\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000eH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"Lcom/example/toothscan/data_user/data_local/PaginationMediator;", "Landroidx/paging/RemoteMediator;", "", "Lcom/example/toothscan/data_user/api_manager/api_response/ListStoryItem;", "database", "Lcom/example/toothscan/data_user/data_local/DataStorage;", "apiService", "Lcom/example/toothscan/data_user/api_manager/ApiService;", "token", "", "(Lcom/example/toothscan/data_user/data_local/DataStorage;Lcom/example/toothscan/data_user/api_manager/ApiService;Ljava/lang/String;)V", "getRemoteKeyClosestToCurrentPosition", "Lcom/example/toothscan/data_user/data_local/RemotePaginationKeys;", "state", "Landroidx/paging/PagingState;", "(Landroidx/paging/PagingState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRemoteKeyForFirstItem", "getRemoteKeyForLastItem", "initialize", "Landroidx/paging/RemoteMediator$InitializeAction;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Landroidx/paging/RemoteMediator$MediatorResult;", "loadType", "Landroidx/paging/LoadType;", "(Landroidx/paging/LoadType;Landroidx/paging/PagingState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
@kotlin.OptIn(markerClass = {androidx.paging.ExperimentalPagingApi.class})
public final class PaginationMediator extends androidx.paging.RemoteMediator<java.lang.Integer, com.example.toothscan.data_user.api_manager.api_response.ListStoryItem> {
    @org.jetbrains.annotations.NotNull
    private final com.example.toothscan.data_user.data_local.DataStorage database = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.toothscan.data_user.api_manager.ApiService apiService = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String token = null;
    public static final int INITIAL_PAGE_INDEX = 1;
    @org.jetbrains.annotations.NotNull
    public static final com.example.toothscan.data_user.data_local.PaginationMediator.Companion Companion = null;
    
    public PaginationMediator(@org.jetbrains.annotations.NotNull
    com.example.toothscan.data_user.data_local.DataStorage database, @org.jetbrains.annotations.NotNull
    com.example.toothscan.data_user.api_manager.ApiService apiService, @org.jetbrains.annotations.NotNull
    java.lang.String token) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object load(@org.jetbrains.annotations.NotNull
    androidx.paging.LoadType loadType, @org.jetbrains.annotations.NotNull
    androidx.paging.PagingState<java.lang.Integer, com.example.toothscan.data_user.api_manager.api_response.ListStoryItem> state, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super androidx.paging.RemoteMediator.MediatorResult> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object initialize(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super androidx.paging.RemoteMediator.InitializeAction> $completion) {
        return null;
    }
    
    private final java.lang.Object getRemoteKeyForLastItem(androidx.paging.PagingState<java.lang.Integer, com.example.toothscan.data_user.api_manager.api_response.ListStoryItem> state, kotlin.coroutines.Continuation<? super com.example.toothscan.data_user.data_local.RemotePaginationKeys> $completion) {
        return null;
    }
    
    private final java.lang.Object getRemoteKeyForFirstItem(androidx.paging.PagingState<java.lang.Integer, com.example.toothscan.data_user.api_manager.api_response.ListStoryItem> state, kotlin.coroutines.Continuation<? super com.example.toothscan.data_user.data_local.RemotePaginationKeys> $completion) {
        return null;
    }
    
    private final java.lang.Object getRemoteKeyClosestToCurrentPosition(androidx.paging.PagingState<java.lang.Integer, com.example.toothscan.data_user.api_manager.api_response.ListStoryItem> state, kotlin.coroutines.Continuation<? super com.example.toothscan.data_user.data_local.RemotePaginationKeys> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/example/toothscan/data_user/data_local/PaginationMediator$Companion;", "", "()V", "INITIAL_PAGE_INDEX", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}