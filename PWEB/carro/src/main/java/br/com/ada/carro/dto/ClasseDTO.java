package br.com.ada.carro.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
public class ClasseDTO {
    private String uid;

    @NotBlank(message = "O nome é obrigatório.")
    @Length(min = 3, message = "O nome tem que ter no mínimo 3 letras.")
    private String nome;
}
