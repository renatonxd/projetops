package acoes;

import modelo.Requerimento;
import notificacao.Observador;
import relatorios.GeradorRelatorio;
import avaliacao.*;

public class AcaoFinalizarRequerimento implements Acao {
    private Requerimento requerimento;

    public AcaoFinalizarRequerimento(Requerimento requerimento) {
        this.requerimento = requerimento;
    }

    @Override
    public void executar() {
        Validador cadeia = new ValidadorLimite();
        cadeia.ligar(new ValidadorDocumento())
               .ligar(new ValidadorPadrao());

        requerimento.getAtividades().forEach(cadeia::validar);
        requerimento.anexar((Observador) new GeradorRelatorio());
        requerimento.notificar();
    }
}