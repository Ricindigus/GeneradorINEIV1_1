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
    private String VARRESFINAL;
    private String VARRESDIA;
    private String VARRESMES;
    private String VARRESANIO;
    private String VARRESHORA;
    private String VARRESMIN;


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
        this.VARRESFINAL = "";
        this.VARRESDIA = "";
        this.VARRESMES= "";
        this.VARRESMIN = "";
        this.VARRESHORA = "";
        this.VARRESMIN = "";
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

    public String getVARRESFINAL() {
        return VARRESFINAL;
    }

    public void setVARRESFINAL(String VARRESFINAL) {
        this.VARRESFINAL = VARRESFINAL;
    }

    public String getVARRESDIA() {
        return VARRESDIA;
    }

    public void setVARRESDIA(String VARRESDIA) {
        this.VARRESDIA = VARRESDIA;
    }

    public String getVARRESMES() {
        return VARRESMES;
    }

    public void setVARRESMES(String VARRESMES) {
        this.VARRESMES = VARRESMES;
    }

    public String getVARRESANIO() {
        return VARRESANIO;
    }

    public void setVARRESANIO(String VARRESANIO) {
        this.VARRESANIO = VARRESANIO;
    }

    public String getVARRESHORA() {
        return VARRESHORA;
    }

    public void setVARRESHORA(String VARRESHORA) {
        this.VARRESHORA = VARRESHORA;
    }

    public String getVARRESMIN() {
        return VARRESMIN;
    }

    public void setVARRESMIN(String VARRESMIN) {
        this.VARRESMIN = VARRESMIN;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLVisitas.VISITA_ID,ID);
        contentValues.put(SQLVisitas.VISITA_MODULO,MODULO);
        contentValues.put(SQLVisitas.VISITA_NUMERO,NUMERO);
        contentValues.put(SQLVisitas.VISITA_VARNUM,VARNUM);
        contentValues.put(SQLVisitas.VISITA_VARDIA,VARDIA);
        contentValues.put(SQLVisitas.VISITA_VARMES,VARMES);
        contentValues.put(SQLVisitas.VISITA_VARANIO,VARANIO);
        contentValues.put(SQLVisitas.VISITA_VARHORI,VARHORI);
        contentValues.put(SQLVisitas.VISITA_VARMINI,VARMINI);
        contentValues.put(SQLVisitas.VISITA_VARHORF,VARHORF);
        contentValues.put(SQLVisitas.VISITA_VARMINF,VARMINF);
        contentValues.put(SQLVisitas.VISITA_VARRES,VARRES);
        contentValues.put(SQLVisitas.VISITA_VARDIAP,VARDIAP);
        contentValues.put(SQLVisitas.VISITA_VARMESP,VARMESP);
        contentValues.put(SQLVisitas.VISITA_VARANIOP,VARANIOP);
        contentValues.put(SQLVisitas.VISITA_VARHORP,VARHORP);
        contentValues.put(SQLVisitas.VISITA_VARMINP,VARMINP);
        contentValues.put(SQLVisitas.VISITA_VARRESFINAL,VARRESFINAL);
        contentValues.put(SQLVisitas.VISITA_VARRESDIA,VARRESDIA);
        contentValues.put(SQLVisitas.VISITA_VARRESMES,VARRESMES);
        contentValues.put(SQLVisitas.VISITA_VARRESANIO,VARRESANIO);
        contentValues.put(SQLVisitas.VISITA_VARRESHORA,VARRESHORA);
        contentValues.put(SQLVisitas.VISITA_VARRESMIN,VARRESMIN);
        return contentValues;
    }
}
