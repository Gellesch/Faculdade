package aula4_ac;

public class Vetor {
    private int[] A;          // lista de números (tipo da lista)
    private int capacity;	// capacidade do vetor
    private int size;           // elementos no vetor

    public Vetor(int capacity) {
        A = new int[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return size;
    }

    public int get(int i) throws Exception {
        if (isEmpty()) {
            throw new Exception("Lista vazia!");
        }        
        return A[i];
    }

    public void set(int i, int n) throws Exception {
        if (isEmpty()) {
            throw new Exception("Lista vazia!");
        }
        A[i] = n;
    }
   
    public void add(int i, int n) throws Exception {
        if (size==A.length)
             throw new Exception("Lista cheia!");
        for (int j = size - 1; j >= i; j--) {
            A[j + 1] = A[j];
        }
        A[i] = n;
        size++;
    }

    public void remove(int i) throws Exception {
        if (isEmpty()) {
            throw new Exception("Lista Vazia!");
        }
        for (int j = i; j <= size - 1; j++) {
            A[j] = A[j + 1];
        }
        size--;
    }

    public int search(int n) {
        for (int i = 0; i < A.length; i++) {
            if (A[i]==n) {
                return i;
            }
        }
        return -1;
    }
}
