package com.wellinton.cursomc.domain;

import com.wellinton.cursomc.domain.enums.EstadoPagamento;

public class PagamentoComCartao extends Pagamento {
	
	private Integer numeroDeParcelas;
	
	//Construtor Vazio
	public PagamentoComCartao() {}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
		super(id, estado, pedido);
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	//Construtor - Superclass
	
	
	

}
