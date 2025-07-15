package avaliacao;

import modelo.AtividadeSelecionada;

public class ValidadorLimite extends Validador {
    @Override
    public boolean validar(AtividadeSelecionada as) {
        int declaradas = as.getHorasDeclaradas();
        int limite = as.getAtividade().getLimiteHoras();
        if (declaradas > limite) {
            as.setHorasValidadas(limite);
            as.setObservacao(
                "Horas declaradas (" + declaradas +
                "h) excedem o limite (" + limite + "h); ajustadas para " + limite + "h."
            );
        }
        return proximo == null ? true : proximo.validar(as);
    }
}