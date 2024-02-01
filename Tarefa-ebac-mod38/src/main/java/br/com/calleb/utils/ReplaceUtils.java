package br.com.calleb.utils;

/**
 * Description of ReplaceUtils
 * Created by calle on 01/02/2024.
 */
public class ReplaceUtils {

    public static String replace(String value, String... patterns) {
        String retorno = value;
        for (String pattern : patterns) {
            retorno = retorno.replace(pattern, "");
        }
        return retorno;
    }
}
