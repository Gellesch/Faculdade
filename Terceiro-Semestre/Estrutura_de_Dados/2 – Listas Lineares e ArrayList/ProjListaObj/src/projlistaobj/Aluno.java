package projlistaobj;

public class Aluno {
    int codigo;
    String nome;
    double media;

    public Aluno(int codigo, String nome, double media) {
        this.codigo = codigo;
        this.nome = nome;
        this.media = media;
    }
    
    public void mostraAluno(){
        System.out.println(codigo + " - " + nome + " - " + media);
    }    
}
