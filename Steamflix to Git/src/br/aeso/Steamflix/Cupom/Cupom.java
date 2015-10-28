package br.aeso.Steamflix.Cupom;

public class Cupom {
	private int id;
	private String nome;
	private double valor;

	public Cupom() {
	}

	public Cupom(int id, String nome, double valor) {
		this.id = id;
		this.nome = nome;
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor / 100;
	}
	
	public String getValorFormatado(){
		return this.valor + "%";
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Cupom id: " + id + "\nNome: " + nome + "\nvalor: " + valor;
	}

}
