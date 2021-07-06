package br.com.fileanalytictest.model;

import java.util.stream.Stream;

public enum IdentificadorEnum {

	VENDEDOR("001"), 
	CLIENTE("002"), 
	VENDA("003");

	private String codigo;
	
	IdentificadorEnum(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public static IdentificadorEnum getByValue(String codigo) {
		return Stream.of(IdentificadorEnum.values()).filter(i -> i.codigo.equals(codigo)).findFirst().orElse(null);
	}
	
}
