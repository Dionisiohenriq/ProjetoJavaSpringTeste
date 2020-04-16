package com.example.database.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

/*
 * Criação da entidade Aluno para o banco h2
 * Foram utilizadas anotações JPA seguindo as diretivas de entidade-relacionamento
 */

@Entity
public class Grade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "objetivo", nullable = false)
	private String nome;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "aluno_id", referencedColumnName = "id")
	private Aluno aluno;

	@ManyToMany(mappedBy = "grades")
	private Set<Materia> materia = new HashSet<>();

	public Grade() {
		// TODO Auto-generated constructor stub
	}

	public Grade(String nome, Aluno aluno) {
		super();
		this.nome = nome;
		this.aluno = aluno;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Set<Materia> getMateria() {
		return materia;
	}

	public void setMateria(Set<Materia> materia) {
		this.materia = materia;
	}

}
