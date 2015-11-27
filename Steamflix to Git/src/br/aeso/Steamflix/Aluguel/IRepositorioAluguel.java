package br.aeso.Steamflix.Aluguel;

import java.util.ArrayList;

import br.aeso.Steamflix.Aluguel.Aluguel;

public interface IRepositorioAluguel {
	public void cadastrar(Aluguel aluguel);

	public void atualizar(Aluguel aluguel);

	public void remover(int id);

	public Aluguel procurar(int id);

	public boolean existe(int id);

	public ArrayList<Aluguel> listar();

	ArrayList<Aluguel> listarPorCliente(String cpf);
}
