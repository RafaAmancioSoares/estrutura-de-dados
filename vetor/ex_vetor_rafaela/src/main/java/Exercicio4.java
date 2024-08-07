import java.util.Scanner;

public class Exercicio4 {

    /*
        4.  Elaborar um programa que solicita que o usuário digite 10 valores inteiros
        e armazene esses valores em um vetor. Depois o programa deve solicitar que o
        usuário digite um número qualquer e o programa deverá exibir quantas vezes esse
        número ocorre no vetor.

        Exemplo:  considere os números 3  7  9  3  7  1  3  3  5  8
        o número 7 ocorre 2 vezes
        o número 3 ocorre 4 vezes
        o número 2 não ocorre nenhuma vez.
     */

    public static void main(String[] args) {
        Integer[] vetor = new Integer[10];
        Scanner leitor = new Scanner(System.in);

        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Digite um número: ");
            vetor[i] = leitor.nextInt();
        }

        System.out.println("-".repeat(10));

        System.out.println("Digite um número: ");
        Integer resposta = leitor.nextInt();

        int contador = 0;

        for (int i = 0; i < vetor.length; i++) {

            if (vetor[i].equals(resposta)) {
                contador++;
            }
        }

        System.out.println("o número " + resposta + " ocorre " + contador + " vezes");
    }
}
