package com.dev.eficiente.casadocodigo.validations;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target({FIELD, METHOD, PARAMETER, CONSTRUCTOR, ANNOTATION_TYPE, TYPE_USE})
@Constraint(validatedBy = TituloLivroUnicoValidation.class)

public @interface TituloLivroUnico {

  String message() default "Titulo do livro ja existe na base";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  @Documented
  @Retention(RUNTIME)
  @Target({FIELD, METHOD, PARAMETER, CONSTRUCTOR, ANNOTATION_TYPE, TYPE_USE})
  @interface List {
    TituloLivroUnico[] value();
  }

}
