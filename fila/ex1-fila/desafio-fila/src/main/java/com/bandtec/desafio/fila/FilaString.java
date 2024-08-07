package com.bandtec.desafio.fila;

public class FilaString {
    // Atributos
    private int tamanho;
    private String[] fila;

    // Construtor
    public FilaString(int capaciade) {
       this.tamanho = 0;
       this.fila = new String[capaciade];
    }

    // Métodos

    /* Método isEmpty() - retorna true se a fila está vazia e false caso contrário */
    public boolean isEmpty() {
        if (getTamanho() == 0) {
            return true;
        }
        return false;
    }

    /* Método isFull() - retorna true se a fila está cheia e false caso contrário */
    public boolean isFull() {
        return getTamanho() == fila.length;
    }

    /* Método insert - recebe um elemento e insere esse elemento na fila
                       no índice tamanho, e incrementa tamanho
                       Retornar IllegalStateException caso a fila esteja cheia
     */
    public void insert(String info) {
        if (isFull()) {
            throw new IllegalStateException();
        } else {
            fila[tamanho++] = info;
        }
    }


    /* Método peek - retorna o primeiro elemento da fila, sem removê-lo */
    public String peek() {
        String resposta = fila[0];
        return resposta;
    }

    /* Método poll - remove e retorna o primeiro elemento da fila, se a fila não estiver
       vazia. Quando um elemento é removido, a fila "anda", e tamanho é decrementado
     */
    public String poll() {
        String primeiro = fila[0];
        if (!isEmpty()) {
            for (int i = 0; i < getTamanho()-1; i++) {
                fila[i] = fila[i+1];
            }
            tamanho--;
        }
        return primeiro;
    }

    /* Método exibe() - exibe o conteúdo da fila */
    public void exibe() {
        for (int i = 0; i < fila.length; i++) {
            System.out.println(i);
        }
    }

    public int getTamanho(){
        return this.tamanho;
    }
}
