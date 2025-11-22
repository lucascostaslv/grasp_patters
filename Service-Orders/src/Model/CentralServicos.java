package Model;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
public class CentralServicos {
    private List<OrdemServico> listaOrdens;
    private List<Tecnico> listaTecnicos;
    private List<Cliente> listaClientes;

    public CentralServicos(){
        this.listaClientes = new ArrayList<>();
        this.listaTecnicos = new ArrayList<>();
        this.listaOrdens = new ArrayList<>();
    }

    public Cliente registrarCliente(String nome, String telefone){
        Random rand = new Random();

        Cliente cliente = new Cliente(rand.nextInt(8999) + 1000 ,nome, telefone);
        listaClientes.add(cliente);

        return cliente;
    }

    public final Tecnico registrarTecnico(String nome, String especialidade){
        Random rand = new Random();

        Tecnico tecnico = new Tecnico(rand.nextInt(899) + 100 ,nome, especialidade);
        listaTecnicos.add(tecnico);

        return tecnico;
    }

    public void criarOrdemServico(String descricao, String status, Cliente cliente, Tecnico tecnico){
        Random rand = new Random();

        OrdemServico os = new OrdemServico(rand.nextInt(89999) + 10000, cliente, tecnico, descricao, status);
        listaOrdens.add(os);
    }

    public OrdemServico buscarOrdemServico(int id){
        for (OrdemServico os : listaOrdens) {
            if(os.getId() == id){
                return os;
            }
        }

        return null;
    }

    public List<OrdemServico> listarOrdemStatus(String status){
        List<OrdemServico> aux = new ArrayList<>();

        for (OrdemServico os : listaOrdens){
            if(os.getStatus().equals(status)){
                aux.add(os);
            }
        }

        return aux;
    }

    public void AtualizarStatus(OrdemServico os, String status, String comentario){
        os.registrarHistorico(status, comentario);
    }

    public List<OrdemServico> getListaOrdens() {
        return listaOrdens;
    }

    public void setListaOrdens(List<OrdemServico> listaOrdens) {
        this.listaOrdens = listaOrdens;
    }

    public List<Tecnico> getListaTecnicos() {
        return listaTecnicos;
    }

    public void setListaTecnicos(List<Tecnico> listaTecnicos) {
        this.listaTecnicos = listaTecnicos;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
}
