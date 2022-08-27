package br.com.pointbank.pointbank.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.pointbank.pointbank.orm.Funcionario;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer> {

	public List<Funcionario> findByNome(String nome);
}
