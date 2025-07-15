package acoes;

import modelo.Requerimento;
import modelo.AtividadeSelecionada;

public class AcaoAdicionarAtividade implements Acao {
    private Requerimento requerimento;
    private AtividadeSelecionada atividadeSel;

    public AcaoAdicionarAtividade(Requerimento requerimento, AtividadeSelecionada atividadeSel) {
        this.requerimento = requerimento;
        this.atividadeSel = atividadeSel;
    }

    @Override
    public void executar() {
        requerimento.adicionarAtividade(atividadeSel);
        System.out.println("Atividade adicionada: " + atividadeSel.getAtividade().getNome());
    }
}