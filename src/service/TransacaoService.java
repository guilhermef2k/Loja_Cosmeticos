package service;

import java.util.List;
import model.ItemTransacao;
import model.Produto;
import model.Transacao;
import repository.TransacaoRepository;
import model.Transacao.TipoTransacao;

public class TransacaoService {
    private TransacaoRepository transacaoRepository;
    private ProdutoService produtoService;

    public TransacaoService() {
        this.transacaoRepository = new TransacaoRepository();
        this.produtoService = new ProdutoService();
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
        validarEstoqueDisponivel(transacao);
        validarTransacao(transacao);

        for (ItemTransacao item : transacao.getItens()) {
            String codigo = item.getProduto().getCodigo();
            int quantidade = item.getQuantidade();

            if (transacao.getTipo().equals(TipoTransacao.VENDA)) { 
                produtoService.atualizarEstoque(codigo, -quantidade);
            } 
            else if (transacao.getTipo() == TipoTransacao.COMPRA) { 
                produtoService.atualizarEstoque(codigo, quantidade);
            }
        }

        transacaoRepository.salvar(transacao);
    }

    public List<Transacao> listarHistorico() {
        return transacaoRepository.listar();
    }

    private void validarEstoqueDisponivel(Transacao transacao) {
        for (ItemTransacao item : transacao.getItens()) {
            Produto produto = item.getProduto();

            if (produto.getEstoque() < item.getQuantidade()) {
                throw new IllegalArgumentException(
                    "Estoque insuficiente para o produto: " + produto.getNome()
                );
            }
        }
    }

    private void validarTransacao(Transacao transacao) {
        if (transacao == null || transacao.getItens() == null || transacao.getItens().isEmpty()) {
            throw new IllegalArgumentException("A transação não pode ser nula.");
        }
    }

    public void validarIdUnico(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("O ID da transação não pode ser vazio.");
        }

        if (transacaoRepository.existeTransacaoComId(id)) {
            throw new IllegalArgumentException("Já existe uma transação com o ID: " + id);
        }
    }
}