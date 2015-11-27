package br.aeso.Steamflix.Cliente;

public class ClienteJaExisteException extends Exception{
	public ClienteJaExisteException(){
		super("Cliente já cadastrado!");
	}
}
