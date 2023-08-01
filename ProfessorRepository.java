package br.com.gabriel.primeiraapi.repository;

import java.util.List; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.gabriel.primeiraapi.entity.Professor;
@Repository
public interface ProfessorRepository extends JpaRepository<Professor,Long>{
	
	@Query(value = "SELECT p FROM Professores p WHERE p.nome LIKE ?%")
	List<Professor>findByNomeLike(String nome);

	
}
