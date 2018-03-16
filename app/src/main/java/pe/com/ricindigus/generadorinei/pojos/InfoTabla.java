package pe.com.ricindigus.generadorinei.pojos;

import android.content.ContentValues;

import pe.com.ricindigus.generadorinei.modelo.DataSourceCaptura.SQLConstantes;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.SQLConstantesComponente;
import pe.com.ricindigus.generadorinei.modelo.DataSourceTablasGuardado.SQLConstantesTablas;

/**
 * Created by dmorales on 21/02/2018.
 */

public class InfoTabla {
    private String ID;
    private String MODULO;
    private String PARTE;
    private String NOMBRE;
    private String TIPO;


    public InfoTabla(String ID, String MODULO, String PARTE, String NOMBRE, String TIPO) {
        this.ID = ID;
        this.MODULO = MODULO;
        this.PARTE = PARTE;
        this.NOMBRE = NOMBRE;
        this.TIPO = TIPO;
    }

    public InfoTabla() {
        this.ID = "";
        this.MODULO = "";
        this.PARTE = "";
        this.NOMBRE = "";
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

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
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
        contentValues.put(SQLConstantesComponente.INFOTABLAS_NOMBRE,NOMBRE);
        contentValues.put(SQLConstantesComponente.INFOTABLAS_TIPO,TIPO);
        contentValues.put(SQLConstantesComponente.INFOTABLAS_PARTE,PARTE);
        return contentValues;
    }

}
