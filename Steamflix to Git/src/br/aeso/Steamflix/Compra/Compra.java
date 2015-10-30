package br.aeso.Steamflix.Compra;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import br.aeso.Steamflix.Cliente.Cliente;
import br.aeso.Steamflix.Cupom.Cupom;
import br.aeso.Steamflix.Filme.Filme;
import br.aeso.Steamflix.Jogo.Jogo;

public class Compra {
	private int id;
	private double preco;
	private Calendar data;
	private ArrayList<Jogo> jogos;
	private ArrayList<Filme> filmes;
	private Cliente cliente;
	private Date date;
	private Cupom cupom;
	private int flag;

	public Compra(int id, Calendar data, Cliente cliente) {
		this.id = id;
		this.data = Calendar.getInstance();
		this.cliente = cliente;
		this.jogos = new ArrayList<Jogo>();
		this.filmes = new ArrayList<Filme>();
		this.date = new Date();
	}

	public Compra() {
		this.jogos = new ArrayList<Jogo>();
		this.filmes = new ArrayList<Filme>();
		this.data = Calendar.getInstance();
		this.date = new Date();
		this.setData();
		this.cupom = new Cupom();
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

	public void setData(Calendar data) {
		this.data = data;
	}

	public ArrayList<Jogo> getJogos() {
		return jogos;
	}

	public void setJogos(Jogo jogo) {
		this.jogos.add(jogo);
		this.setPreco();
	}

	public ArrayList<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(Filme filme) {
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
		if (this.cupom.getValor() == 0) {
			return this.preco;
		} else {
			return this.preco - (this.preco * this.cupom.getValor());
		}
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public void setPreco() {
		double preco = 0;
		for (Filme filme : filmes) {
			preco = preco + filme.getPrecoVenda();
		}
		for (Jogo jogo : jogos) {
			preco = preco + jogo.getPrecoVenda();
		}
		this.preco = preco;
	}

	public String dataFormatada() {
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
		return df.format(this.data.getTime());
	}

	public String retornaFilmes() {
		String listaFilmes = "";
		for (Filme filme : filmes) {
			listaFilmes = listaFilmes + filme.getId() + "\t" + filme.getNome()
					+ "\tR$ " + filme.getPrecoVenda() + "\n";
		}
		return listaFilmes;
	}

	public String retornaJogos() {
		String listaJogos = "";
		for (Jogo jogo : jogos) {
			listaJogos = listaJogos + jogo.getId() + "\t" + jogo.getNome()
					+ "\tR$ " + jogo.getPrecoVenda() + "\n";
		}
		return listaJogos;
	}

	public Cupom getCupom() {
		return cupom;
	}

	public void setCupom(Cupom cupom) {
		this.cupom = cupom;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "Compra id: " + id + "\nData da compra: " + this.dataFormatada()
				+ "\n" + cliente.getNome() + "\n" + retornaJogos()
				+ this.retornaFilmes() + "Cupom "
				+ this.getCupom().getValorFormatado() + "Total: R$" + preco;
	}
}
