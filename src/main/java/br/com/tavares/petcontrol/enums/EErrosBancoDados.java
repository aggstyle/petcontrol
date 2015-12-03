package br.com.tavares.petcontrol.enums;

public enum EErrosBancoDados {

	ABRE_CONEXAO("Falha ao conectar com o banco de dados"), FECHA_CONEXAO(
			"Falha ao fechar a conex�o com o banco de dados"), CRIA_TABELA(
			"Erro ao criar a tabela : "), 
			EXCLUI_TABELA("Erro ao excluir tabela : "), 
			EXCLUI_REGISTRO("Erro ao excluir regitro : "),
			INSERE_DADOS(
			"Erro ao inserir registro :"), VALORES_PADRAO(
			"Erro ao inserir valores padr�es"), RETORNAR_VALOR(
			"Erro ao retornar valor : "), 
			RETORNAR_ULTIMO_REGISTRO("Erro ao retornar o ultimo registro"),
			RETORNAR_QTD_COUNT("Erro ao retornar quantidade de registros"),
			VALIDA_VALOR(
			"Erro ao validar valor no banco:"), CONSULTA_VALOR(
			"Erro ao realizar consulta no banco:"), ATUALIZA_VALOR(
			"Erro ao atualizar registro no banco:");

	private final String descricaoErro;

	private EErrosBancoDados(String descricaoErro) {
		this.descricaoErro = descricaoErro;

	}

	public String getDescricao() {
		return descricaoErro;
	}

}
