package br.aeso.Steamflix.Genero;

import java.util.ArrayList;

public class ControladorGenero {
	private IRepositorioGenero repositorioGenero;

	public ControladorGenero() {
		repositorioGenero = new RepositorioGeneroDAO();
	}

	public void cadastrar(Genero genero) {
		if (genero == null)
			throw new IllegalArgumentException("Fornecedor Inválido.");

		this.repositorioGenero.cadastrar(genero);
	}

	public void atualizar(Genero genero) {
		this.repositorioGenero.atualizar(genero);
	}
	
	public void remover(int id){
		this.repositorioGenero.remover(id);
	}
	
	public Genero procurar(int id){
		return this.repositorioGenero.procurar(id);
	}
	
	public ArrayList<Genero> listar(){
		return this.repositorioGenero.listar();
	}
}
