public class SelectSort {

    public static void main(String[] args) {

        int[] vetor = {4, 7, 5, 2, 8, 1, 6, 3};
        int aux = 0;

        for (int i = 0; i < vetor.length; i++) {
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < vetor[i]) {
                    aux = vetor[i];
                    vetor[i] = vetor[j];
                    vetor[j] = aux;
                }
            }
        }

        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i]+ "\t");
        }

        System.out.println("\n-");

        int[] vetor2 = {4, 7, 5, 2, 8, 1, 6, 3};
        int indMenor;

        for (int i = 0; i < vetor2.length-1; i++) {
            indMenor = i;
            for (int j = i + 1; j < vetor2.length; j++) {
                if (vetor2[j] < vetor2[indMenor]) {
                    indMenor = j;
                }
            }
            aux = vetor2[i];
            vetor2[i] = vetor2[indMenor];
            vetor2[indMenor] = aux;
        }

        for (int i = 0; i < vetor2.length; i++) {
            System.out.print(vetor2[i]+ "\t");
        }
    }
}
