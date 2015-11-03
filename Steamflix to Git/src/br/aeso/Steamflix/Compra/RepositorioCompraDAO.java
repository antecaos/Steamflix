package br.aeso.Steamflix.Compra;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.aeso.Steamflix.Filme.Filme;
import br.aeso.Steamflix.JDBC.ConnectionFactory;
import br.aeso.Steamflix.Jogo.Jogo;

import com.mysql.jdbc.Statement;

public class RepositorioCompraDAO implements IRepositorioCompra {

	private Connection connection;

	public RepositorioCompraDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	@Override
	public void cadastrar(Compra compra) {
		// TODO Auto-generated method stub
		String sql = "insert into Steamflix.Compra(dataCompra,"
				+ "idClienteCompra,precoCompra,idCupomCompra,flagCompra)values(?,?,?,?,1)";
		int codigo = 0;
		try {
			// prepared statement para a inserção
			PreparedStatement stmt = connection.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);

			// seta os valores
			stmt.setDate(1, new Date(compra.getData().getTimeInMillis()));
			stmt.setString(2, compra.getCliente().getCPF());
			stmt.setDouble(3, compra.getPreco());
			stmt.setInt(4, compra.getCupom().getId());

			// executa
			stmt.execute();

			// Pega o código do compra gerado;
			ResultSet rs = stmt.getGeneratedKeys();

			while (rs.next()) {
				codigo = rs.getInt(1);
			}

			compra.setId(codigo);

			this.cadastraProdutos(compra);
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private void cadastraProdutos(Compra compra) {
		// TODO Auto-generated method stub
		String sql1 = "insert into Steamflix.CompraFilme (idCompra, idFilme) values (?,?)";
		String sql2 = "insert into Steamflix.CompraJogo (idCompra, idJogo) values (?,?)";
		try {
			// prepared statement para a inserção
			PreparedStatement stmt1 = connection.prepareStatement(sql1);
			PreparedStatement stmt2 = connection.prepareStatement(sql2);

			// seta os valores
			for (Filme filme : compra.getFilmes()) {
				stmt1.setInt(1, compra.getId());
				stmt1.setInt(2, filme.getId());
				stmt1.execute();
			}

			for (Jogo jogo : compra.getJogos()) {
				stmt2.setInt(1, compra.getId());
				stmt2.setInt(2, jogo.getId());
				stmt2.execute();
			}

			stmt1.close();
			stmt2.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void atualizar(Compra compra) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remover(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Compra procurar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Compra> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
