package br.aeso.Steamflix.Jogo;

import java.text.DateFormat;
import java.util.Calendar;

import br.aeso.Steamflix.Produtos.Produtos;

public class Jogo extends Produtos {

	private String desenvolvedor;
	private int flag;

	public Jogo(int id, String nome, double precoVenda, double precoAluguel,
			String nota, String classificacao, Calendar dataLancamento) {
		super(id, nome, precoVenda, precoAluguel, nota, classificacao,
				dataLancamento);
		// TODO Auto-generated constructor stub
	}

	public Jogo() {
	}

	public String getDesenvolvedor() {
		return desenvolvedor;
	}

	public void setDesenvolvedor(String desenvolvedor) {
		this.desenvolvedor = desenvolvedor;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "Jogo: " + id + "\nNome:" + nome + "\nPreço Venda:" + precoVenda
				+ ", Preço Aluguel: " + precoAluguel + "\nNota: " + nota
				+ "\nClassificação: " + classificacao + "\nGênero: " + genero.getNome()
				+ "\nFornecedor: " + fornecedor.getNomeFantasia()
				+ "\nDesenvolvido por " + desenvolvedor
				+ "\nData de Lançamento: " + dataFormatada();
	}

}
