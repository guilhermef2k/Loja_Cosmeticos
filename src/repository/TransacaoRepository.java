package repository;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import model.ItemTransacao;
import model.Transacao;

public class TransacaoRepository {
    private static final Path CAMINHO_ARQUIVO = Paths.get("data", "transacoes.txt");

    private List<Transacao> transacoes;

    public TransacaoRepository() {
        this.transacoes = new ArrayList<>();
        criarArquivoSeNecessario();
    }

    public void salvar(Transacao transacao) {
        if (transacao == null) {
            throw new IllegalArgumentException("A transação não pode ser nula.");
        }

        transacoes.add(transacao);
        salvarNoArquivo(transacao);
    }

    public List<Transacao> listar() {
        return new ArrayList<>(transacoes);
    }

    public List<String> listarRegistrosArquivo() {
        criarArquivoSeNecessario();

        try {
            return Files.readAllLines(CAMINHO_ARQUIVO, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler o arquivo de transações.", e);
        }
    }

    private void salvarNoArquivo(Transacao transacao) {
        criarArquivoSeNecessario();

        try (BufferedWriter writer = Files.newBufferedWriter(
                CAMINHO_ARQUIVO,
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
        )) {
            writer.write(converterTransacaoParaLinha(transacao));
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar a transação no arquivo.", e);
        }
    }

    private void criarArquivoSeNecessario() {
        try {
            Files.createDirectories(CAMINHO_ARQUIVO.getParent());

            if (!Files.exists(CAMINHO_ARQUIVO)) {
                Files.createFile(CAMINHO_ARQUIVO);
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao criar o arquivo de transações.", e);
        }
    }

    private String converterTransacaoParaLinha(Transacao transacao) {
        String cliente = transacao.getCliente() != null
                ? limparTexto(String.valueOf(transacao.getCliente()))
                : "";

        String funcionario = transacao.getFuncionario() != null
                ? limparTexto(String.valueOf(transacao.getFuncionario()))
                : "";

        String itens = converterItensParaTexto(transacao);

        return limparTexto(transacao.getId()) + ";"
                + transacao.getTipo() + ";"
                + transacao.getDataTransacao() + ";"
                + cliente + ";"
                + funcionario + ";"
                + transacao.getValorTotal() + ";"
                + itens;
    }

    private String converterItensParaTexto(Transacao transacao) {
        StringBuilder builder = new StringBuilder();

        for (ItemTransacao item : transacao.getItens()) {
            if (builder.length() > 0) {
                builder.append("|");
            }

            String nomeProduto = item.getProduto() != null
                    ? item.getProduto().getNome()
                    : "produto_sem_nome";

            builder.append(limparTexto(nomeProduto))
                    .append(",")
                    .append(item.getQuantidade())
                    .append(",")
                    .append(item.getPrecoUnitario())
                    .append(",")
                    .append(item.calcularSubtotal());
        }

        return builder.toString();
    }

    private String limparTexto(String texto) {
        if (texto == null) {
            return "";
        }

        return texto
                .replace(";", " ")
                .replace("|", " ")
                .replace(",", " ")
                .replace("\n", " ")
                .replace("\r", " ");
    }
}