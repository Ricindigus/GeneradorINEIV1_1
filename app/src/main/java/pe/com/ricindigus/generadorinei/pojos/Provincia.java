package pe.com.ricindigus.generadorinei.pojos;

import android.content.ContentValues;

import pe.com.ricindigus.generadorinei.modelo.DataSourceCaptura.SQLConstantes;

/**
 * Created by dmorales on 02/02/2018.
 */

public class Provincia {
    private String ID;
    private String CCDD;
    private String NOMBRE;

    public Provincia() {
        this.ID = "";
        this.CCDD = "";
        this.NOMBRE = "";
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getCCDD() {
        return CCDD;
    }

    public void setCCDD(String CCDD) {
        this.CCDD = CCDD;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.PROVINCIA_ID,ID);
        contentValues.put(SQLConstantes.PROVINCIA_CCDD,CCDD);
        contentValues.put(SQLConstantes.PROVINCIA_NOMBRE,NOMBRE);
        return contentValues;
    }
}
