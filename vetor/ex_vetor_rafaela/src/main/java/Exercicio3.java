import java.util.Scanner;

public class Exercicio3 {

    /*
        Escreva um programa que cria um vetor para armazenar 10 Strings.
        O programa deve solicitar que o usuário digite 10 nomes, que
        devem ser armazenados nesse vetor.
        Depois, o programa deve pedir que se digite um nome qualquer.
        O programa deverá pesquisar se esse nome está no vetor.
        Se estiver, deve exibir a mensagem: “Nome encontrado no índice x”,
        sendo x o índice do nome no vetor, senão deve exibir uma mensagem de
        “Nome não encontrado”.
     */

    public static void main(String[] args) {
        String[] vetor = new String[10];
        Scanner leitor = new Scanner(System.in);

        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Digite um nome: ");
            vetor[i] = leitor.nextLine();
        }

        System.out.println("-".repeat(10));

        System.out.println("Digite um nome: ");
        String resposta = leitor.nextLine();

        for (int i = 0; i < vetor.length; i++) {

            if (vetor[i].equals(resposta)) {
                System.out.println("Nome encontrado no índice "+ i);
            } else {
                System.out.println("Nome não encontrado");
            }
        }
    }
}

