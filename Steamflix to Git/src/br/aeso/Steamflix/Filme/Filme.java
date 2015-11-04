package br.aeso.Steamflix.Filme;

import java.text.DateFormat;
import java.util.Calendar;

import br.aeso.Steamflix.Produtos.Produtos;

public class Filme extends Produtos {

	private String diretor;
	private int flag;

	public Filme(int id, String nome, double precoVenda, double precoAluguel,
			String nota, String classificacao, Calendar dataLancamento) {
		super(id, nome, precoVenda, precoAluguel, nota, classificacao,
				dataLancamento);
		// TODO Auto-generated constructor stub
	}

	public Filme() {
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "Filme: " + id + "\nNome:" + nome + "\nPreço Venda:" + precoVenda
				+ ", Preço Aluguel: " + precoAluguel + "\nNota: " + nota
				+ "\nClassificação: " + classificacao + "\nGênero: "
				+ genero.getNome() + "\nFornecedor: "
				+ fornecedor.getNomeFantasia() + "\nDirigido por " + diretor
				+ "\nData de Lançamento: " + dataFormatada();
	}
}
