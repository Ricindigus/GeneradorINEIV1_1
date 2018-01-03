package pe.com.ricindigus.generadorinei.componentes.componente_radio;

import android.content.ContentValues;

/**
 * Created by RICARDO on 2/01/2018.
 */

public class SPRadio {
    private String ID;
    private String ID_PREGUNTA;
    private String SUBPREGUNTA;
    private String VARIABLE;
    private String VARDESC;

    public SPRadio() {
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
        contentValues.put(SQLRadio.SPRADIO_ID,ID);
        contentValues.put(SQLRadio.SPRADIO_ID_PREGUNTA,ID_PREGUNTA);
        contentValues.put(SQLRadio.SPRADIO_SUBPREGUNTA,SUBPREGUNTA);
        contentValues.put(SQLRadio.SPRADIO_VARIABLE,VARIABLE);
        contentValues.put(SQLRadio.SPRADIO_VARDESC,VARDESC);
        return contentValues;
    }
}
