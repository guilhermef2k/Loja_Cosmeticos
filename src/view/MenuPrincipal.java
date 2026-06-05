package view;

import java.util.Scanner;

public class MenuPrincipal {

    private Scanner sc = new Scanner(System.in);

    public void exibir() {

        int opcao;

        do {

            System.out.println("\n===== SISTEMA =====");
            System.out.println("1 - Usuários");
            System.out.println("2 - Produtos");
            System.out.println("3 - Transações");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = sc.nextInt();

            switch (opcao) {

                case 1:
                    UsuarioView usuarioView = new UsuarioView();
                    usuarioView.menuUsuarios();
                    break;

                case 2:
                    ProdutoView produtoView = new ProdutoView();
                    produtoView.menuProdutos();
                    break;

                case 3:
                    TransacaoView transacaoView = new TransacaoView();
                    transacaoView.menuTransacoes();
                    break;

                case 0:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }
}