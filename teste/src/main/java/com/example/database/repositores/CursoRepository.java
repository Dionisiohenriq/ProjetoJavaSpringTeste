package com.example.database.repositores;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.database.entities.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {

	List<Curso> findByNome(String nome);

	List<Curso> findCursoByNomeContaining(String nome);

	List<Curso> findCursoByNomeLike(String nome);

	List<Curso> findCursoByNomeLikeIgnoreCase(String nome);

	@Query(value = "Select c from Curso c")
	List<Curso> findByQueryNome();

	@Query(value = "Select nome_Do_Curso from curso_faculdade where area = 'Computação'", nativeQuery = true)
	List<String> findByQueryNomePorArea();

	@Query(value = "Select nome_Do_Curso from curso_faculdade where area = :area", nativeQuery = true)
	List<String> findByQueryNomePorAreaInformada(@Param("area") String area);

	@Query(value = "Select nome_Do_Curso from curso_faculdade where area = :area and nome_Do_Curso = :nome", nativeQuery = true)
	List<String> findByQueryNomePorAreaInformada(@Param("area") String area, @Param("nome") String nome);

	@Query(value = "Select nome_Do_Curso from curso_faculdade where area = ?1 and nome_Do_Curso = ?2", nativeQuery = true)
	List<String> findByQueryNomePorAreaParametros(String area, String nome);

}
