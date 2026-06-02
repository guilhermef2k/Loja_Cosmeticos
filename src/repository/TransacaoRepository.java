package repository;

import java.util.ArrayList;
import java.util.List;

import model.Transacao;

public class TransacaoRepository {
    private List<Transacao> transacoes;

    public TransacaoRepository() {
        this.transacoes = new ArrayList<>();
    }

    public void salvar(Transacao transacao) {
        if (transacao == null) {
            throw new IllegalArgumentException("A transação não pode ser nula.");
        }

        transacoes.add(transacao);
    }

    public List<Transacao> listar() {
        return new ArrayList<>(transacoes);
    }
}