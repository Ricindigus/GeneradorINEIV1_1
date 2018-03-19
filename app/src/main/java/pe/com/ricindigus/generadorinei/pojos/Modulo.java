package pe.com.ricindigus.generadorinei.pojos;

import android.content.ContentValues;
import android.content.Context;

import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.SQLConstantesComponente;

/**
 * Created by dmorales on 20/12/2017.
 */

public class Modulo {
    private String ID;
    private String TITULO;
    private String CABECERA;
    private String NTABLA;


    public Modulo() {
        this.ID = "";
        this.TITULO = "";
        this.CABECERA = "";
        this.NTABLA = "";

    }

    public Modulo(String ID, String TITULO, String CABECERA, String NTABLA) {
        this.ID = ID;
        this.TITULO = TITULO;
        this.CABECERA = CABECERA;
        this.NTABLA = NTABLA;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTITULO() {
        return TITULO;
    }

    public void setTITULO(String TITULO) {
        this.TITULO = TITULO;
    }

    public String getCABECERA() {
        return CABECERA;
    }

    public void setCABECERA(String CABECERA) {
        this.CABECERA = CABECERA;
    }

    public String getNTABLA() {
        return NTABLA;
    }

    public void setNTABLA(String NTABLA) {
        this.NTABLA = NTABLA;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues(2);
        contentValues.put(SQLConstantesComponente.MODULO_ID,ID);
        contentValues.put(SQLConstantesComponente.MODULO_TITULO,TITULO);
        contentValues.put(SQLConstantesComponente.MODULO_CABECERA,CABECERA);
        contentValues.put(SQLConstantesComponente.MODULO_NTABLA,NTABLA);
        return contentValues;
    }
}
