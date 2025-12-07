package kotlinx.coroutines.selects;

import java.util.ArrayList;
import java.util.Collections;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\u00A2\u0006\u0002\u0010\u0005J\u0010\u0010\u0011\u001A\u00020\t2\u0006\u0010\u0012\u001A\u00020\u0013H\u0001J\n\u0010\u0014\u001A\u0004\u0018\u00010\u0015H\u0001J6\u0010\u0016\u001A\u00020\t2\u0006\u0010\u0017\u001A\u00020\u00182\u001C\u0010\u0019\u001A\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u001AH\u0016\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010\u001BJ3\u0010\u001C\u001A\u00020\t*\u00020\u001D2\u001C\u0010\u0019\u001A\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u001AH\u0096\u0002\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010\u001EJE\u0010\u001C\u001A\u00020\t\"\u0004\b\u0001\u0010\u001F*\b\u0012\u0004\u0012\u0002H\u001F0 2\"\u0010\u0019\u001A\u001E\b\u0001\u0012\u0004\u0012\u0002H\u001F\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00150!H\u0096\u0002\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010\"JY\u0010\u001C\u001A\u00020\t\"\u0004\b\u0001\u0010#\"\u0004\b\u0002\u0010\u001F*\u000E\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u0002H\u001F0$2\u0006\u0010%\u001A\u0002H#2\"\u0010\u0019\u001A\u001E\b\u0001\u0012\u0004\u0012\u0002H\u001F\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00150!H\u0096\u0002\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010&R-\u0010\u0006\u001A\u001E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007j\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b`\n\u00A2\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0017\u0010\r\u001A\b\u0012\u0004\u0012\u00028\u00000\u000E\u00A2\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019\u00A8\u0006\'"}, d2 = {"Lkotlinx/coroutines/selects/UnbiasedSelectBuilderImpl;", "R", "Lkotlinx/coroutines/selects/SelectBuilder;", "uCont", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/Continuation;)V", "clauses", "Ljava/util/ArrayList;", "Lkotlin/Function0;", "", "Lkotlin/collections/ArrayList;", "getClauses", "()Ljava/util/ArrayList;", "instance", "Lkotlinx/coroutines/selects/SelectBuilderImpl;", "getInstance", "()Lkotlinx/coroutines/selects/SelectBuilderImpl;", "handleBuilderException", "e", "", "initSelectResult", "", "onTimeout", "timeMillis", "", "block", "Lkotlin/Function1;", "(JLkotlin/jvm/functions/Function1;)V", "invoke", "Lkotlinx/coroutines/selects/SelectClause0;", "(Lkotlinx/coroutines/selects/SelectClause0;Lkotlin/jvm/functions/Function1;)V", "Q", "Lkotlinx/coroutines/selects/SelectClause1;", "Lkotlin/Function2;", "(Lkotlinx/coroutines/selects/SelectClause1;Lkotlin/jvm/functions/Function2;)V", "P", "Lkotlinx/coroutines/selects/SelectClause2;", "param", "(Lkotlinx/coroutines/selects/SelectClause2;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
public final class UnbiasedSelectBuilderImpl implements SelectBuilder {
    private final ArrayList clauses;
    private final SelectBuilderImpl instance;

    public UnbiasedSelectBuilderImpl(Continuation continuation0) {
        this.instance = new SelectBuilderImpl(continuation0);
        this.clauses = new ArrayList();
    }

    public final ArrayList getClauses() {
        return this.clauses;
    }

    public final SelectBuilderImpl getInstance() {
        return this.instance;
    }

    public final void handleBuilderException(Throwable throwable0) {
        this.instance.handleBuilderException(throwable0);
    }

    public final Object initSelectResult() {
        if(!this.instance.isSelected()) {
            try {
                Collections.shuffle(this.clauses);
                for(Object object0: this.clauses) {
                    ((Function0)object0).invoke();
                }
            }
            catch(Throwable throwable0) {
                this.instance.handleBuilderException(throwable0);
            }
        }
        return this.instance.getResult();
    }

    @Override  // kotlinx.coroutines.selects.SelectBuilder
    public void invoke(SelectClause0 selectClause00, Function1 function10) {
        kotlinx.coroutines.selects.UnbiasedSelectBuilderImpl.invoke.1 unbiasedSelectBuilderImpl$invoke$10 = new Function0(this, function10) {
            final Function1 $block;
            final SelectClause0 $this_invoke;

            {
                this.$this_invoke = selectClause00;
                UnbiasedSelectBuilderImpl.this = unbiasedSelectBuilderImpl0;
                this.$block = function10;
                super(0);
            }

            @Override  // kotlin.jvm.functions.Function0
            public Object invoke() {
                this.invoke();
                return Unit.INSTANCE;
            }

            public final void invoke() {
                this.$this_invoke.registerSelectClause0(UnbiasedSelectBuilderImpl.this.getInstance(), this.$block);
            }
        };
        this.clauses.add(unbiasedSelectBuilderImpl$invoke$10);
    }

    @Override  // kotlinx.coroutines.selects.SelectBuilder
    public void invoke(SelectClause1 selectClause10, Function2 function20) {
        kotlinx.coroutines.selects.UnbiasedSelectBuilderImpl.invoke.2 unbiasedSelectBuilderImpl$invoke$20 = new Function0(this, function20) {
            final Function2 $block;
            final SelectClause1 $this_invoke;

            {
                this.$this_invoke = selectClause10;
                UnbiasedSelectBuilderImpl.this = unbiasedSelectBuilderImpl0;
                this.$block = function20;
                super(0);
            }

            @Override  // kotlin.jvm.functions.Function0
            public Object invoke() {
                this.invoke();
                return Unit.INSTANCE;
            }

            public final void invoke() {
                this.$this_invoke.registerSelectClause1(UnbiasedSelectBuilderImpl.this.getInstance(), this.$block);
            }
        };
        this.clauses.add(unbiasedSelectBuilderImpl$invoke$20);
    }

    @Override  // kotlinx.coroutines.selects.SelectBuilder
    public void invoke(SelectClause2 selectClause20, Object object0, Function2 function20) {
        kotlinx.coroutines.selects.UnbiasedSelectBuilderImpl.invoke.3 unbiasedSelectBuilderImpl$invoke$30 = new Function0(this, object0, function20) {
            final Function2 $block;
            final Object $param;
            final SelectClause2 $this_invoke;

            {
                this.$this_invoke = selectClause20;
                UnbiasedSelectBuilderImpl.this = unbiasedSelectBuilderImpl0;
                this.$param = object0;
                this.$block = function20;
                super(0);
            }

            @Override  // kotlin.jvm.functions.Function0
            public Object invoke() {
                this.invoke();
                return Unit.INSTANCE;
            }

            public final void invoke() {
                this.$this_invoke.registerSelectClause2(UnbiasedSelectBuilderImpl.this.getInstance(), this.$param, this.$block);
            }
        };
        this.clauses.add(unbiasedSelectBuilderImpl$invoke$30);
    }

    @Override  // kotlinx.coroutines.selects.SelectBuilder
    public void invoke(SelectClause2 selectClause20, Function2 function20) {
        DefaultImpls.invoke(this, selectClause20, function20);
    }

    @Override  // kotlinx.coroutines.selects.SelectBuilder
    public void onTimeout(long v, Function1 function10) {
        kotlinx.coroutines.selects.UnbiasedSelectBuilderImpl.onTimeout.1 unbiasedSelectBuilderImpl$onTimeout$10 = new Function0(v, function10) {
            final Function1 $block;
            final long $timeMillis;

            {
                UnbiasedSelectBuilderImpl.this = unbiasedSelectBuilderImpl0;
                this.$timeMillis = v;
                this.$block = function10;
                super(0);
            }

            @Override  // kotlin.jvm.functions.Function0
            public Object invoke() {
                this.invoke();
                return Unit.INSTANCE;
            }

            public final void invoke() {
                UnbiasedSelectBuilderImpl.this.getInstance().onTimeout(this.$timeMillis, this.$block);
            }
        };
        this.clauses.add(unbiasedSelectBuilderImpl$onTimeout$10);
    }
}

