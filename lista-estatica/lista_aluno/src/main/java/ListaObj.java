import java.util.ArrayList;

public class ListaObj <T>{

    private ArrayList<Aluno> alunos;
    private T[] vetor;
    private int nroElem;
    private int contOcorrencia;

    public ListaObj() {
        alunos = new ArrayList();
        this.nroElem = 0;
    }

    public void adiciona(Integer ra, String nome, Double nota) {
        Aluno aluno = new Aluno(ra, nome, nota);
        alunos.add(aluno);
    }

    public void exibe() {
        if (!alunos.isEmpty()) {
            for (int i = 0; i < alunos.size(); i++) {
                System.out.print("nome: "+ alunos.get(i).getNome()
                        + " ra: "+ alunos.get(i).getRa() + " nota: " +
                        alunos.get(i).getNota() + "\n");
            }
        } else {
            System.out.println("Lista vazia");
        }
    }

    public void busca(T elemento) {
        for (int i = 0; i < alunos.size(); i++) {
            if (elemento.equals(i)) {
                System.out.print("nome: "+ alunos.get(i).getNome()
                        + " ra: "+ alunos.get(i).getRa() + " nota: " +
                        alunos.get(i).getNota() + "\n");
            }
        }
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
        return true; //removePeloIndice(busca(elemento));
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

    public Aluno getElemento(int indice) {
        return alunos.get(indice);
    }

    public void limpa() {
        alunos.clear();
    }
}
