package pe.com.ricindigus.generadorinei.componentes.componente_visitas.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.componentes.componente_visitas.pojos.Visita;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.DBHelperComponente;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.SQLConstantesComponente;

/**
 * Created by RICARDO on 1/01/2018.
 */

public class DataVisitas {
    Context contexto;
    SQLiteOpenHelper sqLiteOpenHelper;
    SQLiteDatabase sqLiteDatabase;

    public DataVisitas(Context contexto) {
        this.contexto = contexto;
        sqLiteOpenHelper = new DBHelperComponente(contexto);
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
    public void insertarVisitas(ArrayList<Visita> visitas){
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
                visita.setVARNUM(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARNUM)));
                visita.setVARDIA(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARDIA)));
                visita.setVARMES(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARMES)));
                visita.setVARANIO(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARANIO)));
                visita.setVARHORI(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARHORI)));
                visita.setVARMINI(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARMINI)));
                visita.setVARHORF(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARHORF)));
                visita.setVARMINF(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARMINF)));
                visita.setVARRES(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARRES)));
                visita.setVARDIAP(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARDIAP)));
                visita.setVARMESP(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARMESP)));
                visita.setVARANIOP(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARANIOP)));
                visita.setVARHORP(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARHORP)));
                visita.setVARMINP(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARMINP)));
                visita.setVARRESFINAL(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARRESFINAL)));
                visita.setVARRESDIA(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARRESDIA)));
                visita.setVARRESMES(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARRESMES)));
                visita.setVARRESANIO(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARRESANIO)));
                visita.setVARRESHORA(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARRESHORA)));
                visita.setVARRESMIN(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARRESMIN)));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return visita;
    }

    public ArrayList<Visita> getAllVisitas(){
        ArrayList<Visita> visitas = new ArrayList<>();
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLVisitas.tableVisitas, null, null,null,null,null,null);
            if(cursor.moveToNext()){
                Visita visita = new Visita();
                visita.setID(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_ID)));
                visita.setMODULO(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_MODULO)));
                visita.setNUMERO(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_NUMERO)));
                visita.setVARNUM(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARNUM)));
                visita.setVARDIA(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARDIA)));
                visita.setVARMES(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARMES)));
                visita.setVARANIO(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARANIO)));
                visita.setVARHORI(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARHORI)));
                visita.setVARMINI(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARMINI)));
                visita.setVARHORF(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARHORF)));
                visita.setVARMINF(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARMINF)));
                visita.setVARRES(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARRES)));
                visita.setVARDIAP(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARDIAP)));
                visita.setVARMESP(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARMESP)));
                visita.setVARANIOP(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARANIOP)));
                visita.setVARHORP(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARHORP)));
                visita.setVARMINP(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARMINP)));
                visita.setVARRESFINAL(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARRESFINAL)));
                visita.setVARRESDIA(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARRESDIA)));
                visita.setVARRESMES(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARRESMES)));
                visita.setVARRESANIO(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARRESANIO)));
                visita.setVARRESHORA(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARRESHORA)));
                visita.setVARRESMIN(cursor.getString(cursor.getColumnIndex(SQLVisitas.VISITA_VARRESMIN)));
                visitas.add(visita);
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return visitas;
    }

}
