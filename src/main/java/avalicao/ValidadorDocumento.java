package avaliacao;

import modelo.AtividadeSelecionada;

public class ValidadorDocumento extends Validador {
    @Override
    public boolean validar(AtividadeSelecionada as) {
        
        return proximo == null ? true : proximo.validar(as);
    }
}