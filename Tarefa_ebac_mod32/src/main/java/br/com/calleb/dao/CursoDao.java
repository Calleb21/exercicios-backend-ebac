package br.com.calleb.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.calleb.domain.Curso;

public class CursoDao implements ICursoDao {

	private EntityManagerFactory emf;

	public CursoDao() {
		emf = Persistence.createEntityManagerFactory("ExemploJPA");
	}

	@Override
	public Curso cadastrar(Curso curso) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(curso);
			em.getTransaction().commit();
			return curso;
		} finally {
			em.close();
		}
	}

	@Override
	public Curso consultarPorId(Long id) {
		EntityManager em = emf.createEntityManager();
		try {
			return em.find(Curso.class, id);
		} finally {
			em.close();
		}
	}

	@Override
	public Curso atualizar(Curso cursoCadastrado) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(cursoCadastrado);
			em.getTransaction().commit();
			return cursoCadastrado;
		} finally {
			em.close();
		}
	}

	@Override
	public void excluirCurso(Long idParaExclusao) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Curso curso = em.find(Curso.class, idParaExclusao);
			if (curso != null) {
				em.remove(curso);
			}
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}
}
