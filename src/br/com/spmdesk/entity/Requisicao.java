package br.com.spmdesk.entity;

public class Requisicao {
	private String descricao;
	private Usuario solicitante;
	private String dataChamado;
	private int qtdPeca;
	private Componente nomePeca;
	private String assunto;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String mensagemAjuda) {
		this.descricao = mensagemAjuda;
	}
	public Usuario getSolicitante() {
		return solicitante;
	}
	public void setSolicitante(Usuario solicitante) {
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
