package com.example.toothscan.data_user.data_local;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.paging.PagingSource;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.paging.LimitOffsetPagingSource;
import androidx.room.util.CursorUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.toothscan.data_user.api_manager.api_response.ListStoryItem;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DataAccess_Impl implements DataAccess {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ListStoryItem> __insertionAdapterOfListStoryItem;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public DataAccess_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfListStoryItem = new EntityInsertionAdapter<ListStoryItem>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `story` (`photoUrl`,`createdAt`,`name`,`description`,`lon`,`id`,`lat`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @Nullable final ListStoryItem entity) {
        if (entity.getPhotoUrl() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getPhotoUrl());
        }
        if (entity.getCreatedAt() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getCreatedAt());
        }
        if (entity.getName() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getName());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getDescription());
        }
        statement.bindDouble(5, entity.getLon());
        if (entity.getId() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getId());
        }
        statement.bindDouble(7, entity.getLat());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM story";
        return _query;
      }
    };
  }

  @Override
  public Object addStories(final List<ListStoryItem> stories,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfListStoryItem.insert(stories);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAll(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteAll.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public PagingSource<Integer, ListStoryItem> getStories() {
    final String _sql = "SELECT * FROM story";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new LimitOffsetPagingSource<ListStoryItem>(_statement, __db, "story") {
      @Override
      @NonNull
      protected List<ListStoryItem> convertRows(@NonNull final Cursor cursor) {
        final int _cursorIndexOfPhotoUrl = CursorUtil.getColumnIndexOrThrow(cursor, "photoUrl");
        final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(cursor, "createdAt");
        final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(cursor, "name");
        final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(cursor, "description");
        final int _cursorIndexOfLon = CursorUtil.getColumnIndexOrThrow(cursor, "lon");
        final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
        final int _cursorIndexOfLat = CursorUtil.getColumnIndexOrThrow(cursor, "lat");
        final List<ListStoryItem> _result = new ArrayList<ListStoryItem>(cursor.getCount());
        while (cursor.moveToNext()) {
          final ListStoryItem _item;
          final String _tmpPhotoUrl;
          if (cursor.isNull(_cursorIndexOfPhotoUrl)) {
            _tmpPhotoUrl = null;
          } else {
            _tmpPhotoUrl = cursor.getString(_cursorIndexOfPhotoUrl);
          }
          final String _tmpCreatedAt;
          if (cursor.isNull(_cursorIndexOfCreatedAt)) {
            _tmpCreatedAt = null;
          } else {
            _tmpCreatedAt = cursor.getString(_cursorIndexOfCreatedAt);
          }
          final String _tmpName;
          if (cursor.isNull(_cursorIndexOfName)) {
            _tmpName = null;
          } else {
            _tmpName = cursor.getString(_cursorIndexOfName);
          }
          final String _tmpDescription;
          if (cursor.isNull(_cursorIndexOfDescription)) {
            _tmpDescription = null;
          } else {
            _tmpDescription = cursor.getString(_cursorIndexOfDescription);
          }
          final double _tmpLon;
          _tmpLon = cursor.getDouble(_cursorIndexOfLon);
          final String _tmpId;
          if (cursor.isNull(_cursorIndexOfId)) {
            _tmpId = null;
          } else {
            _tmpId = cursor.getString(_cursorIndexOfId);
          }
          final double _tmpLat;
          _tmpLat = cursor.getDouble(_cursorIndexOfLat);
          _item = new ListStoryItem(_tmpPhotoUrl,_tmpCreatedAt,_tmpName,_tmpDescription,_tmpLon,_tmpId,_tmpLat);
          _result.add(_item);
        }
        return _result;
      }
    };
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
