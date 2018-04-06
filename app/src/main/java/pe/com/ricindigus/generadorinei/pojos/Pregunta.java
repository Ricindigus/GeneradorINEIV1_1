package pe.com.ricindigus.generadorinei.pojos;

import android.content.ContentValues;

import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.SQLConstantesComponente;

/**
 * Created by RICARDO on 3/04/2018.
 */

public class Pregunta {
    private String _id;
    private String MODULO;
    private String PAGINA;
    private String NUMERO;
    private String TIPO;


    public Pregunta(String _id, String ID_PREGUNTA, String MODULO, String PAGINA, String NUMERO, String TIPO) {
        this._id = _id;
        this.MODULO = MODULO;
        this.PAGINA = PAGINA;
        this.NUMERO = NUMERO;
        this.TIPO = TIPO;
    }

    public Pregunta() {
        this._id = "";
        this.MODULO = "";
        this.PAGINA = "";
        this.NUMERO = "";
        this.TIPO = "";
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
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

    public String getNUMERO() {
        return NUMERO;
    }

    public void setNUMERO(String NUMERO) {
        this.NUMERO = NUMERO;
    }

    public String getTIPO() {
        return TIPO;
    }

    public void setTIPO(String TIPO) {
        this.TIPO = TIPO;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantesComponente.PREGUNTA_ID, _id);
        contentValues.put(SQLConstantesComponente.PREGUNTA_MODULO,MODULO);
        contentValues.put(SQLConstantesComponente.PREGUNTA_PAGINA,PAGINA);
        contentValues.put(SQLConstantesComponente.PREGUNTA_NUMERO,NUMERO);
        contentValues.put(SQLConstantesComponente.PREGUNTA_TIPO,TIPO);
        return contentValues;
    }
}
