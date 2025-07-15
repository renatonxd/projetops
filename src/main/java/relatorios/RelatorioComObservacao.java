package relatorios;

import modelo.AtividadeSelecionada;

public class RelatorioComObservacao extends RelatorioBase {
    private AtividadeSelecionada as;

    public RelatorioComObservacao(RelatorioAtividade base, AtividadeSelecionada as) {
        super(base);
        this.as = as;
    }

    @Override
    public String montar() {
        // possíveis observações adicionais
        return super.montar();
    }
}