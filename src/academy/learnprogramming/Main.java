package academy.learnprogramming;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main{
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Pedido> listaDePedidosMain =  new ArrayList<Pedido>();
    private static LinkedList<Cliente> listaDeClientesMain = new LinkedList<Cliente>();
    private static Cliente cliente =new Cliente("Nick","123","123",listaDePedidosMain);
    private static ListaDeClientes clientes = new ListaDeClientes(listaDeClientesMain);

    public static void main(String[] args) {

        menuInicial();


    }

    public static void menu(){
        System.out.println("=======================================");
        System.out.println("            Menu de opcoes");
        System.out.println("              1 - Pizzas");
        System.out.println("              2 - Lanches");
        System.out.println("             3 - Salgados");
        System.out.println("     4 - Mostrar lista de pedidos");
        System.out.println("       5 - Excluir item do carrio");
        System.out.println("         0 - Finalizar pedido");
        System.out.println("=======================================");
    }

    public static void mostrarListaDePedidos(){
        cliente.listaDePedidos();
        System.out.println("Valor total do pedio R$"+cliente.totalDoPedido());
    }

    public static void escolhaMenuPrincipal(){
        menu();
        System.out.print("Digite sua opcao: ");

        boolean sair = false;
        while (!sair){
            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao){
                case 0:
                    if (cliente.existePedidos()) {
                        System.out.println("Voce esta quase la, so falta mais algumas informacoes");
                        finalizarPedido();
                        sair = true;
                        break;
                    }else {
                        System.out.println("Cliente nao possui itens no carrinho para que possa ser finalizado");
                        menu();
                        break;
                    }
                case 1:
                    menuPrincipalAdicionarPizza();
                    menu();
                    break;
                case 2:
                    menuPrincipalAdicionarLanche();
                    menu();
                    break;
                case 3:
                    menuPrincipalAdicionarSalgadinhos();
                    menu();
                    break;
                case 4:
                    mostrarListaDePedidos();
                    menu();
                    break;
                case 5:
                    excluirItemDoCarrinho();
                    menu();
                    break;
                case 6:
                    mostrarListaDeClientes();
                    menu();
                    break;
                default:
                    System.out.println("Valor invalido digite um valor valido");
                    break;
            }
        }
    }

    public static void menuPrincipalAdicionarPizza(){
        Pizza pizza = new Pizza("pizza",0);
        pizza.escolhaDePizza();
        Pedido pedido = Pedido.criarPedidoUnitario(pizza.getSaborDaPizza(), pizza.getPreco());
        cliente.adicionarPedidosDoCliente(pedido);
    }

    public static void menuPrincipalAdicionarLanche(){
        Lanche lanche = new Lanche();
        double valorDoLanche = lanche.adicaoDeIngredientes();
        Pedido pedido = Pedido.criarPedidoUnitario(lanche.getNomeDoLanche(),valorDoLanche);
        cliente.adicionarPedidosDoCliente(pedido);
    }

    public static void menuPrincipalAdicionarSalgadinhos(){
        Salgadinhos salgadinhos = new Salgadinhos();
        salgadinhos.escolherSalgado();
        Pedido pedido = Pedido.criarPedidoUnitario(salgadinhos.getTipoDeSalgado(), salgadinhos.getPrecoSalgado());
        cliente.adicionarPedidosDoCliente(pedido);
    }

    public static void finalizarPedido(){
            double valorTotal = 0;
            System.out.println("Escolha o tipo de entrega:");
            System.out.println("1 - Retirada no local.");
            System.out.println("2 - Entrega domiciliar.");
            System.out.println("Caso a modalidade desejada seja entrega domiciliar uma taxa de entrega  de R$5.00 sera cobrada.");
            int entrega = 0;
            boolean sair = false;
            while (!sair) {
                entrega = scanner.nextInt();
                scanner.nextLine();
                switch (entrega) {
                    case 1:
                        valorTotal = cliente.totalDoPedido();
                        System.out.println("Rtirada no locar selecionado com sucesso!");
                        cadastrarDadosDeEntregaDoCliente();
                        sair = true;
                        break;
                    case 2:
                        valorTotal = cliente.totalDoPedido() + cliente.getTaxa();
                        System.out.println("Entrega domicilar selecionada com sucesso!");
                        cadastrarDadosDeEntregaDoCliente();
                        sair = true;
                        break;
                    default:
                        System.out.println("no momento so temos essas duas opicoes, por favor digite um valor valido.");

                }
            }

            String formaDePagamento = null;
            int precisaDetroco = 0;
            double troco = 0;
            System.out.println("Qual tipo de pagamento?");
            System.out.println("1 - Cartao de credito.");
            System.out.println("2 - Dinheiro");
            sair = false;
            while (!sair) {
                int tipoDePagamento = scanner.nextInt();
                scanner.nextLine();
                switch (tipoDePagamento) {
                    case 1:
                        System.out.println("Pagamento com cartao de credito selecionado com sucesso!");
                        formaDePagamento = ("Cartao de credito");
                        sair = true;
                        break;
                    case 2:
                        System.out.println("Pagamamento em dinheiro selecionado com sucesso!");
                        formaDePagamento = ("Dinehrio");
                        System.out.println("Sera necessario troco?\n" +
                                "1  - Sim\n" +
                                "2 - Nao \n");
                        boolean sair2 = false;
                        while (!sair2) {
                            precisaDetroco = scanner.nextInt();
                            scanner.nextLine();
                            switch (precisaDetroco) {
                                case 1:
                                    System.out.println("Digite o valor disponibilizado:");
                                    double valorDisponibilizad = scanner.nextInt();
                                    scanner.nextLine();
                                    troco = valorDisponibilizad - valorTotal;
                                    System.out.println("Troco R$" + troco);
                                    System.out.println("Obrigado");
                                    sair2 = true;
                                    break;
                                case 2:
                                    System.out.println("obrigado");
                                    sair2 = true;
                                    break;
                                default:
                                    System.out.println("Valor invaluido por favor insira um valor valido");
                                    break;
                            }
                        }
                        sair = true;
                        break;
                }

            }
            revisaoPedido(valorTotal, formaDePagamento, troco, precisaDetroco,entrega);
    }

    public static void cadastrarDadosDeEntregaDoCliente(){
        System.out.println("Digite o nome completo Do Cliente:");
        String nomeDoCLiente = scanner.nextLine();
        if (clientes.procurarCliente(nomeDoCLiente) != null){
            //cliente ja esta presente na lista nao precisa dos dados
        }else {
            cliente.setNomeDoCliente(nomeDoCLiente);
            System.out.println("Digite o endereco de entrega:");
            String enderecoDoCliente = scanner.nextLine();
            cliente.setEnderecoDoCliente(enderecoDoCliente);
            System.out.println("Digite o telefone de Contato:");
            String telefoneDoCliente = scanner.nextLine();
            cliente.setNumeroDeTelefoneDoCliente(telefoneDoCliente);
            clientes.adicionarCliente(nomeDoCLiente,enderecoDoCliente,telefoneDoCliente,cliente.getPedidos());
        }
    }

    public static void revisaoPedido(double valorTotal,String formaDePagamento,double troco, int precisaDetroco,int entrega) {
        System.out.println("|===========Revisao do pedido===========|");
        System.out.println("Cliente: " + cliente.getNomeDoCliente());
        System.out.println("|---------------------------------------|");
        System.out.println("Pedidos:");
        cliente.listaDePedidos();
        if (entrega==2){
            System.out.println("Taxa de entrega: 5.0" );
        }
        System.out.println("|---------------------------------------|");
        System.out.println("Valor todal do pedido: R$" + valorTotal);
        System.out.println("|---------------------------------------|");
        System.out.println("Forma de pagamento: " + formaDePagamento);
        System.out.println("|---------------------------------------|");
        if (precisaDetroco == 1) {
            System.out.println("|Trco: R$" + troco);
        }
        System.out.println("|=======================================|");

        System.out.println("Muito obrigado por escolher a Quase Tres");
        System.out.println("******************************************");
        System.out.println(" ");
        System.out.println(" ");
        menuInicial();
    }

    public static void excluirItemDoCarrinho(){
        cliente.listaDePedidos();
        System.out.println("Digite o indicie do item a ser excluido do carrinho:");
        int itemParaExcluir = scanner.nextInt();
        scanner.nextLine();
        if(!cliente.removerPedidoDoCliente((itemParaExcluir))){
            excluirItemDoCarrinho();
        }
    }

    public static void mostrarListaDeClientes() {
        for (int i = 0; i < clientes.tamanhoDaLista(); i++){
            clientes.mostrarlistaDeClientes(i);
            System.out.println("=======================================");
            //System.out.println("Pedidos: ");
           // for (int j = 0; j < cliente.getPedidos().size(); j++) {
            //System.out.println(cliente.getPedidos().get(j).getPedidos()+ " - "+cliente.getPedidos().get(j).getValor());
            //}
        }
    }

    public static void menuInicial(){
        System.out.println("=======================================");
        System.out.println("           QAUSE TRES LANCHES");
        System.out.println("        1 - Realizar novo pedido");
        System.out.println("      2 - Gerenciamento de clientes");
        System.out.println("         0 - Finalizar programa");
        System.out.println("=======================================");
        System.out.print("Opcao: ");
        boolean sair = false;
        while (!sair){
            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao){
                case 0:
                    System.out.println("Programa sendo finalizado...");
                    sair = true;
                    break;
                case 1:
                    escolhaMenuPrincipal();
                    break;
                case 2:
                    menuDeGerenciamentoDeClientes();
                    break;
                default:
                    System.out.println("Opcao inexistente por favor entre com uma opcao valida");
                    break;
            }
        }
    }

    public static void menuDeGerenciamentoDeClientes(){
        System.out.println("=======================================");
        System.out.println("     1 - Mostrar lista de clientes");
        System.out.println("2 - Mostrar lista de pedidos do cliente");
        System.out.println("          3 - Adicinar cliente");
        System.out.println("           4 - Remover cliente");
        System.out.println("       5 - Editar dados de cliente");
        System.out.println("        0 - Voltar ao meun inicial");
        System.out.println("=======================================");
        escolhaDeGerenciamentoDeCliente();
    }

    public static void escolhaDeGerenciamentoDeCliente(){
        boolean sair = false;
        while (!sair){
            System.out.print("Digite uma opcao: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao){
                case 0:
                    System.out.println("Retornando ao meu inicial...");
                    menuInicial();
                    sair= true;
                    break;
                case 1:
                    mostrarListaDeClientes();
                    menuDeGerenciamentoDeClientes();
                    sair = true;
                    break;
                case 2:
                    mostrarPedidosDoCliente();
                    menuDeGerenciamentoDeClientes();
                    sair = true;
                    break;
                case 3:
                    adicionarNovoCliente();
                    menuDeGerenciamentoDeClientes();
                    sair = true;
                    break;
                case 4:
                    removerAntigoCliente();
                    menuDeGerenciamentoDeClientes();
                    sair = true;
                    break;
                case 5:
                    editarCliente();
                    menuDeGerenciamentoDeClientes();
                    sair = true;
                    break;
                default:
                    System.out.println("Opcao invalida, por favor entre com um valor valido");
            }
        }
    }

    public static void mostrarPedidosDoCliente(){
        System.out.println("Digite o nome completo do cliente:");
        String nome = scanner.nextLine();
        if (clientes.procurarCliente(nome)!=null){
            Cliente novoCliente = clientes.procurarCliente(nome);
            if (novoCliente.getPedidos()!=null){
                for (int i = 0; i<novoCliente.getPedidos().size(); i++){
                    System.out.println("Pedido "+(i+1)+
                            novoCliente.getPedidos().get(i).getPedidos()+" - "+
                            novoCliente.getPedidos().get(i).getPedidos());
                }
            }else {
                System.out.println("Cliente ainda nao possui pedidos realizados");
            }
        }else {
            System.out.println(nome+", nao foi encontrado em nossa lista de clientes");
        }
    }

    public static void adicionarNovoCliente(){
        System.out.println("Digite o nome completo do cliente:");
        String nomeDoCliente = scanner.nextLine();
        System.out.println("Digite o endereco do cliente:");
        String enderecoDoCliente = scanner.nextLine();
        System.out.println("Digite o telefone do cliente");
        String telefoneDoCliente = scanner.nextLine();
        clientes.adicionarCliente(nomeDoCliente,enderecoDoCliente,telefoneDoCliente,new ArrayList<Pedido>());
    }

    public static void removerAntigoCliente(){
        System.out.println("Digite o nome completo do cliente a ser removido:");
        String nomeDoCliente = scanner.nextLine();
        clientes.removerCliente(nomeDoCliente);
    }

    public static void editarCliente(){
        System.out.println("Digite o nome completo do cliente:");
        String nomeDoCliente = scanner.nextLine();
        Cliente dadosDoCliente = clientes.procurarCliente(nomeDoCliente);
        if (dadosDoCliente != null){
            System.out.println("1 -Nome: "+dadosDoCliente.getNomeDoCliente());
            System.out.println("2 -Endereco: "+dadosDoCliente.getEnderecoDoCliente());
            System.out.println("3 -Telefone: "+dadosDoCliente.getNumeroDeTelefoneDoCliente());
            System.out.println("Campo a ser alterando:");
            boolean sair = false;
            while (!sair){
                int opcao = scanner.nextInt();
                scanner.nextLine();
                switch (opcao){
                    case 1:
                        System.out.println("Digite o novo nome do cliente");
                        String novoNome = scanner.nextLine();
                        dadosDoCliente.setNomeDoCliente(novoNome);
                        System.out.println("Nome alterado com sucesso.");
                        sair = true;
                        break;
                    case 2:
                        System.out.println("Digite o novo endereco do cliente:");
                        String novoEndereco = scanner.nextLine();
                        dadosDoCliente.setEnderecoDoCliente(novoEndereco);
                        System.out.println("Endereco alterado com sucesso");
                        sair=true;
                        break;
                    case 3:
                        System.out.println("Digite o novo telefone do cliente:");
                        String novoTelefone=scanner.nextLine();
                        dadosDoCliente.setNumeroDeTelefoneDoCliente(novoTelefone);
                        System.out.println("Telefone alterado com sucesso");
                        sair=true;
                        break;
                    default:
                        System.out.println("Opcao invalida por favor entre com um valor valido");
                        break;
                }
            }

        }else {
            System.out.println("Cliente nao encontrado");
        }
    }

}
