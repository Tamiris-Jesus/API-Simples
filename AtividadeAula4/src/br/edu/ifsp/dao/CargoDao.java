package br.edu.ifsp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.model.cargo.Cargo;
import br.edu.ifsp.model.departamento.Departamento;
import br.edu.ifsp.model.funcionario.Funcionario;

public class CargoDao extends GenericDao {
	private String instrucaoSql; // Atributo para armazenar a instru��o SQL a ser executada.
	private PreparedStatement comando; // Atributo usado para preparar e executar instru��es SQL.
	private ResultSet registros; // Atributo que recebe os dados retornados por uma instru��o SQL.
	private static String excecao = null; // Atributo para armazenar mensagens de excecao.

    public String insereCargo(Cargo cargo) {
        instrucaoSql = "INSERT INTO Cargo (Descricao, IdDepto) VALUES (?,?)";
        return insere(instrucaoSql, cargo.getDescricao(), cargo.getDepartamento().getId()); 
       
    }
    
    /*
    
    public List<Cargo> recuperaCargos() {
        Cargo cargo;
        List<Cargo> cargos = new ArrayList<Cargo>();
        instrucaoSql = "SELECT * FROM Cargo";
        
        try {
        	excecao = ConnectionDatabase.conectaBd(); // Abre a conex�o com o banco de dados.
        	if (excecao == null) {
                // Obt�m os dados de conex�o com o banco de dados e prepara a instru��o SQL.
                comando = ConnectionDatabase.getConexaoBd().prepareStatement(instrucaoSql);
                
                // Executa a instru��o SQL e retorna os dados ao objeto ResultSet.
                registros = comando.executeQuery();
                
                if (registros.next()) { // Se for retornado pelo menos um registro.
                    registros.beforeFirst(); // Retorna o cursor para antes do 1� registro.
        	        while (registros.next()) {
                        // Atribui o Id e a Descri��o do cargo ao objeto Cargo por meio dos m�todos set e
                        // adiciona este objeto ao ArrayList funcionarios.
        	            cargo = new Cargo();
        	            cargo.setId(registros.getInt("Id"));
        	            cargo.setDescricao(registros.getString("Descricao"));
        	            cargos.add(cargo);
        	        }
        	    }
                registros.close(); // Libera os recursos usados pelo objeto ResultSet.
                comando.close(); // Libera os recursos usados pelo objeto PreparedStatement.
                // Libera os recursos usados pelo objeto Connection e fecha a conex�o com o banco de dados.
                ConnectionDatabase.getConexaoBd().close(); 
            }
        } catch (Exception e) {
        	excecao = "Tipo de Exce��o: " + e.getClass().getSimpleName() + "\nMensagem: " + e.getMessage();
        	cargos = null; // Caso ocorra qualquer exce��o.
        }
        return cargos; // Retorna o ArrayList de objetos Cargo.
    }
    
    // Esse m�todo � necess�rio, porque os m�todos "recuperaCargos" e "consultaFuncionarios" retornam List<> e n�o String.
	public String getExcecao() {
		return excecao;
	}
	
	*/
    
    public List<Departamento> recuperaDepartamentos() {
        Departamento departamento;
        List<Departamento> departamentos = new ArrayList<Departamento>();
        instrucaoSql = "SELECT * FROM departamento";
        
        try {
        	excecao = ConnectionDatabase.conectaBd(); // Abre a conex�o com o banco de dados.
        	if (excecao == null) {
                // Obt�m os dados de conex�o com o banco de dados e prepara a instru��o SQL.
                comando = ConnectionDatabase.getConexaoBd().prepareStatement(instrucaoSql);
                
                // Executa a instru��o SQL e retorna os dados ao objeto ResultSet.
                registros = comando.executeQuery();
                
                if (registros.next()) { // Se for retornado pelo menos um registro.
                    registros.beforeFirst(); // Retorna o cursor para antes do 1� registro.
        	        while (registros.next()) {
                        // Atribui o Id e a Descri��o do cargo ao objeto Cargo por meio dos m�todos set e
                        // adiciona este objeto ao ArrayList funcionarios.
        	        	
        	        	
        	        	departamento =  new Departamento();
        	        	departamento.setId(registros.getInt("Id"));
        	        	departamento.setNomeDepto(registros.getString("NomeDepto"));
        	        	departamentos.add(departamento);;
        	        	
        	  
        	        }
        	    }
                registros.close(); // Libera os recursos usados pelo objeto ResultSet.
                comando.close(); // Libera os recursos usados pelo objeto PreparedStatement.
                // Libera os recursos usados pelo objeto Connection e fecha a conex�o com o banco de dados.
                ConnectionDatabase.getConexaoBd().close(); 
            }
        } catch (Exception e) {
        	excecao = "Tipo de Exce��o: " + e.getClass().getSimpleName() + "\nMensagem: " + e.getMessage();
        	departamentos = null; // Caso ocorra qualquer exce��o.
        }
        return departamentos; // Retorna o ArrayList de objetos Cargo.
    }
    
    // Esse m�todo � necess�rio, porque os m�todos "recuperaCargos" e "consultaFuncionarios" retornam List<> e n�o String.
	public String getExcecao() {
		return excecao;
	}
	
	
	
	
	/*################################	ADICIONANDO CONSULTA 	##########################################*/
	public List<Cargo> consultaCargos() {
		//Funcionario funcionario;
		
		Departamento departamento;
	    Cargo cargo;
	    //List<Funcionario> funcionarios = new ArrayList<Funcionario>();
	    List<Departamento> departamentos = new ArrayList<Departamento>();
	    List<Cargo> cargos = new ArrayList<Cargo>();
	    
	    String instrucaoSql = "SELECT * FROM cargo";
		PreparedStatement comando;
		ResultSet registros;

	    try {
	    	excecao = ConnectionDatabase.conectaBd(); // Abre a conex�o com o banco de dados.
	    	if (excecao == null) {
	            // Obt�m os dados de conex�o com o banco de dados e prepara a instru��o SQL.
	            comando = ConnectionDatabase.getConexaoBd().prepareStatement(instrucaoSql);
	            
	            // Executa a instru��o SQL e retorna os dados ao objeto ResultSet.
	            registros = comando.executeQuery();
	            
	            if (registros.next()) { // Se for retornado pelo menos um registro.
	                registros.beforeFirst(); // Retorna o cursor para antes do 1� registro.
	                
	                // Recupera os cargos cadastrados no banco de dados para acessar a descri��o dos cargos.
		            departamentos = recuperaDepartamentos();
		            
	    	        while (registros.next()) {
	                    // Atribui os dados do funcion�rio ao objeto Funcionario por meio dos m�todos set e
	                    // adiciona este objeto ao ArrayList funcionarios.
	    	        	
	    	        	
	    	        	cargo = new Cargo();
	    	        	cargo.setId(registros.getInt("Id"));
	    	        	cargo.setDescricao(registros.getString("Descricao"));
	    	        	
	    	        	departamento = new Departamento();
	    	        	departamento.setId(registros.getInt("IdDepto"));
	    	        	for(Departamento d : departamentos)
	    	        		if(d.getId() == departamento.getId()) {
	    	        			departamento.setNomeDepto(d.getNomeDepto());
	    	        			break;
	    	        		}
	    	        	cargo.setDepartamento(departamento);
	    	        	cargos.add(cargo);
	    	        }
	    	    }
	            registros.close(); // Libera os recursos usados pelo objeto ResultSet.
	            comando.close(); // Libera os recursos usados pelo objeto PreparedStatement.
	            // Libera os recursos usados pelo objeto Connection e fecha a conex�o com o banco de dados.
	            ConnectionDatabase.getConexaoBd().close();
	        }
	    } catch (Exception e) {
	    	excecao = "Tipo de Exce��o: " + e.getClass().getSimpleName() + "\nMensagem: " + e.getMessage();
	    	cargos = null; // Caso ocorra qualquer exce��o.
	    }
	    return cargos; // Retorna o ArrayList de objetos Funcion�rio.
	}
	
	
	
	
	
	
	
	
	
	
	
	
}