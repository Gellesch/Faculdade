package projlistaobj;

public class Vetor {

    Aluno[] vetor;
    int tamanho;
    int qtde;

    Vetor(int tamanho) {
        vetor = new Aluno[tamanho];
        this.tamanho = tamanho;
        this.qtde = 0;
    }

    public boolean isEmpty() {
        if (qtde == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return qtde;
    }

    public Aluno get(int pos) throws Exception {
        if (isEmpty()) {
            throw new Exception("Lista vazia - não há elemento para recuperar!");
        }

        if (pos < 0 || pos >= qtde) {
            throw new Exception("Índice da Lista é inválido!");
        }
        return (vetor[pos]);
    }

    public void set(int pos, Aluno n) throws Exception {
        if (isEmpty()) {
            throw new Exception("Lista vazia - não há elemento para alterar!");
        }

        if (pos < 0 || pos >= qtde) {
            throw new Exception("Índice da Lista é inválido!");
        }
        vetor[pos] = n;
    }

    public void add(int pos, Aluno n) throws Exception {
        if (qtde == tamanho) {
            throw new Exception("A Lista está cheia! Impossí­vel inserir!");
        }
        if (pos < 0 || pos > qtde) {
            throw new Exception("Índice da Lista é inválido!");
        }
        // abre espaÃ§o no vetor
        for (int j = qtde - 1; j >= pos; j--) {
            vetor[j + 1] = vetor[j];
        }
        vetor[pos] = n;
        qtde++;
    }

    public void remove(int pos) throws Exception {
        if (isEmpty()) {
            throw new Exception("Lista vazia - não há elemento para remover!");
        }
        if (pos < 0 || pos >= qtde) {
            throw new Exception("Índice da Lista é inválido!");
        }
        // movimenta os elementos para a esquerda p/ cobrir posiÃ§Ã£o vaga
        for (int j = pos; j <= qtde - 2; j++) {
            vetor[j] = vetor[j + 1];
        }
        qtde--;
    }

    public int search(String nomeBusca) {
        for (int i = 0; i < qtde; i++) {
            if (vetor[i].nome.equals(nomeBusca)) {
                return i;
            }
        }
        return -1;
    }

    public Aluno[] getArray() {
        return vetor;
    }
}
