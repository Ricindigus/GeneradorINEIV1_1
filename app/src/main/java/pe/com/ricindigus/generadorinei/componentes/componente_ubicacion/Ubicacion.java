package pe.com.ricindigus.generadorinei.componentes.componente_ubicacion;

import android.content.ContentValues;

import pe.com.ricindigus.generadorinei.modelo.DataSourceCaptura.SQLConstantes;

/**
 * Created by dmorales on 29/01/2018.
 */

public class Ubicacion {
    private String ID;
    private String VARREG;
    private String VARDEP;
    private String VARPRO;
    private String VARDIS;

    public Ubicacion() {
         ID = "";
         VARREG = "";
         VARDEP = "";
         VARPRO = "";
         VARDIS = "";
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getVARREG() {
        return VARREG;
    }

    public void setVARREG(String VARREG) {
        this.VARREG = VARREG;
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

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLUbicacion.UBICACION_ID,ID);
        contentValues.put(SQLUbicacion.UBICACION_REGION,VARREG);
        contentValues.put(SQLUbicacion.UBICACION_DEPARTAMENTO,VARDEP);
        contentValues.put(SQLUbicacion.UBICACION_PROVINCIA,VARPRO);
        contentValues.put(SQLUbicacion.UBICACION_DISTRITO,VARDIS);
        return contentValues;
    }
}
