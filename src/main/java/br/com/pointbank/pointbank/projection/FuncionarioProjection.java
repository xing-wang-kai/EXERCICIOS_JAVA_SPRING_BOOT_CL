package br.com.pointbank.pointbank.projection;

import java.time.LocalDate;

public interface FuncionarioProjection {
	public String getNome();
	public String getSalario();
	public LocalDate getDataContratacao();
}
