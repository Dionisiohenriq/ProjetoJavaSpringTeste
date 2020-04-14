package com.example.database;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.database.entities.Aluno;
import com.example.database.entities.Curso;
import com.example.database.entities.Grade;
import com.example.database.entities.Materia;
import com.example.database.repositores.AlunoRepository;
import com.example.database.repositores.CursoRepository;
import com.example.database.repositores.GradeRepository;
import com.example.database.repositores.MateriaRepository;

@SpringBootApplication
public class TesteApplication implements CommandLineRunner {

	@Autowired
	private CursoRepository cursoRepository;

	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private GradeRepository gradeRepository;

	@Autowired
	private MateriaRepository materiaRepository;

	public static void main(String[] args) {
		SpringApplication.run(TesteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Curso curso1 = new Curso("Graduação em T.I.", "Computação");
		Curso curso2 = new Curso("Graduação em E.C.", "Computação");
		Curso curso3 = new Curso("Graduação em Química.", "Exatas");
		Curso curso4 = new Curso("Graduação em Biologia", "Natureza");

		cursoRepository.save(curso1);
		cursoRepository.save(curso2);
		cursoRepository.save(curso3);
		cursoRepository.save(curso4);

		Aluno aluno1 = new Aluno("José", curso1);
		Aluno aluno2 = new Aluno("ALine", curso4);
		Aluno aluno3 = new Aluno("Henrique", curso1);

		alunoRepository.save(aluno1);
		alunoRepository.save(aluno2);
		alunoRepository.save(aluno3);

		Grade grade1 = new Grade("Graduação em games", aluno1);
		Grade grade2 = new Grade("Graduação em ecosistemas", aluno2);
		Grade grade3 = new Grade("Graduação em Sistemas de Informação", aluno3);

		gradeRepository.save(grade1);
		gradeRepository.save(grade2);
		gradeRepository.save(grade3);

		Set<Grade> gradeMateria1 = new HashSet<>();
		gradeMateria1.add(grade1);
		Materia materia1 = new Materia("Lógica de programação", gradeMateria1);

		Set<Grade> gradeMateria2 = new HashSet<>();
		gradeMateria1.add(grade1);
		Materia materia2 = new Materia("Fisiologia", gradeMateria2);

		Set<Grade> gradeMateria3 = new HashSet<>();
		gradeMateria1.add(grade1);
		Materia materia3 = new Materia("Java", gradeMateria3);

		materiaRepository.save(materia1);
		materiaRepository.save(materia2);
		materiaRepository.save(materia3);
		// System.out.println("Aguarde...");
		// Thread.sleep(3000);

		// curso4.setNome("Graduação em Microbiologia");
		// cursoRepository.save(curso4);

		// curso2.setNome("Graduação em Bioquímica");
		// cursoRepository.save(curso2);

		/*
		 * List<Curso> listaDeCursos = cursoRepository.findAll();
		 * listaDeCursos.forEach(curso -> System.out.println(curso));
		 * 
		 * 
		 * Optional<Curso> cursoProcurado = cursoRepository.findById(3); Curso
		 * cursoFinal = cursoProcurado.orElse(null);
		 * 
		 * System.out.println("Curso escolhido: " + cursoFinal.getNome());
		 * 
		 * 
		 * List<Curso> cursoPorNome =
		 * cursoRepository.findByNome("Graduação em Bioquímica");
		 * cursoPorNome.forEach(curso -> System.out.println(curso));
		 * 
		 * List<Curso> cursoPorNomeContendo =
		 * cursoRepository.findCursoByContaining("Graduação");
		 * cursoPorNomeContendo.forEach(curso -> System.out.println(curso));
		 * 
		 * List<Curso> cursoPorNomeLike = cursoRepository.findCursoByNomeLike("%Grad%");
		 * cursoPorNomeLike.forEach(curso -> System.out.println(curso));
		 * 
		 * 
		 * List<Curso> cursoPorNomeLikeIgnoreCase =
		 * cursoRepository.findCursoByNomeLikeIgnoreCase("%Grad%");
		 * cursoPorNomeLikeIgnoreCase.forEach(curso -> System.out.println(curso));
		 */
		// List<Curso> cursoPorQueryNome = cursoRepository.findByQueryNome();
		// cursoPorQueryNome.forEach(curso -> System.out.println(curso));

		// List<String> cursoPorQueryNomePorArea =
		// cursoRepository.findByQueryNomePorArea();
		// cursoPorQueryNomePorArea.forEach(curso -> System.out.println(curso));

		// List<String> cursoPorQueryNomePorAreaInformada =
		// cursoRepository.findByQueryNomePorAreaInformada("Computação", "Graduação em
		// T.I.");
		// cursoPorQueryNomePorAreaInformada.forEach(curso ->
		// System.out.println(curso));

		// List<String> cursoPorQueryNomePorAreaParametros =
		// cursoRepository.findByQueryNomePorAreaParametros("Computação",
		// "Graduação em T.I.");
		// cursoPorQueryNomePorAreaParametros.forEach(curso ->
		// System.out.println(curso));

	}

}
