package br.aeso.Steamflix.Fornecedor;

import java.util.ArrayList;

import br.aeso.Steamflix.Cadastro.Cadastro;
import br.aeso.Steamflix.Util.CNPJInvalidoException;
import br.aeso.Steamflix.Util.CPFInvalidoException;
import br.aeso.Steamflix.Util.CampoVazioException;
import br.aeso.Steamflix.Util.ValidarCNPJ;
import br.aeso.Steamflix.Util.ValidarCPF;
import br.aeso.Steamflix.Cadastro.ControladorCadastro;
import br.aeso.Steamflix.Fornecedor.Fornecedor;
import br.aeso.Steamflix.Endereco.ControladorEndereco;
import br.aeso.Steamflix.Endereco.Endereco;

public class ControladorFornecedor {

	private IRepositorioFornecedor repositorioFornecedor;
	private ControladorEndereco controladorEndereco;
	private ControladorCadastro controladorCadastro;
	private CamposNulosFornecedor camposNulos;

	public ControladorFornecedor() {
		this.repositorioFornecedor = new RepositorioFornecedorDAO();
		this.controladorCadastro = new ControladorCadastro();
		this.controladorEndereco = new ControladorEndereco();
		this.camposNulos = new CamposNulosFornecedor();
	}

	public void cadastrar(Fornecedor fornecedor) throws CampoVazioException,
			CNPJInvalidoException, FornecedorJaCadastradoException {

		if (fornecedor == null)
			throw new IllegalArgumentException("Cadastro Inválido.");

		if (camposNulos.estaVazio(fornecedor))
			throw new CampoVazioException();

		if (!ValidarCNPJ.isCNPJ(fornecedor.getCNPJ()))
			throw new CNPJInvalidoException(fornecedor.getCNPJ());

		this.repositorioFornecedor.cadastrar(fornecedor);
		this.controladorCadastro.cadastrar(fornecedor.getCadastro());
		this.controladorEndereco.cadastrar(fornecedor.getEndereco());
	}

	public void atualizar(Fornecedor fornecedor) {
		this.repositorioFornecedor.atualizar(fornecedor);
		this.controladorCadastro.atualizar(fornecedor.getCadastro());
		this.controladorEndereco.atualizar(fornecedor.getEndereco());
	}

	public void remover(String cnpj) {
		Fornecedor fornecedor = this.procurar(cnpj);

		this.controladorCadastro.remover(fornecedor.getCadastro());
		this.controladorEndereco.remover(fornecedor.getEndereco());

		this.repositorioFornecedor.remover(cnpj);
	}

	public Fornecedor procurar(String cnpj) {
		Fornecedor fornecedor = this.repositorioFornecedor.procurar(cnpj);
		Cadastro cadastro = this.controladorCadastro
				.procurarPorFornecedor(cnpj);
		Endereco endereco = this.controladorEndereco
				.procurarPorFornecedor(cnpj);

		cadastro.setFornecedor(fornecedor);
		endereco.setFornecedor(fornecedor);

		fornecedor.setCadastro(cadastro);
		fornecedor.setEndereco(endereco);

		return fornecedor;
	}

	public ArrayList<Fornecedor> listar() {
		ArrayList<Fornecedor> fornecedors = null;
		Endereco endereco = null;
		Cadastro cadastro = null;

		fornecedors = this.repositorioFornecedor.listar();

		for (Fornecedor fornecedor : fornecedors) {
			endereco = this.controladorEndereco
					.procurarPorFornecedor(fornecedor.getCNPJ());
			cadastro = this.controladorCadastro
					.procurarPorFornecedor(fornecedor.getCNPJ());

			endereco.setFornecedor(fornecedor);
			cadastro.setFornecedor(fornecedor);

			fornecedor.setCadastro(cadastro);
			fornecedor.setEndereco(endereco);
		}

		return fornecedors;
	}

}
