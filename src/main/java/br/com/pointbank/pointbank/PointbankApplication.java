package br.com.pointbank.pointbank;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.pointbank.pointbank.service.CargoService;
import br.com.pointbank.pointbank.service.FuncionarioRelatorioService;
import br.com.pointbank.pointbank.service.FuncionarioService;
import br.com.pointbank.pointbank.service.UnidadeTrabalhoService;

@SpringBootApplication
public class PointbankApplication implements CommandLineRunner{
	
	private Boolean system = true;
	private final CargoService cs;
	private final FuncionarioService fs;
	private final FuncionarioRelatorioService frs;
	private final UnidadeTrabalhoService uts;
	
	public PointbankApplication(
			CargoService cs,
			FuncionarioService fs,
			UnidadeTrabalhoService uts,
			FuncionarioRelatorioService frs
			)
	{
		this.cs = cs;
		this.fs = fs;
		this.uts = uts;
		this.frs = frs;
	}

	public static void main(String[] args) {
		SpringApplication.run(PointbankApplication.class, args);
	}
	@Override
	public void run(String... args)
	{
		Scanner scanner = new Scanner(System.in);
		while(system)
		{
			System.out.println("|--------------------------------------------|");
			System.out.println("|--------| [ 0 ] - SAIR             |--------|");
			System.out.println("|--------| [ 1 ] - CARGOS           |--------|");
			System.out.println("|--------| [ 2 ] - FUNCIONARIOS     |--------|");
			System.out.println("|--------| [ 3 ] - UNIDADE TRABALHO |--------|");
			System.out.println("|--------| [ 4 ] - RELATORIOS DE    |--------|");
			System.out.println("|--------|         FUNCIONARIOS     |--------|");
			System.out.println("|--------------------------------------------|");
			
			Integer opcao = scanner.nextInt();
			
			if(opcao == 1)
			{
				this.cs.inicial(scanner);
			}
			else if (opcao == 2)
			{
				this.fs.inicial(scanner);
			}
			else if(opcao == 3)
			{
				this.uts.inicial(scanner);
			}
			else if(opcao == 4)
			{
				this.frs.inicial(scanner);
			}
			else
			{
				system = false;
			}
			
		}
	}

}
