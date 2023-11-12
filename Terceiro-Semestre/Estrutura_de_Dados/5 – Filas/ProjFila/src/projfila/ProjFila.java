package projfila;

public class ProjFila {
    public static void main(String[] args) {

        Fila f1 = new Fila(10);
        try {
            f1.enqueue("Marcos Paulo");
            f1.enqueue("Ana Luiza");
            f1.enqueue("José Almeida");
            System.out.println("Primeiro da fila: " + f1.front());
            f1.dequeue();
            f1.enqueue("Julia Muniz");
            System.out.println("Primeiro da fila: " + f1.front());
            f1.enqueue("Maria Marta");
            System.out.println("Pessoas na fila: " + f1.size());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
