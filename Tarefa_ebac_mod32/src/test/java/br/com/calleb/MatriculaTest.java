package br.com.calleb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.Instant;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.calleb.dao.IMatriculaDao;
import br.com.calleb.dao.MatriculaDao;
import br.com.calleb.domain.Matricula;

public class MatriculaTest {

	private IMatriculaDao matriculaDao;
	private EntityManagerFactory emf;

	@Before
	public void setUp() {
		emf = Persistence.createEntityManagerFactory("ExemploJPA");
		matriculaDao = new MatriculaDao();
	}

	@After
	public void tearDown() {
		emf.close();
	}

	public MatriculaTest() {
		matriculaDao = new MatriculaDao();
	}

	@Test
	public void cadastrarTest() {
		Matricula mat = new Matricula();
		mat.setCodigo("A1");
		mat.setDataMatricula(Instant.now());
		mat.setStatus("ATIVA");
		mat.setValor(2000d);
		mat = matriculaDao.cadastrar(mat);

		assertNotNull(mat);
		assertNotNull(mat.getId());
	}

	@Test
	public void consultarMatriculaIdTest() {
		Matricula matricula = new Matricula();
		matricula.setCodigo("A2");
		matricula.setDataMatricula(Instant.now());
		matricula.setStatus("PENDENTE");
		matricula.setValor(2345d);
		Matricula matriculaCadastrada = matriculaDao.cadastrar(matricula);

		Long idParaConsulta = matriculaCadastrada.getId();
		Matricula matriculaConsultada = matriculaDao.consultarPorId(idParaConsulta);

		assertEquals(matricula.getCodigo(), matriculaConsultada.getCodigo());
		assertEquals(matricula.getDataMatricula(), matriculaCadastrada.getDataMatricula());
		assertEquals(matricula.getStatus(), matriculaCadastrada.getStatus());
		assertEquals(matricula.getValor(), matriculaCadastrada.getValor());
	}

	@Test
	public void atualizarMatriculaTest() {
		Matricula matricula = new Matricula();
		matricula.setCodigo("Teste 3");
		matricula.setDataMatricula(Instant.now());
		matricula.setStatus("ATIVA");
		matricula.setValor(2341d);
		Matricula matriculaCadastrada = matriculaDao.cadastrar(matricula);

		matriculaCadastrada.setCodigo("Teste 2");
		matriculaCadastrada.setDataMatricula(Instant.now());
		matriculaCadastrada.setStatus("PENDENTE");
		matriculaCadastrada.setValor(5435d);

		Matricula matriculaAtualizada = matriculaDao.atualizar(matriculaCadastrada);

		assertEquals("Teste 2", matriculaAtualizada.getCodigo());
		assertEquals(matriculaCadastrada.getDataMatricula(), matriculaAtualizada.getDataMatricula());
		assertEquals("PENDENTE", matriculaAtualizada.getStatus());
		assertEquals(5435d, matriculaAtualizada.getValor(), 0.001); // Use uma tolerância para valores decimais
	}

	@Test
	public void excluirMatriculaTest() {
		Matricula matricula = new Matricula();
		matricula.setCodigo("A5");
		matricula.setDataMatricula(Instant.now());
		matricula.setStatus("PENDENTE");
		matricula.setValor(5435d);
		Matricula matriculaCadastrada = matriculaDao.cadastrar(matricula);
		
		Long idParaExcluir = matriculaCadastrada.getId();
		matriculaDao.excluirMatricula(idParaExcluir);
		
		Matricula matriculaExcluida = matriculaDao.consultarPorId(idParaExcluir);
		assertNull(matriculaExcluida);	
	}

	// TODO Como atividade principal do módulo: Com base nesse projeto, crie um novo
	// projeto, crie uma classe
	// chamada produto com 3 propriedades utilizando o JPA e adicione as
	// implementações acima!
}
