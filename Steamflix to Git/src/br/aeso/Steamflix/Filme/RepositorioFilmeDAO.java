package br.aeso.Steamflix.Filme;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import br.aeso.Steamflix.Filme.Filme;

public class RepositorioFilmeDAO implements IRepositorioFilme{
	
	private Connection connection;
	
	@Override
	public void cadastrar(Filme filme) {
		// TODO Auto-generated method stub
		String sql = "insert into Steamflix.Filme "
				+ "(nomeFilme,precoVendaFilme,precoAluguelFilme, notaFilme, " +
				"classificacaoFilme,idGeneroFilme,idFornecedorFilme,dataLancamentoFilme," +
				"diretorFilme,quantidadeFilm)"
				+ " values (?,?,?,?,?,?,?,?,?,?)";

		try {
			// prepared statement para a inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
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
			stmt.setInt(9, filme.getQuantidade());
			
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void atualizar(Filme filme) {
		// TODO Auto-generated method stub
		String sql = "update Steamflix.Filme set nomeFilme = ? where cpfFilme = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, filme.getNome());
			stmt.setString(2, filme.getCPF());

			stmt.executeUpdate();
			stmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	@Override
	public void remover(Filme filme) {
		// TODO Auto-generated method stub
		String sql = "delete from Steamflix.Filme where cpfFilme = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, filme.getCPF());

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
		String sql = "select * from Steamflix.Filme where cpfFilme = ?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cpf);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				filmeProcurado.setCPF(rs.getString(1));
				filmeProcurado.setNome(rs.getString(2));

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate(3));
				filmeProcurado.setDataDeNascimento(data);
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
		String sql = "select * from Steamflix.Filme";
		ArrayList<Filme> filmes = new ArrayList<Filme>();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Filme filme = new Filme();

				filme.setCPF(rs.getString(1));
				filme.setNome(rs.getString(2));

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate(3));
				filme.setDataDeNascimento(data);

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
