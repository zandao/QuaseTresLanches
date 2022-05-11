package academy.learnprogramming;

import java.util.ArrayList;
import java.util.LinkedList;


public class ListaDeClientes {
    private LinkedList<Cliente> listaDeClientes;

    public ListaDeClientes(LinkedList<Cliente> listaDeClientes) {
        this.listaDeClientes = new LinkedList<>();
    }

    public Cliente procurarCliente(String nomeDoCliente){
        for (Cliente checarCliente: this.listaDeClientes){
            if (checarCliente.getNomeDoCliente().equals(nomeDoCliente)){
                return checarCliente;
            }
        }
        return null;
    }

    public int procurarClienteRetornaIndex(Cliente cliente){
        int index = 0;
        for (Cliente checarCliente : this.listaDeClientes){
            if (checarCliente.equals(cliente)){
                index = listaDeClientes.indexOf(checarCliente);
            }else {
                index = -1;
            }
        }
        return index;
    }

    public boolean removerCliente(String nomeDocliente){
        boolean retorno = true;
        if (procurarCliente(nomeDocliente)!=null){
            Cliente clienteParaExlucir = procurarCliente(nomeDocliente);
            int indexParaRemover = procurarClienteRetornaIndex(clienteParaExlucir);
            if (indexParaRemover!=-1){
                this.listaDeClientes.remove(indexParaRemover);
                System.out.println("Cliente removido com sucesso");
                retorno=  true;
            }else {
                System.out.println("Cliente nao foi encontrado");
                retorno = false;
            }
        }
        return retorno;
    }

    public boolean adicionarCliente(String nomeDoCliente, String enderecodoCliente, String numeroDoCliente, ArrayList<Pedido> pedidos){
        if (procurarCliente(nomeDoCliente) == null){
            this.listaDeClientes.add(new Cliente(nomeDoCliente,enderecodoCliente,numeroDoCliente,pedidos));
            System.out.println("Cliente adicionado com sucesso");
            return true;
        }
        System.out.println("Cliente ja existe na lista de clientes cadastrados.");
        return false;
    }

    public void mostrarlistaDeClientes(int i){
            System.out.println("Nome: "+listaDeClientes.get(i).getNomeDoCliente()+
                    "\nEndereco: "+listaDeClientes.get(i).getEnderecoDoCliente()+
                    "\nTelefone: " +listaDeClientes.get(i).getNumeroDeTelefoneDoCliente());

    }

    public int tamanhoDaLista(){
        return listaDeClientes.size();
    }

}
