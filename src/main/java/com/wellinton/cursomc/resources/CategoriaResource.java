package com.wellinton.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wellinton.cursomc.domain.Categoria;
import com.wellinton.cursomc.services.CategoriaService;

//Controlador Rest da Class Categoria
@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired //Para instanciar automaticamente o objeto
	private CategoriaService service;
	
	//Testando o REST
	//Significa que o End Point do método abaixo (public ResponseEntity) aogra
	//vai ser o /categorias e o /id
	//find - esse método irá receber um id que irá vim da minha uml
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		//ResponseEntity é um tipo especial do Spring que ele encapsula (armazena) 
		//várias informações de uma resposta http para um servidor Rest
		
		Categoria obj = service.find(id); //Para ir no serviço e buscar a categoria 
		//que tenha o id
		return ResponseEntity.ok().body(obj);
		
		/* Código antigo 
		Categoria cat1 = new Categoria(1, "Informática");
		Categoria cat2 = new Categoria(2, "Escritório");
		
		List<Categoria> lista = new ArrayList<>();
		lista.add(cat1);
		lista.add(cat2);
		
		
		return lista;*/
	}

}
