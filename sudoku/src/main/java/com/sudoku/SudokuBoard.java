package com.sudoku;

public class SudokuBoard {
    private static final int TAMANHO_TABULEIRO = 9;
    private static final int CELULA_VAZIA = 0;
    private int[][] tabuleiro;
    private boolean[][] celulasFixas;

    public SudokuBoard() {
        this.tabuleiro = new int[TAMANHO_TABULEIRO][TAMANHO_TABULEIRO];
        this.celulasFixas = new boolean[TAMANHO_TABULEIRO][TAMANHO_TABULEIRO];
        inicializarTabuleiro();
    }

    private void inicializarTabuleiro() {
        // Inicializa com um quebra-cabeça simples
        int[][] tabuleiroInicial = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
            for (int j = 0; j < TAMANHO_TABULEIRO; j++) {
                tabuleiro[i][j] = tabuleiroInicial[i][j];
                celulasFixas[i][j] = (tabuleiroInicial[i][j] != CELULA_VAZIA);
            }
        }
    }

    public boolean jogadaValida(int linha, int coluna, int valor) {
        if (celulasFixas[linha][coluna]) {
            return false;
        }

        // Verifica linha
        for (int j = 0; j < TAMANHO_TABULEIRO; j++) {
            if (j != coluna && tabuleiro[linha][j] == valor) {
                return false;
            }
        }

        // Verifica coluna
        for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
            if (i != linha && tabuleiro[i][coluna] == valor) {
                return false;
            }
        }

        // Verifica caixa 3x3
        int linhaCaixa = (linha / 3) * 3;
        int colunaCaixa = (coluna / 3) * 3;
        for (int i = linhaCaixa; i < linhaCaixa + 3; i++) {
            for (int j = colunaCaixa; j < colunaCaixa + 3; j++) {
                if (i != linha && j != coluna && tabuleiro[i][j] == valor) {
                    return false;
                }
            }
        }

        return true;
    }

    public void setCelula(int linha, int coluna, int valor) {
        if (!celulasFixas[linha][coluna]) {
            tabuleiro[linha][coluna] = valor;
        }
    }

    public boolean completo() {
        for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
            for (int j = 0; j < TAMANHO_TABULEIRO; j++) {
                if (tabuleiro[i][j] == CELULA_VAZIA) {
                    return false;
                }
            }
        }
        return true;
    }

    public void imprimirTabuleiro() {
        System.out.println("\nTabuleiro Atual:");
        System.out.println("-------------------");
        
        for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("-------------------");
            }
            
            for (int j = 0; j < TAMANHO_TABULEIRO; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("| ");
                }
                
                if (tabuleiro[i][j] == CELULA_VAZIA) {
                    System.out.print(". ");
                } else {
                    System.out.print(tabuleiro[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println("-------------------");
    }
} 