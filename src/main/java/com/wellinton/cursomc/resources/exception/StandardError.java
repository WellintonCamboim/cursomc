package com.wellinton.cursomc.resources.exception;

import java.io.Serializable;

//Aula S2-17
public class StandardError implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	private Integer status;
	private String msg;
	private Long timeStamp;
	
	//Construtor
	public StandardError(Integer status, String msg, Long timeStamp) {
		super();
		this.status = status;
		this.msg = msg;
		this.timeStamp = timeStamp;
	}
	
	//Getters e Setters
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

	
	
}
