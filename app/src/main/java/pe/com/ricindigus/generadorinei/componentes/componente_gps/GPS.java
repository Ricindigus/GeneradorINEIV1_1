package pe.com.ricindigus.generadorinei.componentes.componente_gps;

import android.content.ContentValues;

/**
 * Created by dmorales on 29/01/2018.
 */

public class GPS {
    private String ID;
    private String VARLAT;
    private String VARLONG;
    private String VARALT;


    public GPS() {
        this.ID = "";
        this.VARLAT = "";
        this.VARLONG = "";
        this.VARALT = "";
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getVARLAT() {
        return VARLAT;
    }

    public void setVARLAT(String VARLAT) {
        this.VARLAT = VARLAT;
    }

    public String getVARLONG() {
        return VARLONG;
    }

    public void setVARLONG(String VARLONG) {
        this.VARLONG = VARLONG;
    }

    public String getVARALT() {
        return VARALT;
    }

    public void setVARALT(String VARALT) {
        this.VARALT = VARALT;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLGps.GPS_ID,ID);
        contentValues.put(SQLGps.GPS_ALTITUD,VARALT);
        contentValues.put(SQLGps.GPS_LATITUD,VARLAT);
        contentValues.put(SQLGps.GPS_LONGITUD,VARLONG);
        return contentValues;
    }
}
