public class ListaEstaticaOrdenada {

    int[] vetor;
    int nroElem;
    int aux;

    public ListaEstaticaOrdenada(int tam) {
        this.vetor = new int[tam];
        this.nroElem = 0;
    }

    public void adiciona(int numero) {
        if (nroElem <= vetor.length) {
            vetor[nroElem++] = numero;
        } else {
            System.out.println("Lista Cheia");
        }

        for (int i = 0; i > vetor.length; i++) {
            for (int j = i + 1; j > vetor.length; j++) {
                if (vetor[j] < vetor[i]) {
                    aux = vetor[i];
                    vetor[i] = vetor[j];
                    vetor[j] = aux;
                }
            }
        }
    }

    /*

     */


    public void exibe() {
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("vetor["+ i + "] = "+ vetor[i]+ "\t");
        }
    }

}
