package br.aeso.Steamflix.Endereco;

import br.aeso.Steamflix.Endereco.Endereco;

public class CamposNulosEndereco {
	public boolean estaVazio(Endereco endereco) {
		boolean flag = false;
		if (endereco.getLogradouro().trim().isEmpty()
				|| endereco.getBairro().trim().isEmpty()
				|| endereco.getCEP().trim().isEmpty()
				|| endereco.getCidade().trim().isEmpty()
				|| endereco.getEstado().trim().isEmpty()
				|| endereco.getLogradouro().trim().isEmpty()
				|| endereco.getNumero().trim().isEmpty()
				|| endereco.getPais().trim().isEmpty()) {
			flag = true;
		}
		return flag;
	}
}
