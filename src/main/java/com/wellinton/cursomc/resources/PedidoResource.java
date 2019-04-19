package com.wellinton.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wellinton.cursomc.domain.Pedido;
import com.wellinton.cursomc.services.PedidoService;

//Controlador Rest da Class Pedido
@RestController
@RequestMapping(value="/pedidos")
public class PedidoResource {
	
	@Autowired //Para instanciar automaticamente o objeto
	private PedidoService service;
	
	//Testando o REST
	//Significa que o End Point do método abaixo (public ResponseEntity) aogra
	//vai ser o /categorias e o /id
	//find - esse método irá receber um id que irá vim da minha uml
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		//ResponseEntity é um tipo especial do Spring que ele encapsula (armazena) 
		//várias informações de uma resposta http para um servidor Rest
		
		Pedido obj = service.find(id); //Para ir no serviço e buscar a categoria 
		//que tenha o id
		return ResponseEntity.ok().body(obj);
		
		/* Código antigo 
		Pedido cat1 = new Pedido(1, "Informática");
		Pedido cat2 = new Pedido(2, "Escritório");
		
		List<Pedido> lista = new ArrayList<>();
		lista.add(cat1);
		lista.add(cat2);
		
		
		return lista;*/
	}

}
