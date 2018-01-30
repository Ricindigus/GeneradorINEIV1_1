package pe.com.ricindigus.generadorinei.pojos;

import android.content.ContentValues;

import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.SQLConstantesComponente;

/**
 * Created by dmorales on 30/01/2018.
 */

public class OpcionSpinner {
    private String ID;
    private String IDVARIABLE;
    private String NOPCION;
    private String OPCION;

    public OpcionSpinner() {
        this.ID = "";
        this.IDVARIABLE = "";
        this.NOPCION = "";
        this.OPCION = "";
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getIDVARIABLE() {
        return IDVARIABLE;
    }

    public void setIDVARIABLE(String IDVARIABLE) {
        this.IDVARIABLE = IDVARIABLE;
    }

    public String getNOPCION() {
        return NOPCION;
    }

    public void setNOPCION(String NOPCION) {
        this.NOPCION = NOPCION;
    }

    public String getOPCION() {
        return OPCION;
    }

    public void setOPCION(String OPCION) {
        this.OPCION = OPCION;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantesComponente.OPCION_SPINNER_ID,ID);
        contentValues.put(SQLConstantesComponente.OPCION_SPINNER_IDVARIABLE,IDVARIABLE);
        contentValues.put(SQLConstantesComponente.OPCION_SPINNER_NOPCION,NOPCION);
        contentValues.put(SQLConstantesComponente.OPCION_SPINNER_OPCION,OPCION);
        return contentValues;
    }
}
