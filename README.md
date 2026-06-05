# Sistema de Gerenciamento - Loja de Cosméticos

Sistema de gerenciamento desenvolvido em Java para a disciplina de Programação Orientada a Objetos (POO). O projeto simula as operações de uma loja de cosméticos, incluindo controle de estoque, cadastro de usuários e o registro de transações comerciais.

## 🏗️ Arquitetura

O projeto foi construído utilizando o padrão **MVC (Model-View-Controller)**, expandido com as camadas Service e Repository para garantir uma rigorosa separação de responsabilidades (princípios SOLID):
* **Model:** Classes de domínio (Produto, Cliente, Funcionario, Transacao, ItemTransacao).
* **Repository:** Responsável exclusivo pela persistência e leitura dos dados em disco.
* **Service:** Centraliza as regras de negócio, validações de dados e integração entre módulos.
* **Controller:** Intermediador que orquestra a comunicação entre a interface do usuário e a camada lógica.

## 🚀 Funcionalidades

* **Módulo de Produtos:** Cadastro, edição, exclusão e listagem de cosméticos no catálogo.
* **Módulo de Usuários:** Gerenciamento de Clientes e Funcionários.
* **Módulo de Transações:** Registro de vendas (com múltiplos itens) e compras (reposição de estoque), incluindo cálculo automático de subtotais e atualização dinâmica do inventário.
* **Persistência de Dados:** Todos os registros são salvos permanentemente em arquivos `.txt` isolados, garantindo a integridade dos dados entre diferentes sessões.

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java (Puro / Sem frameworks)
* **Armazenamento:** Manipulação de arquivos (`java.io` e `java.nio`)
* **IDE Recomendada:** Visual Studio Code (VS Code)

## ⚙️ Como Executar

1. Certifique-se de ter o **Java Development Kit (JDK)** instalado em sua máquina.
2. Clone este repositório para o seu computador:
   ```bash
   git clone https://github.com/guilhermef2k/Projeto_POO.git
3. Abra a pasta raiz do projeto na sua IDE.

4. Execute o arquivo principal do sistema (Main.java ou o arquivo correspondente à View) localizado dentro da pasta src/.

Nota: Os arquivos de banco de dados (ex: produtos.txt) serão gerados automaticamente na raiz do projeto durante a primeira operação de salvamento.

## 📁 Estrutura do Projeto

📦 Loja_Cosmeticos\
 ┣ 📂 src\
 ┃ ┣ 📂 controller\
 ┃ ┣ 📂 model\
 ┃ ┣ 📂 repository\
 ┃ ┣ 📂 service\
 ┃ ┗ 📜 Main.java\
 ┣ 📜 README.md\
 ┗ 📜 .gitignore