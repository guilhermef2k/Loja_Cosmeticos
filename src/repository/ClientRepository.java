package repository;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;

public class ClientRepository {
    private static final String FILE_NAME = "clientes.txt";
    private static List<Cliente> listaClientes = new ArrayList<Cliente>();

    public ClientRepository() {
        carregar();
    }

    private void carregar() {
        listaClientes.clear();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";", -1);

                if (dados.length == 7) {
                    Cliente cliente = new Cliente(
                        dados[0],
                        dados[1],
                        dados[2],
                        dados[3],
                        Boolean.parseBoolean(dados[4]),
                        dados[5],
                        dados[6]
                    );
                    listaClientes.add(cliente);
                }
            }
        } catch (IOException e) {
        }
    }

    public void salvar(Cliente cliente) {
        listaClientes.add(cliente);
        salvarNoArquivo();
    }

    private void salvarNoArquivo() {
        try {
            FileWriter fileWriter = new FileWriter(FILE_NAME);

            for (Cliente cliente : listaClientes) {
                fileWriter.write(
                    cliente.getNome() + ";" +
                    cliente.getEmail() + ";" +
                    cliente.getSenha() + ";" +
                    cliente.getCpf() + ";" +
                    cliente.isAtivo() + ";" +
                    cliente.getEndereco() + ";" +
                    cliente.getTelefone() + "\n"
                );
            }

            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar clientes no arquivo.");
        }
    }

    public Cliente findByCpf(String cpf) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    public boolean atualizar(Cliente cliente) {
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getCpf().equals(cliente.getCpf())) {
                listaClientes.set(i, cliente);
                salvarNoArquivo();
                return true;
            }
        }
        return false;
    }

    public boolean deletar(String cpf) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getCpf().equals(cpf)) {
                listaClientes.remove(cliente);
                salvarNoArquivo();
                return true;
            }
        }
        return false;
    }

    public List<Cliente> listarTodos() {
        return new ArrayList<Cliente>(listaClientes);
    }

    public void limpar() {
        listaClientes.clear();
        salvarNoArquivo();
    }
}
