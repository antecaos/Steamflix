package br.aeso.Steamflix.Cadastro;

import java.util.ArrayList;

import br.aeso.Steamflix.Cliente.Cliente;
import br.aeso.Steamflix.Fornecedor.Fornecedor;

public class Cadastro {
	private int id;
	private String login;
	private String senha;
	private String[] email;
	private String[] telefone;
	private Cliente cliente;
	private Fornecedor fornecedor;

	public Cadastro(int id, String login, String senha, Cliente cliente) {
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.email = new String[2];
		this.telefone = new String[2];
		this.cliente = cliente;
	}

	public Cadastro(int id, String login, String senha, Fornecedor fornecedor) {
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.email = new String[2];
		this.telefone = new String[2];
		this.fornecedor = fornecedor;
	}

	public Cadastro() {
		this.email = new String[2];
		this.telefone = new String[2];
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public void setEmailPrincipal(String email) {
		this.email[0] = email;
	}

	public String getEmailPrincipal() {
		return this.email[0];
	}

	public void setEmailSecundario(String email) {
		this.email[1] = email;
	}

	public String getEmailSecundário() {
		return this.email[1];
	}

	public void setTelefoneFixo(String telefone) {
		this.telefone[0] = telefone;
	}

	public String getTelefoneFixo() {
		return this.telefone[0];
	}

	public void setTelefoneCelular(String telefone) {
		this.telefone[1] = telefone;
	}

	public String getTelefoneCelular() {
		return this.telefone[1];
	}

	@Override
	public String toString() {
		return "\nlogin: " + login + "\nsenha: " + senha
				+ "\nemail principal: " + this.getEmailPrincipal()
				+ "\nemail secundário:" + this.getEmailSecundário()
				+ "\ntelefone celular:" + this.getTelefoneCelular() 
				+ "\ntelefone fixo:" + this.getTelefoneFixo();
	}
}
