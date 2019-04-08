package com.wellinton.cursomc.domain.enums;

//Tipo Enumerado - Aula - S219
public enum TipoCliente {
	PESSOAFISICA(1, "Pessoa Física"), PESSOAJURIDICA(2, "Pessoa Jurídica");
	
	//Variáveis internas para armazenamento dos valores 
	private int cod;
	private String descricao;
	
	//Construtor do TipoEnumerado
	private TipoCliente(int cod, String descricao) {
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
	public static TipoCliente toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (TipoCliente x : TipoCliente.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		//Para quando o código for inválido -- Exceção --> IllegalArgumentException()
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
