import java.util.ArrayList;
import java.util.List;

public class FuncionarioRepository {
    private static List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();

    public void salvar(Funcionario funcionario) {
        listaFuncionarios.add(funcionario);
    }

    public Funcionario findByCpf(String cpf) throws FuncionarioNotFoundException {
        for (Funcionario funcionario : listaFuncionarios) {
            if (funcionario.getCpf().equals(cpf)) {
                return funcionario;
            }
        }
        throw new FuncionarioNotFoundException("Funcionário com CPF " + cpf + " não encontrado");
    }

    public void atualizar(Funcionario funcionario) throws FuncionarioNotFoundException {
        for (int i = 0; i < listaFuncionarios.size(); i++) {
            if (listaFuncionarios.get(i).getCpf().equals(funcionario.getCpf())) {
                listaFuncionarios.set(i, funcionario);
                return;
            }
        }
        throw new FuncionarioNotFoundException("Funcionário não encontrado para atualizar");
    }

    public void deletar(String cpf) throws FuncionarioNotFoundException {
        for (Funcionario funcionario : listaFuncionarios) {
            if (funcionario.getCpf().equals(cpf)) {
                listaFuncionarios.remove(funcionario);
                return;
            }
        }
        throw new FuncionarioNotFoundException("Funcionário não encontrado para deletar");
    }

    public List<Funcionario> listarTodos() {
        return new ArrayList<Funcionario>(listaFuncionarios);
    }

    public void limpar() {
        listaFuncionarios.clear();
    }
}
