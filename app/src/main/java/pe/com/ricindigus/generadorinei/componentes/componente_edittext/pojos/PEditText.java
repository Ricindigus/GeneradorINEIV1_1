package pe.com.ricindigus.generadorinei.componentes.componente_edittext.pojos;

import android.content.ContentValues;

import pe.com.ricindigus.generadorinei.componentes.componente_edittext.modelo.SQLEditText;

/**
 * Created by dmorales on 13/12/2017.
 */

public class PEditText {
    private String ID;
    private String MODULO;
    private String NUMERO;
    private String PREGUNTA;


    public PEditText() {
        ID = "";
        MODULO = "";
        NUMERO = "";
        PREGUNTA = "";
    }

    public PEditText(String ID, String MODULO, String NUMERO) {
        this();
        this.ID = ID;
        this.MODULO = MODULO;
        this.NUMERO = NUMERO;

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
        ContentValues contentValues = new ContentValues(10);
        contentValues.put(SQLEditText.EDITTEXT_ID,ID);
        contentValues.put(SQLEditText.EDITTEXT_MODULO, MODULO);
        contentValues.put(SQLEditText.EDITTEXT_NUMERO, NUMERO);
        contentValues.put(SQLEditText.EDITTEXT_PREGUNTA, PREGUNTA);
        return contentValues;
    }
}
