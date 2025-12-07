package androidx.room;

public final class QueryInterceptorDatabase..ExternalSyntheticLambda4 implements Runnable {
    public final QueryInterceptorDatabase f$0;
    public final String f$1;
    public final Object[] f$2;

    public QueryInterceptorDatabase..ExternalSyntheticLambda4(QueryInterceptorDatabase queryInterceptorDatabase0, String s, Object[] arr_object) {
        this.f$0 = queryInterceptorDatabase0;
        this.f$1 = s;
        this.f$2 = arr_object;
    }

    @Override
    public final void run() {
        QueryInterceptorDatabase.query$lambda$7(this.f$0, this.f$1, this.f$2);
    }
}

