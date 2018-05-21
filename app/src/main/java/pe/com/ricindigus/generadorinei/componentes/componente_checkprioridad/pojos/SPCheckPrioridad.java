package pe.com.ricindigus.generadorinei.componentes.componente_checkprioridad.pojos;

import android.content.ContentValues;

import pe.com.ricindigus.generadorinei.componentes.componente_checkprioridad.modelo.SQLCheckPrioridad;

/**
 * Created by dmorales on 30/04/2018.
 */

public class SPCheckPrioridad {
    private String ID;
    private String ID_PREGUNTA;
    private String SUBPREGUNTA;
    private String VARCK;
    private String VARESP;
    private String VARSP;

    public SPCheckPrioridad() {
    }

    public SPCheckPrioridad(String ID, String ID_PREGUNTA, String SUBPREGUNTA, String VARCK, String VARESP, String VARSP) {
        this.ID = ID;
        this.ID_PREGUNTA = ID_PREGUNTA;
        this.SUBPREGUNTA = SUBPREGUNTA;
        this.VARCK = VARCK;
        this.VARESP = VARESP;
        this.VARSP = VARSP;
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

    public String getVARCK() {
        return VARCK;
    }

    public void setVARCK(String VARCK) {
        this.VARCK = VARCK;
    }

    public String getVARESP() {
        return VARESP;
    }

    public void setVARESP(String VARESP) {
        this.VARESP = VARESP;
    }

    public String getVARSP() {
        return VARSP;
    }

    public void setVARSP(String VARSP) {
        this.VARSP = VARSP;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLCheckPrioridad.SPCHECKPRIORIDAD_ID,ID);
        contentValues.put(SQLCheckPrioridad.SPCHECKPRIORIDAD_ID_PREGUNTA, ID_PREGUNTA);
        contentValues.put(SQLCheckPrioridad.SPCHECKPRIORIDAD_SUBPREGUNTA, SUBPREGUNTA);
        contentValues.put(SQLCheckPrioridad.SPCHECKPRIORIDAD_VARCK, VARCK);
        contentValues.put(SQLCheckPrioridad.SPCHECKPRIORIDAD_VARESP, VARESP);
        contentValues.put(SQLCheckPrioridad.SPCHECKPRIORIDAD_VARSP, VARSP);
        return contentValues;
    }
}
