package br.com.gabriel.primeiraapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gabriel.primeiraapi.entity.Professor;
import br.com.gabriel.primeiraapi.exception.ProfessorException;
import br.com.gabriel.primeiraapi.repository.ProfessorRepository;

@Service
public class ProfessorService {
	
	protected static final String MENSAGEM_PROFESSOR_NULO = "Professor não pode ser nulo.";
	protected static final String MENSAGEM_NOME_PROFESSOR_NULO_VAZIO = "O nome do professor deve ser preenchido.";
	protected static final String MENSAGEM_STATUS_PROFESSOR_NULO = "O status de professor não pode ser nulo.";
	protected static final String MENSAGEM_ID_PROFESSOR_NULO = "O id de professor não pode ser nulo.";

	
	@Autowired
	private ProfessorRepository professorRepository; //Injeção de dependencia de ProfessorRepository
	
	public Professor criar (Professor professor) throws ProfessorException {
		if(professor == null) {
			//throw new RuntimeException(MENSAGEM_PROFESSOR_NULO);
			throw new  ProfessorException(MENSAGEM_PROFESSOR_NULO);
		}else if (professor.getNome() == null || professor.getNome().isBlank()) {
			throw new ProfessorException(MENSAGEM_NOME_PROFESSOR_NULO_VAZIO);
		}else if (professor.getStatus() == null) {
			throw new ProfessorException(MENSAGEM_STATUS_PROFESSOR_NULO);
		}else if (professor.getId() != null) {
			throw new ProfessorException(MENSAGEM_ID_PROFESSOR_NULO);
		}
		return professorRepository.save(professor);
	}
	
	public Professor atualizar (Professor professor) throws ProfessorException {
		if(professor == null) {
			throw new  ProfessorException(MENSAGEM_PROFESSOR_NULO);
		}else if (professor.getNome( ) == null || professor.getNome().isBlank()) {
			throw new ProfessorException(MENSAGEM_NOME_PROFESSOR_NULO_VAZIO);
		}else if (professor.getStatus() == null) {
			throw new ProfessorException(MENSAGEM_STATUS_PROFESSOR_NULO);
		}else if (professor.getId() == null) {
			throw new ProfessorException(MENSAGEM_ID_PROFESSOR_NULO);
		}
		return professorRepository.save(professor);
	}
	public void deletar (Long idProfessor) throws ProfessorException {
		if (idProfessor == null) {
			throw new ProfessorException(MENSAGEM_PROFESSOR_NULO);
		}
		professorRepository.deleteById(idProfessor);
	}
	public Professor consultar (Long idProfessor) throws ProfessorException {
		if (idProfessor == null) {
			throw new ProfessorException (MENSAGEM_PROFESSOR_NULO);
		}
		Optional<Professor> professorOptional = professorRepository.findById(idProfessor);
		if(professorOptional.isPresent()) {
			return professorOptional.get();
		}
		throw new RuntimeException(MENSAGEM_PROFESSOR_NAO_EXISTE);
	}
	
	public List<Professor> findByNome(String nome) throws ProfessorException{
	    if(nome == null) {
	    	throw new ProfessorException (MENSAGEM_NOME_PROFESSOR_NULO_VAZIO);
	    }
		return professorRepository.findByNomeLike(nome);
	}
}
