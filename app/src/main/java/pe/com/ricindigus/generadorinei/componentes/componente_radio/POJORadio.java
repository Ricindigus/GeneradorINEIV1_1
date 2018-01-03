package pe.com.ricindigus.generadorinei.componentes.componente_radio;

import android.content.ContentValues;


/**
 * Created by dmorales on 21/12/2017.
 */

public class POJORadio {
    private String ID;
    private String MODULO;
    private String NUMERO;
    private String PREGUNTA;


    public POJORadio() {
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
        contentValues.put(SQLRadio.RADIO_ID,ID);
        contentValues.put(SQLRadio.RADIO_MODULO,MODULO);
        contentValues.put(SQLRadio.RADIO_NUMERO,NUMERO);
        contentValues.put(SQLRadio.RADIO_PREGUNTA,PREGUNTA);
        return contentValues;
    }
}
