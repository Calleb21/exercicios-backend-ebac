package br.com.calleb.exceptions;

/**
 * Description of TipoElementoNaoConhecidoException
 * Created by calle on 01/02/2024.
 */
public class TipoElementoNaoConhecidoException extends Exception {


    private static final long serialVersionUID = -2268140970978666251L;

    public TipoElementoNaoConhecidoException(String msg) {
        this(msg, null);
    }

    public TipoElementoNaoConhecidoException(String msg, Throwable e) {
        super(msg, e);
    }
}
