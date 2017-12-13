package pe.com.ricindigus.generadorinei.pojos;

import android.content.ContentValues;

import pe.com.ricindigus.generadorinei.modelo.DataSourceCaptura.SQLConstantes;

/**
 * Created by otin016 on 28/08/2017.
 */

public class Ubigeo {
    private String ID;
    private String ID_UBI;
    private String DISTRITO;

    public Ubigeo() {
        this.ID = "";
        this.ID_UBI = "";
        this.DISTRITO = "";
    }


    public Ubigeo(String ID, String ID_UBI, String DISTRITO) {
        this.ID = ID;
        this.ID_UBI = ID_UBI;
        this.DISTRITO = DISTRITO;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID_UBI() {
        return ID_UBI;
    }

    public void setID_UBI(String ID_UBI) {
        this.ID_UBI = ID_UBI;
    }

    public String getDISTRITO() {
        return DISTRITO;
    }

    public void setDISTRITO(String DISTRITO) {
        this.DISTRITO = DISTRITO;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues(3);
        contentValues.put(SQLConstantes.UBIGEO_ID,ID);
        contentValues.put(SQLConstantes.UBIGEO_ID_UBI,ID_UBI);
        contentValues.put(SQLConstantes.UBIGEO_DISTRITO,DISTRITO);
        return contentValues;
    }
}
