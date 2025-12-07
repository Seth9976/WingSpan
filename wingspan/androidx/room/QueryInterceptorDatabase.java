package androidx.room;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u001D\u0012\u0006\u0010\u0002\u001A\u00020\u0001\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u00A2\u0006\u0002\u0010\u0007J\b\u0010\'\u001A\u00020(H\u0016J\b\u0010)\u001A\u00020(H\u0016J\u0010\u0010*\u001A\u00020(2\u0006\u0010+\u001A\u00020,H\u0016J\u0010\u0010-\u001A\u00020(2\u0006\u0010+\u001A\u00020,H\u0016J\t\u0010.\u001A\u00020(H\u0096\u0001J\u0010\u0010/\u001A\u0002002\u0006\u00101\u001A\u00020\u000BH\u0016J4\u00102\u001A\u00020\"2\u0006\u00103\u001A\u00020\u000B2\b\u00104\u001A\u0004\u0018\u00010\u000B2\u0012\u00105\u001A\u000E\u0012\b\b\u0001\u0012\u0004\u0018\u000107\u0018\u000106H\u0096\u0001\u00A2\u0006\u0002\u00108J\t\u00109\u001A\u00020(H\u0097\u0001J\t\u0010:\u001A\u00020\u000FH\u0096\u0001J\b\u0010;\u001A\u00020(H\u0016J,\u0010<\u001A\u00020(2\u0006\u00101\u001A\u00020\u000B2\u0014\b\u0001\u0010=\u001A\u000E\u0012\b\b\u0001\u0012\u0004\u0018\u000107\u0018\u000106H\u0096\u0001\u00A2\u0006\u0002\u0010>J\u0010\u0010?\u001A\u00020(2\u0006\u00101\u001A\u00020\u000BH\u0016J\'\u0010?\u001A\u00020(2\u0006\u00101\u001A\u00020\u000B2\u0010\u0010=\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010706H\u0016\u00A2\u0006\u0002\u0010>J\t\u0010@\u001A\u00020\u000FH\u0096\u0001J!\u0010A\u001A\u00020\u00172\u0006\u00103\u001A\u00020\u000B2\u0006\u0010B\u001A\u00020\"2\u0006\u0010C\u001A\u00020DH\u0096\u0001J\u0011\u0010E\u001A\u00020\u000F2\u0006\u0010F\u001A\u00020\"H\u0096\u0001J\u0010\u0010G\u001A\u00020H2\u0006\u0010G\u001A\u00020IH\u0016J\u001A\u0010G\u001A\u00020H2\u0006\u0010G\u001A\u00020I2\b\u0010J\u001A\u0004\u0018\u00010KH\u0016J\u0010\u0010G\u001A\u00020H2\u0006\u0010G\u001A\u00020\u000BH\u0016J\'\u0010G\u001A\u00020H2\u0006\u0010G\u001A\u00020\u000B2\u0010\u0010=\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010706H\u0016\u00A2\u0006\u0002\u0010LJ\u0011\u0010M\u001A\u00020(2\u0006\u0010N\u001A\u00020\u000FH\u0097\u0001J\u0011\u0010O\u001A\u00020(2\u0006\u0010P\u001A\u00020QH\u0096\u0001J\u0011\u0010R\u001A\u00020(2\u0006\u0010S\u001A\u00020\"H\u0096\u0001J\u0011\u0010T\u001A\u00020\u00172\u0006\u0010U\u001A\u00020\u0017H\u0096\u0001J\b\u0010V\u001A\u00020(H\u0016JD\u0010W\u001A\u00020\"2\u0006\u00103\u001A\u00020\u000B2\u0006\u0010B\u001A\u00020\"2\u0006\u0010C\u001A\u00020D2\b\u00104\u001A\u0004\u0018\u00010\u000B2\u0012\u00105\u001A\u000E\u0012\b\b\u0001\u0012\u0004\u0018\u000107\u0018\u000106H\u0096\u0001\u00A2\u0006\u0002\u0010XJ\t\u0010Y\u001A\u00020\u000FH\u0096\u0001J\u0011\u0010Y\u001A\u00020\u000F2\u0006\u0010Z\u001A\u00020\u0017H\u0096\u0001R(\u0010\b\u001A\u0016\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u000B0\n\u0018\u00010\t8VX\u0096\u0005\u00A2\u0006\u0006\u001A\u0004\b\f\u0010\rR\u000E\u0010\u0002\u001A\u00020\u0001X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u0012\u0010\u000E\u001A\u00020\u000FX\u0096\u0005\u00A2\u0006\u0006\u001A\u0004\b\u000E\u0010\u0010R\u0012\u0010\u0011\u001A\u00020\u000FX\u0096\u0005\u00A2\u0006\u0006\u001A\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001A\u00020\u000F8VX\u0096\u0005\u00A2\u0006\u0006\u001A\u0004\b\u0012\u0010\u0010R\u0012\u0010\u0013\u001A\u00020\u000FX\u0096\u0005\u00A2\u0006\u0006\u001A\u0004\b\u0013\u0010\u0010R\u0012\u0010\u0014\u001A\u00020\u000FX\u0096\u0005\u00A2\u0006\u0006\u001A\u0004\b\u0014\u0010\u0010R\u0014\u0010\u0015\u001A\u00020\u000F8WX\u0096\u0005\u00A2\u0006\u0006\u001A\u0004\b\u0015\u0010\u0010R\u0012\u0010\u0016\u001A\u00020\u0017X\u0096\u0005\u00A2\u0006\u0006\u001A\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001A\u001A\u00020\u0017X\u0096\u000F\u00A2\u0006\f\u001A\u0004\b\u001B\u0010\u0019\"\u0004\b\u001C\u0010\u001DR\u0014\u0010\u001E\u001A\u0004\u0018\u00010\u000BX\u0096\u0005\u00A2\u0006\u0006\u001A\u0004\b\u001F\u0010 R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u0018\u0010!\u001A\u00020\"X\u0096\u000F\u00A2\u0006\f\u001A\u0004\b#\u0010$\"\u0004\b%\u0010&\u00A8\u0006["}, d2 = {"Landroidx/room/QueryInterceptorDatabase;", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "delegate", "queryCallbackExecutor", "Ljava/util/concurrent/Executor;", "queryCallback", "Landroidx/room/RoomDatabase$QueryCallback;", "(Landroidx/sqlite/db/SupportSQLiteDatabase;Ljava/util/concurrent/Executor;Landroidx/room/RoomDatabase$QueryCallback;)V", "attachedDbs", "", "Landroid/util/Pair;", "", "getAttachedDbs", "()Ljava/util/List;", "isDatabaseIntegrityOk", "", "()Z", "isDbLockedByCurrentThread", "isExecPerConnectionSQLSupported", "isOpen", "isReadOnly", "isWriteAheadLoggingEnabled", "maximumSize", "", "getMaximumSize", "()J", "pageSize", "getPageSize", "setPageSize", "(J)V", "path", "getPath", "()Ljava/lang/String;", "version", "", "getVersion", "()I", "setVersion", "(I)V", "beginTransaction", "", "beginTransactionNonExclusive", "beginTransactionWithListener", "transactionListener", "Landroid/database/sqlite/SQLiteTransactionListener;", "beginTransactionWithListenerNonExclusive", "close", "compileStatement", "Landroidx/sqlite/db/SupportSQLiteStatement;", "sql", "delete", "table", "whereClause", "whereArgs", "", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I", "disableWriteAheadLogging", "enableWriteAheadLogging", "endTransaction", "execPerConnectionSQL", "bindArgs", "(Ljava/lang/String;[Ljava/lang/Object;)V", "execSQL", "inTransaction", "insert", "conflictAlgorithm", "values", "Landroid/content/ContentValues;", "needUpgrade", "newVersion", "query", "Landroid/database/Cursor;", "Landroidx/sqlite/db/SupportSQLiteQuery;", "cancellationSignal", "Landroid/os/CancellationSignal;", "(Ljava/lang/String;[Ljava/lang/Object;)Landroid/database/Cursor;", "setForeignKeyConstraintsEnabled", "enabled", "setLocale", "locale", "Ljava/util/Locale;", "setMaxSqlCacheSize", "cacheSize", "setMaximumSize", "numBytes", "setTransactionSuccessful", "update", "(Ljava/lang/String;ILandroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/Object;)I", "yieldIfContendedSafely", "sleepAfterYieldDelayMillis", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class QueryInterceptorDatabase implements SupportSQLiteDatabase {
    private final SupportSQLiteDatabase delegate;
    private final QueryCallback queryCallback;
    private final Executor queryCallbackExecutor;

    public QueryInterceptorDatabase(SupportSQLiteDatabase supportSQLiteDatabase0, Executor executor0, QueryCallback roomDatabase$QueryCallback0) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase0, "delegate");
        Intrinsics.checkNotNullParameter(executor0, "queryCallbackExecutor");
        Intrinsics.checkNotNullParameter(roomDatabase$QueryCallback0, "queryCallback");
        super();
        this.delegate = supportSQLiteDatabase0;
        this.queryCallbackExecutor = executor0;
        this.queryCallback = roomDatabase$QueryCallback0;
    }

    @Override  // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransaction() {
        QueryInterceptorDatabase..ExternalSyntheticLambda8 queryInterceptorDatabase$$ExternalSyntheticLambda80 = () -> {
            Intrinsics.checkNotNullParameter(this, "this$0");
            List list0 = CollectionsKt.emptyList();
            this.queryCallback.onQuery("BEGIN EXCLUSIVE TRANSACTION", list0);
        };
        this.queryCallbackExecutor.execute(queryInterceptorDatabase$$ExternalSyntheticLambda80);
        this.delegate.beginTransaction();
    }

    // 检测为 Lambda 实现
    private static final void beginTransaction$lambda$0(QueryInterceptorDatabase queryInterceptorDatabase0) [...]

    @Override  // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionNonExclusive() {
        QueryInterceptorDatabase..ExternalSyntheticLambda0 queryInterceptorDatabase$$ExternalSyntheticLambda00 = () -> {
            Intrinsics.checkNotNullParameter(this, "this$0");
            List list0 = CollectionsKt.emptyList();
            this.queryCallback.onQuery("BEGIN DEFERRED TRANSACTION", list0);
        };
        this.queryCallbackExecutor.execute(queryInterceptorDatabase$$ExternalSyntheticLambda00);
        this.delegate.beginTransactionNonExclusive();
    }

    // 检测为 Lambda 实现
    private static final void beginTransactionNonExclusive$lambda$1(QueryInterceptorDatabase queryInterceptorDatabase0) [...]

    @Override  // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListener(SQLiteTransactionListener sQLiteTransactionListener0) {
        Intrinsics.checkNotNullParameter(sQLiteTransactionListener0, "transactionListener");
        QueryInterceptorDatabase..ExternalSyntheticLambda2 queryInterceptorDatabase$$ExternalSyntheticLambda20 = () -> {
            Intrinsics.checkNotNullParameter(this, "this$0");
            List list0 = CollectionsKt.emptyList();
            this.queryCallback.onQuery("BEGIN EXCLUSIVE TRANSACTION", list0);
        };
        this.queryCallbackExecutor.execute(queryInterceptorDatabase$$ExternalSyntheticLambda20);
        this.delegate.beginTransactionWithListener(sQLiteTransactionListener0);
    }

    // 检测为 Lambda 实现
    private static final void beginTransactionWithListener$lambda$2(QueryInterceptorDatabase queryInterceptorDatabase0) [...]

    @Override  // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener sQLiteTransactionListener0) {
        Intrinsics.checkNotNullParameter(sQLiteTransactionListener0, "transactionListener");
        QueryInterceptorDatabase..ExternalSyntheticLambda6 queryInterceptorDatabase$$ExternalSyntheticLambda60 = () -> {
            Intrinsics.checkNotNullParameter(this, "this$0");
            List list0 = CollectionsKt.emptyList();
            this.queryCallback.onQuery("BEGIN DEFERRED TRANSACTION", list0);
        };
        this.queryCallbackExecutor.execute(queryInterceptorDatabase$$ExternalSyntheticLambda60);
        this.delegate.beginTransactionWithListenerNonExclusive(sQLiteTransactionListener0);
    }

    // 检测为 Lambda 实现
    private static final void beginTransactionWithListenerNonExclusive$lambda$3(QueryInterceptorDatabase queryInterceptorDatabase0) [...]

    @Override
    public void close() {
        this.delegate.close();
    }

    @Override  // androidx.sqlite.db.SupportSQLiteDatabase
    public SupportSQLiteStatement compileStatement(String s) {
        Intrinsics.checkNotNullParameter(s, "sql");
        return new QueryInterceptorStatement(this.delegate.compileStatement(s), s, this.queryCallbackExecutor, this.queryCallback);
    }

    @Override  // androidx.sqlite.db.SupportSQLiteDatabase
    public int delete(String s, String s1, Object[] arr_object) {
        Intrinsics.checkNotNullParameter(s, "table");
        return this.delegate.delete(s, s1, arr_object);
    }

    @Override  // androidx.sqlite.db.SupportSQLiteDatabase
    public void disableWriteAheadLogging() {
        this.delegate.disableWriteAheadLogging();
    }

    @Override  // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean enableWriteAheadLogging() {
        return this.delegate.enableWriteAheadLogging();
    }

    @Override  // androidx.sqlite.db.SupportSQLiteDatabase
    public void endTransaction() {
        QueryInterceptorDatabase..ExternalSyntheticLambda10 queryInterceptorDatabase$$ExternalSyntheticLambda100 = () -> {
            Intrinsics.checkNotNullParameter(this, "this$0");
            List list0 = CollectionsKt.emptyList();
            this.queryCallback.onQuery("END TRANSACTION", list0);
        };
        this.queryCallbackExecutor.execute(queryInterceptorDatabase$$ExternalSyntheticLambda100);
        this.delegate.endTransaction();
    }

    // 检测为 Lambda 实现
    private static final void endTransaction$lambda$4(QueryInterceptorDatabase queryInterceptorDatabase0) [...]

    @Override  // androidx.sqlite.db.SupportSQLiteDatabase
    public void execPerConnectionSQL(String s, Object[] arr_object) {
        Intrinsics.checkNotNullParameter(s, "sql");
        this.delegate.execPerConnectionSQL(s, arr_object);
    }

    @Override  // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(String s) {
        Intrinsics.checkNotNullParameter(s, "sql");
        QueryInterceptorDatabase..ExternalSyntheticLambda1 queryInterceptorDatabase$$ExternalSyntheticLambda10 = () -> {
            Intrinsics.checkNotNullParameter(this, "this$0");
            Intrinsics.checkNotNullParameter(s, "$sql");
            List list0 = CollectionsKt.emptyList();
            this.queryCallback.onQuery(s, list0);
        };
        this.queryCallbackExecutor.execute(queryInterceptorDatabase$$ExternalSyntheticLambda10);
        this.delegate.execSQL(s);
    }

    @Override  // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(String s, Object[] arr_object) {
        Intrinsics.checkNotNullParameter(s, "sql");
        Intrinsics.checkNotNullParameter(arr_object, "bindArgs");
        List list0 = new ArrayList();
        list0.addAll(CollectionsKt.listOf(arr_object));
        QueryInterceptorDatabase..ExternalSyntheticLambda11 queryInterceptorDatabase$$ExternalSyntheticLambda110 = () -> {
            Intrinsics.checkNotNullParameter(this, "this$0");
            Intrinsics.checkNotNullParameter(s, "$sql");
            Intrinsics.checkNotNullParameter(list0, "$inputArguments");
            this.queryCallback.onQuery(s, list0);
        };
        this.queryCallbackExecutor.execute(queryInterceptorDatabase$$ExternalSyntheticLambda110);
        this.delegate.execSQL(s, new List[]{list0});
    }

    // 检测为 Lambda 实现
    private static final void execSQL$lambda$10(QueryInterceptorDatabase queryInterceptorDatabase0, String s) [...]

    // 检测为 Lambda 实现
    private static final void execSQL$lambda$11(QueryInterceptorDatabase queryInterceptorDatabase0, String s, List list0) [...]

    @Override  // androidx.sqlite.db.SupportSQLiteDatabase
    public List getAttachedDbs() {
        return this.delegate.getAttachedDbs();
    }

    @Override  // androidx.sqlite.db.SupportSQLiteDatabase
    public long getMaximumSize() {
        return this.delegate.getMaximumSize();
    }

    @Override  // androidx.sqlite.db.SupportSQLiteDatabase
    public long getPageSize() {
        return this.delegate.getPageSize();
    }

    @Override  // androidx.sqlite.db.SupportSQLiteDatabase
    public String getPath() {
        return this.delegate.getPath();
    }

    @Override  // androidx.sqlite.db.SupportSQLiteDatabase
    public int getVersion() {
        return this.delegate.getVersion();
    }

    @Override  // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean inTransaction() {
        return this.delegate.inTransaction();
    }

    @Override  // androidx.sqlite.db.SupportSQLiteDatabase
    public long insert(String s, int v, ContentValues contentValues0) {
        Intrinsics.checkNotNullParameter(s, "table");
        Intrinsics.checkNotNullParameter(contentValues0, "values");
        return this.delegate.insert(s, v, contentValues0);
    }

    @Override  // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDatabaseIntegrityOk() {
        return this.delegate.isDatabaseIntegrityOk();
    }

    @Override  // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDbLockedByCurrentThread() {
        return this.delegate.isDbLockedByCurrentThread();
    }

    @Override  // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isExecPerConnectionSQLSupported() {
        return this.delegate.isExecPerConnectionSQLSupported();
    }

    @Override  // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isOpen() {
        return this.delegate.isOpen();
    }

    @Override  // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isReadOnly() {
        return this.delegate.isReadOnly();
    }

    @Override  // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isWriteAheadLoggingEnabled() {
        return this.delegate.isWriteAheadLoggingEnabled();
    }

    @Override  // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean needUpgrade(int v) {
        return this.delegate.needUpgrade(v);
    }

    @Override  // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(SupportSQLiteQuery supportSQLiteQuery0) {
        Intrinsics.checkNotNullParameter(supportSQLiteQuery0, "query");
        QueryInterceptorProgram queryInterceptorProgram0 = new QueryInterceptorProgram();
        supportSQLiteQuery0.bindTo(queryInterceptorProgram0);
        QueryInterceptorDatabase..ExternalSyntheticLambda7 queryInterceptorDatabase$$ExternalSyntheticLambda70 = () -> {
            Intrinsics.checkNotNullParameter(this, "this$0");
            Intrinsics.checkNotNullParameter(supportSQLiteQuery0, "$query");
            Intrinsics.checkNotNullParameter(queryInterceptorProgram0, "$queryInterceptorProgram");
            String s = supportSQLiteQuery0.getSql();
            List list0 = queryInterceptorProgram0.getBindArgsCache$room_runtime_release();
            this.queryCallback.onQuery(s, list0);
        };
        this.queryCallbackExecutor.execute(queryInterceptorDatabase$$ExternalSyntheticLambda70);
        return this.delegate.query(supportSQLiteQuery0);
    }

    @Override  // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(SupportSQLiteQuery supportSQLiteQuery0, CancellationSignal cancellationSignal0) {
        Intrinsics.checkNotNullParameter(supportSQLiteQuery0, "query");
        QueryInterceptorProgram queryInterceptorProgram0 = new QueryInterceptorProgram();
        supportSQLiteQuery0.bindTo(queryInterceptorProgram0);
        QueryInterceptorDatabase..ExternalSyntheticLambda3 queryInterceptorDatabase$$ExternalSyntheticLambda30 = () -> {
            Intrinsics.checkNotNullParameter(this, "this$0");
            Intrinsics.checkNotNullParameter(supportSQLiteQuery0, "$query");
            Intrinsics.checkNotNullParameter(queryInterceptorProgram0, "$queryInterceptorProgram");
            String s = supportSQLiteQuery0.getSql();
            this.queryCallback.onQuery(s, queryInterceptorProgram0.getBindArgsCache$room_runtime_release());
        };
        this.queryCallbackExecutor.execute(queryInterceptorDatabase$$ExternalSyntheticLambda30);
        return this.delegate.query(supportSQLiteQuery0);
    }

    @Override  // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(String s) {
        Intrinsics.checkNotNullParameter(s, "query");
        QueryInterceptorDatabase..ExternalSyntheticLambda9 queryInterceptorDatabase$$ExternalSyntheticLambda90 = () -> {
            Intrinsics.checkNotNullParameter(this, "this$0");
            Intrinsics.checkNotNullParameter(s, "$query");
            List list0 = CollectionsKt.emptyList();
            this.queryCallback.onQuery(s, list0);
        };
        this.queryCallbackExecutor.execute(queryInterceptorDatabase$$ExternalSyntheticLambda90);
        return this.delegate.query(s);
    }

    @Override  // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(String s, Object[] arr_object) {
        Intrinsics.checkNotNullParameter(s, "query");
        Intrinsics.checkNotNullParameter(arr_object, "bindArgs");
        QueryInterceptorDatabase..ExternalSyntheticLambda4 queryInterceptorDatabase$$ExternalSyntheticLambda40 = () -> {
            Intrinsics.checkNotNullParameter(this, "this$0");
            Intrinsics.checkNotNullParameter(s, "$query");
            Intrinsics.checkNotNullParameter(arr_object, "$bindArgs");
            List list0 = ArraysKt.toList(arr_object);
            this.queryCallback.onQuery(s, list0);
        };
        this.queryCallbackExecutor.execute(queryInterceptorDatabase$$ExternalSyntheticLambda40);
        return this.delegate.query(s, arr_object);
    }

    // 检测为 Lambda 实现
    private static final void query$lambda$6(QueryInterceptorDatabase queryInterceptorDatabase0, String s) [...]

    // 检测为 Lambda 实现
    private static final void query$lambda$7(QueryInterceptorDatabase queryInterceptorDatabase0, String s, Object[] arr_object) [...]

    // 检测为 Lambda 实现
    private static final void query$lambda$8(QueryInterceptorDatabase queryInterceptorDatabase0, SupportSQLiteQuery supportSQLiteQuery0, QueryInterceptorProgram queryInterceptorProgram0) [...]

    // 检测为 Lambda 实现
    private static final void query$lambda$9(QueryInterceptorDatabase queryInterceptorDatabase0, SupportSQLiteQuery supportSQLiteQuery0, QueryInterceptorProgram queryInterceptorProgram0) [...]

    @Override  // androidx.sqlite.db.SupportSQLiteDatabase
    public void setForeignKeyConstraintsEnabled(boolean z) {
        this.delegate.setForeignKeyConstraintsEnabled(z);
    }

    @Override  // androidx.sqlite.db.SupportSQLiteDatabase
    public void setLocale(Locale locale0) {
        Intrinsics.checkNotNullParameter(locale0, "locale");
        this.delegate.setLocale(locale0);
    }

    @Override  // androidx.sqlite.db.SupportSQLiteDatabase
    public void setMaxSqlCacheSize(int v) {
        this.delegate.setMaxSqlCacheSize(v);
    }

    @Override  // androidx.sqlite.db.SupportSQLiteDatabase
    public long setMaximumSize(long v) {
        return this.delegate.setMaximumSize(v);
    }

    @Override  // androidx.sqlite.db.SupportSQLiteDatabase
    public void setPageSize(long v) {
        this.delegate.setPageSize(v);
    }

    @Override  // androidx.sqlite.db.SupportSQLiteDatabase
    public void setTransactionSuccessful() {
        QueryInterceptorDatabase..ExternalSyntheticLambda5 queryInterceptorDatabase$$ExternalSyntheticLambda50 = () -> {
            Intrinsics.checkNotNullParameter(this, "this$0");
            List list0 = CollectionsKt.emptyList();
            this.queryCallback.onQuery("TRANSACTION SUCCESSFUL", list0);
        };
        this.queryCallbackExecutor.execute(queryInterceptorDatabase$$ExternalSyntheticLambda50);
        this.delegate.setTransactionSuccessful();
    }

    // 检测为 Lambda 实现
    private static final void setTransactionSuccessful$lambda$5(QueryInterceptorDatabase queryInterceptorDatabase0) [...]

    @Override  // androidx.sqlite.db.SupportSQLiteDatabase
    public void setVersion(int v) {
        this.delegate.setVersion(v);
    }

    @Override  // androidx.sqlite.db.SupportSQLiteDatabase
    public int update(String s, int v, ContentValues contentValues0, String s1, Object[] arr_object) {
        Intrinsics.checkNotNullParameter(s, "table");
        Intrinsics.checkNotNullParameter(contentValues0, "values");
        return this.delegate.update(s, v, contentValues0, s1, arr_object);
    }

    @Override  // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely() {
        return this.delegate.yieldIfContendedSafely();
    }

    @Override  // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely(long v) {
        return this.delegate.yieldIfContendedSafely(v);
    }
}

