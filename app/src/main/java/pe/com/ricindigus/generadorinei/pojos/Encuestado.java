package pe.com.ricindigus.generadorinei.pojos;

/**
 * Created by otin016 on 27/06/2017.
 */

public class Encuestado {
    private int numero;
    private String campo1;
    private String campo2;
    private String campo3;

    public Encuestado(int numero, String campo1, String campo2, String campo3) {
        this.numero = numero;
        this.campo1 = campo1;
        this.campo2 = campo2;
        this.campo3 = campo3;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCampo1() {
        return campo1;
    }

    public void setCampo1(String campo1) {
        this.campo1 = campo1;
    }

    public String getCampo2() {
        return campo2;
    }

    public void setCampo2(String campo2) {
        this.campo2 = campo2;
    }

    public String getCampo3() {
        return campo3;
    }

    public void setCampo3(String campo3) {
        this.campo3 = campo3;
    }
}
