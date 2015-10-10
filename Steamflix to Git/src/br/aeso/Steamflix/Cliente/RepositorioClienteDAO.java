package br.aeso.Steamflix.Cliente;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import br.aeso.Steamflix.JDBC.ConnectionFactory;

public class RepositorioClienteDAO implements IRepositorioCliente {

	private Connection connection;

	public RepositorioClienteDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	@Override
	public void cadastrar(Cliente cliente) {
		// TODO Auto-generated method stub
		String sql = "insert into Steamflix.Cliente "
				+ "(cpfCliente,nomeCliente,dataNascimentoCliente)"
				+ " values (?,?,?)";

		try {
			// prepared statement para a inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setString(1, cliente.getCPF());
			stmt.setString(2, cliente.getNome());
			stmt.setDate(3, new Date(cliente.getDataDeNascimento()
					.getTimeInMillis()));

			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void atualizar(Cliente cliente) {
		// TODO Auto-generated method stub
		String sql = "update Steamflix.Cliente set nomeCliente = ? where cpfCliente = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCPF());

			stmt.executeUpdate();
			stmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	@Override
	public void remover(Cliente cliente) {
		// TODO Auto-generated method stub
		String sql = "delete from Steamflix.Cliente where cpfCliente = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, cliente.getCPF());

			stmt.executeUpdate();
			stmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	@Override
	public Cliente procurar(String cpf) {
		// TODO Auto-generated method stub
		Cliente clienteProcurado = new Cliente();
		String sql = "select * from Steamflix.Cliente where cpfCliente = ?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cpf);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				clienteProcurado.setCPF(rs.getString(1));
				clienteProcurado.setNome(rs.getString(2));

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate(3));
				clienteProcurado.setDataDeNascimento(data);
			}
			stmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		return clienteProcurado;
	}

	@Override
	public boolean existe(String cpf) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Cliente> listar() {
		// TODO Auto-generated method stub
		String sql = "select * from Steamflix.Cliente";
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente cliente = new Cliente();

				cliente.setCPF(rs.getString(1));
				cliente.setNome(rs.getString(2));

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate(3));
				cliente.setDataDeNascimento(data);

				clientes.add(cliente);
			}
			rs.close();
			stmt.close();
			return clientes;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

}
