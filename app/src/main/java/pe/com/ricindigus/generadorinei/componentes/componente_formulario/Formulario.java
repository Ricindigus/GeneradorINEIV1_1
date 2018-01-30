package pe.com.ricindigus.generadorinei.componentes.componente_formulario;

import android.content.ContentValues;

/**
 * Created by dmorales on 30/01/2018.
 */

public class Formulario {
    private String ID;
    private String MODULO;
    private String NUMERO;
    private String PREGUNTA;

    public Formulario() {
        this.ID = "";
        this.MODULO = "";
        this.NUMERO = "";
        this.PREGUNTA = "";
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

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLFormulario.FORMULARIO_ID,ID);
        contentValues.put(SQLFormulario.FORMULARIO_MODULO,MODULO);
        contentValues.put(SQLFormulario.FORMULARIO_NUMERO,NUMERO);
        contentValues.put(SQLFormulario.FORMULARIO_PREGUNTA,PREGUNTA);
        return contentValues;
    }
}
