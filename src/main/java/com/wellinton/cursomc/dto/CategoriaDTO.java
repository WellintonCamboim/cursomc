package com.wellinton.cursomc.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.wellinton.cursomc.domain.Categoria;

//Aula-S3-34- DTO
//DTO - Objeto para definir os dados que eu quero trafegar quando realizar operações básicas de Categoria

public class CategoriaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	//Aula-S3-36
	@NotEmpty(message="Preenchimento obrigatório") //Validação sintática com Bean Validation
	@Length(min=5, max=80, message="O tamanho deve ser entre 5 e 80 caracteres") //Validação sintática com Bean Validation
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
