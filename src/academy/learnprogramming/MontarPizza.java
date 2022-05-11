package academy.learnprogramming;

import java.io.Console;
import java.util.Scanner;

public class MontarPizza extends Pizza implements MenuDemontagem{
    private double precoDoAdicional;

    public MontarPizza() {
        super("Pizza personalizada",20);
    }

    @Override
    public void opcoesDeMontagem() {
        System.out.println("Menu de opcoes de montagem");
        System.out.println("          Bordas:");
        System.out.println("1 - Simpes: R$0,00");
        System.out.println("2 - Catupiry: R$5,00");
        System.out.println("         Rcheios:");
        System.out.println("1 - Mussarela: R$3.00");
        System.out.println("2 - Frango: R$5.00");
        System.out.println("3 - Bacon: R$6.00");
        System.out.println("4 - Presunto: R$4.00");
        System.out.println("5 - Tomate: R$2.00");
        System.out.println("         Molhos:");
        System.out.println("1 - Tomate: R$3.00");
        System.out.println("2 - Parisiense: R$5.00");
    }

    @Override
    public double adicaoDeIngredientes() {
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;
        opcoesDeMontagem();

        while (!sair) {
            System.out.println("Borda:");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("Borda simples adicionada por R$0.00");
                    setPrecoDoAdicional(0);
                    sair = true;
                    break;
                case 2:
                    System.out.println("Borda de caputiry adicionada por R$5.00");
                    setPrecoDoAdicional(5 + getPrecoDoAdicional());
                    sair= true;
                    break;
                default:
                    System.out.println("Valor invalido, digite novamente.");
                    break;
            }
        }
        System.out.println("Recheio: ");
        System.out.println("(Ao finalizar a escolha dos recheios desejados digite te '0'");
        sair = false;
        while (!sair) {
            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 0:
                    System.out.println("Adiciao de recheio finalizada");
                    sair = true;
                    break;
                case 1:
                    System.out.println("Mussarela adicionadapor R$3.00");
                    setPrecoDoAdicional(3 + getPrecoDoAdicional());
                    break;
                case 2:
                    System.out.println("Frango adicionadapor R$5.00");
                    setPrecoDoAdicional(5 + getPrecoDoAdicional());
                    break;
                case 3:
                    System.out.println("Baacon adicionadapor R$6.00");
                    setPrecoDoAdicional(6 + getPrecoDoAdicional());
                    break;
                case 4:
                    System.out.println("Presunto adicionadapor R$4.00");
                    setPrecoDoAdicional(4 + getPrecoDoAdicional());
                    break;
                case 5:
                    System.out.println("Tomate adicionadapor R$2.00");
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
                case 1:System.out.println("Molho de tomate adicionadapor R$3.00");
                    setPrecoDoAdicional(3+getPrecoDoAdicional());
                    sair = true;
                    break;
                case 2:
                    System.out.println("Molho parisience adicionadapor R$5.00");
                    setPrecoDoAdicional(5+getPrecoDoAdicional());
                    sair= true;
                    break;
                default:
                    System.out.println("valor invalido por favor insira um valor valido");
                    break;
            }
        }
        System.out.println("Valor da pizza personalizada: R$"+getPreco());
        return getPreco();
    }

    @Override
    public double getPreco() {
        return super.getPreco()+getPrecoDoAdicional();
    }

    @Override
    public String getSaborDaPizza() {
        return super.getSaborDaPizza();
    }


    public double getPrecoDoAdicional() {
        return precoDoAdicional;
    }

    public void setPrecoDoAdicional(double precoDoAdicional) {
        this.precoDoAdicional = precoDoAdicional;
    }
}
