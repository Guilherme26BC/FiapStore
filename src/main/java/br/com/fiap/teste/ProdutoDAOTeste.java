package br.com.fiap.teste;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.fiap.dao.CategoriaDAO;
import br.com.fiap.dao.MarcaDAO;
import br.com.fiap.dao.ProdutoDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.factory.DAOFactory;
import br.com.fiap.model.Categoria;
import br.com.fiap.model.Marca;
import br.com.fiap.model.Produto;

public class ProdutoDAOTeste {
	
	private ProdutoDAO produtoDAO;
	private CategoriaDAO categoriaDAO;
	private MarcaDAO marcaDAO;
	private Produto produto;

	//pode usar métodos de VERIFICAÇÂO dentro do Before, apenas de verificação
	@Before
	public void setUp() {
		produtoDAO = DAOFactory.getProdutoDAO();
		categoriaDAO = DAOFactory.getCategoriaDAO();
		marcaDAO = DAOFactory.getMarcaDAO();
		//Recupera uma categoria e uma marca já existentes no BD
		List<Categoria> categorias = categoriaDAO.listarTodas();
		List<Marca> marcas = marcaDAO.listarTodas();
		//Certificando que existem categorias e marcas para os testes
		assertTrue("O banco precisa ter ao menos uma categoria cadastrada", !categorias.isEmpty());
		assertTrue("O banco precisa ter ao menos uma marca cadastrada", !marcas.isEmpty());
		Categoria categoria = categorias.get(1);
		Marca marca = marcas.get(1);
		//Inicializa o produto com a categoria e a marca recuperadas
		produto = new Produto("Tv Samsung", 5000, Calendar.getInstance(), 50);
		produto.setCategoria(categoria);
		produto.setMarca(marca);
	}
	
	@After
	public void tearDown() {
		try {
			produtoDAO.cadastrar(produto);
			List<Produto> lista = produtoDAO.listarTodos();
			assertNotNull("A lista de produtos não deve ser nula", lista);
			assertTrue("A lista de produtos deve conter itens", lista.size()>0);
		}catch(DBException e) {
			
		}
	}
	@Test
	public void testRemoverProduto() {
		try {
			produtoDAO.cadastrar(produto);
			produtoDAO.remover(produto.getCodigo());
			Produto produtoRemovido = produtoDAO.listarPorId(produto.getCodigo());
			assertNull("O produto deve ser removido", produtoRemovido);
		}catch(DBException e) {
			
		}
	}

}
