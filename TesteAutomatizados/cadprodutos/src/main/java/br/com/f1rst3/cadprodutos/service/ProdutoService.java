package br.com.f1rst3.cadprodutos.service;

import br.com.f1rst3.cadprodutos.model.ProdutoModel;
import br.com.f1rst3.cadprodutos.repository.ProdutoRepositori;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    final ProdutoRepositori produtoRepositori;

    public ProdutoService(ProdutoRepositori produtoRepositori) {
        this.produtoRepositori = produtoRepositori;
    }

    public ProdutoModel salvar(ProdutoModel produtoModel) {
        if (produtoModel.getNome() == null){
            throw new RuntimeException("Nome é obrigatório");
        }
        if (produtoModel.getQuantidade() == null ){
            throw new RuntimeException("A quantidade não foi informada");
        }
        return produtoRepositori.save(produtoModel);
    }

    public void excluir(Long idProduto) {
        produtoRepositori.deleteById(idProduto);
    }
    public ProdutoModel getById(long idProduto) {
        ProdutoModel produtoModel = produtoRepositori.findById(idProduto).orElse(null);
        if (produtoModel == null) {
            throw new RuntimeException("ID não encontrado");
        }
        return produtoModel;
    }

    public List<ProdutoModel> listarTodos(){
        return produtoRepositori.findAll();
    }
}
