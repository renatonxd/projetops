package avaliacao;

import modelo.AtividadeSelecionada;

public abstract class Validador {
    protected Validador proximo;

    public Validador ligar(Validador proximo) {
        this.proximo = proximo;
        return proximo;
    }

    public abstract boolean validar(AtividadeSelecionada as);
}