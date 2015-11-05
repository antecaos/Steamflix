package br.aeso.Steamflix.Cadastro;

public class CamposNulosCadastro {
	public boolean estaVazio(Cadastro cadastro) {
		Boolean flag = false;
		if (cadastro.getLogin().trim().isEmpty()
				|| cadastro.getSenha().trim().isEmpty()) {
			flag = true;
		}
		return flag;
	}
}
