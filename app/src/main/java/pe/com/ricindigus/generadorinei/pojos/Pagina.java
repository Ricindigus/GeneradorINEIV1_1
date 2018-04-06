package pe.com.ricindigus.generadorinei.pojos;

import android.content.ContentValues;

import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.SQLConstantesComponente;

/**
 * Created by dmorales on 18/12/2017.
 */

public class Pagina {
    private String _id;
    private String MODULO;



    public Pagina() {
        _id = "";
        MODULO = "";
    }

    public Pagina(String _id, String MODULO) {
        this._id = _id;
        this.MODULO = MODULO;
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


    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantesComponente.PAGINA_ID, _id);
        contentValues.put(SQLConstantesComponente.PAGINA_MODULO,MODULO);
        return contentValues;
    }
}
