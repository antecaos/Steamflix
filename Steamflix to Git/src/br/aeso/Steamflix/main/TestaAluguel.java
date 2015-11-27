package br.aeso.Steamflix.main;

import java.util.ArrayList;
import java.util.Vector;

import br.aeso.Steamflix.Aluguel.Aluguel;
import br.aeso.Steamflix.Cliente.Cliente;
import br.aeso.Steamflix.Compra.Compra;
//import br.aeso.Steamflix.Cupom.Cupom;
import br.aeso.Steamflix.Fachada.Fachada;
import br.aeso.Steamflix.Filme.Filme;
import br.aeso.Steamflix.Jogo.Jogo;
import br.aeso.Steamflix.Produtos.Produtos;

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
		//Filme fi2 = fachada.procuraFilme(1);
		Cliente c = fachada.procuraCliente("09750906403");
		//Cupom cupom = fachada.procurarCupom(10);
		Aluguel a1 = new Aluguel();
		a1.setCliente(c);
		a1.setDataAtual();
		a1.setFilme(fi1);
		//a1.setFilme(fi2);
		a1.setJogo(j1);
		a1.setJogo(j2);
		a1.setId(14);
		//a1.setCupom(cupom);		

		//System.out.println(a1);

		//fachada.cadastrarAluguel(a1);
		//fachada.atualizarAluguel(a1);
		System.out.println("\n");
		
		//System.out.println(fachada.procuraAluguel(13));
		
		ArrayList<Aluguel> lista = fachada.listaAluguelPorCliente("09750906403");
		ArrayList<Produtos> produtos = new ArrayList<Produtos>();
		for (Aluguel aluguel : lista) {
			for (Jogo jogo : aluguel.getJogo()) {
				produtos.add(jogo);
			}
			for (Filme filme : aluguel.getFilme()) {
				produtos.add(filme);
			}
		}	
		
		for(Produtos produto : produtos){
			System.out.println(produto);
		}
	
		
		/*for (Compra compra : listaCompra) {
				Vector vector = new Vector();
				for (Filme filme : compra.getFilmes()) {
					vector.add(filme.getId());
					vector.add(filme.getNome());
					vector.add(filme.getFornecedor().getNomeFantasia());
					vector.add(filme.getDiretor());
					vector.add(filme.getNota());
					vector.add(filme.getClassificacao());
					vector.add(filme.getGenero().getNome());
					vector.add("-");
					vector.add(filme.dataFormatada());

				}
				produtosDefaultTable.addRow(vector);
			}*/
		
		/*for (Aluguel aluguel : listaAluguel) {
				Vector vector = new Vector();
				for (Filme filme : aluguel.getFilme()) {
					vector.add(filme.getId());
					vector.add(filme.getNome());
					vector.add(filme.getFornecedor().getNomeFantasia());
					vector.add(filme.getDiretor());
					vector.add(filme.getNota());
					vector.add(filme.getClassificacao());
					vector.add(filme.getGenero().getNome());
					vector.add(aluguel.dataDevolucaoFormatada());
					vector.add(filme.dataFormatada());

				}
				produtosDefaultTable.addRow(vector);
			}*/
	}

}
