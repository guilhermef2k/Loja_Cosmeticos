package service;

import model.Funcionario;
import model.exceptions.FuncionarioNotFoundException;
import repository.FuncionarioRepository;

public class FuncionarioService {
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioService() {
        this.funcionarioRepository = new FuncionarioRepository();
    }

    public void criarFuncionario(String name, String email, String password, String cpf, String cargo) {
        Funcionario funcionario = new Funcionario(name, email, password, cpf, true, cargo);
        funcionarioRepository.salvar(funcionario);
    }

    public void editarFuncionario(String cpf, String name, String email, String password, String cargo) throws FuncionarioNotFoundException {
        Funcionario funcionario = funcionarioRepository.findByCpf(cpf);

        funcionario.setName(name);
        funcionario.setEmail(email);
        funcionario.setPassword(password);
        funcionario.setCargo(cargo);

        funcionarioRepository.atualizar(funcionario);
    }

    public Funcionario buscarFuncionarioPorCpf(String cpf) throws FuncionarioNotFoundException {
        return funcionarioRepository.findByCpf(cpf);
    }

    public void listarTodosFuncionarios() {
        for (Funcionario funcionario : funcionarioRepository.listarTodos()) {
            System.out.println("==== Funcionário ====");
            System.out.println("Nome: " + funcionario.getName());
            System.out.println("Email: " + funcionario.getEmail());
            System.out.println("CPF: " + funcionario.getCpf());
            System.out.println("Cargo: " + funcionario.getCargo());
            System.out.println("Ativo: " + funcionario.isAtivo());
        }
    }

    public void deletarFuncionario(String cpf) throws FuncionarioNotFoundException {
        funcionarioRepository.deletar(cpf);
    }

    public void atualizarCargo(String cpf, String novoCargo) throws FuncionarioNotFoundException {
        Funcionario funcionario = funcionarioRepository.findByCpf(cpf);
        funcionario.setCargo(novoCargo);
        funcionarioRepository.atualizar(funcionario);
    }
}
