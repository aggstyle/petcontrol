package br.com.tavares.petcontrol.enums;

public enum EPetControlErros {

	REGISTRO_JA_EXISTE("Este registro já existe.");

	private final String descricaoErro;

	private EPetControlErros(String descricaoErro) {
		this.descricaoErro = descricaoErro;

	}

	public String getDescricao() {
		return descricaoErro;
	}

}
