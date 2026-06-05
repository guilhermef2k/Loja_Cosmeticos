package controller;
import java.util.List;

import model.Produto;
import service.ProdutoService;;

public class ProdutoController {
    private ProdutoService service;

    public ProdutoController(){
        this.service = new ProdutoService();
    }

    public String cadastrarProduto(String codigo, String nome, String marca, String categoria, double precoCusto, double precoVenda, int estoque, int estoqueMin) {
        try {
            Produto produto = new Produto(codigo, nome, marca, categoria, precoCusto, precoVenda, estoque, estoqueMin);
            service.cadastrarProduto(produto);
            return "Sucesso: Produto cadastrado corretamente!";
        } catch (IllegalArgumentException e) {
            return "Erro de Validação: " + e.getMessage();
        } catch (Exception e) {
            return "Erro Crítico: " + e.getMessage();
        }
    }

    public String editarProduto(String codigo, String nome, String marca, String categoria, double precoCusto, double precoVenda, int estoque, int estoqueMin) {
        try {
            Produto produtoAtualizado = new Produto(codigo, nome, marca, categoria, precoCusto, precoVenda, estoque, estoqueMin);
            service.editarProduto(produtoAtualizado);
            return "Sucesso: Produto atualizado corretamente!";
        } catch (IllegalArgumentException e) {
            return "Erro ao Editar: " + e.getMessage();
        }
    }

    public String excluirProduto(String codigo) {
        try {
            service.excluirProduto(codigo);
            return "Sucesso: Produto removido do sistema!";
        } catch (IllegalArgumentException e) {
            return "Erro ao Excluir: " + e.getMessage();
        }
    }

    public List<Produto> listarTodos() {
        return service.listarTodos();
    }

    public Produto buscarPorCodigo(String codigo) {
        return service.buscarPorCodigo(codigo);
    }
}
