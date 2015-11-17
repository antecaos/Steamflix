package br.aeso.Steamflix.Cliente;

import java.util.ArrayList;

import br.aeso.Steamflix.Cadastro.Cadastro;
import br.aeso.Steamflix.Cadastro.CamposNulosCadastro;
import br.aeso.Steamflix.Util.CPFInvalidoException;
import br.aeso.Steamflix.Util.CampoVazioException;
import br.aeso.Steamflix.Util.ValidarCPF;
import br.aeso.Steamflix.Cadastro.ControladorCadastro;
import br.aeso.Steamflix.Endereco.ControladorEndereco;
import br.aeso.Steamflix.Endereco.Endereco;

public class ControladorCliente {
	private IRepositorioCliente repositorioCliente;
	private ControladorEndereco controladorEndereco;
	private ControladorCadastro controladorCadastro;
	private CamposNulosCliente camposNulos;

	public ControladorCliente() {
		this.repositorioCliente = new RepositorioClienteDAO();
		this.controladorEndereco = new ControladorEndereco();
		this.controladorCadastro = new ControladorCadastro();
		this.camposNulos = new CamposNulosCliente();
	}

	public void cadastrar(Cliente cliente) throws CampoVazioException,
			CPFInvalidoException {
	
		if (cliente == null)
			throw new IllegalArgumentException("Cliente Inválido.");

		if (camposNulos.estaVazio(cliente))
			throw new CampoVazioException();

		if (!ValidarCPF.validaCPF(cliente.getCPF()))
			throw new CPFInvalidoException(cliente.getCPF());

		this.repositorioCliente.cadastrar(cliente);
		controladorCadastro.cadastrar(cliente.getCadastro());
		controladorEndereco.cadastrar(cliente.getEndereco());
	}

	public void atualizar(Cliente cliente) {
		this.repositorioCliente.atualizar(cliente);
		controladorCadastro.atualizar(cliente.getCadastro());
		controladorEndereco.atualizar(cliente.getEndereco());
	}

	public void remover(Cliente cliente) {
		controladorCadastro.remover(cliente.getCadastro());

		controladorEndereco.remover(cliente.getEndereco());

		this.repositorioCliente.remover(cliente);
	}

	public Cliente procurar(String cpf) {
		Cliente cliente = null;
		Endereco endereco = null;
		Cadastro cadastro = null;

		cliente = this.repositorioCliente.procurar(cpf);

		endereco = this.controladorEndereco.procurarPorCliente(cpf);
		cadastro = this.controladorCadastro.procurarPorCliente(cpf);

		endereco.setCliente(cliente);
		cadastro.setCliente(cliente);

		cliente.setCadastro(cadastro);
		cliente.setEndereco(endereco);
		return cliente;
	}

	public ArrayList<Cliente> listar() {
		ArrayList<Cliente> clientes = null;
		Endereco endereco = null;
		Cadastro cadastro = null;

		clientes = this.repositorioCliente.listar();

		for (Cliente cliente : clientes) {
			endereco = this.controladorEndereco.procurarPorCliente(cliente
					.getCPF());
			cadastro = this.controladorCadastro.procurarPorCliente(cliente
					.getCPF());

			endereco.setCliente(cliente);
			cadastro.setCliente(cliente);

			cliente.setCadastro(cadastro);
			cliente.setEndereco(endereco);
		}

		return clientes;
	}
}
