package com.wellinton.cursomc.services.exception;
//Aula S2-17 - Exceção Personalizada
public class ObjectNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(String msg) {
		super(msg);
	}
	public ObjectNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
