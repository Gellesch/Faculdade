/*Observe o código disponível em: < https://ideone.com/tIRV4G>.  
 
Refatore-o, utilizando as duas técnicas de refatoração aprendidas até o momento. 
 
Dica: é importante que você tenha lido o Texto de Apoio para realizar a atividade.   
 
O objetivo desta atividade é que você treine seus conhecimentos. Ao final do prazo da atividade, será disponibilizada a videoaula com a resolução.   
 
Esta atividade vale créditos que, ao final do componente curricular, serão convertidos em nota de participação.  



1. Extrair Método:

Vamos extrair o trecho de código que calcula a mensalidade com desconto para um método separado.

java*/

class Aluno {
    private String nome, nome_curso, nível_curso;
    private int cód_matrícula;
    private boolean é_bolsista;
    private double mensalidade_curso, desconto;

    public Aluno(String nome, String nome_curso, String nível_curso, int cód_matrícula, boolean é_bolsista,
            double mensalidade_curso, double desconto) {
        this.nome = nome;
        this.nome_curso = nome_curso;
        this.nível_curso = nível_curso;
        this.cód_matrícula = cód_matrícula;
        this.é_bolsista = é_bolsista;
        this.mensalidade_curso = mensalidade_curso;
        this.desconto = desconto;
    }

    private double calcularMensalidadeComDesconto() {
        return this.mensalidade_curso * (1 - this.desconto / 100);
    }

    public String getDados() {
        String resp = "Aluno: " + this.nome + "\n";
        resp += "Curso: " + this.nível_curso + " em " + this.nome_curso + "\n";
        if (é_bolsista) {
            resp += "Bolsista com desconto de: " + this.desconto + "%\n";
            resp += "Mensalidade: R$ " + calcularMensalidadeComDesconto();
        } else {
            resp += "Mensalidade: R$ " + this.mensalidade_curso;
        }
        return resp;
    }
}

class Teste {
    public static void main(String args[]) {
        Aluno a1 = new Aluno("Martin Fowler", "ADS", "Graduação", 11223344, true, 920.50, 20.5);
        Aluno a2 = new Aluno("Kent Beck", "Computação Aplicada", "Mestrado", 22334455, false, 2150.45, 0);
        System.out.println(a1.getDados());
        System.out.println(a2.getDados());
    }
}

/*
 * 2. Mover Método:
 * 
 * Vamos mover o método getDados para uma classe separada chamada RelatorioAluno
 * para melhorar a coesão.
 * 
 * java
 */

class Aluno {
    private String nome, nome_curso, nível_curso;
    private int cód_matrícula;
    private boolean é_bolsista;
    private double mensalidade_curso, desconto;

    public Aluno(String nome, String nome_curso, String nível_curso, int cód_matrícula, boolean é_bolsista,
            double mensalidade_curso, double desconto) {
        this.nome = nome;
        this.nome_curso = nome_curso;
        this.nível_curso = nível_curso;
        this.cód_matrícula = cód_matrícula;
        this.é_bolsista = é_bolsista;
        this.mensalidade_curso = mensalidade_curso;
        this.desconto = desconto;
    }

    private double calcularMensalidadeComDesconto() {
        return this.mensalidade_curso * (1 - this.desconto / 100);
    }

    public String getDados() {
        return RelatorioAluno.gerarRelatorio(this);
    }
}

class RelatorioAluno {
    public static String gerarRelatorio(Aluno aluno) {
        String resp = "Aluno: " + aluno.getNome() + "\n";
        resp += "Curso: " + aluno.getNível_curso() + " em " + aluno.getNome_curso() + "\n";
        if (aluno.isÉ_bolsista()) {
            resp += "Bolsista com desconto de: " + aluno.getDesconto() + "%\n";
            resp += "Mensalidade: R$ " + aluno.calcularMensalidadeComDesconto();
        } else {
            resp += "Mensalidade: R$ " + aluno.getMensalidade_curso();
        }
        return resp;
    }
}

class Teste {
    public static void main(String args[]) {
        Aluno a1 = new Aluno("Martin Fowler", "ADS", "Graduação", 11223344, true, 920.50, 20.5);
        Aluno a2 = new Aluno("Kent Beck", "Computação Aplicada", "Mestrado", 22334455, false, 2150.45, 0);
        System.out.println(a1.getDados());
        System.out.println(a2.getDados());
    }
}