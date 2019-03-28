package com.wellinton.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity //Indica que a presente class será uma entidade do JPA-- Para criar a tab. de BD
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //Para definir a estratégia de geração automatica 
	//dos Ids das minhas categorias-- Para criar a tab. de BD
	private Integer id;
	private String nome;
	
	//Uma categoria possui vários produtos - Fonte UML - Por isso devemos construir uma lista de produtos
	//produtos - Nome do papel - Ver em UML
	
	
	@ManyToMany(mappedBy="categorias")
	private List<Produto> produtos = new ArrayList<>();
	//Para iniciar --> produtos = new ArrayList<>();
	
	public Categoria() {
		
	}

	public Categoria(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
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

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	//hashCode e equals (implementação padrão: somente id) --> 
	//Criar com base somente no id, para comparar pelo conteúdo e não pelo ponteiro
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
}
