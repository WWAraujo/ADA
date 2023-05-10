package br.com.letscode.zoo.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

@Data
@Builder
public class AnimalDTO {
    private String uid;

    @NotBlank(message = "O nome é obrigatório.")
    @Length(min = 3, max = 250, message = "O nome do animal tem que ter no mínimo 3 letras.")
    private String nome;

    @Min(value = 0, message = "A idade do animal deve ser maior que zero.")
    @Max(value = 1000, message = "A idade do animal deve ser menor que 1000.")
    private int idade;

    @NotNull(message = "A classe do animal é obrigatória.")
    private ClasseDTO classe;
}
