package com.wellinton.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellinton.cursomc.domain.Pedido;
import com.wellinton.cursomc.repositories.PedidoRepository;
import com.wellinton.cursomc.services.exception.ObjectNotFoundException;

// Camada de serviços de Pedido
@Service // 
public class PedidoService {
	
	@Autowired // Faz a dependencia ser automaticamente instanciada pelo Spring
	//Pelo mecanismo de injeção de independência ou inversão de controler
	private PedidoRepository repo;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id); //Operação que faz busca no banco de dados
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
}
