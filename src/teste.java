package src;

public class teste {
    public static void main(String[] args) {
        Client cliente1 = new Client(
            "Joao",
            "joao@email.com",
            "123",
            "111.222.333-44",
            true,
            "Rua A",
            "99999-9999"
        );

        Client cliente2 = new Client(
            "Maria",
            "maria@email.com",
            "456",
            "555.666.777-88",
            true,
            "Rua B",
            "88888-8888"
        );

        cliente1.adicionarCliente(cliente1);
        cliente1.adicionarCliente(cliente2);

        System.out.println("Lista de clientes:");
        cliente1.listarClientes();

        System.out.println("Editando cliente:");
        cliente1.editarCliente("Joao Silva", "joao.silva@email.com", "789", "111.222.333-44", true);
        cliente1.verCliente();

        System.out.println("Deletando cliente:");
        cliente1.deletarCliente(cliente2);
        cliente1.listarClientes();

        Funcionario funcionario1 = new Funcionario(
            "Carlos",
            "carlos@email.com",
            "abc",
            "999.888.777-66",
            true,
            "Gerente"
        );

        funcionario1.adicionarFuncionario(funcionario1);

        System.out.println("Lista de funcionarios:");
        funcionario1.listarFuncionarios();
    }
} 
    

