package view;

import java.util.List;
import java.util.Scanner;
import controller.TransacaoController;
import model.Cliente;
import model.Funcionario;
import model.ItemTransacao;
import model.Produto;
import model.Transacao;
import service.ClientService;
import service.FuncionarioService;
import service.ProdutoService;
import service.TransacaoService;

public class TransacaoView {

    private Scanner sc;
    private TransacaoController controller;
    private ClientService clientService = new ClientService();
    private FuncionarioService funcionarioService = new FuncionarioService();
    private ProdutoService produtoService = new ProdutoService();
    private Transacao transacaoAtual;

    public TransacaoView(Scanner sc) {
        this.sc = sc;
        TransacaoService transacaoService = new TransacaoService();
        this.controller = new TransacaoController(transacaoService);
    }

    public void menuTransacoes() {

        int opcao;

        do {

            System.out.println("\n===== TRANSAÇÕES =====");
            System.out.println("1 - Iniciar Venda");
            System.out.println("2 - Iniciar Compra");
            System.out.println("3 - Adicionar Item");
            System.out.println("4 - Remover Item");
            System.out.println("5 - Calcular Total");
            System.out.println("6 - Finalizar Transação");
            System.out.println("7 - Listar Histórico");
            System.out.println("0 - Voltar");
            System.out.print("Opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:

                    System.out.print("ID da transação: ");
                    String id = sc.nextLine();

                    System.out.print("CPF do cliente: ");
                    String cpf = sc.nextLine();

                    Cliente cliente = clientService.buscarClientPorCpf(cpf);

                    if (cliente == null) {
                        System.out.println("Cliente não encontrado.");
                        break;
                    }

                    try {
                        transacaoAtual = controller.iniciarVenda(id, cliente);
                        System.out.println("Venda iniciada com sucesso.");
                    } catch (Exception e) {
                        System.out.println("Erro: " + e.getMessage());
                    }

                    break;

                case 2:

                    System.out.print("ID da transação: ");
                    id = sc.nextLine();

                    System.out.print("CPF do funcionário: ");
                    cpf = sc.nextLine();

                    Funcionario funcionario = funcionarioService.buscarFuncionarioPorCpf(cpf);

                    if (funcionario == null) {
                        System.out.println("Funcionário não encontrado.");
                        break;
                    }

                    try {
                        transacaoAtual = controller.iniciarCompra(id, funcionario);
                        System.out.println("Compra iniciada com sucesso.");
                    } catch (Exception e) {
                        System.out.println("Erro: " + e.getMessage());
                    }

                    break;

                case 3:

                    if (transacaoAtual == null) {
                        System.out.println("Nenhuma transação em andamento. Inicie uma venda ou compra primeiro.");
                        break;
                    }

                    System.out.print("Código do produto: ");
                    String codigo = sc.nextLine();

                    Produto produto = produtoService.buscarPorCodigo(codigo);

                    if (produto == null) {
                        System.out.println("Produto não encontrado.");
                        break;
                    }

                    System.out.print("Quantidade: ");
                    int quantidade = sc.nextInt();

                    System.out.print("Preço unitário: ");
                    double precoUnitario = sc.nextDouble();
                    sc.nextLine();

                    try {
                        controller.adicionarItem(transacaoAtual, produto, quantidade, precoUnitario);
                        System.out.println("Item adicionado.");
                    } catch (Exception e) {
                        System.out.println("Erro: " + e.getMessage());
                    }

                    break;

                case 4:

                    if (transacaoAtual == null) {
                        System.out.println("Nenhuma transação em andamento.");
                        break;
                    }

                    List<ItemTransacao> itens = transacaoAtual.getItens();

                    if (itens.isEmpty()) {
                        System.out.println("Nenhum item na transação.");
                        break;
                    }

                    System.out.println("Itens atuais:");
                    for (int i = 0; i < itens.size(); i++) {
                        System.out.println(i + " - " + itens.get(i));
                    }

                    System.out.print("Índice do item a remover: ");
                    int indice = sc.nextInt();
                    sc.nextLine();

                    try {
                        controller.removerItem(transacaoAtual, indice);
                        System.out.println("Item removido.");
                    } catch (Exception e) {
                        System.out.println("Erro: " + e.getMessage());
                    }

                    break;

                case 5:

                    if (transacaoAtual == null) {
                        System.out.println("Nenhuma transação em andamento.");
                        break;
                    }

                    double total = controller.calcularTotal(transacaoAtual);
                    System.out.println("Valor total: R$ " + String.format("%.2f", total));

                    break;

                case 6:

                    if (transacaoAtual == null) {
                        System.out.println("Nenhuma transação em andamento.");
                        break;
                    }

                    try {
                        controller.finalizarTransacao(transacaoAtual);
                        System.out.println("Transação finalizada com sucesso.");
                        transacaoAtual = null;
                    } catch (Exception e) {
                        System.out.println("Erro: " + e.getMessage());
                    }

                    break;

                case 7:

                    List<Transacao> historico = controller.listarHistorico();

                    if (historico.isEmpty()) {
                        System.out.println("Nenhuma transação no histórico.");
                    } else {
                        for (Transacao t : historico) {
                            System.out.println(t);
                            for (ItemTransacao item : t.getItens()) {
                                System.out.println("  " + item);
                            }
                            System.out.println("------------------------");
                        }
                    }

                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }
}
