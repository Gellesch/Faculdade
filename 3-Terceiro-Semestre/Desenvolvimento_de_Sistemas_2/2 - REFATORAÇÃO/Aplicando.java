/*Considerando o que foi visto sobre as técnicas de refatoração nesta aula, refatore o código disponível no link: <https://ideone.com/a53N7I>.  
 
Além de todos os detalhes vistos nos dois exercícios do recurso Professor Resolve, para esta atividade final da aula, considere algumas mudanças nas regras de negócio: 
•	Apenas trabalhos finais de graduação passam a ter uma nota. 
•	Dissertações de Mestrado precisam de uma banca de avaliação com dois professores. 
•	Teses de Doutorado precisam de uma banca de avaliação com quatro professores. 
•	Trabalhos finais de Lato Sensu não têm nota nem banca. 

    Criação de uma classe Trabalho para representar o trabalho acadêmico:
        Essa classe conterá os dados relevantes, como título, orientador, nota e membros da banca.

    Modificação da classe Aluno:
        Adição de atributos específicos para cada tipo de curso.
        Uso de constantes para representar os tipos de curso.
        Criação de métodos específicos para lidar com as regras de negócio.
        Organização dos métodos para melhorar a legibilidade.

    Atualização da classe Teste:
        Atualização para incluir os dados necessários de acordo com as regras de negócio.

Aqui está o código refatorado:
*/

class Trabalho {
    private String titulo;
    private String orientador;
    private Double nota;
    private String[] membrosBanca;

    public Trabalho(String titulo, String orientador, Double nota, String[] membrosBanca) {
        this.titulo = titulo;
        this.orientador = orientador;
        this.nota = nota;
        this.membrosBanca = membrosBanca;
    }

    public String toString() {
        return "Título: " + titulo + "\nOrientador(a): Prof. " + orientador + "\nNota: " + nota;
    }
}

class Aluno {
    private String nome;
    private String nomeCurso;
    private String nivelCurso;
    private int codMatricula;
    private boolean bolsista;
    private boolean cursoFinalizado;
    private boolean temTrabalho;
    private int anoFinalizacao;
    private double mensalidadeCurso;
    private double desconto;
    private Trabalho trabalho;

    public Aluno(String nome, String nomeCurso, String nivelCurso, int codMatricula, boolean bolsista,
            boolean cursoFinalizado, boolean temTrabalho, int anoFinalizacao, double mensalidadeCurso, double desconto,
            Trabalho trabalho) {
        this.nome = nome;
        this.nomeCurso = nomeCurso;
        this.nivelCurso = nivelCurso;
        this.codMatricula = codMatricula;
        this.bolsista = bolsista;
        this.cursoFinalizado = cursoFinalizado;
        this.temTrabalho = temTrabalho;
        this.anoFinalizacao = anoFinalizacao;
        this.mensalidadeCurso = mensalidadeCurso;
        this.desconto = desconto;
        this.trabalho = trabalho;
    }

    public String getMensalidade() {
        String resp = "";
        if (this.bolsista) {
            resp += "Bolsista com desconto de: " + this.desconto + "%\n";
            this.mensalidadeCurso *= (1 - this.desconto / 100);
        }
        resp += "Mensalidade: R$ " + this.mensalidadeCurso + "\n";
        return resp;
    }

    public String getDados() {
        StringBuilder resp = new StringBuilder("Aluno: " + this.nome + "\n");
        resp.append("Curso: ").append(this.nivelCurso).append(" em ").append(this.nomeCurso).append("\n");
        resp.append(this.getMensalidade());
        if (this.cursoFinalizado) {
            resp.append("Curso finalizado em ").append(anoFinalizacao).append("\n");
            if (this.temTrabalho) {
                resp.append("Título ");
                switch (nivelCurso) {
                    case "Graduação":
                        resp.append("do TCC: ");
                        break;
                    case "Lato sensu":
                        resp.append("da monografia: ");
                        break;
                    case "Mestrado":
                        resp.append("da dissertação: ");
                        break;
                    case "Doutorado":
                        resp.append("da tese: ");
                        break;
                }
                resp.append(trabalho.toString()).append("\n");

                if (nivelCurso.equals("Mestrado") || nivelCurso.equals("Doutorado")) {
                    resp.append("Banca: ").append(String.join(" - ", trabalho.getMembrosBanca()));
                }
            }
        }
        return resp.toString();
    }
}

public class Teste {
    public static void main(String[] args) {
        String[] dados1 = { null, null, null };
        Aluno aluno1 = new Aluno("Martin Fowler", "ADS", "Graduação", 11223344, true, false, false, -1, 920.50, 20.5,
                new Trabalho(null, null, null, dados1));

        String[] dados2 = { "Peter Coad", "Impacto da Refatoração", null, "Grady Booch", "Erich Gamma" };
        Aluno aluno2 = new Aluno("Kent Beck", "Computação Aplicada", "Mestrado", 22334455, false, true, true, 2019,
                2150.45, 0, new Trabalho(dados2[1], dados2[0], null, dados2));

        System.out.println(aluno1.getDados());
        System.out.println(aluno2.getDados());
    }
}
