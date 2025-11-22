package Model;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
public class CentralServicos {
    private List<OrdemServico> listaOrdens = new ArrayList<>();
    private List<Tecnico> listaTecnicos = new ArrayList<>();
    private List<Cliente> listaClientes = new ArrayList<>();

    public Cliente registrarCliente(String nome, String telefone){
        Random rand = new Random();

        Cliente cliente = new Cliente(rand.nextInt(8999) + 1000 ,nome, telefone);
        listaClientes.add(cliente);

        return cliente;
    }

    public Tecnico registrarTecnico(String nome, String especialidade){
        Random rand = new Random();

        Tecnico tecnico = new Tecnico(rand.nextInt(899) + 100 ,nome, especialidade);
        listaTecnicos.add(tecnico);

        return tecnico;
    }

    public void criarOrdemServico(String nome_cliente, String telefone, String nome_tecnico, String especialidade, String descricao, String status){
        Random rand = new Random();

        listaOrdens.add(new OrdemServico(rand.nextInt(89999) + 10000,registrarCliente(nome_cliente, telefone), registrarTecnico(nome_tecnico, especialidade), descricao, status));
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
