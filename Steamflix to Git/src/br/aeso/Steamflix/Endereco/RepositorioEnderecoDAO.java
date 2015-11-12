package br.aeso.Steamflix.Endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.aeso.Steamflix.JDBC.ConnectionFactory;

public class RepositorioEnderecoDAO implements IRepositorioEndereco {

	private Connection connection;

	public RepositorioEnderecoDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	@Override
	public void cadastrar(Endereco endereco) {
		// TODO Auto-generated method stub

		if (endereco.getFornecedor() == null) {
			this.cadastrarEnderecoCliente(endereco);
		} else if (endereco.getCliente() == null) {
			this.cadastrarEnderecoFornecedor(endereco);
		}
	}

	private void cadastrarEnderecoFornecedor(Endereco endereco) {
		// TODO Auto-generated method stub

		String sql = "insert into Steamflix.Endereco "
				+ "(logradouroEndereco, numeroEndereco, complementoEndereco, bairroEndereco,"
				+ " cidadeEndereco, estadoEndereco, paisEndereco, cepEndereco, idFornecedorEndereco, flagEndereco)"
				+ " values(?,?,?,?,?,?,?,?,?,?)";
		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, endereco.getLogradouro());
			stmt.setString(2, endereco.getNumero());
			stmt.setString(3, endereco.getComplemento());
			stmt.setString(4, endereco.getBairro());
			stmt.setString(5, endereco.getCidade());
			stmt.setString(6, endereco.getEstado());
			stmt.setString(7, endereco.getPais());
			stmt.setString(8, endereco.getCEP());
			stmt.setString(9, endereco.getFornecedor().getCNPJ());
			stmt.setInt(10, 1);

			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	private void cadastrarEnderecoCliente(Endereco endereco) {
		// TODO Auto-generated method stub
		String sql = "insert into Steamflix.Endereco"
				+ "(logradouroEndereco,numeroEndereco,complementoEndereco,bairroEndereco,cidadeEndereco,"
				+ "estadoEndereco,paisEndereco,cepEndereco,idClienteEndereco,flagEndereco)"
				+ " values(?,?,?,?,?,?,?,?,?,?)";
		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, endereco.getLogradouro());
			stmt.setString(2, endereco.getNumero());
			stmt.setString(3, endereco.getComplemento());
			stmt.setString(4, endereco.getBairro());
			stmt.setString(5, endereco.getCidade());
			stmt.setString(6, endereco.getEstado());
			stmt.setString(7, endereco.getPais());
			stmt.setString(8, endereco.getCEP());
			stmt.setString(9, endereco.getCliente().getCPF());
			stmt.setInt(10, 1);

			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	@Override
	public void atualizar(Endereco endereco) {
		// TODO Auto-generated method stub

		if (endereco.getFornecedor() == null) {
			this.atualizaEnderecoCliente(endereco);
		} else if (endereco.getCliente() == null) {
			this.atualizaEnderecoFornecedor(endereco);
		}
	}

	private void atualizaEnderecoFornecedor(Endereco endereco) {
		// TODO Auto-generated method stub
		String sql = "update Steamflix.Endereco set "
				+ "logradouroEndereco = ?, numeroEndereco = ?,complementoEndereco = ?,"
				+ " bairroEndereco = ?, cidadeEndereco = ?, estadoEndereco = ?,"
				+ " paisEndereco = ?, cepEndereco=?"
				+ " where idFornecedorEndereco = ?";
		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, endereco.getLogradouro());
			stmt.setString(2, endereco.getNumero());
			stmt.setString(3, endereco.getComplemento());
			stmt.setString(4, endereco.getBairro());
			stmt.setString(5, endereco.getCidade());
			stmt.setString(6, endereco.getEstado());
			stmt.setString(7, endereco.getPais());
			stmt.setString(8, endereco.getCEP());
			stmt.setString(9, endereco.getFornecedor().getCNPJ());

			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	private void atualizaEnderecoCliente(Endereco endereco) {
		// TODO Auto-generated method stub
		String sql = "update Steamflix.Endereco set "
				+ "logradouroEndereco = ?, numeroEndereco = ?,complementoEndereco = ?,"
				+ " bairroEndereco = ?, cidadeEndereco = ?, estadoEndereco = ?,"
				+ " paisEndereco = ?, cepEndereco = ?"
				+ " where idClienteEndereco = ?";
		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, endereco.getLogradouro());
			stmt.setString(2, endereco.getNumero());
			stmt.setString(3, endereco.getComplemento());
			stmt.setString(4, endereco.getBairro());
			stmt.setString(5, endereco.getCidade());
			stmt.setString(6, endereco.getEstado());
			stmt.setString(7, endereco.getPais());
			stmt.setString(8, endereco.getCEP());
			stmt.setString(9, endereco.getCliente().getCPF());

			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	@Override
	public void remover(Endereco endereco) {
		// TODO Auto-generated method stub
		if (endereco.getFornecedor() == null) {
			this.removeEnderecoCliente(endereco);
		} else if (endereco.getCliente() == null) {
			this.removeEnderecoFornecedor(endereco);
		}
	}

	private void removeEnderecoFornecedor(Endereco endereco) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement stmt = connection
					.prepareStatement("update Steamflix.Endereco"
							+ " set flagEndereco = ? where idFornecedorEndereco = ?");
			stmt.setInt(1, 0);
			stmt.setString(2, endereco.getFornecedor().getCNPJ());
			stmt.executeUpdate();
			stmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	private void removeEnderecoCliente(Endereco endereco) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement stmt = connection
					.prepareStatement("update Steamflix.Endereco"
							+ "set flagEndereco = ? where idClienteEndereco = ?");
			stmt.setInt(1, 0);
			stmt.setString(2, endereco.getCliente().getCPF());
			stmt.executeUpdate();
			stmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	@Override
	public Endereco procurar(int id) {
		// TODO Auto-generated method stub
		Endereco enderecoProcurado = new Endereco();
		String sql = "select * from Steamflix.Endereco "
				+ "where idEndereco = ? and flagEndereco = 1";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				enderecoProcurado.setId(rs.getInt(1));
				enderecoProcurado.setLogradouro(rs.getString(2));
				enderecoProcurado.setNumero(rs.getString(3));
				enderecoProcurado.setComplemento(rs.getString(4));
				enderecoProcurado.setBairro(rs.getString(5));
				enderecoProcurado.setCidade(rs.getString(6));
				enderecoProcurado.setEstado(rs.getString(7));
				enderecoProcurado.setPais(rs.getString(8));
				enderecoProcurado.setCEP(rs.getString(9));
			}
			stmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		return enderecoProcurado;
	}

	@Override
	public boolean existe(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Endereco> listar() {
		// TODO Auto-generated method stub
		try {
			ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from Steamflix.Endereco where flagEndereco = 1");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// Criando o objeto contato
				Endereco endereco = new Endereco();
				endereco.setId(rs.getInt(1));
				endereco.setLogradouro(rs.getString(2));
				endereco.setNumero(rs.getString(3));
				endereco.setComplemento(rs.getString(4));
				endereco.setBairro(rs.getString(5));
				endereco.setCidade(rs.getString(6));
				endereco.setEstado(rs.getString(7));
				endereco.setPais(rs.getString(8));
				endereco.setCEP(rs.getString(9));

				// adicionando o objeto à lista
				enderecos.add(endereco);
			}
			rs.close();
			stmt.close();
			return enderecos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Endereco procurarPorCliente(String cpf) {
		// TODO Auto-generated method stub
		Endereco enderecoProcurado = new Endereco();
		String sql = "select * from Steamflix.Endereco "
				+ "where idClienteEndereco = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cpf);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				enderecoProcurado.setId(rs.getInt(1));
				enderecoProcurado.setLogradouro(rs.getString(2));
				enderecoProcurado.setNumero(rs.getString(3));
				enderecoProcurado.setComplemento(rs.getString(4));
				enderecoProcurado.setBairro(rs.getString(5));
				enderecoProcurado.setCidade(rs.getString(6));
				enderecoProcurado.setEstado(rs.getString(7));
				enderecoProcurado.setPais(rs.getString(8));
				enderecoProcurado.setCEP(rs.getString(9));
			}
			stmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		return enderecoProcurado;
	}

	@Override
	public Endereco procurarPorFornecedor(String cnpj) {
		// TODO Auto-generated method stub
		Endereco enderecoProcurado = new Endereco();
		String sql = "select * from Steamflix.Endereco "
				+ "where idFornecedorEndereco = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cnpj);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				enderecoProcurado.setId(rs.getInt(1));
				enderecoProcurado.setLogradouro(rs.getString(2));
				enderecoProcurado.setNumero(rs.getString(3));
				enderecoProcurado.setComplemento(rs.getString(4));
				enderecoProcurado.setBairro(rs.getString(5));
				enderecoProcurado.setCidade(rs.getString(6));
				enderecoProcurado.setEstado(rs.getString(7));
				enderecoProcurado.setPais(rs.getString(8));
				enderecoProcurado.setCEP(rs.getString(9));
			}
			stmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		return enderecoProcurado;
	}

}
