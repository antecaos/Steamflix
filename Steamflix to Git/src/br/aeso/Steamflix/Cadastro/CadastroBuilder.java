package br.aeso.Steamflix.Cadastro;

import java.util.ArrayList;

import br.aeso.Steamflix.Cliente.Cliente;
import br.aeso.Steamflix.Fornecedor.Fornecedor;

public class CadastroBuilder {
	private String login;
	private String senha;
	private ArrayList<String> email;
	private ArrayList<String> telefone;
	private Cliente cliente;
	private Fornecedor fornecedor;

	public CadastroBuilder() {
		this.email = new ArrayList<String>();
		this.telefone = new ArrayList<String>();
	}

	public CadastroBuilder comLogin(String login) {
		this.login = login;
		return this;
	}

	public CadastroBuilder comSenha(String senha) {
		this.senha = senha;
		return this;
	}

	public CadastroBuilder comEmail(String email) {
		this.email.add(email);
		return this;
	}

	public CadastroBuilder comTelefone(String telefone) {
		this.telefone.add(telefone);
		return this;
	}

	public CadastroBuilder comCliente(Cliente cliente) {
		this.cliente = cliente;
		return this;
	}

	public CadastroBuilder comFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
		return this;
	}

	public Cadastro construirCliente() {
		return new Cadastro();
	}

}
