package pe.com.ricindigus.generadorinei.pojos;

/**
 * Created by RICARDO on 7/09/2017.
 */

public class ExportarItem {
    private int seleccionado;
    private String idEmpresa;
    private String ruc;
    private String razonSocial;

    public ExportarItem(int seleccionado, String idEmpresa, String ruc, String razonSocial) {
        this.seleccionado = seleccionado;
        this.idEmpresa = idEmpresa;
        this.ruc = ruc;
        this.razonSocial = razonSocial;
    }

    public int getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(int seleccionado) {
        this.seleccionado = seleccionado;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
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
}
