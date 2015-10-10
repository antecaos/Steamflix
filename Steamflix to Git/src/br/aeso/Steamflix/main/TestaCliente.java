package br.aeso.Steamflix.main;

import java.util.ArrayList;
import java.util.Calendar;

import br.aeso.Steamflix.Cadastro.Cadastro;
import br.aeso.Steamflix.Cliente.Cliente;
import br.aeso.Steamflix.Endereco.Endereco;
import br.aeso.Steamflix.Fachada.Fachada;

public class TestaCliente {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cliente c = new Cliente();
		Cadastro cad = new Cadastro();
		Endereco e = new Endereco();
		Fachada fachada = Fachada.getInstance();
		c.setNome("Gobinho");
		Calendar d1 = Calendar.getInstance();
		d1.set(2005, 00, 05);
		c.setDataDeNascimento(d1);
		c.setCPF("01223665987");

		cad.setCliente(c);
		cad.setEmailPrincipal("gobinho@gmail.com");
		cad.setEmailSecundario("lhalves@ericsson.com");
		cad.setLogin("gobinhoso");
		cad.setSenha("JXSg7UGDlu");
		cad.setTelefoneFixo("33669966");
		cad.setTelefoneCelular("99669988");

		c.setCadastro(cad);

		e.setCliente(c);
		e.setBairro("Areal");
		e.setLogradouro("Rua Visconde de São Gabriel");
		e.setCEP("96077260");
		e.setCidade("Pelotas");
		e.setComplemento("");
		e.setEstado("RS");
		e.setNumero("517 A");
		e.setPais("Brasil");

		c.setEndereco(e);

		//System.out.println(c);
		//fachada.cadastrarCliente(c);

		//c.setNome("Leonardo Heitor Alves");
		// fachada.atualizarCliente(c);

		// fachada.removerCliente(c);
		
		//System.out.println(fachada.procuraCliente("01223665987"));
		
		ArrayList<Cliente> lista = fachada.listaCliente();
		
		for (Cliente cliente : lista) {
			System.out.println(cliente);
			System.out.println("\n");
		}
	}

}
