package br.com.calleb.vendas.online.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Description of Cliente
 * Created by calle on 09/02/2024.
 */
@Document(collection = "cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "Cliente", description = "Cliente")
public class Cliente {

    @Id
    @Schema(description = "Identificador único")
    private String id;

    @NotNull
    @Size(min = 1, max = 50)
    @Schema(description = "Nome", minLength = 1, maxLength = 50, nullable = false)
    private String nome;

    @NotNull
    @Indexed(unique = true, background = true)
    @Schema(description = "CPF", nullable = false)
    private Long cpf;

    @NotNull
    @Schema(description = "Telefone", nullable = false)
    private Long tel;

    @NotNull
    @Size(min = 1, max = 50)
    @Indexed(unique = true, background = true)
    @Schema(description = "Email", minLength = 1, maxLength = 50, nullable = false)
    @Pattern(regexp = ".+@.+\\..+", message = "Email inválido")
    private String email;

    @NotNull
    @Size(min = 1, max = 50)
    @Schema(description = "Endereço", minLength = 1, maxLength = 50, nullable = false)
    private String end;

    @NotNull
    @Schema(description = "Numero residencial", nullable = false)
    private Integer numero;

    @NotNull
    @Size(min = 1, max = 50)
    @Schema(description = "Cidade", minLength = 1, maxLength = 50, nullable = false)
    private String cidade;

    @NotNull
    @Size(min = 1, max = 50)
    @Schema(description = "Estado", minLength = 1, maxLength = 50, nullable = false)
    private String estado;
}
