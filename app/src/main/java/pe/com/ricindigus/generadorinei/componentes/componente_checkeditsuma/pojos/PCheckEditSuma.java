package pe.com.ricindigus.generadorinei.componentes.componente_checkeditsuma.pojos;

import android.content.ContentValues;

import pe.com.ricindigus.generadorinei.componentes.componente_checkeditsuma.modelo.SQLCheckEditSuma;
import pe.com.ricindigus.generadorinei.componentes.componente_editsuma.modelo.SQLEditSuma;

/**
 * Created by dmorales on 30/04/2018.
 */

public class PCheckEditSuma {
    private String ID;
    private String MODULO;
    private String NUMERO;
    private String PREGUNTA;
    private String CABPREG;
    private String CABRES;
    private String VALSUMA;

    public PCheckEditSuma() {
    }

    public PCheckEditSuma(String ID, String MODULO, String NUMERO, String PREGUNTA, String CABPREG, String CABRES, String VALSUMA) {
        this.ID = ID;
        this.MODULO = MODULO;
        this.NUMERO = NUMERO;
        this.PREGUNTA = PREGUNTA;
        this.CABPREG = CABPREG;
        this.CABRES = CABRES;
        this.VALSUMA = VALSUMA;
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

    public String getPREGUNTA() {
        return PREGUNTA;
    }

    public void setPREGUNTA(String PREGUNTA) {
        this.PREGUNTA = PREGUNTA;
    }

    public String getCABPREG() {
        return CABPREG;
    }

    public void setCABPREG(String CABPREG) {
        this.CABPREG = CABPREG;
    }

    public String getCABRES() {
        return CABRES;
    }

    public void setCABRES(String CABRES) {
        this.CABRES = CABRES;
    }

    public String getVALSUMA() {
        return VALSUMA;
    }

    public void setVALSUMA(String VALSUMA) {
        this.VALSUMA = VALSUMA;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLCheckEditSuma.CHECKEDITSUMA_ID,ID);
        contentValues.put(SQLCheckEditSuma.CHECKEDITSUMA_MODULO, MODULO);
        contentValues.put(SQLCheckEditSuma.CHECKEDITSUMA_NUMERO, NUMERO);
        contentValues.put(SQLCheckEditSuma.CHECKEDITSUMA_PREGUNTA, PREGUNTA);
        contentValues.put(SQLCheckEditSuma.CHECKEDITSUMA_CABPREG, CABPREG);
        contentValues.put(SQLCheckEditSuma.CHECKEDITSUMA_CABRES, CABRES);
        contentValues.put(SQLCheckEditSuma.CHECKEDITSUMA_VALSUMA, VALSUMA);
        return contentValues;
    }
}
