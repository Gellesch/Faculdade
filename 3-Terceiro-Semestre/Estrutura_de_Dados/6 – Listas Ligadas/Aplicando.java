/*Essa atividade deve ser feita com base nos conhecimentos adquiridos sobre listas ligadas. Para resolver esses exercícios, utilize a implementação das listas ligadas de nomes de animais disponível no recurso Explorando os Conceitos. 
Você deverá adaptar a implementação para uma Lista Ligada de Números inteiros (trocar de String (nome do animal) para int (número inteiro). Lembre-se de fazer todas as alterações originadas a partir desta troca (de String para int). 
A atividade consiste no desenvolvimento de duas novas funções que deverão ser inseridas na classe de teste. As regras para escolha são: 
- escolher um exercício entre as opções 1 a 6; e 
- escolher um exercício entre as opções 7 a 10. 

OPÇÕES: 
1. Escreva uma função que retorne o elemento central de uma lista ligada. 
2. Escreva uma função que remova o elemento central de uma lista ligada. 
3. Escreva uma função que retorne o número de ocorrências de determinado elemento em uma lista ligada. Por exemplo, quantas vezes o número 33 aparece na lista ligada. 
4. Escreva uma função para encontrar todas as ocorrências de elementos em uma lista ligada que são menores do que um valor específico informado e exiba esses valores na tela. Por exemplo, mostrar na tela todos os números da lista ligada que são menores que 47. 
5. Escreva uma função para encontrar todas as ocorrências de elementos em uma lista ligada que são menores do que um valor específico informado e retorne um vetor que contenha essas ocorrências. Por exemplo, retornar um vetor com todos os valores da lista ligada que são menores que 50. 
6. Escreva uma função que receba como parâmetro duas listas ligadas de números inteiros e compare-as. A função deve retornar true, se as listas forem iguais, ou false, caso contrário. 
7. Escreva uma função para dividir uma lista ligada em duas, em um ponto específico, e retornar a lista com a maior quantidade de elementos. Por exemplo, se a lista ligada recebida como parâmetro tiver os valores (10 20 30 40 50) e o ponto específico informado for igual a 3, serão geradas duas listas: uma com (10 20 30) e outra com (40 50). A lista que será retornada é a (10 20 30), pois tem mais elementos. Se as listas geradas tiverem tamanho igual, retornar a lista 1. 
8. Escrever uma função que retorna uma lista ligada que contém valores duplicados de outra lista ligada recebida como parâmetro. Por exemplo, se a lista recebida como parâmetro tiver os valores (3 1 2), deverá ser gerada e retornada a seguinte lista (3 3 1 1 2 2). 
9. Escreva uma função que constrói (e retorna) uma lista ligada que é o inverso de uma lista ligada recebida como parâmetro. (Lista original deve se manter inalterada.) Por exemplo, se a lista enviada como parâmetro tiver os valores (34 67 88 90), deverá ser retornada uma lista com os valores (90 88 67 34). 
10. Escreva uma função que anexe uma lista ligada à extremidade de outra lista ligada, recebida como parâmetro, e retorne essa nova lista. Por exemplo, se forrem recebidas duas listas com o conteúdo (10 20 45 70) e (23 14 56), deverá ser retornada uma lista com o conteúdo (10 20 45 70 23 14 56). 
Entrega: entregar a classe lista ligada, bem como a classe de teste e um “print” da execução. Não esqueça de informar, no documento ou em forma de comentário no código, quais opções você está desenvolvendo. 
*/

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    // Função para adicionar elementos à lista
    void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
    }

    // Função para imprimir a lista ligada
    void printList() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    // Aqui você implementaria as funções conforme as opções escolhidas
    // ...

    // Exemplo de função para encontrar o elemento central de uma lista ligada
    int findMiddleElement() {
        Node slowPtr = head;
        Node fastPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        return (slowPtr != null) ? slowPtr.data : -1; // Retorna -1 se a lista estiver vazia
    }

    // Exemplo de função para dividir uma lista ligada em dois, retornando a com
    // mais elementos
    LinkedList splitAndReturnLarger(int splitPoint) {
        // Implemente conforme necessário
        return null;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.append(10);
        linkedList.append(20);
        linkedList.append(30);
        linkedList.append(40);
        linkedList.printList();

        int middleElement = linkedList.findMiddleElement();
        System.out.println("Middle Element: " + middleElement);

        LinkedList largerList = linkedList.splitAndReturnLarger(2);
        if (largerList != null) {
            System.out.print("Larger List: ");
            largerList.printList();
        }
    }
}
