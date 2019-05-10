package com.wellinton.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wellinton.cursomc.domain.Cliente;

//Class DAO - Class de Camada de acesso a dados(Repository)
//Acessar os dados da Tabela Categoria 

// JpaRepository tipo especial do Spring capaz de acessar os dados com base 
//em um tipo (Objetos do tipo Categoria) --> Categoria,do tipo Integer
@Repository // Será uma interface que irá herdar do JpaRepository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	//Aula-S3-43
	//Busca por Email, caso o e-mail já existir, irá ser reportado a seguinte "message": "Email já existente"
	//Recurso de padrão de nome
	@Transactional(readOnly=true) //Ela não necessida ser uma operação envolvida com banco de dados 
	Cliente findByEmail(String email);
}