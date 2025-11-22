package Model;

import java.util.List;
import java.util.ArrayList;

public class OrdemServico {
    private int id;
    private Cliente cliente;
    private Tecnico tecnico;
    private String descricao;
    private String status;
    private List<Historico> historicos = new ArrayList<>();

    public OrdemServico(int id, Cliente cliente, Tecnico tecnico, String descricao, String status){
        this.id = id;
        this.cliente = cliente;
        this.tecnico = tecnico;
        this.descricao = descricao;
        this.status = status;
    }

    protected void registrarHistorico(String status, String comentario){
        this.historicos.add(new Historico(status, comentario));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Historico> getHistoricos() {
        return historicos;
    }

    public void setHistoricos(List<Historico> historicos) {
        this.historicos = historicos;
    }
}
