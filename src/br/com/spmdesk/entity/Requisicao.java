package br.com.spmdesk.entity;

import java.util.Date;

public class Requisicao {
	private String mensagemAjuda;
	private Usuario solicitante;
	private Date dataChamado;
	private int qtdPeça;
	private Componente nomePeca;
	private String assunto;
	
	public String getMensagemAjuda() {
		return mensagemAjuda;
	}
	public void setMensagemAjuda(String mensagemAjuda) {
		this.mensagemAjuda = mensagemAjuda;
	}
	public Usuario getSolicitante() {
		return solicitante;
	}
	public void setSolicitante(Usuario solicitante) {
		this.solicitante = solicitante;
	}
	public Date getDataChamado() {
		return dataChamado;
	}
	public void setDataChamado(Date dataChamado) {
		this.dataChamado = dataChamado;
	}
	public int getQtdPeça() {
		return qtdPeça;
	}
	public void setQtdPeça(int qtdPeça) {
		this.qtdPeça = qtdPeça;
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
