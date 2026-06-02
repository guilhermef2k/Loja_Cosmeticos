public class ClientController {
    private ClientService clientService;

    public ClientController() {
        this.clientService = new ClientService();
    }

    public void criar(String name, String email, String password, String cpf, String endereco, String telefone) {
        try {
            clientService.criarClient(name, email, password, cpf, endereco, telefone);
            System.out.println("✓ Cliente criado com sucesso");
        } catch (Exception e) {
            System.out.println("✗ Erro ao criar cliente: " + e.getMessage());
        }
    }

    public void editar(String cpf, String name, String email, String password, String endereco, String telefone) {
        try {
            clientService.editarClient(cpf, name, email, password, endereco, telefone);
            System.out.println("✓ Cliente atualizado com sucesso");
        } catch (ClientNotFoundException e) {
            System.out.println("✗ Cliente não encontrado: " + e.getMessage());
        }
    }

    public void buscarPorCpf(String cpf) {
        try {
            Client client = clientService.buscarClientPorCpf(cpf);
            System.out.println("Cliente encontrado: " + client.getName());
        } catch (ClientNotFoundException e) {
            System.out.println("✗ " + e.getMessage());
        }
    }

    public void listar() {
        clientService.listarTodosClients();
    }

    public void deletar(String cpf) {
        try {
            clientService.deletarClient(cpf);
            System.out.println("✓ Cliente deletado com sucesso");
        } catch (ClientNotFoundException e) {
            System.out.println("✗ " + e.getMessage());
        }
    }

    public void atualizarEndereco(String cpf, String novoEndereco) {
        try {
            clientService.atualizarEndereco(cpf, novoEndereco);
            System.out.println("✓ Endereço atualizado com sucesso");
        } catch (ClientNotFoundException e) {
            System.out.println("✗ " + e.getMessage());
        }
    }

    public void atualizarTelefone(String cpf, String novoTelefone) {
        try {
            clientService.atualizarTelefone(cpf, novoTelefone);
            System.out.println("✓ Telefone atualizado com sucesso");
        } catch (ClientNotFoundException e) {
            System.out.println("✗ " + e.getMessage());
        }
    }
}
