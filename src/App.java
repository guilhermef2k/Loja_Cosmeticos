import controller.ClientController;
import controller.FuncionarioController;

public class App {
    public static void main(String[] args) throws Exception {
        ClientController clientController = new ClientController();
         System.out.println("\n--- TESTE DE CLIENTE ---");
        clientController.criar("Maria Silva", "maria@email.com", "123456", "11122233344", "Rua das Flores, 100", "84999990000");
        clientController.criar("Maria Silva", "maria@email.com", "123456", "11122233344", "Rua das Flores, 100", "84999990000");
        clientController.buscarPorCpf("11122233344");        
        clientController.editar("11122233344", "Maria Souza", "maria.souza@email.com", "654321", "Av. Central, 200", "84988880000");        
        clientController.atualizarEndereco("11122233344", "Rua Nova, 300");        
        clientController.atualizarTelefone("11122233344", "84977770000");       
        clientController.listar();
        clientController.deletar("11122233344");
        clientController.buscarPorCpf("11122233344");

        System.out.println("\n--- TESTE DE FUNCIONARIO ---");
        FuncionarioController funcionarioController = new FuncionarioController();
        funcionarioController.criar("João Pereira", "joao@email.com", "123456", "55566677788", "Vendedor");
        funcionarioController.criar("João Pereira", "joao@email.com", "123456", "55566677788", "Vendedor");
        funcionarioController.buscarPorCpf("55566677788");
        funcionarioController.editar("55566677788", "João Pereira", "joao.pereira@email.com", "654321", "Caixa");
        funcionarioController.atualizarCargo("55566677788", "Gerente");
        funcionarioController.atualizarCargo("55566677788", "Vendedor");
        funcionarioController.deletar("55566677788");
        funcionarioController.buscarPorCpf("55566677788");
    }




}