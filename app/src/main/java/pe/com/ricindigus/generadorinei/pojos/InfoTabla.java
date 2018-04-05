package pe.com.ricindigus.generadorinei.pojos;

import android.content.ContentValues;

import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.SQLConstantesComponente;

/**
 * Created by dmorales on 21/02/2018.
 */

public class InfoTabla {
    private String ID;
    private String MODULO;
    private String PARTE;
    private String NOMBRE_XML;
    private String TIPO;


    public InfoTabla(String ID, String MODULO, String PARTE, String NOMBRE_XML, String TIPO) {
        this.ID = ID;
        this.MODULO = MODULO;
        this.PARTE = PARTE;
        this.NOMBRE_XML = NOMBRE_XML;
        this.TIPO = TIPO;
    }

    public InfoTabla() {
        this.ID = "";
        this.MODULO = "";
        this.PARTE = "";
        this.NOMBRE_XML = "";
        this.TIPO = "";
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

    public String getPARTE() {
        return PARTE;
    }

    public void setPARTE(String PARTE) {
        this.PARTE = PARTE;
    }

    public String getNOMBRE_XML() {
        return NOMBRE_XML;
    }

    public void setNOMBRE_XML(String NOMBRE_XML) {
        this.NOMBRE_XML = NOMBRE_XML;
    }

    public String getTIPO() {
        return TIPO;
    }

    public void setTIPO(String TIPO) {
        this.TIPO = TIPO;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantesComponente.INFOTABLAS_ID,ID);
        contentValues.put(SQLConstantesComponente.INFOTABLAS_MODULO,MODULO);
        contentValues.put(SQLConstantesComponente.INFOTABLAS_NOMBRE_XML, NOMBRE_XML);
        contentValues.put(SQLConstantesComponente.INFOTABLAS_TIPO,TIPO);
        contentValues.put(SQLConstantesComponente.INFOTABLAS_PARTE,PARTE);
        return contentValues;
    }

}
