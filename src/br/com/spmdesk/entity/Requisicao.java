package br.com.spmdesk.entity;

import java.util.Date;

public class Requisicao {
	private String descricao;
	private Usuario solicitante;
	private String dataChamado;
	private int qtdPeça;
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
