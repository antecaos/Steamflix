package br.aeso.Steamflix.Filme;

import java.util.ArrayList;

public interface IRepositorioFilme {
	public void cadastrar(Filme filme);

	public void atualizar(Filme filme);

	public void remover(int id);

	public Filme procurar(int id);	

	public boolean existe(int id);

	public ArrayList<Filme> listar();
}
