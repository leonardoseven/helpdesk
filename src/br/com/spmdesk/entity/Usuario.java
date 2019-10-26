package br.com.spmdesk.entity;

public class Usuario {
	
	private String nome;
	private String pass;
	private String tipo;
	private String registro;
	private Setor nomeSetor;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getRegistro() {
		return registro;
	}
	public void setRegistro(String registro) {
		this.registro = registro;
	}
	public Setor getNomeSetor() {
		return nomeSetor;
	}
	public void setNomeSetor(Setor nomeSetor) {
		this.nomeSetor = nomeSetor;
	}
	
	
	
}
