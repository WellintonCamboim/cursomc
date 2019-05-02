package com.wellinton.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.wellinton.cursomc.domain.Cliente;
import com.wellinton.cursomc.dto.ClienteDTO;
import com.wellinton.cursomc.repositories.ClienteRepository;
import com.wellinton.cursomc.services.exception.DataIntegrityException;
import com.wellinton.cursomc.services.exception.ObjectNotFoundException;

// Camada de serviços de Cliente
@Service //
public class ClienteService {

	@Autowired // Faz a dependencia ser automaticamente instanciada pelo Spring
	// Pelo mecanismo de injeção de independência ou inversão de controler
	private ClienteRepository repo;

	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id); // Operação que faz busca no banco de dados
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

	// Aula - S3-32
	// Aula-S3-38
	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	// Aula - S3-33 - DELETE
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há entidades relacionadas");
		}
	}

	public List<Cliente> findAll() {
		return repo.findAll();
	}

	// Aula - S3-35
	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);

	}

	// Aula - S3-36 - A partir de um DTO o sistema irá construir um objeto Cliente
	// Método auxiliar que instancia uma Cliente a partir de um DTO
	public Cliente fromDTO(ClienteDTO objDto) {
		return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null);
		// return new Cliente(objDto.getId(), objDto.getNome());
	}

	// Aula-S3-38-Método Auxiliar
	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}

}
