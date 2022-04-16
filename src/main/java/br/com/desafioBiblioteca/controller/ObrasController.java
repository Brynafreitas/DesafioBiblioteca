package br.com.desafioBiblioteca.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafioBiblioteca.model.Obras;
import br.com.desafioBiblioteca.repository.ObrasRepository;
import br.com.desafioBiblioteca.service.ObrasService;

@RestController
@RequestMapping("/obras")
@CrossOrigin("*")
public class ObrasController {
	
	@Autowired
	private ObrasRepository obrasRepository;
	
	@Autowired
	private ObrasService obrasService;
	
	@GetMapping
	public ResponseEntity<List<Obras>> GetAll(){
		return ResponseEntity.ok(obrasRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Obras> GetById(@PathVariable Long id){
		return obrasRepository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
		
	}
	
	@GetMapping("titulo/{titulo}")
	public ResponseEntity<List<Obras>> GetByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(obrasRepository.findAllByTituloContainingIgnoreCase(titulo));
	}

	@PostMapping
	public ResponseEntity<Obras>post(@RequestBody Obras obras){
		return ResponseEntity.status(HttpStatus.CREATED).body(obrasRepository.save(obras));
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Obras> putById(@PathVariable Long id, @RequestBody Obras obras){
		return ResponseEntity.status(HttpStatus.OK).body(obrasService.putById(id, obras));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		obrasRepository.deleteById(id);
	}
}
