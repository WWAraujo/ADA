package br.com.f1rst3.cadprodutos.controller;

import br.com.f1rst3.cadprodutos.dto.request.ProdutoSalvarRequestDto;
import br.com.f1rst3.cadprodutos.dto.response.ProdutoResponseDto;
import br.com.f1rst3.cadprodutos.model.ProdutoModel;
import br.com.f1rst3.cadprodutos.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoResponseDto salvar(@RequestBody ProdutoSalvarRequestDto resquesDto) {

        ProdutoModel produtoModel = new ProdutoModel()
                .setNome(resquesDto.getNome())
                .setQuantidade(resquesDto.getQuantidade());

        produtoModel = produtoService.salvar(produtoModel);

        ProdutoResponseDto responseDto = new ProdutoResponseDto()
                .setId(produtoModel.getId())
                .setNome(produtoModel.getNome())
                .setQuantidade(produtoModel.getQuantidade());

        return responseDto;
    }

    @GetMapping
    public List<ProdutoResponseDto> listarTodos(){

        List<ProdutoModel> produtoModels = produtoService.listarTodos();

        produtoModels.sort(((o1, o2) -> o2.getId().compareTo(o1.getId())));

        List<ProdutoResponseDto> produtoResponseDtoList = new ArrayList<>();

        for (ProdutoModel produtoModel : produtoModels ){
            ProdutoResponseDto produtoResponseDto = new ProdutoResponseDto()
                    .setId(produtoModel.getId())
                    .setNome(produtoModel.getNome())
                    .setQuantidade(produtoModel.getQuantidade());

            produtoResponseDtoList.add(produtoResponseDto);
        }

        return produtoResponseDtoList;
    }

    @GetMapping("/{idProduto}")
    @ResponseStatus(HttpStatus.OK)
    public ProdutoResponseDto getById(@PathVariable Long idProduto) {

        ProdutoModel produtoModel = produtoService.getById(idProduto);

        ProdutoResponseDto produtoSalvarRequestDto = new ProdutoResponseDto()
                .setId(produtoModel.getId())
                .setNome(produtoModel.getNome())
                .setQuantidade(produtoModel.getQuantidade());
        return produtoSalvarRequestDto;
    }
    @PutMapping("/{idProduto}")
    @ResponseStatus(HttpStatus.OK)
    public ProdutoResponseDto update(@PathVariable Long idProduto, @RequestBody ProdutoSalvarRequestDto requestDto) {

        ProdutoModel produtoModel = new ProdutoModel()
                .setId(idProduto)
                .setNome(requestDto.getNome())
                .setQuantidade(requestDto.getQuantidade());

        produtoModel = produtoService.salvar(produtoModel);
        ProdutoResponseDto resposeDto = new ProdutoResponseDto()
                .setId(produtoModel.getId())
                .setNome(produtoModel.getNome())
                .setQuantidade(produtoModel.getQuantidade());

        return resposeDto;}
    @DeleteMapping("/{idProduto}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable Long idProduto) {

         produtoService.excluir(idProduto);
    }
}
