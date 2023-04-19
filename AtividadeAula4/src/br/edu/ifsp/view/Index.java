package br.edu.ifsp.view;

import java.util.Scanner;

import br.edu.ifsp.view.cargo.CargoCadastro;
import br.edu.ifsp.view.cargo.CargoConsulta;
import br.edu.ifsp.view.departamento.DepartamentoCadastro;
import br.edu.ifsp.view.departamento.DepartamentoConsulta;
import br.edu.ifsp.view.funcionario.FuncionarioCadastro;
import br.edu.ifsp.view.funcionario.FuncionarioConsulta;

public class Index {
	public static void main(String[] args) {
		int opcaoCadastro = 0, opcaoOperacao = 0;
		
		Scanner entrada = new Scanner(System.in);
		
		do 
		{
			System.out.println("\nOPERA��ES:");
			System.out.println("1) Cadastrar");
			System.out.println("2) Consultar");
			System.out.print("Digite uma op��o: ");
			 opcaoOperacao = Integer.parseInt(entrada.nextLine());
			 
			 
			 if(opcaoOperacao == 1) {
			 
			 System.out.println("CADASTROS:");
				System.out.println("1) Cadastro de Departamentos");
				System.out.println("2) Cadastro de Cargos");
				System.out.println("3) Cadastro de Funcion�rios");
				System.out.print("Digite uma op��o (0 para sair): ");
				
				opcaoCadastro = Integer.parseInt(entrada.nextLine());
				
			switch(opcaoCadastro) {
			
			case 1: 
				System.out.println("####################");
				DepartamentoCadastro.exibeInterface();
				break;
			
			case 2:
				System.out.println("####################");
				CargoCadastro.exibeInterface();
				break;
			
			case 3:
				System.out.println("####################");
			    FuncionarioCadastro.exibeInterface();
			  
		default:
			System.out.println("Digite uma opção valida!");
			}
				
			 }
		
	
			 if(opcaoOperacao == 2) {
				 System.out.println("CONSULTAS:");
				System.out.println("1) Consulta de Departamentos");
				System.out.println("2) Consulta de Cargos");
				System.out.println("3) Consulta de Funcion�rios");
				System.out.print("Digite uma op��o (0 para sair): ");
					
				int opcaoConsulta = Integer.parseInt(entrada.nextLine());
				
				
				switch(opcaoConsulta) {
				
				case 1:
					System.out.println("####################");
					DepartamentoConsulta.exibeInterface();
					break;
				case 2:
					System.out.println("####################");
					CargoConsulta.exibeInterface();
					break;
					
				case 3:
					System.out.println("####################");
					FuncionarioConsulta.exibeInterface();
					break;
				
				default:
					if(opcaoOperacao == 0) {
					System.out.println("Encerrando");
					}
				}
				
				 
			 }
			 
			 
		} while(opcaoOperacao != 0);
		
		entrada.close();
	}
}
		

