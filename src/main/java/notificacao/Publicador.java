package notificacao;

public interface Publicador {
    void anexar(Observador o);
    void notificar();
}