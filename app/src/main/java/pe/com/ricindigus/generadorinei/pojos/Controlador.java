package pe.com.ricindigus.generadorinei.pojos;

import android.content.ContentValues;

import pe.com.ricindigus.generadorinei.modelo.DataSourceCaptura.SQLConstantes;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.SQLConstantesComponente;

/**
 * Created by RICARDO on 28/02/2018.
 */

public class Controlador {
    private String ID;
    private String ID_EMPRESA;
    private String ID_PREGUNTA;
    private String VARIABLE;

    public Controlador(String ID, String ID_EMPRESA, String ID_PREGUNTA, String VARIABLE) {
        this.ID = ID;
        this.ID_EMPRESA = ID_EMPRESA;
        this.ID_PREGUNTA = ID_PREGUNTA;
        this.VARIABLE = VARIABLE;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID_EMPRESA() {
        return ID_EMPRESA;
    }

    public void setID_EMPRESA(String ID_EMPRESA) {
        this.ID_EMPRESA = ID_EMPRESA;
    }

    public String getID_PREGUNTA() {
        return ID_PREGUNTA;
    }

    public void setID_PREGUNTA(String ID_PREGUNTA) {
        this.ID_PREGUNTA = ID_PREGUNTA;
    }

    public String getVARIABLE() {
        return VARIABLE;
    }

    public void setVARIABLE(String VARIABLE) {
        this.VARIABLE = VARIABLE;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.CONTROLADOR_ID,ID);
        contentValues.put(SQLConstantes.CONTROLADOR_ID_EMPRESA,ID_EMPRESA);
        contentValues.put(SQLConstantes.CONTROLADOR_ID_PREGUNTA,ID_PREGUNTA);
        contentValues.put(SQLConstantes.CONTROLADOR_VARIABLE,VARIABLE);
        return contentValues;
    }
}
