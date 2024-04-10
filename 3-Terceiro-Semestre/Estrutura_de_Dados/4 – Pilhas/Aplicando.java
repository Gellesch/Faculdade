/*Desenvolva um programa em Java que receba pelo teclado um número inteiro qualquer diferente de zero (fazer a validação) e o transforme na base hexadecimal. Use os conceitos vistos em pilhas para armazenar os restos das divisões e, em seguida, desempilhe os restos para exibir o resultado da conversão. 
Use o site Invertexto.com para verificar se o resultado de seu programa está correto (conversor de bases). 
https://www.invertexto.com/conversao-base-numerica 
Esta atividade deverá ser entregue em um arquivo .pdf com a classe de teste apenas (não é necessário fazer o envio da classe vetor e da classe pilha). 
*/

import java.util.Scanner;
import java.util.Stack;

public class ConversorHexadecimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um número inteiro diferente de zero: ");
        int num = sc.nextInt();
        while (num == 0) {
            System.out.println("Digite um número inteiro diferente de zero: ");
            num = sc.nextInt();
        }

        Stack<Character> pilha = new Stack<>();

        while (num != 0) {
            int resto = num % 16;
            if (resto < 10) {
                pilha.push((char) (resto + '0'));
            } else {
                pilha.push((char) (resto + 10 + 'A'));
            }
            num /= 16;
        }

        System.out.println("O número convertido para hexadecimal é: ");
        while (!pilha.isEmpty()) {
            System.out.print(pilha.pop());
        }
        sc.close();
    }
}