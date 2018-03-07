package pe.com.ricindigus.generadorinei.pojos;

import android.content.ContentValues;

import pe.com.ricindigus.generadorinei.modelo.DataSourceCaptura.SQLConstantes;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.SQLConstantesComponente;

/**
 * Created by RICARDO on 6/03/2018.
 */

public class Variable {
    private String ID;
    private String TABLA;
    private String MODULO;
    private String PAGINA;
    private String PREGUNTA;

    public Variable() {
        this.ID = "";
        this.TABLA = "";
        this.MODULO = "";
        this.PAGINA = "";
        this.PREGUNTA = "";
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTABLA() {
        return TABLA;
    }

    public void setTABLA(String TABLA) {
        this.TABLA = TABLA;
    }

    public String getMODULO() {
        return MODULO;
    }

    public void setMODULO(String MODULO) {
        this.MODULO = MODULO;
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

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantesComponente.VARIABLE_ID,ID);
        contentValues.put(SQLConstantesComponente.VARIABLE_MODULO,MODULO);
        contentValues.put(SQLConstantesComponente.VARIABLE_PAGINA,PAGINA);
        contentValues.put(SQLConstantesComponente.VARIABLE_PREGUNTA,PREGUNTA);
        contentValues.put(SQLConstantesComponente.VARIABLE_TABLA,TABLA);
        return contentValues;
    }
}
