package pe.com.ricindigus.generadorinei.pojos;

import android.content.ContentValues;

import pe.com.ricindigus.generadorinei.modelo.DataSourceCaptura.SQLConstantes;

/**
 * Created by dmorales on 02/02/2018.
 */

public class Distrito {
    private String ID;
    private String CCPP;
    private String NOMBRE;

    public Distrito() {
        this.ID = "";
        this.CCPP = "";
        this.NOMBRE = "";
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getCCPP() {
        return CCPP;
    }

    public void setCCPP(String CCPP) {
        this.CCPP = CCPP;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.DISTRITO_ID,ID);
        contentValues.put(SQLConstantes.DISTRITO_CCPP,CCPP);
        contentValues.put(SQLConstantes.DISTRITO_NOMBRE,NOMBRE);
        return contentValues;
    }
}
