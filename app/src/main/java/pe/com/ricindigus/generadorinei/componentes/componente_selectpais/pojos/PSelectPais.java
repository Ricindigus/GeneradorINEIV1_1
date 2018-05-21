package pe.com.ricindigus.generadorinei.componentes.componente_selectpais.pojos;

import android.content.ContentValues;

import pe.com.ricindigus.generadorinei.componentes.componente_edittext.modelo.SQLEditText;
import pe.com.ricindigus.generadorinei.componentes.componente_selectpais.modelo.SQLSelectPais;

public class PSelectPais {
    private String ID;
    private String MODULO;
    private String NUMERO;
    private String PREGUNTA;
    private String VARPAIS;

    public PSelectPais(String ID, String MODULO, String NUMERO, String PREGUNTA, String VARPAIS) {
        this.ID = ID;
        this.MODULO = MODULO;
        this.NUMERO = NUMERO;
        this.PREGUNTA = PREGUNTA;
        this.VARPAIS = VARPAIS;
    }

    public PSelectPais() {
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

    public String getVARPAIS() {
        return VARPAIS;
    }

    public void setVARPAIS(String VARPAIS) {
        this.VARPAIS = VARPAIS;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLSelectPais.SELECTPAIS_ID,ID);
        contentValues.put(SQLSelectPais.SELECTPAIS_MODULO,MODULO);
        contentValues.put(SQLSelectPais.SELECTPAIS_NUMERO,NUMERO);
        contentValues.put(SQLSelectPais.SELECTPAIS_PREGUNTA,PREGUNTA);
        contentValues.put(SQLSelectPais.SELECTPAIS_VARPAIS,VARPAIS);
        return contentValues;
    }
}
