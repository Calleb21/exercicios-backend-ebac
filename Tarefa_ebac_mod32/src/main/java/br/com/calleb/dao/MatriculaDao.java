package br.com.calleb.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.calleb.domain.Matricula;

public class MatriculaDao implements IMatriculaDao {

	private EntityManagerFactory emf;

	public MatriculaDao() {
		emf = Persistence.createEntityManagerFactory("ExemploJPA");
	}

	@Override
	public Matricula cadastrar(Matricula mat) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(mat);
			em.getTransaction().commit();
			return mat;
		} finally {
			em.close();
		}
	}

	@Override
	public Matricula consultarPorId(Long id) {
		EntityManager em = emf.createEntityManager();
		try {
			return em.find(Matricula.class, id);
		} finally {
			em.close();
		}
	}

	@Override
	public Matricula atualizar(Matricula matriculaCadastrada) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(matriculaCadastrada);
			em.getTransaction().commit();
			return matriculaCadastrada;
		} finally {
			em.close();
		}
	}

	@Override
	public void excluirMatricula(Long idParaExcluir) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Matricula matricula = em.find(Matricula.class, idParaExcluir);
			if (matricula != null) {
				em.remove(matricula);
			}
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}

}
