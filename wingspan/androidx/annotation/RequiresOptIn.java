package androidx.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

@Retention(RetentionPolicy.CLASS)
@Target({ElementType.ANNOTATION_TYPE})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0002\u0018\u00002\u00020\u0001:\u0001\u0005B\n\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003R\u000F\u0010\u0002\u001A\u00020\u0003¢\u0006\u0006\u001A\u0004\b\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Landroidx/annotation/RequiresOptIn;", "", "level", "Landroidx/annotation/RequiresOptIn$Level;", "()Landroidx/annotation/RequiresOptIn$Level;", "Level", "annotation-experimental_release"}, k = 1, mv = {1, 4, 2})
@kotlin.annotation.Retention(AnnotationRetention.BINARY)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS})
public @interface RequiresOptIn {
    // 部分失败：枚举糖化
    // 枚举按原样呈现，而不是糖化为Java 5枚举。
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Landroidx/annotation/RequiresOptIn$Level;", "", "(Ljava/lang/String;I)V", "WARNING", "ERROR", "annotation-experimental_release"}, k = 1, mv = {1, 4, 2})
    public static final class Level extends Enum {
        private static final Level[] $VALUES;
        public static final enum Level ERROR;
        public static final enum Level WARNING;

        static {
            Level[] arr_requiresOptIn$Level = new Level[2];
            Level.WARNING = new Level("WARNING", 0);
            arr_requiresOptIn$Level[0] = Level.WARNING;
            Level.ERROR = new Level("ERROR", 1);
            arr_requiresOptIn$Level[1] = Level.ERROR;
            Level.$VALUES = arr_requiresOptIn$Level;
        }

        private Level(String s, int v) {
            super(s, v);
        }

        public static Level valueOf(String s) {
            return (Level)Enum.valueOf(Level.class, s);
        }

        public static Level[] values() {
            return (Level[])Level.$VALUES.clone();
        }
    }

    Level level() default Level.ERROR;
}

