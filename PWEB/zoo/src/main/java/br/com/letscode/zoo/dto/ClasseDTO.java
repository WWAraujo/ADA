package br.com.letscode.zoo.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class ClasseDTO {
    private String uid;

    @NotBlank(message = "O nome é obrigatório.")
    @Length(min = 3, message = "O nome tem que ter no mínimo 3 letras.")
    private String nome;
}
