package br.com.calleb;

/**
 * @author calle
 */
public class Pessoas {

    private String nome;
    private Sexo sexo;

    public Pessoas(String nome, Sexo sexo) {
        this.nome = nome;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    enum Sexo {
        Masculino, Femenino
    }
}
