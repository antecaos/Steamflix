package br.aeso.Steamflix.Filme;

import br.aeso.Steamflix.Filme.Filme;

public class CamposNulosFilme {
	public boolean estaVazio(Filme filme) {
		boolean flag = false;
		String valorAluguel = "" + filme.getPrecoAluguel();
		String valorCompra = "" + filme.getPrecoVenda();
		String quantidade = "" + filme.getQuantidade();
		if (filme.getNome().trim().isEmpty()
				|| filme.getClassificacao().trim().isEmpty()
				|| valorAluguel.trim().isEmpty()
				|| valorCompra.trim().isEmpty()
				|| filme.getDataLancamento().equals(null)
				|| filme.getDiretor().trim().isEmpty()
				|| filme.getNota().trim().isEmpty()
				|| quantidade.trim().isEmpty()) {
			flag = true;
		}
		return flag;
	}
}
