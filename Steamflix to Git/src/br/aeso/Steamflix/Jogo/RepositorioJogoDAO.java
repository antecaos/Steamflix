package br.aeso.Steamflix.Jogo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import br.aeso.Steamflix.Jogo.Jogo;
import br.aeso.Steamflix.Fornecedor.Fornecedor;
import br.aeso.Steamflix.Genero.Genero;
import br.aeso.Steamflix.JDBC.ConnectionFactory;

public class RepositorioJogoDAO implements IRepositorioJogo{
	private Connection connection;

	public RepositorioJogoDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	@Override
	public void cadastrar(Jogo jogo) {
		// TODO Auto-generated method stub
		String sql = "insert into Steamflix.Jogo "
				+ "(nomeJogo,precoVendaJogo,precoAluguelJogo, notaJogo, "
				+ "classificacaoJogo,idGeneroJogo,idFornecedorJogo,dataLancamentoJogo,"
				+ "desenvolvedorJogo,quantidadeJogo)"
				+ " values (?,?,?,?,?,?,?,?,?,?)";

		try {
			// prepared statement para a inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, jogo.getNome());
			stmt.setDouble(2, jogo.getPrecoVenda());
			stmt.setDouble(3, jogo.getPrecoAluguel());
			stmt.setString(4, jogo.getNota());
			stmt.setString(5, jogo.getClassificacao());
			stmt.setInt(6, jogo.getGenero().getId());
			stmt.setString(7, jogo.getFornecedor().getCNPJ());
			stmt.setDate(8, new Date(jogo.getDataLancamento()
					.getTimeInMillis()));
			stmt.setString(9, jogo.getDesenvolvedor());
			stmt.setInt(10, jogo.getQuantidade());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void atualizar(Jogo jogo) {
		// TODO Auto-generated method stub
		String sql = "update Steamflix.Jogo set nomeJogo =?, precoVendaJogo=?,precoAluguelJogo=?, notaJogo=?, "
				+ "classificacaoJogo=?,idGeneroJogo=?,idFornecedorJogo=?,dataLancamentoJogo=?,"
				+ "desenvolvedorJogo=?,quantidadeJogo=? where idJogo = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, jogo.getNome());
			stmt.setDouble(2, jogo.getPrecoVenda());
			stmt.setDouble(3, jogo.getPrecoAluguel());
			stmt.setString(4, jogo.getNota());
			stmt.setString(5, jogo.getClassificacao());
			stmt.setInt(6, jogo.getGenero().getId());
			stmt.setString(7, jogo.getFornecedor().getCNPJ());
			stmt.setDate(8, new Date(jogo.getDataLancamento()
					.getTimeInMillis()));
			stmt.setString(9, jogo.getDesenvolvedor());
			stmt.setInt(10, jogo.getQuantidade());
			stmt.setInt(11, jogo.getId());

			stmt.executeUpdate();
			stmt.close();
			System.out.println("Jogo Atualizado");
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	@Override
	public void remover(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from Steamflix.Jogo where idJogo = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1, id);

			stmt.executeUpdate();
			stmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	@Override
	public Jogo procurar(int id) {
		// TODO Auto-generated method stub
		Jogo jogoProcurado = new Jogo();
		Fornecedor fornecedor = new Fornecedor();
		Genero genero = new Genero();

		String sql = "select * from Steamflix.Jogo where idJogo = ?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				jogoProcurado.setId(rs.getInt(1));
				jogoProcurado.setNome(rs.getString(2));
				jogoProcurado.setPrecoVenda(rs.getDouble(3));
				jogoProcurado.setPrecoAluguel(rs.getDouble(4));
				jogoProcurado.setNota(rs.getString(5));
				jogoProcurado.setClassificacao(rs.getString(6));
				genero.setId(rs.getInt(7));
				jogoProcurado.setGenero(genero);

				fornecedor.setCNPJ(rs.getString(8));
				jogoProcurado.setFornecedor(fornecedor);

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate(9));
				jogoProcurado.setDataLancamento(data);

				jogoProcurado.setDesenvolvedor(rs.getString(10));
				jogoProcurado.setQuantidade(rs.getInt(11));
			}
			stmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		return jogoProcurado;
	}

	@Override
	public boolean existe(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Jogo> listar() {
		// TODO Auto-generated method stub
		String sql = "select * from Steamflix.Jogo";
		ArrayList<Jogo> jogos = new ArrayList<Jogo>();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Jogo jogo = new Jogo();

				jogo.setId(rs.getInt(1));
				jogo.setNome(rs.getString(2));
				jogo.setPrecoVenda(rs.getDouble(3));
				jogo.setPrecoAluguel(rs.getDouble(4));
				jogo.setNota(rs.getString(5));
				jogo.setClassificacao(rs.getString(6));
								
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate(9));
				jogo.setDataLancamento(data);

				jogo.setDesenvolvedor(rs.getString(10));
				jogo.setQuantidade(rs.getInt(11));

				jogos.add(jogo);
			}
			rs.close();
			stmt.close();
			return jogos;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

}
