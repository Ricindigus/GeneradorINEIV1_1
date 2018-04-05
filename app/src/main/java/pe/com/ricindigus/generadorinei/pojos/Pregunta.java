package pe.com.ricindigus.generadorinei.pojos;

/**
 * Created by RICARDO on 3/04/2018.
 */

public class Pregunta {
    private String numero;
    private String modulo;
    private String idPregunta;
    private String tipoComponente;
    private String descripcion;

    public Pregunta(String numero, String modulo, String idPregunta, String tipoComponente, String descripcion) {
        this.numero = numero;
        this.modulo = modulo;
        this.idPregunta = idPregunta;
        this.tipoComponente = tipoComponente;
        this.descripcion = descripcion;
    }

    public Pregunta() {
        this.idPregunta = "";
        this.numero = "";
        this.modulo = "";
        this.tipoComponente = "";
        this.descripcion = "";
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public String getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(String idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getTipoComponente() {
        return tipoComponente;
    }

    public void setTipoComponente(String tipoComponente) {
        this.tipoComponente = tipoComponente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
