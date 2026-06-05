package model;

public class Produto {
    private String nome;
    private String codigo;
    private String marca;
    private String categoria;
    private Double precoCusto;      
    private Double precoVenda;      
    private int estoque;
    private int estoqueMin;

    public Produto(String nome, String codigo, String marca, String categoria, Double precoCusto, Double precoVenda, int estoque, int estoqueMin){
        this.nome = nome;
        this.codigo = codigo;
        this.marca = marca;
        this.categoria = categoria;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.estoque = estoque;
        this.estoqueMin = estoqueMin;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public int getEstoqueMin() {
        return estoqueMin;
    }

    public void setEstoqueMin(int estoqueMin) {
        this.estoqueMin = estoqueMin;
    }

    @Override
    public String toString() {
        return "Produto [" + codigo + "] - " + nome + " (" + marca + ")\n Categoria: " + categoria + "\nPreço: R$ " + precoVenda + " | Estoque: " + estoque;
    }
}
