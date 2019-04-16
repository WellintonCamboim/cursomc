package com.wellinton.cursomc.domain;

import com.wellinton.cursomc.domain.enums.EstadoPagamento;

//Aula - S2-22
public class Pagamento {
	private Integer id;
	private EstadoPagamento estado;
	
	private Pedido pedido;
	
	//Construtor Vazio
	public Pagamento() {}
	//Construtor 
	public Pagamento(Integer id, EstadoPagamento estado, Pedido pedido) {
		super();
		this.id = id;
		this.estado = estado;
		this.pedido = pedido;
	}
	

	
	
}
