package com.wellinton.cursomc.services.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

//Anotação 
//ClienteInsertValidator -> class que implementa o validation
//ClienteInsert --> É a anotação 
//Aula-S3-42- Validação customizada: CPF ou CNPJ na inserção de Cliente
@Constraint(validatedBy = ClienteInsertValidator.class)
@Target({ ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)

public @interface ClienteInsert {
	String message() default "Erro de validação";
	
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default {};
}
