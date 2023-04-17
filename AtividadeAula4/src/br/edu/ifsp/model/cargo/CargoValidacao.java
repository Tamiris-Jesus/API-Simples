package br.edu.ifsp.model.cargo;

import java.util.ArrayList;
import java.util.List;

public class CargoValidacao {
	private static List<String> errosValidacao; // List para armazenar as mensagens de erro de valida��o.
	
	// Valida os dados informados conforme as regras abaixo.
	public static List<String> validaCargo(Cargo cargo){
		errosValidacao = new ArrayList<>();
		
		// Valida��o do campo Nome.
		if (!cargo.getDescricao().equals("")) {
			if (cargo.getDescricao().length() < 5 || cargo.getDescricao().length() > 100)
				errosValidacao.add("* O Nome do cargo deve ter entre 5 e 100 caracteres.");
		} else {
			errosValidacao.add("* O Nome n�o foi informado.");
		}
		
		// Valida��o do campo Cargo (para o caso de n�o existirem cargos cadastrados).
		if (cargo.getDepartamento() == null)
			errosValidacao.add("* O departamento n�o foi informado.");
		
		return errosValidacao; // Retorna o ArrayList contendo as mensagens de erro de valida��o.
	}
}