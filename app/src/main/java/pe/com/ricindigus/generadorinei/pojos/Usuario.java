package pe.com.ricindigus.generadorinei.pojos;

import android.content.ContentValues;

import pe.com.ricindigus.generadorinei.modelo.DataSourceCaptura.SQLConstantes;

/**
 * Created by otin016 on 23/08/2017.
 */

public class Usuario {
    private String USUARIO_ID = "ID";
    private String USUARIO_PASSWORD = "PASSWORD";
    private String USUARIO_PERMISO = "PERMISO";


    public Usuario() {
        this.USUARIO_ID = "";
        this.USUARIO_PASSWORD = "";
        this.USUARIO_PERMISO = "";
    }

    public Usuario(String USUARIO_ID, String USUARIO_PASSWORD, String USUARIO_PERMISO) {
        this.USUARIO_ID = USUARIO_ID;
        this.USUARIO_PASSWORD = USUARIO_PASSWORD;
        this.USUARIO_PERMISO = USUARIO_PERMISO;
    }

    public String getUSUARIO_ID() {
        return USUARIO_ID;
    }

    public void setUSUARIO_ID(String USUARIO_ID) {
        this.USUARIO_ID = USUARIO_ID;
    }

    public String getUSUARIO_PASSWORD() {
        return USUARIO_PASSWORD;
    }

    public void setUSUARIO_PASSWORD(String USUARIO_PASSWORD) {
        this.USUARIO_PASSWORD = USUARIO_PASSWORD;
    }

    public String getUSUARIO_PERMISO() {
        return USUARIO_PERMISO;
    }

    public void setUSUARIO_PERMISO(String USUARIO_PERMISO) {
        this.USUARIO_PERMISO = USUARIO_PERMISO;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues(3);
        contentValues.put(SQLConstantes.USUARIO_ID,USUARIO_ID);
        contentValues.put(SQLConstantes.USUARIO_PASSWORD,USUARIO_PASSWORD);
        contentValues.put(SQLConstantes.USUARIO_PERMISO,USUARIO_PERMISO);
        return contentValues;
    }
}
