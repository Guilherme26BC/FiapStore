package br.com.fiap.teste;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.fiap.dao.CategoriaDAO;
import br.com.fiap.factory.DAOFactory;
import br.com.fiap.model.Categoria;

public class CategoriaDAOTeste {
	
	private CategoriaDAO dao;
	//dependência para rodar o teste, colocar no método SetUp com @Before.
	
	@Before
	public void setUp() {
		dao = DAOFactory.getCategoriaDAO();
	}

	@Test 
	public void testListarTodas() {
		List<Categoria> lista = dao.listarTodas();
		assertNotNull("A lista de categorias não deve ser nula", lista);
		assertTrue("A lista de categorias deve conter itens", lista.size()>0);
	}
}
