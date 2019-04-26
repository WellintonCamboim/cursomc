package com.wellinton.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.wellinton.cursomc.domain.Categoria;
import com.wellinton.cursomc.repositories.CategoriaRepository;
import com.wellinton.cursomc.services.exception.DataIntegrityException;
import com.wellinton.cursomc.services.exception.ObjectNotFoundException;

// Camada de serviços de Categoria
@Service //
public class CategoriaService {

	@Autowired // Faz a dependencia ser automaticamente instanciada pelo Spring
	// Pelo mecanismo de injeção de independência ou inversão de controler
	private CategoriaRepository repo;

	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id); // Operação que faz busca no banco de dados
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

	// Aula - S3-31
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	// Aula - S3-32
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	// Aula - S3-33 - DELETE
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
		}
	}
	public List<Categoria> findAll(){
		return repo.findAll();
	}
	
	//Aula - S3-35
	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);
		return repo.findAll(pageRequest);
		
	}
}
