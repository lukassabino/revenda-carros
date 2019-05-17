package br.com.lukas.atividades.enuns;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum EnumStatusCarro {

	VENDIDO, 
	NAO_VENDIDO;

	@JsonCreator
	public static EnumStatusCarro getByCodigo(String codigo) {
		return EnumStatusCarro.valueOf(codigo);
	}

}
