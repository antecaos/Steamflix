package br.aeso.Steamflix.Cadastro;

import java.util.ArrayList;

public interface IRepositorioCadastro {
	public void cadastrar(Cadastro cadastro);

	public void atualizar(Cadastro cadastro);

	public void remover(Cadastro cadastro);

	public Cadastro procurar(int id);
	
	public Cadastro procurarPorCliente(String cpf);
	
	public Cadastro procurarPorFornecedor(String cnpj);

	public boolean existe(int id);

	public ArrayList<Cadastro> listar();
	
	public Cadastro retornaCadastro(String login,String senha);
}
