public class Userctrl {
    private UserService userService;

    public Userctrl() {
        this.userService = new UserService();
    }

    public void criarUser(String name, String email, String password, String cpf, boolean ativo) {
        try {
            userService.criarUser(name, email, password, cpf, ativo);
            System.out.println("✓ Usuário criado com sucesso");
        } catch (Exception e) {
            System.out.println("✗ Erro ao criar usuário: " + e.getMessage());
        }
    }

    public void autenticar(String cpf, String password) {
        try {
            userService.autenticarUser(cpf, password);
            System.out.println("✓ Autenticação bem-sucedida");
        } catch (UserNotFoundException e) {
            System.out.println("✗ Usuário não encontrado: " + e.getMessage());
        } catch (InvalidCredentialsException e) {
            System.out.println("✗ Credenciais inválidas: " + e.getMessage());
        }
    }

    public void desativar(String cpf) {
        try {
            userService.desativarUser(cpf);
            System.out.println("✓ Usuário desativado");
        } catch (UserNotFoundException e) {
            System.out.println("✗ Usuário não encontrado: " + e.getMessage());
        }
    }

    public void editar(String cpf, String name, String email, String password, boolean ativo) {
        try {
            userService.editarUser(cpf, name, email, password, ativo);
            System.out.println("✓ Usuário atualizado com sucesso");
        } catch (UserNotFoundException e) {
            System.out.println("✗ Usuário não encontrado: " + e.getMessage());
        }
    }

    public void buscarPorCpf(String cpf) {
        try {
            User user = userService.buscarUserPorCpf(cpf);
            System.out.println("Usuário encontrado: " + user.getName());
        } catch (UserNotFoundException e) {
            System.out.println("✗ " + e.getMessage());
        }
    }

    public void listar() {
        userService.listarTodosUsers();
    }

    public void deletar(String cpf) {
        try {
            userService.deletarUser(cpf);
            System.out.println("✓ Usuário deletado com sucesso");
        } catch (UserNotFoundException e) {
            System.out.println("✗ " + e.getMessage());
        }
    }
}
