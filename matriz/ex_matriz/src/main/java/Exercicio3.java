import java.util.Scanner;

public class Exercicio3 {

    public static void main(String[] args) {
        int[][] matriz = new int[3][3];
        Scanner leitor = new Scanner(System.in);

        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                System.out.println(String.format("Digite [%d][%d]", linha, coluna));
                matriz[linha][coluna] = leitor.nextInt();
            }
        }

        System.out.println("------------");
        System.out.println("Exibindo a matriz: ");
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                System.out.print(matriz[linha][coluna] + "\t");
            }
            System.out.println();
        }

        int[][] somaMatriz = new int[1][3];

        for (int i = 0; i < somaMatriz.length; i++) {
            for (int j = 0; j < somaMatriz[i].length; j++) {
                somaMatriz[i][j] = matriz[i][j] + matriz[i+1][j] + matriz[i+2][j];
            }
        }

        System.out.println("------------");
        System.out.println("Exibindo a matriz: ");
        for (int linha = 0; linha < somaMatriz.length; linha++) {
            for (int coluna = 0; coluna < somaMatriz[linha].length; coluna++) {
                System.out.print(somaMatriz[linha][coluna] + "\t");
            }
            System.out.println();
        }
    }
}
