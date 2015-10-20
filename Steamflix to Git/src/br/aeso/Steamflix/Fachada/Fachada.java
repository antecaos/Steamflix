package br.aeso.Steamflix.Fachada;

import java.util.ArrayList;

import br.aeso.Steamflix.Cliente.Cliente;
import br.aeso.Steamflix.Cliente.ControladorCliente;
import br.aeso.Steamflix.Cupom.ControladorCupom;
import br.aeso.Steamflix.Cupom.Cupom;
import br.aeso.Steamflix.Filme.ControladorFilme;
import br.aeso.Steamflix.Filme.Filme;
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
	private ControladorFilme controladorFilme;

	private Fachada() {
		this.controladorGenero = new ControladorGenero();
		this.controladorCupom = new ControladorCupom();
		this.controladorCliente = new ControladorCliente();
		this.controladorFornecedor = new ControladorFornecedor();
		this.controladorFilme = new ControladorFilme();
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
		this.controladorFornecedor.atualizar(fornecedor);
	}  
	
	public void removerFornecedor(String cnpj) {
		this.controladorFornecedor.remover(cnpj);
	}

	public Fornecedor procuraFornecedor(String cnpj) {
		return this.controladorFornecedor.procurar(cnpj);
	}

	public ArrayList<Fornecedor> listaFornecedor() {
		return this.controladorFornecedor.listar();
	}
	
	public void cadastrarFilme(Filme filme){
		this.controladorFilme.cadastrar(filme);		
	}
	
	public void atualizarFilme(Filme filme){
		this.controladorFilme.atualizar(filme);
	}  
	
	public void removerFilme(int id) {
		this.controladorFilme.remover(id);
	}

	public Filme procuraFilme(int id) {
		return this.controladorFilme.procurar(id);
	}

	public ArrayList<Filme> listaFilme() {
		return this.controladorFilme.listar();
	}
}
