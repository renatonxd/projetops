package apresentacao;

import modelo.*;
import acoes.*;
import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Informe matrícula do aluno: ");
        String matricula = sc.nextLine().trim();

        Requerimento req = new Requerimento(matricula);
        GerenciadorAcoes ger = new GerenciadorAcoes();

        while (true) {
            System.out.println("\n== Menu de Modalidades ==");
            for (Modalidade m : Modalidade.values()) {
                System.out.printf("%d) %s%n", m.getId(), m.getDescricao());
            }
            System.out.println("0) Finalizar e emitir parecer");
            System.out.print("Escolha a modalidade (0-finalizar): ");
            int opc = sc.nextInt();
            if (opc == 0) break;

            Modalidade mod = Modalidade.fromId(opc);
            if (mod == null) {
                System.out.println("Opção inválida.");
                continue;
            }

            List<Atividade> lista = mod.getAtividades();
            while (true) {
                System.out.println("\n-- Atividades em " + mod.getDescricao() + " --");
                lista.forEach(a -> System.out.println(a));
                System.out.println("0) Voltar");
                System.out.print("Escolha a atividade (0-voltar): ");
                int aid = sc.nextInt();
                if (aid == 0) break;

                Atividade at = lista.stream()
                                    .filter(a -> a.getId() == aid)
                                    .findFirst()
                                    .orElse(null);
                if (at == null) {
                    System.out.println("Atividade inválida.");
                    continue;
                }

                System.out.print("Horas declaradas para '" + at.getNome() + "': ");
                int hrs = sc.nextInt();
                AtividadeSelecionada as = new AtividadeSelecionada(at, hrs);
                ger.executarAcao(new AcaoAdicionarAtividade(req, as));
            }
        }

        ger.executarAcao(new AcaoFinalizarRequerimento(req));
        sc.close();
    }
}