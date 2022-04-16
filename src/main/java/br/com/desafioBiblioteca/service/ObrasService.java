package br.com.desafioBiblioteca.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafioBiblioteca.model.Obras;
import br.com.desafioBiblioteca.repository.ObrasRepository;

@Service
public class ObrasService {
	
	@Autowired
	private ObrasRepository obrasRepository;
	
	public Obras putById(Long id, Obras obras) {
		
		Obras obraAtual = obrasRepository.findById(id).get();
		BeanUtils.copyProperties(obras, obraAtual, "id");
		return obrasRepository.save(obraAtual);
	}

}
