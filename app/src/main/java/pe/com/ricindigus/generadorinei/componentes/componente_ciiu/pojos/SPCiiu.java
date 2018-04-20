package pe.com.ricindigus.generadorinei.componentes.componente_ciiu.pojos;

import android.content.ContentValues;

import pe.com.ricindigus.generadorinei.componentes.componente_ciiu.modelo.SQLCiiu;

/**
 * Created by dmorales on 19/04/2018.
 */

public class SPCiiu {
    private String ID;
    private String ID_PREGUNTA;
    private String SUBPREGUNTA;
    private String VARACT;
    private String VARCIIU;
    private String VARCK;

    public SPCiiu(String ID, String ID_PREGUNTA, String SUBPREGUNTA, String VARACT, String VARCIIU, String VARCK) {
        this.ID = ID;
        this.ID_PREGUNTA = ID_PREGUNTA;
        this.SUBPREGUNTA = SUBPREGUNTA;
        this.VARACT = VARACT;
        this.VARCIIU = VARCIIU;
        this.VARCK = VARCK;
    }

    public SPCiiu() {
        this.ID = "";
        this.ID_PREGUNTA = "";
        this.SUBPREGUNTA = "";
        this.VARACT = "";
        this.VARCIIU = "";
        this.VARCK = "";
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

    public String getVARACT() {
        return VARACT;
    }

    public void setVARACT(String VARACT) {
        this.VARACT = VARACT;
    }

    public String getVARCIIU() {
        return VARCIIU;
    }

    public void setVARCIIU(String VARCIIU) {
        this.VARCIIU = VARCIIU;
    }

    public String getVARCK() {
        return VARCK;
    }

    public void setVARCK(String VARCK) {
        this.VARCK = VARCK;
    }

    public String getSUBPREGUNTA() {
        return SUBPREGUNTA;
    }

    public void setSUBPREGUNTA(String SUBPREGUNTA) {
        this.SUBPREGUNTA = SUBPREGUNTA;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLCiiu.SPCIIU_ID,ID);
        contentValues.put(SQLCiiu.SPCIIU_ID_PREGUNTA,ID_PREGUNTA);
        contentValues.put(SQLCiiu.SPCIIU_SUBPREGUNTA,SUBPREGUNTA);
        contentValues.put(SQLCiiu.SPCIIU_VARACT,VARACT);
        contentValues.put(SQLCiiu.SPCIIU_VARCIIU, VARCIIU);
        contentValues.put(SQLCiiu.SPCIIU_VARCK,VARCK);
        return contentValues;
    }
}
