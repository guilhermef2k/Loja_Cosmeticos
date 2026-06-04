package model;
public class Funcionario extends User {
    private String cargo;

    public Funcionario(String nome, String email, String senha, String cpf, boolean ativo, String cargo) {
        super(nome, email, senha, cpf, ativo);
        this.cargo = cargo;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
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
    }
}
    
