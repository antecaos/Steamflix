package br.aeso.Steamflix.Cupom;

import java.util.ArrayList;

public class ControladorCupom {
	private IRepositorioCupom repositorioCupom;

	public ControladorCupom() {
		repositorioCupom = new RepositorioCupomDAO();
	}

	public void cadastrar(Cupom cupom) {
		this.repositorioCupom.cadastrar(cupom);
	}
	
	public void atualizar(Cupom cupom){
		this.repositorioCupom.atualizar(cupom);
	}
	
	public void remover(int id){
		this.repositorioCupom.remover(id);
	}
	
	public Cupom procurar(int id){
		return this.repositorioCupom.procurar(id);
	}
	
	public ArrayList<Cupom> listar(){
		return this.repositorioCupom.listar();
	}
	
	
}
