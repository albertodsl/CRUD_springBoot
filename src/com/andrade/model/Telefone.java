package com.andrade.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;

@XmlRootElement
@Entity
@Table(name="telefone")
public class Telefone implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idTelefone;
	@Column(length=15)
	private String telefone;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JsonBackReference
	private Pessoa pessoa;

	public Telefone() {
	}

	public Telefone(Integer idTelefone, String telefone, Pessoa pessoa) {
		this.idTelefone = idTelefone;
		this.telefone = telefone;
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "Telefone [idTelefone=" + idTelefone + ", telefone=" + telefone + "]";
	}

	public Integer getIdTelefone() {
		return idTelefone;
	}

	public void setIdTelefone(Integer idTelefone) {
		this.idTelefone = idTelefone;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
}
