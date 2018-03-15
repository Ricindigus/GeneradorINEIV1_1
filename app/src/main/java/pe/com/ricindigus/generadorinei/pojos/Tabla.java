package pe.com.ricindigus.generadorinei.pojos;

import android.content.ContentValues;

import pe.com.ricindigus.generadorinei.modelo.DataSourceCaptura.SQLConstantes;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.SQLConstantesComponente;
import pe.com.ricindigus.generadorinei.modelo.DataSourceTablasGuardado.SQLConstantesTablas;

/**
 * Created by dmorales on 21/02/2018.
 */

public class Tabla {
    private String ID;
    private String MODULO;
    private String PARTE;
    private String NOMBRE;
    private String TIPO;


    public Tabla(String ID, String MODULO, String PARTE, String NOMBRE, String TIPO) {
        this.ID = ID;
        this.MODULO = MODULO;
        this.PARTE = PARTE;
        this.NOMBRE = NOMBRE;
        this.TIPO = TIPO;
    }

    public Tabla() {
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

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getMODULO() {
        return MODULO;
    }

    public void setMODULO(String MODULO) {
        this.MODULO = MODULO;
    }

    public String getTIPO() {
        return TIPO;
    }

    public void setTIPO(String TIPO) {
        this.TIPO = TIPO;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.TABLA_ID,ID);
        contentValues.put(SQLConstantes.TABLA_MODULO,MODULO);
        contentValues.put(SQLConstantes.TABLA_NOMBRE,NOMBRE);
        contentValues.put(SQLConstantes.TABLA_TIPO,TIPO);
        return contentValues;
    }

}
