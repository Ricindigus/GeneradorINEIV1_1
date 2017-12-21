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

    public Modulo(String ID, String TITULO) {
        this.ID = ID;
        this.TITULO = TITULO;
    }

    public Modulo() {
        this.ID = "";
        this.TITULO = "";
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

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues(2);
        contentValues.put(SQLConstantesComponente.MODULO_ID,ID);
        contentValues.put(SQLConstantesComponente.MODULO_TITULO,TITULO);
        return contentValues;
    }
}
