package repository;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Produto;

public class ProdutoRepository {
    private List<Produto> produtos;
    private final String caminho = "produtos.txt"; 
    
    public ProdutoRepository(){
        this.produtos = new ArrayList<>();
        carregarDadosDoArquivo();
    }
    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
        salvarDadosNoArquivo();
    }
    public void editarProduto(Produto produtoAtualizado) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getCodigo().equals(produtoAtualizado.getCodigo())) {
                produtos.set(i, produtoAtualizado);
                salvarDadosNoArquivo();
                break;
            }
        }
    }
    public void excluirProduto(String codigo){
        boolean removido = this.produtos.removeIf(produto -> produto.getCodigo().equals(codigo));
        if (removido) {
            salvarDadosNoArquivo();
        }
    }
    public List<Produto> listarProdutos() {
        carregarDadosDoArquivo();
        return new ArrayList<>(this.produtos);
    }
    public Produto buscarProdutoPorCodigo(String codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo().equals(codigo)) {
                return produto;
            }
        }
        return null;
    }
    private void carregarDadosDoArquivo() {
        this.produtos.clear();
        File arquivo = new File(caminho);
        
        if (!arquivo.exists()) {
            return;
        }

        try (BufferedReader leitor = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                String[] dados = linha.split(";");
                
                String codigo = dados[0];
                String nome = dados[1];
                String marca = dados[2];
                String categoria = dados[3];
                double precoCusto = Double.parseDouble(dados[4]);
                double precoVenda = Double.parseDouble(dados[5]);
                int estoque = Integer.parseInt(dados[6]);
                int estoquemin = Integer.parseInt(dados[7]);
                
                Produto produto = new Produto(codigo, nome, marca, categoria, precoCusto, precoVenda, estoque, estoquemin);
                this.produtos.add(produto);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void salvarDadosNoArquivo(){
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(caminho))) {
            for (Produto produto : produtos) {
                escritor.write(produto.getCodigo() + ";" + 
                               produto.getNome() + ";" + 
                               produto.getMarca() + ";" +
                               produto.getCategoria() + ";" +
                               produto.getPrecoCusto() + ";" + 
                               produto.getPrecoVenda() + ";" + 
                               produto.getEstoque() + ";" +
                               produto.getEstoqueMin());
                escritor.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}