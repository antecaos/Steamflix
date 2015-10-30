package br.aeso.Steamflix.main;

import br.aeso.Steamflix.Aluguel.Aluguel;
import br.aeso.Steamflix.Cliente.Cliente;
import br.aeso.Steamflix.Cupom.Cupom;
import br.aeso.Steamflix.Fachada.Fachada;
import br.aeso.Steamflix.Filme.Filme;
import br.aeso.Steamflix.Jogo.Jogo;

public class TestaAluguel {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fachada fachada = Fachada.getInstance();		
		
		Filme fi1 = fachada.procuraFilme(2);
		Jogo j1 = fachada.procuraJogo(6);
		Jogo j2 = fachada.procuraJogo(3);
		Filme fi2 = fachada.procuraFilme(1);
		Cliente c = fachada.procuraCliente("09750906403");
		Cupom cupom = fachada.procurarCupom(2);
		Aluguel a1 = new Aluguel();
		a1.setCliente(c);
		a1.setDataAtual();
		a1.setFilme(fi1);
		a1.setFilme(fi2);
		a1.setJogo(j1);
		a1.setJogo(j2);
		a1.setId(14);
		a1.setCupom(cupom);
		

		System.out.println(a1);

		fachada.cadastrarAluguel(a1);
		//fachada.atualizarAluguel(a1);
		//System.out.println("\n");
		
		//System.out.println(fachada.procuraAluguel(2));
		
	}

}
