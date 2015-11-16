package br.aeso.Steamflix.Jogo;

import br.aeso.Steamflix.Jogo.Jogo;

public class CamposNulosJogo {
	public boolean estaVazio(Jogo Jogo) {
		boolean flag = false;
		String valorAluguel = "" + Jogo.getPrecoAluguel();
		String valorCompra = "" + Jogo.getPrecoVenda();
		String quantidade = "" + Jogo.getQuantidade();
		if (Jogo.getNome().trim().isEmpty()
				|| Jogo.getClassificacao().trim().isEmpty()
				|| valorAluguel.trim().isEmpty()
				|| valorCompra.trim().isEmpty()
				|| Jogo.getDataLancamento().equals(null)
				|| Jogo.getDesenvolvedor().trim().isEmpty()
				|| Jogo.getNota().trim().isEmpty()
				|| quantidade.trim().isEmpty()) {
			flag = true;
		}
		return flag;
	}
}
