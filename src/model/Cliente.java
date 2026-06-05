package model;
public class Cliente extends User {
    private String endereco;
    private String telefone;

    public Cliente (String nome, String email, String senha, String cpf, boolean ativo, String endereco, String telefone) {
        super(nome, email, senha, cpf, ativo);
        this.endereco = endereco;
        this.telefone = telefone;
    }
   public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public void editarCliente(String nome, String email, String senha, String cpf, boolean ativo, String endereco, String telefone) {
        editarUsuario(nome, email, senha, cpf, ativo);
        this.endereco = endereco;
        this.telefone = telefone;
    }
    public void verCliente() {
        System.out.println("Nome: " + getNome());
        System.out.println("Email: " + getEmail());
        System.out.println("CPF: " + getCpf());
        System.out.println("Ativo: " + isAtivo());
        System.out.println("Endereco: " + getEndereco());
        System.out.println("Telefone: " + getTelefone());
    }
}
