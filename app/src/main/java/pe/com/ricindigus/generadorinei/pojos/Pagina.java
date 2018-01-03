package pe.com.ricindigus.generadorinei.pojos;

import android.content.ContentValues;

import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.SQLConstantesComponente;

/**
 * Created by dmorales on 18/12/2017.
 */

public class Pagina {
    private String ID;
    private String MODULO;
    private String TIPO1;
    private String IDP1;
    private String TIPO2;
    private String IDP2;
    private String TIPO3;
    private String IDP3;
    private String TIPO4;
    private String IDP4;
    private String TIPO5;
    private String IDP5;
    private String TIPO6;
    private String IDP6;
    private String TIPO7;
    private String IDP7;
    private String TIPO8;
    private String IDP8;
    private String TIPO9;
    private String IDP9;
    private String TIPO10;
    private String IDP10;


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
        IDP6 = "";
        TIPO6 = "";
        IDP7 = "";
        TIPO7 = "";
        IDP8 = "";
        TIPO8 = "";
        IDP9 = "";
        TIPO9 = "";
        IDP10 = "";
        TIPO10 = "";
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

    public String getTIPO1() {
        return TIPO1;
    }

    public void setTIPO1(String TIPO1) {
        this.TIPO1 = TIPO1;
    }

    public String getIDP1() {
        return IDP1;
    }

    public void setIDP1(String IDP1) {
        this.IDP1 = IDP1;
    }

    public String getTIPO2() {
        return TIPO2;
    }

    public void setTIPO2(String TIPO2) {
        this.TIPO2 = TIPO2;
    }

    public String getIDP2() {
        return IDP2;
    }

    public void setIDP2(String IDP2) {
        this.IDP2 = IDP2;
    }

    public String getTIPO3() {
        return TIPO3;
    }

    public void setTIPO3(String TIPO3) {
        this.TIPO3 = TIPO3;
    }

    public String getIDP3() {
        return IDP3;
    }

    public void setIDP3(String IDP3) {
        this.IDP3 = IDP3;
    }

    public String getTIPO4() {
        return TIPO4;
    }

    public void setTIPO4(String TIPO4) {
        this.TIPO4 = TIPO4;
    }

    public String getIDP4() {
        return IDP4;
    }

    public void setIDP4(String IDP4) {
        this.IDP4 = IDP4;
    }

    public String getTIPO5() {
        return TIPO5;
    }

    public void setTIPO5(String TIPO5) {
        this.TIPO5 = TIPO5;
    }

    public String getIDP5() {
        return IDP5;
    }

    public void setIDP5(String IDP5) {
        this.IDP5 = IDP5;
    }

    public String getTIPO6() {
        return TIPO6;
    }

    public void setTIPO6(String TIPO6) {
        this.TIPO6 = TIPO6;
    }

    public String getIDP6() {
        return IDP6;
    }

    public void setIDP6(String IDP6) {
        this.IDP6 = IDP6;
    }

    public String getTIPO7() {
        return TIPO7;
    }

    public void setTIPO7(String TIPO7) {
        this.TIPO7 = TIPO7;
    }

    public String getIDP7() {
        return IDP7;
    }

    public void setIDP7(String IDP7) {
        this.IDP7 = IDP7;
    }

    public String getTIPO8() {
        return TIPO8;
    }

    public void setTIPO8(String TIPO8) {
        this.TIPO8 = TIPO8;
    }

    public String getIDP8() {
        return IDP8;
    }

    public void setIDP8(String IDP8) {
        this.IDP8 = IDP8;
    }

    public String getTIPO9() {
        return TIPO9;
    }

    public void setTIPO9(String TIPO9) {
        this.TIPO9 = TIPO9;
    }

    public String getIDP9() {
        return IDP9;
    }

    public void setIDP9(String IDP9) {
        this.IDP9 = IDP9;
    }

    public String getTIPO10() {
        return TIPO10;
    }

    public void setTIPO10(String TIPO10) {
        this.TIPO10 = TIPO10;
    }

    public String getIDP10() {
        return IDP10;
    }

    public void setIDP10(String IDP10) {
        this.IDP10 = IDP10;
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
        contentValues.put(SQLConstantesComponente.PAGINA_IDP6,IDP6);
        contentValues.put(SQLConstantesComponente.PAGINA_TP6,TIPO6);
        contentValues.put(SQLConstantesComponente.PAGINA_IDP7,IDP7);
        contentValues.put(SQLConstantesComponente.PAGINA_TP7,TIPO7);
        contentValues.put(SQLConstantesComponente.PAGINA_IDP8,IDP8);
        contentValues.put(SQLConstantesComponente.PAGINA_TP8,TIPO8);
        contentValues.put(SQLConstantesComponente.PAGINA_IDP9,IDP9);
        contentValues.put(SQLConstantesComponente.PAGINA_TP9,TIPO9);
        contentValues.put(SQLConstantesComponente.PAGINA_IDP10,IDP10);
        contentValues.put(SQLConstantesComponente.PAGINA_TP10,TIPO10);
        return contentValues;
    }
}
