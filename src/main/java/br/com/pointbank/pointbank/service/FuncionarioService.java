package br.com.pointbank.pointbank.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.pointbank.pointbank.orm.Cargo;
import br.com.pointbank.pointbank.orm.Funcionario;
import br.com.pointbank.pointbank.orm.UnidadeTrabalho;
import br.com.pointbank.pointbank.repository.CargoRepository;
import br.com.pointbank.pointbank.repository.FuncionarioRepository;
import br.com.pointbank.pointbank.repository.UnidadeTrabalhoRepository;

@Service
public class FuncionarioService 
{
	
	private Boolean system = true;
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private final FuncionarioRepository fr;
	private final CargoRepository cr;
	private final UnidadeTrabalhoRepository utr;
	
	public FuncionarioService(
			FuncionarioRepository fr,
			CargoRepository cr,
			UnidadeTrabalhoRepository utr
			)
	{
		this.fr = fr;
		this.cr = cr;
		this.utr = utr;
	}
	public void inicial(Scanner scanner)
	{
		while(system)
		{
			System.out.println("|--------------------------------------------|");
			System.out.println("|--------| [ 0 ] - SAIR             |--------|");
			System.out.println("|--------| [ 1 ] - ADICIONAR        |--------|");
			System.out.println("|--------| [ 2 ] - ALTERAR          |--------|");
			System.out.println("|--------| [ 3 ] - REMOVER          |--------|");
			System.out.println("|--------| [ 4 ] - BUSCAR           |--------|");
			System.out.println("|--------------------------------------------|");
			
			Integer opcao = scanner.nextInt();
			
			switch(opcao)
			{
			case 1:
				this.adicionar(scanner);
				break;
			case 2:
				this.alterar(scanner);
				break;
			case 3:
				this.remover(scanner);
				break;
			case 4:
				this.buscar();
				break;
			default:
				this.system = false;
				break;
			}
		
		}
			
	}
	public void adicionar(Scanner scanner)
	{
		System.out.println("|--------------------------------------------|");
		System.out.println("|----|   INSIRA O NOME   |-------------------|");
		System.out.println("|--------------------------------------------|");
			String nome = scanner.next();
		System.out.println("|--------------------------------------------|");
		System.out.println("|----|    INSIRA O CPF    |------------------|");
		System.out.println("|--------------------------------------------|");
			String cpf = scanner.next();
		System.out.println("|--------------------------------------------|");
		System.out.println("|----|    INSIRA O SALARIO    |--------------|");
		System.out.println("|--------------------------------------------|");
			Double salario = scanner.nextDouble();
		System.out.println("|--------------------------------------------|");
		System.out.println("|----|    INSIRA O CARGO_ID    |-------------|");
		System.out.println("|--------------------------------------------|");
		
		try
		{
			Integer cargoId = scanner.nextInt();
			Optional<Cargo> cargo = cr.findById(cargoId);
			
		
			String concorda = "s";
			ArrayList<UnidadeTrabalho> listUt = new ArrayList<>();
			while(concorda.equals("s")) 
			{
				System.out.println("|--------------------------------------------|");
				System.out.println("|----|    INSIRA O UNIDADE_ID    |-----------|");
				System.out.println("|--------------------------------------------|");
				
				Integer unidadeId = scanner.nextInt();
				Optional<UnidadeTrabalho> ut = utr.findById(unidadeId);
				ut.stream().forEach(u->listUt.add(u));
				
				System.out.println("|--------------------------------------------|");
				System.out.println("|-|  INSERIR MAIS UNIDADES? [ s / n ] |------|");
				System.out.println("|--------------------------------------------|");
				
				concorda = scanner.next();
			}
			
				System.out.println("|--------------------------------------------|");
				System.out.println("|--|    INSIRA DATA CONTRATACAO    |---------|");
				System.out.println("|--------------------------------------------|");
			
				String data = scanner.next();
				LocalDate dataContratacao = LocalDate.parse(data, formatter);
				
				try 
				{
					Funcionario funcionario = new Funcionario();
					
					funcionario.setNome(nome);
					funcionario.setCpf(cpf);
					funcionario.setSalario(salario);
					cargo.stream().forEach(c -> funcionario.setCargo(c));
					funcionario.setDataContratacao(dataContratacao);
					funcionario.setUnidadeTrabalho((List<UnidadeTrabalho>) listUt);
					fr.save(funcionario);
				}
				catch(Exception e)
				{
					System.out.println("|--------------------------------------------|");
					System.out.println("|-------|           ERROR          |---------|");
					System.out.println("|-------| " + e.getMessage());
					System.out.println("|--------------------------------------------|");
				}
		}
		catch(Exception err)
		{
			System.out.println("|---| ERRO STACK TRACE:  " + err.getStackTrace() + " |---|");
			System.out.println("|---| ERRO SUPPRESSED:   " + err.getSuppressed() + " |---|");
			System.out.println("|---| ERRO MESSAGE:      " + err.getMessage() + " |---|");
			System.out.println("|---| ERRO CAUSA:        " + err.getCause() + " |---|");
			System.out.println("|---| ERRO CLASS:        " + err.getClass() + " |---|");
			System.out.println("|---| ERRO LOCALIZED MESSAGE: " + err.getLocalizedMessage() + " |---|");
		}
		
			
			
		System.out.println("|--------------------------------------------|");
		System.out.println("|--|     FUNCIONARIO SALVO COM SUCESSO    |--|");
		System.out.println("|--------------------------------------------|");
	}
	public void alterar(Scanner scanner)
	{
		System.out.println("|--------------------------------------------|");
		System.out.println("|-----|  INSIRA O ID PARA ALTERAR  |---------|");
		System.out.println("|--------------------------------------------|");
		
		Integer id = scanner.nextInt();
		
		System.out.println("|--------------------------------------------|");
		System.out.println("|----|   INSIRA O NOME   |-------------------|");
		System.out.println("|--------------------------------------------|");
			String nome = scanner.next();
		System.out.println("|--------------------------------------------|");
		System.out.println("|----|    INSIRA O CPF    |------------------|");
		System.out.println("|--------------------------------------------|");
			String cpf = scanner.next();
		System.out.println("|--------------------------------------------|");
		System.out.println("|----|    INSIRA O SALARIO    |--------------|");
		System.out.println("|--------------------------------------------|");
			Double salario = scanner.nextDouble();
		System.out.println("|--------------------------------------------|");
		System.out.println("|----|    INSIRA O CARGO_ID    |-------------|");
		System.out.println("|--------------------------------------------|");
		
		
		try
		{
			Integer cargoId = scanner.nextInt();
			Optional<Cargo> cargo = cr.findById(cargoId);
			
		
		String concorda = "s";
		ArrayList<UnidadeTrabalho> listUt = new ArrayList<>();
		while(concorda.equals("s")) 
		{
			System.out.println("|--------------------------------------------|");
			System.out.println("|----|    INSIRA O UNIDADE_ID    |-----------|");
			System.out.println("|--------------------------------------------|");
			
			Integer unidadeId = scanner.nextInt();
			Optional<UnidadeTrabalho> ut = utr.findById(unidadeId);
			ut.stream().forEach(u->listUt.add(u));
			
			System.out.println("|--------------------------------------------|");
			System.out.println("|-|  INSERIR MAIS UNIDADES? [ s / n ] |------|");
			System.out.println("|--------------------------------------------|");
			
			concorda = scanner.next();
		}
		
		System.out.println("|--------------------------------------------|");
		System.out.println("|--|    INSIRA DATA CONTRATACAO    |---------|");
		System.out.println("|--------------------------------------------|");
		
			String data = scanner.next();
			LocalDate dataContratacao = LocalDate.parse(data, formatter);
			
			try 
			{
				Funcionario funcionario = new Funcionario();
				
				funcionario.setId(id);
				funcionario.setNome(nome);
				funcionario.setCpf(cpf);
				funcionario.setSalario(salario);
				cargo.stream().forEach(c -> funcionario.setCargo(c));
				funcionario.setDataContratacao(dataContratacao);
				funcionario.setUnidadeTrabalho((List<UnidadeTrabalho>) listUt);
				fr.save(funcionario);
			}
			catch(Exception e)
			{
				System.out.println("|--------------------------------------------|");
				System.out.println("|-------|           ERROR          |---------|");
				System.out.println("|-------| " + e.getMessage());
				System.out.println("|--------------------------------------------|");
			}
		}
		catch(Exception err)
		{
			System.out.println("|---| ERRO STACK TRACE:  " + err.getStackTrace() + " |---|");
			System.out.println("|---| ERRO SUPPRESSED:   " + err.getSuppressed() + " |---|");
			System.out.println("|---| ERRO MESSAGE:      " + err.getMessage() + " |---|");
			System.out.println("|---| ERRO CAUSA:        " + err.getCause() + " |---|");
			System.out.println("|---| ERRO CLASS:        " + err.getClass() + " |---|");
			System.out.println("|---| ERRO LOCALIZED MESSAGE: " + err.getLocalizedMessage() + " |---|");
		}
		System.out.println("|--------------------------------------------|");
		System.out.println("|--|     FUNCIONARIO ALTERADO COM SUCESSO    |--|");
		System.out.println("|--------------------------------------------|");
	}
	public void remover(Scanner scanner)
	{
		System.out.println("|--------------------------------------------|");
		System.out.println("|-----|  INSIRA O ID PARA REMOVER  |---------|");
		System.out.println("|--------------------------------------------|");
		
		try
		{

			Integer id = scanner.nextInt();
			fr.deleteById(id);
		}
		catch(Exception err)
		{
			System.out.println("|---| ERRO STACK TRACE:  " + err.getStackTrace() + " |---|");
			System.out.println("|---| ERRO SUPPRESSED:   " + err.getSuppressed() + " |---|");
			System.out.println("|---| ERRO MESSAGE:      " + err.getMessage() + " |---|");
			System.out.println("|---| ERRO CAUSA:        " + err.getCause() + " |---|");
			System.out.println("|---| ERRO CLASS:        " + err.getClass() + " |---|");
			System.out.println("|---| ERRO LOCALIZED MESSAGE: " + err.getLocalizedMessage() + " |---|");
		}
		
		System.out.println("|--------------------------------------------|");
		System.out.println("|---| FUNCIONARIO REMOVIDO        |----------|");
		System.out.println("|--------------------------------------------|");
	}
	public void buscar()
	{

		System.out.println("|--------------------------------------------|");
		System.out.println("|------------|   FUNCIONARIOS  |-------------|");
		System.out.println("|--------------------------------------------|");
			try
			{
				List<Funcionario> funcionarios = (List<Funcionario>) fr.findAll();
				
				funcionarios.stream().forEach(f-> System.out.println("| -----|    UT: " + f + "    |-----|"));
				
			}
			catch(Exception err)
			{
				System.out.println("|---| ERRO STACK TRACE:  " + err.getStackTrace() + " |---|");
				System.out.println("|---| ERRO SUPPRESSED:   " + err.getSuppressed() + " |---|");
				System.out.println("|---| ERRO MESSAGE:      " + err.getMessage() + " |---|");
				System.out.println("|---| ERRO CAUSA:        " + err.getCause() + " |---|");
				System.out.println("|---| ERRO CLASS:        " + err.getClass() + " |---|");
				System.out.println("|---| ERRO LOCALIZED MESSAGE: " + err.getLocalizedMessage() + " |---|");
				
			}
			
		System.out.println("|--------------------------------------------|");
		System.out.println("|------|   FIM   |---------------------------|");
		System.out.println("|--------------------------------------------|");
		
	}
}
