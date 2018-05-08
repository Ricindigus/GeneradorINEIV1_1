package pe.com.ricindigus.generadorinei.componentes.componente_checkeditsuma.pojos;

import android.content.ContentValues;

import pe.com.ricindigus.generadorinei.componentes.componente_checkeditsuma.modelo.SQLCheckEditSuma;
import pe.com.ricindigus.generadorinei.componentes.componente_editsuma.modelo.SQLEditSuma;

/**
 * Created by dmorales on 30/04/2018.
 */

public class SPCheckEditSuma {
    private String ID;
    private String ID_PREGUNTA;
    private String SUBPREGUNTA;
    private String VARIABLE;
    private String VARESP;
    private String LONGITUD;

    public SPCheckEditSuma() {
    }

    public SPCheckEditSuma(String ID, String ID_PREGUNTA, String SUBPREGUNTA, String VARIABLE, String VARESP, String LONGITUD) {
        this.ID = ID;
        this.ID_PREGUNTA = ID_PREGUNTA;
        this.SUBPREGUNTA = SUBPREGUNTA;
        this.VARIABLE = VARIABLE;
        this.VARESP = VARESP;
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

    public String getVARESP() {
        return VARESP;
    }

    public void setVARESP(String VARESP) {
        this.VARESP = VARESP;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLCheckEditSuma.SPCHECKEDITSUMA_ID,ID);
        contentValues.put(SQLCheckEditSuma.SPCHECKEDITSUMA_ID_PREGUNTA, ID_PREGUNTA);
        contentValues.put(SQLCheckEditSuma.SPCHECKEDITSUMA_SUBPREGUNTA, SUBPREGUNTA);
        contentValues.put(SQLCheckEditSuma.SPCHECKEDITSUMA_VARIABLE, VARIABLE);
        contentValues.put(SQLCheckEditSuma.SPCHECKEDITSUMA_VARESP, VARESP);
        contentValues.put(SQLCheckEditSuma.SPCHECKEDITSUMA_LONGITUD, LONGITUD);
        return contentValues;
    }
}
