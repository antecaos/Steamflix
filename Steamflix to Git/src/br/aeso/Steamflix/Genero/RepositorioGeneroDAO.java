package br.aeso.Steamflix.Genero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.aeso.Steamflix.JDBC.ConnectionFactory;

public class RepositorioGeneroDAO implements IRepositorioGenero {

	private Connection connection;

	public RepositorioGeneroDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	@Override
	public void cadastrar(Genero genero) {
		// TODO Auto-generated method stub
		int codigo = 0;
		String sql = "insert into Steamflix.Genero" + "(nomeGenero,flagGenero)"
				+ "values (?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, genero.getNome());
			stmt.setInt(2, 1);

			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();

			while (rs.next()) {
				codigo = rs.getInt(1);
			}

			genero.setId(codigo);
			System.out.println();

			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Erro de SQL");
		}
	}

	@Override
	public void atualizar(Genero genero) {
		// TODO Auto-generated method stub
		String sql = "update Steamflix.Genero set nomeGenero=? where idGenero = ?";
		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, genero.getNome());
			stmt.setInt(2, genero.getId());

			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			// TODO: handle exception
			System.err.println("Erro de SQL");
		}
	}

	@Override
	public void remover(int id) {
		// TODO Auto-generated method stub
		Genero genero = this.procurar(id);
		try {
			PreparedStatement stmt = connection.prepareStatement("update "
					+ "Steamflix.Genero set flagGenero = ? where idGenero =?");
			stmt.setInt(1, 0);
			stmt.setInt(2, genero.getId());

			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			System.err.println("Erro de SQL");
		}
	}

	@Override
	public Genero procurar(int id) {
		// TODO Auto-generated method stub
		Genero generoProcurado = null;
		String sql = "select * from Steamflix.Genero where idGenero = ? and flagGenero = 1";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				generoProcurado = new Genero();
				generoProcurado.setNome(rs.getString("nomeGenero"));
				generoProcurado.setId(rs.getInt("idGenero"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
		return generoProcurado;
	}

	@Override
	public boolean existe(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Genero> listar() {
		// TODO Auto-generated method stub
		try {
			ArrayList<Genero> generos = new ArrayList<Genero>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from  Steamflix.Genero where flagGenero = 1");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// Criando o objeto contato
				Genero genero = new Genero();

				// Pegar o resto dos dados para setar no endereço
				genero.setId(rs.getInt(1));
				genero.setNome(rs.getString(2));

				// adicionando o objeto à lista
				generos.add(genero);
			}
			rs.close();
			stmt.close();
			return generos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
