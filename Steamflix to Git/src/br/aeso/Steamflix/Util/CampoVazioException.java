package br.aeso.Steamflix.Util;

public class CampoVazioException extends Exception{
	public CampoVazioException(){
		super("Algum campo obrigatório está vazio!");
	} 
}
