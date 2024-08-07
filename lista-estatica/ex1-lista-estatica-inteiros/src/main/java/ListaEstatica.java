public class ListaEstatica {

    int[] vetor;
    int nroElem;
    int contOcorrencia;
    int aux;

    public ListaEstatica(int tam) {
        this.vetor = new int[tam];
        this.nroElem = 0;
    }

    public void adiciona(int numero) {
            if (nroElem <= vetor.length) {
                vetor[nroElem++] = numero;
            } else {
                System.out.println("Lista Cheia");
            }

    }

    public void exibe() {
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("vetor["+ i + "] = "+ vetor[i]+ "\t");
        }
    }

    public int busca(int elemento) {
        for (int i = 0; i < nroElem; i++) {
            if (elemento == vetor[i]) {
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

    public boolean removeElemento(int elemento) {
        /*int numero = busca(elemento);
        if (removePeloIndice(numero)) {
            return true;
        } else {
            return false;
        }
         */
        return removePeloIndice(busca(elemento));
    }

    // não ta funcionando
    public boolean substitui(int valorAntigo, int valorNovo) {
        for (int i = 0; i <= vetor.length; i++) {
            if (valorAntigo == vetor[i]) {
                vetor[i] = valorNovo;
            }
            return true;
        }
        return false;
    }

    public void contaOcorrencias(int ocorrencia) {
        for (int i = 0; i < nroElem; i++) {
            if (vetor[i] == ocorrencia) {
                contOcorrencia++;
            }
        }
        System.out.println(contOcorrencia + " ocorrencias do número " + ocorrencia);
    }

    public boolean adicionaNoInicio(int valor){
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


}
