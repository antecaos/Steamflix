package br.aeso.Steamflix.main;

import br.aeso.Steamflix.Endereco.Endereco;
import br.aeso.Steamflix.Fachada.Fachada;
import br.aeso.Steamflix.Fornecedor.Fornecedor;

public class TestaFornecedor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Endereco e2 = new Endereco(1, "Rua Altamir de Lacerda Nascimento", "710", "",
				"Hidráulica", "Rio Grande", "RS", "Brasil", "96.211-280");
		Fornecedor f1 = new Fornecedor("20586463000194", "Costinha S.A",
				"Costinha Games");
		f1.setEndereco(e2);
		
		Fachada fachada = Fachada.getInstance();
		
		fachada.cadastrarFornecedor(f1);
	}

}
