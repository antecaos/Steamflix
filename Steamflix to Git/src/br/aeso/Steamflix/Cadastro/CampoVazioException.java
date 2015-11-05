package br.aeso.Steamflix.Cadastro;

public class CampoVazioException extends Exception{
	public CampoVazioException(){
		super("Algum campo do cadastro está vazio!");
	} 
}
