package service;

import model.Cliente;
import repository.ClientRepository;

public class ClientService {
    private ClientRepository clientRepository;

    public ClientService() {
        this.clientRepository = new ClientRepository();
    }

    public String criarClient(String nome, String email, String senha, String cpf, String endereco, String telefone) {
        if (clientRepository.findByCpf(cpf) == null) {
            Cliente client = new Cliente(nome, email, senha, cpf, true, endereco, telefone);
            clientRepository.salvar(client);
            return "✓ Cliente criado com sucesso";
        } else {
            return "✗ Cliente com CPF " + cpf + " já cadastrado";
        }
    }

    public String editarClient(String cpf, String nome, String email, String senha, String endereco, String telefone) {
        Cliente client = clientRepository.findByCpf(cpf);

        if (client == null) {
            return "✗ Cliente com CPF " + cpf + " não encontrado";
        } else {
            client.setNome(nome);
            client.setEmail(email);
            client.setSenha(senha);
            client.setEndereco(endereco);
            client.setTelefone(telefone);
            clientRepository.atualizar(client);
            return "✓ Cliente atualizado com sucesso";
        }
    }

    public Cliente buscarClientPorCpf(String cpf) {
        return clientRepository.findByCpf(cpf);
    }

    public void listarTodosClients() {
        for (Cliente cliente : clientRepository.listarTodos()) {
            System.out.println("==== Cliente ====");
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Email: " + cliente.getEmail());
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("Endereco: " + cliente.getEndereco());
            System.out.println("Telefone: " + cliente.getTelefone());
            System.out.println("Ativo: " + cliente.isAtivo());
        }
    }

    public String deletarClient(String cpf) {
        if (clientRepository.deletar(cpf)) {
            return "✓ Cliente deletado com sucesso";
        } else {
            return "✗ Cliente com CPF " + cpf + " não encontrado";
        }
    }

    public String atualizarEndereco(String cpf, String novoEndereco) {
        Cliente client = clientRepository.findByCpf(cpf);

        if (client == null) {
            return "✗ Cliente com CPF " + cpf + " não encontrado";
        } else {
            client.setEndereco(novoEndereco);
            clientRepository.atualizar(client);
            return "✓ Endereço atualizado com sucesso";
        }
    }

    public String atualizarTelefone(String cpf, String novoTelefone) {
        Cliente client = clientRepository.findByCpf(cpf);

        if (client == null) {
            return "✗ Cliente com CPF " + cpf + " não encontrado";
        } else {
            client.setTelefone(novoTelefone);
            clientRepository.atualizar(client);
            return "✓ Telefone atualizado com sucesso";
        }
    }
}
