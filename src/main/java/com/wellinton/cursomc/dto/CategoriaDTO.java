package com.wellinton.cursomc.dto;

import java.io.Serializable;

import com.wellinton.cursomc.domain.Categoria;

//Aula-S3-34- DTO
//DTO - Objeto para definir os dados que eu quero trafegar quando realizar operações básicas de Categoria

public class CategoriaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;

	// Construtor Vazio
	public CategoriaDTO() {

	}

	//
	public CategoriaDTO(Categoria obj) {
		id = obj.getId();
		nome = obj.getNome();
	}

	// Getters e Setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
