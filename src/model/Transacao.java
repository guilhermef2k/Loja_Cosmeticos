package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Transacao {

    public enum TipoTransacao {
        VENDA, COMPRA
    }

    private String id;
    private TipoTransacao tipo;
    private LocalDateTime dataTransacao;
    private List<ItemTransacao> itens;
    private Cliente cliente;
    private Funcionario funcionario;
    private double valorTotal;

    public Transacao(String id, Cliente cliente) {
        this.id = id;
        this.tipo = TipoTransacao.VENDA;
        this.cliente = cliente;
        this.funcionario = null;
        this.dataTransacao = LocalDateTime.now();
        this.itens = new ArrayList<>();
        this.valorTotal = 0.0;
    }

    public Transacao(String id, Funcionario funcionario) {
        this.id = id;
        this.tipo = TipoTransacao.COMPRA;
        this.funcionario = funcionario;
        this.cliente = null;
        this.dataTransacao = LocalDateTime.now();
        this.itens = new ArrayList<>();
        this.valorTotal = 0.0;
    }

    public String getId() {
        return id;
    }

    public TipoTransacao getTipo() {
        return tipo;
    }

    public LocalDateTime getDataTransacao() {
        return dataTransacao;
    }

    public List<ItemTransacao> getItens() {
        return new ArrayList<>(itens);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void adicionarItem(ItemTransacao item) {
        if (item == null) {
            throw new IllegalArgumentException("O item da transação não pode ser nulo.");
        }
        itens.add(item);
        calcularValorTotal();
    }

    public void removerItem(int indice) {
        if (indice < 0 || indice >= itens.size()) {
            throw new IllegalArgumentException("Índice inválido.");
        }
        itens.remove(indice);
        calcularValorTotal();
    }

    public void limparCarrinho() {
        itens.clear();
    }

    public void calcularValorTotal() {
        valorTotal = 0.0;
        for (ItemTransacao item : itens) {
            valorTotal += item.calcularSubtotal();
        }
    }

    public int getTotalItens() {
        return itens.size();
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "id='" + id + '\'' +
                ", tipo=" + tipo +
                ", dataTransacao=" + dataTransacao +
                ", totalItens=" + itens.size() +
                ", valorTotal=" + valorTotal +
                '}';
    }
}