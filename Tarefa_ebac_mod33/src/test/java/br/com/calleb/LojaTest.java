package br.com.calleb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.calleb.dao.AcessorioDao;
import br.com.calleb.dao.CarroDao;
import br.com.calleb.dao.IAcessorioDao;
import br.com.calleb.dao.ICarroDao;
import br.com.calleb.dao.ILojaDao;
import br.com.calleb.dao.IMarcaDao;
import br.com.calleb.dao.LojaDao;
import br.com.calleb.dao.MarcaDao;
import br.com.calleb.domain.Acessorio;
import br.com.calleb.domain.Carro;
import br.com.calleb.domain.Loja;
import br.com.calleb.domain.Marca;

/**
 * @author calle
 * 
 */
public class LojaTest {

	private ILojaDao lojaDao;
	private ICarroDao carroDao;
	private IMarcaDao marcaDao;
	private IAcessorioDao acessorioDao;

	public LojaTest() {
		lojaDao = new LojaDao();
		carroDao = new CarroDao();
		marcaDao = new MarcaDao();
		acessorioDao = new AcessorioDao();
	}

	@Test
	public void cadastrar() {
		Marca marca = criarMarca("M1");
		Carro carro = criarCarro("C1");

		Loja loja = new Loja();
		loja.setIdentificador("L1");
		loja.setStatus("Concluido");
		loja.setValor(235599D);
		loja.setMarca(marca);
		loja.setCarro(carro);

		carro.setLoja(loja);
		loja = lojaDao.cadastrar(loja);

		assertNotNull(loja);
		assertNotNull(loja.getId());

		Loja lojaDB = lojaDao.buscarCodigoMarca(loja.getIdentificador());
		assertNotNull(lojaDB);
		assertEquals(loja.getId(), lojaDB.getId());

		Loja lojaBDObj = lojaDao.buscarPorCurso(marca);
		assertNotNull(lojaBDObj);
		assertEquals(loja.getId(), lojaBDObj.getId());
		assertEquals(loja.getId(), lojaBDObj.getId());
		assertEquals(loja.getIdentificador(), lojaDB.getIdentificador());
		assertEquals(loja.getIdentificador(), lojaBDObj.getIdentificador());
	}

	private Acessorio criarAcessorio(String identificador) {
		Acessorio acess = new Acessorio();
		acess.setIdentificador(identificador);
		acess.setDescricao("Acessorio 1");
		return acess;
	}

	private Carro criarCarro(String identificador) {
		Acessorio acess = criarAcessorio("A1");
		Acessorio acess1 = criarAcessorio("A2");
		Carro carro = new Carro();
		carro.setIdentificador(identificador);
		carro.setNome("Audi Q3");
		carro.add(acess);
		carro.add(acess1);
		return carroDao.cadastrar(carro);
	}

	private Marca criarMarca(String identificador) {
		Marca marca = new Marca();
		marca.setIdentificador(identificador);
		marca.setDescricao("Carro de Luxo");
		marca.setNome("AUDI");
		return marcaDao.cadastrar(marca);
	}
}
