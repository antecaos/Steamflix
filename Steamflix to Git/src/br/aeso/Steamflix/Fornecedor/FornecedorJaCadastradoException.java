package br.aeso.Steamflix.Fornecedor;

public class FornecedorJaCadastradoException extends Exception{
	public FornecedorJaCadastradoException(){
		super("Fornecedor já cadastrado!");
	}
}
