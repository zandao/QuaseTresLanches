package academy.learnprogramming.menu;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Menu {

    private static Scanner scanner = new Scanner(System.in);
    private String titulo;
    private String subtitulo;
    private ArrayList<Item> itens;

    public Menu(String titulo) {
        this(titulo, null);
    }

    public Menu(String titulo, String subtitulo) {
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.itens = new ArrayList<Item>();
    }

    public void imprimir() {
        System.out.println("=======================================");
        System.out.println("      " + titulo);
        if (subtitulo != null) {
            System.out.println("      " + subtitulo);
        }
        System.out.println("");
        if (itens != null) {
            int itemMenu = 1;
            for (Item item : itens) {
                if (item.getValor() > 0.0) {
                    System.out.println("      " + itemMenu + " - " + item.getTexto() + "  " + item.getValor());
                } else {
                    System.out.println("      " + itemMenu + " - " + item.getTexto());
                }
                itemMenu++;
            }
        }
        System.out.println("");
        System.out.println("      0 - Finalizar " + titulo.toLowerCase());
        System.out.println("=======================================");
    }

    public Item lerOpcao() {
        int opcao = -1;
        while(true) {
            System.out.print("Opção: ");
            boolean isAnInt = scanner.hasNextInt();
            if (isAnInt) {
                opcao = scanner.nextInt();

                if (opcao >= 0 && opcao <= itens.size()+1) {
                    break;
                } else {
                    System.out.println("Opção inválida");
                }
            } else {
                System.out.println("Opção não é número válido");
            }
            scanner.nextLine();
        }
        Item item = null;
        if (opcao > 0) {
            item = itens.get(opcao - 1);
        }
        return item;
    }
    private String formatarPreco(String item, Double valor) {
        return String.format("%1$20s", item) + "R$ " + String.format(Locale.GERMAN, "%,.2f", valor);
    }

    public void adicionarItem(String nome, String texto) {
        itens.add(new Item(nome, texto,0.0));
    }

    public void adicionarItemComPreco(String nome, String texto, Double valor) {
        Item novoItemDeMenu = new Item(nome, formatarPreco(texto, valor), valor);
        itens.add(novoItemDeMenu);
    }


}
