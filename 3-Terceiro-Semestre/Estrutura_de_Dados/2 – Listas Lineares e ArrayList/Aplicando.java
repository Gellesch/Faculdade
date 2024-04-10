import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Cria o ArrayList para armazenar as notas
        ArrayList<Double> notas = new ArrayList<Double>();
        // Define o caminho do arquivo alunos.txt
        File arquivo = new File("alunos.txt");
        try {
            // Cria um Scanner para ler o arquivo
            Scanner scanner = new Scanner(arquivo);
            // Enquanto houver linhas no arquivo
            while (scanner.hasNextLine()) {
                // Lê a linha e separa os dados por ";"
                String[] dados = scanner.nextLine().split(";");
                // Armazena a nota na ArrayList
                double nota = Double.parseDouble(dados[2]);
                notas.add(nota);
            }
            scanner.close();
            // Calcula a média das notas
            double media = 0;
            for (double nota : notas) {
                media += nota;
            }
            media /= notas.size();
            System.out.println("Média das notas: " + media);
            // Imprime as notas que são maiores ou iguais à média
            System.out.print("Notas maiores ou iguais à média: ");
            for (double nota : notas) {
                if (nota >= media) {
                    System.out.print(nota + " ");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
