package modelo;

public class Atividade {
    private int id;
    private String nome;
    private int limiteHoras;

    public Atividade(int id, String nome, int limiteHoras) {
        this.id = id;
        this.nome = nome;
        this.limiteHoras = limiteHoras;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public int getLimiteHoras() { return limiteHoras; }

    @Override
    public String toString() {
        return id + ") " + nome + " (limite " + limiteHoras + "h)";
    }
}