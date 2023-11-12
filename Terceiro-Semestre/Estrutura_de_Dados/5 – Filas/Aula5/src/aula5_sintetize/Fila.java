package aula5_sintetize;

public class Fila extends Vetor {

    public Fila(int capacity) {        
        super(capacity);
    }

    public int size() {
    // Devolve o número de elementos da fila
        return super.size();
    }

    public void enqueue(String n) throws Exception {
    // Enfileira, caso a fila não esteja cheia, o elemento n
        add (size(),n);
    }

    public void dequeue() throws Exception {
    // Desenfileira, caso a fila não esteja vazia, o primeiro elemento 
        remove(0);
    }

    public String front() throws Exception{
	// Devolve, sem desenfileirar, o primeiro elemento da fila
        return get(0);
    }

}
