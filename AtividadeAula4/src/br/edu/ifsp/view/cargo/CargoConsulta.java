package br.edu.ifsp.view.cargo;

import java.util.List;

import br.edu.ifsp.controller.CargoController;
import br.edu.ifsp.controller.FuncionarioController;
import br.edu.ifsp.model.cargo.Cargo;
import br.edu.ifsp.model.funcionario.Funcionario;

public class CargoConsulta {
	
	public static void exibeInterface() {
		String excecaoFuncionarios = null;
		String excecaoCargos = null;
		
		List<Cargo> cargos = new CargoController().consultaCargos();
		excecaoCargos = new CargoController().getExcecao();
	
		String formato = "%-6s %-30s %-20s\n";
		
		if (excecaoCargos != null) // Caso ocorra qualquer tipo de exce��o.
			System.out.println("N�o foi poss�vel recuperar os dados dos cargos:\n" + excecaoCargos);
		else {
			System.out.println("\nCONSULTA DE CARGOS:");
			System.out.printf(formato, "C�DIGO", " | DESCRICAO",  " | DEPARTAMENTO");
			
			for (Cargo c : cargos) {
				
				System.out.printf(formato, c.getId(), 
						           " | " + c.getDescricao(),
						           " | " + c.getDepartamento().getNomeDepto());
			}
			System.out.println();
		}
	}

}
