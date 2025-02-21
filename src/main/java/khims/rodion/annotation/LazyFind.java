package khims.rodion.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
public @interface LazyFind {
    long timeout() default 30;
    long period() default 3;
    ExpectConditionType waitType() default ExpectConditionType.WAITFOR;
    String xpath();
}
