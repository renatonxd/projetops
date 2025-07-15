package relatorios;

import modelo.Requerimento;
import modelo.AtividadeSelecionada;
import notificacao.Observador;

import java.time.LocalDate;
import java.util.List;

public class GeradorRelatorio implements Observador {
    @Override
    public void atualizar(Requerimento req) {
        System.out.println("\n=== PARECER DE VALIDAÇÃO ===");
        System.out.println("Matrícula: " + req.getMatricula());
        System.out.println("Data emissão: " + LocalDate.now());
        List<AtividadeSelecionada> lista = req.getAtividades();
        int totalDec = 0, totalVal = 0, idx = 1;

        for (AtividadeSelecionada as : lista) {
            System.out.println("\nAtividade " + idx++ + ":");
            RelatorioAtividade base = () ->
                "  Descrição:       " + as.getAtividade().getNome() + "\n" +
                "  Horas declaradas: " + as.getHorasDeclaradas() + "h\n" +
                "  Limite Máximo:    " + as.getAtividade().getLimiteHoras() + "h\n" +
                "  Horas validadas:  " + as.getHorasValidadas() + "h\n";

            RelatorioAtividade ajustado = new RelatorioComAjuste(base, as);
            RelatorioAtividade decorado = new RelatorioComObservacao(ajustado, as);

            System.out.print(decorado.montar());
            totalDec += as.getHorasDeclaradas();
            totalVal += as.getHorasValidadas();
        }

        System.out.println("\nResumo geral:");
        System.out.println("  Total horas declaradas: " + totalDec + "h");
        System.out.println("  Total horas validadas:  " + totalVal + "h");
    }
}