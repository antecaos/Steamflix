package br.aeso.Steamflix.main;

import java.util.ArrayList;
import java.util.Calendar;

import br.aeso.Steamflix.Endereco.Endereco;
import br.aeso.Steamflix.Fachada.Fachada;
import br.aeso.Steamflix.Filme.Filme;
import br.aeso.Steamflix.Fornecedor.Fornecedor;
import br.aeso.Steamflix.Genero.Genero;

public class TestaFilmeEJogo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fachada fachada = Fachada.getInstance();
		Calendar d1 = Calendar.getInstance();
		Genero g2 = new Genero(2, "Comédia");
		Endereco e2 = new Endereco(1, "Rua Altamir de Lacerda Nascimento", "710", "",
				"Hidráulica", "Rio Grande", "RS", "Brasil", "96.211-280");
		Fornecedor f1 = new Fornecedor("20586463000194", "Costinha S.A",
				"Costinha Games");
		f1.setEndereco(e2);
		
		d1.set(2005, 00, 05);
		Filme fi1 = new Filme();
		//, 25, 9, "1.2", ,	d1
		fi1.setClassificacao("12");
		fi1.setNome("Bom demais para morrer 2");
		fi1.setDataLancamento(d1);
		fi1.setFornecedor(f1);
		fi1.setGenero(g2);
		fi1.setNota("1.2");
		fi1.setPrecoVenda(25);
		fi1.setPrecoAluguel(9);
		fi1.setDiretor("Berilio Costa Jr.");
		fi1.setFornecedor(f1);
		fi1.setGenero(g2);
		fi1.setId(1);
		
		//fachada.cadastrarFilme(fi1);
		//fachada.atualizarFilme(fi1);
		//fachada.removerFilme(12);
		
		
		//System.out.println(fachada.procuraFilme(1));
		
		ArrayList<Filme> lista = fachada.listaFilme();
		
		for (Filme filme : lista) {
			System.out.println(filme);
			System.out.println("\n-----------------------------------\n");
		}
	}

}
