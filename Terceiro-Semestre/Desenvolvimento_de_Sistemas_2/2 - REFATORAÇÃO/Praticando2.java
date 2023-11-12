/*Refatore-o, utilizando as técnicas de refatoração aprendidas até o momento. Note que este código é uma modificação do exemplo anterior. Neste código, incluímos as informações sobre o fato de o curso ter um trabalho final obrigatório, e se o curso está finalizado e em que ano. No caso de o curso ter um trabalho final obrigatório, este trabalho recebe nomes diferentes de acordo com o nível do curso (Graduação é um TCC, Mestrado é uma Dissertação etc.) 
 
O objetivo desta atividade é que você treine seus conhecimentos. Ao final do prazo da atividade, será disponibilizada a videoaula com a resolução.  
 
Esta atividade vale créditos que, ao final do componente curricular, serão convertidos em nota de participação. 
*/

class Aluno {
    private String nome, nome_curso, nível_curso;
    private int cód_matrícula, ano_finalização;
    private boolean é_bolsista, curso_finalizado, tem_trabalho;
    private double mensalidade_curso, desconto;
    private String dados_tcc[] = new String[3];

    // [título do trabalho, nome do orientador, nota do trabalho]
    public Aluno(String nome, String nome_curso, String nível_curso, int cód_matrícula, boolean é_bolsista,
            boolean curso_finalizado, boolean tem_trabalho, int ano_finalização, double mensalidade_curso,
            double desconto, String dados_tcc[]) {
        this.nome = nome;
        this.nome_curso = nome_curso;
        this.nível_curso = nível_curso;
        this.cód_matrícula = cód_matrícula;
        this.é_bolsista = é_bolsista;
        this.curso_finalizado = curso_finalizado;
        this.tem_trabalho = tem_trabalho;
        this.ano_finalização = ano_finalização;
        this.mensalidade_curso = mensalidade_curso;
        this.desconto = desconto;
        this.dados_tcc = dados_tcc;
    }

    public String getDados() {
        StringBuilder resp = new StringBuilder("Aluno: " + this.nome + "\n");
        resp.append("Curso: ").append(this.nível_curso).append(" em ").append(this.nome_curso).append("\n");

        if (this.é_bolsista) {
            resp.append("Bolsista com desconto de: ").append(this.desconto).append("%\n");
            resp.append("Mensalidade: R$ ").append(calcularMensalidadeComDesconto()).append("\n");
        } else {
            resp.append("Mensalidade: R$ ").append(this.mensalidade_curso).append("\n");
        }

        if (this.curso_finalizado) {
            resp.append("Curso finalizado em ").append(ano_finalização).append("\n");
            if (this.tem_trabalho) {
                resp.append("Título ").append(obterTituloTrabalho()).append("\n");
                resp.append("Orientador(a): Prof. ").append(dados_tcc[0]).append("\n");
                resp.append("Nota: ").append(dados_tcc[2]);
            }
        }

        return resp.toString();
    }

    private double calcularMensalidadeComDesconto() {
        return this.mensalidade_curso * (1 - this.desconto / 100);
    }

    private String obterTituloTrabalho() {
        switch (nível_curso) {
            case "Graduação":
                return "do TCC: ";
            case "Lato sensu":
                return "da monografia: ";
            case "Mestrado":
                return "da dissertação: ";
            case "Doutorado":
                return "da tese: ";
            default:
                return "";
        }
    }
}

class Teste {
    public static void main(String args[]) {
        String dados1[] = { null, null, null };
        Aluno aluno1 = new Aluno("Martin Fowler", "ADS", "Graduação", 11223344, true, false, false, -1, 920.50, 20.5,
                dados1);

        String dados2[] = { "Peter Coad", "Impacto da Refatoração", "9.5" };
        Aluno aluno2 = new Aluno("Kent Beck", "Computação Aplicada", "Mestrado", 22334455, false, true, true, 2019,
                2150.45, 0, dados2);

        System.out.println(aluno1.getDados());
        System.out.println(aluno2.getDados());
    }
}
