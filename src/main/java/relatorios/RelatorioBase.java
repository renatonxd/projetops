package relatorios;

public abstract class RelatorioBase implements RelatorioAtividade {
    protected RelatorioAtividade base;

    public RelatorioBase(RelatorioAtividade base) {
        this.base = base;
    }

    @Override
    public String montar() {
        return base.montar();
    }
}