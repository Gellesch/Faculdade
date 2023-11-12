public class pedido {
    int numero;
    Produto produto1;
    int quantidade;
    double valor;

    Pedido(int numero, Produto produto1, int quantidade){
        this.numero = numero;
        this.item = item;
        this.quantidade = quantidade;
    }

    public double calculaPedido() {
        valor = produto.preco * quantidade;
        return valor;
    }

    public void toString(int numero, Produto produto1, int quantidade) {
        System.out.println("Numero do pedido: " + numero);
        System.out.println("Codigo do Produto: " + produto1.cod);
        System.out.println("Descricao: " + produto1.descricao);
        System.out.println("Quantidade: " + quantidade);
    }
}
