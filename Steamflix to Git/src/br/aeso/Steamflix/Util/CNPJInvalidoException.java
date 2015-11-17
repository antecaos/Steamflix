package br.aeso.Steamflix.Util;

public class CNPJInvalidoException extends Exception{
	private String cnpj;

	public CNPJInvalidoException (String cnpj) {
		super("\nCPF " + cnpj + " Nulo ou Inválido\n");
		this.cnpj = cnpj;
	}
}
