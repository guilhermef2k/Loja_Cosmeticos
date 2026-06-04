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

    public Funcionario logar(String cpf, String senha) {
        Funcionario funcionario = funcionarioRepository.findByCpf(cpf);
        if (funcionario != null && funcionario.getSenha().equals(senha) && funcionario.isAtivo()) {
            return funcionario;
        }
        return null;
    }

    public String darAcesso(String supervisorCpf, String nome, String email, String senha, String cpf, String cargo) {
        Funcionario supervisor = funcionarioRepository.findByCpf(supervisorCpf);
        if (supervisor == null) {
            return "✗ Supervisor com CPF " + supervisorCpf + " não encontrado";
        }
        if (!supervisor.podeDarAcesso(cargo)) {
            return "✗ " + supervisor.getCargo() + " não pode dar acesso a " + cargo;
        }
        if (funcionarioRepository.findByCpf(cpf) != null) {
            return "✗ Funcionário com CPF " + cpf + " já cadastrado";
        }
        Funcionario novo = new Funcionario(nome, email, senha, cpf, true, cargo);
        novo.setCpfSupervisor(supervisorCpf);
        funcionarioRepository.salvar(novo);
        return "✓ Acesso concedido para " + nome + " como " + cargo;
    }

    public void listarSubordinados(String cpfSupervisor) {
        for (Funcionario f : funcionarioRepository.listarTodos()) {
            if (f.getCpfSupervisor().equals(cpfSupervisor)) {
                System.out.println("CPF: " + f.getCpf() + " | Nome: " + f.getNome() + " | Cargo: " + f.getCargo());
            }
        }
    }
}
