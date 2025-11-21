package Model;

public class Cliente extends Pessoa{
    private String telefone;

    public Cliente(int id, String nome, String telefone){
        super(id, nome);
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
