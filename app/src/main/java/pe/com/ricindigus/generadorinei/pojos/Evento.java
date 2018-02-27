package pe.com.ricindigus.generadorinei.pojos;

import android.content.ContentValues;

import pe.com.ricindigus.generadorinei.modelo.DataSourceCaptura.SQLConstantes;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.SQLConstantesComponente;

/**
 * Created by dmorales on 26/02/2018.
 */

public class Evento {
    private String ID;
    private String IDPREG;
    private String VAR;
    private String VAL;
    private String IDOCU;
    private String IDPAG;
    private String ACCION;

    public Evento() {
        this.ID = "";
        this.IDPREG = "";
        this.VAR = "";
        this.VAL = "";
        this.IDOCU = "";
        this.IDPAG = "";
        this.ACCION = "";
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getIDPREG() {
        return IDPREG;
    }

    public void setIDPREG(String IDPREG) {
        this.IDPREG = IDPREG;
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

    public String getIDOCU() {
        return IDOCU;
    }

    public void setIDOCU(String IDOCU) {
        this.IDOCU = IDOCU;
    }

    public String getIDPAG() {
        return IDPAG;
    }

    public void setIDPAG(String IDPAG) {
        this.IDPAG = IDPAG;
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
        contentValues.put(SQLConstantesComponente.EVENTO_IDPREG,IDPREG);
        contentValues.put(SQLConstantesComponente.EVENTO_VAR,VAR);
        contentValues.put(SQLConstantesComponente.EVENTO_VAL,VAL);
        contentValues.put(SQLConstantesComponente.EVENTO_IDOCU,IDOCU);
        contentValues.put(SQLConstantesComponente.EVENTO_IDPAG,IDPAG);
        contentValues.put(SQLConstantesComponente.EVENTO_ACCION,ACCION);
        return contentValues;
    }
}
