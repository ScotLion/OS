package com.alessandro.os.domain.enums;

public enum Prioridade {

	BAIXA(0, "BAIXA"), MEDIA(1, "MEDIA"), ALTA(2, "ALTO");

	private Integer codPrioridade;
	private String decicaoPro;

	private Prioridade(Integer codPrioridade, String decicaoPro) {
		this.codPrioridade = codPrioridade;
		this.decicaoPro = decicaoPro;
	}

	public Integer getCodPrioridade() {
		return codPrioridade;
	}

	public String getDecicaoPro() {
		return decicaoPro;
	}
	
	public static Prioridade toEnum(Integer codPropriedade) {
		if(codPropriedade == null) {
			return null;
		}
		
		for(Prioridade x : Prioridade.values()) {
			return x;
		}
		throw new IllegalArgumentException("Prioriudade Invalida " + codPropriedade);
	}

}
