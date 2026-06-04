package service;

import model.Funcionario;
import repository.FuncionarioRepository;

public class FuncionarioService {
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioService() {
        this.funcionarioRepository = new FuncionarioRepository();
    }

    public String criarFuncionario(String nome, String email, String senha, String cpf, String cargo) {
        if (funcionarioRepository.findByCpf(cpf) == null) {
            Funcionario funcionario = new Funcionario(nome, email, senha, cpf, true, cargo);
            funcionarioRepository.salvar(funcionario);
            return "✓ Funcionário criado com sucesso";
        } else {
            return "✗ Funcionário com CPF " + cpf + " já cadastrado";
        }
    }

    public String editarFuncionario(String cpf, String nome, String email, String senha, String cargo) {
        Funcionario funcionario = funcionarioRepository.findByCpf(cpf);

        if (funcionario == null) {
            return "✗ Funcionário com CPF " + cpf + " não encontrado";
        } else {
            funcionario.setNome(nome);
            funcionario.setEmail(email);
            funcionario.setSenha(senha);
            funcionario.setCargo(cargo);
            funcionarioRepository.atualizar(funcionario);
            return "✓ Funcionário atualizado com sucesso";
        }
    }

    public Funcionario buscarFuncionarioPorCpf(String cpf) {
        return funcionarioRepository.findByCpf(cpf);
    }

    public void listarTodosFuncionarios() {
        for (Funcionario funcionario : funcionarioRepository.listarTodos()) {
            System.out.println("==== Funcionário ====");
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Email: " + funcionario.getEmail());
            System.out.println("CPF: " + funcionario.getCpf());
            System.out.println("Cargo: " + funcionario.getCargo());
            System.out.println("Ativo: " + funcionario.isAtivo());
        }
    }

    public String deletarFuncionario(String cpf) {
        if (funcionarioRepository.deletar(cpf)) {
            return "✓ Funcionário deletado com sucesso";
        } else {
            return "✗ Funcionário com CPF " + cpf + " não encontrado";
        }
    }

    public String atualizarCargo(String cpf, String novoCargo) {
        Funcionario funcionario = funcionarioRepository.findByCpf(cpf);

        if (funcionario == null) {
            return "✗ Funcionário com CPF " + cpf + " não encontrado";
        } else {
            funcionario.setCargo(novoCargo);
            funcionarioRepository.atualizar(funcionario);
            return "✓ Cargo atualizado com sucesso";
        }
    }
}
