package com.wellinton.cursomc.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.wellinton.cursomc.domain.Cliente;
import com.wellinton.cursomc.dto.ClienteDTO;
import com.wellinton.cursomc.repositories.ClienteRepository;
import com.wellinton.cursomc.resources.exception.FieldMessage;

//Aula-S3-44 - ClienteUpdateValidator irá validar a Anotação @ClienteUpdate
//ClienteInsertValidator -> class que implementa o validation
//ClienteInsert --> É a anotação 
//Aula-S3-42- Validação customizada: CPF ou CNPJ na inserção de Cliente
public class ClienteUpdateValidator implements ConstraintValidator<ClienteUpdate, ClienteDTO> {
	
	//Aula-S3-44 - Essa função irá permitir obter  o parametro da URI (ID)
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private ClienteRepository repo;
	
	@Override
	public void initialize(ClienteUpdate ann) {

	}
	//Aula-S3-42
	//isValid método da ConstraintValidator que verifica se o nosso  tipo aqui (ClienteNewDTO), o objeto, vai ser válido ou não 
	//(true ou false), se o objeto não for válido
	@Override
	public boolean isValid(ClienteDTO objDto, ConstraintValidatorContext context) {
		//Aula-S3-44 --< Permite pegar o Id - http://localhost:8080/clientes/2 == id=2
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId = Integer.parseInt(map.get("id"));
		
		List<FieldMessage> list = new ArrayList<>();
		
		//Aula-S3-43 - Map --> Estrutura de dados	
		//Lógica para testar se o email do Cliente já existe 
		Cliente aux = repo.findByEmail(objDto.getEmail());
		if (aux != null && !aux.getId().equals(uriId)) {
			list.add(new FieldMessage("email", "Email já existente")); //Erro de validação 
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
