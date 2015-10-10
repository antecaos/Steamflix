package br.aeso.Steamflix.main;

import java.util.ArrayList;

import br.aeso.Steamflix.Cupom.Cupom;
import br.aeso.Steamflix.Fachada.Fachada;

public class TestaCupom {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fachada fachada = Fachada.getInstance();
		ArrayList<Cupom> lista = new ArrayList<Cupom>();
		lista = fachada.listarCupom();

		for (Cupom cupom : lista) {
			System.out.println(cupom);
			System.out.println("\n");
		}

		Cupom c1 = new Cupom();
		c1.setNome("DescLol12");
		c1.setValor(12);
		
		//fachada.cadastrarCupom(c1);	
		//System.out.println(fachada.procurarCupom(5));
		//fachada.atualizarCupom(c1);
		//fachada.removerCupom(7);

	}

}
