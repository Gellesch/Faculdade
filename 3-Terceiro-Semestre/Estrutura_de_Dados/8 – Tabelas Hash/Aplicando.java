/*
Visto isso, faça uma aplicação em Java que armazene, em uma tabela Hash de tamanho = 10, objetos do tipo produto que têm os seguintes atributos: 
Código produto – String (padrão GTIN-13) 
Descrição do produto – String 
Preço – double 
De acordo com a proposta, você deverá criar a classe Produto, bem como a classe para armazenar a Tabela Hash e a classe de teste. 
Na classe de teste, cadastre diversos produtos e execute as operações de exclusão e busca de produtos, conforme os modelos estudados. 
ATENÇÃO: 
1) O código do produto deve ser validado, isto é, deve conter obrigatoriamente 13 dígitos no momento do cadastramento; a descrição não pode estar em branco e o preço deve ser maior que zero. 
2) Você deverá implementar alguma funcionalidade diferente em seu código (mostrar o nome do país, contar quantos produtos são de um mesmo país ou alguma outra funcionalidade qualquer). 
3) Você poderá optar pelo método do tratamento das colisões que desejar: Separate Chaining ou Linear Probing. 
4) A função hash deverá ser calculada levando-se em consideração apenas os três primeiros caracteres do código do produto, os quais indicam o país de origem. Você poderá criar sua própria função hash, ou, ainda, usar alguma das estudadas no curso. 
*/

import java.util.LinkedList;

class Produto {
    private String codigoProduto;
    private String descricao;
    private double preco;

    public Produto(String codigoProduto, String descricao, double preco) {
        this.codigoProduto = codigoProduto;
        this.descricao = descricao;
        this.preco = preco;
    }

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "codigoProduto='" + codigoProduto + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                '}';
    }
}

class TabelaHash {
    private static final int TAMANHO_TABELA = 10;
    private LinkedList<Produto>[] tabela;

    public TabelaHash() {
        tabela = new LinkedList[TAMANHO_TABELA];
        for (int i = 0; i < TAMANHO_TABELA; i++) {
            tabela[i] = new LinkedList<>();
        }
    }

    private int calcularHash(String codigoProduto) {
        // Função de hash simples usando os três primeiros caracteres do código do
        // produto
        return (codigoProduto.charAt(0) + codigoProduto.charAt(1) + codigoProduto.charAt(2)) % TAMANHO_TABELA;
    }

    public void cadastrarProduto(Produto produto) {
        if (produto.getCodigoProduto().length() != 13 || produto.getDescricao().isEmpty() || produto.getPreco() <= 0) {
            System.out.println("Erro: Produto inválido. Verifique os requisitos.");
            return;
        }

        int indice = calcularHash(produto.getCodigoProduto());
        tabela[indice].add(produto);
        System.out.println("Produto cadastrado com sucesso.");
    }

    public void excluirProduto(String codigoProduto) {
        int indice = calcularHash(codigoProduto);
        tabela[indice].removeIf(produto -> produto.getCodigoProduto().equals(codigoProduto));
        System.out.println("Produto excluído com sucesso.");
    }

    public Produto buscarProduto(String codigoProduto) {
        int indice = calcularHash(codigoProduto);
        for (Produto produto : tabela[indice]) {
            if (produto.getCodigoProduto().equals(codigoProduto)) {
                return produto;
            }
        }
        return null; // Produto não encontrado
    }
}

public class TesteTabelaHash {
    public static void main(String[] args) {
        TabelaHash tabelaHash = new TabelaHash();

        // Cadastro de produtos
        tabelaHash.cadastrarProduto(new Produto("7890123456789", "Produto A", 50.0));
        tabelaHash.cadastrarProduto(new Produto("1234567890123", "Produto B", 30.0));
        tabelaHash.cadastrarProduto(new Produto("9876543210987", "Produto C", 25.0));

        // Exclusão de produto
        tabelaHash.excluirProduto("7890123456789");

        // Busca de produto
        Produto produtoEncontrado = tabelaHash.buscarProduto("1234567890123");
        if (produtoEncontrado != null) {
            System.out.println("Produto encontrado: " + produtoEncontrado);
        } else {
            System.out.println("Produto não encontrado.");
        }
    }
}
