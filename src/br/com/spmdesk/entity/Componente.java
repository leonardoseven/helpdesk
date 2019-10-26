package br.com.spmdesk.entity;
public class Componente {
	private String nome;
	private double preco;
	private String descrição;
	private int qtdPeca;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getDescrição() {
		return descrição;
	}
	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}
	public int getQtdPeca() {
		return qtdPeca;
	}
	public void setQtdPeca(int qtdPeca) {
		this.qtdPeca = qtdPeca;
	}
	
	
}
