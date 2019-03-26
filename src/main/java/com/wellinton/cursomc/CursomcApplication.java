package com.wellinton.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wellinton.cursomc.domain.Categoria;
import com.wellinton.cursomc.repositories.CategoriaRepository;

//CommandLineRunner --> Permiti implementar um método auxiliar para executar alguma 
//ação quando a aplicação iniciar 
@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	/*Autowired -->A anotação @ Autowired fornece controle sobre onde e como a ligação entre os beans 
	deve ser realizada. Pode ser usado para em métodos setter, no 
	construtor, em uma propriedade ou métodos com nomes arbitrários e / ou vários argumentos.*/
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	
	//Método implementando por CommandLineRunner
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		//categoriaRepository.saveAll --> irá salvar as categorias do banco
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		
		
	}

}
