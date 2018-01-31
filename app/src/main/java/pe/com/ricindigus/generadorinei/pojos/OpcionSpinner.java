package pe.com.ricindigus.generadorinei.pojos;

import android.content.ContentValues;

import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.SQLConstantesComponente;

/**
 * Created by dmorales on 30/01/2018.
 */

public class OpcionSpinner {
    private String ID;
    private String IDVARIABLE;
    private String NDATO;
    private String DATO;

    public OpcionSpinner() {
        this.ID = "";
        this.IDVARIABLE = "";
        this.NDATO = "";
        this.DATO = "";
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

    public String getNDATO() {
        return NDATO;
    }

    public void setNDATO(String NDATO) {
        this.NDATO = NDATO;
    }

    public String getDATO() {
        return DATO;
    }

    public void setDATO(String DATO) {
        this.DATO = DATO;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantesComponente.OPCION_SPINNER_ID,ID);
        contentValues.put(SQLConstantesComponente.OPCION_SPINNER_IDVARIABLE,IDVARIABLE);
        contentValues.put(SQLConstantesComponente.OPCION_SPINNER_NDATO,NDATO);
        contentValues.put(SQLConstantesComponente.OPCION_SPINNER_DATO,DATO);
        return contentValues;
    }
}
