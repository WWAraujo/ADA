package br.com.f1rst3.cadprodutos;

import br.com.f1rst3.cadprodutos.model.ProdutoModel;
import br.com.f1rst3.cadprodutos.service.ProdutoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CadProdutoServiceTest {

    @Autowired
    private ProdutoService produtoService;

    @Test
    @DisplayName("Test - Inserir cliente - OK!")
    void inserir_produto_ok() {

        ProdutoModel produtoModel = new ProdutoModel()
                .setNome("Protudo test 1")
                .setQuantidade(5);

        ProdutoModel produtoModelSaved = produtoService.salvar(produtoModel);

        Assertions.assertNotNull(produtoModelSaved.getId());
        Assertions.assertEquals(produtoModel.getNome(), produtoModelSaved.getNome());
        Assertions.assertEquals(produtoModel.getQuantidade(), produtoModelSaved.getQuantidade());
    }

    @Test
    void excluir_produto() {

        ProdutoModel produtoModel = new ProdutoModel()
                .setNome("Protudo test")
                .setQuantidade(5);

        ProdutoModel produtoModelSaved = produtoService.salvar(produtoModel);

        Long idProduto = produtoModelSaved.getId();

        produtoService.excluir(idProduto);

        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            ProdutoModel produtoModelDeleted = produtoService.getById(idProduto);
        });

        Assertions.assertEquals("ID não encontrado", exception.getMessage());
    }


    @Test
    void get_id_invalido() {

        Exception exception = Assertions.assertThrows(Exception.class, () -> {
           ProdutoModel produtoModel = produtoService.getById(100);
        });

        Assertions.assertEquals("ID não encontrado", exception.getMessage());

    }

    @Test
    void quantidade_obrigatorio() {

        ProdutoModel produtoModel = new ProdutoModel();
        produtoModel.setNome("Produto teste");

        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            ProdutoModel produtoModelSaved = produtoService.salvar(produtoModel);
        });

        Assertions.assertEquals("A quantidade não foi informada", exception.getMessage());

    }

    @Test
    void nome_obrigatorio() {

        ProdutoModel produtoModel = new ProdutoModel();
        produtoModel.setQuantidade(5);

        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            ProdutoModel produtoModelSaved = produtoService.salvar(produtoModel);
        });

        Assertions.assertEquals("Nome é obrigatório", exception.getMessage());
    }

    @Test
    void get_by_id() {

        ProdutoModel produtoModel = new ProdutoModel();
        produtoModel.setNome("Produto test");
        produtoModel.setQuantidade(5);

        ProdutoModel produtoModelSaved = produtoService.salvar(produtoModel);

        Long idCliente = produtoModelSaved.getId();

        ProdutoModel produtoModelGet = produtoService.getById(idCliente);

        Assertions.assertEquals(produtoModelSaved.getId(), produtoModelGet.getId());
        Assertions.assertEquals(produtoModelSaved.getNome(), produtoModelGet.getNome());
        Assertions.assertEquals(produtoModelSaved.getQuantidade(), produtoModelGet.getQuantidade());

    }

}
