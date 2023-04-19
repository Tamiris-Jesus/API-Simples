package br.edu.ifsp.view.departamento;

import java.util.List;

import br.edu.ifsp.controller.DepartamentoController;
import br.edu.ifsp.controller.FuncionarioController;
import br.edu.ifsp.model.departamento.Departamento;
import br.edu.ifsp.model.funcionario.Funcionario;

public class DepartamentoConsulta {
	
	public static void exibeInterface() {
		String excecaoDepartamentos = null;
		String excecaoCargos = null;
		String planoSaude;
		
		List<Departamento> departamentos = new DepartamentoController().consultaDepartamentos();
		excecaoDepartamentos = new DepartamentoController().getExcecao();
		String formato = "%-6s %-30s %-20s\n";
		
		if (excecaoDepartamentos != null) // Caso ocorra qualquer tipo de exce��o.
			System.out.println("N�o foi poss�vel recuperar os dados dos departamentos:\n" + excecaoDepartamentos);
		else {
			System.out.println("\nCONSULTA DE DEPARTAMENTOS:");
			System.out.printf(formato, "C�DIGO", " | NOME DO DEPARTAMENTO", " | GERENTE");
			
			for (Departamento d : departamentos) {
				
				
				System.out.printf(formato, d.getId(), 
						           " | " + d.getNomeDepto(),
						           " | " + d.getGerente().getNome());
			}
			System.out.println();
		}
	}

}
