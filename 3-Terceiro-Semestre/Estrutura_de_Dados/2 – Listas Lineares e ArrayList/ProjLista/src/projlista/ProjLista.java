package projlista;

public class ProjLista {

    public static void main(String[] args) throws Exception {

        //cria vetor de 5 elementos
        Vetor lista = new Vetor(5);
        try {
            lista.add(0, "Mariana");
            lista.add(1, "Eduardo");
            lista.add(2, "Gustavo");
            lista.add(3, "Leila");
            System.out.println("Quantidade de elementos na lista: " + lista.size());
            System.out.println("O conteúdo da posição 2 é " + lista.get(2));
            lista.set(2, "Pedro");
            System.out.println("O conteúdo da posição 2 é " + lista.get(2));
            lista.add(0, "Nair");
            System.out.println("Quantidade de elementos na lista: " + lista.size());
            String [] aux = lista.getArray();
            System.out.println("\nConteúdo da Lista");
            for (int i = 0; i < lista.size(); i++) {
                System.out.println("Conteúdo da posição " + i + " é " + aux[i]);
            }
            
            lista.remove(2);
            aux = lista.getArray();
            System.out.println("\nConteúdo da Lista");
            for (int i = 0; i < lista.size(); i++) {
                System.out.println("Conteúdo da posição " + i + " é " + aux[i]);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }  
    }
}
