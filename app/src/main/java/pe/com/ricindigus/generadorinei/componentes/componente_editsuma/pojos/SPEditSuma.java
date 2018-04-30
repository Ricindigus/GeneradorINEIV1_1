package pe.com.ricindigus.generadorinei.componentes.componente_editsuma.pojos;

import android.content.ContentValues;

import pe.com.ricindigus.generadorinei.componentes.componente_editsuma.modelo.SQLEditSuma;

/**
 * Created by dmorales on 30/04/2018.
 */

public class SPEditSuma {
    private String ID;
    private String ID_PREGUNTA;
    private String SUBPREGUNTA;
    private String VARIABLE;
    private String LONGITUD;

    public SPEditSuma() {
    }

    public SPEditSuma(String ID, String ID_PREGUNTA, String SUBPREGUNTA, String VARIABLE, String LONGITUD) {
        this.ID = ID;
        this.ID_PREGUNTA = ID_PREGUNTA;
        this.SUBPREGUNTA = SUBPREGUNTA;
        this.VARIABLE = VARIABLE;
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

    public String getLONGITUD() {
        return LONGITUD;
    }

    public void setLONGITUD(String LONGITUD) {
        this.LONGITUD = LONGITUD;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLEditSuma.SPEDITSUMA_ID,ID);
        contentValues.put(SQLEditSuma.SPEDITSUMA_ID_PREGUNTA, ID_PREGUNTA);
        contentValues.put(SQLEditSuma.SPEDITSUMA_SUBPREGUNTA, SUBPREGUNTA);
        contentValues.put(SQLEditSuma.SPEDITSUMA_VARIABLE, VARIABLE);
        contentValues.put(SQLEditSuma.SPEDITSUMA_LONGITUD, LONGITUD);
        return contentValues;
    }
}
