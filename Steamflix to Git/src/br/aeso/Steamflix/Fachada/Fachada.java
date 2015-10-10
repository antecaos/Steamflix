package br.aeso.Steamflix.Fachada;

import java.util.ArrayList;

import br.aeso.Steamflix.Cliente.Cliente;
import br.aeso.Steamflix.Cliente.ControladorCliente;
import br.aeso.Steamflix.Cupom.ControladorCupom;
import br.aeso.Steamflix.Cupom.Cupom;
import br.aeso.Steamflix.Fornecedor.ControladorFornecedor;
import br.aeso.Steamflix.Fornecedor.Fornecedor;
import br.aeso.Steamflix.Genero.ControladorGenero;
import br.aeso.Steamflix.Genero.Genero;

public class Fachada {
	private static Fachada instance;
	private ControladorGenero controladorGenero;
	private ControladorCupom controladorCupom;
	private ControladorCliente controladorCliente;
	private ControladorFornecedor controladorFornecedor;

	private Fachada() {
		this.controladorGenero = new ControladorGenero();
		this.controladorCupom = new ControladorCupom();
		this.controladorCliente = new ControladorCliente();
		this.controladorFornecedor = new ControladorFornecedor();
	}

	public static Fachada getInstance() {
		if (Fachada.instance == null) {
			Fachada.instance = new Fachada();
		}
		return Fachada.instance;
	}

	public void cadastrarGenero(Genero genero) {
		this.controladorGenero.cadastrar(genero);
	}

	public void atualizarGenero(Genero genero) {
		this.controladorGenero.atualizar(genero);
	}

	public void removerGenero(int id) {
		this.controladorGenero.remover(id);
	}

	public Genero procurarGenero(int id) {
		return this.controladorGenero.procurar(id);
	}

	public ArrayList<Genero> listarGenero() {
		return controladorGenero.listar();
	}

	public void cadastrarCupom(Cupom cupom) {
		this.controladorCupom.cadastrar(cupom);
	}

	public void atualizarCupom(Cupom cupom) {
		this.controladorCupom.atualizar(cupom);
	}

	public void removerCupom(int id) {
		this.controladorCupom.remover(id);
	}

	public Cupom procurarCupom(int id) {
		return this.controladorCupom.procurar(id);
	}

	public ArrayList<Cupom> listarCupom() {
		return this.controladorCupom.listar();
	}

	public void cadastrarCliente(Cliente cliente) {
		this.controladorCliente.cadastrar(cliente);
	}

	public void atualizarCliente(Cliente cliente) {
		this.controladorCliente.atualizar(cliente);
	}

	public void removerCliente(Cliente cliente) {
		this.controladorCliente.remover(cliente);
	}

	public Cliente procuraCliente(String cpf) {
		return this.controladorCliente.procurar(cpf);
	}

	public ArrayList<Cliente> listaCliente() {
		return this.controladorCliente.listar();
	}

	public void cadastrarFornecedor(Fornecedor fornecedor){
		this.controladorFornecedor.cadastrar(fornecedor);		
	}
	
	public void atualizarFornecedor(Fornecedor fornecedor){
		this.controladorFornecedor.cadastrar(fornecedor);
	}  
	
	public void removerFornecedor(String cpf) {
		this.controladorFornecedor.remover(cpf);
	}

	public Fornecedor procuraFornecedor(String cpf) {
		return this.controladorFornecedor.procurar(cpf);
	}

	public ArrayList<Fornecedor> listaFornecedor() {
		return this.controladorFornecedor.listar();
	}
	
	
}
