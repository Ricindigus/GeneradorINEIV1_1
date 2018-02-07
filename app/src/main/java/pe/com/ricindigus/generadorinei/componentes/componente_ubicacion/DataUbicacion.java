package pe.com.ricindigus.generadorinei.componentes.componente_ubicacion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.componentes.componente_radio.modelo.SQLRadio;
import pe.com.ricindigus.generadorinei.componentes.componente_radio.pojos.PRadio;
import pe.com.ricindigus.generadorinei.componentes.componente_radio.pojos.SPRadio;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.DBHelperComponente;
import pe.com.ricindigus.generadorinei.pojos.Ubigeo;

/**
 * Created by dmorales on 29/01/2018.
 */

public class DataUbicacion {
    Context contexto;
    SQLiteOpenHelper sqLiteOpenHelper;
    SQLiteDatabase sqLiteDatabase;

    public DataUbicacion(Context contexto) {
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

    public long getNumeroItemsUbicacion(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, SQLUbicacion.tablaUbicacion);
    }


    public void insertarUbicacion(Ubicacion ubicacion){
        ContentValues contentValues = ubicacion.toValues();
        sqLiteDatabase.insert(SQLUbicacion.tablaUbicacion,null,contentValues);
    }

    public Ubicacion getUbicacion(String idUbicacion){
        Ubicacion ubicacion = new Ubicacion();
        String[] whereArgs = new String[]{idUbicacion};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLUbicacion.tablaUbicacion,
                    SQLUbicacion.ALL_COLUMNS_UBICACION, SQLUbicacion.WHERE_CLAUSE_ID,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                ubicacion.setID(cursor.getString(cursor.getColumnIndex(SQLUbicacion.UBICACION_ID)));
                ubicacion.setNUMERO(cursor.getString(cursor.getColumnIndex(SQLUbicacion.UBICACION_NUM)));
                ubicacion.setMODULO(cursor.getString(cursor.getColumnIndex(SQLUbicacion.UBICACION_MODULO)));
                ubicacion.setVARDEP(cursor.getString(cursor.getColumnIndex(SQLUbicacion.UBICACION_DEPARTAMENTO)));
                ubicacion.setVARDIS(cursor.getString(cursor.getColumnIndex(SQLUbicacion.UBICACION_DISTRITO)));
                ubicacion.setVARPRO(cursor.getString(cursor.getColumnIndex(SQLUbicacion.UBICACION_PROVINCIA)));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return ubicacion;
    }
}
