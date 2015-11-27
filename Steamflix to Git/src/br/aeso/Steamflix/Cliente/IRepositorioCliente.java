package br.aeso.Steamflix.Cliente;

import java.util.ArrayList;

public interface IRepositorioCliente {
	public void cadastrar(Cliente cliente) throws ClienteJaExisteException;

	public void atualizar(Cliente cliente);

	public void remover(Cliente cliente);

	public Cliente procurar(String cpf);

	public boolean existe(String cpf);

	public ArrayList<Cliente> listar();
}
