import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double[] vet = new double[10];

        Scanner input = new Scanner(System.in);
        for (int i = 0; i < vet.length; i++) {
            vet[i] = input.nextDouble();
        }

        for (int i = 0; i < vet.length; i++) {
            if (vet[i] > 0) {
                int i_val = (int) vet[i];
                System.out.println(i_val);
            }
        }
    }
}