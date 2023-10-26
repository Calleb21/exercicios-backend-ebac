package br.com.calleb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.calleb.dao.IProdutoDao;
import br.com.calleb.dao.ProdutoDao;
import br.com.calleb.domain.Produto;

public class ProdutoTest {

	private IProdutoDao produtoDao;
	private EntityManagerFactory emf;

	@Before
	public void setUp() {
		emf = Persistence.createEntityManagerFactory("ExemploJPA");
		produtoDao = new ProdutoDao();
	}

	@After
	public void tearDown() {
		emf.close();
	}
	
	public ProdutoTest() {
		produtoDao = new ProdutoDao();
	}

	@Test
	public void cadastrarProdutoTest() {
		Produto produtoTest = new Produto();
		produtoTest.setEstado("GO");
		produtoTest.setNome("Prod 1");
		produtoTest.setPreco(14232d);
		Produto produtoCadastrado = produtoDao.cadastrar(produtoTest);

		assertNotNull(produtoCadastrado);
		assertNotNull(produtoCadastrado.getId());
	}

	@Test
	public void consultarProdutoIdTest() {
		Produto produtoTest = new Produto();
		produtoTest.setEstado("SP");
		produtoTest.setNome("Prod 2");
		produtoTest.setPreco(1324d);
		Produto produtoCadastrado = produtoDao.cadastrar(produtoTest);

		Long idConsulta = produtoCadastrado.getId();
		Produto produtoConsultado = produtoDao.consultarProdutoId(idConsulta);

		assertEquals(produtoTest.getEstado(), produtoConsultado.getEstado());
		assertEquals(produtoTest.getNome(), produtoConsultado.getNome());
		assertEquals(produtoTest.getPreco(), produtoConsultado.getPreco());
	}

	@Test
	public void atualizarProdutoTest() {
		Produto produtoTest = new Produto();
		produtoTest.setEstado("RJ");
		produtoTest.setNome("Prod 4");
		produtoTest.setPreco(12345d);
		Produto produtoCadastrado = produtoDao.cadastrar(produtoTest);

		produtoCadastrado.setEstado("MG");
		produtoCadastrado.setNome("Prod 3");
		produtoCadastrado.setPreco(4321d);

		Produto produtoAtualizado = produtoDao.atualizar(produtoCadastrado);

		assertEquals("MG", produtoAtualizado.getEstado());
		assertEquals("Prod 3", produtoAtualizado.getNome());
		assertEquals(4321d, produtoAtualizado.getPreco(), 0.001);
	}

	@Test
	public void excluirProdutoTest() {
		Produto produtoTest = new Produto();
		produtoTest.setEstado("MT");
		produtoTest.setNome("Prod 5");
		produtoTest.setPreco(14545d);
		Produto produtoCadastrado = produtoDao.cadastrar(produtoTest);
		
		Long idParaExclusao = produtoCadastrado.getId();
		produtoDao.excluirProduto(idParaExclusao);
		
		Produto produtoExcluido = produtoDao.consultarProdutoId(idParaExclusao);
		assertNull(produtoExcluido);
	}
}
