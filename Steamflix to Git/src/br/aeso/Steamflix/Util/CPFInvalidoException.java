package br.aeso.Steamflix.Util;

public class CPFInvalidoException extends Exception {
	private String cpf;

	public CPFInvalidoException(String cpf) {
		super("\nCPF " + cpf + " Nulo ou Inválido\n");
		this.cpf = cpf;
	}
}
