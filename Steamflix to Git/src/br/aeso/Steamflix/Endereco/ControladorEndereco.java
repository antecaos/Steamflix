package br.aeso.Steamflix.Endereco;

import java.util.ArrayList;

import br.aeso.Steamflix.Endereco.Endereco;

public class ControladorEndereco {
	private IRepositorioEndereco repositorioEndereco;
	
	public ControladorEndereco(){
		repositorioEndereco = new RepositorioEnderecoDAO();
	}
	
	public void cadastrar(Endereco endereco) {
		this.repositorioEndereco.cadastrar(endereco);
	}
	
	public void atualizar(Endereco endereco){
		this.repositorioEndereco.atualizar(endereco);
	}
	
	public void remover(Endereco endereco){
		this.repositorioEndereco.remover(endereco);
	}
	
	public Endereco procurar(int id){
		return this.repositorioEndereco.procurar(id);
	}
	
	public Endereco procurarPorCliente(String cpf){
		return this.repositorioEndereco.procurarPorCliente(cpf);
	}
	
	public Endereco procurarPorFornecedor(String cnpj){
		return this.repositorioEndereco.procurarPorFornecedor(cnpj);
	}
	
	public ArrayList<Endereco> listar(){
		return this.repositorioEndereco.listar();
	}
}
