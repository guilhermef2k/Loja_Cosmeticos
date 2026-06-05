package view;

import java.util.Scanner;
import controller.ClientController;

public class ClienteView {

    private Scanner sc = new Scanner(System.in);
    private ClientController controller = new ClientController();

    public void menuClientes() {

        int opcao;

        do {

            System.out.println("\n===== CLIENTES =====");
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

                    System.out.print("Endereço: ");
                    String endereco = sc.nextLine();

                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();

                    controller.criar(
                            nome,
                            email,
                            senha,
                            cpf,
                            endereco,
                            telefone);

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

                    System.out.print("CPF do cliente: ");
                    cpf = sc.nextLine();

                    System.out.print("Novo nome: ");
                    nome = sc.nextLine();

                    System.out.print("Novo email: ");
                    email = sc.nextLine();

                    System.out.print("Nova senha: ");
                    senha = sc.nextLine();

                    System.out.print("Novo endereço: ");
                    endereco = sc.nextLine();

                    System.out.print("Novo telefone: ");
                    telefone = sc.nextLine();

                    controller.editar(
                    cpf,
                    nome,
                    email,
                    senha,
                    endereco,
                    telefone);

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