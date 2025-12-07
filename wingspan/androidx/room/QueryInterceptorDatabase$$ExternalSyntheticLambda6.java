package androidx.room;

public final class QueryInterceptorDatabase..ExternalSyntheticLambda6 implements Runnable {
    public final QueryInterceptorDatabase f$0;

    public QueryInterceptorDatabase..ExternalSyntheticLambda6(QueryInterceptorDatabase queryInterceptorDatabase0) {
        this.f$0 = queryInterceptorDatabase0;
    }

    @Override
    public final void run() {
        QueryInterceptorDatabase.beginTransactionWithListenerNonExclusive$lambda$3(this.f$0);
    }
}

