package academy.learnprogramming;

import java.util.Scanner;

public class Pizza  {
    private String saborDaPizza;
    private double preco;

    public Pizza(String saborDaPizza, double preco) {
        this.saborDaPizza = saborDaPizza;
        this.preco = preco;
    }

    public void menuDepizzas(){
        System.out.println("=======================================");
        System.out.println("           Menu De pizzas");
        System.out.println("       1 - Calabresa: R$30,00");
        System.out.println("       2 - Marguerita: R$25,00");
        System.out.println("        3 - Mussarela: R$20.00");
        System.out.println("         4 - Frango: R$25.00");
        System.out.println("          5 - Bacon: R$28.00");
        System.out.println("        6 - Portuguesa: R$35.00");
        System.out.println("      7 - Monte sua prorpia pizza");
        System.out.println("=======================================");
    }

    public void escolhaDePizza(){
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;
        menuDepizzas();
        System.out.print("Digite sua opcao de pizza: ");
        while (!sair){
            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao){
                case 1:
                    setPreco(30);
                    setSaborDaPizza("Pizza de calabresa");
                    sair = true;
                    break;
                case 2:
                    setPreco(25);
                    setSaborDaPizza("Pizza marguerita");
                    sair = true;
                    break;
                case 3:
                    setPreco(20);
                    setSaborDaPizza("Pizza de mussarela");
                    sair = true;
                    break;
                case 4:
                    setPreco(25);
                    setSaborDaPizza("Pizza de frango");
                    sair = true;
                    break;
                case 5:
                    setPreco(28.00);
                    setSaborDaPizza("Pizza de bacon");
                    sair = true;
                    break;
                case 6:
                    setPreco(35);
                    setSaborDaPizza("Pizza portuguesa");
                    sair = true;

                    break;
                case 7:
                    MontarPizza montarPizza=new MontarPizza();
                    setPreco(montarPizza.adicaoDeIngredientes());
                    setSaborDaPizza("Pizza personalizada");
                    sair = true;
                    break;
                default:
                    System.out.println("Valore nao valido, digite um valor valido");
                    break;
            }
        }
        System.out.println(getSaborDaPizza()+", adicionada por R$"+getPreco());
    }


    public String getSaborDaPizza() {
        return saborDaPizza;
    }

    public void setSaborDaPizza(String saborDaPizza) {
        this.saborDaPizza = saborDaPizza;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
