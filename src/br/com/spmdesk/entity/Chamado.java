package br.com.spmdesk.entity;

import java.util.Date;

public class Chamado {
	
	private String descricao;
	private String setor;
	private String solicitante;
	
	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	private Date dataChamado;
	private String assunto;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public Date getDataChamado() {
		return dataChamado;
	}

	public void setDataChamado(Date dataChamado) {
		this.dataChamado = dataChamado;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getMensagemAjuda() {
		return descricao;
	}

	public void setMensagemAjuda(String mensagemAjuda) {
		this.descricao = mensagemAjuda;
	}
}
