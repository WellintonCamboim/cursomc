package com.wellinton.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
//Mapeamento da class Produto -->@Entity

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity 
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Double preco;
	
	//Uma produto possui no minimo 1 categoria ou várias categorias - 
	//Fonte UML - Por isso devemos construir uma lista de categorias
	//categorias - Nome do papel - Ver em UML
	//Para iniciar --> produtos = new ArrayList<>();
	
	//@JoinTable define a tabela que fará a ligação de muitos para muitos no banco de dados relacional
	
	/*Mapeamento da lista de categorias informando quem irá ser a tabela de banco de dados que 
	 * irá fazer o meio de campe entre as duas tabelas (CATEGORIA E PRODUTO)*/

	//Conexões entre chaves estrangeiras

	// joinColumns → Para atribuir a chave estrangeira de Produto = produto_id

	//inverseJoinColumns → Outra chave estrangeira que irá referenciar a categoria = categoria_id
	
	@JsonBackReference //Aula-S2-17, Irá omitir a lista de categorias para cada produto
	@ManyToMany
	@JoinTable(name = "PRODUTO_CATEGORIA",
			joinColumns = @JoinColumn(name = "produto_id"),
			inverseJoinColumns = @JoinColumn(name ="categoria_id")
	)
	private List<Categoria> categorias = new ArrayList<>();
	
	//Construtor Vazio
	public Produto() {
		
	}
	//Categoria não irá entrar no contrutor -Já foi iniciado em cima pela List
	//--> não inclua coleções no construtor com parâmetros
	public Produto(Integer id, String nome, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}
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
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public List<Categoria> getCategorias() {
		return categorias;
	}
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	//hashCode e equals (implementação padrão: somente id) --> 
	//Criar com base somente no id, para comparar pelo conteúdo e não pelo ponteiro
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
