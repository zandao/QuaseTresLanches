package academy.learnprogramming.menu;

public class Item {
    private String nome;
    private String texto;
    private Double valor;

    public Item(String nome, String texto) {
        this(nome, texto, 0.0);
    }

    public Item(String nome, String texto, Double valor) {
        this.nome = nome;
        this.texto = texto;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}