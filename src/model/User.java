package model;
public class User {
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private boolean ativo;

    public User(String nome, String email, String senha, String cpf,boolean ativo) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.ativo = ativo;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void criarUsuario(String nome, String email, String senha, String cpf, boolean ativo) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.ativo = ativo;
    }
    public void editarUsuario(String nome, String email, String senha, String cpf, boolean ativo) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.ativo = ativo;
    }
    public void verUsuario() {
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("CPF: " + cpf);
        System.out.println("Ativo: " + ativo);
    }
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
