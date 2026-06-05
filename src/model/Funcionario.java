package model;
public class Funcionario extends User {
    public static final String CHEFE = "Chefe";
    public static final String GERENTE = "Gerente";
    public static final String VENDEDOR = "Vendedor";

    private String cargo;
    private String cpfSupervisor;

    public Funcionario(String nome, String email, String senha, String cpf, boolean ativo, String cargo) {
        super(nome, email, senha, cpf, ativo);
        this.cargo = cargo;
        this.cpfSupervisor = "";
    }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public String getCpfSupervisor() { return cpfSupervisor; }
    public void setCpfSupervisor(String cpfSupervisor) { this.cpfSupervisor = cpfSupervisor; }

    public boolean podeDarAcesso(String cargoAlvo) {
        if (cargo.equals(CHEFE)) {
            return cargoAlvo.equals(VENDEDOR) || cargoAlvo.equals(GERENTE);
        } else if (cargo.equals(GERENTE)) {
            return cargoAlvo.equals(VENDEDOR);
        }
        return false;
    }

    public void editarFuncionario(String nome, String email, String senha, String cpf, boolean ativo, String cargo) {
        editarUsuario(nome, email, senha, cpf, ativo);
        this.cargo = cargo;
    }

    public void verFuncionario() {
        System.out.println("Nome: " + getNome());
        System.out.println("Email: " + getEmail());
        System.out.println("CPF: " + getCpf());
        System.out.println("Ativo: " + isAtivo());
        System.out.println("Cargo: " + getCargo());
        System.out.println("Supervisor: " + (cpfSupervisor.isEmpty() ? "Nenhum" : cpfSupervisor));
    }
}
    
