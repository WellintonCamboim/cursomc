package com.wellinton.cursomc.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

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

import com.wellinton.cursomc.domain.Cliente;
import com.wellinton.cursomc.dto.ClienteDTO;
import com.wellinton.cursomc.dto.ClienteNewDTO;
import com.wellinton.cursomc.services.ClienteService;

//Controlador Rest da Class Cliente
@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

	@Autowired // Para instanciar automaticamente o objeto
	private ClienteService service;

	// Testando o REST
	// Significa que o End Point do método abaixo (public ResponseEntity) aogra
	// vai ser o /categorias e o /id
	// find - esse método irá receber um id que irá vim da minha uml
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> find(@PathVariable Integer id) {
		// ResponseEntity é um tipo especial do Spring que ele encapsula (armazena)
		// várias informações de uma resposta http para um servidor Rest

		Cliente obj = service.find(id); // Para ir no serviço e buscar a categoria
		// que tenha o id
		return ResponseEntity.ok().body(obj);

		/*
		 * Código antigo Cliente cat1 = new Cliente(1, "Informática"); Cliente cat2 =
		 * new Cliente(2, "Escritório");
		 * 
		 * List<Cliente> lista = new ArrayList<>(); lista.add(cat1); lista.add(cat2);
		 * 
		 * 
		 * return lista;
		 */
	}

	// Aula - S3-40
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ClienteNewDTO objDto) {
		Cliente obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	// Aula - S3-32
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ClienteDTO objDto, @PathVariable Integer id) {
		Cliente obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	// Aula - S3-33 - DELETE
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	// Aula - S3-34 - List de Clientes
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ClienteDTO>> findAll() {
		List<Cliente> list = service.findAll();
		List<ClienteDTO> listDto = list.stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	// Aula - S3-35
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<ClienteDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Cliente> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<ClienteDTO> listDto = list.map(obj -> new ClienteDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}

}
