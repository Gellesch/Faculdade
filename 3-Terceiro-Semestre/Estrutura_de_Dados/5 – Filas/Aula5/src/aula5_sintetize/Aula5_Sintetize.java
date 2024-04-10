package aula5_sintetize;

import java.util.*;

public class Aula5_Sintetize {

    public static void main(String[] args) throws Exception {
        
        Scanner ent = new Scanner (System.in);
        
        Pilha s = new Pilha(5);
        Fila q = new Fila(5);
        
        System.out.println("Informe o nome das pessoas da fila");
        for (int i = 0; i < 5; i++) {
            q.enqueue(ent.nextLine());
        }
        
        //tira da fila e coloca na pilha
        do {
            s.push(q.front());
            q.dequeue();
        } while (q.size()!=0);
        
        //tira da pilha e volta para a fila
        do {
            q.enqueue(s.top());
            s.pop();
        } while (s.size()!=0);
        
        
        //mostra a fila após a inversão
        System.out.println("Fila depois da inversão");
        do {
            System.out.println(q.front());
            q.dequeue();
        } while (q.size()!=0);
        
        
    }
}
