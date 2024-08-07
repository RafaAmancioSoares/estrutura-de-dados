public class ListaObj <T> {

    private T[] vetor;
    private int nroElem;
    private int contOcorrencia;

    public ListaObj(int tam) {
        this.vetor = (T[]) new Object[tam];
        this.nroElem = 0;
    }

    public void adiciona(T numero) {

        if (nroElem <= vetor.length) {
            vetor[nroElem++] = numero;
        } else {
            System.out.println("Lista Cheia");
        }


    }

    public void exibe() {
        for (T p : vetor) {
            System.out.println(p);
        }
    }

    public int busca(T elemento) {
        for (int i = 0; i < nroElem; i++) {
            if (elemento.equals(vetor[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean removePeloIndice(int indice) {
        if (indice <= vetor.length) {
            for (int i = indice; i < nroElem-1; i++) {
                vetor[i] = vetor[i+1];
            }
            nroElem--;
            return true;
        }
        return false;
    }

    public boolean removeElemento(T elemento) {
        /*int numero = busca(elemento);
        if (removePeloIndice(numero)) {
            return true;
        } else {
            return false;
        }
         */
        return removePeloIndice(busca(elemento));
    }

    public boolean substitui(int valorAntigo, int valorNovo) {

        /*
        for (int i = 0; i <= vetor.length; i++) {
            if (valorAntigo == vetor[i]) {
                vetor[i] = vetor[valorNovo];
            }
            return true;
        }
         */
        return false;
    }

    public void contaOcorrencias(int ocorrencia) {
        for (int i = 0; i < nroElem; i++) {
            if (vetor[i].equals(ocorrencia)) {
                contOcorrencia++;
            }
        }
        System.out.println(contOcorrencia + " ocorrencias do número " + ocorrencia);
    }

    public boolean adicionaNoInicio(T valor){
        if(nroElem == vetor.length){
            System.out.println("Lista cheia");
            return false;
        }else{
            for (int i = nroElem-1; i >= 0; i--){
                vetor[i+1] = vetor[i];
            }
            vetor[0] = valor;
            nroElem++;
            return true;
        }
    }

    public int getTamanho() {
        return nroElem;
    }

    public T getElemento(int indice) {
        if (indice < 0 || indice >= nroElem) {
            return null;
        } else {
            return vetor[indice];
        }
    }

    protected boolean validaIndice(int index) {
        if (index > this.nroElem || index < 0) {
            return false;
        }
        return true;
    }

    public T getIndice(int index) {
        if (this.validaIndice(index)) {
            return this.vetor[index];
        }
        return null;
    }

    public void limpa() {
        nroElem = 0;
    }

}

