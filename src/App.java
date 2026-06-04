import controller.ClientController;
import controller.FuncionarioController;
import controller.ProdutoController;
import controller.TransacaoController;
import model.Produto;

public class App {

    public static void main(String[] args) {
        ProdutoController produtoController = new ProdutoController();
        ClientController clientController = new ClientController();
        FuncionarioController funcionarioController = new FuncionarioController();
        TransacaoController transacaoController = new TransacaoController();

        System.out.println("--- TESTE DE CADASTRO ---");
        String resultadoCadastro1 = produtoController.cadastrarProduto(
                "BAT-001", "Baton Matte", "Vult", "Maquiagem", 15.00, 35.00, 50, 10
        );
        System.out.println(resultadoCadastro1);

        String resultadoCadastro2 = produtoController.cadastrarProduto(
                "SHP-002", "Shampoo Neutro", "Granado", "Cabelo", 12.00, 28.00, 30, 5
        );
        System.out.println(resultadoCadastro2);


        System.out.println("--- TESTE DE CADASTRO DE USUÁRIOS---");

        funcionarioController.criar(
                "Guilherme", "guilherme@loja.com", "guilherme123", "123456789", "Gerente"
        );

        clientController.criar(
                "Maria Silva", "maria@email.com", "maria.silva", "senha123", "Rua das Flores, 123", "99999-0000"
        );

        System.out.println("\n--- ESTADO FINAL DO ESTOQUE ---");
        for (Produto produto : produtoController.listarTodos()) {
            System.out.println(produto.toString());
        }
        /*System.out.println("\n--- TESTE DE REGRAS DE NEGOCIO (ERRO ESPERADO) ---");
        String resultadoDuplicado = produtoController.cadastrarProduto(
                "BAT-001", "Outro Batom", "Mac", "Maquiagem", 10.00, 20.00, 10, 2
        );
        System.out.println(resultadoDuplicado);

        String resultadoPrecoInvalido = produtoController.cadastrarProduto(
                "PER-003", "Perfume Floral", "Natura", "Perfumaria", 100.00, 80.00, 10, 2
        );
        System.out.println(resultadoPrecoInvalido);

        System.out.println("\n--- TESTE DE LEITURA (LISTAGEM) ---");
        for (Produto produto : produtoController.listarTodos()) {
            System.out.println(produto.toString());
        }

        System.out.println("\n--- TESTE DE EDICAO ---");
        String resultadoEdicao = produtoController.editarProduto(
                "BAT-001", "Batom Matte Ultra", "Vult", "Maquiagem", 15.00, 39.90, 45, 10
        );
        System.out.println(resultadoEdicao);

        System.out.println("\n--- TESTE DE EXCLUSAO ---");
        String resultadoExclusao = produtoController.excluirProduto("SHP-002");
        System.out.println(resultadoExclusao);

        System.out.println("\n--- ESTADO FINAL DO ESTOQUE ---");
        for (Produto produto : produtoController.listarTodos()) {
            System.out.println(produto.toString());
        }*/
    }
}