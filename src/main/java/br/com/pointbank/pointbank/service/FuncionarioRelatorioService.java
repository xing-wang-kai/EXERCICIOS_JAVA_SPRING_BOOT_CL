package br.com.pointbank.pointbank.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.pointbank.pointbank.orm.Funcionario;
import br.com.pointbank.pointbank.repository.FuncionarioRepository;

@Service
public class FuncionarioRelatorioService {
public Boolean system = true;
	
	public final FuncionarioRepository fr;
	
	public FuncionarioRelatorioService( FuncionarioRepository fr)
	{
		this.fr = fr;
	}
	
	public void inicial(Scanner scanner)
	{
		while(system)
		{
			System.out.println("|--------------------------------------------|");
			System.out.println("|--------| [ 0 ] - SAIR             |--------|");
			System.out.println("|--------| [ 1 ] - BUCAR POR MOME   |--------|");
			System.out.println("|--------------------------------------------|");
			
			int opcao = scanner.nextInt();
			switch(opcao)
			{
			case 1:
				break;
			default:
				system = false;
				break;
			}
		}
	}
	public void buscarFuncionarioPorNome(Scanner scanner)
	{
		System.out.println("|--------------------------------------------|");
		System.out.println("|--------| DIGITE O NOME DO         |--------|");
		System.out.println("|--------| FUNCIONARIO              |--------|");
		System.out.println("|--------------------------------------------|");
		
		try 
		{
			String nome = scanner.next();
			
			List<Funcionario> funcionarios = fr.findByNome(nome);
			funcionarios.stream().forEach(f -> 
			System.out.println(String.format("|---| FUNCIONARIO: %20.0s  |----|", f)));
		}catch(Exception err)
		{
			System.out.println(String.format("|---| ERRO MESSAGE: %10.0s |---|", err.getMessage()));
			System.out.println("|---| ERRO STACK TRACE: " + err.getStackTrace() + " |---|");
			System.out.println("|---| ERRO SUPPRESSED: " + err.getSuppressed() + " |---|");
			System.out.println(String.format("|---| ERRO CAUSE: %10.0s |---|", err.getCause()));
			System.out.println(String.format("|---| ERRO CLASS: %10.0s |---|", err.getClass()));
			System.out.println(String.format("|---| ERRO LOCALIZES MESSAGE: %10.0s |---|", err.getLocalizedMessage()));
		}
		
		
	}
}
