package notificacao;

import modelo.Requerimento;

public interface Observador {
    void atualizar(Requerimento req);
}