package service;

import java.util.List;

import model.ItemTransacao;
import model.Produto;
import model.Transacao;
import repository.TransacaoRepository;

public class TransacaoService {
    private TransacaoRepository transacaoRepository;

    public TransacaoService(TransacaoRepository transacaoRepository) {
        if (transacaoRepository == null) {
            throw new IllegalArgumentException("O repositório de transações não pode ser nulo.");
        }

        this.transacaoRepository = transacaoRepository;
    }

    public double calcularValorTotal(Transacao transacao) {
        validarTransacao(transacao);

        double total = 0.0;

        for (ItemTransacao item : transacao.getItens()) {
            total += item.calcularSubtotal();
        }

        return total;
    }

    public void concluirTransacao(Transacao transacao) {
        validarTransacao(transacao);

        if (transacao.getItens().isEmpty()) {
            throw new IllegalArgumentException("A transação deve possuir pelo menos um item.");
        }

        if (transacao.getTipo() == Transacao.TipoTransacao.VENDA) {
            validarEstoqueDisponivel(transacao);
            baixarEstoque(transacao);
        } else {
            reporEstoque(transacao);
        }

        transacao.calcularValorTotal();
        transacaoRepository.salvar(transacao);
    }

    public List<Transacao> listarHistorico() {
        return transacaoRepository.listar();
    }

    private void validarEstoqueDisponivel(Transacao transacao) {
        for (ItemTransacao item : transacao.getItens()) {
            Produto produto = item.getProduto();

            if (produto.getQuantidadeEstoque() < item.getQuantidade()) {
                throw new IllegalArgumentException(
                    "Estoque insuficiente para o produto: " + produto.getNome()
                );
            }
        }
    }

    private void baixarEstoque(Transacao transacao) {
        for (ItemTransacao item : transacao.getItens()) {
            Produto produto = item.getProduto();

            int novoEstoque = produto.getQuantidadeEstoque() - item.getQuantidade();
            produto.setQuantidadeEstoque(novoEstoque);
        }
    }

    private void reporEstoque(Transacao transacao) {
        for (ItemTransacao item : transacao.getItens()) {
            Produto produto = item.getProduto();

            int novoEstoque = produto.getQuantidadeEstoque() + item.getQuantidade();
            produto.setQuantidadeEstoque(novoEstoque);
        }
    }

    private void validarTransacao(Transacao transacao) {
        if (transacao == null) {
            throw new IllegalArgumentException("A transação não pode ser nula.");
        }
    }
}