package br.edu.ifsp.model.cargo;

import br.edu.ifsp.model.departamento.Departamento;

public class Cargo {
	private Integer id;
	private String descricao;
	private Departamento depto;
	
	public Integer getId() {
		return id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public Departamento getDepartamento() {
		return depto;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void setDepartamento(Departamento depto) {
		this.depto = depto;
	}
}
