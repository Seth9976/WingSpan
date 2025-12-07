package androidx.room;

public final class QueryInterceptorDatabase..ExternalSyntheticLambda5 implements Runnable {
    public final QueryInterceptorDatabase f$0;

    public QueryInterceptorDatabase..ExternalSyntheticLambda5(QueryInterceptorDatabase queryInterceptorDatabase0) {
        this.f$0 = queryInterceptorDatabase0;
    }

    @Override
    public final void run() {
        QueryInterceptorDatabase.setTransactionSuccessful$lambda$5(this.f$0);
    }
}

