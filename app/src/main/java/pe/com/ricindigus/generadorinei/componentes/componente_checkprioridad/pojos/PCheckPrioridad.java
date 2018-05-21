package pe.com.ricindigus.generadorinei.componentes.componente_checkprioridad.pojos;

import android.content.ContentValues;

import pe.com.ricindigus.generadorinei.componentes.componente_checkprioridad.modelo.SQLCheckPrioridad;

/**
 * Created by dmorales on 30/04/2018.
 */

public class PCheckPrioridad {
    private String ID;
    private String MODULO;
    private String NUMERO;
    private String PREGUNTA;
    private String CAB1;
    private String CAB2;
    private String PRIORIDAD;

    public PCheckPrioridad() {
    }

    public PCheckPrioridad(String ID, String MODULO, String NUMERO, String PREGUNTA, String CAB1, String CAB2, String PRIORIDAD) {
        this.ID = ID;
        this.MODULO = MODULO;
        this.NUMERO = NUMERO;
        this.PREGUNTA = PREGUNTA;
        this.CAB1 = CAB1;
        this.CAB2 = CAB2;
        this.PRIORIDAD = PRIORIDAD;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMODULO() {
        return MODULO;
    }

    public void setMODULO(String MODULO) {
        this.MODULO = MODULO;
    }

    public String getNUMERO() {
        return NUMERO;
    }

    public void setNUMERO(String NUMERO) {
        this.NUMERO = NUMERO;
    }

    public String getPREGUNTA() {
        return PREGUNTA;
    }

    public void setPREGUNTA(String PREGUNTA) {
        this.PREGUNTA = PREGUNTA;
    }

    public String getCAB1() {
        return CAB1;
    }

    public void setCAB1(String CAB1) {
        this.CAB1 = CAB1;
    }

    public String getCAB2() {
        return CAB2;
    }

    public void setCAB2(String CAB2) {
        this.CAB2 = CAB2;
    }

    public String getPRIORIDAD() {
        return PRIORIDAD;
    }

    public void setPRIORIDAD(String PRIORIDAD) {
        this.PRIORIDAD = PRIORIDAD;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLCheckPrioridad.CHECKPRIORIDAD_ID,ID);
        contentValues.put(SQLCheckPrioridad.CHECKPRIORIDAD_MODULO, MODULO);
        contentValues.put(SQLCheckPrioridad.CHECKPRIORIDAD_NUMERO, NUMERO);
        contentValues.put(SQLCheckPrioridad.CHECKPRIORIDAD_PREGUNTA, PREGUNTA);
        contentValues.put(SQLCheckPrioridad.CHECKPRIORIDAD_CAB1, CAB1);
        contentValues.put(SQLCheckPrioridad.CHECKPRIORIDAD_CAB2, CAB2);
        contentValues.put(SQLCheckPrioridad.CHECKPRIORIDAD_PRIORIDAD, PRIORIDAD);
        return contentValues;
    }
}
