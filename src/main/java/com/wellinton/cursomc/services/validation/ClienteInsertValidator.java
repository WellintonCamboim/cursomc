package com.wellinton.cursomc.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.wellinton.cursomc.domain.enums.TipoCliente;
import com.wellinton.cursomc.dto.ClienteNewDTO;
import com.wellinton.cursomc.resources.exception.FieldMessage;
import com.wellinton.cursomc.services.validation.utils.BR;

//ClienteInsertValidator -> class que implementa o validation
//ClienteInsert --> É a anotação 
//Aula-S3-42- Validação customizada: CPF ou CNPJ na inserção de Cliente
public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
	@Override
	public void initialize(ClienteInsert ann) {

	}
	//Aula-S3-42
	//isValid método da ConstraintValidator que verifica se o nosso  tipo aqui (ClienteNewDTO), o objeto, vai ser válido ou não 
	//(true ou false), se o objeto não for válido
	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();

		if (objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CPF inválido"));
		}
		
		if (objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CNPJ inválido"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
