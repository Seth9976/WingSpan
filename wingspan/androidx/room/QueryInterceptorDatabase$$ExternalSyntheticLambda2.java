package androidx.room;

public final class QueryInterceptorDatabase..ExternalSyntheticLambda2 implements Runnable {
    public final QueryInterceptorDatabase f$0;

    public QueryInterceptorDatabase..ExternalSyntheticLambda2(QueryInterceptorDatabase queryInterceptorDatabase0) {
        this.f$0 = queryInterceptorDatabase0;
    }

    @Override
    public final void run() {
        QueryInterceptorDatabase.beginTransactionWithListener$lambda$2(this.f$0);
    }
}

