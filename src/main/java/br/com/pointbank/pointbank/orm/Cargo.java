package br.com.pointbank.pointbank.orm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cargos")
public class Cargo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id;
	private String descricao;
	
	public Cargo() {}
	
	public Integer getId()
	{
		return this.id;
	}
	public String getDescricao() 
	{
		return this.descricao;
	}
	public void setId(Integer value)
	{
		this.id = value;
	}
	public void setDescricao(String value)
	{
		this.descricao = value;
	}
	@Override
	public String toString()
	{
		return String.format(
				"[ ID: %d, descricao: %s ]",
				this.getId(),
				this.getDescricao());
				
	}
}
