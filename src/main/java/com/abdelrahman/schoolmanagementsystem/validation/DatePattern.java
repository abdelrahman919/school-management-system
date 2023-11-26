package com.abdelrahman.schoolmanagementsystem.validation;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotNull;

import java.lang.annotation.*;


@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {})
@JsonFormat(pattern = "dd-MM-yyyy")
public @interface DatePattern {

    String message() default "Date Format dd/MM/yyyy";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
