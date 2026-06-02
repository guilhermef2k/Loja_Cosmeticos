package controller;

import java.util.List;

import model.Cliente;
import model.Funcionario;
import model.ItemTransacao;
import model.Produto;
import model.Transacao;
import service.TransacaoService;

public class TransacaoController {
    private TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        if (transacaoService == null) {
            throw new IllegalArgumentException("O serviço de transações não pode ser nulo.");
        }

        this.transacaoService = transacaoService;
    }

    public Transacao iniciarVenda(String id, Cliente cliente) {
        return new Transacao(id, cliente);
    }

    public Transacao iniciarCompra(String id, Funcionario funcionario) {
        return new Transacao(id, funcionario);
    }

    public void adicionarItem(Transacao transacao, Produto produto, int quantidade, double precoUnitario) {
        if (transacao == null) {
            throw new IllegalArgumentException("A transação não pode ser nula.");
        }

        ItemTransacao item = new ItemTransacao(produto, quantidade, precoUnitario);
        transacao.adicionarItem(item);
    }

    public void removerItem(Transacao transacao, int indice) {
        if (transacao == null) {
            throw new IllegalArgumentException("A transação não pode ser nula.");
        }

        transacao.removerItem(indice);
    }

    public double calcularTotal(Transacao transacao) {
        return transacaoService.calcularValorTotal(transacao);
    }

    public void finalizarTransacao(Transacao transacao) {
        transacaoService.concluirTransacao(transacao);
    }

    public List<Transacao> listarHistorico() {
        return transacaoService.listarHistorico();
    }
}