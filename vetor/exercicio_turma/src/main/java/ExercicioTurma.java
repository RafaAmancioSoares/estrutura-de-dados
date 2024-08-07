import java.util.Scanner;

public class ExercicioTurma {

    public static void main(String[] args) {
        
        String[] T1 = new String[10];
        String[] T2 = new String[10];
        Scanner leitor = new Scanner(System.in);
        Scanner leitorInt = new Scanner(System.in);

        for (int i = 0; i < T1.length && i < T2.length; i++) {
            System.out.println("Escolha uma turma: ");
            int turma = leitorInt.nextInt();


            if (turma == 1) {
                System.out.println("Digite o nome do aluno:");
                T1[i] = leitor.nextLine();
            } else if (turma == 2) {
                System.out.println("Digite o nome do aluno:");
                T2[i] = leitor.nextLine();
            } else {
                System.out.println("Turma não cadastrada, escolha outra");
            }
        }

        System.out.println("Turma 1:");
        for (int i = 0; i < T1.length; i++) {
            System.out.print(T1[i]+ "\t");
        }

        System.out.println("Turma 2:");
        for (int i = 0; i < T2.length; i++) {
            System.out.print(T2[i]+ "\t");
        }
    }

    
}
