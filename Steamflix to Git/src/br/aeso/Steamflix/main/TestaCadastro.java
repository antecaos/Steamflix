package br.aeso.Steamflix.main;

import br.aeso.Steamflix.Cadastro.Cadastro;
import br.aeso.Steamflix.Cadastro.CadastroBuilder;
import br.aeso.Steamflix.Cadastro.CadastroNaoEncontradoException;
import br.aeso.Steamflix.Cliente.Cliente;
import br.aeso.Steamflix.Fachada.Fachada;
import br.aeso.Steamflix.Util.CampoVazioException;

public class TestaCadastro {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Cliente cliente = new Cliente();
		Endereco e1 = new Endereco(1, "Rua Rutilo", "18", "",
				"Jardim Atlântico", "Olinda", "PE", "Brasil", "53.060-360");
		Calendar d1 = Calendar.getInstance();
		cliente.setNome("Giulio Caetano Pires de Sá");
		cliente.setCPF("09750906403");
		d1.set(1993, 01, 05);
		cliente.setDataDeNascimento(d1);
		cliente.setEndereco(e1);

		Cadastro cadastro = new Cadastro();
		// cadastro.setCliente(cliente);
		cadastro.setEmailPrincipal("Giulio@giulio.com");
		cadastro.setEmailSecundario("asd@tol.com");
		cadastro.setLogin("antecaos");
		cadastro.setSenha("1234");
		cadastro.setTelefoneFixo("1123");
		// cadastro.setTelefone("123456789");

		cliente.setCadastro(cadastro);		

		Fornecedor f1 = new Fornecedor("11111111111111", "Costinha S.A",
				"Costinha Games");
		cadastro.setFornecedor(f1);*/
		Fachada fachada = Fachada.getInstance();
		Cadastro cadastro;
		try {
			cadastro = fachada.retornaCadastro("giulios", "giulio");
			//System.out.println(cadastro);
		} catch (CampoVazioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CadastroNaoEncontradoException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		
		
		//Cliente cliente = fachada.procuraCliente("09750906403");
		
		//CadastroBuilder cadastro = new CadastroBuilder();	
		//cadastro.comCliente(cliente).comEmail("giuliocaetano@yahoo.com.br").comLogin("antecaos").comSenha("123");
		//Cadastro cad = cadastro.construirCliente();
		//System.out.println(cad);
	}
}
