# Jogo de Sudoku

Um jogo simples de Sudoku implementado em Java que roda no terminal.

## Funcionalidades

- Interface interativa no terminal
- Validação de entrada
- Aplicação das regras do Sudoku
- Exibição visual do tabuleiro
- Células fixas (números pré-preenchidos que não podem ser alterados)

## Requisitos

- Java 11 ou superior
- Maven 3.6 ou superior

## Construindo o Projeto

1. Clone o repositório
2. Navegue até o diretório do projeto
3. Execute o seguinte comando para construir o projeto:

```bash
mvn clean package
```

## Executando o Jogo

Após a construção, você pode executar o jogo usando:

```bash
java -jar target/sudoku-1.0-SNAPSHOT-jar-with-dependencies.jar
```

## Como Jogar

1. O jogo exibirá um tabuleiro de Sudoku com alguns números pré-preenchidos
2. Para fazer uma jogada, digite três números separados por espaços:
   - Primeiro número: linha (1-9)
   - Segundo número: coluna (1-9)
   - Terceiro número: valor a ser colocado (1-9)
3. Exemplo: `1 2 5` significa colocar o número 5 na linha 1, coluna 2
4. Digite `0` para sair do jogo
5. O jogo validará suas jogadas e impedirá colocações inválidas
6. Vença preenchendo todas as células vazias com números válidos

## Regras do Jogo

1. Cada linha deve conter os números 1-9 sem repetição
2. Cada coluna deve conter os números 1-9 sem repetição
3. Cada caixa 3x3 deve conter os números 1-9 sem repetição
4. Você não pode alterar os números pré-preenchidos (mostrados no tabuleiro inicial)

## Exemplo de Tabuleiro

```
Tabuleiro Atual:
-------------------
5 3 . | . 7 . | . . . 
6 . . | 1 9 5 | . . . 
. 9 8 | . . . | . 6 . 
-------------------
8 . . | . 6 . | . . 3 
4 . . | 8 . 3 | . . 1 
7 . . | . 2 . | . . 6 
-------------------
. 6 . | . . . | 2 8 . 
. . . | 4 1 9 | . . 5 
. . . | . 8 . | . 7 9 
-------------------
```

Neste exemplo, pontos (.) representam células vazias que podem ser preenchidas. 