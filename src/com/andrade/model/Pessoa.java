package com.andrade.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@XmlRootElement
@Entity
@Table(name="pessoa")
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idPessoa;
	@Column(length=50)
	private String nomePessoa;
	@Column
	@Temporal(TemporalType.DATE)
	@JsonFormat(timezone="Brazil/East", pattern="yyyy-MM-dd")
	private Date dtNascimento;
    @Column(length=60, unique=true)
    private String email;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="pessoa", fetch=FetchType.EAGER)
    @JsonManagedReference
    private List<Telefone> telefones;

	public Pessoa() {
	}

	public Pessoa(Integer idPessoa, String nomePessoa, Date dtNascimento, String email) {
		this.idPessoa = idPessoa;
		this.nomePessoa = nomePessoa;
		this.dtNascimento = dtNascimento;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Pessoa [idPessoa=" + idPessoa + ", nomePessoa=" + nomePessoa + ", dtNascimento=" + dtNascimento
				+ ", email=" + email + "]";
	}

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
    
	public void addTelefone(Telefone ...t) {
		if(telefones==null) {
			telefones = new ArrayList<>();
		}
		for(Telefone item : t) {
			telefones.add(item);
		}
	}


}
