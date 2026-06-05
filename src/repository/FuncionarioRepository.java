package repository;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Funcionario;


public class FuncionarioRepository {
    private static final String FILE_NAME = "FUncionarios.txt";
    private static List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();

    public FuncionarioRepository() {
        carregar();
    }

    private void carregar() {
        listaFuncionarios.clear();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";", -1);

                if (dados.length >= 6) {
                    Funcionario funcionario = new Funcionario(
                        dados[0],
                        dados[1],
                        dados[2],
                        dados[3],
                        Boolean.parseBoolean(dados[4]),
                        dados[5]
                    );
                    if (dados.length >= 7) {
                        funcionario.setCpfSupervisor(dados[6]);
                    }
                    listaFuncionarios.add(funcionario);
                }
            }
        } catch (IOException e) {
        }
    }

    public void salvar(Funcionario funcionario) {
        listaFuncionarios.add(funcionario);
        salvarNoArquivo();
    }

    private void salvarNoArquivo() {
        try {
            FileWriter fileWriter = new FileWriter(FILE_NAME);

            for (Funcionario funcionario : listaFuncionarios) {
                fileWriter.write(
                    funcionario.getNome() + ";" +
                    funcionario.getEmail() + ";" +
                    funcionario.getSenha() + ";" +
                    funcionario.getCpf() + ";" +
                    funcionario.isAtivo() + ";" +
                    funcionario.getCargo() + ";" +
                    funcionario.getCpfSupervisor() + "\n"
                );
            }

            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar funcionarios no arquivo.");
        }
    }

    public Funcionario findByCpf(String cpf) {
        for (Funcionario funcionario : listaFuncionarios) {
            if (funcionario.getCpf().equals(cpf)) {
                return funcionario;
            }
        }
        return null;
    }

    public boolean atualizar(Funcionario funcionario) {
        for (int i = 0; i < listaFuncionarios.size(); i++) {
            if (listaFuncionarios.get(i).getCpf().equals(funcionario.getCpf())) {
                listaFuncionarios.set(i, funcionario);
                salvarNoArquivo();
                return true;
            }
        }
        return false;
    }

    public boolean deletar(String cpf) {
        for (Funcionario funcionario : listaFuncionarios) {
            if (funcionario.getCpf().equals(cpf)) {
                listaFuncionarios.remove(funcionario);
                salvarNoArquivo();
                return true;
            }
        }
        return false;
    }

    public List<Funcionario> listarTodos() {
        return new ArrayList<Funcionario>(listaFuncionarios);
    }

    public void limpar() {
        listaFuncionarios.clear();
        salvarNoArquivo();
    }
}
