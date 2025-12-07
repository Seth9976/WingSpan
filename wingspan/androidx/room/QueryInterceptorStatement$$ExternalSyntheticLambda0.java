package androidx.room;

public final class QueryInterceptorStatement..ExternalSyntheticLambda0 implements Runnable {
    public final QueryInterceptorStatement f$0;

    public QueryInterceptorStatement..ExternalSyntheticLambda0(QueryInterceptorStatement queryInterceptorStatement0) {
        this.f$0 = queryInterceptorStatement0;
    }

    @Override
    public final void run() {
        QueryInterceptorStatement.executeUpdateDelete$lambda$1(this.f$0);
    }
}

