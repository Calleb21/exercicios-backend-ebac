package br.com.calleb.vendas.online.exception;

/**
 * Description of BadRequestException
 * Created by calle on 09/02/2024.
 */
public class BadRequestException extends RuntimeException {

    private static final long serialVersionUID = -7339546357706827674L;

    public BadRequestException(String message) {
        super(message);
    }
}
