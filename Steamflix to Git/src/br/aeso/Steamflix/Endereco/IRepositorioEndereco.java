package br.aeso.Steamflix.Endereco;

import java.util.ArrayList;

public interface IRepositorioEndereco {
	public void cadastrar(Endereco endereco);

	public void atualizar(Endereco endereco);

	public void remover(Endereco endereco);

	public Endereco procurar(int id);
	
	public Endereco procurarPorCliente(String cpf);
	
	public Endereco procurarPorFornecedor(String cnpj);

	public boolean existe(int id);

	public ArrayList<Endereco> listar();
}
