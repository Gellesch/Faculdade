public class vendas {
    public static void main(String[] args) {
        Produto produto1 = new Produto(1234, "caderno", 18.30);
        Pedido pedido1 = new Pedido(58763, produto1, 500);
        pedido1.calculaPedido();
        System.out.println("informacoes do Pedido");
        System.out.println(pedido1.toString());
    }
}
