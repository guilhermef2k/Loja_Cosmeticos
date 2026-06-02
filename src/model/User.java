import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String email;
    private String password;
    private String cpf;
    private boolean ativo;

    public User(String name, String email, String password, String cpf,boolean ativo) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.ativo = ativo;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    public void criarUsuario(String name, String email, String password, String cpf, boolean ativo) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.ativo = ativo;
    }
    public void editarUsuario(String name, String email, String password, String cpf, boolean ativo) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.ativo = ativo;
    }
    public void deletarUsuario(User usuario) {
        listaUsuarios.remove(usuario);
    }
    public void adicionarUsuario(User usuario) {
        listaUsuarios.add(usuario);
    }
    public void verUsuario() {
        System.out.println("Nome: " + name);
        System.out.println("Email: " + email);
        System.out.println("CPF: " + cpf);
        System.out.println("Ativo: " + ativo);
    }
    private static List<User> listaUsuarios = new ArrayList<User>();
    public void listarUsuarios() {
        for (User usuario : listaUsuarios) {
            usuario.verUsuario();
        }
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
