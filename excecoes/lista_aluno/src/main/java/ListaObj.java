import java.util.ArrayList;

public class ListaObj <T>{

    private T[] vetor;
    private int nroElem;
    private int contOcorrencia;

    public ListaObj(int length) {
        this.vetor = (T[]) new Object[length];
        this.nroElem = 0;
    }

    public void adiciona(T elem) {
        if (this.nroElem < this.vetor.length) {
            vetor[this.nroElem++] = elem;
        } else {
            System.out.println("Lista está cheia!");
        }
    }
    public void exibe() {
        if (nroElem == 0) {
            System.out.println("\nA lista está vazia.");
        }
        else {
            System.out.println("\nElementos da lista:");
            for (int i = 0; i < nroElem; i++) {
                System.out.println(vetor[i]);
            }
        }
    }

    /* Método busca - recebe o elemento a ser procurado na lista
       Retorna o índice do elemento, se for encontrado
       Retorna -1 se não encontrou
     */
    public int busca(T elementoBuscado) {
        for (int i = 0; i < nroElem; i++) {
            if (vetor[i].equals(elementoBuscado)) {   // se encontrou
                return i;                        // retorna seu índice
            }
        }
        return -1;                               // não encontrou, retorna -1
    }

    /* Método removePeloIndice - recebe o índice do elemento a ser removida
       Se o índice for inválido, retorna false
       Se removeu, retorna true
     */
    public boolean removePeloIndice (int indice) {
        if (indice < 0 || indice >= nroElem) {
            System.out.println("\nÍndice inválido!");
            return false;
        }
        // Loop para "deslocar para a esquerda" os elementos do vetor
        // sobrescrevendo o elemento removido
        for (int i = indice; i < nroElem-1; i++) {
            vetor[i] = vetor[i+1];
        }

        nroElem--;          // decrementa nroElem
        return true;
    }

    /* Método removeElemento - recebe um elemento a ser removido
       Utiliza os métodos busca e removePeloIndice
       Retorna false, se não encontrou o elemento
       Retorna true, se encontrou e removeu o elemento
     */
    public boolean removeElemento(T elementoARemover) {
        return removePeloIndice(busca(elementoARemover));
    }

    /* getTamanho()  - retorna o tamanho da lista */
    public int getTamanho() {
        return nroElem;
    }

    /* getElemento() - recebe um índice e retorna o elemento desse índice */
    public T getElemento(int indice) {
        if (indice < 0 || indice >= nroElem) {   // se índice inválido
            return null;                        // então retorna null
        }
        else {
            return vetor[indice];
        }
    }

    /* limpa() - limpa a lista */
    public void limpa() {
        nroElem = 0;
    }
}
