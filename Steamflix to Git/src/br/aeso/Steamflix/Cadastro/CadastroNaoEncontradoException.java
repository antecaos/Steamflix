package br.aeso.Steamflix.Cadastro;

public class CadastroNaoEncontradoException extends Exception{
	public CadastroNaoEncontradoException(){
		super("Cadastro não encontrado!");
	}
}
