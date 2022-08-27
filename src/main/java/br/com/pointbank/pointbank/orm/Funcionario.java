package br.com.pointbank.pointbank.orm;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
@Table(name="funcionarios")
public class Funcionario 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cpf;
	private Double salario;
	@ManyToOne
	@JoinColumn(name = "cargo_id", nullable = false)
	private Cargo cargo;
	private LocalDate dataContratacao;
	@Fetch(FetchMode.SELECT)
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "funcionarios_unidades", 
		joinColumns = {@JoinColumn(name = "fk_funcionario") }, 
	inverseJoinColumns = { @JoinColumn(name = "fk_unidade") })
	private List<UnidadeTrabalho> unidadeTrabalhos;
	
	public Funcionario () {}
	
	public Integer getId()
	{
		return this.id;
	}
	public String getNome()
	{
		return this.nome;
	}
	public String getCpf()
	{
		return this.cpf;
	}
	public Double getSalario()
	{
		return this.salario;
	}
	public Cargo getCargo()
	{
		return this.cargo;
	}
	public LocalDate getDataContratacao()
	{
		return this.dataContratacao;
	}
	public List<UnidadeTrabalho> getUnidadeTrabalho()
	{
		return this.unidadeTrabalhos;
	}
	 
	public void setUnidadeTrabalho(List<UnidadeTrabalho> value)
	{
		this.unidadeTrabalhos = value;
	}		
	public void setId(Integer value)

	{
		this.id = value;
	}
	public void setNome(String value)
	{
		this.nome = value;
	}
	public void setCpf(String value)
	{
		this.cpf = value;
	}
	public void setSalario(Double value)
	{
		this.salario = value;
	}
	public void setCargo(Cargo value)
	{
		this.cargo = value;
	}
	public void setDataContratacao(LocalDate value)
	{
		this.dataContratacao = value;
	}
	@Override
	public String toString()
	{	
		return String.format(
				"[ ID: %d NOME: %s CPF: %s, CARGO: %s, SALARIO: %d, UNIDADE-TRABALHO: %s ]", 
				this.getId(), 
				this.getNome(), 
				this.getCpf(), 
				this.getCargo(), 
				this.getSalario(),
				this.getUnidadeTrabalho());
	}
	
}
