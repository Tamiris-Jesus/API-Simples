package br.edu.ifsp.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.dao.FuncionarioDao;
import br.edu.ifsp.model.cargo.Cargo;
import br.edu.ifsp.model.funcionario.Funcionario;
import br.edu.ifsp.model.funcionario.FuncionarioValidacao;

public class FuncionarioController {
	private Funcionario funcionario;
	private List<String> erros;

    public List<String> insereFuncionario(String nome, Character sexo, BigDecimal salario, Boolean planoSaude, Cargo cargo) {
    	recebeDadosFuncionario(null, nome, sexo, salario, planoSaude, cargo);
    	
		// Se nenhum erro de valida��o for encontrado, tenta inserir o funcion�rio no banco.
		if (erros.size() == 0)
			erros.add(new FuncionarioDao().insereFuncionario(funcionario));
		
		// Retorna o ArrayList contendo:
		// - Em caso de sucesso: null na 1� posi��o; OU
		// - Em caso de exce��o: uma mensagem de exce��o na 1� posi��o; OU
		// - Em caso de erro de valida��o: mensagens de erro iniciando na 1� posi��o.
		return erros; 
    }
    
    // M�todo usado pelas opera��es de inser��o e altera��o de funcion�rio.
    public void recebeDadosFuncionario(Integer id, String nome, Character sexo, BigDecimal salario, Boolean planoSaude, Cargo cargo) {
    	funcionario = new Funcionario();
    	erros = new ArrayList<String>();

		// Os m�todos set abaixo criam um objeto Funcionario contendo os dados do funcion�rio informado.
		// Este objeto ser� enviado � classe DAO, que far� a inser��o de seus dados no banco.
    	funcionario.setId(id);
    	funcionario.setNome(nome);
		funcionario.setSexo(sexo);
		funcionario.setSalario(salario);
		funcionario.setPlanoSaude(planoSaude);
		funcionario.setCargo(cargo);
        
		// Retorna um ArrayList contendo os erros encontrados em regras de valida��o e de neg�cios.
		erros = FuncionarioValidacao.validaFuncionario(funcionario);
    }
    
    public List<Cargo> recuperaCargos() {
    	// Recupera os cargos cadastrados no banco de dados para que sejam exibidos no campo Cargo.
		return new FuncionarioDao().recuperaCargos();
    }
    
    public String getExcecao() {
    	// Retorna a exce��o lan�ada ao recuperar os cargos (ao abrir a interface "Cadastro de Funcion�rio").
    	return new FuncionarioDao().getExcecao();
    }
    
    public List<Funcionario> consultaFuncionarios() {
		return new FuncionarioDao().consultaFuncionarios();
    }
}

