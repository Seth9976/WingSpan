package androidx.room;

public final class QueryInterceptorDatabase..ExternalSyntheticLambda0 implements Runnable {
    public final QueryInterceptorDatabase f$0;

    public QueryInterceptorDatabase..ExternalSyntheticLambda0(QueryInterceptorDatabase queryInterceptorDatabase0) {
        this.f$0 = queryInterceptorDatabase0;
    }

    @Override
    public final void run() {
        QueryInterceptorDatabase.beginTransactionNonExclusive$lambda$1(this.f$0);
    }
}

