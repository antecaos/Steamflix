package br.aeso.Steamflix.Cadastro;

import java.util.ArrayList;

public class ControladorCadastro {
	private IRepositorioCadastro repositorioCadastro;
	private CamposNulosCadastro camposNulos;

	public ControladorCadastro() {
		repositorioCadastro = new RepositorioCadastroDAO();
		camposNulos = new CamposNulosCadastro();
	}

	public void cadastrar(Cadastro cadastro) throws CampoVazioException {
		if(cadastro == null)
			throw new IllegalArgumentException("Cadastro Inválido.");
		if(camposNulos.estaVazio(cadastro))
			throw new CampoVazioException();
		
		
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
