package br.com.calleb.vendas.online.domain;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

/**
 * Description of Produto
 * Created by calle on 16/02/2024.
 */
@Document(collection = "produto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Produto {

    public enum Status {
        ATIVO, INATIVO;
    }

    @Id
    private String id;

    @NotNull
    @Size(min = 2, max = 10)
    @Indexed(unique = true, background = true)
    private String codigo;

    @NotNull
    @Size(min = 1, max = 50)
    private String nome;

    @NotNull
    @Size(min = 1, max = 50)
    private String descricao;

    private BigDecimal valor;

    private Status status;
}
