package Controller;

import java.util.Scanner;
import java.util.List;

import Model.CentralServicos;
import Model.OrdemServico;
import Model.Tecnico;

public class Control implements ControllerInteface{

    public final Scanner scan;
    private final CentralServicos central;

    public Control(){
        this.scan = new Scanner(System.in);
        this.central = new CentralServicos();
    }


    public void abrirOrdem(){
        String nome_cliente, telefone, nome_tecnico, especialidade, descricao, status = "ABERTURA";

        System.out.println("Digite o nome do cliente.");
        nome_cliente = scan.nextLine();

        System.out.println("Digite o telefone do cliente.");
        telefone = scan.nextLine();

        System.out.println("Digite o nome do tecnico.");
        nome_tecnico = scan.nextLine();

        System.out.println("Digite a especialidade do tecnico.");
        especialidade = scan.nextLine();

        System.out.println("Adicione uma descricao para a Ordem de Servico");
        descricao = scan.nextLine();

        central.criarOrdemServico(descricao, status, central.registrarCliente(nome_cliente, telefone) , central.registrarTecnico(nome_tecnico, especialidade));
    }

    public void atribuirTecnico(){
        int id_os, id_tecnico;

        System.out.println("Digite o id da Ordem de Serviço");
        id_os = Integer.parseInt(scan.nextLine());

        System.out.println("Digite o id do tecnico");
        id_tecnico = Integer.parseInt(scan.nextLine());

        List<OrdemServico> auxOs = central.getListaOrdens();
        List<Tecnico> auxT = central.getListaTecnicos();
        
        for (OrdemServico os : auxOs) {

            if(os.getId() == id_os){
                for (Tecnico tecnico : auxT) {

                    if(tecnico.getId() == id_tecnico){
                        os.setTecnico(tecnico);

                    } else{
                        System.out.println("Tecnico não encontrado.");
                        return;
                    }
                }
            } else{
                System.out.println("Ordem não encontrada.");
                return;
            }
        }
    }

    public void atualizarStatus(){
        int id_os;
        String status, comentario;

        System.out.println("Digite o id da Ordem de Serviço");
        id_os = Integer.parseInt(scan.nextLine());

        System.out.println("Digite o status da Ordem de Serviço");
        status = scan.nextLine().toUpperCase();

        System.out.println("Digite um comentario para hostorico");
        comentario = scan.nextLine();

        List<OrdemServico> auxOS = central.getListaOrdens();

        for (OrdemServico os : auxOS) {
            if(os.getId() == id_os){
                central.AtualizarStatus(os, status, comentario);  
    
            }else{
                System.out.println("Ordem não encontrada.");
                return;
            }
        }
    }

    public void listarOrdens(){
        List<OrdemServico> lista_os = central.getListaOrdens();

        if (lista_os.isEmpty()) {
            System.out.println("Nenhuma ordem de serviço cadastrada.");
        } else {
            System.out.println("\n--- Lista de Ordens de Serviço ---");
            for (OrdemServico os : lista_os) {
                String nomeTecnico = (os.getTecnico() != null) ? os.getTecnico().getNome() : "N/A";
                System.out.println("ID: " + os.getId() + ", Status: " + os.getStatus() + ", Cliente: " + os.getCliente().getNome() + ", Técnico: " + nomeTecnico);
            }
            System.out.println("------------------------------------\n");
        }
    }

    public void buscarOrdem(){
        int id_os;

        System.out.println("Digite o id da Ordem de Serviço");
        id_os = Integer.parseInt(scan.nextLine());

        OrdemServico os = central.buscarOrdemServico(id_os);

        if (os != null) {
            System.out.println("\n--- Detalhes da Ordem de Serviço ---");
            System.out.println("ID: " + os.getId());
            System.out.println("Cliente: " + os.getCliente().getNome());
            String nomeTecnico = (os.getTecnico() != null) ? os.getTecnico().getNome() : "N/A";
            System.out.println("Técnico: " + nomeTecnico);
            System.out.println("Descrição: " + os.getDescricao());
            System.out.println("Status: " + os.getStatus());
            System.out.println("------------------------------------\n");
        } else {
            System.out.println("Ordem de Serviço não encontrada.");
        }
    }

    public void listarOrdensStatus(){
        System.out.println("Digite o status a ser buscado");
        String status = scan.nextLine().toUpperCase();

        List<OrdemServico> lista_os = central.listarOrdemStatus(status);

        if (lista_os.isEmpty()) {
            System.out.println("Nenhuma ordem de serviço encontrada com o status '" + status + "'.");
        } else {
            System.out.println("\n--- Ordens de Serviço com Status: " + status + " ---");
            for (OrdemServico os : lista_os) {
                String nomeTecnico = (os.getTecnico() != null) ? os.getTecnico().getNome() : "N/A";
                System.out.println("ID: " + os.getId() + ", Cliente: " + os.getCliente().getNome() + ", Técnico: " + nomeTecnico);
            }
            System.out.println("-------------------------------------------\n");
        }
    }
}
