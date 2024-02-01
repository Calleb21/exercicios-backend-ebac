package br.com.calleb.exceptions;

/**
 * Description of DAOException
 * Created by calle on 01/02/2024.
 */
public class DAOException extends Exception {

    private static final long serialVersionUID = 7054379063290825137L;

    public DAOException(String msg, Exception ex) {
        super(msg, ex);
    }
}
