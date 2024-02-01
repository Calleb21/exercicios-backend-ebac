package br.com.calleb.service;

import br.com.calleb.domain.Venda;
import br.com.calleb.exceptions.DAOException;
import br.com.calleb.exceptions.TipoChaveNaoEncontradaException;

/**
 * Description of IVendaService
 * Created by calle on 01/02/2024.
 */
public interface IVendaService extends IGenericDAO<Venda, Long>{

    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;

    public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;

    /**
     * Usando este método para evitar a exception org.hibernate.LazyInitializationException
     * Ele busca todos os dados de objetos que tenham colletion pois a mesma por default é lazy
     * Mas você pode configurar a propriedade da collection como fetch = FetchType.EAGER na anotação @OneToMany e usar o consultar genérico normal
     *
     * OBS: Não é uma boa prática utiliar FetchType.EAGER pois ele sempre irá trazer todos os objetos da collection
     * mesmo sem precisar utilizar.
     *
     *
     * @see VendaJpa produtos
     *
     * @param id
     * @return
     */
    public Venda consultarComCollection(Long id);
}