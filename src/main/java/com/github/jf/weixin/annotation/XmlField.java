package com.github.jf.weixin.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * xml注解<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface XmlField {
    public String name() default "";
    public String setFuncName() default "setField";
    public String getFuncName() default "getField";
}
