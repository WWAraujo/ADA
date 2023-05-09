package br.com.ada.carro.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
public class CarroDTO {

    private String uid;

    @NotBlank(message = "O nome é obrigatório.")
    @Length(min = 3, max = 250, message = "O nome do carro tem que ter no mínimo 3 letras.")
    private String nome;

    @Min(value = 50, message = "A potencia do motor tem que ser maior que 50cv...")
    @Max(value = 2000, message = "A potencia do motor tem que ser menor que 2000cv...")
    private double potenciaMotor;

    @NotNull(message = "A classe do marca é obrigatória.")
    private ClasseDTO classe;
}
