package pe.com.ricindigus.generadorinei.pojos;

import android.content.ContentValues;

import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.SQLConstantesComponente;

/**
 * Created by dmorales on 18/12/2017.
 */

public class Pagina {
    private String ID;
    private String MODULO;
    private String IDP1;
    private String TIPO1;
    private String IDP2;
    private String TIPO2;
    private String IDP3;
    private String TIPO3;
    private String IDP4;
    private String TIPO4;
    private String IDP5;
    private String TIPO5;

    public Pagina() {
        ID = "";
        MODULO = "";
        IDP1 = "";
        TIPO1 = "";
        IDP2 = "";
        TIPO2 = "";
        IDP3 = "";
        TIPO3 = "";
        IDP4 = "";
        TIPO4 = "";
        IDP5 = "";
        TIPO5 = "";
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMODULO() {
        return MODULO;
    }

    public void setMODULO(String MODULO) {
        this.MODULO = MODULO;
    }

    public String getIDP1() {
        return IDP1;
    }

    public void setIDP1(String IDP1) {
        this.IDP1 = IDP1;
    }

    public String getTIPO1() {
        return TIPO1;
    }

    public void setTIPO1(String TIPO1) {
        this.TIPO1 = TIPO1;
    }

    public String getIDP2() {
        return IDP2;
    }

    public void setIDP2(String IDP2) {
        this.IDP2 = IDP2;
    }

    public String getTIPO2() {
        return TIPO2;
    }

    public void setTIPO2(String TIPO2) {
        this.TIPO2 = TIPO2;
    }

    public String getIDP3() {
        return IDP3;
    }

    public void setIDP3(String IDP3) {
        this.IDP3 = IDP3;
    }

    public String getTIPO3() {
        return TIPO3;
    }

    public void setTIPO3(String TIPO3) {
        this.TIPO3 = TIPO3;
    }

    public String getIDP4() {
        return IDP4;
    }

    public void setIDP4(String IDP4) {
        this.IDP4 = IDP4;
    }

    public String getTIPO4() {
        return TIPO4;
    }

    public void setTIPO4(String TIPO4) {
        this.TIPO4 = TIPO4;
    }

    public String getIDP5() {
        return IDP5;
    }

    public void setIDP5(String IDP5) {
        this.IDP5 = IDP5;
    }

    public String getTIPO5() {
        return TIPO5;
    }

    public void setTIPO5(String TIPO5) {
        this.TIPO5 = TIPO5;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues(13);
        contentValues.put(SQLConstantesComponente.PAGINA_ID,ID);
        contentValues.put(SQLConstantesComponente.PAGINA_MODULO,MODULO);
        contentValues.put(SQLConstantesComponente.PAGINA_IDP1,IDP1);
        contentValues.put(SQLConstantesComponente.PAGINA_TP1,TIPO1);
        contentValues.put(SQLConstantesComponente.PAGINA_IDP2,IDP2);
        contentValues.put(SQLConstantesComponente.PAGINA_TP2,TIPO2);
        contentValues.put(SQLConstantesComponente.PAGINA_IDP3,IDP3);
        contentValues.put(SQLConstantesComponente.PAGINA_TP3,TIPO3);
        contentValues.put(SQLConstantesComponente.PAGINA_IDP4,IDP4);
        contentValues.put(SQLConstantesComponente.PAGINA_TP4,TIPO4);
        contentValues.put(SQLConstantesComponente.PAGINA_IDP5,IDP5);
        contentValues.put(SQLConstantesComponente.PAGINA_TP5,TIPO5);
        return contentValues;
    }
}
