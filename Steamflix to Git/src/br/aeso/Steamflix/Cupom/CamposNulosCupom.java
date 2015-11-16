package br.aeso.Steamflix.Cupom;

import br.aeso.Steamflix.Cupom.Cupom;

public class CamposNulosCupom {
	public boolean estaVazio(Cupom cupom) {
		boolean flag = false;
		String valor = "" + cupom.getValor();
		if (valor.trim().isEmpty() || cupom.getNome().trim().isEmpty()) {
			flag = true;
		}
		return flag;
	}
}
