package pe.com.ricindigus.generadorinei.componentes.componente_formulario;

import android.content.ContentValues;

/**
 * Created by dmorales on 30/01/2018.
 */

public class SPFormulario {
    private String ID;
    private String ID_PREGUNTA;
    private String SUBPREGUNTA;
    private String VARE;
    private String TIPO;
    private String LONG;
    private String VARS;
    private String VARESP;

    public SPFormulario() {
        this.ID = "";
        this.ID_PREGUNTA = "";
        this.SUBPREGUNTA = "";
        this.VARE = "";
        this.TIPO = "";
        this.LONG = "";
        this.VARS = "";
        this.VARESP = "";
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID_PREGUNTA() {
        return ID_PREGUNTA;
    }

    public void setID_PREGUNTA(String ID_PREGUNTA) {
        this.ID_PREGUNTA = ID_PREGUNTA;
    }

    public String getSUBPREGUNTA() {
        return SUBPREGUNTA;
    }

    public void setSUBPREGUNTA(String SUBPREGUNTA) {
        this.SUBPREGUNTA = SUBPREGUNTA;
    }

    public String getVARE() {
        return VARE;
    }

    public void setVARE(String VARE) {
        this.VARE = VARE;
    }

    public String getTIPO() {
        return TIPO;
    }

    public void setTIPO(String TIPO) {
        this.TIPO = TIPO;
    }

    public String getLONG() {
        return LONG;
    }

    public void setLONG(String LONG) {
        this.LONG = LONG;
    }

    public String getVARS() {
        return VARS;
    }

    public void setVARS(String VARS) {
        this.VARS = VARS;
    }

    public String getVARESP() {
        return VARESP;
    }

    public void setVARESP(String VARESP) {
        this.VARESP = VARESP;
    }

    public ContentValues toValues(){
        ContentValues contentValues =  new ContentValues();
        contentValues.put(SQLFormulario.SP_FORMU_ID,ID);
        contentValues.put(SQLFormulario.SP_FORMU_IDPREGUNTA,ID_PREGUNTA);
        contentValues.put(SQLFormulario.SP_FORMU_SUBPREGUNTA,SUBPREGUNTA);
        contentValues.put(SQLFormulario.SP_FORMU_VARE,VARE);
        contentValues.put(SQLFormulario.SP_FORMU_LONG,LONG);
        contentValues.put(SQLFormulario.SP_FORMU_TIPO,TIPO);
        contentValues.put(SQLFormulario.SP_FORMU_VARS,VARS);
        contentValues.put(SQLFormulario.SP_FORMU_VARESP,VARESP);
        return contentValues;
    }
}
