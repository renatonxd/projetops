package relatorios;

import modelo.AtividadeSelecionada;

public class RelatorioComAjuste extends RelatorioBase {
    private AtividadeSelecionada as;

    public RelatorioComAjuste(RelatorioAtividade base, AtividadeSelecionada as) {
        super(base);
        this.as = as;
    }

    @Override
    public String montar() {
        String texto = super.montar();
        if (as.getHorasValidadas() < as.getHorasDeclaradas()) {
            texto += "  Observação: " + as.getObservacao() + "\n";
        }
        return texto;
    }
}