package com.wellinton.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellinton.cursomc.domain.Pagamento;

//Class DAO - Class de Camada de acesso a dados(Repository)
//Acessar os dados da Tabela Categoria 

// JpaRepository tipo especial do Spring capaz de acessar os dados com base 
//em um tipo (Objetos do tipo Categoria) --> Categoria,do tipo Integer
@Repository // Será uma interface que irá herdar do JpaRepository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

}