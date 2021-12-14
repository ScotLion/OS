package com.alessandro.os.domain;


import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.alessandro.os.domain.enums.Prioridade;
import com.alessandro.os.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class OS {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataAbertura;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataFechamento;
	private Integer prioridade;
	private String observacoes;
	private Integer status;
	//muitos para 1
	@ManyToOne
	@JoinColumn(name = "tecnico_id")
	private Tecnico tecnico;      
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	public OS() {
		super();
		this.setDataAbertura(LocalDateTime.now()); 
		this.setPrioridade(Prioridade.BAIXA);
		this.setStatus(Status.Aberto);
		// TODO Auto-generated constructor stub
	}

	public OS(Integer id, Prioridade prioridade,
			String observacoes, Status status, Tecnico tecnico, Cliente cliente) {
		super();
		this.id = id;
		this.setDataAbertura(LocalDateTime.now()); 
		//this.dataFechamento = dataFechamento;
		this.prioridade = (prioridade == null) ? 0 : prioridade.getCodPrioridade(); 
		this.observacoes = observacoes;
		this.status = (status == null) ? 0 : status.getcodStatus();
		this.tecnico = tecnico; 
		this.cliente = cliente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(LocalDateTime dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public LocalDateTime getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(LocalDateTime dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public Prioridade getPrioridade() {
		return Prioridade.toEnum(this.prioridade);
	}

	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade.getCodPrioridade();
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Status getStatus() {
		return Status.toEnum(this.status);
	}

	public void setStatus(Status status) {
		this.status = status.getcodStatus();
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OS other = (OS) obj;
		return Objects.equals(id, other.id);
	}

}
