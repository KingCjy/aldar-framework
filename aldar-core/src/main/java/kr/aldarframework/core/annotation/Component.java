package kr.aldarframework.core.annotation;

import java.lang.annotation.*;

/**
 * @author KingCjy
 */

@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
    String value() default "";
}
