import controller.ClientController;
import controller.FuncionarioController;
import controller.TransacaoController;
import controller.ProdutoController;
import model.Produto;
import model.Cliente;
import model.Funcionario;
import model.Transacao;


public class App {
    public static void main(String[] args) throws Exception {
        ClientController clientController = new ClientController();
        FuncionarioController funcionarioController = new FuncionarioController();
        TransacaoController transacaoController = new TransacaoController();
        ProdutoController produtoController = new ProdutoController();

        Produto produto1 = produtoController.buscarPorCodigo("BAT-001");
        Produto produto2 = produtoController.buscarPorCodigo("SHP-002");

        clientController.criar("Maria Silva", "maria@email.com", "123456", "11122233344", "Rua das Flores, 100", "84999990000");
        Cliente cliente = clientController.buscarPorCpf("11122233344");
        Funcionario funcionario = funcionarioController.buscarPorCpf("44466677788");

        
        System.out.println("\n--- INICIANDO FLUXO DE VENDA ---");
        Transacao venda = transacaoController.iniciarVenda("VND-007", cliente);

        System.out.println("Adicionando 2 Batons ao carrinho...");
        transacaoController.adicionarItem(venda, produto1, 2, produto1.getPrecoVenda());

        System.out.println("Adicionando 1 Shampoo ao carrinho...");
        transacaoController.adicionarItem(venda, produto2, 1, produto2.getPrecoVenda());

        double total = transacaoController.calcularTotal(venda);
        System.out.println("Total da Venda: R$ " + total);

        System.out.println("\n--- FINALIZANDO VENDA ---");
        try {
            transacaoController.finalizarTransacao(venda);
            System.out.println("Sucesso: Venda registrada e estoque atualizado!");
        } catch (Exception e) {
            System.out.println("Erro ao finalizar a transacao: " + e.getMessage());
        }

        System.out.println("\n--- ESTADO FINAL DO ESTOQUE ---");
        for (Produto produto : produtoController.listarTodos()) {
            System.out.println(produto.toString());
        }
    }
}