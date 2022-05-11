package academy.learnprogramming;

import java.util.ArrayList;

public class Cliente {
    private String nomeDoCliente;
    private String enderecoDoCliente;
    private String numeroDeTelefoneDoCliente;
    private double taxa;
    private final ArrayList<Pedido> pedidos;

    public Cliente(String nomeDoCliente, String enderecoDoCliente, String numeroDeTelefoneDoCliente, ArrayList<Pedido> pedidos) {
        this.nomeDoCliente = nomeDoCliente;
        this.enderecoDoCliente = enderecoDoCliente;
        this.numeroDeTelefoneDoCliente = numeroDeTelefoneDoCliente;
        this.taxa = 5;
        this.pedidos = pedidos;
    }

    public void adicionarPedidosDoCliente (Pedido pedido){
        this.pedidos.add(pedido);
        System.out.println("Pedido adicionado com sucesso!");

    }

    public boolean removerPedidoDoCliente(int index){
        if (procurarItemPorIndex(index)){
            pedidos.remove(index-1);
            System.out.println("Item excluido com sucesso!");
            return true;
        }else {
            System.out.println("Item nao encontrado no carrinho");
            System.out.println("Por favor entre com um item valido para ser excluido");
            return false;
        }
    }

    public boolean procurarItemPorIndex(int index){

        if ( index<= pedidos.size() && index>0){
            System.out.println(pedidos.size());
            return true;
        }else {
            return false;
        }
    }

    public String getNomeDoCliente() {
        return nomeDoCliente;
    }

    public double totalDoPedido(){
        double total = 0 ;
        for (int i = 0 ; i < pedidos.size() ; i ++){
            total += pedidos.get(i).getValor();
        }
        return total;
    }

    public double getTaxa() {
        return taxa;
    }

    public void setNomeDoCliente(String nomeDoCliente) {
        this.nomeDoCliente = nomeDoCliente;
    }

    public void listaDePedidos (){
        if (!existePedidos()){
            System.out.println("Nao existe itens no carrinho de compras.");
        }else {
            for (int i = 0; i < pedidos.size(); i++) {
                System.out.println("Item " + (i + 1) + ": " + pedidos.get(i).getPedidos() + ", " + pedidos.get(i).getValor());
            }
        }
    }

    public boolean existePedidos(){
        if (pedidos.isEmpty()){
            return false;
        }else {
            return true;
        }
    }

    public String getEnderecoDoCliente() {
        return enderecoDoCliente;
    }

    public void setEnderecoDoCliente(String enderecoDoCliente) {
        this.enderecoDoCliente = enderecoDoCliente;
    }

    public String getNumeroDeTelefoneDoCliente() {
        return numeroDeTelefoneDoCliente;
    }

    public void setNumeroDeTelefoneDoCliente(String numeroDeTelefoneDoCliente) {
        this.numeroDeTelefoneDoCliente = numeroDeTelefoneDoCliente;
    }

    public ArrayList<Pedido> getPedidos() {
        return this.pedidos;
    }



}
