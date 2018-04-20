package pe.com.ricindigus.generadorinei.pojos;

import android.content.ContentValues;

import pe.com.ricindigus.generadorinei.modelo.DataSourceCaptura.SQLConstantes;

/**
 * Created by dmorales on 20/04/2018.
 */

public class CIIU {
    private String ID;
    private String DESCRIPCION;

    public CIIU(String ID, String DESCRIPCION) {
        this.ID = ID;
        this.DESCRIPCION = DESCRIPCION;
    }

    public CIIU() {
        this.ID = "";
        this.DESCRIPCION = "";
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }
    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.CIIU_ID,ID);
        contentValues.put(SQLConstantes.CIIU_DESCRIPCION,DESCRIPCION);
        return contentValues;
    }
}
