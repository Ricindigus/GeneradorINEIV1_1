package pe.com.ricindigus.generadorinei.componentes.componente_ubicacion.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.componentes.componente_ubicacion.pojos.Ubicacion;
import pe.com.ricindigus.generadorinei.componentes.componente_visitas.modelo.SQLVisitas;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.DBHelperComponente;

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

    public void actualizarUbicacion(String idPregunta, ContentValues contentValues){
        sqLiteDatabase.update(SQLUbicacion.tablaUbicacion, contentValues,SQLVisitas.WHERE_CLAUSE_ID,new String[]{idPregunta});
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
            while(cursor.moveToNext()){
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
    public boolean existeUbicacion(String idUbicacion){
        String[] whereArgs = new String[]{idUbicacion};
        Cursor cursor = null;
        boolean existe = false;
        try{
            cursor = sqLiteDatabase.query(SQLUbicacion.tablaUbicacion, SQLUbicacion.ALL_COLUMNS_UBICACION, SQLUbicacion.WHERE_CLAUSE_ID,whereArgs,null,null,null);
            if (cursor.getCount() == 1) existe = true;
        }finally{
            if(cursor != null) cursor.close();
        }
        return existe;
    }
    public ArrayList<Ubicacion> getAllUbicacion(){
        ArrayList<Ubicacion> ubicaciones= new ArrayList<>();
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLUbicacion.tablaUbicacion, null, null, null,null,null,null);
            while(cursor.moveToNext()){
                Ubicacion ubicacion = new Ubicacion();
                ubicacion.setID(cursor.getString(cursor.getColumnIndex(SQLUbicacion.UBICACION_ID)));
                ubicacion.setNUMERO(cursor.getString(cursor.getColumnIndex(SQLUbicacion.UBICACION_NUM)));
                ubicacion.setMODULO(cursor.getString(cursor.getColumnIndex(SQLUbicacion.UBICACION_MODULO)));
                ubicacion.setVARDEP(cursor.getString(cursor.getColumnIndex(SQLUbicacion.UBICACION_DEPARTAMENTO)));
                ubicacion.setVARDIS(cursor.getString(cursor.getColumnIndex(SQLUbicacion.UBICACION_DISTRITO)));
                ubicacion.setVARPRO(cursor.getString(cursor.getColumnIndex(SQLUbicacion.UBICACION_PROVINCIA)));
                ubicaciones.add(ubicacion);
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return ubicaciones;
    }
}
