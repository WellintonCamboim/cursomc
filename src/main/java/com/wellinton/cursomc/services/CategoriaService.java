package com.wellinton.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellinton.cursomc.domain.Categoria;
import com.wellinton.cursomc.repositories.CategoriaRepository;
import com.wellinton.cursomc.services.exception.ObjectNotFoundException;

// Camada de serviços de Categoria
@Service // 
public class CategoriaService {
	
	@Autowired // Faz a dependencia ser automaticamente instanciada pelo Spring
	//Pelo mecanismo de injeção de independência ou inversão de controler
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id); //Operação que faz busca no banco de dados
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	//Aula - S3-31
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
}
