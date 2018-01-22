package pe.com.ricindigus.generadorinei.componentes.componente_checkbox.pojos;

import android.content.ContentValues;

import pe.com.ricindigus.generadorinei.componentes.componente_checkbox.modelo.SQLCheckBox;

/**
 * Created by RICARDO on 2/01/2018.
 */

public class SPCheckBox {
    private String ID;
    private String ID_PREGUNTA;
    private String SUBPREGUNTA;
    private String VARIABLE;
    private String VARDESC;

    public SPCheckBox() {
        this.ID = "";
        this.ID_PREGUNTA = "";
        this.SUBPREGUNTA = "";
        this.VARIABLE = "";
        this.VARDESC = "";
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

    public String getVARIABLE() {
        return VARIABLE;
    }

    public void setVARIABLE(String VARIABLE) {
        this.VARIABLE = VARIABLE;
    }

    public String getVARDESC() {
        return VARDESC;
    }

    public void setVARDESC(String VARDESC) {
        this.VARDESC = VARDESC;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues(5);
        contentValues.put(SQLCheckBox.SPCHECKBOX_ID,ID);
        contentValues.put(SQLCheckBox.SPCHECKBOX_ID_PREGUNTA,ID_PREGUNTA);
        contentValues.put(SQLCheckBox.SPCHECKBOX_SUBPREGUNTA,SUBPREGUNTA);
        contentValues.put(SQLCheckBox.SPCHECKBOX_VARIABLE,VARIABLE);
        contentValues.put(SQLCheckBox.SPCHECKBOX_VARDESC,VARDESC);
        return contentValues;
    }
}
