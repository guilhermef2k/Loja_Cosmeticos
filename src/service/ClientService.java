public class ClientService {
    private ClientRepository clientRepository;

    public ClientService() {
        this.clientRepository = new ClientRepository();
    }

    public void criarClient(String name, String email, String password, String cpf, String endereco, String telefone) {
        Client client = new Client(name, email, password, cpf, true, endereco, telefone);
        clientRepository.salvar(client);
    }

    public void editarClient(String cpf, String name, String email, String password, String endereco, String telefone) throws ClientNotFoundException {
        Client client = clientRepository.findByCpf(cpf);
        
        client.setName(name);
        client.setEmail(email);
        client.setPassword(password);
        client.setEndereco(endereco);
        client.setTelefone(telefone);
        
        clientRepository.atualizar(client);
    }

    public Client buscarClientPorCpf(String cpf) throws ClientNotFoundException {
        return clientRepository.findByCpf(cpf);
    }

    public void listarTodosClients() {
        for (Client cliente : clientRepository.listarTodos()) {
            System.out.println("==== Cliente ====");
            System.out.println("Nome: " + cliente.getName());
            System.out.println("Email: " + cliente.getEmail());
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("Endereco: " + cliente.getEndereco());
            System.out.println("Telefone: " + cliente.getTelefone());
            System.out.println("Ativo: " + cliente.isAtivo());
        }
    }

    public void deletarClient(String cpf) throws ClientNotFoundException {
        clientRepository.deletar(cpf);
    }

    public void atualizarEndereco(String cpf, String novoEndereco) throws ClientNotFoundException {
        Client client = clientRepository.findByCpf(cpf);
        client.setEndereco(novoEndereco);
        clientRepository.atualizar(client);
    }

    public void atualizarTelefone(String cpf, String novoTelefone) throws ClientNotFoundException {
        Client client = clientRepository.findByCpf(cpf);
        client.setTelefone(novoTelefone);
        clientRepository.atualizar(client);
    }
}
