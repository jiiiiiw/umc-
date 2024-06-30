package umcstudybook.spring.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umcstudybook.spring.validation.validator.CheckPageValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CheckPageValidator.class)
@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPage {
    //    String value() default "page";
    String message() default "페이지 번호가 잘못되었습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}