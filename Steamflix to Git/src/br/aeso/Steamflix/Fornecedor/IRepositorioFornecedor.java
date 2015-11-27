package br.aeso.Steamflix.Fornecedor;

import java.util.ArrayList;

public interface IRepositorioFornecedor {
	public void cadastrar(Fornecedor fornecedor) throws FornecedorJaCadastradoException;

	public void atualizar(Fornecedor fornecedor);
	
	public void remover(String cnpj);
	
	public Fornecedor procurar(String cnpj);
	
	public boolean existe(String cnpj);
	
	public ArrayList<Fornecedor> listar();
}
