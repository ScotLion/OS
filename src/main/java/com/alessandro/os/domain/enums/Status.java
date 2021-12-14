package com.alessandro.os.domain.enums;

public enum Status {
	Aberto(0, "ABERTO"), Andamento(1, "ANDAMENTO"), Encerrado2(2, "ENCERRADO");

	private Integer codStatus;
	private String decicaoStatus;

	private Status(Integer codStatus, String decicaoStatus) {
		this.codStatus = codStatus;
		this.decicaoStatus = decicaoStatus;
	}

	public Integer getcodStatus() {
		return codStatus;
	}

	public String getdecicaoStatus() {
		return decicaoStatus;
	}
	
	public static Status toEnum(Integer codStatus) {
		if(codStatus == null) {
			return null;
		}
		
		for(Status x : Status.values()) {
			return x;
		}
		throw new IllegalArgumentException("Prioriudade Invalida " + codStatus);
	}
}
