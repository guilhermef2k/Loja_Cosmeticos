package view;

import java.util.List;
import java.util.Scanner;
import controller.ProdutoController;
import model.Produto;

public class ProdutoView {

    private Scanner sc;
    private ProdutoController controller = new ProdutoController();

    public ProdutoView(Scanner sc) {
        this.sc = sc;
    }

    public void menuProdutos() {

        int opcao;

        do {

            System.out.println("\n===== PRODUTOS =====");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Buscar por Código");
            System.out.println("4 - Editar");
            System.out.println("5 - Excluir");
            System.out.println("0 - Voltar");
            System.out.print("Opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:

                    System.out.print("Código: ");
                    String codigo = sc.nextLine();

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Marca: ");
                    String marca = sc.nextLine();

                    System.out.print("Categoria: ");
                    String categoria = sc.nextLine();

                    System.out.print("Preço de Custo: ");
                    double precoCusto = sc.nextDouble();

                    System.out.print("Preço de Venda: ");
                    double precoVenda = sc.nextDouble();

                    System.out.print("Estoque: ");
                    int estoque = sc.nextInt();

                    System.out.print("Estoque Mínimo: ");
                    int estoqueMin = sc.nextInt();
                    sc.nextLine();

                    String resultado = controller.cadastrarProduto(codigo, nome, marca, categoria, precoCusto, precoVenda, estoque, estoqueMin);
                    System.out.println(resultado);

                    break;

                case 2:

                    List<Produto> produtos = controller.listarTodos();

                    if (produtos.isEmpty()) {
                        System.out.println("Nenhum produto cadastrado.");
                    } else {
                        for (Produto p : produtos) {
                            System.out.println(p);
                            System.out.println("------------------------");
                        }
                    }

                    break;

                case 3:

                    System.out.print("Código: ");
                    codigo = sc.nextLine();

                    Produto produto = controller.buscarPorCodigo(codigo);

                    if (produto == null) {
                        System.out.println("Produto não encontrado.");
                    } else {
                        System.out.println(produto);
                    }

                    break;

                case 4:

                    System.out.print("Código do produto: ");
                    codigo = sc.nextLine();

                    System.out.print("Novo nome: ");
                    nome = sc.nextLine();

                    System.out.print("Nova marca: ");
                    marca = sc.nextLine();

                    System.out.print("Nova categoria: ");
                    categoria = sc.nextLine();

                    System.out.print("Novo preço de custo: ");
                    precoCusto = sc.nextDouble();

                    System.out.print("Novo preço de venda: ");
                    precoVenda = sc.nextDouble();

                    System.out.print("Novo estoque: ");
                    estoque = sc.nextInt();

                    System.out.print("Novo estoque mínimo: ");
                    estoqueMin = sc.nextInt();
                    sc.nextLine();

                    resultado = controller.editarProduto(codigo, nome, marca, categoria, precoCusto, precoVenda, estoque, estoqueMin);
                    System.out.println(resultado);

                    break;

                case 5:

                    System.out.print("Código: ");
                    codigo = sc.nextLine();

                    resultado = controller.excluirProduto(codigo);
                    System.out.println(resultado);

                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }
}
