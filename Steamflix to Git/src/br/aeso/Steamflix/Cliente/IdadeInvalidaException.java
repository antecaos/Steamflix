package br.aeso.Steamflix.Cliente;

public class IdadeInvalidaException extends Exception {
	public IdadeInvalidaException() {
		super("Você não tem idade para fazer o cadastro!");
	}
}
