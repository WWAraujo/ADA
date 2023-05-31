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
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CadProdutoControllerTest {

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
    void listar_todos_produtos() {

        ProdutoSalvarRequestDto requestDto = new ProdutoSalvarRequestDto()
                .setNome("produto test listar 1")
                .setQuantidade(10);

        ResponseEntity<ProdutoResponseDto> responseDto =
                restTemplate.exchange(
                        "/produtos",
                        HttpMethod.POST,
                        new HttpEntity<>(requestDto),
                        ProdutoResponseDto.class);

        Long idProduto1 = responseDto.getBody().getId();

        requestDto = new ProdutoSalvarRequestDto()
                .setNome("produto test listar 2")
                .setQuantidade(20);

        responseDto =
                restTemplate.exchange(
                        "/produtos",
                        HttpMethod.POST,
                        new HttpEntity<>(requestDto),
                        ProdutoResponseDto.class);

        Long idProduto2 = responseDto.getBody().getId();

        ResponseEntity<List<ProdutoResponseDto>> responseGeDto =
                restTemplate.exchange(
                        "/produtos",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<ProdutoResponseDto>>() {
                        }
                );

        List<ProdutoResponseDto> produtoResponseDtoList = responseGeDto.getBody();

        Assertions.assertFalse(produtoResponseDtoList.isEmpty());

        boolean existsProduto1 = false;
        boolean existsProduto2 = false;
        for (ProdutoResponseDto produtoResponseDto : produtoResponseDtoList){
            if (produtoResponseDto.getId().equals(idProduto1)) {
                existsProduto1 = true;
            } else if (produtoResponseDto.getId().equals(idProduto2)){
                existsProduto2 = true;
            }
        }

        Assertions.assertTrue(existsProduto1);
        Assertions.assertTrue(existsProduto2);

        Assertions.assertTrue(
                produtoResponseDtoList.stream().anyMatch(produtoResponseDto -> produtoResponseDto.getId().equals(idProduto1))
        );

        Assertions.assertTrue(
                produtoResponseDtoList.stream().anyMatch(produtoResponseDto -> produtoResponseDto.getId().equals(idProduto2))
        );


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
