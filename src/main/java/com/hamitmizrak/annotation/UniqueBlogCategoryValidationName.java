package com.hamitmizrak.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {UniqueBlogCategoryValidation.class})
public @interface UniqueBlogCategoryValidationName {

    String message() default "{blog.category.unique.validation.constraints.NotNull.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
