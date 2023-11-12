package projprodutos;

import java.util.ArrayList;
import java.util.LinkedList;

public class TabelaProd {

    private ArrayList<LinkedList<Produto>> conjunto;
    int tamanho;

    public TabelaProd(int c) {
        // constroi o Arraylist e dentro dele, 
        // instância uma lista ligada em cada posição
        conjunto = new ArrayList<LinkedList<Produto>>(c);
        for (int i = 0; i < c; i++) {
            conjunto.add(new LinkedList<Produto>());
        }
        tamanho = 0;
    }
    
    public int size(){
        return tamanho;
    }

    public void insere(Produto def) {
        //adiciona uma palavra no dicionário
        //envia palavra para a função que define a posição
        int pos = hashFunc(def.getCodigo().substring(0, 3));        
        //adiciona a definição na lista ligada dentro da posição correspondente
        conjunto.get(pos).add(def);
        //atualiza contador
        tamanho++;
        System.out.println("Produto cadastrado com sucesso!!\n\n");
    }

    public void remove(String codigo) {
        //retira uma palavra do dicionario
        //descobre em qual posição (lista ligada a palavra está)
        int pos = hashFunc(codigo.substring(0, 3));
        //armazena a lista ligada da posição correspondete em uma lista separada
        LinkedList<Produto> lista = conjunto.get(pos);
        //inicia a busca pela palavra... ela pode não existir
        int flag = 0;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCodigo().equals(codigo)) {
                Produto aux = lista.get(i);
                lista.remove(aux);
                flag = 1;
                tamanho--;
                System.out.println("Produto removido com sucesso!!\n\n");
            }
        }
        if (flag == 0) {
            System.out.println("Esse produto NÃO está cadastrado!!\n\n");
        }
    }

    public Produto consulta(String codigo) {
        //procura uma palavra no dicionario
        //descobre em qual posição (lista ligada a palavra está)
        int pos = hashFunc(codigo.substring(0, 3));
        //armazena a lista ligada da posição correspondete em uma lista separada
        LinkedList<Produto> lista = conjunto.get(pos);
        //inicia a busca pela palavra... ela pode não existir
        int flag = 0;
        Produto aux = null;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCodigo().equals(codigo)) {
                aux = lista.get(i);
                flag = 1;
            }
        }
        return aux;
    }

    public int hashFunc(String cod) {
        System.out.println(cod);
        //pega o primeiro número do código
        char l1 = cod.charAt(0);
        //pega o segundo número do código
        char l2 = cod.charAt(1);
        //pega o terceiro número do código
        char l3 = cod.charAt(2);
        //soma os valores ASCII de cada um dos números
        int soma = (int) l1 + (int) l2 + (int) l3;
        //aplica função mod 10
        int resto = soma % 10;
        return resto;
    }
}
