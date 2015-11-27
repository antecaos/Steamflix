package br.aeso.Steamflix.Compra;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import br.aeso.Steamflix.Compra.Compra;
import br.aeso.Steamflix.Cliente.Cliente;
import br.aeso.Steamflix.Cupom.Cupom;
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
			rs.close();

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
		String sql = "update Steamflix.Compra set dataCompra = ?, "
				+ "precoCompra = ?, idCupomCompra = ?  where idCompra = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setDate(1, new Date(compra.getData().getTimeInMillis()));
			stmt.setDouble(2, compra.getPreco());
			stmt.setInt(3, compra.getCupom().getId());
			stmt.setInt(4, compra.getId());

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
		String sql = "update Steamflix.Compra set flagCompra = ? where idCompra = ?";
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
	public Compra procurar(int id) {
		// TODO Auto-generated method stub
		Compra compraProcurado = new Compra();
		Cliente cliente = new Cliente();
		Cupom cupom = new Cupom();
		String sql = "select * from Steamflix.Compra where idCompra = ? and flagCompra = 1";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				compraProcurado.setId(rs.getInt(1));

				Calendar data = Calendar.getInstance();

				data.setTime(rs.getDate(2));
				compraProcurado.setData(data);

				cliente.setCPF(rs.getString(3));
				compraProcurado.setCliente(cliente);

				compraProcurado.setPreco(rs.getDouble(4));

				cupom.setId(rs.getInt(5));
				compraProcurado.setCupom(cupom);

				compraProcurado.setFlag(rs.getInt(6));

			}

			compraProcurado = this.procuraProdutos(compraProcurado);
			stmt.close();
			rs.close();

		} catch (SQLException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}

		return compraProcurado;
	}

	@Override
	public boolean existe(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Compra> listar() {
		// TODO Auto-generated method stub
		Cliente cliente = new Cliente();
		Cupom cupom = new Cupom();
		String sql = "select * from Steamflix.Compra where flagCompra = 1";
		ArrayList<Compra> alugueis = new ArrayList<Compra>();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Compra compra = new Compra();

				compra.setId(rs.getInt(1));

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate(2));
				compra.setData(data);

				cliente.setCPF(rs.getString(3));
				compra.setCliente(cliente);

				compra.setPreco(rs.getDouble(4));

				cupom.setId(rs.getInt(5));
				compra.setCupom(cupom);

				compra.setFlag(rs.getInt(6));

				compra = this.procuraProdutos(compra);

				alugueis.add(compra);
			}
			rs.close();
			stmt.close();

			return alugueis;
		} catch (SQLException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	private Compra procuraProdutos(Compra compra) {
		// TODO Auto-generated method stub
		String sql1 = "select idFilme from Steamflix.CompraFilme where idCompra = ?";
		String sql2 = "select idJogo from Steamflix.CompraJogo where idCompra = ?";

		try {
			PreparedStatement stmt1 = connection.prepareStatement(sql1);
			PreparedStatement stmt2 = connection.prepareStatement(sql2);

			stmt1.setInt(1, compra.getId());
			stmt2.setInt(1, compra.getId());

			ResultSet rs1 = stmt1.executeQuery();
			ResultSet rs2 = stmt2.executeQuery();

			while (rs1.next()) {
				Filme filme = new Filme();
				filme.setId(rs1.getInt("idFilme"));
				compra.setFilmes(filme);
			}

			while (rs2.next()) {
				Jogo jogo = new Jogo();
				jogo.setId(rs2.getInt("idJogo"));
				compra.setJogos(jogo);
			}
			stmt1.close();
			stmt2.close();
			rs1.close();
			rs2.close();

		} catch (SQLException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}

		return compra;
	}

	@Override
	public ArrayList<Compra> listarPorCliente(String cpf) {
		// TODO Auto-generated method stub
		Cliente cliente = new Cliente();
		Cupom cupom = new Cupom();
		String sql = "select * from Steamflix.Compra where idClienteCompra = ? and flagCompra = 1";
		ArrayList<Compra> alugueis = new ArrayList<Compra>();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cpf);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Compra compra = new Compra();

				compra.setId(rs.getInt(1));

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate(2));
				compra.setData(data);

				cliente.setCPF(rs.getString(3));
				compra.setCliente(cliente);

				compra.setPreco(rs.getDouble(4));

				cupom.setId(rs.getInt(5));
				compra.setCupom(cupom);

				compra.setFlag(rs.getInt(6));

				compra = this.procuraProdutos(compra);

				alugueis.add(compra);
			}
			rs.close();
			stmt.close();

			return alugueis;
		} catch (SQLException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
}
