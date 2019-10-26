package br.com.spmdesk.entity;

import java.util.Date;

public class Chamado {
	
	private String mensagemAjuda;
	private Usuario solicitante;
	private Date dataChamado;
	private String assunto;

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
}
