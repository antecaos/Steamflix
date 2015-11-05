package br.aeso.Steamflix.Filme;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import br.aeso.Steamflix.Fornecedor.Fornecedor;
import br.aeso.Steamflix.Genero.Genero;
import br.aeso.Steamflix.JDBC.ConnectionFactory;

public class RepositorioFilmeDAO implements IRepositorioFilme {

	private Connection connection;

	public RepositorioFilmeDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	@Override
	public void cadastrar(Filme filme) {
		// TODO Auto-generated method stub
		String sql = "insert into Steamflix.Filme "
				+ "(nomeFilme,precoVendaFilme,precoAluguelFilme, notaFilme, "
				+ "classificacaoFilme,idGeneroFilme,idFornecedorFilme,dataLancamentoFilme,"
				+ "diretorFilme,quantidadeFilme,flagFilme)"
				+ " values (?,?,?,?,?,?,?,?,?,?,?)";

		try {
			// prepared statement para a inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, filme.getNome());
			stmt.setDouble(2, filme.getPrecoVenda());
			stmt.setDouble(3, filme.getPrecoAluguel());
			stmt.setString(4, filme.getNota());
			stmt.setString(5, filme.getClassificacao());
			stmt.setInt(6, filme.getGenero().getId());
			stmt.setString(7, filme.getFornecedor().getCNPJ());
			stmt.setDate(8, new Date(filme.getDataLancamento()
					.getTimeInMillis()));
			stmt.setString(9, filme.getDiretor());
			stmt.setInt(10, filme.getQuantidade());
			stmt.setInt(11, 1);

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void atualizar(Filme filme) {
		// TODO Auto-generated method stub
		String sql = "update Steamflix.Filme set nomeFilme =?, precoVendaFilme=?,precoAluguelFilme=?, notaFilme=?, "
				+ "classificacaoFilme=?,idGeneroFilme=?,idFornecedorFilme=?,dataLancamentoFilme=?,"
				+ "diretorFilme=?,quantidadeFilme=? where idFilme = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, filme.getNome());
			stmt.setDouble(2, filme.getPrecoVenda());
			stmt.setDouble(3, filme.getPrecoAluguel());
			stmt.setString(4, filme.getNota());
			stmt.setString(5, filme.getClassificacao());
			stmt.setInt(6, filme.getGenero().getId());
			stmt.setString(7, filme.getFornecedor().getCNPJ());
			stmt.setDate(8, new Date(filme.getDataLancamento()
					.getTimeInMillis()));
			stmt.setString(9, filme.getDiretor());
			stmt.setInt(10, filme.getQuantidade());
			stmt.setInt(11, filme.getId());

			stmt.executeUpdate();
			stmt.close();
			System.out.println("Filme Atualizado");
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	@Override
	public void remover(int id) {
		// TODO Auto-generated method stub
		String sql = "update Steamflix.Filme set flagFilme = ? where idFilme = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, 0);
			stmt.setInt(2, id);

			stmt.executeUpdate();
			stmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	@Override
	public Filme procurar(int id) {
		// TODO Auto-generated method stub
		Filme filmeProcurado = new Filme();
		Fornecedor fornecedor = new Fornecedor();
		Genero genero = new Genero();

		String sql = "select * from Steamflix.Filme where idFilme = ? and flagFilme = 1";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				filmeProcurado.setId(rs.getInt(1));
				filmeProcurado.setNome(rs.getString(2));
				filmeProcurado.setPrecoVenda(rs.getDouble(3));
				filmeProcurado.setPrecoAluguel(rs.getDouble(4));
				filmeProcurado.setNota(rs.getString(5));
				filmeProcurado.setClassificacao(rs.getString(6));
				genero.setId(rs.getInt(7));
				filmeProcurado.setGenero(genero);

				fornecedor.setCNPJ(rs.getString(8));
				filmeProcurado.setFornecedor(fornecedor);

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate(9));
				filmeProcurado.setDataLancamento(data);

				filmeProcurado.setDiretor(rs.getString(10));
				filmeProcurado.setQuantidade(rs.getInt(11));
			}
			stmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		return filmeProcurado;
	}

	@Override
	public boolean existe(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Filme> listar() {
		// TODO Auto-generated method stub
		
		String sql = "select * from Steamflix.Filme where flagFilme = 1";
		ArrayList<Filme> filmes = new ArrayList<Filme>();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Filme filme = new Filme();

				filme.setId(rs.getInt(1));
				filme.setNome(rs.getString(2));
				filme.setPrecoVenda(rs.getDouble(3));
				filme.setPrecoAluguel(rs.getDouble(4));
				filme.setNota(rs.getString(5));
				filme.setClassificacao(rs.getString(6));
								
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate(9));
				filme.setDataLancamento(data);

				filme.setDiretor(rs.getString(10));
				filme.setQuantidade(rs.getInt(11));

				filmes.add(filme);
			}
			rs.close();
			stmt.close();
			return filmes;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

}
