import java.util.ArrayList;
import java.util.List;

public class Funcionario extends User {
    private static List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
    private String cargo;

    public Funcionario(String name, String email, String password, String cpf, boolean ativo, String cargo) {
        super(name, email, password, cpf, ativo);
        this.cargo = cargo;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public void editarFuncionario(String name, String email, String password, String cpf, boolean ativo, String cargo) {
        editarUsuario(name, email, password, cpf, ativo);
        this.cargo = cargo;
    }
    public void adicionarFuncionario(Funcionario funcionario) {
        listaFuncionarios.add(funcionario);
    }

    public void listarFuncionarios() {
        for (Funcionario funcionario : listaFuncionarios) {
            funcionario.verFuncionario();
        }
    }
   public void verFuncionario() {
        System.out.println("Nome: " + getName());
        System.out.println("Email: " + getEmail());
        System.out.println("CPF: " + getCpf());
        System.out.println("Ativo: " + isAtivo());
        System.out.println("Cargo: " + getCargo());
    }

    public void deletarFuncionario(Funcionario funcionario) {
        listaFuncionarios.remove(funcionario);
    }
}
    
