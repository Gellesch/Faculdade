//IMPLEMENTAÇÃO
//É feita apenas uma adaptação na inserção direta de forma que, ao invés de se comparar elementos contíguos uns aos outros, consideram-se apenas elementos pertencentes ao mesmo segmento (lógico), separados por uma distância h.
//CÓDIGO
public class Proj_Ex1 {
    public static void main(String[] args) {
        int[] vetor = new int[20];
        gera_vetor(vetor);
        exibe_vetor(vetor);
        shellsort(vetor);
        exibe_vetor(vetor);
    }

    public static void exibe_vetor(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.printf("%d \t", vetor[i]);
        }
        System.out.printf("\n");
    }

    public static void gera_vetor(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * 101);
        }
    }

    public static void shellsort(int[] vetor) {
        int i, j, h, aux;
        h = vetor.length / 2;
        while (h > 0) {
            for (i = h; i < vetor.length; i++) {
                j = i;
                aux = vetor[i];
                while ((j >= h) && (vetor[j - h] > aux)) {
                    vetor[j] = vetor[j - h];
                    j = j - h;
                }
                vetor[j] = aux;
            }
            if (h == 2) {
                h = 1;
            } else {
                h = (int) (h / 2.2);
            }
        }
    }
}