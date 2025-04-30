package com.sudoku;

import java.util.Scanner;

public class SudokuGame {
    private static final int TAMANHO_TABULEIRO = 9;
    private static final int CELULA_VAZIA = 0;
    private SudokuBoard tabuleiro;
    private Scanner scanner;

    public SudokuGame() {
        this.tabuleiro = new SudokuBoard();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        System.out.println("Bem-vindo ao Sudoku!");
        System.out.println("Digite suas jogadas no formato: linha coluna valor (1-9)");
        System.out.println("Exemplo: 1 2 5 significa colocar o número 5 na linha 1, coluna 2");
        System.out.println("Digite '0' para sair do jogo");
        
        tabuleiro.imprimirTabuleiro();
        
        while (true) {
            System.out.print("\nDigite sua jogada: ");
            String entrada = scanner.nextLine().trim();
            
            if (entrada.equals("0")) {
                System.out.println("Obrigado por jogar!");
                break;
            }
            
            try {
                String[] partes = entrada.split(" ");
                if (partes.length != 3) {
                    System.out.println("Formato inválido. Use: linha coluna valor");
                    continue;
                }
                
                int linha = Integer.parseInt(partes[0]) - 1;
                int coluna = Integer.parseInt(partes[1]) - 1;
                int valor = Integer.parseInt(partes[2]);
                
                if (linha < 0 || linha >= TAMANHO_TABULEIRO || coluna < 0 || coluna >= TAMANHO_TABULEIRO || valor < 1 || valor > 9) {
                    System.out.println("Valores inválidos. Linha, coluna e valor devem estar entre 1 e 9");
                    continue;
                }
                
                if (tabuleiro.jogadaValida(linha, coluna, valor)) {
                    tabuleiro.setCelula(linha, coluna, valor);
                    tabuleiro.imprimirTabuleiro();
                    
                    if (tabuleiro.completo()) {
                        System.out.println("Parabéns! Você resolveu o Sudoku!");
                        break;
                    }
                } else {
                    System.out.println("Jogada inválida! Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite apenas números válidos");
            }
        }
        
        scanner.close();
    }

    public static void main(String[] args) {
        SudokuGame jogo = new SudokuGame();
        jogo.iniciar();
    }
} 