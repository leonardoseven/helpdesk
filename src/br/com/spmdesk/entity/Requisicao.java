package br.com.spmdesk.entity;

import java.util.Date;

public class Requisicao {
	private String descricao;
	private Usuario solicitante;
	private String dataChamado;
	private int qtdPe�a;
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
