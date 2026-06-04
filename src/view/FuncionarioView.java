package view;

import java.util.Scanner;
import controller.FuncionarioController;

public class FuncionarioView {

    private Scanner sc = new Scanner(System.in);
    private FuncionarioController controller = new FuncionarioController();

    public void menuFuncionarios() {

        int opcao;

        do {

            System.out.println("\n===== FUNCIONÁRIOS =====");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Buscar por CPF");
            System.out.println("4 - Editar");
            System.out.println("5 - Excluir");
            System.out.println("0 - Voltar");
            System.out.print("Opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Senha: ");
                    String senha = sc.nextLine();

                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();

                    System.out.print("Cargo: ");
                    String cargo = sc.nextLine();

                    controller.criar(
                            nome,
                            email,
                            senha,
                            cpf,
                            cargo);

                    break;

                case 2:

                    controller.listar();

                    break;

                case 3:

                    System.out.print("CPF: ");
                    cpf = sc.nextLine();

                    controller.buscarPorCpf(cpf);

                    break;

                case 4:

                    System.out.print("CPF do funcionário: ");
                    cpf = sc.nextLine();

                    System.out.print("Novo nome: ");
                    nome = sc.nextLine();

                    System.out.print("Novo email: ");
                    email = sc.nextLine();

                    System.out.print("Nova senha: ");
                    senha = sc.nextLine();

                    System.out.print("Novo cargo: ");
                    cargo = sc.nextLine();

                    controller.editar(
                    cpf,
                    nome,
                    email,
                    senha,
                    cargo);

                    break;    

                case 5:

                    System.out.print("CPF: ");
                    cpf = sc.nextLine();

                    controller.deletar(cpf);

                    break;

                case 0:

                    break;

                default:

                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }
}