package br.com.pointbank.pointbank.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.pointbank.pointbank.orm.Funcionario;
import br.com.pointbank.pointbank.projection.FuncionarioProjection;
import br.com.pointbank.pointbank.repository.FuncionarioRepository;
import br.com.pointbank.pointbank.specification.FuncionarioSpecification;

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
			System.out.println("|--------| [ 3 ] - DATA CONTRATACAO MAIOR QUE        |--------|");
			System.out.println("|--------| [ 4 ] - RELATORIO SIMPLIFICADO            |--------|");
			System.out.println("|--------| [ 5 ] - BUSCAR POR CRITERIOS              |--------|");
			System.out.println("|-------------------------------------------------------------|");
			System.out.println("");

			int opcao = scanner.nextInt();
			switch (opcao) {
			case 1:
				this.buscarFuncionarioPorNome(scanner);
				break;
			case 2:
				this.buscarFuncionarioPorNomeSalarioMaiorQueDataContratacao(scanner);
				break;
			case 3:
				this.buscarFuncionarioDataContratacaoMaiorQuer(scanner);
				break;
			case 4:
				this.findRelatorioSimplificado();
				break;
			case 5: 
				this.findPorNomeSugerido(scanner);
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
		System.out.println("");

		String nome = scanner.next();
		try {
			List<Funcionario> funcionarios = fr.findByNome(nome);
			funcionarios.stream().forEach(f -> System.out.println("|---| FUNCIONARIO: " + f + " |----|"));
			
			System.out.println("|--------------------------------------------|");
			System.out.println("|--------------|      FIM    |---------------|");
			System.out.println("|-------------FEITO COM ♥ POR KAI WANG-------|");
			System.out.println("");
		} catch (Exception err) {
			System.out.println("|---| ERRO STACK TRACE:  " + err.getStackTrace() + " |---|");
			System.out.println("|---| ERRO SUPPRESSED:   " + err.getSuppressed() + " |---|");
			System.out.println("|---| ERRO MESSAGE:      " + err.getMessage() + " |---|");
			System.out.println("|---| ERRO CAUSA:        " + err.getCause() + " |---|");
			System.out.println("|---| ERRO CLASS:        " + err.getClass() + " |---|");
			System.out.println("|---| ERRO LOCALIZED MESSAGE: " + err.getLocalizedMessage() + " |---|");
		}
	}

	public void buscarFuncionarioPorNomeSalarioMaiorQueDataContratacao(Scanner scanner) {
		System.out.println("|--------------------------------------------|");
		System.out.println("|--------| DIGITE O NOME DO         |--------|");
		System.out.println("|--------| FUNCIONARIO              |--------|");
		System.out.println("|--------------------------------------------|");
		System.out.println("");

		String nome = scanner.next();

		System.out.println("|--------------------------------------------|");
		System.out.println("|--------| DIGITE A BASE SALARIO    |--------|");
		System.out.println("|--------| DO FUNCIONARIO           |--------|");
		System.out.println("|--------------------------------------------|");
		System.out.println("");

		double salario = scanner.nextDouble();

		System.out.println("|--------------------------------------------|");
		System.out.println("|--------| DIGITE DATA CONTRACTACAO |--------|");
		System.out.println("|--------| DO FUNCIONARIO           |--------|");
		System.out.println("|--------------------------------------------|");
		System.out.println("");

		String data = scanner.next();
		LocalDate dataContratacao = LocalDate.parse(data, formatter);

		List<Funcionario> funcionario = this.fr.findNomeSalarioMaiorDataContratacao(nome, salario, dataContratacao);
		funcionario.stream().forEach(System.out::print);

	}

	private void buscarFuncionarioDataContratacaoMaiorQuer(Scanner scanner) {
		System.out.println("|--------------------------------------------|");
		System.out.println("|--------| DIGITE DATA CONTRACTACAO |--------|");
		System.out.println("|--------| DO FUNCIONARIO           |--------|");
		System.out.println("|--------------------------------------------|");
		System.out.println("");
		
		String data = scanner.next();
		LocalDate dataContratacao = LocalDate.parse(data, formatter);

		List<Funcionario> funcionario = this.fr.findDataContratacaoMaior(dataContratacao);
		funcionario.stream().forEach(System.out::print);
		
		System.out.println("|--------------------------------------------|");
		System.out.println("|--------------|      FIM    |---------------|");
		System.out.println("|-------------FEITO COM ♥ POR KAI WANG-------|");
		System.out.println("");
	}

	private void findRelatorioSimplificado() {
		System.out.println("|--------------------------------------------|");
		System.out.println("|--------|     FUNCIONARIO          |--------|");
		System.out.println("|--------| RELATORIO SIMPLIFICADO   |--------|");
		System.out.println("|--------------------------------------------|");
		System.out.println("");
		
		List<FuncionarioProjection> funcionarios = this.fr.findRelatorioSimplificado();
		funcionarios.stream().forEach(f->
				System.out.println("|----| FUNCIONARIO, "
									+ "NOME: " + f.getNome() 
									+ ", SALARIO: " + f.getSalario() 
									+ ", DATA CONTRATACAO: " + f.getDataContratacao() + " |----|")
				);
		System.out.println("|--------------------------------------------|");
		System.out.println("|--------------|      FIM    |---------------|");
		System.out.println("|-------------FEITO COM ♥ POR KAI WANG-------|");
		System.out.println("");
	}
	
	private void findPorNomeSugerido(Scanner scanner)
	{
		System.out.println("|--------------------------------------------|");
		System.out.println("|--------| DIGITE O NOME DO         |--------|");
		System.out.println("|--------| FUNCIONARIO              |--------|");
		System.out.println("|--------| DIGITE 'NULL' PARA       |--------|");
		System.out.println("|--------| NAO BUSCAR PELO NOME     |--------|");
		System.out.println("|--------------------------------------------|");
		System.out.println("");

		String nome = scanner.next();
		if(nome.equalsIgnoreCase("NULL"))
		{
			nome = null;
		}
		
		System.out.println("|--------------------------------------------|");
		System.out.println("|--------| DIGITE O SALARIO DO      |--------|");
		System.out.println("|--------| FUNCIONARIO              |--------|");
		System.out.println("|--------| DIGITE '0' PARA          |--------|");
		System.out.println("|--------| NAO BUSCAR PELO SALARIO  |--------|");
		System.out.println("|--------------------------------------------|");
		System.out.println("");

		Double salario = scanner.nextDouble();
		if(salario==0)
		{
			salario = (Double) null;
		}
		
		System.out.println("|--------------------------------------------|");
		System.out.println("|--------| DIGITE O CPF DO          |--------|");
		System.out.println("|--------| FUNCIONARIO              |--------|");
		System.out.println("|--------| DIGITE 'NULL' PARA       |--------|");
		System.out.println("|--------| NAO BUSCAR PELO CPF      |--------|");
		System.out.println("|--------------------------------------------|");
		System.out.println("");

		String cpf = scanner.next();
		if(cpf.equalsIgnoreCase("NULL"))
		{
			cpf = null;
		}
		
		System.out.println("|--------------------------------------------|");
		System.out.println("|--------| DIGITE O DATA CONTRATACAO|--------|");
		System.out.println("|--------| FUNCIONARIO              |--------|");
		System.out.println("|--------| DIGITE 'NULL' PARA       |--------|");
		System.out.println("|--------| NAO BUSCAR PELO DC       |--------|");
		System.out.println("|--------------------------------------------|");
		System.out.println("");

		String data = scanner.next();
		LocalDate dataContratacao = null;
		if(data.equalsIgnoreCase("NULL"))
		{
			data = null;
		}
		else {
			dataContratacao = LocalDate.parse(data, formatter);
		}
		
		
		
		try 
		{
			List<Funcionario> funcionarios = this.fr.findAll(Specification.where(
															FuncionarioSpecification.nome(nome)
															.or(FuncionarioSpecification.cpf(cpf))
															.or(FuncionarioSpecification.salario(salario))
															.or(FuncionarioSpecification.dataContratacao(dataContratacao))
															)
					);
			funcionarios.stream().forEach(System.out::println);
			
			System.out.println("|--------------------------------------------|");
			System.out.println("|--------------|      FIM    |---------------|");
			System.out.println("|-------------FEITO COM ♥ POR KAI WANG-------|");
			System.out.println("");
			
		}catch (Exception err) 
		{
			System.out.println("|---| ERRO STACK TRACE:  " + err.getStackTrace() + " |---|");
			System.out.println("|---| ERRO SUPPRESSED:   " + err.getSuppressed() + " |---|");
			System.out.println("|---| ERRO MESSAGE:      " + err.getMessage() + " |---|");
			System.out.println("|---| ERRO CAUSA:        " + err.getCause() + " |---|");
			System.out.println("|---| ERRO CLASS:        " + err.getClass() + " |---|");
			System.out.println("|---| ERRO LOCALIZED MESSAGE: " + err.getLocalizedMessage() + " |---|");
		}
	}

}
