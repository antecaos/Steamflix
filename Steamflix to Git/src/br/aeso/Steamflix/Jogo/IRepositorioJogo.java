package br.aeso.Steamflix.Jogo;

import java.util.ArrayList;

import br.aeso.Steamflix.Jogo.Jogo;

public interface IRepositorioJogo {
	public void cadastrar(Jogo jogo);

	public void atualizar(Jogo jogo);

	public void remover(int id);

	public Jogo procurar(int id);	

	public boolean existe(int id);

	public ArrayList<Jogo> listar();

	public ArrayList<Jogo> listarPorFornecedor(String cnpj);
}
