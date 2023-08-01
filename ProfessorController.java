package br.com.gabriel.primeiraapi.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabriel.primeiraapi.entity.Professor;
import br.com.gabriel.primeiraapi.exception.ProfessorException;
import br.com.gabriel.primeiraapi.service.ProfessorService;

@RestController
@RequestMapping("/professores")
public class ProfessorController {
	
	@Autowired
	private ProfessorService professorService;
	
	@PostMapping
	public Professor criar(@RequestBody Professor professor) throws ProfessorException {
		return professorService.criar(professor);
	}
	
	@PatchMapping
	public Professor atualizar (@RequestBody Professor professor) throws ProfessorException {
		return professorService.atualizar(professor);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) throws ProfessorException {
		professorService.deletar(id);
	}
	@GetMapping
	public Professor consultar (@RequestBody long id) throws ProfessorException {
		return professorService.consultar(id);
	}
	@GetMapping
	@ResponseBody
	public List<Professor> findByNomeLike(@RequestParam(name = "nome") String nome) throws ProfessorException{ //recebe os dados
		return professorService.findByNome(nome);		
	}
}
