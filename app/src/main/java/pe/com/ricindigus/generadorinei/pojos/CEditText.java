package pe.com.ricindigus.generadorinei.pojos;

import android.content.ContentValues;

import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.SQLConstantesComponente;

/**
 * Created by dmorales on 13/12/2017.
 */

public class CEditText {
    private String ID;
    private String SP1;
    private String VAR1;
    private String SP2;
    private String VAR2;
    private String SP3;
    private String VAR3;

    public CEditText() {
        ID = "";
        SP1 = "";
        VAR1 = "";
        SP2 = "";
        VAR2 = "";
        SP3 = "";
        VAR3 = "";
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getSP1() {
        return SP1;
    }

    public void setSP1(String SP1) {
        this.SP1 = SP1;
    }

    public String getVAR1() {
        return VAR1;
    }

    public void setVAR1(String VAR1) {
        this.VAR1 = VAR1;
    }

    public String getSP2() {
        return SP2;
    }

    public void setSP2(String SP2) {
        this.SP2 = SP2;
    }

    public String getVAR2() {
        return VAR2;
    }

    public void setVAR2(String VAR2) {
        this.VAR2 = VAR2;
    }

    public String getSP3() {
        return SP3;
    }

    public void setSP3(String SP3) {
        this.SP3 = SP3;
    }

    public String getVAR3() {
        return VAR3;
    }

    public void setVAR3(String VAR3) {
        this.VAR3 = VAR3;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues(7);
        contentValues.put(SQLConstantesComponente.EDITTEXT_ID,ID);
        contentValues.put(SQLConstantesComponente.EDITTEXT_SP1,SP1);
        contentValues.put(SQLConstantesComponente.EDITTEXT_VAR1,VAR1);
        contentValues.put(SQLConstantesComponente.EDITTEXT_SP2,SP2);
        contentValues.put(SQLConstantesComponente.EDITTEXT_VAR2,VAR2);
        contentValues.put(SQLConstantesComponente.EDITTEXT_SP3,SP3);
        contentValues.put(SQLConstantesComponente.EDITTEXT_VAR3,VAR3);
        return contentValues;
    }
}
