package br.aeso.Steamflix.Cliente;

import java.text.DateFormat;
import java.util.Calendar;

import br.aeso.Steamflix.Cadastro.Cadastro;
import br.aeso.Steamflix.Endereco.Endereco;

public class Cliente {
	private String nome;
	private String CPF;
	private Calendar dataDeNascimento;
	private Endereco endereco;
	private Cadastro cadastro;
	private int flag;

	public Cliente() {
	}

	public Cliente(String nome, String CPF, Calendar dataNascimento) {
		this.setCPF(CPF);
		this.setNome(nome);
		this.setDataDeNascimento(dataNascimento);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String CPF) {
		if (CPF == null) {
			this.CPF = CPF;
		} else {
			this.CPF = CPF.replaceAll("\\.|\\-|\\ ", "");
		}
	}

	public Calendar getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Calendar dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
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

	public String dataFormatada() {
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
		return df.format(this.dataDeNascimento.getTime());
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "Cliente: " + nome + "\nCPF: " + CPF + "\nData de nascimento: "
				+ this.dataFormatada() + cadastro + "\nEndereço: " + endereco;
	}

}
