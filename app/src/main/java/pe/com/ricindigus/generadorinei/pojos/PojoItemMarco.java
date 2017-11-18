package pe.com.ricindigus.generadorinei.pojos;

/**
 * Created by dmorales on 10/11/2017.
 */

public class PojoItemMarco {
    private String dato1;
    private String dato2;
    private String dato3;
    private String dato4;

    public PojoItemMarco(String dato1, String dato2, String dato3, String dato4) {
        this.dato1 = dato1;
        this.dato2 = dato2;
        this.dato3 = dato3;
        this.dato4 = dato4;
    }

    public String getDato1() {
        return dato1;
    }

    public void setDato1(String dato1) {
        this.dato1 = dato1;
    }

    public String getDato2() {
        return dato2;
    }

    public void setDato2(String dato2) {
        this.dato2 = dato2;
    }

    public String getDato3() {
        return dato3;
    }

    public void setDato3(String dato3) {
        this.dato3 = dato3;
    }

    public String getDato4() {
        return dato4;
    }

    public void setDato4(String dato4) {
        this.dato4 = dato4;
    }
}
