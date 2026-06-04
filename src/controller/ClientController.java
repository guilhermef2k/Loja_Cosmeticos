package controller;
import model.Cliente;
import service.ClientService;


public class ClientController {
    private ClientService clientService;

    public ClientController() {
        this.clientService = new ClientService();
    }

    public void criar(String nome, String email, String senha, String cpf, String endereco, String telefone) {
        System.out.println(clientService.criarClient(nome, email, senha, cpf, endereco, telefone));
    }

    public void editar(String cpf, String nome, String email, String senha, String endereco, String telefone) {
        System.out.println(clientService.editarClient(cpf, nome, email, senha, endereco, telefone));
    }

    public void buscarPorCpf(String cpf) {
        Cliente client = clientService.buscarClientPorCpf(cpf);

        if (client == null) {
            System.out.println("✗ Cliente com CPF " + cpf + " não encontrado");
        } else {
            System.out.println("Cliente encontrado: " + client.getNome());
        }
    }

    public void listar() {
        clientService.listarTodosClients();
    }

    public void deletar(String cpf) {
        System.out.println(clientService.deletarClient(cpf));
    }

    public void atualizarEndereco(String cpf, String novoEndereco) {
        System.out.println(clientService.atualizarEndereco(cpf, novoEndereco));
    }

    public void atualizarTelefone(String cpf, String novoTelefone) {
        System.out.println(clientService.atualizarTelefone(cpf, novoTelefone));
    }
}
