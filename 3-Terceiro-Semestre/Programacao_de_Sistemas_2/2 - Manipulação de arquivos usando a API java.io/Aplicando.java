/*Algumas vezes, queremos armazenar dados em um arquivo texto, em que cada linha corresponderia a um registro, como em uma tabela de banco de dados. Para tanto, podemos separar as várias informações de uma linha utilizando um caractere específico, por exemplo um ponto e vírgula (“;”).
Considere o arquivo texto alunos.txt conforme descrito abaixo:
111;Jose da Silva;10.0 222;Manoel Pereira;5.0 333;Carlos Dias;7.5 122;Ana Andrade;6.5 441;Mario Souza;3.5
No arquivo alunos.txt, cada linha tem os dados de um aluno com seu id;nome;nota separados por ponto e vírgula (“;”). Escreva um programa que leia todas as linhas do arquivo alunos.txt. Para cada linha lida, você deve separar o id, o nome e nota do aluno, e armazenar a nota em um ArrayList. Em seguida, seu programa deve calcular a média das notas armazenada no ArrayList e, por fim, deve imprimir na tela a média das notas lidas do arquivo e quais são as notas que são maiores ou igual à média. Para isso, você terá de percorrer novamente o ArrayList.*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LerArquivoNotas {
    public static void main(String[] args) {
        String arquivo = "alunos.txt"; // Nome do arquivo
        ArrayList<Double> notas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;

            // Lê cada linha do arquivo
            while ((linha = br.readLine()) != null) {
                // Separa os dados da linha usando ponto e vírgula como delimitador
                String[] dados = linha.split(";");
                if (dados.length == 3) {
                    // O terceiro elemento do array é a nota, que é convertida para double e
                    // adicionada ao ArrayList
                    double nota = Double.parseDouble(dados[2]);
                    notas.add(nota);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        if (!notas.isEmpty()) {
            // Calcula a média das notas
            double soma = 0;
            for (double nota : notas) {
                soma += nota;
            }
            double media = soma / notas.size();

            System.out.println("Média das notas: " + media);

            // Imprime as notas maiores ou iguais à média
            System.out.println("Notas maiores ou iguais à média:");
            for (double nota : notas) {
                if (nota >= media) {
                    System.out.println(nota);
                }
            }
        } else {
            System.out.println("Nenhuma nota encontrada no arquivo.");
        }
    }
}
