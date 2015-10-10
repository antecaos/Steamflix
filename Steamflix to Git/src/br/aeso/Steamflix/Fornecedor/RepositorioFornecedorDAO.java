package br.aeso.Steamflix.Fornecedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

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

	}

	@Override
	public void remover(String cnpj) {
		// TODO Auto-generated method stub

	}

	@Override
	public Fornecedor procurar(String cnpj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(String cnpj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Fornecedor> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
