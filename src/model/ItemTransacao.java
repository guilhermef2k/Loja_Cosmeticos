package model;

public class ItemTransacao {
    private Produto produto;
    private int quantidade;
    private double precoUnitario;

    // Construtor
    public ItemTransacao(Produto produto, int quantidade, double precoUnitario) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    // Getters
    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    // Setters
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    // Método de cálculo
    public double calcularSubtotal() {
        return quantidade * precoUnitario;
    }

    // toString para visualização
    @Override
    public String toString() {
        return "ItemTransacao{" +
                "produto=" + produto.getNome() +
                ", quantidade=" + quantidade +
                ", precoUnitario=" + precoUnitario +
                ", subtotal=" + calcularSubtotal() +
                '}';
    }
}