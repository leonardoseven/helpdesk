package br.com.spmdesk.entity;

import java.util.Date;

public class Requisicao {
	private String mensagemAjuda;
	private Usuario solicitante;
	private Date dataChamado;
	private int qtdPe�a;
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
	public int getQtdPe�a() {
		return qtdPe�a;
	}
	public void setQtdPe�a(int qtdPe�a) {
		this.qtdPe�a = qtdPe�a;
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
