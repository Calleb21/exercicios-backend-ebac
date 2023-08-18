package br.com.calleb.dao;

/**
 * @author calle
 */
public class ClienteDAO implements IClienteDAO {

    @Override
    public String salvar() {
        throw new UnsupportedOperationException("Não funciona sem config de banco");
//        return "Sucesso";
    }
}
