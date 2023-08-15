package br.com.calleb.domain;

import br.com.calleb.anotacao.TipoChave;
import br.com.calleb.dao.Persistence;

import java.math.BigDecimal;

/**
 * Description of Produto
 * Created by calle on 02/08/2023.
 */
public class Produto implements Persistence {

    @TipoChave("getCodigo")
    private String codigo;

    private String nome;

    private String descricao;

    private BigDecimal valor;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
