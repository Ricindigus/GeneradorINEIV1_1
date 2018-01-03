package pe.com.ricindigus.generadorinei.componentes.componente_edittext;

import android.content.ContentValues;

/**
 * Created by RICARDO on 1/01/2018.
 */

public class SPEditText {
    private String ID;
    private String ID_PREGUNTA;
    private String SUBPREGUNTA;
    private String VARIABLE;
    private String TIPO;
    private String LONGITUD;

    public SPEditText() {
        this.ID = "";
        this.ID_PREGUNTA = "";
        this.SUBPREGUNTA = "";
        this.VARIABLE = "";
        this.TIPO = "";
        this.LONGITUD = "";
    }

    public SPEditText(String ID, String ID_PREGUNTA, String SUBPREGUNTA, String VARIABLE, String TIPO, String LONGITUD) {
        this.ID = ID;
        this.ID_PREGUNTA = ID_PREGUNTA;
        this.SUBPREGUNTA = SUBPREGUNTA;
        this.VARIABLE = VARIABLE;
        this.TIPO = TIPO;
        this.LONGITUD = LONGITUD;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID_PREGUNTA() {
        return ID_PREGUNTA;
    }

    public void setID_PREGUNTA(String ID_PREGUNTA) {
        this.ID_PREGUNTA = ID_PREGUNTA;
    }

    public String getSUBPREGUNTA() {
        return SUBPREGUNTA;
    }

    public void setSUBPREGUNTA(String SUBPREGUNTA) {
        this.SUBPREGUNTA = SUBPREGUNTA;
    }

    public String getVARIABLE() {
        return VARIABLE;
    }

    public void setVARIABLE(String VARIABLE) {
        this.VARIABLE = VARIABLE;
    }

    public String getTIPO() {
        return TIPO;
    }

    public void setTIPO(String TIPO) {
        this.TIPO = TIPO;
    }

    public String getLONGITUD() {
        return LONGITUD;
    }

    public void setLONGITUD(String LONGITUD) {
        this.LONGITUD = LONGITUD;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues(6);
        contentValues.put(SQLEditText.SPEDITTEXT_ID,ID);
        contentValues.put(SQLEditText.SPEDITTEXT_ID_PREGUNTA,ID_PREGUNTA);
        contentValues.put(SQLEditText.SPEDITTEXT_SUBPREGUNTA,SUBPREGUNTA);
        contentValues.put(SQLEditText.SPEDITTEXT_VARIABLE,VARIABLE);
        contentValues.put(SQLEditText.SPEDITTEXT_TIPO,TIPO);
        contentValues.put(SQLEditText.SPEDITTEXT_LONGITUD,LONGITUD);
        return contentValues;
    }
}
