package br.com.calleb.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.calleb.domain.Produto;

public class ProdutoDao implements IProdutoDao {

	private EntityManagerFactory emf;

	public ProdutoDao() {
		emf = Persistence.createEntityManagerFactory("ExemploJPA");
	}

	@Override
	public Produto cadastrar(Produto produtoTest) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(produtoTest);
			em.getTransaction().commit();
			return produtoTest;
		} finally {
			em.close();
		}
	}

	@Override
	public Produto consultarProdutoId(Long idConsulta) {
		EntityManager em = emf.createEntityManager();
		try {
			return em.find(Produto.class, idConsulta);
		} finally {
			em.close();
		}
	}

	@Override
	public Produto atualizar(Produto produtoCadastrado) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(produtoCadastrado);
			em.getTransaction().commit();
			return produtoCadastrado;
		} finally {
			em.close();
		}
	}

	@Override
	public void excluirProduto(Long idParaExclusao) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Produto produto = em.find(Produto.class, idParaExclusao);
			if (produto != null) {
				em.remove(produto);
			}
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}
}
