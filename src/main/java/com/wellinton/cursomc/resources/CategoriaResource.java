package com.wellinton.cursomc.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.wellinton.cursomc.domain.Categoria;
import com.wellinton.cursomc.dto.CategoriaDTO;
import com.wellinton.cursomc.services.CategoriaService;

//Controlador Rest da Class Categoria
@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@Autowired // Para instanciar automaticamente o objeto
	private CategoriaService service;

	// Testando o REST
	// Significa que o End Point do método abaixo (public ResponseEntity) aogra
	// vai ser o /categorias e o /id
	// find - esse método irá receber um id que irá vim da minha uml
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Categoria> find(@PathVariable Integer id) {
		// ResponseEntity é um tipo especial do Spring que ele encapsula (armazena)
		// várias informações de uma resposta http para um servidor Rest

		Categoria obj = service.find(id); // Para ir no serviço e buscar a categoria
		// que tenha o id
		return ResponseEntity.ok().body(obj);

		/*
		 * Código antigo Categoria cat1 = new Categoria(1, "Informática"); Categoria
		 * cat2 = new Categoria(2, "Escritório");
		 * 
		 * List<Categoria> lista = new ArrayList<>(); lista.add(cat1); lista.add(cat2);
		 * return lista;
		 */

	}

	// @RequestBody -Converte objeto Java automaticamente
	// Aula - S3-31
	// Método para receber uma Categoria no formato Json e para inserir essa
	// Categoria no banco de dados
	// Resposta HTPP só que não irá ter corpo (Void)
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Categoria obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	// Aula - S3-32
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Categoria obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	// Aula - S3-33 - DELETE
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	// Aula - S3-34 - List de Categorias
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<CategoriaDTO>> findAll(){
		List<Categoria> list = service.findAll();
		List<CategoriaDTO> listDto = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	// Aula - S3-35
	@RequestMapping(value = "/page", method=RequestMethod.GET)
	public ResponseEntity<Page<CategoriaDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24")Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome")String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC")String direction){
		Page<Categoria> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<CategoriaDTO> listDto = list.map(obj -> new CategoriaDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
}
