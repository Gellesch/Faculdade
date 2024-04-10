public class MergeSort {

    public static void mergeSort(int[] array, int inicio, int fim) {

        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(array, inicio, meio);
            mergeSort(array, meio + 1, fim);
            merge(array, inicio, meio, fim);
        }
    }

    private static void merge(int[] array, int inicio, int meio, int fim) {
        int tamanho1 = meio - inicio + 1;
        int tamanho2 = fim - meio;

        int[] esquerda = new int[tamanho1];
        int[] direita = new int[tamanho2];

        for (int i = 0; i < tamanho1; i++) {
            esquerda[i] = array[inicio + i];
        }
        for (int j = 0; i < tamanho2; j++) {
            direita[j] = array[meio + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = inicio;

        while (i < tamanho1 && j < tamanho2) {
            if (esquerda[i] <= direita[j]) {
                array[k] = esquerda[i];
                i++;
            } else {
                array[k] = direita[j];
                j++;
            }

            while (i < tamanho) {
                array[k] = esquerda[i];
                i++;
                k++;
            }

            while (j < tamanho2) {
                array[k] = direita[j];
                j++;
                k++;
            }
        }
    }
}