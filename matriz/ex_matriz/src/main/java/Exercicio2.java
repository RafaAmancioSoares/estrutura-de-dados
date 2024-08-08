import java.util.Scanner;

public class Exercicio2 {

    public static void exibeMatriz(int[][] matriz) {
        System.out.println("Exibindo a matriz: ");
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                System.out.print(matriz[linha][coluna] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matriz1 = new int[2][3];
        int[][] matriz2 = new int[2][3];
        Scanner leitor = new Scanner(System.in);

        System.out.println("Matriz 1: ");
        for (int linha = 0; linha < matriz1.length; linha++) {
            for (int coluna = 0; coluna < matriz1[linha].length; coluna++) {
                System.out.println(String.format("Digite [%d][%d]", linha, coluna));
                matriz1[linha][coluna] = leitor.nextInt();
            }
        }

        System.out.println("Matriz 2: ");
        for (int linha = 0; linha < matriz2.length; linha++) {
            for (int coluna = 0; coluna < matriz2[linha].length; coluna++) {
                System.out.println(String.format("Digite [%d][%d]", linha, coluna));
                matriz2[linha][coluna] = leitor.nextInt();
            }
        }

        exibeMatriz(matriz1);
        exibeMatriz(matriz2);

        System.out.println("Somando matriz:");
        int[][] matriz3 = new int[2][3];

        for (int i = 0; i < matriz3.length; i++) {
            for (int j = 0; j < matriz3[i].length; j++) {
                matriz3[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }

        exibeMatriz(matriz3);
    }
}
