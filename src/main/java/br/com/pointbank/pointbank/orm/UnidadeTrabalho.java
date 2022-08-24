package br.com.pointbank.pointbank.orm;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="unidade_trabalho")
public class UnidadeTrabalho {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	private String endereco;
	@ManyToMany(mappedBy = "unidadeTrabalhos", fetch = FetchType.EAGER)
	private List<Funcionario> funcionarios;
	
	public void setId(Integer value)
	{
		this.id = value;
	}
	public void setDescricao(String value)
	{
		this.descricao = value;
	}
	public void setEndereco(String value)
	{
		this.endereco= value;
	}
	public void setFuncionarios(List<Funcionario> value)
	{
		this.funcionarios = value;
	}
	
	public Integer getId()
	{
		return this.id;
	}
	public String getDescricao()
	{
		return this.descricao;
	}
	public String getEndereco()
	{
		return this.endereco;
	}
	public List<Funcionario> getFuncionarios()
	{
		return this.funcionarios;
	}
	
	@Override
	public String toString()
	{
		return String.format(
				"[ ID: %d, DESCRICAO: %s, ENDERECO: %s, FUNCIONARIOS: %s]",
				this.getId(),
				this.getDescricao(),
				this.getEndereco(),
				this.getFuncionarios()
				);
	}
}
