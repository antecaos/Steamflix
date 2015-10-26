package br.aeso.Steamflix.Aluguel;

import java.sql.Connection;
import java.util.ArrayList;

import br.aeso.Steamflix.JDBC.ConnectionFactory;

public class RepositorioAluguelDAO implements IRepositorioAluguel{
	private Connection connection;

	public RepositorioAluguelDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	@Override
	public void cadastrar(Aluguel aluguel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Aluguel aluguel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Aluguel procurar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Aluguel> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
