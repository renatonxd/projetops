package acoes;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorAcoes {
    private List<Acao> historico = new ArrayList<>();

    public void executarAcao(Acao acao) {
        acao.executar();
        historico.add(acao);
    }
}