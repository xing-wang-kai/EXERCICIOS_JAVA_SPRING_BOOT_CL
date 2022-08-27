package br.com.pointbank.pointbank.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.pointbank.pointbank.orm.Cargo;
import br.com.pointbank.pointbank.repository.CargoRepository;

@Service
public class CargoService 
{
	
	private Boolean system = true;
	private final CargoRepository cr;
	
	public CargoService(CargoRepository cr) {
		this.cr = cr;
	}
	
	public void inicial(Scanner get)
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
			
			Integer opcao = get.nextInt();
			
			switch(opcao)
			{
			case 1:
				this.adicionar(get);
				break;
			case 2:
				this.alterar(get);
				break;
			case 3:
				this.remover(get);
			case 4:
				this.buscar();
				break;
			
			default:
				this.system = false;
				break;
			}
		
		}
	}
	public void adicionar(Scanner get)
	{
		System.out.println("|--------------------------------------------|");
		System.out.println("|-----|  INSIRA A DESCRICAO  |---------------|");
		System.out.println("|--------------------------------------------|");
			String descricao = get.next();
			Cargo cargo = new Cargo();
			cargo.setDescricao(descricao);
			cr.save(cargo);
		System.out.println("|--------------------------------------------|");
		System.out.println("|------| CARGO SALVO COM SUCESSO |-----------|");
		System.out.println("|--------------------------------------------|");
	}
	
	public void alterar(Scanner scanner)
	{
		System.out.println("|--------------------------------------------|");
		System.out.println("|-----|  INSIRA O ID PARA ALTERAR  |---------|");
		System.out.println("|--------------------------------------------|");
		
			Integer id = scanner.nextInt();
		
		System.out.println("|--------------------------------------------|");
		System.out.println("|-----|  INSIRA A NOVA DESCRICAO  |----------|");
		System.out.println("|--------------------------------------------|");
		
			String descricao = scanner.next();
			
			Cargo cargo = new Cargo();
			cargo.setId(id);
			cargo.setDescricao(descricao);
			cr.save(cargo);
		
		System.out.println("|--------------------------------------------|");
		System.out.println("|---| CARGO ALTERADO COM SUCESSO |-----------|");
		System.out.println("|--------------------------------------------|");
		
	}
	
	public void remover(Scanner scanner)
	{
		System.out.println("|--------------------------------------------|");
		System.out.println("|-----|  INSIRA O ID PARA REMOVER  |---------|");
		System.out.println("|--------------------------------------------|");
		
			Integer id = scanner.nextInt();
			cr.deleteById(id);
		
		System.out.println("|--------------------------------------------|");
		System.out.println("|---| CARGO ALTERADO COM REMOVIDO |----------|");
		System.out.println("|--------------------------------------------|");
	}
	
	public void buscar()
	{
		System.out.println("|--------------------------------------------|");
		System.out.println("|--------|   CARGOS   |----------------------|");
		System.out.println("|--------------------------------------------|");
			List<Cargo> cargos = (List<Cargo>) cr.findAll();
			
			cargos.stream().forEach(c-> System.out.println("|-----|    CARGO: " + c + "|-----|"));
			
		System.out.println("|--------------------------------------------|");
		System.out.println("|------|   FIM   |---------------------------|");
		System.out.println("|--------------------------------------------|");
	}
}
