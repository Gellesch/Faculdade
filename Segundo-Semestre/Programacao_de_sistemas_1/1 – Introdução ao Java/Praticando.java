import java.util.Scanner;

public class Praticando_Aula1 {
    public static void main(String[] args) {
        double n1, n2;
        int op;
        Scanner entrada = new Scanner (System.in);
        
        while (true){
         op = entrada.nextInt();
            if (op==5)                                          //sai do while com a opção 5
                break;
            if (op<1 || op>6){                                 //não executa o trecho linha 18 a 36
                System.out.println("Opção do menu inválida");  //e volta ao while  
                continue;
            }
            n1 = entrada.nextDouble();
            n2 = entrada.nextDouble();
            switch (op){
                case 1:                
                System.out.println("Soma = " + (n1+n2));
                break;
            case 2:
                System.out.println("Subtração = " + (n1-n2));
                break;
            case 3:
                System.out.println("Multiplicação = " + (n1*n2));
                break;
            case 4:
                 // aluno irá implementar na questão 2
                 break;
                
            default:
                System.out.println("Opção inválida");
            }
        }
    
}
     }

import java.util.Scanner;

public class Praticando_Aula1 {
    public static void main(String[] args) {
        double n1, n2;
        int op;
        Scanner entrada = new Scanner(System.in);

        while (true) {
            op = entrada.nextInt();
            if (op == 5) // sai do while com a opção 5
                break;
            if (op < 1 || op > 6) { // não executa o trecho linha 18 a 36
                System.out.println("Opção do menu inválida"); // e volta ao while
                continue;
            }
            n1 = entrada.nextDouble();
            n2 = entrada.nextDouble();
            switch (op) {
                case 1:
                    System.out.println("Soma = " + (n1 + n2));
                    break;
                case 2:
                    System.out.println("Subtração = " + (n1 - n2));
                    break;
                case 3:
                    System.out.println("Multiplicação = " + (n1 * n2));
                    break;
                case 4:
                    // aluno irá implementar na questão 2
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }

    }
}
