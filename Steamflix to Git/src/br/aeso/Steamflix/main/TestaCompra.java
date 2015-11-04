package br.aeso.Steamflix.main;

import java.util.ArrayList;

import br.aeso.Steamflix.Cliente.Cliente;
import br.aeso.Steamflix.Compra.Compra;
import br.aeso.Steamflix.Fachada.Fachada;
import br.aeso.Steamflix.Filme.Filme;
import br.aeso.Steamflix.Jogo.Jogo;

public class TestaCompra {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fachada fachada = Fachada.getInstance();
		
		Cliente cliente = fachada.procuraCliente("11111111111");
		Jogo j1 = fachada.procuraJogo(4);
		Filme f1 = fachada.procuraFilme(6);
		Filme f2 = fachada.procuraFilme(1);
		
		Compra compra = new Compra();
		compra.setCliente(cliente);
		compra.setData();
		compra.setFilmes(f1);
		compra.setFilmes(f2);
		compra.setJogos(j1);
		
		//System.out.println(compra);
		
		//fachada.cadastrarCompra(compra);
		//fachada.removerCompra(3);
		//System.out.println(fachada.procuraCompra(4));
		
		ArrayList<Compra> lista = fachada.listaCompra();
		
		for (Compra compras : lista) {
			System.out.println(compras);
			System.out.println("\n");
		}
	}

}
