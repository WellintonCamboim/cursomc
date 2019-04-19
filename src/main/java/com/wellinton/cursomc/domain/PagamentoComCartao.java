package com.wellinton.cursomc.domain;

import javax.persistence.Entity;

import com.wellinton.cursomc.domain.enums.EstadoPagamento;

//A anotação @Entity é utilizada para informar que uma classe também é uma entidade. Uma entidade representa, na Orientação a Objetos, 
//uma tabela do banco de dados, e cada instância dessa entidade representa uma linha dessa tabela.
@Entity
public class PagamentoComCartao extends Pagamento {
	private static final long serialVersionUID = 1L;

	private Integer numeroDeParcelas;

	// Construtor Vazio
	public PagamentoComCartao() {
	}

	// Construtor
	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
		super(id, estado, pedido);
		this.numeroDeParcelas = numeroDeParcelas;
	}

	// Getters e Setters
	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}

}
