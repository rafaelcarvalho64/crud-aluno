package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlunoController {

	@Autowired
	AlunoRepository repository;

	@GetMapping("/aluno/{id}")
	public Aluno getAlunoById(@PathVariable Long id) {
		return repository.findById(id).get();
	}

	@GetMapping("/aluno")
	public List<Aluno> getAllAlunos() {
		return repository.findAll();
	}

	@RequestMapping(value = "aluno/curso/{nomecurso}", method = RequestMethod.GET)
 	public List<Aluno> findByCourse(@PathVariable String nomecurso) {
		List<Aluno> alunos = new ArrayList<Aluno>(); 
			repository.findByCurso(nomecurso.toUpperCase()).forEach(alunos::add);
		return alunos;	
	 }

	@PostMapping("/aluno")
	public Aluno saveAluno(@RequestBody Aluno aluno) {
		return repository.save(aluno);
	}

	@DeleteMapping("/aluno/{id}")
	public void deleteAluno(@PathVariable Long id) {
		repository.deleteById(id);
	}

	    
	@PutMapping("/aluno/{id}")
	public Aluno updateAluno(@PathVariable long id, @RequestBody Aluno aluno) {
		Optional<Aluno> tutorialData = repository.findById(id);
	    	Aluno a = tutorialData.get();
	      a.setNome(aluno.getNome());
	      a.setCurso(aluno.getCurso());
	      a.setDataNascimento(aluno.getDataNascimento());
	      return repository.save(a);	   
	}
}