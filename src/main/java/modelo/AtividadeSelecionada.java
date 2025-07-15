package modelo;

public class AtividadeSelecionada {
    private Atividade atividade;
    private int horasDeclaradas;
    private int horasValidadas;
    private String observacao = "";

    public AtividadeSelecionada(Atividade atividade, int horasDeclaradas) {
        this.atividade = atividade;
        this.horasDeclaradas = horasDeclaradas;
        this.horasValidadas = horasDeclaradas;
    }

    public Atividade getAtividade() { return atividade; }
    public int getHorasDeclaradas() { return horasDeclaradas; }
    public int getHorasValidadas() { return horasValidadas; }
    public String getObservacao() { return observacao; }

    public void setHorasValidadas(int horasValidadas) {
        this.horasValidadas = horasValidadas;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}