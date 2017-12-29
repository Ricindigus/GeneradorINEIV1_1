package pe.com.ricindigus.generadorinei.componentes.componente_radio;

import android.content.ContentValues;

import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.SQLConstantesComponente;

/**
 * Created by dmorales on 21/12/2017.
 */

public class CRadio {
    private String ID;
    private String MODULO;
    private String NUMERO;
    private String PAGINA;
    private String PREGUNTA;
    private String SP1;
    private String SP2;
    private String SP3;
    private String SP4;
    private String SP5;
    private String SP6;
    private String SP7;
    private String SP8;
    private String SP9;
    private String SP10;
    private String VARRADIO;
    private String VARESP;

    public CRadio(String ID, String MODULO, String NUMERO, String PAGINA, String PREGUNTA, String SP1, String SP2, String SP3, String SP4, String SP5, String SP6, String SP7, String SP8, String SP9, String SP10, String VARRADIO, String VARESP) {
        this.ID = ID;
        this.MODULO = MODULO;
        this.NUMERO = NUMERO;
        this.PAGINA = PAGINA;
        this.PREGUNTA = PREGUNTA;
        this.SP1 = SP1;
        this.SP2 = SP2;
        this.SP3 = SP3;
        this.SP4 = SP4;
        this.SP5 = SP5;
        this.SP6 = SP6;
        this.SP7 = SP7;
        this.SP8 = SP8;
        this.SP9 = SP9;
        this.SP10 = SP10;
        this.VARRADIO = VARRADIO;
        this.VARESP = VARESP;
    }

    public CRadio() {
        this.ID = "";
        this.MODULO = "";
        this.NUMERO = "";
        this.PAGINA = "";
        this.PREGUNTA = "";
        this.SP1 = "";
        this.SP2 = "";
        this.SP3 = "";
        this.SP4 = "";
        this.SP5 = "";
        this.SP6 = "";
        this.SP7 = "";
        this.SP8 = "";
        this.SP9 = "";
        this.SP10 = "";
        this.VARRADIO = "";
        this.VARESP = "";
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

    public String getNUMERO() {
        return NUMERO;
    }

    public void setNUMERO(String NUMERO) {
        this.NUMERO = NUMERO;
    }

    public String getPAGINA() {
        return PAGINA;
    }

    public void setPAGINA(String PAGINA) {
        this.PAGINA = PAGINA;
    }

    public String getPREGUNTA() {
        return PREGUNTA;
    }

    public void setPREGUNTA(String PREGUNTA) {
        this.PREGUNTA = PREGUNTA;
    }

    public String getSP1() {
        return SP1;
    }

    public void setSP1(String SP1) {
        this.SP1 = SP1;
    }

    public String getSP2() {
        return SP2;
    }

    public void setSP2(String SP2) {
        this.SP2 = SP2;
    }

    public String getSP3() {
        return SP3;
    }

    public void setSP3(String SP3) {
        this.SP3 = SP3;
    }

    public String getSP4() {
        return SP4;
    }

    public void setSP4(String SP4) {
        this.SP4 = SP4;
    }

    public String getSP5() {
        return SP5;
    }

    public void setSP5(String SP5) {
        this.SP5 = SP5;
    }

    public String getSP6() {
        return SP6;
    }

    public void setSP6(String SP6) {
        this.SP6 = SP6;
    }

    public String getSP7() {
        return SP7;
    }

    public void setSP7(String SP7) {
        this.SP7 = SP7;
    }

    public String getSP8() {
        return SP8;
    }

    public void setSP8(String SP8) {
        this.SP8 = SP8;
    }

    public String getSP9() {
        return SP9;
    }

    public void setSP9(String SP9) {
        this.SP9 = SP9;
    }

    public String getSP10() {
        return SP10;
    }

    public void setSP10(String SP10) {
        this.SP10 = SP10;
    }

    public String getVARRADIO() {
        return VARRADIO;
    }

    public void setVARRADIO(String VARRADIO) {
        this.VARRADIO = VARRADIO;
    }

    public String getVARESP() {
        return VARESP;
    }

    public void setVARESP(String VARESP) {
        this.VARESP = VARESP;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues(16);
        contentValues.put(SQLConstantesComponente.RADIO_ID,ID);
        contentValues.put(SQLConstantesComponente.RADIO_MODULO,MODULO);
        contentValues.put(SQLConstantesComponente.RADIO_NUMERO,NUMERO);
        contentValues.put(SQLConstantesComponente.RADIO_PAGINA,PAGINA);
        contentValues.put(SQLConstantesComponente.RADIO_PREGUNTA,PREGUNTA);
        contentValues.put(SQLConstantesComponente.RADIO_SP1,SP1);
        contentValues.put(SQLConstantesComponente.RADIO_SP2,SP2);
        contentValues.put(SQLConstantesComponente.RADIO_SP3,SP3);
        contentValues.put(SQLConstantesComponente.RADIO_SP4,SP4);
        contentValues.put(SQLConstantesComponente.RADIO_SP5,SP5);
        contentValues.put(SQLConstantesComponente.RADIO_SP6,SP6);
        contentValues.put(SQLConstantesComponente.RADIO_SP7,SP7);
        contentValues.put(SQLConstantesComponente.RADIO_SP8,SP8);
        contentValues.put(SQLConstantesComponente.RADIO_SP9,SP9);
        contentValues.put(SQLConstantesComponente.RADIO_SP10,SP10);
        contentValues.put(SQLConstantesComponente.RADIO_VARRADIO,VARRADIO);
        contentValues.put(SQLConstantesComponente.RADIO_VARESP,VARESP);
        return contentValues;
    }
}
