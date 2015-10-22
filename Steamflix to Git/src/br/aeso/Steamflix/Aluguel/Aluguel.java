package br.aeso.Steamflix.Aluguel;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import br.aeso.Steamflix.Cliente.Cliente;
import br.aeso.Steamflix.Filme.Filme;
import br.aeso.Steamflix.Jogo.Jogo;

public class Aluguel {
	private int id;
	private Calendar data;
	private double preco;
	private Calendar dataDevolucao;
	private ArrayList<Jogo> jogos;
	private ArrayList<Filme> filmes;
	private Cliente cliente;
	private Date date;

	public Aluguel() {
		this.jogos = new ArrayList<Jogo>();
		this.filmes = new ArrayList<Filme>();
		this.data = Calendar.getInstance();
		this.dataDevolucao = Calendar.getInstance();
		this.date = new Date();
	}

	public Aluguel(int id, Cliente cliente) {
		this.id = id;
		this.jogos = new ArrayList<Jogo>();
		this.filmes = new ArrayList<Filme>();
		this.cliente = cliente;
		this.data = Calendar.getInstance();
		this.dataDevolucao = Calendar.getInstance();
		this.date = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getData() {
		return data;
	}

	public void setData() {
		this.data.setTime(date);
	}

	public Calendar getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao() {
		this.dataDevolucao.setTime(date);
		this.dataDevolucao.add(Calendar.DAY_OF_MONTH, 3);
	}

	public ArrayList<Jogo> getJogo() {
		return jogos;
	}

	public void setJogo(Jogo jogo) {
		this.jogos.add(jogo);
		this.setPreco();
	}

	public ArrayList<Filme> getFilme() {
		return filmes;
	}

	public void setFilme(Filme filme) {
		this.filmes.add(filme);
		this.setPreco();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco() {
		double preco = 0;
		for (Filme filme : filmes) {
			preco = preco + filme.getPrecoAluguel();
		}
		for (Jogo jogo : jogos) {
			preco = preco + jogo.getPrecoAluguel();
		}
		this.preco = preco;
	}

	public String dataFormatada() {
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
		return df.format(this.data.getTime());
	}

	public String dataDevolucaoFormatada() {
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
		return df.format(this.dataDevolucao.getTime());
	}

	public String retornaFilmes() {
		String listaFilmes = "";
		for (Filme filme : filmes) {
			listaFilmes = listaFilmes + filme.getId() + "\t" + filme.getNome()
					+ "\tR$ " + filme.getPrecoAluguel() + "\n";
		}
		return listaFilmes;
	}

	public String retornaJogos() {
		String listaJogos = "";
		for (Jogo jogo : jogos) {
			listaJogos = listaJogos + jogo.getId() + "\t" + jogo.getNome()
					+ "\tR$ " + jogo.getPrecoAluguel() + "\n";
		}
		return listaJogos;
	}

	@Override
	public String toString() {
		return "Aluguel id: " + id + "\nData do aluguel: " + dataFormatada()
				+ "\nData de Devolucao: " + dataDevolucaoFormatada()
				+ "\nCliente: " + cliente.getNome() + "\nID" + "\t" + "Nome"
				+ "\tR$ " + "\t\t\t\tPreço" + "\n" + retornaJogos()
				+ retornaFilmes() + "Total: R$" + preco;
	}
}
