package pe.com.ricindigus.generadorinei.componentes.componente_visitas;

import android.content.ContentValues;

/**
 * Created by dmorales on 28/12/2017.
 */

public class Visita {
    private String ID;
    private String MODULO;
    private String NUMERO;
    private String VARNUM;
    private String VARDIA;
    private String VARMES;
    private String VARANIO;
    private String VARHORI;
    private String VARMINI;
    private String VARHORF;
    private String VARMINF;
    private String VARRES;
    private String VARDIAP;
    private String VARMESP;
    private String VARANIOP;
    private String VARHORP;
    private String VARMINP;

    public Visita() {
        this.ID = "";
        this.MODULO = "";
        this.NUMERO = "";
        this.VARNUM = "";
        this.VARDIA = "";
        this.VARMES = "";
        this.VARANIO = "";
        this.VARHORI = "";
        this.VARMINI = "";
        this.VARHORF = "";
        this.VARMINF = "";
        this.VARRES = "";
        this.VARDIAP = "";
        this.VARMESP = "";
        this.VARANIOP = "";
        this.VARHORP = "";
        this.VARMINP = "";
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMODULO() {
        return MODULO;
    }

    public void setMODULO(String MODULO) {
        this.MODULO = MODULO;
    }

    public String getNUMERO() {
        return NUMERO;
    }

    public void setNUMERO(String NUMERO) {
        this.NUMERO = NUMERO;
    }

    public String getVARNUM() {
        return VARNUM;
    }

    public void setVARNUM(String VARNUM) {
        this.VARNUM = VARNUM;
    }

    public String getVARDIA() {
        return VARDIA;
    }

    public void setVARDIA(String VARDIA) {
        this.VARDIA = VARDIA;
    }

    public String getVARMES() {
        return VARMES;
    }

    public void setVARMES(String VARMES) {
        this.VARMES = VARMES;
    }

    public String getVARANIO() {
        return VARANIO;
    }

    public void setVARANIO(String VARANIO) {
        this.VARANIO = VARANIO;
    }

    public String getVARHORI() {
        return VARHORI;
    }

    public void setVARHORI(String VARHORI) {
        this.VARHORI = VARHORI;
    }

    public String getVARMINI() {
        return VARMINI;
    }

    public void setVARMINI(String VARMINI) {
        this.VARMINI = VARMINI;
    }

    public String getVARHORF() {
        return VARHORF;
    }

    public void setVARHORF(String VARHORF) {
        this.VARHORF = VARHORF;
    }

    public String getVARMINF() {
        return VARMINF;
    }

    public void setVARMINF(String VARMINF) {
        this.VARMINF = VARMINF;
    }

    public String getVARRES() {
        return VARRES;
    }

    public void setVARRES(String VARRES) {
        this.VARRES = VARRES;
    }

    public String getVARDIAP() {
        return VARDIAP;
    }

    public void setVARDIAP(String VARDIAP) {
        this.VARDIAP = VARDIAP;
    }

    public String getVARMESP() {
        return VARMESP;
    }

    public void setVARMESP(String VARMESP) {
        this.VARMESP = VARMESP;
    }

    public String getVARANIOP() {
        return VARANIOP;
    }

    public void setVARANIOP(String VARANIOP) {
        this.VARANIOP = VARANIOP;
    }

    public String getVARHORP() {
        return VARHORP;
    }

    public void setVARHORP(String VARHORP) {
        this.VARHORP = VARHORP;
    }

    public String getVARMINP() {
        return VARMINP;
    }

    public void setVARMINP(String VARMINP) {
        this.VARMINP = VARMINP;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLVisitas.VISITA_ID,ID);
        contentValues.put(SQLVisitas.VISITA_MODULO,MODULO);
        contentValues.put(SQLVisitas.VISITA_NUMERO,NUMERO);
        contentValues.put(SQLVisitas.VISITA_VARDIA,VARNUM);
        contentValues.put(SQLVisitas.VISITA_VARMES,VARDIA);
        contentValues.put(SQLVisitas.VISITA_VARANIO,VARMES);
        contentValues.put(SQLVisitas.VISITA_VARHORI,VARANIO);
        contentValues.put(SQLVisitas.VISITA_VARMINI,VARHORI);
        contentValues.put(SQLVisitas.VISITA_VARHORF,VARMINI);
        contentValues.put(SQLVisitas.VISITA_VARMINF,VARHORF);
        contentValues.put(SQLVisitas.VISITA_VARRES,VARMINF);
        contentValues.put(SQLVisitas.VISITA_VARDIAP,VARRES);
        contentValues.put(SQLVisitas.VISITA_VARMESP,VARDIAP);
        contentValues.put(SQLVisitas.VISITA_VARANIOP,VARMESP);
        contentValues.put(SQLVisitas.VISITA_VARHORP,VARANIOP);
        contentValues.put(SQLVisitas.VISITA_VARMINP,VARHORP);
        contentValues.put(SQLVisitas.VISITA_VARMINP,VARMINP);
        return contentValues;
    }
}
