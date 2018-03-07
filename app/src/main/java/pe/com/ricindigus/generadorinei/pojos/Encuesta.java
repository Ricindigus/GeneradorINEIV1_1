package pe.com.ricindigus.generadorinei.pojos;

import android.content.ContentValues;

import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.SQLConstantesComponente;

/**
 * Created by dmorales on 13/12/2017.
 */

public class Encuesta {
    private String ID;
    private String TITULO;

    public Encuesta() {
        ID = "";
        TITULO = "";
    }

    public Encuesta(String ID, String TITULO) {
        this.ID = ID;
        this.TITULO = TITULO;
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
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantesComponente.ENCUESTA_ID,ID);
        contentValues.put(SQLConstantesComponente.ENCUESTA_TITULO,TITULO);
        return contentValues;
    }
}
