import org.example.controller.Idade;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TesteIdade {

    static Idade idade;

    @BeforeAll
    static void init() {
        idade = new Idade();
        System.out.println("start");
    }

    @Test
    void validar_idade(){
        int resultado = idade.anosDeVida(2000);
        Assertions.assertEquals(23, resultado);
    }

    @Test
    void validar_ano_nascimento_maior(){

        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            int resultado = idade.anosDeVida(2025);
        });

        Assertions.assertEquals("Ano invalido.", exception.getMessage());
    }

    @Test
    void validar_ano_nascimento_menor(){

        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            int resultado = idade.anosDeVida(1902);
        });

        Assertions.assertEquals("Ano invalido.", exception.getMessage());
    }


}
