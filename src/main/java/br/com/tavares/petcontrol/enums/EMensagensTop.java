package br.com.tavares.petcontrol.enums;

public enum EMensagensTop {

	
	MSG_VALUE("MSG_VALUE"),
	MSG_INFO("MSG_INFO"),
	
	TIPO_MSG("TIPO_MSG"), 
	
	TIPO_MSG_ERRO("MSG_ERRO"), 
	TIPO_MSG_SUCESSO("MSG_SUCESSO"),
	TIPO_MSG_AVISO("MSG_AVISO") ;

	private final String value;

	EMensagensTop(String value) {
		this.value = value;
	}

	public String getValor() {
		return value;
	}

}
