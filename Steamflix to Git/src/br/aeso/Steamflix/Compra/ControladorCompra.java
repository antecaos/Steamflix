package br.aeso.Steamflix.Compra;

import java.util.ArrayList;

import br.aeso.Steamflix.Compra.Compra;
import br.aeso.Steamflix.Compra.IRepositorioCompra;
import br.aeso.Steamflix.Compra.RepositorioCompraDAO;
import br.aeso.Steamflix.Cliente.Cliente;
import br.aeso.Steamflix.Cliente.ControladorCliente;
import br.aeso.Steamflix.Cupom.ControladorCupom;
import br.aeso.Steamflix.Cupom.Cupom;
import br.aeso.Steamflix.Filme.ControladorFilme;
import br.aeso.Steamflix.Filme.Filme;
import br.aeso.Steamflix.Jogo.ControladorJogo;
import br.aeso.Steamflix.Jogo.Jogo;

public class ControladorCompra {
	private IRepositorioCompra repositorioCompra;
	private ControladorCliente controladorCliente;
	private ControladorCupom controladorCupom;
	private ControladorFilme controladorFilme;
	private ControladorJogo controladorJogo;

	public ControladorCompra() {
		this.repositorioCompra = new RepositorioCompraDAO();
		this.controladorCliente = new ControladorCliente();
		this.controladorCupom = new ControladorCupom();
		this.controladorFilme = new ControladorFilme();
		this.controladorJogo = new ControladorJogo();
	}

	public void cadastrar(Compra compra) {
		this.repositorioCompra.cadastrar(compra);
	}

	public void atualizar(Compra compra) {
		this.repositorioCompra.atualizar(compra);
	}

	public void remover(int id) {
		this.repositorioCompra.remover(id);
	}

	public Compra procurar(int id) {
		Compra compra = null;
		Cliente cliente = null;
		Cupom cupom = null;
		compra = this.repositorioCompra.procurar(id);

		cliente = controladorCliente.procurar(compra.getCliente().getCPF());
		if(compra.getCupom().getId() == 0){
			compra.getCupom().setId(12);			
		}
		cupom = controladorCupom.procurar(compra.getCupom().getId());
		
		
		compra.setCliente(cliente);
		compra.setCupom(cupom);

		for (Filme filme : compra.getFilmes()) {
			compra.getFilmes().set(compra.getFilmes().lastIndexOf(filme),
					this.controladorFilme.procurar(filme.getId()));
			compra.setPreco();

		}

		for (Jogo jogo : compra.getJogos()) {
			compra.getJogos().set(compra.getJogos().lastIndexOf(jogo),
					this.controladorJogo.procurar(jogo.getId()));
			compra.setPreco();
		}

		return compra;
	}

	public ArrayList<Compra> listar() {
		ArrayList<Compra> alugueis = null;

		alugueis = this.repositorioCompra.listar();

		for (Compra compra : alugueis) {
			alugueis.set(alugueis.lastIndexOf(compra),
					this.procurar(compra.getId()));
		}

		return alugueis;
	}
	
	public ArrayList<Compra> listarPorCliente(String cpf) {
		ArrayList<Compra> alugueis = null;

		alugueis = this.repositorioCompra.listarPorCliente(cpf);

		for (Compra compra : alugueis) {
			alugueis.set(alugueis.lastIndexOf(compra),
					this.procurar(compra.getId()));
		}

		return alugueis;
	}
}
