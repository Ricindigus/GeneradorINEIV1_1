package pe.com.ricindigus.generadorinei.pojos;

/**
 * Created by user on 9/08/2017.
 */

public class ItemMarco {
    private String id;
    private String ruc;
    private String razonSocial;
    private String tamanio;
    private String resultado;

    public ItemMarco(String id, String ruc, String razonSocial, String tamanio, String resultado) {
        this.id = id;
        this.ruc = ruc;
        this.razonSocial = razonSocial;
        this.tamanio = tamanio;
        this.resultado = resultado;
    }

    public ItemMarco() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
