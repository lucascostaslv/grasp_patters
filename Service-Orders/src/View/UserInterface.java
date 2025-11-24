package View;

import Controller.Control;

public class UserInterface {

    private Control control;

    public UserInterface() {
        // Instancia o controller
        this.control = new Control();
    }

    public void iniciar() {
        boolean rodando = true;

        while (rodando) {
            System.out.println("\n=== SISTEMA DE GERENCIAMENTO DE OS ===");
            System.out.println("1. Abrir Nova Ordem de Serviço");
            System.out.println("2. Atribuir Técnico");
            System.out.println("3. Atualizar Status");
            System.out.println("4. Listar Todas as Ordens");
            System.out.println("5. Buscar Ordem por ID");
            System.out.println("6. Listar Ordens por Status");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                // Usa o scanner do control conforme solicitado
                String entrada = control.scan.nextLine();
                int opcao = Integer.parseInt(entrada);

                // Switch "sofisticado" (Java 14+)
                switch (opcao) {
                    case 1 -> control.abrirOrdem();
                    case 2 -> control.atribuirTecnico();
                    case 3 -> control.atualizarStatus();
                    case 4 -> control.listarOrdens();
                    case 5 -> control.buscarOrdem();
                    case 6 -> control.listarOrdensStatus();
                    case 0 -> {
                        System.out.println("Encerrando o sistema...");
                        rodando = false;
                    }
                    default -> System.out.println("Opção inválida! Tente novamente.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Erro: Por favor, digite apenas números válidos.");
            } catch (Exception e) {
                System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
            }
        }
    }
}
