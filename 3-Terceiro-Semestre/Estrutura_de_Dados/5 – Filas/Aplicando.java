import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Fila fila = new Fila(5);
        fila.enfileirar("João");
        fila.enfileirar("Maria");
        fila.enfileirar("Pedro");
        fila.enfileirar("Ana");
        fila.enfileirar("José");

        System.out.println("Fila antes da inversão: " + Arrays.toString(fila.getVetor()));

        Pilha pilha = new Pilha(5);
        while (!fila.estaVazia()) {
            pilha.empilhar(fila.desenfileirar());
        }
        while (!pilha.estaVazia()) {
            fila.enfileirar(pilha.desempilhar());
        }

        System.out.println("Fila depois da inversão: " + Arrays.toString(fila.getVetor()));
        System.out.println("Primeiro elemento da fila: " + fila.primeiro());
    }
}

class Vetor {
    private Object[] elementos;
    private int tamanho;

    public Vetor(int capacidade) {
        this.elementos = new Object[capacidade];
        this.tamanho = 0;
    }

    public boolean adiciona(Object elemento) {
        aumentaCapacidade();
        if (this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
            return true;
        }
        return false;
    }

    public boolean adiciona(int posicao, Object elemento) {
        if (posicao < 0 || posicao > this.tamanho) {
            throw new IllegalArgumentException("Posição inválida");
        }
        aumentaCapacidade();
        for (int i = this.tamanho - 1; i >= posicao; i--) {
            this.elementos[i + 1] = this.elementos[i];
        }
        this.elementos[posicao] = elemento;
        this.tamanho++;
        return true;
    }

    public Object busca(int posicao) {
        if (posicao < 0 || posicao >= this.tamanho) {
            throw new IllegalArgumentException("Posição inválida");
        }
        return this.elementos[posicao];
    }

    public int busca(Object elemento) {
        for (int i = 0; i < this.tamanho; i++) {
            if (this.elementos[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

    public boolean remove(Object elemento) {
        int posicao = busca(elemento);
        if (posicao != -1) {
            remove(posicao);
            return true;
        }
        return false;
    }

    public void remove(int posicao) {
        if (posicao < 0 || posicao >= this.tamanho) {
            throw new IllegalArgumentException("Posição inválida");
        }
        for (int i = posicao; i < this.tamanho - 1; i++) {
            this.elementos[i] = this.elementos[i + 1];
        }
        this.tamanho--;
        this.elementos[this.tamanho] = null;
    }

    public int tamanho() {
        return this.tamanho;
    }

private void aumentaCapacidade() {
        if (this.tamanho == this.elementos.length) {
            Object[] elementosNovos = new Object[this.elementos.length * 2];
            for (int i = 0; i < this.elementos.length; i++) {
                elementosNovos[i] = this.elementos[i];
