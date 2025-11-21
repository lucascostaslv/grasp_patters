package Model;

public class Tecnico extends Pessoa{
    private String especialidade;

    public Tecnico(int id, String nome, String especialidade){
        super(id, nome);
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
