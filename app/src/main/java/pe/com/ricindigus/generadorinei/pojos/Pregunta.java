package pe.com.ricindigus.generadorinei.pojos;

import android.content.ContentValues;

import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.SQLConstantesComponente;

/**
 * Created by dmorales on 13/12/2017.
 */

public class Pregunta {
    private String ID;
    private String PREGUNTA;
    private String TIPO;

    public Pregunta() {
        ID = "";
        PREGUNTA = "";
        TIPO = "";
    }

    public Pregunta(String ID, String PREGUNTA, String TIPO) {
        this.ID = ID;
        this.PREGUNTA = PREGUNTA;
        this.TIPO = TIPO;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPREGUNTA() {
        return PREGUNTA;
    }

    public void setPREGUNTA(String PREGUNTA) {
        this.PREGUNTA = PREGUNTA;
    }

    public String getTIPO() {
        return TIPO;
    }

    public void setTIPO(String TIPO) {
        this.TIPO = TIPO;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues(3);
        contentValues.put(SQLConstantesComponente.ID_PREGUNTA,ID);
        contentValues.put(SQLConstantesComponente.TEXTO_PREGUNTA,PREGUNTA);
        contentValues.put(SQLConstantesComponente.TIPO_PREGUNTA,TIPO);
        return contentValues;
    }
}
