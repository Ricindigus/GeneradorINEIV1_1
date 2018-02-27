package pe.com.ricindigus.generadorinei.componentes.componente_gps.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import pe.com.ricindigus.generadorinei.componentes.componente_gps.pojos.GPS;
import pe.com.ricindigus.generadorinei.componentes.componente_ubicacion.modelo.SQLUbicacion;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.DBHelperComponente;

/**
 * Created by dmorales on 29/01/2018.
 */

public class DataGPS {
    Context contexto;
    SQLiteOpenHelper sqLiteOpenHelper;
    SQLiteDatabase sqLiteDatabase;

    public DataGPS(Context contexto) {
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

    public long getNumeroItemsGPS(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, SQLGps.tablaGPS);
    }


    public void insertarGPS(GPS gps){
        ContentValues contentValues = gps.toValues();
        sqLiteDatabase.insert(SQLGps.tablaGPS,null,contentValues);
    }

    public GPS getGPS(String idGPS){
        GPS gps = new GPS();
        String[] whereArgs = new String[]{idGPS};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLGps.tablaGPS,
                    SQLGps.ALL_COLUMNS_GPS, SQLUbicacion.WHERE_CLAUSE_ID,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                gps.setID(cursor.getString(cursor.getColumnIndex(SQLGps.GPS_ID)));
                gps.setNUMERO(cursor.getString(cursor.getColumnIndex(SQLGps.GPS_NUMERO)));
                gps.setMODULO(cursor.getString(cursor.getColumnIndex(SQLGps.GPS_MODULO)));
                gps.setVARALT(cursor.getString(cursor.getColumnIndex(SQLGps.GPS_ALTITUD)));
                gps.setVARLAT(cursor.getString(cursor.getColumnIndex(SQLGps.GPS_LATITUD)));
                gps.setVARLONG(cursor.getString(cursor.getColumnIndex(SQLGps.GPS_LONGITUD)));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return gps;
    }
}
