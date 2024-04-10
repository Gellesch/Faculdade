package aula5_sintetize;

public class Vetor {
    private String[] A;          
    private int capacity;	
    private int size;           

    public Vetor(int capacity) {
        A = new String[capacity];
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

    public String get(int i) throws Exception {
        if (isEmpty()) {
            throw new Exception("Lista vazia!");
        }        
        return A[i];
    }

    public void set(int i, String n) throws Exception {
        if (isEmpty()) {
            throw new Exception("Lista vazia!");
        }
        A[i] = n;
    }
   
    public void add(int i, String n) throws Exception {
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
        for (int j = i; j <= size - 2; j++) {
            A[j] = A[j + 1];
        }
        size--;
    }

    public int search(String n) {
        for (int i = 0; i < A.length; i++) {
            if (A[i].equals(n)) {
                return i;
            }
        }
        return -1;
    }
}
