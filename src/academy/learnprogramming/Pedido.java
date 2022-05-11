package academy.learnprogramming;


public class Pedido {
    private String pedidos;
    private double valor;

    public Pedido(String pedidos, double valor) {
        this.pedidos = pedidos;
        this.valor = valor;
    }
    public static Pedido criarPedidoUnitario(String pedido , double valor){
        return new Pedido(pedido,valor);
    }

    public String getPedidos() {
        return pedidos;
    }

    public double getValor() {
        return valor;
    }

}
