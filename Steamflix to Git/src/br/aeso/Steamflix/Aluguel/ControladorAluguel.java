package br.aeso.Steamflix.Aluguel;

import java.util.ArrayList;

import br.aeso.Steamflix.Cliente.Cliente;
import br.aeso.Steamflix.Cliente.ControladorCliente;
import br.aeso.Steamflix.Cupom.ControladorCupom;
import br.aeso.Steamflix.Cupom.Cupom;
import br.aeso.Steamflix.Filme.ControladorFilme;
import br.aeso.Steamflix.Filme.Filme;
import br.aeso.Steamflix.Jogo.ControladorJogo;
import br.aeso.Steamflix.Jogo.Jogo;

public class ControladorAluguel {
	private IRepositorioAluguel repositorioAluguel;
	private ControladorCliente controladorCliente;
	private ControladorCupom controladorCupom;
	private ControladorFilme controladorFilme;
	private ControladorJogo controladorJogo;

	public ControladorAluguel() {
		this.repositorioAluguel = new RepositorioAluguelDAO();
		this.controladorCliente = new ControladorCliente();
		this.controladorCupom = new ControladorCupom();
		this.controladorFilme = new ControladorFilme();
		this.controladorJogo = new ControladorJogo();
	}

	public void cadastrar(Aluguel aluguel) {
		this.repositorioAluguel.cadastrar(aluguel);
	}

	public void atualizar(Aluguel aluguel) {
		this.repositorioAluguel.atualizar(aluguel);
	}

	public void remover(int id) {
		this.repositorioAluguel.remover(id);
	}

	public Aluguel procurar(int id) {
		Aluguel aluguel = null;
		Cliente cliente = null;
		Cupom cupom = null;
		aluguel = this.repositorioAluguel.procurar(id);

		cliente = controladorCliente.procurar(aluguel.getCliente().getCPF());
		if(aluguel.getCupom().getId() == 0){
			aluguel.getCupom().setId(12);			
		}
		cupom = controladorCupom.procurar(aluguel.getCupom().getId());
		
		
		aluguel.setCliente(cliente);
		aluguel.setCupom(cupom);

		for (Filme filme : aluguel.getFilme()) {
			aluguel.getFilme().set(aluguel.getFilme().lastIndexOf(filme),
					this.controladorFilme.procurar(filme.getId()));
			aluguel.setPreco();

		}

		for (Jogo jogo : aluguel.getJogo()) {
			aluguel.getJogo().set(aluguel.getJogo().lastIndexOf(jogo),
					this.controladorJogo.procurar(jogo.getId()));
			aluguel.setPreco();
		}

		return aluguel;
	}

	public ArrayList<Aluguel> listar() {
		ArrayList<Aluguel> alugueis = null;

		alugueis = this.repositorioAluguel.listar();

		for (Aluguel aluguel : alugueis) {
			alugueis.set(alugueis.lastIndexOf(aluguel),
					this.procurar(aluguel.getId()));
		}

		return alugueis;
	}
}
