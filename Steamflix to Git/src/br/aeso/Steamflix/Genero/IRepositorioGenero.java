package br.aeso.Steamflix.Genero;

import java.util.ArrayList;


public interface IRepositorioGenero {
	public void cadastrar(Genero genero);

	public void atualizar(Genero genero);

	public void remover(int id);

	public Genero procurar(int id);

	public boolean existe(int id);

	public ArrayList<Genero> listar();
}
