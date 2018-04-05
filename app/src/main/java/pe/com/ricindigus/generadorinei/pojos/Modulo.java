package pe.com.ricindigus.generadorinei.pojos;

import android.content.ContentValues;

import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.SQLConstantesComponente;

/**
 * Created by dmorales on 20/12/2017.
 */

public class Modulo {
    private String ID;
    private String TITULO;
    private String CABECERA;
    private String TABLA_XML;
    private String NPAGINAS;



    public Modulo() {
        this.ID = "";
        this.TITULO = "";
        this.CABECERA = "";
        this.TABLA_XML = "";
        this.NPAGINAS = "";
    }

    public Modulo(String ID, String TITULO, String CABECERA, String TABLA_XML, String NPAGINAS) {
        this.ID = ID;
        this.TITULO = TITULO;
        this.CABECERA = CABECERA;
        this.TABLA_XML = TABLA_XML;
        this.NPAGINAS = NPAGINAS;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTITULO() {
        return TITULO;
    }

    public void setTITULO(String TITULO) {
        this.TITULO = TITULO;
    }

    public String getCABECERA() {
        return CABECERA;
    }

    public void setCABECERA(String CABECERA) {
        this.CABECERA = CABECERA;
    }

    public String getTABLA_XML() {
        return TABLA_XML;
    }

    public void setTABLA_XML(String TABLA_XML) {
        this.TABLA_XML = TABLA_XML;
    }

    public String getNPAGINAS() {
        return NPAGINAS;
    }

    public void setNPAGINAS(String NPAGINAS) {
        this.NPAGINAS = NPAGINAS;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantesComponente.MODULO_ID,ID);
        contentValues.put(SQLConstantesComponente.MODULO_TITULO,TITULO);
        contentValues.put(SQLConstantesComponente.MODULO_CABECERA,CABECERA);
        contentValues.put(SQLConstantesComponente.MODULO_TABLA_XML, TABLA_XML);
        contentValues.put(SQLConstantesComponente.MODULO_NPAGINAS, NPAGINAS);
        return contentValues;
    }
}
