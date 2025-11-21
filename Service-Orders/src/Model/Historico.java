package Model;

import java.time.LocalDateTime;
public class Historico {
    private LocalDateTime dataHora;
    private String status;
    private String comentario;

    public Historico(String status, String comentario){
        this.dataHora = LocalDateTime.now();
        this.status = status;
        this.comentario = comentario;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
