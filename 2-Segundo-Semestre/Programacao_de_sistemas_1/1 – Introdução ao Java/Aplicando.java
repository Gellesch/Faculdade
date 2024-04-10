import java.util.Scanner;
 public class MenuOpcoes {
        public static void main (String[] args){
        double n1, n2;
        int op;    
        Scanner entrada = new Scanner (System.in);
                while(true){
            op = entrada.nextInt();
            if (op == 5){
                break;
            }
            if (op < 1 || op > 5){
                System.out.println("OPÇÃO INVÁLIDA");  
                continue;
            }
            
            n1 = entrada.nextDouble();
            
            n2 = entrada.nextDouble();
            
            switch (op){
                case 1:
                    System.out.println(((n1 + n2)/2));
                    break;
                case 2:
                    if (n1 > n2){
                        System.out.println((n1-n2));
                    }
                    else {
                        System.out.println((n2-n1));
                    }
                    break;
                case 3:
                    System.out.println((n1*n2));
                    break;
                case 4:
                    if (n2 <= 0){
                    System.out.println("NÃO FOI POSSÍVEL REALIZAR A OPERAÇÃO");
                    break;           
                }
                    else {
                    System.out.println((n1/n2));
                    break;
                }
                default:
                    System.out.println("OPÇÃO INVÁLIDA") 
            }
        }
    }
}














import java.util.Scanner;
 
public class MenuOpcoes {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        double m, n1,n2;
        int op;
       while(true){
            op = input.nextInt();
            if (op==5)                                         
                break;
            if (op<1 || op>6){                                 
                System.out.println("OPÇÃO INVÁLIDA");   
                continue;
                }
            n1 = input.nextDouble();
            n2= input.nextDouble();
            switch (op){
                case 1:
                    System.out.println((n1+n2)/2); 
                    break;
                case 2:
                    if (n1>n2)
                        System.out.println(n1-n2);
                    else
                        System.out.println(n2-n1);
                    break;
                case 3:
                    System.out.println(n1*n2);
                    break;
                case 4:
                    if (n2==0)
                     System.out.println("NÃO FOI POSSÍVEL REALIZAR A OPERAÇÃO");
                    else
                        System.out.println(n1/n2);
                    break;
                }
 
        }
    }
    
}
