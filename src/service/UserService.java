public class UserService {
    private UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();
    }

    public void criarUser(String name, String email, String password, String cpf, boolean ativo) {
        User user = new User(name, email, password, cpf, ativo);
        userRepository.salvar(user);
    }

    public void autenticarUser(String cpf, String password) throws UserNotFoundException, InvalidCredentialsException {
        User user = userRepository.findByCpf(cpf);
        
        if (!user.getPassword().equals(password)) {
            throw new InvalidCredentialsException("Senha incorreta");
        }
        
        user.setAtivo(true);
        try {
            userRepository.atualizar(user);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void desativarUser(String cpf) throws UserNotFoundException {
        User user = userRepository.findByCpf(cpf);
        user.setAtivo(false);
        userRepository.atualizar(user);
    }

    public void editarUser(String cpf, String name, String email, String password, boolean ativo) throws UserNotFoundException {
        User user = userRepository.findByCpf(cpf);
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setAtivo(ativo);
        userRepository.atualizar(user);
    }

    public User buscarUserPorCpf(String cpf) throws UserNotFoundException {
        return userRepository.findByCpf(cpf);
    }

    public User buscarUserPorEmail(String email) throws UserNotFoundException {
        return userRepository.findByEmail(email);
    }

    public void listarTodosUsers() {
        for (User usuario : userRepository.listarTodos()) {
            System.out.println("==== Usuário ====");
            System.out.println("Nome: " + usuario.getName());
            System.out.println("Email: " + usuario.getEmail());
            System.out.println("CPF: " + usuario.getCpf());
            System.out.println("Tipo: " + getTipoUsuario(usuario));
            System.out.println("Ativo: " + usuario.isAtivo());
        }
    }

    private String getTipoUsuario(User usuario) {
        if (usuario instanceof Funcionario) {
            return "Funcionário";
        }
        if (usuario instanceof Client) {
            return "Cliente";
        }
        return "Usuário";
    }

    public void deletarUser(String cpf) throws UserNotFoundException {
        userRepository.deletar(cpf);
    }
}
