import java.util.ArrayList;
import java.util.List;

public class ClientRepository {
    private static List<Client> listaClientes = new ArrayList<Client>();

    public void salvar(Client cliente) {
        listaClientes.add(cliente);
    }

    public Client findByCpf(String cpf) throws ClientNotFoundException {
        for (Client cliente : listaClientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        throw new ClientNotFoundException("Cliente com CPF " + cpf + " não encontrado");
    }

    public void atualizar(Client cliente) throws ClientNotFoundException {
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getCpf().equals(cliente.getCpf())) {
                listaClientes.set(i, cliente);
                return;
            }
        }
        throw new ClientNotFoundException("Cliente não encontrado para atualizar");
    }

    public void deletar(String cpf) throws ClientNotFoundException {
        for (Client cliente : listaClientes) {
            if (cliente.getCpf().equals(cpf)) {
                listaClientes.remove(cliente);
                return;
            }
        }
        throw new ClientNotFoundException("Cliente não encontrado para deletar");
    }

    public List<Client> listarTodos() {
        return new ArrayList<Client>(listaClientes);
    }

    public void limpar() {
        listaClientes.clear();
    }
}
