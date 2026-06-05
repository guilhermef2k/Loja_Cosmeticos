package model;

public class ItemTransacao {
    private Produto produto;
    private int quantidade;
    private double precoUnitario;

    public ItemTransacao(Produto produto, int quantidade, double precoUnitario) {
        this.produto = produto;
        setQuantidade(quantidade);
        setPrecoUnitario(precoUnitario);
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        }
        this.quantidade = quantidade;
    }

    public void setPrecoUnitario(double precoUnitario) {
        if (precoUnitario < 0) {
            throw new IllegalArgumentException("O preço unitário não pode ser negativo.");
        }
        this.precoUnitario = precoUnitario;
    }

    public double calcularSubtotal() {
        return quantidade * precoUnitario;
    }

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