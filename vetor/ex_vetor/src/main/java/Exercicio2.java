import java.util.Scanner;

public class Exercicio2 {

    /*
    * 2.  Escreva um programa que cria um vetor para armazenar 10 inteiros.
    * O programa deve solicitar que o usuário digite 10 números, que devem
    * ser armazenados nesse vetor.
    * O programa deverá calcular a média dos números digitados e exibir a média.
    * Depois, deverá exibir os números que estão no vetor que estão acima da média.
     * */
    public static void main(String[] args) {

        int[] vetor = new int[10];
        Scanner leitor = new Scanner(System.in);
        int soma = 0;

        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Digite um número: ");
            vetor[i] = leitor.nextInt();
            soma += vetor[i];
        }

        System.out.println("-".repeat(10));
        System.out.println("A média dos números é: " + soma/vetor.length);

        System.out.println("-".repeat(10));

        for (int i = 0; i < vetor.length; i++) {
            System.out.println("[" + vetor[i] + "]");
        }


    }
}
