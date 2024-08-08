import java.util.Scanner;

public class Exercicio4 {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Scanner leitorStr = new Scanner(System.in);

        System.out.println("Digite o valor máximo de alunos: ");
        Integer maxAluno = leitor.nextInt();

        String[] aluno = new String[maxAluno];

        int[][] notas = new int[maxAluno][2];

        double[] media = new double[2];

        for (int i = 0; i < aluno.length; i++) {
            System.out.println("Digite os nomes dos alunos: ");
            String nome = leitorStr.nextLine();

            aluno[i] = nome;
        }

        for (int i = 0; i < notas.length; i++) {
            for (int j = 0; j < notas[j].length; j++) {
                if () {

                }
            }
        }

    }
}
