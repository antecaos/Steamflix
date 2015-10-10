package br.aeso.Steamflix.Produtos;

import java.text.DateFormat;
import java.util.Calendar;

import br.aeso.Steamflix.Fornecedor.Fornecedor;
import br.aeso.Steamflix.Genero.Genero;

public abstract class Produtos {
	protected int id;
	protected String nome;
	protected double precoVenda;
	protected double precoAluguel;
	protected String nota;
	protected String classificacao;
	protected Genero genero;
	protected Fornecedor fornecedor;
	protected Calendar dataLancamento;
	protected int quantidade;

	public Produtos() {
	}

	public Produtos(int id, String nome, double precoVenda,
			double precoAluguel, String nota, String classificacao,
			Calendar dataLancamento) {
		this.id = id;
		this.nome = nome;
		this.precoVenda = precoVenda;
		this.precoAluguel = precoAluguel;
		this.nota = nota;
		this.classificacao = classificacao;		
		this.dataLancamento = dataLancamento;
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

	public double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public double getPrecoAluguel() {
		return precoAluguel;
	}

	public void setPrecoAluguel(double precoAluguel) {
		this.precoAluguel = precoAluguel;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Calendar getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Calendar dataLancamento) {
		this.dataLancamento = dataLancamento;
	}	
	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String dataFormatada(){
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
		return df.format(this.dataLancamento.getTime());
	}

	@Override
	public String toString() {
		return "Produtos [id=" + id + ", nome=" + nome + ", precoVenda="
				+ precoVenda + ", precoAluguel=" + precoAluguel + ", nota="
				+ nota + ", classificacao=" + classificacao + ", genero="
				+ genero + ", fornecedor=" + fornecedor
				+ ", dataLancamento=" + dataLancamento + "]";
	}

}
