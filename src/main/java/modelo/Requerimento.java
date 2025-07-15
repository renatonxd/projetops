package modelo;

import notificacao.Observador;
import notificacao.Publicador;
import java.util.ArrayList;
import java.util.List;

public class Requerimento implements Publicador {
    private String matricula;
    private List<AtividadeSelecionada> atividades = new ArrayList<>();
    private List<Observador> observadores = new ArrayList<>();

    public Requerimento(String matricula) {
        this.matricula = matricula;
    }

    public void adicionarAtividade(AtividadeSelecionada as) {
        atividades.add(as);
    }

    public List<AtividadeSelecionada> getAtividades() {
        return atividades;
    }

    public String getMatricula() {
        return matricula;
    }

    @Override
    public void anexar(Observador o) {
        observadores.add(o);
    }

    @Override
    public void notificar() {
        observadores.forEach(o -> o.atualizar(this));
    }
}