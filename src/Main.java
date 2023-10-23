import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        char[][] Velha = new char[3][3];

        System.out.println("Jogador 1 = X");
        System.out.println("Jogador 2 = O");

        boolean ganhou = false;
        int jogada = 1;
        char sinal;
        int linha = 0, coluna = 0;

        while (!ganhou) {

            if (jogada % 2 == 1) { // jogador 1
                System.out.println("Vez do jogador 1. Escolha uma linha e coluna (1-3).");
                sinal = 'X';
            } else {
                System.out.println("Vez do jogador 2. Escolha uma linha e coluna (1-3).");
                sinal = 'O';
            }

            boolean linhaValida = false;
            while (!linhaValida) {
                System.out.println("Entre com a linha (1, 2 ou 3).");
                linha = scan.nextInt();
                if (linha >= 1 && linha <= 3) {
                    linhaValida = true;
                } else {
                    System.out.println("Entrada inválida, tente novamente.");
                }
            }
            boolean colunaValida = false;
            while (!colunaValida) {
                System.out.println("Entre com a coluna (1, 2, ou 3)");
                coluna = scan.nextInt();
                if (coluna >= 1 && coluna <= 3) {
                    colunaValida = true;
                } else {
                    System.out.println("Entrada inválida, tente novamente.");
                }
            }
            linha--;
            coluna--;
            if (Velha[linha][coluna] == 'X' || Velha[linha][coluna] == 'O') {
                System.out.println("Posição já utilizada, tente novamente.");
            } else { // jogada válida
                Velha[linha][coluna] = sinal;
                jogada++;
            }
            // imprimir tabuleiro
            for (int i = 0; i < Velha.length; i++) {
                for (int j = 0; j < Velha[i].length; j++) {
                    System.out.println(Velha[i][j] + " | ");
                }
                System.out.println();
            }

            //verifica se tem algum ganhador
            if ((Velha [0][0] == 'X' && Velha[0][1] == 'X' && Velha [0][2] == 'X') || //linha 1
                (Velha [1][0] == 'X' && Velha[1][1] == 'X' && Velha [1][2] == 'X') || //linha 2
                (Velha [2][0] == 'X' && Velha[2][1] == 'X' && Velha [2][2] == 'X') || //linha 3
                
                (Velha [0][0] == 'X' && Velha[1][0] == 'X' && Velha [2][0] == 'X') || //coluna 1
                (Velha [0][1] == 'X' && Velha[1][1] == 'X' && Velha [2][1] == 'X') || //coluna 2
                (Velha [0][2] == 'X' && Velha[1][2] == 'X' && Velha [2][2] == 'X') || //coluna 3
                //diagonal
                (Velha [0][0] == 'X' && Velha[1][1] == 'X' && Velha [2][2] == 'X')) {
            ganhou = true;
            System.out.println("Parabéns, o jogador 1 ganhou!");
                } else if ((Velha [0][0] == 'O' && Velha[0][1] == 'O' && Velha [0][2] == 'O') || //linha 1
                (Velha [1][0] == 'O' && Velha[1][1] == 'O' && Velha [1][2] == 'O') || //linha 2
                (Velha [2][0] == 'O' && Velha[2][1] == 'O' && Velha [2][2] == 'O') || //linha 3
                
                (Velha [0][0] == 'O' && Velha[1][0] == 'O' && Velha [2][0] == 'O') || //coluna 1
                (Velha [0][1] == 'O' && Velha[1][1] == 'o' && Velha [2][1] == 'O') || //coluna 2
                (Velha [0][2] == 'O' && Velha[1][2] == 'O' && Velha [2][2] == 'O') || //coluna 3
                //diagonal
                (Velha [0][0] == 'O' && Velha[1][1] == 'O' && Velha [2][2] == 'O')) {
            ganhou = true;
            System.out.println("Parabéns, o jogador 2 ganhou!");
                } else if (jogada > 9) {
                    ganhou = true;
                    System.out.println("Ninguém ganhou a partida!")
                }
        }
    }
}