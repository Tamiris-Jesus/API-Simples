package br.edu.ifsp.model.departamento;

import br.edu.ifsp.model.funcionario.Funcionario;

public class Departamento {
	private Integer id;
	private String nomeDepto;
	private Funcionario gerente;
	
	public Integer getId() {
		return id;
	}
	
	public String getNomeDepto() {
		return nomeDepto;
	}
	
	public Funcionario getGerente() {
		return gerente;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setNomeDepto(String nomeDepto) {
		this.nomeDepto = nomeDepto;
	}
	
	public void setGerente(Funcionario gerente) {
		this.gerente = gerente;
	}
}
