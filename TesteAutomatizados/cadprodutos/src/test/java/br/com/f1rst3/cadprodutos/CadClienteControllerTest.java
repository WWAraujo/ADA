package br.com.f1rst3.cadprodutos;

import br.com.f1rst3.cadprodutos.dto.request.ProdutoSalvarRequestDto;
import br.com.f1rst3.cadprodutos.dto.response.ProdutoResponseDto;
import br.com.f1rst3.cadprodutos.dto.response.ProdutoResponseDtoTeste;
import br.com.f1rst3.cadprodutos.exception.NotFoundException;
import br.com.f1rst3.cadprodutos.exception.ValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CadClienteControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void inserir_produto_rest() {

        ProdutoSalvarRequestDto requestDto = new ProdutoSalvarRequestDto()
                .setNome("Arroz")
                .setQuantidade(10);

        ResponseEntity<ProdutoResponseDto> responseDto =
                restTemplate.exchange("/produtos",
                        HttpMethod.POST,
                        new HttpEntity<>(requestDto),
                        ProdutoResponseDto.class);

        Assertions.assertEquals(201, responseDto.getStatusCode().value());
        org.junit.jupiter.api.Assertions.assertNotNull(responseDto.getBody());
        org.junit.jupiter.api.Assertions.assertNotNull(responseDto.getBody().getId());
        org.junit.jupiter.api.Assertions.assertEquals(requestDto.getNome(), responseDto.getBody().getNome());
        org.junit.jupiter.api.Assertions.assertEquals(requestDto.getQuantidade(), responseDto.getBody().getQuantidade());
    }

    @Test
    void get_produto_by_id() {

        ProdutoSalvarRequestDto requestDto = new ProdutoSalvarRequestDto()
            .setNome("produto test")
            .setQuantidade(12);

        ResponseEntity<ProdutoResponseDto> responseDto =
                restTemplate.exchange(
                        "/produtos",
                        HttpMethod.POST,
                        new HttpEntity<>(requestDto),
                        ProdutoResponseDto.class);

        Long idProduto = responseDto.getBody().getId();

        ResponseEntity<ProdutoResponseDtoTeste> responseGetDto =
                restTemplate.exchange(
                        "/produtos/" + idProduto,
                        HttpMethod.GET,
                        null,
                        ProdutoResponseDtoTeste.class);

        ProdutoResponseDtoTeste responseBody = responseGetDto.getBody();

        Assertions.assertEquals(200, responseGetDto.getStatusCode().value());
        Assertions.assertEquals(idProduto, responseBody.getId());
        Assertions.assertEquals(requestDto.getNome(), responseBody.getNome());
        Assertions.assertEquals(requestDto.getQuantidade(), responseBody.getQuantidade());
    }

    @Test
    void atualizar_produto() {

        ProdutoSalvarRequestDto requestDto = new ProdutoSalvarRequestDto()
                .setNome("produto test atualizar")
                .setQuantidade(10);

        ResponseEntity<ProdutoResponseDto> responseDto =
                restTemplate.exchange(
                        "/produtos",
                        HttpMethod.POST,
                        new HttpEntity<>(requestDto),
                        ProdutoResponseDto.class);

        Long idProduto = responseDto.getBody().getId();

        requestDto.setNome("Produto atualizado");
        requestDto.setQuantidade(20);

        ResponseEntity<ProdutoResponseDtoTeste> responseGetDto =
                restTemplate.exchange(
                        "/produtos/" + idProduto,
                        HttpMethod.PUT,
                        new HttpEntity<>(requestDto),
                        ProdutoResponseDtoTeste.class);

        ProdutoResponseDtoTeste responseBody = responseGetDto.getBody();

        Assertions.assertEquals(200, responseGetDto.getStatusCode().value());
        Assertions.assertEquals(idProduto, responseBody.getId());
        Assertions.assertEquals(requestDto.getNome(), responseBody.getNome());
        Assertions.assertEquals(requestDto.getQuantidade(), responseBody.getQuantidade());
    }

    @Test
    void deletar_produto() {

        ProdutoSalvarRequestDto requestDto = new ProdutoSalvarRequestDto()
                .setNome("produto test deletar")
                .setQuantidade(10);

        ResponseEntity<ProdutoResponseDto> responseDto =
                restTemplate.exchange(
                        "/produtos",
                        HttpMethod.POST,
                        new HttpEntity<>(requestDto),
                        ProdutoResponseDto.class);

        Long idProduto = responseDto.getBody().getId();

        ResponseEntity<ProdutoResponseDtoTeste> responseDeleteDto =
                restTemplate.exchange(
                        "/produtos/" + idProduto,
                        HttpMethod.DELETE,
                        new HttpEntity<>(requestDto),
                        ProdutoResponseDtoTeste.class);

        Assertions.assertEquals(202, responseDeleteDto.getStatusCode().value());

        ResponseEntity<ProdutoResponseDtoTeste> responseGetDto =
                restTemplate.exchange(
                        "/produtos/" + idProduto,
                        HttpMethod.GET,
                        null,
                        ProdutoResponseDtoTeste.class);

        ProdutoResponseDtoTeste responseBody = responseGetDto.getBody();

        Assertions.assertEquals(500, responseGetDto.getStatusCode().value());
        Assertions.assertEquals(null, responseBody.getId());
    }

    @Test
    void teste_not_found_exception() {
        String teste = "teste";
        NotFoundException resultTeste = new NotFoundException(teste);
        Assertions.assertEquals("teste", resultTeste.getLocalizedMessage());
    }

    @Test
    void teste_validation_exception() {
        String teste = "teste";
        ValidationException resultTeste = new ValidationException(teste);
        Assertions.assertEquals("teste", resultTeste.getMessage());
    }
}
