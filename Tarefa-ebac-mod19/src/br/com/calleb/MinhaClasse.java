package br.com.calleb;

@Tabela(nome = "MinhaTabela")
public class MinhaClasse {

    public static void main(String[] args) {
        Class<?> classe = MinhaClasse.class;
        Tabela tabela = classe.getAnnotation(Tabela.class);

        if (tabela != null) {
            String nomeTabela = tabela.nome();
            System.out.println("Nome da tabela: " + nomeTabela);
        }
    }
}
