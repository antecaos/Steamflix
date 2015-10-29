package br.aeso.Steamflix.Aluguel;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import br.aeso.Steamflix.Cliente.Cliente;
import br.aeso.Steamflix.Cupom.Cupom;
import br.aeso.Steamflix.Filme.Filme;
import br.aeso.Steamflix.JDBC.ConnectionFactory;
import br.aeso.Steamflix.Jogo.Jogo;

import com.mysql.jdbc.Statement;

public class RepositorioAluguelDAO implements IRepositorioAluguel {
	private Connection connection;

	public RepositorioAluguelDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	@Override
	public void cadastrar(Aluguel aluguel) {
		// TODO Auto-generated method stub
		String sql = "insert into Steamflix.Aluguel(dataAluguel,dataDevolucaoAluguel,"
				+ "idAluguelAluguel,precoAluguel)values(?,?,?,?)";
		int codigo = 0;
		try {
			// prepared statement para a inserção
			PreparedStatement stmt = connection.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);

			// seta os valores
			stmt.setDate(1, new Date(aluguel.getData().getTimeInMillis()));
			stmt.setDate(2, new Date(aluguel.getDataDevolucao()
					.getTimeInMillis()));
			stmt.setString(3, aluguel.getCliente().getCPF());
			stmt.setDouble(4, aluguel.getPreco());

			// executa
			stmt.execute();

			// Pega o código do aluguel gerado;
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
		String sql = "update Steamflix.Aluguel set dataAluguel = ?, dataDevolucaoAluguel = ?,"
				+ "precoAluguel = ?, idCupomAluguel = ?  where idAluguel = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setDate(1, new Date(aluguel.getData().getTimeInMillis()));
			stmt.setDate(2, new Date(aluguel.getDataDevolucao()
					.getTimeInMillis()));
			stmt.setDouble(3, aluguel.getPreco());
			stmt.setInt(4, aluguel.getCupom().getId());
			stmt.setInt(5, aluguel.getId());

			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	@Override
	public void remover(int id) {
		// TODO Auto-generated method stub
		String sql = "update Steamflix.Aluguel set flagAluguel = ? where idAluguel = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1, 0);
			stmt.setInt(2, id);

			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	@Override
	public Aluguel procurar(int id) {
		// TODO Auto-generated method stub
		Aluguel aluguelProcurado = new Aluguel();
		Cliente cliente = new Cliente();
		Cupom cupom = new Cupom();
		String sql = "select * from Steamflix.Aluguel where idAluguel = ? and flagAluguel = 1";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				aluguelProcurado.setId(rs.getInt(1));

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate(2));
				aluguelProcurado.setData(data);
				
				cliente.setCPF(rs.getString(4));
				aluguelProcurado.setCliente(cliente);
								
				aluguelProcurado.setPreco(rs.getDouble(5));
				
				cupom.setId(rs.getInt(6));
				aluguelProcurado.setCupom(cupom);
				
				aluguelProcurado.setFlag(rs.getInt(7));

			}
			
			aluguelProcurado = this.procuraProdutos(aluguelProcurado);
			stmt.close();

		} catch (SQLException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}

		return aluguelProcurado;
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

	private void cadastraProdutos(Aluguel aluguel) {
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

			for (Jogo jogo : aluguel.getJogo()) {
				stmt2.setInt(1, aluguel.getId());
				stmt2.setInt(2, jogo.getId());
				stmt2.execute();
			}

			stmt1.close();
			stmt2.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private Aluguel procuraProdutos(Aluguel aluguel){
		String sql1 = "select idFilme from Steamflix.AluguelFilme where idAluguel = ?";
		String sql2 = "select idJogo from Steamflix.AluguelJogo where idAluguel = ?";
		
		try {
			PreparedStatement stmt1 = connection.prepareStatement(sql1);
			PreparedStatement stmt2 = connection.prepareStatement(sql2);
			
			stmt1.setInt(1, aluguel.getId());
			stmt2.setInt(1, aluguel.getId());
			
			ResultSet rs1 = stmt1.executeQuery();
			ResultSet rs2 = stmt2.executeQuery();
			
			while(rs1.next()){
				Filme filme = new Filme();
				filme.setId(rs1.getInt("idFilme"));
				aluguel.setFilme(filme);
			}
			
			while(rs2.next()){
				Jogo jogo = new Jogo();
				jogo.setId(rs2.getInt("idJogo"));
				aluguel.setJogo(jogo);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		
		return aluguel;
	}

}
