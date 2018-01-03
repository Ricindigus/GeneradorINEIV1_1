package pe.com.ricindigus.generadorinei.componentes.componente_checkbox;

import android.content.ContentValues;

/**
 * Created by dmorales on 20/12/2017.
 */

public class POJOCheckBox {
    private String ID;
    private String MODULO;
    private String NUMERO;
    private String PREGUNTA;


    public POJOCheckBox() {
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
        ContentValues contentValues = new ContentValues(5);
        contentValues.put(SQLCheckBox.CHECKBOX_ID,ID);
        contentValues.put(SQLCheckBox.CHECKBOX_MODULO,MODULO);
        contentValues.put(SQLCheckBox.CHECKBOX_NUMERO,NUMERO);
        contentValues.put(SQLCheckBox.CHECKBOX_PREGUNTA,PREGUNTA);
        return contentValues;
    }
}
