package pe.com.ricindigus.generadorinei.componentes.componente_visitas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.componentes.componente_edittext.modelo.SQLEditText;
import pe.com.ricindigus.generadorinei.componentes.componente_edittext.pojos.PEditText;
import pe.com.ricindigus.generadorinei.modelo.DataSourceCaptura.DBHelper;
import pe.com.ricindigus.generadorinei.modelo.DataSourceCaptura.SQLConstantes;

/**
 * Created by RICARDO on 1/01/2018.
 */

public class DataVisitas {
    Context contexto;
    SQLiteOpenHelper sqLiteOpenHelper;
    SQLiteDatabase sqLiteDatabase;

    public DataVisitas(Context contexto) {
        this.contexto = contexto;
        sqLiteOpenHelper = new DBHelper(contexto);
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    }

    public void open(){
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    }

    public void close(){
        sqLiteOpenHelper.close();
    }

    public long getNumeroItemsVisita(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase,SQLVisitas.tableVisitas);
    }

    public void insertarVisita(Visita visita){
        ContentValues contentValues = visita.toValues();
        sqLiteDatabase.insert(SQLVisitas.tableVisitas,null,contentValues);
    }
    public void insertarVisita(ArrayList<Visita> visitas){
        long items = getNumeroItemsVisita();
        if(items == 0){
            for (Visita visita : visitas) {
                try {
                    insertarVisita(visita);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public Visita getVisita(String idVisita){
        Visita visita = new Visita();
        String[] whereArgs = new String[]{idVisita};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLVisitas.tableVisitas,
                    SQLVisitas.ALL_COLUMNS_VISITAS, SQLVisitas.WHERE_CLAUSE_ID,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                visita.setID(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_ID)));
                visita.setMODULO(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_MODULO)));
                visita.setNUMERO(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_NUMERO)));
                visita.setVARDIA(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARDIA)));
                visita.setVARMES(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARMES)));
                visita.setVARANIO(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARANIO)));
                visita.setVARHORI(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARHORI)));
                visita.setVARHORF(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARMINI)));
                visita.setVARRES(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARRES)));
                visita.setVARDIAP(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARDIAP)));
                visita.setVARMESP(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARMESP)));
                visita.setVARANIOP(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARANIOP)));
                visita.setVARHORP(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARHORP)));
                visita.setVARMINP(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARMINP)));
                visita.setVARRESFINAL(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARRESFINAL)));
                visita.setVARRESFECHA(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARRESFECHA)));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return visita;
    }

}
