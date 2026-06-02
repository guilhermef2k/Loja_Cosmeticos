package repository;

import java.util.ArrayList;
import java.util.List;
import model.Cliente;
public class ClientRepository {
    private static List<Cliente> listaClientes = new ArrayList<Cliente>();

    public void salvar(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public Cliente findByCpf(String cpf) throws ClientNotFoundException {
        for (Cliente cliente : listaClientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        throw new ClientNotFoundException("Cliente com CPF " + cpf + " não encontrado");
    }

    public void atualizar(Cliente cliente) throws ClientNotFoundException {
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getCpf().equals(cliente.getCpf())) {
                listaClientes.set(i, cliente);
                return;
            }
        }
        throw new ClientNotFoundException("Cliente não encontrado para atualizar");
    }

    public void deletar(String cpf) throws ClientNotFoundException {
        for (Cliente cliente : listaClientes) {
            if (cliente.getCpf().equals(cpf)) {
                listaClientes.remove(cliente);
                return;
            }
        }
        throw new ClientNotFoundException("Cliente não encontrado para deletar");
    }

    public List<Cliente> listarTodos() {
        return new ArrayList<Cliente>(listaClientes);
    }

    public void limpar() {
        listaClientes.clear();
    }
}
