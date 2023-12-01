package com.example.toothscan.data_user.data_local;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class RemotePaginationKeysDao_Impl implements RemotePaginationKeysDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<RemotePaginationKeys> __insertionAdapterOfRemotePaginationKeys;

  private final SharedSQLiteStatement __preparedStmtOfDeleteRemoteKeys;

  public RemotePaginationKeysDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfRemotePaginationKeys = new EntityInsertionAdapter<RemotePaginationKeys>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `remote_keys` (`id`,`prevKey`,`nextKey`) VALUES (?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @Nullable final RemotePaginationKeys entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getPrevKey() == null) {
          statement.bindNull(2);
        } else {
          statement.bindLong(2, entity.getPrevKey());
        }
        if (entity.getNextKey() == null) {
          statement.bindNull(3);
        } else {
          statement.bindLong(3, entity.getNextKey());
        }
      }
    };
    this.__preparedStmtOfDeleteRemoteKeys = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM remote_keys";
        return _query;
      }
    };
  }

  @Override
  public Object insertAll(final List<RemotePaginationKeys> remoteKey,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfRemotePaginationKeys.insert(remoteKey);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteRemoteKeys(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteRemoteKeys.acquire();
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
          __preparedStmtOfDeleteRemoteKeys.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object getRemoteKeysId(final String id,
      final Continuation<? super RemotePaginationKeys> $completion) {
    final String _sql = "SELECT * FROM remote_keys WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<RemotePaginationKeys>() {
      @Override
      @Nullable
      public RemotePaginationKeys call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfPrevKey = CursorUtil.getColumnIndexOrThrow(_cursor, "prevKey");
          final int _cursorIndexOfNextKey = CursorUtil.getColumnIndexOrThrow(_cursor, "nextKey");
          final RemotePaginationKeys _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final Integer _tmpPrevKey;
            if (_cursor.isNull(_cursorIndexOfPrevKey)) {
              _tmpPrevKey = null;
            } else {
              _tmpPrevKey = _cursor.getInt(_cursorIndexOfPrevKey);
            }
            final Integer _tmpNextKey;
            if (_cursor.isNull(_cursorIndexOfNextKey)) {
              _tmpNextKey = null;
            } else {
              _tmpNextKey = _cursor.getInt(_cursorIndexOfNextKey);
            }
            _result = new RemotePaginationKeys(_tmpId,_tmpPrevKey,_tmpNextKey);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
