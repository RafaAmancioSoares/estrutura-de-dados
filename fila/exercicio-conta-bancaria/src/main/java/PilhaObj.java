public class PilhaObj<T> {

    private T[] pilha;
    private int topo;

    public PilhaObj(int capacidade) {
        this.topo = -1;
        this.pilha = (T[]) new Object[capacidade];
    }

    public Boolean isEmpty() {
        if (topo == 0) {
            return true;
        }
        return false;
    }

    public Boolean isFull() {
        if (pilha.length-1 == topo) {
            return true;
        }
        return false;
    }

    public void push(T info) {
        if (isFull()) {
            throw new IllegalStateException("Pilha cheia");
        } else {
            pilha[++topo] = info;
        }
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        return pilha[topo--];
    }

    public T peek() {
        if (topo == -1) {
            return null;
        }
        return pilha[topo];
    }

    public void exibe() {
        if (topo != -1) {
            for (int i = 0; i < pilha.length; i++) {
                System.out.println(pilha[i]);
            }
        } else {
            System.out.println("Pilha vazia!");

        }
    }

}
