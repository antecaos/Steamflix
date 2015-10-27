package br.aeso.Steamflix.main;

import java.util.Calendar;

import br.aeso.Steamflix.Aluguel.Aluguel;
import br.aeso.Steamflix.Cadastro.Cadastro;
import br.aeso.Steamflix.Cliente.Cliente;
import br.aeso.Steamflix.Endereco.Endereco;
import br.aeso.Steamflix.Fachada.Fachada;
import br.aeso.Steamflix.Filme.Filme;
import br.aeso.Steamflix.Fornecedor.Fornecedor;
import br.aeso.Steamflix.Genero.Genero;
import br.aeso.Steamflix.Jogo.Jogo;

public class TestaAluguel {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fachada fachada = Fachada.getInstance();
		/*Cliente c = new Cliente();
		Cadastro cad = new Cadastro();
		Endereco e = new Endereco();

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

		Calendar d3 = Calendar.getInstance();
		Genero g1 = new Genero(1, "Plataforma/Aventura");
		Genero g2 = new Genero(2, "Comédia");
		Endereco e2 = new Endereco(1, "Rua Altamir de Lacerda Nascimento",
				"710", "", "Hidráulica", "Rio Grande", "RS", "Brasil",
				"96.211-280");
		Fornecedor f1 = new Fornecedor("20586463000194", "Costinha S.A",
				"Costinha Games");
		f1.setEndereco(e2);

		d1.set(2005, 00, 05);
		
		 * Filme fi1 = new Filme(); // , 25, 9, "1.2", , d1
		 * fi1.setClassificacao("12"); fi1.setNome("Bom demais para morrer 2");
		 * fi1.setDataLancamento(d1); fi1.setFornecedor(f1); fi1.setGenero(g2);
		 * fi1.setNota("1.2"); fi1.setPrecoVenda(25); fi1.setPrecoAluguel(9);
		 * fi1.setDiretor("Berilio Costa Jr."); fi1.setFornecedor(f1);
		 * fi1.setGenero(g2); fi1.setId(1);
		 */

		/*
		 * Jogo j1 = new Jogo(); d3.set(2015, 05, 02); j1.setId(1);
		 * j1.setNome("CostaBoy: Bom demais para morrer");
		 * j1.setDesenvolvedor("Belirio Costa Jr."); j1.setFornecedor(f1);
		 * j1.setNota("5"); j1.setGenero(g1); j1.setPrecoAluguel(5);
		 * j1.setPrecoVenda(15); j1.setClassificacao("Livre");
		 * j1.setDataLancamento(d3);
		 */
		Filme fi1 = fachada.procuraFilme(2);
		Jogo j1 = fachada.procuraJogo(6);
		Jogo j2 = fachada.procuraJogo(3);
		Filme fi2 = fachada.procuraFilme(1);
		Cliente c = fachada.procuraCliente("09750906403");
		Aluguel a1 = new Aluguel();
		a1.setCliente(c);
		a1.setData();
		a1.setDataDevolucao();
		a1.setFilme(fi1);
		a1.setFilme(fi2);
		a1.setJogo(j1);
		a1.setJogo(j2);
		a1.setId(1);
		a1.setCupom(null);

		System.out.println(a1);

		fachada.cadastrarAluguel(a1);
	}

}
