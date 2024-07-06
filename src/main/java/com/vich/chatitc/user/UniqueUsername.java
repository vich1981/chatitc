package com.vich.chatitc.user;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueUsernameValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueUsername {
    String message() default "{chatitc.constraints.username.UniqueUsername.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };


}
