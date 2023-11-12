package projlistaobj;

public class ProjListaObj {

    public static void main(String[] args) {
        Vetor listaAluno = new Vetor(10);
        try{
            Aluno a1 = new Aluno(12345,"Pedro",7.5);
            Aluno a2 = new Aluno(67890,"Maria",8.5);
            listaAluno.add(0, a1);
            listaAluno.add(1, a2);
            Aluno aux = listaAluno.get(0);
            aux.mostraAluno();
            Aluno a3 = new Aluno(67890,"Maria",10);
            listaAluno.set(1, a3);
            int teste = listaAluno.search("Pedro");
            if (teste != -1)
                System.out.println("Pedro está na posição " + teste + " da lista");
            else
                System.out.println("Pedro não existe na lista");
            Aluno[] aux1 = listaAluno.getArray();
            for (int i=0; i<listaAluno.size();i++)
                aux1[i].mostraAluno();
            
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
