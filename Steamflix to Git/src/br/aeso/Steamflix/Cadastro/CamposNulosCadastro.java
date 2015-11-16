package br.aeso.Steamflix.Cadastro;

public class CamposNulosCadastro {
	public boolean estaVazio(Cadastro cadastro) {
		boolean flag = false;
		if (cadastro.getLogin().trim().isEmpty()
				|| cadastro.getSenha().trim().isEmpty()
				|| cadastro.getEmailPrincipal().trim().isEmpty()) {
			flag = true;
		}
		return flag;
	}

	public boolean validaLogin(String login, String senha) {
		boolean flag = false;
		if (login.equals(null)|| senha.equals(null)) {
			flag = true;
		} else if (login.trim().isEmpty() || senha.trim().isEmpty()) {
			flag = true;
		}
		return flag;
	}
}
