package br.com.pointbank.pointbank.specification;

import java.time.LocalDate;

import org.springframework.data.jpa.domain.Specification;

import br.com.pointbank.pointbank.orm.Funcionario;

public class FuncionarioSpecification {
	public static Specification<Funcionario> nome(String nome) {
		return (root, criteriaQuery, criteriaBuild) -> criteriaBuild.like(root.get("nome"), "%" + nome + "%");
	}

	public static Specification<Funcionario> cpf(String cpf) {
		return (root, criteriaQuery, criteriaBuild) -> criteriaBuild.equal(root.get("cpf"), cpf);
	}

	public static Specification<Funcionario> salario(Double salario) {
		return (root, criteriaQuery, criteriaBuild) -> criteriaBuild.greaterThan(root.get("salario"), salario);
	}

	public static Specification<Funcionario> dataContratacao(LocalDate dataContratacao) {
		return (root, criteriaQuery, criteriaBuild) -> criteriaBuild.greaterThan(root.get("dataContratacao"), dataContratacao);
	}
}
