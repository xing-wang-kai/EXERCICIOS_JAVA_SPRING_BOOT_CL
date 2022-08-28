package br.com.pointbank.pointbank.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.pointbank.pointbank.orm.UnidadeTrabalho;
import br.com.pointbank.pointbank.repository.UnidadeTrabalhoRepository;

@Service
public class UnidadeTrabalhoService {

	private Boolean system = true;
	private final UnidadeTrabalhoRepository utr;

	public UnidadeTrabalhoService(UnidadeTrabalhoRepository utr) {
		this.utr = utr;
	}

	public void inicial(Scanner scanner) {
		while (system) {
			System.out.println("|--------------------------------------------|");
			System.out.println("|--------| [ 0 ] - SAIR             |--------|");
			System.out.println("|--------| [ 1 ] - ADICIONAR        |--------|");
			System.out.println("|--------| [ 2 ] - ALTERAR          |--------|");
			System.out.println("|--------| [ 3 ] - REMOVER          |--------|");
			System.out.println("|--------| [ 4 ] - BUSCAR           |--------|");
			System.out.println("|--------------------------------------------|");
			System.out.println("");

			Integer opcao = scanner.nextInt();

			switch (opcao) {
			case 1:
				this.adicionar(scanner);
				break;
			case 2:
				this.alterar(scanner);
				break;
			case 3:
				this.remover(scanner);
			case 4:
				this.buscar();
				break;

			default:
				this.system = false;
				break;
			}

		}

	}

	public void adicionar(Scanner scanner) {
		System.out.println("|--------------------------------------------|");
		System.out.println("|-----|  INSIRA A DESCRICAO  |---------------|");
		System.out.println("|--------------------------------------------|");
		System.out.println("");

		String descricao = scanner.next();

		System.out.println("|--------------------------------------------|");
		System.out.println("|-----|  INSIRA A ENDERCO  |-----------------|");
		System.out.println("|--------------------------------------------|");
		System.out.println("");

		String endereco = scanner.next();

		UnidadeTrabalho ut = new UnidadeTrabalho();
		ut.setDescricao(descricao);
		ut.setEndereco(endereco);

		utr.save(ut);

		System.out.println("|--------------------------------------------|");
		System.out.println("|--| UNIDADE DE TRABALHO SALVO COM SUCESSO |-|");
		System.out.println("|--------------------------------------------|");
		System.out.println("");

		System.out.println("|--------------------------------------------|");
		System.out.println("|--------------|      FIM    |---------------|");
		System.out.println("|-------------FEITO COM ♥ POR KAI WANG-------|");
		System.out.println("");
	}

	public void alterar(Scanner scanner) {
		System.out.println("|--------------------------------------------|");
		System.out.println("|-----|  INSIRA O ID PARA ALTERAR  |---------|");
		System.out.println("|--------------------------------------------|");
		System.out.println("");

		Integer id = scanner.nextInt();

		System.out.println("|--------------------------------------------|");
		System.out.println("|-----|  INSIRA A NOVA DESCRICAO  |----------|");
		System.out.println("|--------------------------------------------|");
		System.out.println("");

		String descricao = scanner.next();

		System.out.println("|--------------------------------------------|");
		System.out.println("|-----|  INSIRA O NOVO ENDERECO   |----------|");
		System.out.println("|--------------------------------------------|");
		System.out.println("");

		String endereco = scanner.next();

		UnidadeTrabalho ut = new UnidadeTrabalho();
		ut.setId(id);
		ut.setDescricao(descricao);
		ut.setEndereco(endereco);

		utr.save(ut);

		System.out.println("|--------------------------------------------|");
		System.out.println("|-| UNIDADE TRABALHO ALTERADO COM SUCESSO |--|");
		System.out.println("|--------------------------------------------|");
		System.out.println("");

		System.out.println("|--------------------------------------------|");
		System.out.println("|--------------|      FIM    |---------------|");
		System.out.println("|-------------FEITO COM ♥ POR KAI WANG-------|");
		System.out.println("");
	}

	public void remover(Scanner scanner) {
		System.out.println("|--------------------------------------------|");
		System.out.println("|-----|  INSIRA O ID PARA REMOVER  |---------|");
		System.out.println("|--------------------------------------------|");
		System.out.println("");

		Integer id = scanner.nextInt();
		utr.deleteById(id);

		System.out.println("|--------------------------------------------|");
		System.out.println("|---| UNIDADE TRABALHO REMOVIDA   |----------|");
		System.out.println("|--------------------------------------------|");
		System.out.println("");

		System.out.println("|--------------------------------------------|");
		System.out.println("|--------------|      FIM    |---------------|");
		System.out.println("|-------------FEITO COM ♥ POR KAI WANG-------|");
		System.out.println("");
	}

	public void buscar() {
		System.out.println("|--------------------------------------------|");
		System.out.println("|--------|   UNIDADE TRABALHO  |-------------|");
		System.out.println("|--------------------------------------------|");
		System.out.println("");
		List<UnidadeTrabalho> uts = (List<UnidadeTrabalho>) utr.findAll();

		uts.stream().forEach(ut -> System.out.println("| -----|    UT: " + ut + "    |-----|"));

		System.out.println("|--------------------------------------------|");
		System.out.println("|--------------|      FIM    |---------------|");
		System.out.println("|-------------FEITO COM ♥ POR KAI WANG-------|");
		System.out.println("");
	}

}
