package com.wellinton.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wellinton.cursomc.domain.Categoria;
import com.wellinton.cursomc.domain.Produto;
import com.wellinton.cursomc.repositories.CategoriaRepository;
import com.wellinton.cursomc.repositories.ProdutoRepository;

//CommandLineRunner --> Permiti implementar um método auxiliar para executar alguma 
//ação quando a aplicação iniciar 
@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	/*Autowired -->A anotação @ Autowired fornece controle sobre onde e como a ligação entre os beans 
	deve ser realizada. Pode ser usado para em métodos setter, no 
	construtor, em uma propriedade ou métodos com nomes arbitrários e / ou vários argumentos.*/
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	//@Autowired = Criando uma dependência de Produto
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	
	//Método implementando por CommandLineRunner
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		//Instanciando produto e categoria = Criando os objetos
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		//get = acessar, pegar, consultar
		//set = 
		
		//addAll = eu passo vários elementos e ele adiciona na Lista
		//Quais os produtos que estão associados com cat1 == p1,p2,p3 --> Para seguir o UML
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		//cat2 está associado somente com o p2
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		//p1 --> cat1 (relacionamento conforme o UML)
		p1.getCategorias().addAll(Arrays.asList(cat1));
		
		//p2 --> cat1, cat2
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		//p3 --> cat1
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
			
				
		//categoriaRepository.saveAll --> irá salvar as categorias do banco
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		
		//Para salvar produto
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		
	}

}
