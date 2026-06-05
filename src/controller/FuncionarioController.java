package controller; 

import model.Funcionario;
import service.FuncionarioService;


public class FuncionarioController {
    private FuncionarioService funcionarioService;

    public FuncionarioController() {
        this.funcionarioService = new FuncionarioService();
    }

    public void criar(String nome, String email, String senha, String cpf, String cargo) {
        System.out.println(funcionarioService.criarFuncionario(nome, email, senha, cpf, cargo));
    }

    public void editar(String cpf, String nome, String email, String senha, String cargo) {
        System.out.println(funcionarioService.editarFuncionario(cpf, nome, email, senha, cargo));
    }

    public void buscarPorCpf(String cpf) {
        Funcionario funcionario = funcionarioService.buscarFuncionarioPorCpf(cpf);

        if (funcionario == null) {
            System.out.println("✗ Funcionário com CPF " + cpf + " não encontrado");
        } else {
            System.out.println("Funcionário encontrado: " + funcionario.getNome());
        }
    }

    public void listar() {
        funcionarioService.listarTodosFuncionarios();
    }

    public void deletar(String cpf) {
        System.out.println(funcionarioService.deletarFuncionario(cpf));
    }

    public void atualizarCargo(String cpf, String novoCargo) {
        System.out.println(funcionarioService.atualizarCargo(cpf, novoCargo));
    }

    public Funcionario login(String cpf, String senha) {
        return funcionarioService.logar(cpf, senha);
    }

    public void darAcesso(String supervisorCpf, String nome, String email, String senha, String cpf, String cargo) {
        System.out.println(funcionarioService.darAcesso(supervisorCpf, nome, email, senha, cpf, cargo));
    }

    public void listarSubordinados(String cpfSupervisor) {
        funcionarioService.listarSubordinados(cpfSupervisor);
    }
}
