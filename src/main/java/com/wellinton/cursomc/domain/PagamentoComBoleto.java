package com.wellinton.cursomc.domain;

import java.util.Date;

import com.wellinton.cursomc.domain.enums.EstadoPagamento;

public class PagamentoComBoleto extends Pagamento {
	private Date dataVencimento;
	private Date dataPagamento;

	//Construtor Vazio
	public PagamentoComBoleto() {}
	
	//Construtor - Superclass
	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
		super(id, estado, pedido);
		this.dataPagamento = dataPagamento;
		this.dataVencimento = dataVencimento;
	}

	


}
