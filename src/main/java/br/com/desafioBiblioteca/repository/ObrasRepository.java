package br.com.desafioBiblioteca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafioBiblioteca.model.Obras;

@Repository
public interface ObrasRepository extends JpaRepository<Obras, Long> {
	
	
	public List<Obras> findAll();
	public List<Obras> findAllByTituloContainingIgnoreCase(String Titulo);
	

}
