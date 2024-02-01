package br.com.calleb.exceptions;

/**
 * Description of TipoChaveNaoEncontradaException
 * Created by calle on 01/02/2024.
 */
public class TipoChaveNaoEncontradaException extends Exception {


    private static final long serialVersionUID = -1389494676398525746L;

    public TipoChaveNaoEncontradaException(String msg) {
        this(msg, null);
    }

    public TipoChaveNaoEncontradaException(String msg, Throwable e) {
        super(msg, e);
    }
}
