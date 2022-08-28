package br.com.pointbank.pointbank.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.pointbank.pointbank.orm.Funcionario;
import br.com.pointbank.pointbank.projection.FuncionarioProjection;

@Repository
public interface FuncionarioRepository extends PagingAndSortingRepository<Funcionario, Integer>, JpaSpecificationExecutor<Funcionario> {

	public List<Funcionario> findByNome(String nome);
	
	@Query("SELECT f FROM Funcionario f WHERE f.nome = :nome AND f.salario >= :salario AND f.dataContratacao >= :dataContratacao ")
	public List<Funcionario> findNomeSalarioMaiorDataContratacao(	String nome,double salario,LocalDate dataContratacao );
	
	@Query(value = "SELECT * FROM funcionarios f WHERE f.data_contratacao >= :data",
			nativeQuery = true)
	public List<Funcionario> findDataContratacaoMaior(LocalDate data);
	
	@Query(value = "SELECT f.nome, f.data_contratacao, f.salario FROM funcionarios f",
			nativeQuery = true)
	public List<FuncionarioProjection> findRelatorioSimplificado();

}
