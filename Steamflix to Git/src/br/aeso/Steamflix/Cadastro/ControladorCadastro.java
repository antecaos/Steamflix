package br.aeso.Steamflix.Cadastro;

import java.util.ArrayList;

public class ControladorCadastro {
	private IRepositorioCadastro repositorioCadastro;

	public ControladorCadastro() {
		repositorioCadastro = new RepositorioCadastroDAO();
	}

	public void cadastrar(Cadastro cadastro) {
		this.repositorioCadastro.cadastrar(cadastro);
	}
	
	public void atualizar(Cadastro cadastro){
		this.repositorioCadastro.atualizar(cadastro);
	}
	
	public void remover(Cadastro cadastro){
		this.repositorioCadastro.remover(cadastro);
	}
	
	public Cadastro procurar(int id){
		return this.repositorioCadastro.procurar(id);
	}
	
	public Cadastro procurarPorCliente(String cpf) {
		// TODO Auto-generated method stub
		return this.repositorioCadastro.procurarPorCliente(cpf);
	}
	
	public Cadastro procurarPorFornecedor(String cnpj) {
		// TODO Auto-generated method stub
		return this.repositorioCadastro.procurarPorFornecedor(cnpj);
	}
	
	public ArrayList<Cadastro> listar(){
		return this.repositorioCadastro.listar();
	}

	
}
