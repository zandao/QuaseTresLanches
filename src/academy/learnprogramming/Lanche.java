package academy.learnprogramming;

import java.util.Scanner;

public class Lanche implements MenuDemontagem{
    private double precoDoAdicional;
    private String nomeDoLanche;

    public Lanche() {
        this.nomeDoLanche = "Lanche Personalizado";

    }

    @Override
    public void opcoesDeMontagem() {
        System.out.println("=======================================");
        System.out.println("      Menu de opicoes de montagem");
        System.out.println("                 Pao:");
        System.out.println("          1 - Simpes: R$2,00");
        System.out.println("          2 - Brioche: R$5,00");
        System.out.println("                Recheios:");
        System.out.println("         1 - Mussarela: R$2.00");
        System.out.println("           2 - Frango: R$2.50");
        System.out.println("            3 - Bacon: R$3.00");
        System.out.println("           4 - Presunto: R$2.00");
        System.out.println("            5 - Tomate: R$2.00");
        System.out.println("          6 - Hamburguer: R$6.00");
        System.out.println("             7 - Ovo: R$2.00");
        System.out.println("                 Molhos:");
        System.out.println("         1 - Catchup: R$1.00");
        System.out.println("      2 - Molho esespecia: R$3.00");
        System.out.println("=======================================");

    }

    @Override
    public double adicaoDeIngredientes() {
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;
        opcoesDeMontagem();

        while (!sair) {
            System.out.println("Tipo de pao:");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("Pao simples adicionada por R$2.00");
                    setPrecoDoAdicional(2+getPrecoDoAdicional());
                    sair = true;
                    break;
                case 2:
                    System.out.println("Pao brioche adicionada por R$5.00");
                    setPrecoDoAdicional(5 + getPrecoDoAdicional());
                    sair= true;
                    break;
                default:
                    System.out.println("Valor invalido, digite novamente.");
                    break;
            }
        }
        System.out.println("Recheio: ");
        System.out.println("(Quando finalizar escolha digite 0)");
        sair = false;
        while (!sair) {
            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 0:
                    sair = true;
                    break;
                case 1:
                    System.out.println("Mussarela adicionadapor R$2.00");
                    setPrecoDoAdicional(2 + getPrecoDoAdicional());
                    break;
                case 2:
                    System.out.println("Frango adicionadapor R$2.50");
                    setPrecoDoAdicional(2.5 + getPrecoDoAdicional());
                    break;
                case 3:
                    System.out.println("Baacon adicionadapor R$3.00");
                    setPrecoDoAdicional(3 + getPrecoDoAdicional());
                    break;
                case 4:
                    System.out.println("Presunto adicionadapor R$2.00");
                    setPrecoDoAdicional(2 + getPrecoDoAdicional());
                    break;
                case 5:
                    System.out.println("Tomate adicionadapor R$2.00");
                    setPrecoDoAdicional(2+getPrecoDoAdicional());
                    break;
                case 6:
                    System.out.println("Hamburguer adicionadapor R$6.00");
                    setPrecoDoAdicional(6+getPrecoDoAdicional());
                    break;
                case 7:
                    System.out.println("Ovo adicionadapor R$2.00");
                    setPrecoDoAdicional(2+getPrecoDoAdicional());
                    break;
                default:
                    System.out.println("Valor invalido, digite novamente.");
                    break;
            }
        }
        System.out.println("Molho: ");
        sair=false;
        while (!sair) {
            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:System.out.println("Catchup adicionadapor R$1.00");
                    setPrecoDoAdicional(1+getPrecoDoAdicional());
                    sair = true;
                    break;
                case 2:
                    System.out.println("Molho especial adicionadapor R$3.00");
                    setPrecoDoAdicional(3+getPrecoDoAdicional());
                    sair= true;
                    break;
                default:
                    System.out.println("valor invalido por favor insira um valor valido");
                    break;
            }
        }
        System.out.println(getNomeDoLanche()+", adicionado por R$"+getPrecoDoAdicional());
        return getPrecoDoAdicional();
    }

    public double getPrecoDoAdicional() {
        return precoDoAdicional;
    }

    public void setPrecoDoAdicional(double precoDoAdicional) {
        this.precoDoAdicional = precoDoAdicional;
    }

    public String getNomeDoLanche() {
        return nomeDoLanche;
    }

}
