package br.aeso.Steamflix.Filme;

import java.util.ArrayList;

public interface IRepositorioFilme {
	public void cadastrar(Filme endereco);

	public void atualizar(Filme endereco);

	public void remover(Filme endereco);

	public Filme procurar(int id);	

	public boolean existe(int id);

	public ArrayList<Filme> listar();
}
