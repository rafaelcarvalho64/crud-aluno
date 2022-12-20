package com.example.demo;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Aluno {
	
	@Id
	@GeneratedValue
	private Long id;
    private String nome;
    private String curso;
    private Date dataNascimento;
    
	public Aluno() {
		super();
	}
	

	public Aluno(Long id, String nome, String curso, Date dataNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.curso = curso;
		this.dataNascimento = dataNascimento;
	}
	

	public Aluno(String nome, String curso, Date dataNascimento) {
		super();
		this.nome = nome;
		this.curso = curso;
		this.dataNascimento = dataNascimento;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso.toUpperCase();
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
