package br.aeso.Steamflix.Fornecedor;

import br.aeso.Steamflix.Cadastro.Cadastro;
import br.aeso.Steamflix.Endereco.Endereco;

public class Fornecedor {
	private String CNPJ;
	private String razaoSocial;
	private String nomeFantasia;
	private Endereco endereco;
	private Cadastro cadastro;
	private int flag;

	public Fornecedor(String CNPJ, String razaoSocial, String nomeFantasia) {
		this.CNPJ = CNPJ;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
	}

	public Fornecedor() {
	}

	public String getCNPJ() {
		return this.CNPJ;
	}

	public void setCNPJ(String CNPJ) {
		if (CNPJ == null) {
			this.CNPJ = CNPJ;
		}else{
			this.CNPJ = CNPJ.replaceAll("\\/|\\.|\\-|\\ ", "");
		}
		
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Cadastro getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "Fornecedor CNPJ: " + CNPJ + "\nRazao Social: " + razaoSocial
				+ "\nNome Fantasia: " + nomeFantasia + cadastro
				+ "\nEndereco: " + endereco;
	}

}
