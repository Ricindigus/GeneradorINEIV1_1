package pe.com.ricindigus.generadorinei.pojos;

import android.content.ContentValues;

import pe.com.ricindigus.generadorinei.modelo.DataSourceCaptura.SQLConstantes;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.SQLConstantesComponente;

/**
 * Created by dmorales on 26/02/2018.
 */

public class Evento {
    private String ID;
    private String IDPREGA;
    private String IDPREGB;
    private String VAR;
    private String VAL;
    private String IDPAGA;
    private String IDPAGB;
    private String ACCION;


    public Evento() {
        this.ID = "";
        this.IDPREGA = "";
        this.IDPREGB = "";
        this.VAR = "";
        this.VAL = "";
        this.IDPAGA = "";
        this.IDPAGB = "";
        this.ACCION = "";

    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getIDPREGA() {
        return IDPREGA;
    }

    public void setIDPREGA(String IDPREGA) {
        this.IDPREGA = IDPREGA;
    }

    public String getIDPREGB() {
        return IDPREGB;
    }

    public void setIDPREGB(String IDPREGB) {
        this.IDPREGB = IDPREGB;
    }

    public String getVAR() {
        return VAR;
    }

    public void setVAR(String VAR) {
        this.VAR = VAR;
    }

    public String getVAL() {
        return VAL;
    }

    public void setVAL(String VAL) {
        this.VAL = VAL;
    }

    public String getIDPAGA() {
        return IDPAGA;
    }

    public void setIDPAGA(String IDPAGA) {
        this.IDPAGA = IDPAGA;
    }

    public String getIDPAGB() {
        return IDPAGB;
    }

    public void setIDPAGB(String IDPAGB) {
        this.IDPAGB = IDPAGB;
    }

    public String getACCION() {
        return ACCION;
    }

    public void setACCION(String ACCION) {
        this.ACCION = ACCION;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantesComponente.EVENTO_ID,ID);
        contentValues.put(SQLConstantesComponente.EVENTO_IDPREGA,IDPREGA);
        contentValues.put(SQLConstantesComponente.EVENTO_IDPREGB,IDPREGB);
        contentValues.put(SQLConstantesComponente.EVENTO_VAR,VAR);
        contentValues.put(SQLConstantesComponente.EVENTO_VAL,VAL);
        contentValues.put(SQLConstantesComponente.EVENTO_IDPAGA,IDPAGA);
        contentValues.put(SQLConstantesComponente.EVENTO_IDPAGB,IDPAGB);
        contentValues.put(SQLConstantesComponente.EVENTO_ACCION,ACCION);
        return contentValues;
    }
}
