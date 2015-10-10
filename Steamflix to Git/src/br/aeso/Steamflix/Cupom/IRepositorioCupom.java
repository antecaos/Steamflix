package br.aeso.Steamflix.Cupom;

import java.util.ArrayList;


public interface IRepositorioCupom {
	public void cadastrar(Cupom cupom);

	public void atualizar(Cupom cupom);

	public void remover(int id);

	public Cupom procurar(int id);

	public boolean existe(int id);

	public ArrayList<Cupom> listar();
}
