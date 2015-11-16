package br.aeso.Steamflix.Cliente;

import br.aeso.Steamflix.Cliente.Cliente;

public class CamposNulosCliente {
	public boolean estaVazio(Cliente cliente) {
		boolean flag = false;
		if (cliente.getNome().trim().isEmpty()
				|| cliente.getCPF().trim().isEmpty()
				|| cliente.getDataDeNascimento().equals(null)) {
			flag = true;
		}
		return flag;
	}
}
