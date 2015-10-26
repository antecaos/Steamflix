package br.aeso.Steamflix.Aluguel;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import br.aeso.Steamflix.JDBC.ConnectionFactory;

public class RepositorioAluguelDAO implements IRepositorioAluguel {
	private Connection connection;

	public RepositorioAluguelDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	@Override
	public void cadastrar(Aluguel aluguel) {
		// TODO Auto-generated method stub
		String sql = "insert into Steamflix.Aluguel(dataAluguel,dataDevolucaoAluguel,"
				+ "idClienteAluguel,precoAluguel,idCupomAluguel)values(?,?,?,?,?)";
		try {
			// prepared statement para a inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setDate(1, new Date(aluguel.getData().getTimeInMillis()));
			stmt.setDate(2, new Date(aluguel.getDataDevolucao().getTimeInMillis()));
			stmt.setString(3, aluguel.getCliente().getCPF());
			stmt.setDouble(4, aluguel.getPreco());
			stmt.setInt(5, aluguel.getCupom().getId());

			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
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
