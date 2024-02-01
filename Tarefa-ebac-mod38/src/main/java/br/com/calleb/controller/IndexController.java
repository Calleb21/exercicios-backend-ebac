package br.com.calleb.controller;

import scala.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

/**
 * Description of IndexController
 * Created by calle on 01/02/2024.
 */
@Named
@ViewScoped
public class IndexController implements Serializable {

    private static final long serialVersionUID = -784519597996507487L;

    public String redirectCliente() {
        return "/cliente/list.xhtml";
    }

    public String redirectProduto() {
        return "/produto/list.xhtml";
    }

    public String redirectVenda() {
        return "/venda/list.xhtml";
    }
}
