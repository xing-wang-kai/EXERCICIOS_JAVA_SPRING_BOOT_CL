package br.com.pointbank.pointbank.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.pointbank.pointbank.orm.Funcionario;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer> {

	public List<Funcionario> findByNome(String nome);
	
	@Query("SELECT f FROM funcionario f "
							+ "WHERE f.nome = :nome "
							+ "AND f.salario >= :salario "
							+ "AND f.dataContratacao = :dataContratacao ")
	public List<Funcionario> findNomeSalarioMaiorDataContratacao(	String nome, 
																	double salario, 
																	LocalDate dataContratacao 
																);
}
