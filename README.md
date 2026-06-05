# Sistema de Gerenciamento - Loja de Cosméticos

Sistema de gerenciamento desenvolvido em **Java** para a disciplina de **Programação Orientada a Objetos (POO)**.

O projeto simula as principais operações de uma loja de cosméticos, incluindo cadastro de produtos, gerenciamento de clientes e funcionários, controle de estoque e registro de transações comerciais, como vendas e compras/reposições.

---

## Objetivo do Projeto

O objetivo do sistema é controlar as operações de uma loja de cosméticos de forma organizada, permitindo:

- Cadastrar e gerenciar produtos;
- Cadastrar e gerenciar clientes;
- Cadastrar e gerenciar funcionários;
- Registrar vendas com múltiplos itens;
- Registrar compras/reposições de estoque;
- Atualizar automaticamente o estoque após cada transação;
- Impedir vendas com quantidade insuficiente em estoque;
- Manter histórico das operações realizadas;
- Persistir os dados em arquivos `.txt`.

---

## Arquitetura do Sistema

O projeto foi desenvolvido utilizando o padrão **MVC (Model-View-Controller)**, com a adição das camadas **Service** e **Repository** para melhorar a separação de responsabilidades.

A estrutura geral segue o fluxo:

```text
View → Controller → Service → Repository → Model
```

### Model

A camada `model` representa as entidades principais do sistema.

Exemplos:

- `Produto`
- `Cliente`
- `Funcionario`
- `Transacao`
- `ItemTransacao`
- `TipoTransacao`

Essas classes armazenam os dados e comportamentos básicos dos objetos utilizados no sistema.

---

### Repository

A camada `repository` é responsável pela persistência dos dados.

Ela realiza operações como:

- Salvar dados em memória;
- Ler dados cadastrados;
- Salvar informações em arquivos `.txt`;
- Recuperar registros armazenados;
- Manter histórico das operações.

Exemplos:

- `ProdutoRepository`
- `ClientRepository`
- `FuncionarioRepository`
- `TransacaoRepository`

---

### Service

A camada `service` concentra as regras de negócio do sistema.

Ela é responsável por validações e processamentos, como:

- Verificar se um produto já existe;
- Validar dados de clientes e funcionários;
- Verificar estoque disponível;
- Atualizar estoque após vendas ou reposições;
- Calcular valores de transações;
- Impedir operações inválidas.

Exemplos:

- `ProdutoService`
- `ClientService`
- `FuncionarioService`
- `TransacaoService`

---

### Controller

A camada `controller` faz a ponte entre a interface do sistema e as regras de negócio.

Ela recebe as solicitações da interface e chama os métodos adequados da camada `service`.

Exemplos:

- `ProdutoController`
- `ClientController`
- `FuncionarioController`
- `TransacaoController`

---

### View

A camada `view`, quando presente, é responsável pela interação com o usuário.

Ela pode ser implementada por menus no terminal ou interface gráfica. No estado atual do projeto, a execução principal ocorre via terminal.

---

## Funcionalidades

### Módulo de Produtos

O módulo de produtos permite o gerenciamento dos cosméticos da loja.

Funcionalidades principais:

- Cadastrar produto;
- Editar produto;
- Remover produto;
- Buscar produto por código;
- Listar produtos;
- Atualizar estoque;
- Persistir produtos em arquivo `.txt`.

---

### Módulo de Usuários

O módulo de usuários contempla o gerenciamento de clientes e funcionários.

Funcionalidades principais:

- Cadastrar cliente;
- Editar cliente;
- Buscar cliente por CPF;
- Listar clientes;
- Remover cliente;
- Cadastrar funcionário;
- Editar funcionário;
- Buscar funcionário por CPF;
- Listar funcionários;
- Remover funcionário.

---

### Módulo de Transações

O módulo de transações é responsável pelo registro de vendas e compras/reposições.

Funcionalidades principais:

- Criar venda vinculada a um cliente;
- Criar compra/reposição vinculada a um funcionário;
- Adicionar múltiplos itens em uma mesma transação;
- Remover itens da transação;
- Calcular subtotal de cada item;
- Calcular total da transação;
- Validar estoque antes de finalizar uma venda;
- Bloquear venda com estoque insuficiente;
- Atualizar estoque após venda;
- Atualizar estoque após compra/reposição;
- Impedir transações com ID duplicado;
- Listar histórico de transações;
- Salvar histórico em arquivo `.txt`.

---

## Funcionamento das Transações

As transações funcionam com o conceito de **carrinho de compras**.

Uma transação pode conter vários itens, e cada item possui:

- Produto;
- Quantidade;
- Preço unitário;
- Subtotal.

Exemplo:

```text
Transacao
 ├── ItemTransacao 1 → Shampoo x2
 ├── ItemTransacao 2 → Perfume x1
 └── ItemTransacao 3 → Sabonete x3
```

Tipos de transação:

```text
VENDA  → reduz o estoque
COMPRA → aumenta o estoque
```

Durante a finalização de uma venda, o sistema verifica se existe estoque suficiente. Caso não exista, a operação é bloqueada.

---

## Persistência de Dados

O sistema utiliza arquivos `.txt` para salvar os dados de forma persistente.

Isso significa que as informações não ficam apenas em memória durante a execução do programa. Após o encerramento do sistema, os registros continuam armazenados nos arquivos correspondentes.

Exemplos de arquivos utilizados ou gerados:

```text
produtos.txt
data/transacoes.txt
src/repository/CLiente.txt
src/repository/FUncionario.txt
```

A persistência é feita na camada `repository`, mantendo a separação correta entre armazenamento, regras de negócio e controle do sistema.

---

## Estrutura do Projeto

Estrutura geral do projeto:

```text
Projeto_POO/
├── src/
│   ├── App.java
│   │
│   ├── controller/
│   │   ├── ClientController.java
│   │   ├── FuncionarioController.java
│   │   ├── ProdutoController.java
│   │   └── TransacaoController.java
│   │
│   ├── model/
│   │   ├── Cliente.java
│   │   ├── Funcionario.java
│   │   ├── Produto.java
│   │   ├── Transacao.java
│   │   ├── ItemTransacao.java
│   │   ├── TipoTransacao.java
│   │   └── User.java
│   │
│   ├── repository/
│   │   ├── ClientRepository.java
│   │   ├── FuncionarioRepository.java
│   │   ├── ProdutoRepository.java
│   │   └── TransacaoRepository.java
│   │
│   └── service/
│       ├── ClientService.java
│       ├── FuncionarioService.java
│       ├── ProdutoService.java
│       └── TransacaoService.java
│
├── produtos.txt
├── README.md
└── .gitignore
```

---

## Tecnologias Utilizadas

- **Java**
- **Programação Orientada a Objetos**
- **Arquitetura MVC**
- **Manipulação de arquivos `.txt`**
- **Git**
- **GitHub**
- **Visual Studio Code**
- **PowerShell**

O projeto foi desenvolvido sem uso de frameworks externos, utilizando apenas recursos da linguagem Java e bibliotecas padrão.

---

## Como Executar o Projeto

### 1. Pré-requisitos

Antes de executar o projeto, é necessário ter instalado:

- Java Development Kit (**JDK**)
- Git
- Uma IDE ou editor de código, como **Visual Studio Code**

Para verificar se o Java está instalado:

```bash
java -version
```

Para verificar se o compilador Java está instalado:

```bash
javac -version
```

---

### 2. Clonar o Repositório

```bash
git clone https://github.com/guilhermef2k/Projeto_POO.git
```

Entrar na pasta do projeto:

```bash
cd Projeto_POO
```

---

### 3. Compilar o Projeto

No **PowerShell**, use:

```powershell
Remove-Item sources.txt -ErrorAction SilentlyContinue
Remove-Item bin -Recurse -Force -ErrorAction SilentlyContinue
New-Item -ItemType Directory -Force bin
Get-ChildItem -Recurse .\src -Filter *.java | ForEach-Object { $_.FullName.Replace((Get-Location).Path + "\", "") } | Set-Content -Encoding ascii sources.txt
javac -encoding UTF-8 -d bin '@sources.txt'
```

No **Linux/macOS**, use:

```bash
find src -name "*.java" > sources.txt
mkdir -p bin
javac -encoding UTF-8 -d bin @sources.txt
```

---

### 4. Executar o Sistema

Após compilar, execute:

```bash
java -cp bin App
```

---

## Testes Realizados

Durante o desenvolvimento, foram realizados testes manuais para validar o funcionamento dos principais módulos.

No módulo de transações, foram testados os seguintes cenários:

- Venda com estoque suficiente;
- Venda com estoque insuficiente;
- Compra/reposição de estoque;
- Bloqueio de transação com ID duplicado;
- Cálculo correto do valor total;
- Atualização correta do estoque;
- Criação do arquivo `data/transacoes.txt`.

Exemplo de resultado esperado:

```text
Teste 1: venda com estoque suficiente
Total esperado: 50.0
Total calculado: 50.0
Estoque esperado: 8
Estoque atual: 8

Teste 2: venda com estoque insuficiente
Venda bloqueada corretamente.

Teste 3: compra/reposicao de estoque
Total esperado: 32.0
Total calculado: 32.0
Estoque esperado: 9
Estoque atual: 9

Teste 4: transacao com ID duplicado
ID duplicado bloqueado corretamente.

Teste 5: verificando arquivo TXT
Arquivo criado corretamente: data\transacoes.txt
```

---

## Regras de Negócio

O sistema aplica algumas regras importantes:

- Não é permitido cadastrar produtos com código duplicado;
- Não é permitido realizar venda sem estoque suficiente;
- Toda venda deve estar vinculada a um cliente;
- Toda compra/reposição deve estar vinculada a um funcionário;
- Uma transação pode conter múltiplos itens;
- O estoque deve ser atualizado automaticamente após uma venda ou reposição;
- O sistema deve impedir transações com ID duplicado;
- As informações devem ser persistidas em arquivos `.txt`.

---

## Diagrama de Classes

O projeto possui um diagrama de classes elaborado no Lucidchart.

Link do diagrama:

https://lucid.app/lucidchart/54d2e07c-f37b-405e-804f-9cf5bf544494/edit?invitationId=inv_b8ec1644-e374-4021-8fb4-5475078dc5da&page=0_0#

---

## Branches do Projeto

O desenvolvimento foi dividido por responsabilidades, utilizando branches separadas.

Branches principais utilizadas no projeto:

```text
main
teste
guilherme/produtos
guilherme/readme.md
joao-lucas/transacao-vendas
thallys/view
```

Essa divisão permitiu que cada integrante trabalhasse em sua parte sem alterar diretamente a branch principal.

---

## Divisão de Responsabilidades

### Gestão de Produtos

Responsável pelo módulo de produtos, incluindo cadastro, edição, remoção, listagem, busca e persistência dos cosméticos.

### Gestão de Usuários

Responsável pelo gerenciamento de clientes e funcionários, incluindo cadastro, edição, busca, listagem e remoção.

### Gestão de Transações/Vendas

Responsável pelo registro de vendas e compras/reposições, carrinho de compras, cálculo de totais, validação de estoque, atualização do inventário e histórico de transações.

### Interface

Responsável pela interação do usuário com o sistema, conectando os menus ou telas aos controllers correspondentes.

---

## Conceitos de POO Aplicados

O projeto aplica os principais conceitos de Programação Orientada a Objetos:

### Encapsulamento

Os atributos das classes são protegidos e acessados por métodos públicos, como getters e setters.

### Herança

A estrutura de usuários permite reaproveitamento de atributos e comportamentos comuns entre clientes e funcionários.

### Associação entre classes

As transações se relacionam com clientes, funcionários, produtos e itens de transação.

### Composição

Uma transação possui uma lista de itens, representando a composição entre `Transacao` e `ItemTransacao`.

### Separação de responsabilidades

Cada camada possui uma função específica, evitando que regras de negócio, persistência e interface fiquem misturadas.

---

## Exemplo de Fluxo de Venda

Fluxo simplificado de uma venda:

```text
1. O usuário escolhe registrar uma venda.
2. O sistema identifica o cliente.
3. O sistema adiciona produtos à transação.
4. Cada produto é armazenado como um ItemTransacao.
5. O sistema calcula o total.
6. O sistema verifica o estoque.
7. Se houver estoque, a venda é finalizada.
8. O estoque é atualizado.
9. A transação é salva no histórico.
10. O registro é gravado em arquivo .txt.
```

---

## Observações

- Os arquivos `.txt` são criados automaticamente durante a execução do sistema.
- Arquivos gerados por compilação, como `bin/`, não devem ser versionados.
- Arquivos temporários de teste não devem ser enviados para o repositório.
- A branch `main` deve receber apenas versões integradas e revisadas do projeto.

---

## Autores

Projeto desenvolvido por estudantes da disciplina de **Programação Orientada a Objetos (POO)** da **Universidade Federal Rural do Semi-Árido (UFERSA)**.

Equipe:

- Guilherme de França Vasconcelos
- João Lucas Oliveira de Andrade
- Thallys Araújo de Morais
- Thiago Geovane da Costa Nunes

---

## Disciplina

**PEX0130 - Programação Orientada a Objetos**

Universidade Federal Rural do Semi-Árido  
Campus Pau dos Ferros  
Departamento de Engenharias e Tecnologia
