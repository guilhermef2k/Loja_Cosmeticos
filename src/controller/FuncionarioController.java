package controller; 

import model.Funcionario;
import model.exceptions.FuncionarioNotFoundException;
import service.FuncionarioService;


public class FuncionarioController {
    private FuncionarioService funcionarioService;

    public FuncionarioController() {
        this.funcionarioService = new FuncionarioService();
    }

    public void criar(String name, String email, String password, String cpf, String cargo) {
        try {
            funcionarioService.criarFuncionario(name, email, password, cpf, cargo);
            System.out.println("✓ Funcionário criado com sucesso");
        } catch (Exception e) {
            System.out.println("✗ Erro ao criar funcionário: " + e.getMessage());
        }
    }

    public void editar(String cpf, String name, String email, String password, String cargo) {
        try {
            funcionarioService.editarFuncionario(cpf, name, email, password, cargo);
            System.out.println("✓ Funcionário atualizado com sucesso");
        } catch (FuncionarioNotFoundException e) {
            System.out.println("✗ Funcionário não encontrado: " + e.getMessage());
        }
    }

    public void buscarPorCpf(String cpf) {
        try {
            Funcionario funcionario = funcionarioService.buscarFuncionarioPorCpf(cpf);
            System.out.println("Funcionário encontrado: " + funcionario.getName());
        } catch (FuncionarioNotFoundException e) {
            System.out.println("✗ " + e.getMessage());
        }
    }

    public void listar() {
        funcionarioService.listarTodosFuncionarios();
    }

    public void deletar(String cpf) {
        try {
            funcionarioService.deletarFuncionario(cpf);
            System.out.println("✓ Funcionário deletado com sucesso");
        } catch (FuncionarioNotFoundException e) {
            System.out.println("✗ " + e.getMessage());
        }
    }

    public void atualizarCargo(String cpf, String novoCargo) {
        try {
            funcionarioService.atualizarCargo(cpf, novoCargo);
            System.out.println("✓ Cargo atualizado com sucesso");
        } catch (FuncionarioNotFoundException e) {
            System.out.println("✗ " + e.getMessage());
        }
    }
}
