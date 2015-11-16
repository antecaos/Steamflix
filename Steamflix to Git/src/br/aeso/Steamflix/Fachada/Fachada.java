package br.aeso.Steamflix.Fachada;

import java.util.ArrayList;

import br.aeso.Steamflix.Aluguel.Aluguel;
import br.aeso.Steamflix.Aluguel.ControladorAluguel;
import br.aeso.Steamflix.Cadastro.Cadastro;
import br.aeso.Steamflix.Cadastro.CampoVazioException;
import br.aeso.Steamflix.Cadastro.ControladorCadastro;
import br.aeso.Steamflix.Cliente.Cliente;
import br.aeso.Steamflix.Cliente.ControladorCliente;
import br.aeso.Steamflix.Compra.Compra;
import br.aeso.Steamflix.Compra.ControladorCompra;
import br.aeso.Steamflix.Cupom.ControladorCupom;
import br.aeso.Steamflix.Cupom.Cupom;
import br.aeso.Steamflix.Filme.ControladorFilme;
import br.aeso.Steamflix.Filme.Filme;
import br.aeso.Steamflix.Fornecedor.ControladorFornecedor;
import br.aeso.Steamflix.Fornecedor.Fornecedor;
import br.aeso.Steamflix.Genero.ControladorGenero;
import br.aeso.Steamflix.Genero.Genero;
import br.aeso.Steamflix.Jogo.ControladorJogo;
import br.aeso.Steamflix.Jogo.Jogo;

public class Fachada {
	private static Fachada instance;
	private ControladorGenero controladorGenero;
	private ControladorCupom controladorCupom;
	private ControladorCliente controladorCliente;
	private ControladorFornecedor controladorFornecedor;
	private ControladorFilme controladorFilme;
	private ControladorJogo controladorJogo;
	private ControladorAluguel controladorAluguel;
	private ControladorCompra controladorCompra;
	private ControladorCadastro controladorCadastro;
	
	private Fachada() {
		this.controladorGenero = new ControladorGenero();
		this.controladorCupom = new ControladorCupom();
		this.controladorCliente = new ControladorCliente();
		this.controladorFornecedor = new ControladorFornecedor();
		this.controladorFilme = new ControladorFilme();
		this.controladorJogo = new ControladorJogo();
		this.controladorAluguel = new ControladorAluguel();
		this.controladorCompra = new ControladorCompra();
		this.controladorCadastro = new ControladorCadastro();
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

	public void cadastrarCliente(Cliente cliente) throws CampoVazioException {
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

	public void cadastrarFornecedor(Fornecedor fornecedor) throws CampoVazioException{
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
	
	public void cadastrarJogo(Jogo jogo){
		this.controladorJogo.cadastrar(jogo);		
	}
	
	public void atualizarJogo(Jogo jogo){
		this.controladorJogo.atualizar(jogo);
	}  
	
	public void removerJogo(int id) {
		this.controladorJogo.remover(id);
	}

	public Jogo procuraJogo(int id) {
		return this.controladorJogo.procurar(id);
	}

	public ArrayList<Jogo> listaJogo() {
		return this.controladorJogo.listar();
	}
	
	public void cadastrarAluguel(Aluguel aluguel){
		this.controladorAluguel.cadastrar(aluguel);		
	}
	
	public void atualizarAluguel(Aluguel aluguel){
		this.controladorAluguel.atualizar(aluguel);
	}  
	
	public void removerAluguel(int id) {
		this.controladorAluguel.remover(id);
	}

	public Aluguel procuraAluguel(int id) {
		return this.controladorAluguel.procurar(id);
	}

	public ArrayList<Aluguel> listaAluguel() {
		return this.controladorAluguel.listar();
	}
	
	public void cadastrarCompra(Compra aluguel){
		this.controladorCompra.cadastrar(aluguel);		
	}
	
	public void atualizarCompra(Compra aluguel){
		this.controladorCompra.atualizar(aluguel);
	}  
	
	public void removerCompra(int id) {
		this.controladorCompra.remover(id);
	}

	public Compra procuraCompra(int id) {
		return this.controladorCompra.procurar(id);
	}

	public ArrayList<Compra> listaCompra() {
		return this.controladorCompra.listar();
	}
	
	public Cadastro retornaCadastro(String login,String senha) throws CampoVazioException{
		return this.controladorCadastro.retornaCadastro(login, senha);		
	}
}
