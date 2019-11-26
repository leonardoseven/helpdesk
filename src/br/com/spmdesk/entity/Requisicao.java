package br.com.spmdesk.entity;

public class Requisicao {
	private String descricao;
	private String solicitante;
	private String dataChamado;
	private int qtdPeca;
	private String componente;
	private String setor;
	
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		this.setor = setor;
	}
	public String getComponente() {
		return componente;
	}
	public void setComponente(String componente) {
		this.componente = componente;
	}
	private Componente nomePeca;
	private String assunto;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String mensagemAjuda) {
		this.descricao = mensagemAjuda;
	}
	public String getSolicitante() {
		return solicitante;
	}
	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}
	public String getDataChamado() {
		return dataChamado;
	}
	public void setDataChamado(String dataChamado) {
		this.dataChamado = dataChamado;
	}
	public int getQtdPeca() {
		return qtdPeca;
	}
	public void setQtdPeca(int qtdPeca) {
		this.qtdPeca = qtdPeca;
	}
	public Componente getNomePeca() {
		return nomePeca;
	}
	public void setNomePeca(Componente nomePeca) {
		this.nomePeca = nomePeca;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	
}
