package projprodutos;

import java.util.*;

public class ProjProdutos {

    public static void main(String[] args) {
        TabelaProd compras = new TabelaProd(10);
        Scanner ent = new Scanner(System.in);
        int opc = 0;
        while (opc != 5) {
            System.out.println("MENU");
            System.out.println("1- Inserir Produto");
            System.out.println("2- Excluir Produto");
            System.out.println("3- Consultar Produto");
            System.out.println("4- Quantidade de Produtos");
            System.out.println("5- Encerrar");
            do {
                opc = ent.nextInt();
            } while (opc < 1 || opc > 5);

            String codigo, descricao;
            double preco;

            if (opc == 1) {
                do {
                    System.out.print("Informe o código do produto: ");
                    codigo = ent.next();ent.nextLine();
                } while (codigo.length() != 13);
                
                do {
                    System.out.print("Informe a descrição do produto: ");
                    descricao = ent.nextLine();
                } while (descricao.length() == 0);
                
                do {
                    System.out.print("Informe o preço do produto: R$ ");
                    preco = ent.nextDouble();
                } while (preco <=0);
                
                compras.insere(new Produto(codigo, descricao, preco));
            }
            if (opc == 2) {
                System.out.print("Informe o código do produto que será removido: ");
                codigo = ent.next();                
                compras.remove(codigo);
            }
            if (opc == 3) {
                System.out.print("Informe o código do produto para consulta: ");
                codigo = ent.next();                
                Produto aux = compras.consulta(codigo);
                if (aux != null)
                    System.out.println("Produto= " + aux.getCodigo() + " - " + aux.getDescricao() + " - " + aux.getPreco());
                else
                    System.out.println("Esse produto NÃO está cadastrado!!\n\n");
            }
            if (opc == 4) {
                System.out.println("Quantidade de produtos cadastrados: " + compras.size() + "\n\n");
            }

        }

    }
}
