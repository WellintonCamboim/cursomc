package com.wellinton.cursomc.domain;

import java.util.Date;

//Aula - S2-22
public class Pedido {
	
	private Integer id;
	private Date instante;
	
	private Pagamento pagamento;
	
	//Pedido tem um cliente e um enderecoDeEntrega
	
	private Cliente cliente;
	
	private Endereco enderecoDeEntrega;
	
	//Construtor Vazio
	public Pedido() {}
	//Construtor
	public Pedido(Integer id, Date instante, Pagamento pagamento, Cliente cliente, Endereco enderecoDeEntrega) {
		super();
		this.id = id;
		this.instante = instante;
		this.pagamento = pagamento;
		this.cliente = cliente;
		this.enderecoDeEntrega = enderecoDeEntrega;
	}
	

	
	
	
	

}
