package br.aeso.Steamflix.Fornecedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.aeso.Steamflix.Fornecedor.Fornecedor;
import br.aeso.Steamflix.JDBC.ConnectionFactory;

public class RepositorioFornecedorDAO implements IRepositorioFornecedor {

	private Connection connection;

	public RepositorioFornecedorDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	@Override
	public void cadastrar(Fornecedor fornecedor) {
		// TODO Auto-generated method stub
		String sql = "insert into Steamflix.Fornecedor(cnpjFornecedor, "
				+ "razaoSocialFornecedor, nomeFantasiaFornecedor) values(?,?,?)";
		try {
			// prepared statement para a inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setString(1, fornecedor.getCNPJ());
			stmt.setString(2, fornecedor.getRazaoSocial());
			stmt.setString(3, fornecedor.getNomeFantasia());

			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void atualizar(Fornecedor fornecedor) {
		// TODO Auto-generated method stub
		String sql = "update Steamflix.Fornecedor set razaoSocialFornecedor = ? ,"
				+ " nomeFantasiaFornecedor = ? where cnpjFornecedor = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, fornecedor.getRazaoSocial());
			stmt.setString(2, fornecedor.getNomeFantasia());
			stmt.setString(3, fornecedor.getCNPJ());

			stmt.executeUpdate();
			stmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	@Override
	public void remover(String cnpj) {
		// TODO Auto-generated method stub
		String sql = "update Steamflix.Fornecedor set flagFornecedor = ? where cnpjFornecedor = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, 0);
			stmt.setString(2, cnpj);

			stmt.executeUpdate();
			stmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	@Override
	public Fornecedor procurar(String cnpj) {
		// TODO Auto-generated method stub
		Fornecedor fornecedorProcurado = new Fornecedor();
		String sql = "select * from Steamflix.Fornecedor where cnpjFornecedor = ? and flagFornecedor = 1";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cnpj);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				fornecedorProcurado.setCNPJ(rs.getString(1));
				fornecedorProcurado.setRazaoSocial(rs.getString(2));
				fornecedorProcurado.setNomeFantasia(rs.getString(3));
			}
			stmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		return fornecedorProcurado;
	}

	@Override
	public boolean existe(String cnpj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Fornecedor> listar() {
		// TODO Auto-generated method stub
		String sql = "select * from Steamflix.Fornecedor where flagFornecedor = 1";
		ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Fornecedor fornecedor = new Fornecedor();

				fornecedor.setCNPJ(rs.getString(1));
				fornecedor.setRazaoSocial(rs.getString(2));
				fornecedor.setNomeFantasia(rs.getString(3));
				

				fornecedores.add(fornecedor);
			}
			rs.close();
			stmt.close();
			return fornecedores;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

}
