package br.aeso.Steamflix.Aluguel;

import java.util.ArrayList;

public class ControladorAluguel {
	private IRepositorioAluguel repositorioAluguel;	

	public ControladorAluguel() {
		this.repositorioAluguel = new RepositorioAluguelDAO();
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
		aluguel = this.repositorioAluguel.procurar(id);		
		return aluguel;
	}

	public ArrayList<Aluguel> listar() {
		ArrayList<Aluguel> alugueis = null;
		

		alugueis = this.repositorioAluguel.listar();

		for (Aluguel aluguel : alugueis) {

			
		}

		return alugueis;
	}
}
