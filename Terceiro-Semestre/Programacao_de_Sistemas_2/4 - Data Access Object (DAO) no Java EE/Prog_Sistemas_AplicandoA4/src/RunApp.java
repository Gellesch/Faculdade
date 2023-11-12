import java.util.Scanner;
import java.util.ArrayList;

public class RunApp {
    public static void main(String[] args) {
        //recebendo input do usuário
        Scanner input = new Scanner(System.in);
        Funcionario funcionario = new Funcionario();
        
        System.out.println("Digite os valores para inserir na tabela: ");
        System.out.println("Informe o Numat: ");
        funcionario.setNumat(Integer.parseInt(input.nextLine()));

        System.out.println("Informe o Nome: ");
        funcionario.setNome(input.nextLine());
        
        System.out.println("Informe o Salário: ");
        funcionario.setSalario(Double.parseDouble(input.nextLine()));
        
        System.out.println("Sexo: ");
        funcionario.setSexo(input.nextLine().charAt(0));
        
        System.out.println("Informe o NDepto: ");
        funcionario.setNdepto(Integer.parseInt(input.nextLine()));
        
        System.out.println("Informe o Nsuper: ");
        funcionario.setNsuper(Integer.parseInt(input.nextLine()));
        
        System.out.println("Cadastro no BD concluido!");
        System.out.println("-----------------------------");
        System.out.println("Funcionarios atualmente no BD: ");
        System.out.println();

        FuncionarioDao dao = new FuncionarioDao();
        dao.addFuncionario(funcionario);
        ArrayList <Funcionario> listaFuncionario = dao.getLista();
        for (Funcionario f:listaFuncionario)
            System.out.println("Numat: " + f.getNumat()+" "+
                               "Nome: " + f.getNome()+" "+
                               "Salario: " + f.getSalario()+" "+
                               "Sexo: " + f.getSexo()+" "+
                               "NDepto: " + f.getNdepto()+" "+
                               "NSuper: " + f.getNsuper());
    }
    
}
