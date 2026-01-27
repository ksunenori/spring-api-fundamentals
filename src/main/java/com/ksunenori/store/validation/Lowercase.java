package com.ksunenori.store.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD) //specify where you want to apply this annotation. You can pass one or more by wrapping in {} like an array.
@Retention(RetentionPolicy.RUNTIME) //specify where this annotation is applied
@Constraint(validatedBy = LowercaseValidator.class)
public @interface Lowercase {
    String message() default "must be lowercase";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
