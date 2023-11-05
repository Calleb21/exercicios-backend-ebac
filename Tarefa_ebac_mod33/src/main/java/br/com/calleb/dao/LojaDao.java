package br.com.calleb.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import br.com.calleb.domain.Loja;
import br.com.calleb.domain.Marca;

/**
 * @author calle
 * 
 */
public class LojaDao implements ILojaDao {

	private EntityManagerFactory entityManagerFactory;

	public LojaDao() {
		entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
	}

	@Override
	public Loja cadastrar(Loja loja) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(loja);
		entityManager.getTransaction().commit();
		entityManager.close();
		return loja;
	}

	@Override
	public Loja buscarCodigoMarca(String identificador) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Loja loja = null;

		try {
			TypedQuery<Loja> query = entityManager.createQuery(
					"SELECT m FROM Loja m INNER JOIN m.marca c WHERE c.identificador = :identificador", Loja.class);
			query.setParameter("identificador", identificador);
			loja = query.getSingleResult();
		} catch (NoResultException e) {
		} finally {
			entityManager.close();
		}

		return loja;
	}

	@Override
	public Loja buscarPorCurso(Marca marca) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Loja> query = builder.createQuery(Loja.class);
		Root<Loja> root = query.from(Loja.class);
		Join<Object, Object> join = root.join("marca", JoinType.INNER);
		query.select(root).where(builder.equal(join, marca));

		TypedQuery<Loja> tpQuery = entityManager.createQuery(query);
		Loja loja = tpQuery.getSingleResult();

		entityManager.close();

		return loja;
	}

	public void fecharConexao() {
		entityManagerFactory.close();
	}
}
