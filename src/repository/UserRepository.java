import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static List<User> listaUsuarios = new ArrayList<User>();

    public void salvar(User usuario) {
        listaUsuarios.add(usuario);
    }

    public User findByCpf(String cpf) throws UserNotFoundException {
        for (User usuario : listaUsuarios) {
            if (usuario.getCpf().equals(cpf)) {
                return usuario;
            }
        }
        throw new UserNotFoundException("Usuário com CPF " + cpf + " não encontrado");
    }

    public User findByEmail(String email) throws UserNotFoundException {
        for (User usuario : listaUsuarios) {
            if (usuario.getEmail().equals(email)) {
                return usuario;
            }
        }
        throw new UserNotFoundException("Usuário com email " + email + " não encontrado");
    }

    public void atualizar(User usuario) throws UserNotFoundException {
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (listaUsuarios.get(i).getCpf().equals(usuario.getCpf())) {
                listaUsuarios.set(i, usuario);
                return;
            }
        }
        throw new UserNotFoundException("Usuário não encontrado para atualizar");
    }

    public void deletar(String cpf) throws UserNotFoundException {
        for (User usuario : listaUsuarios) {
            if (usuario.getCpf().equals(cpf)) {
                listaUsuarios.remove(usuario);
                return;
            }
        }
        throw new UserNotFoundException("Usuário não encontrado para deletar");
    }

    public List<User> listarTodos() {
        return new ArrayList<User>(listaUsuarios);
    }

    public void limpar() {
        listaUsuarios.clear();
    }
}
