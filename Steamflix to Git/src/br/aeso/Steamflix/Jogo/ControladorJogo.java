package br.aeso.Steamflix.Jogo;

import java.util.ArrayList;

import br.aeso.Steamflix.Jogo.Jogo;
import br.aeso.Steamflix.Jogo.IRepositorioJogo;
import br.aeso.Steamflix.Jogo.RepositorioJogoDAO;
import br.aeso.Steamflix.Fornecedor.ControladorFornecedor;
import br.aeso.Steamflix.Fornecedor.Fornecedor;
import br.aeso.Steamflix.Genero.ControladorGenero;
import br.aeso.Steamflix.Genero.Genero;

public class ControladorJogo {
	private IRepositorioJogo repositorioJogo;
	private ControladorFornecedor controladorFornecedor;
	private ControladorGenero controladorGenero;

	public ControladorJogo() {
		this.repositorioJogo = new RepositorioJogoDAO();
		this.controladorFornecedor = new ControladorFornecedor();
		this.controladorGenero = new ControladorGenero();
	}

	public void cadastrar(Jogo jogo) {
		this.repositorioJogo.cadastrar(jogo);

	}

	public void atualizar(Jogo jogo) {
		this.repositorioJogo.atualizar(jogo);

	}

	public void remover(int id) {
		this.repositorioJogo.remover(id);
	}

	public Jogo procurar(int id) {
		Jogo jogo = null;
		Genero genero = null;
		Fornecedor fornecedor = null;

		jogo = this.repositorioJogo.procurar(id);

		genero = this.controladorGenero.procurar(jogo.getGenero().getId());
		fornecedor = this.controladorFornecedor.procurar(jogo.getFornecedor()
				.getCNPJ());

		jogo.setFornecedor(fornecedor);
		jogo.setGenero(genero);
		return jogo;
	}

	public ArrayList<Jogo> listar() {
		ArrayList<Jogo> jogos = null;		

		jogos = this.repositorioJogo.listar();

		for (Jogo jogo : jogos) {
			jogos.set(jogos.lastIndexOf(jogo), this.procurar(jogo.getId()));									
		}
		
		return jogos;
	}
}
