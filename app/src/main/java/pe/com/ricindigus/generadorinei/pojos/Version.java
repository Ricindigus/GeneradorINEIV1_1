package pe.com.ricindigus.generadorinei.pojos;

import android.content.ContentValues;

import pe.com.ricindigus.generadorinei.modelo.DataControladorVersiones.SQLVersion;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.SQLConstantesComponente;

/**
 * Created by dmorales on 16/03/2018.
 */

public class Version {
    private String ID;
    private String CAPTURA;
    private String COMPONENTES;
    private String TABLAS;

    public Version(String ID, String CAPTURA, String COMPONENTES, String TABLAS) {
        this.ID = ID;
        this.CAPTURA = CAPTURA;
        this.COMPONENTES = COMPONENTES;
        this.TABLAS = TABLAS;
    }

    public Version() {
        this.ID = "";
        this.CAPTURA = "";
        this.COMPONENTES = "";
        this.TABLAS = "";
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getCAPTURA() {
        return CAPTURA;
    }

    public void setCAPTURA(String CAPTURA) {
        this.CAPTURA = CAPTURA;
    }

    public String getCOMPONENTES() {
        return COMPONENTES;
    }

    public void setCOMPONENTES(String COMPONENTES) {
        this.COMPONENTES = COMPONENTES;
    }

    public String getTABLAS() {
        return TABLAS;
    }

    public void setTABLAS(String TABLAS) {
        this.TABLAS = TABLAS;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLVersion.VERSION_ID,ID);
        contentValues.put(SQLVersion.VERSION_BD_CAPTURA,CAPTURA);
        contentValues.put(SQLVersion.VERSION_BD_COMPONENTES,COMPONENTES);
        contentValues.put(SQLVersion.VERSION_BD_TABLAS,TABLAS);
        return contentValues;
    }
}
