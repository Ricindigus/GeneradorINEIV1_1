package pe.com.ricindigus.generadorinei.componentes.componente_ubicacion;

import android.content.ContentValues;

import pe.com.ricindigus.generadorinei.modelo.DataSourceCaptura.SQLConstantes;

/**
 * Created by dmorales on 29/01/2018.
 */

public class Ubicacion {
    private String ID;
    private String NUMERO;
    private String MODULO;
    private String VARDEP;
    private String VARPRO;
    private String VARDIS;

    public Ubicacion() {
         ID = "";
         VARDEP = "";
         VARPRO = "";
         VARDIS = "";
         NUMERO = "";
         MODULO = "";
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }


    public String getVARDEP() {
        return VARDEP;
    }

    public void setVARDEP(String VARDEP) {
        this.VARDEP = VARDEP;
    }

    public String getVARPRO() {
        return VARPRO;
    }

    public void setVARPRO(String VARPRO) {
        this.VARPRO = VARPRO;
    }

    public String getVARDIS() {
        return VARDIS;
    }

    public void setVARDIS(String VARDIS) {
        this.VARDIS = VARDIS;
    }

    public String getNUMERO() {
        return NUMERO;
    }

    public void setNUMERO(String NUMERO) {
        this.NUMERO = NUMERO;
    }

    public String getMODULO() {
        return MODULO;
    }

    public void setMODULO(String MODULO) {
        this.MODULO = MODULO;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLUbicacion.UBICACION_ID,ID);
        contentValues.put(SQLUbicacion.UBICACION_DEPARTAMENTO,VARDEP);
        contentValues.put(SQLUbicacion.UBICACION_PROVINCIA,VARPRO);
        contentValues.put(SQLUbicacion.UBICACION_DISTRITO,VARDIS);
        contentValues.put(SQLUbicacion.UBICACION_NUM,NUMERO);
        contentValues.put(SQLUbicacion.UBICACION_MODULO,MODULO);
        return contentValues;
    }
}
