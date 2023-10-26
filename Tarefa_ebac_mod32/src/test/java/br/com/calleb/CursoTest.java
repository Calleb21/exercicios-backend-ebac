package br.com.calleb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.calleb.dao.CursoDao;
import br.com.calleb.dao.ICursoDao;
import br.com.calleb.domain.Curso;

public class CursoTest {

	private ICursoDao cursoDao;
	private EntityManagerFactory emf;

	@Before
	public void setUp() {
		emf = Persistence.createEntityManagerFactory("ExemploJPA");
		cursoDao = new CursoDao();
	}

	@After
	public void tearDown() {
		emf.close();
	}
	
	public CursoTest() {
		cursoDao = new CursoDao();
	}

	@Test
	public void cadastrarTest() {
		Curso cursoTeste = new Curso();
		cursoTeste.setCodigo("A1");
		cursoTeste.setNome("Curso de Teste 1");
		cursoTeste.setDescricao("Teste 1");
		Curso cursoCadastrado = cursoDao.cadastrar(cursoTeste);

		assertNotNull(cursoCadastrado);
		assertNotNull(cursoCadastrado.getId());
	}

	@Test
	public void consultarPorIdTest() {
		Curso cursoTeste2 = new Curso();
		cursoTeste2.setCodigo("A2");
		cursoTeste2.setNome("Curso de Teste 2");
		cursoTeste2.setDescricao("Teste 2");
		Curso cursoCadastrado = cursoDao.cadastrar(cursoTeste2);

		Long idParaConsulta = cursoCadastrado.getId();
		Curso cursoConsultado = cursoDao.consultarPorId(idParaConsulta);

		assertEquals(cursoTeste2.getCodigo(), cursoConsultado.getCodigo());
		assertEquals(cursoTeste2.getNome(), cursoConsultado.getNome());
		assertEquals(cursoTeste2.getDescricao(), cursoConsultado.getDescricao());
	}

	@Test
	public void atualizarTest() {
		Curso cursoTeste3 = new Curso();
		cursoTeste3.setCodigo("A4");
		cursoTeste3.setNome("Curso de Teste 4");
		cursoTeste3.setDescricao("Teste 4");
		Curso cursoCadastrado = cursoDao.cadastrar(cursoTeste3);

		cursoCadastrado.setCodigo("A3");
		cursoCadastrado.setNome("Curso de Teste 3");
		cursoCadastrado.setDescricao("Teste 3");

		Curso cursoAtualizado = cursoDao.atualizar(cursoCadastrado);

		assertEquals("A3", cursoAtualizado.getCodigo());
		assertEquals("Curso de Teste 3", cursoAtualizado.getNome());
		assertEquals("Teste 3", cursoAtualizado.getDescricao());
	}

	@Test
	public void excluirTest() {
		Curso cursoTest4 = new Curso();
		cursoTest4.setCodigo("A5");
		cursoTest4.setNome("Curso de Teste 5");
		cursoTest4.setDescricao("Teste 5");
		Curso cursoCadastrado = cursoDao.cadastrar(cursoTest4);

		Long idParaExclusao = cursoCadastrado.getId();
		cursoDao.excluirCurso(idParaExclusao);

		Curso cursoExcluido = cursoDao.consultarPorId(idParaExclusao);
		assertNull(cursoExcluido);
	}
}
