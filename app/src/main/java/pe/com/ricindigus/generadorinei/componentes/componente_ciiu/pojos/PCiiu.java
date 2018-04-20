package pe.com.ricindigus.generadorinei.componentes.componente_ciiu.pojos;

import android.content.ContentValues;

import pe.com.ricindigus.generadorinei.componentes.componente_ciiu.modelo.SQLCiiu;

/**
 * Created by dmorales on 19/04/2018.
 */

public class PCiiu {
    private String ID;
    private String MODULO;
    private String NUMERO;
    private String PREGUNTA;

    public PCiiu(String ID, String MODULO, String NUMERO, String PREGUNTA) {
        this.ID = ID;
        this.MODULO = MODULO;
        this.NUMERO = NUMERO;
        this.PREGUNTA = PREGUNTA;
    }

    public PCiiu() {
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
        contentValues.put(SQLCiiu.PCIIU_ID,ID);
        contentValues.put(SQLCiiu.PCIIU_MODULO,MODULO);
        contentValues.put(SQLCiiu.PCIIU_NUMERO,NUMERO);
        contentValues.put(SQLCiiu.PCIIU_PREGUNTA,PREGUNTA);
        return contentValues;
    }
}
