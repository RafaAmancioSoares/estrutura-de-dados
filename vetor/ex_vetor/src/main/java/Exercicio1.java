import java.util.Scanner;

public class Exercicio1 {

    /*
        1.  Escreva um programa que leia 7 números e armazene-os em um vetor.
        Depois, o programa deve percorrer o vetor exibindo os números na
        ordem em que foram inseridos. E depois, deve percorrer o vetor de
        trás para frente, exibindo os números na ordem inversa em que foram
        inseridos (dica: utilize o for ao contrário).
    */
    public static void main(String[] args) {

        int[] vetor = new int[7];
        Scanner leitor = new Scanner(System.in);

        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Digite um número: ");
            vetor[i] = leitor.nextInt();
        }

        System.out.println("-".repeat(10));

        for (int i = 0; i < vetor.length; i++) {
            System.out.println("[" + vetor[i] + "]");
        }

        System.out.println("-".repeat(10));

        for (int i = vetor.length-1; i >= 0; i--) {
            System.out.println("[" + vetor[i] + "]");
        }

    }
}
