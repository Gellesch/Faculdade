/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicandoconhecimento;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author fabio
 */
public class AplicandoConhecimento {

   
    
    public static void main(String[] args){
        // declara um ArrayList e variaveis para trabalhar com nota
        // foi declarada fora do try..catch para podermos usar fora da estrutura
        ArrayList <Float> listaNotas = new ArrayList();
        float somaNota=0, mediaNota=0;
        try {
            // Abre o arquivo.txt
            InputStream is = new FileInputStream("alunos.txt");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            while( true ){
                // Le uma String do alunos.txt 
                String s = br.readLine();
                if( s == null )
                    break;
                // Separa a String s em duas substring
                String subStrings[] = s.split(";");
                // converte a String com a nota para tipo float
                float nota = Float.parseFloat(subStrings[2]);
                // soma a nota 
                somaNota = somaNota + nota;
                // adiciona a nota no ArrayList
                listaNotas.add(nota);
            }
            // Fecha o fluxo de stream
            is.close();
        } catch (IOException ex) {
            System.out.println("Erro na abertura do arquivo.");
        } // fim do try..catch
        
        // calcula a media das notas
        mediaNota = somaNota / listaNotas.size();
        System.out.println("Media das notas = "+mediaNota);
        // imprimindo as notas maiores que a media calculada
        for( int i=0;i<listaNotas.size();i++)
            if( listaNotas.get(i)>=mediaNota)
                System.out.println("Nota maior que a media => "+listaNotas.get(i));
        System.out.println("fim de programa.");
    }   
}
