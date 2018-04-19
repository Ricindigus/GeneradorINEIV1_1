package pe.com.ricindigus.generadorinei.componentes.componente_ciiu.pojos;

import android.content.ContentValues;

import pe.com.ricindigus.generadorinei.componentes.componente_ciiu.modelo.SQLCiiu;

/**
 * Created by dmorales on 19/04/2018.
 */

public class SPCiiu {
    private String ID;
    private String ID_PREGUNTA;
    private String VARACT;
    private String VARAUTO;
    private String VARCK;

    public SPCiiu(String ID, String ID_PREGUNTA, String VARACT, String VARAUTO, String VARCK) {
        this.ID = ID;
        this.ID_PREGUNTA = ID_PREGUNTA;
        this.VARACT = VARACT;
        this.VARAUTO = VARAUTO;
        this.VARCK = VARCK;
    }

    public SPCiiu() {
        this.ID = "";
        this.ID_PREGUNTA = "";
        this.VARACT = "";
        this.VARAUTO = "";
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

    public String getVARAUTO() {
        return VARAUTO;
    }

    public void setVARAUTO(String VARAUTO) {
        this.VARAUTO = VARAUTO;
    }

    public String getVARCK() {
        return VARCK;
    }

    public void setVARCK(String VARCK) {
        this.VARCK = VARCK;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLCiiu.SPCIIU_ID,ID);
        contentValues.put(SQLCiiu.SPCIIU_ID_PREGUNTA,ID_PREGUNTA);
        contentValues.put(SQLCiiu.SPCIIU_VARACT,VARACT);
        contentValues.put(SQLCiiu.SPCIIU_VARAUTO,VARAUTO);
        contentValues.put(SQLCiiu.SPCIIU_VARCK,VARCK);
        return contentValues;
    }
}
