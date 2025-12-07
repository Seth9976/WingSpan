package androidx.room;

import java.util.List;

public final class QueryInterceptorDatabase..ExternalSyntheticLambda11 implements Runnable {
    public final QueryInterceptorDatabase f$0;
    public final String f$1;
    public final List f$2;

    public QueryInterceptorDatabase..ExternalSyntheticLambda11(QueryInterceptorDatabase queryInterceptorDatabase0, String s, List list0) {
        this.f$0 = queryInterceptorDatabase0;
        this.f$1 = s;
        this.f$2 = list0;
    }

    @Override
    public final void run() {
        QueryInterceptorDatabase.execSQL$lambda$11(this.f$0, this.f$1, this.f$2);
    }
}

