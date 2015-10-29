package br.aeso.Steamflix.main;

import java.util.Calendar;

import br.aeso.Steamflix.Aluguel.Aluguel;
import br.aeso.Steamflix.Cadastro.Cadastro;
import br.aeso.Steamflix.Cliente.Cliente;
import br.aeso.Steamflix.Compra.Compra;
import br.aeso.Steamflix.Endereco.Endereco;
import br.aeso.Steamflix.Filme.Filme;
import br.aeso.Steamflix.Fornecedor.Fornecedor;
import br.aeso.Steamflix.Genero.Genero;
import br.aeso.Steamflix.Jogo.Jogo;

public class TestaClasses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Instanciando as classes;
		Calendar d1 = Calendar.getInstance();
		Calendar d2 = Calendar.getInstance();
		Calendar d3 = Calendar.getInstance();
		
		Cliente cliente = new Cliente();
		Endereco e1 = new Endereco(1, "Rua Rutilo", "18", "",
				"Jardim Atlântico", "Olinda", "PE", "Brasil", "53.060-360");
		
		Endereco e2 = new Endereco(1, "Rua Altamir de Lacerda Nascimento", "710", "",
				"Hidráulica", "Rio Grande", "RS", "Brasil", "96.211-280");
		Fornecedor f1 = new Fornecedor("20.586.463/0001-94", "Costinha S.A",
				"Costinha Games");
		f1.setEndereco(e2);
		
		Genero g1 = new Genero(1, "Plataforma/Aventura");
		Genero g2 = new Genero(2, "Comédia");
		
		
		d1.set(2005, 00, 05);
		Filme fi1 = new Filme(1, "Bom demais para morrer", 25, 9, "1.2", "12",
				d1);
		fi1.setDiretor("Berilio Costa Sr.");
		fi1.setFornecedor(f1);
		fi1.setGenero(g2);

		
		// Adicionando dados do cliente;
		cliente.setNome("Giulio Caetano Pires de Sá");
		cliente.setCPF("097.509.064-03");
		d2.set(1993, 01, 05);
		cliente.setDataDeNascimento(d2);
		
		Jogo j1 = new Jogo();		
		d3.set(2015, 05, 02);
		j1.setId(1);
		j1.setNome("CostaBoy: Bom demais para morrer");
		j1.setDesenvolvedor("Belirio Costa Jr.");
		j1.setFornecedor(f1);
		j1.setNota("2");
		j1.setGenero(g1);
		j1.setPrecoAluguel(5);
		j1.setPrecoVenda(15);
		j1.setClassificacao("Livre");
		j1.setDataLancamento(d3);

		e1.setCliente(cliente);
		cliente.setEndereco(e1);
		
		Cadastro cad1 = new Cadastro(1,"antecaos","giulio93",cliente);
		cad1.setEmailPrincipal("giuliocaetano@yahoo.com.br");
		cad1.setTelefoneFixo("(81)3012-1014");
		cad1.setTelefoneCelular("(81)9 9963-0463");
		Cadastro cad2 = new Cadastro(2,"costa","sucesso",f1);
		cad2.setEmailPrincipal("costa@costa.com");
		cad2.setEmailSecundario("relacionamentos@costa.com");
		cad2.setTelefoneFixo("(10)3030-1919");
		cad2.setTelefoneCelular("(10)9 9988-8877");
		cliente.setCadastro(cad1);
		f1.setCadastro(cad2);
		
		//Date d = new Date();
		
		Aluguel a1 = new Aluguel();
		a1.setCliente(cliente);		
		a1.setDataAtual();
		a1.setFilme(fi1);
		a1.setJogo(j1);
		a1.setId(1);
		
		Compra cp1 = new Compra();
		cp1.setCliente(cliente);
		cp1.setFilmes(fi1);
		cp1.setJogos(j1);
		cp1.setId(1);
		
		System.out.println("\n-----------------------------------\n");
		System.out.println(cliente);
		System.out.println("\n-----------------------------------\n");
		System.out.println(f1);
		System.out.println("\n-----------------------------------\n");
		System.out.println(g1);
		System.out.println(g2);
		System.out.println("\n-----------------------------------\n");
		System.out.println(fi1);
		System.out.println("\n-----------------------------------\n");
		System.out.println(j1);
		System.out.println("\n-----------------------------------\n");
		System.out.println(a1);
		System.out.println("\n-----------------------------------\n");
		System.out.println(cp1);
		System.out.println("\n-----------------------------------\n");
		

	}

}
