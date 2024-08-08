import java.util.Scanner;

public class ExMatriz {

    public static void main(String[] args) {
        int[][] matriz = new int[3][4];
        Scanner leitor = new Scanner(System.in);

        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                System.out.println(String.format("Digite [%d][%d]", linha, coluna));
                matriz[linha][coluna] = leitor.nextInt();
            }
        }

        System.out.println("Exibindo a matriz: ");
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                System.out.print(matriz[linha][coluna] + "\t");
            }
            System.out.println();
        }
    }
}
