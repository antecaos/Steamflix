package br.aeso.Steamflix.Cupom;

public class Cupom {
	private int id;
	private String nome;
	private double valor;
	private int flag;

	public Cupom() {
		this.id = 12;
		this.flag = 1;
	}

	public Cupom(String nome, double valor) {
		this.id = 12;
		this.nome = nome;
		this.valor = valor;
		this.flag = 1;
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

	public String getValorFormatado() {
		if (this.getId() == 0) {
			return 0.0 + "%";
		} else {
			return this.valor + "%";
		}
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "Cupom id: " + id + "\nNome: " + nome + "\nvalor: " + valor;
	}

}
