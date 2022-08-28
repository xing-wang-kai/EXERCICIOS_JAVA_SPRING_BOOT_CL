package br.com.pointbank.pointbank.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.pointbank.pointbank.orm.Funcionario;
import br.com.pointbank.pointbank.repository.FuncionarioRepository;

@Service
public class FuncionarioRelatorioService {
	public Boolean system = true;
	public DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public final FuncionarioRepository fr;

	public FuncionarioRelatorioService(FuncionarioRepository fr) {
		this.fr = fr;
	}

	public void inicial(Scanner scanner) {
		while (system) {
			System.out.println("|-------------------------------------------------------------|");
			System.out.println("|--------| [ 0 ] - SAIR                              |--------|");
			System.out.println("|--------| [ 1 ] - BUCAR POR MOME                    |--------|");
			System.out.println("|--------| [ 2 ] - BUCAR POR MOME SALARIO MAIOR QUE  |--------|");
			System.out.println("|--------|         E DATA CONTRATACAO                |--------|");
			System.out.println("|-------------------------------------------------------------|");

			int opcao = scanner.nextInt();
			switch (opcao) {
			case 1:
				this.buscarFuncionarioPorNome(scanner);
				break;
			case 2:
				break;
			default:
				system = false;
				break;
			}
		}
	}
	public void buscarFuncionarioPorNome(Scanner scanner) {
		System.out.println("|--------------------------------------------|");
		System.out.println("|--------| DIGITE O NOME DO         |--------|");
		System.out.println("|--------| FUNCIONARIO              |--------|");
		System.out.println("|--------------------------------------------|");
		
		String nome = scanner.next();
		try {
			List<Funcionario> funcionarios = fr.findByNome(nome);
			funcionarios.stream()
					.forEach(f -> System.out.println("|---| FUNCIONARIO: " + f + " |----|"));
		} catch (Exception err) {
			System.out.println("|---| ERRO STACK TRACE:  " + err.getStackTrace() + " |---|");
			System.out.println("|---| ERRO SUPPRESSED:   " + err.getSuppressed() + " |---|");
			System.out.println("|---| ERRO MESSAGE:      " + err.getMessage() + " |---|");
			System.out.println("|---| ERRO CAUSA:        " + err.getCause() + " |---|");
			System.out.println("|---| ERRO CLASS:        " + err.getClass() + " |---|");
			System.out.println("|---| ERRO LOCALIZED MESSAGE: " + err.getLocalizedMessage() + " |---|");
		}
	}
	public void buscarFuncionarioPorNomeSalarioMaiorQueDataContratacao(Scanner scanner)
	{
		System.out.println("|--------------------------------------------|");
		System.out.println("|--------| DIGITE O NOME DO         |--------|");
		System.out.println("|--------| FUNCIONARIO              |--------|");
		System.out.println("|--------------------------------------------|");
		
		String nome = scanner.next();
		
		System.out.println("|--------------------------------------------|");
		System.out.println("|--------| DIGITE A BASE SALARIO    |--------|");
		System.out.println("|--------| DO FUNCIONARIO           |--------|");
		System.out.println("|--------------------------------------------|");
		
		double salario = scanner.nextDouble();
		
		System.out.println("|--------------------------------------------|");
		System.out.println("|--------| DIGITE DATA CONTRACTACAO |--------|");
		System.out.println("|--------| DO FUNCIONARIO           |--------|");
		System.out.println("|--------------------------------------------|");
		
		String data = scanner.next();
		LocalDate dataContratacao = LocalDate.parse(data, formatter);
		
		List<Funcionario> funcionario = this.fr.findNomeSalarioMaiorDataContratacao(nome, salario, dataContratacao);
		funcionario.stream().forEach(System.out::print);
		
	}
}
