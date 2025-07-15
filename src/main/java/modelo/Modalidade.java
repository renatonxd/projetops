package modelo;

import java.util.Arrays;
import java.util.List;

public enum Modalidade {
    ENSINO(1, "Ensino"),
    PESQUISA(2, "Pesquisa e Inovação"),
    EXTENSAO(3, "Extensão"),
    COMPLEMENTACAO(4, "Complementação");

    private int id;
    private String descricao;

    Modalidade(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() { return id; }
    public String getDescricao() { return descricao; }

    public static Modalidade fromId(int id) {
        return Arrays.stream(values())
            .filter(m -> m.id == id)
            .findFirst()
            .orElse(null);
    }

    public List<Atividade> getAtividades() {
        switch (this) {
            case ENSINO:
                return Arrays.asList(
                    new Atividade(1, "Ministrar aula de reforço", 10),
                    new Atividade(2, "Monitoria de laboratório", 15)
                );
            case PESQUISA:
                return Arrays.asList(
                    new Atividade(1, "Apresentação em evento científico", 20),
                    new Atividade(2, "Projeto de iniciação científica", 60)
                );
            case EXTENSAO:
                return Arrays.asList(
                    new Atividade(1, "Projeto de extensão", 60),
                    new Atividade(2, "Ação social comunitária", 40)
                );
            case COMPLEMENTACAO:
                return Arrays.asList(
                    new Atividade(1, "Palestra técnica", 5),
                    new Atividade(2, "Visita técnica", 8)
                );
            default:
                return List.of();
        }
    }
}