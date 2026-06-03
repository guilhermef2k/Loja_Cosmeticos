package model;
public class Funcionario extends User {
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
   public void verFuncionario() {
        System.out.println("Nome: " + getName());
        System.out.println("Email: " + getEmail());
        System.out.println("CPF: " + getCpf());
        System.out.println("Ativo: " + isAtivo());
        System.out.println("Cargo: " + getCargo());
    }
}
    
