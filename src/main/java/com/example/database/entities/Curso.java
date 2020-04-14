package com.example.database.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "curso_faculdade")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nome_Do_Curso", nullable = false)
	private String nome;

	@Column(nullable = false)
	private String area;

	@CreationTimestamp
	@Column(name = "data_de_criação")
	private LocalDateTime dataDeCriação;

	@UpdateTimestamp
	@Column(name = "data_de_atualização")
	private LocalDateTime dataDeAtualização;

	@NotNull(message = "O nome do usuário não pode ser nulo")
	@NotBlank(message = "O nome do usuário não pode estar em branco")
	private String usuario;

	@Transient
	private BigDecimal valorDoCurso;

	@OneToMany(mappedBy = "curso")
	private List<Aluno> alunos = new ArrayList<>();

	@PostPersist
	private void aposPersistirDados() {
		this.nome = this.nome + " POST";
	}

	@PrePersist
	private void antesDePersistirDados() {
		this.usuario = "Admin";
	}

	public Curso(String nome, String area) {
		super();
		this.nome = nome;
		this.area = area;
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

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public LocalDateTime getDataDeCriação() {
		return dataDeCriação;
	}

	public void setDataDeCriação(LocalDateTime dataDeCriação) {
		this.dataDeCriação = dataDeCriação;
	}

	public LocalDateTime getDataDeAtualização() {
		return dataDeAtualização;
	}

	public void setDataDeAtualização(LocalDateTime dataDeAtualização) {
		this.dataDeAtualização = dataDeAtualização;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public BigDecimal getValorDoCurso() {
		return valorDoCurso;
	}

	public void setValorDoCurso(BigDecimal valorDoCurso) {
		this.valorDoCurso = valorDoCurso;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nome=" + nome + ", area=" + area + "]";
	}

	public Curso() {
		// TODO Auto-generated constructor stub
	}

}
