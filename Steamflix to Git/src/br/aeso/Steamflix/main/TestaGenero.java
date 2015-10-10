package br.aeso.Steamflix.main;

import java.util.ArrayList;

import br.aeso.Steamflix.Fachada.Fachada;
import br.aeso.Steamflix.Genero.Genero;

public class TestaGenero {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fachada fachada = Fachada.getInstance();
		/*Genero g1 = new Genero();
		g1.setNome("Comédia Romantica");
		fachada.cadastrarGenero(g1);
		
		Genero g2 = fachada.procurarGenero(6);
		g2.setNome("Teste");
		fachada.atualizarGenero(g2);*/
		
		//fachada.removerGenero(6);
		
		ArrayList<Genero> listar;
		
		listar = fachada.listarGenero();
		
		System.out.println(listar);
	}

}
