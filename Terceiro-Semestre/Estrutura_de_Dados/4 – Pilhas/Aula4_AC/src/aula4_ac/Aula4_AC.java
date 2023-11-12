package aula4_ac;

import java.util.Scanner;

public class Aula4_AC {

    public static void main(String[] args) throws Exception {
        Pilha p1 = new Pilha(5);

        Scanner entrada = new Scanner(System.in);

        int base10 = 0;
        do {
            System.out.println("Informe um valor na base 10: ");
            base10 = entrada.nextInt();
        } while (base10 == 0);

        do {
            p1.push(base10 % 16);
            base10 = base10 / 16;
        } while (base10 / 16 != 0);
        p1.push(base10 % 16);

        System.out.println("Resultado da conversão");

        int x;
        do {
            x = p1.top();
            if (x < 10) {
                System.out.print(x);
            } else {
                System.out.print(converteHexa(x));
            }
            p1.pop();
        } while (p1.size() != 0);

        System.out.println(" ");

    }

    public static char converteHexa(int x) {
        char valor = ' ';
        switch (x) {
            case 10:
                valor = 'A';
                break;
            case 11:
                valor = 'B';
                break;
            case 12:
                valor = 'C';
                break;
            case 13:
                valor = 'D';
                break;
            case 14:
                valor = 'E';
                break;
            case 15:
                valor = 'F';
                break;
        }
        return valor;
    }

}
