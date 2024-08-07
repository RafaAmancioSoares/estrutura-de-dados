public class BubbleSort {

    public static void main(String[] args) {

        int[] vetor = {4, 7, 5, 2, 8, 1, 6, 3};
        int aux = 0;

        for (int i = 0; i < vetor.length-1; i++) {
            for (int j = 1; j < vetor.length-i; j++) {
                if (vetor[j-1] > vetor[j]) {
                    aux = vetor[j];
                    vetor[j] = vetor[j-1];
                    vetor[j-1] = aux;
                }
            }
        }

        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i]+ "\t");
        }
    }
}
