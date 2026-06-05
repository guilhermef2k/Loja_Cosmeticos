package service;

import java.util.List;
import model.Produto;
import repository.ProdutoRepository;

public class ProdutoService{
    private ProdutoRepository repository;

    public ProdutoService(){
        this.repository = new ProdutoRepository();
    }


    public void cadastrarProduto(Produto produto){
        validarDados(produto);

        if (repository.buscarProdutoPorCodigo(produto.getCodigo()) != null) {
            throw new IllegalArgumentException("Já existe um produto com esse código");
        }

        repository.adicionarProduto(produto);
    }

    public void editarProduto(Produto produto){
        validarDados(produto);

        if (repository.buscarProdutoPorCodigo(produto.getCodigo()) == null) {
            throw new IllegalArgumentException("Não existe um produto com esse código");
        }
        repository.editarProduto(produto);
    }
    
    public void excluirProduto(String codigo){
        if (repository.buscarProdutoPorCodigo(codigo) == null) {
            throw new IllegalArgumentException("Não existe um produto com esse código");
        }
        repository.excluirProduto(codigo);
    }
    public List<Produto> listarTodos(){
        return repository.listarProdutos();
    }

    public Produto buscarPorCodigo(String codigo){
        return repository.buscarProdutoPorCodigo(codigo);
    }

    public void atualizarEstoque(String codigo, int quantidade){
        Produto produto = repository.buscarProdutoPorCodigo(codigo);
        if (produto == null) {
            throw new IllegalArgumentException("Produto não encontrado para atualização de estoque");
        }
        int total = produto.getEstoque()+quantidade;
        if (total < 0) {
            throw new IllegalArgumentException("Estoque insuficiente");
        }
        produto.setEstoque(total);
        repository.editarProduto(produto);
    }
    private void validarDados(Produto produto){
        if (produto.getCodigo()==null || produto.getCodigo().trim().isEmpty()) {
            throw new IllegalArgumentException("O código do produto não pode ser vazio");
        }
        if (produto.getNome()==null || produto.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do produto não pode ser vazio");
        }
        if (produto.getMarca()==null || produto.getMarca().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome da marca não pode ser vazio");
        }
        if (produto.getCategoria()==null || produto.getCategoria().trim().isEmpty()) {
            throw new IllegalArgumentException("A categoria do produto não pode ser vazia");
        }

        if (produto.getPrecoCusto() <= 0) {
            throw new IllegalArgumentException("O preço de custo deve ser maior que 0");
        }
        if (produto.getPrecoVenda() < produto.getPrecoCusto()) {
            throw new IllegalArgumentException("O valor de venda não pode ser menor que o de custo");
        }

        if (produto.getEstoque() < 0) {
            throw new IllegalArgumentException("O estoque não pode ser negativo");
        }
        if (produto.getEstoqueMin() < 0) {
            throw new IllegalArgumentException("O estoque mínimo não pode ser negativo");
        }
    }
}


