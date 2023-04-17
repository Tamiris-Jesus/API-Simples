package br.edu.ifsp.controller;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.dao.CargoDao;
import br.edu.ifsp.dao.DepartamentoDao;
import br.edu.ifsp.model.cargo.Cargo;
import br.edu.ifsp.model.cargo.CargoValidacao;
import br.edu.ifsp.model.departamento.Departamento;

public class CargoController {
	private Cargo cargo;
	private List<String> erros;

    public List<String> insereCargo(String descricao, Departamento depto) {
    	recebeDadosCargo(null, descricao, depto);
    	
		// Se nenhum erro de valida��o for encontrado, tenta inserir o cargo no banco.
		if (erros.size() == 0)
			erros.add(new CargoDao().insereCargo(cargo));
		
		// Retorna o ArrayList contendo:
		// - Em caso de sucesso: null na 1� posi��o; OU
		// - Em caso de exce��o: uma mensagem de exce��o na 1� posi��o; OU
		// - Em caso de erro de valida��o: mensagens de erro iniciando na 1� posi��o.
		return erros; 
    }
    

	// M�todo usado pelas operacoes de insercao de cargo
    public void recebeDadosCargo(Integer id, String descricao, Departamento depto) {
    	cargo = new Cargo();
    	erros = new ArrayList<String>();

		// Os m�todos set abaixo criam um objeto Cargo contendo os dados do Cargo informado.
		// Este objeto sera enviado para a classe DAO, que fara a insercao de seus dados no banco.
    	cargo.setId(id);
    	cargo.setDescricao(descricao);
		cargo.setDepartamento(depto);
        
		// Retorna um ArrayList contendo os erros encontrados em regras de valida��o e de neg�cios.
		erros = CargoValidacao.validaCargo(cargo);
    }
    
    public List<Departamento> recuperaDepartamentos() {
    	// Recupera os departamentos cadastrados no banco de dados para que sejam exibidos no campo Departamento.
    	return new DepartamentoDao().recuperaDepartamentos();
    }
    
    public String getExcecao() {
    	// Retorna a excecao lancada ao recuperar os departamentos (ao abrir a interface "Cadastro de Cargo").
    	return new DepartamentoDao().getExcecao();
    }
}
