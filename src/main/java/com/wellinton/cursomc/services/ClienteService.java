package com.wellinton.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellinton.cursomc.domain.Cliente;
import com.wellinton.cursomc.repositories.ClienteRepository;
import com.wellinton.cursomc.services.exception.ObjectNotFoundException;

// Camada de serviços de Cliente
@Service // 
public class ClienteService {
	
	@Autowired // Faz a dependencia ser automaticamente instanciada pelo Spring
	//Pelo mecanismo de injeção de independência ou inversão de controler
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id); //Operação que faz busca no banco de dados
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
}
