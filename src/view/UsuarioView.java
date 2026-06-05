package view;

import java.util.Scanner;

public class UsuarioView {

    private Scanner sc = new Scanner(System.in);

    public void menuUsuarios() {

        int opcao;

        do {

            System.out.println("\n===== USUÁRIOS =====");
            System.out.println("1 - Clientes");
            System.out.println("2 - Funcionários");
            System.out.println("0 - Voltar");
            System.out.print("Opção: ");

            opcao = sc.nextInt();

            switch (opcao) {

                case 1:
                    ClienteView clienteView = new ClienteView();
                    clienteView.menuClientes();
                    break;

                case 2:
                    FuncionarioView funcionarioView = new FuncionarioView();
                    funcionarioView.menuFuncionarios();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }
}