package androidx.room;

public final class QueryInterceptorDatabase..ExternalSyntheticLambda1 implements Runnable {
    public final QueryInterceptorDatabase f$0;
    public final String f$1;

    public QueryInterceptorDatabase..ExternalSyntheticLambda1(QueryInterceptorDatabase queryInterceptorDatabase0, String s) {
        this.f$0 = queryInterceptorDatabase0;
        this.f$1 = s;
    }

    @Override
    public final void run() {
        QueryInterceptorDatabase.execSQL$lambda$10(this.f$0, this.f$1);
    }
}

