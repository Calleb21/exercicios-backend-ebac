package br.com.calleb;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.calleb.dao.CarroDao;
import br.com.calleb.dao.ICarroDao;
import br.com.calleb.domain.Carro;

/**
 * @author calle
 * 
 */
public class CarroTest {

	private ICarroDao carroDao;

	public CarroTest() {
		carroDao = new CarroDao();
	}

	@Test
	public void cadastrar() {
		Carro carro = new Carro();
		carro.setIdentificador("C1");
		carro.setNome("Audi A8");
		carro = carroDao.cadastrar(carro);

		assertNotNull(carro);
		assertNotNull(carro.getId());
	}
}
