package br.aeso.Steamflix.Aluguel;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.aeso.Steamflix.Filme.Filme;
import br.aeso.Steamflix.JDBC.ConnectionFactory;
import br.aeso.Steamflix.Jogo.Jogo;

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
		int codigo = 0;
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
			
			//Pega o código do aluguel gerado;
			ResultSet rs = stmt.getGeneratedKeys();

			while (rs.next()) {
				codigo = rs.getInt(1);
			}
			
			aluguel.setId(codigo);
			
			this.cadastraProdutos(aluguel);
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
	
	private void cadastraProdutos(Aluguel aluguel){
		String sql1 = "insert into Steamflix.AluguelFilme (idAluguel, idFilme) values (?,?)";
		String sql2 = "insert into Steamflix.AluguelJogo (idAluguel, idJogo) values (?,?)";
		try {
			// prepared statement para a inserção
			PreparedStatement stmt1 = connection.prepareStatement(sql1);
			PreparedStatement stmt2 = connection.prepareStatement(sql2);

			// seta os valores
			for (Filme filme : aluguel.getFilme()) {
				stmt1.setInt(1, aluguel.getId());
				stmt1.setInt(2, filme.getId());
				stmt1.execute();
			}
			
			for(Jogo jogo : aluguel.getJogo()){
				stmt2.setInt(1,aluguel.getId());
				stmt2.setInt(2, jogo.getId());
				stmt2.execute();
			}
			
			stmt1.close();
			stmt2.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
