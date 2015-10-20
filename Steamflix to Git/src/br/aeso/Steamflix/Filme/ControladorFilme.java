package br.aeso.Steamflix.Filme;

import java.util.ArrayList;

import br.aeso.Steamflix.Fornecedor.Fornecedor;
import br.aeso.Steamflix.Fornecedor.ControladorFornecedor;
import br.aeso.Steamflix.Filme.Filme;
import br.aeso.Steamflix.Filme.IRepositorioFilme;
import br.aeso.Steamflix.Filme.RepositorioFilmeDAO;
import br.aeso.Steamflix.Genero.ControladorGenero;
import br.aeso.Steamflix.Genero.Genero;

public class ControladorFilme {
	private IRepositorioFilme repositorioFilme;
	private ControladorFornecedor controladorFornecedor;
	private ControladorGenero controladorGenero;

	public ControladorFilme() {
		this.repositorioFilme = new RepositorioFilmeDAO();
		this.controladorFornecedor = new ControladorFornecedor();
		this.controladorGenero = new ControladorGenero();
	}

	public void cadastrar(Filme filme) {
		this.repositorioFilme.cadastrar(filme);

	}

	public void atualizar(Filme filme) {
		this.repositorioFilme.atualizar(filme);

	}

	public void remover(int id) {
		this.repositorioFilme.remover(id);
	}

	public Filme procurar(int id) {
		Filme filme = null;
		Genero genero = null;
		Fornecedor fornecedor = null;

		filme = this.repositorioFilme.procurar(id);

		genero = this.controladorGenero.procurar(filme.getGenero().getId());
		fornecedor = this.controladorFornecedor.procurar(filme.getFornecedor()
				.getCNPJ());

		filme.setFornecedor(fornecedor);
		filme.setGenero(genero);
		return filme;
	}

	public ArrayList<Filme> listar() {
		ArrayList<Filme> filmes = null;
		//Genero genero = null;
		//Fornecedor fornecedor = null;

		filmes = this.repositorioFilme.listar();

		for (Filme filme : filmes) {
			filmes.set(filmes.lastIndexOf(filme), this.procurar(filme.getId()));									
		}
		
		return filmes;
	}
}
