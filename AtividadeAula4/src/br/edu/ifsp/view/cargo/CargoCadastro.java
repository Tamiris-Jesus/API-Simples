package br.edu.ifsp.view.cargo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.ifsp.controller.CargoController;
import br.edu.ifsp.model.departamento.Departamento;

public class CargoCadastro {
	static Scanner entrada = new Scanner(System.in);
	
	public static void exibeInterface() {
		String descricao;

		System.out.println("\nCADASTRO DE CARGO:");
		System.out.print("DESCRICAO: ");
		descricao = entrada.nextLine();
		
		List<String> erros = new ArrayList<String>();
		
		// Envia os dados do funcion�rio (informados no formul�rio) ao controller. 
		// O controller retorna ent�o um ArrayList contendo os erros encontrados.
		
		erros = new CargoController().insereCargo(descricao, leDepartamento());
		
		if (erros.get(0) == null) { // Se o primeiro elemento do ArrayList for null.
			System.out.println("Cargo cadastrado com sucesso.\n");
		} else { // Se o primeiro elemento do ArrayList n�o for null.
			String mensagem = "N�o foi poss�vel cadastrar o cargo:\n";
			for (String e : erros) // Cria uma mensagem contendo todos os erros armazenados no ArrayList.
				mensagem = mensagem + e + "\n";
			System.out.println(mensagem);
		}
	}
	
	public static Departamento leDepartamento() {
		int codDepto;
		Departamento departamento = new Departamento();
		
		List<Departamento> departamentos = new ArrayList<Departamento>();
		// Retorna um ArrayList de objetos Cargo, contendo o Id e a Descri��o dos cargos cadastrados.
		departamentos = new CargoController().recuperaDepartamentos();		
		String erro = new CargoController().getExcecao();
		if (erro != null) // Caso ocorra qualquer tipo de exce��o.
			System.out.println("N�o foi poss�vel recuperar os dados dos departamentos:\n" + erro);
		
		if (departamentos.size() != 0) { // Se existir pelo menos um cargo cadastrado.
			System.out.println("DEPARTAMENTOS CADASTRADOS: ");
			for (Departamento d : departamentos)
				System.out.println(d.getId() + " - " + d.getNomeDepto());
			
			System.out.print("CARGO (Digite o c�digo do cargo): ");
			codDepto = Integer.parseInt(entrada.nextLine());
			for (Departamento d : departamentos)
				if (d.getId() == codDepto)
					departamento = d;
		}
		return departamento;
	}
}

