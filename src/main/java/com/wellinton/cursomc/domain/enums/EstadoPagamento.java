package com.wellinton.cursomc.domain.enums;

public enum EstadoPagamento {
	
	PENDENTE(1,"Pendente"),
	QUITADO(2,"Quitado"),
	CANCELADO(3,"Cancelado");
	
	//Variáveis internas para armazenamento dos valores 
		private int cod;
		private String descricao;
		
		//Construtor do TipoEnumerado
		private EstadoPagamento(int cod, String descricao) {
			this.cod = cod;
			this.descricao = descricao;
		}
		//Getters
		public int getCod() {
			return cod;
		}
		public String getDescricao() {
			return descricao;
		}
		//Algoritmo para fazer busca --> 1=PESSOA FISÍCA / 2=PESSOA JURÍDICA
		public static EstadoPagamento toEnum(Integer cod) {
			if (cod == null) {
				return null;
			}
			for (EstadoPagamento x : EstadoPagamento.values()) {
				if(cod.equals(x.getCod())) {
					return x;
				}
			}
			//Para quando o código for inválido -- Exceção --> IllegalArgumentException()
			throw new IllegalArgumentException("Id inválido: " + cod);
		}

}
