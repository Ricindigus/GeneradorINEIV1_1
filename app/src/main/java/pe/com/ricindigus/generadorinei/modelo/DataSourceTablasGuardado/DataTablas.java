package pe.com.ricindigus.generadorinei.modelo.DataSourceTablasGuardado;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.modelo.DataControladorVersiones.DataVersion;
import pe.com.ricindigus.generadorinei.modelo.DataControladorVersiones.SQLVersion;

/**
 * Created by dmorales on 08/01/2018.
 */

public class DataTablas {
    private Context contexto;
    private SQLiteOpenHelper sqLiteOpenHelper;
    private SQLiteDatabase sqLiteDatabase;

    public DataTablas(Context contexto) {
        this.contexto = contexto;
        DataVersion dataVersion = new DataVersion(contexto);
        dataVersion.open();
        int version = Integer.parseInt(dataVersion.getVersion(SQLVersion.VERSION_BD_TABLAS));
        dataVersion.close();
        sqLiteOpenHelper = new DBHelperTablas(contexto,version);
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();

    }

    public void open(){
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    }

    public void close(){
        sqLiteOpenHelper.close();
    }


    public String[] getColumnasModulo(String nModulo){
        String[] columnas = null;
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query("modulo" + nModulo, null,null,null,null,null,null);
        }finally {
            if(cursor != null){
                columnas = cursor.getColumnNames();
                cursor.close();
            }
        }
        return columnas;
    }

    public boolean existenDatos(String nModulo, String idEmpresa){
        boolean encontrado = false;
        String[] columnas = {"ID_EMPRESA"};
        String[] whereArgs = new String[]{idEmpresa};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query("modulo" + nModulo, columnas,SQLConstantesTablas.WHERE_CLAUSE_ID_EMPRESA,whereArgs,null,null,null);
            if(cursor.getCount() > 0) encontrado = true;
        }finally {
            if(cursor != null)cursor.close();
        }
        return encontrado;
    }

    public void deleteDatos(String idTabla, String idEmpresa){
        String[] whereArgs = new String[]{idEmpresa};
        sqLiteDatabase.delete("modulo" + idTabla,SQLConstantesTablas.WHERE_CLAUSE_ID_EMPRESA,whereArgs);
    }

    public void deleteDatosxId(String idTabla, String id){
        String[] whereArgs = new String[]{id};
        sqLiteDatabase.delete("modulo" + idTabla,SQLConstantesTablas.WHERE_CLAUSE_id,whereArgs);
    }



    public void insertarValores(String idTabla, ContentValues valores){
        sqLiteDatabase.insert("modulo" + idTabla,null,valores);
    }

    public void actualizarValores(String nModulo, String idempresa, ContentValues valores){
        String[] whereArgs = new String[]{idempresa};
        sqLiteDatabase.update("modulo" + nModulo,valores,SQLConstantesTablas.WHERE_CLAUSE_ID_EMPRESA,whereArgs);
    }

    public String[] getValores(String nModulo, String[] variables, String idEmpresa){
        String[] valores = new String[variables.length];
        String[] whereArgs = new String[]{idEmpresa};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query("modulo" + nModulo, variables,SQLConstantesTablas.WHERE_CLAUSE_ID_EMPRESA,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                for (int i = 0; i < variables.length; i++) {
                    valores[i] = cursor.getString(cursor.getColumnIndex(variables[i]));
                }
            }
        }finally {
            if(cursor != null)cursor.close();
        }
        return valores;
    }

    public String getValor(String idTabla, String variable, String idEmpresa){
        String valor = "";
        String[] whereArgs = new String[]{idEmpresa};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query("modulo" + idTabla, new String[]{variable},SQLConstantesTablas.WHERE_CLAUSE_ID_EMPRESA,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                valor = cursor.getString(cursor.getColumnIndex(variable));
            }
        }finally {
            if(cursor != null)cursor.close();
        }
        if(valor == null) valor = "";
        return valor;
    }

    public String getValorxId(String nModulo, String variable, String id){
        String valor = "";
        String[] whereArgs = new String[]{id};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query("modulo" + nModulo, new String[]{variable},SQLConstantesTablas.WHERE_CLAUSE_id,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                valor = cursor.getString(cursor.getColumnIndex(variable));
            }
        }finally {
            if(cursor != null)cursor.close();
        }
        if(valor == null) valor = "";
        return valor;
    }

    public String[] getModulo(String nModulo, String idEmpresa){
        String[] columnas = getColumnasModulo(nModulo);
        String[] valoresModulo = new String[columnas.length];
        String[] whereArgs = new String[]{idEmpresa};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query("modulo" + nModulo, columnas,SQLConstantesTablas.WHERE_CLAUSE_ID_EMPRESA,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                for (int i = 0; i < columnas.length; i++) {
                    valoresModulo[i] = cursor.getString(cursor.getColumnIndex(columnas[i]));
                }
            }
        }finally {
            if(cursor != null)cursor.close();
        }
        return valoresModulo;
    }


    public Cursor getAllTabla(String tabla){
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * from " + tabla, null);
        if (cursor != null) cursor.moveToFirst();
        return cursor;
    }

    public void deleteTabla(String tabla){
        sqLiteDatabase.execSQL("DROP TABLE " + tabla);
    }

    public Cursor getVisitas(String nModulo, String idEmpresa){
        String[] whereArgs = new String[]{idEmpresa};
        Cursor cursor = null;
        cursor = sqLiteDatabase.query("modulo" + nModulo,null, SQLConstantesTablas.WHERE_CLAUSE_ID_EMPRESA,whereArgs,null,null,null);
        if(cursor != null) cursor.moveToFirst();
        return cursor;
    }

    public ArrayList<String> getFilas(String idTabla,String idEmpresa){
        ArrayList<String> filas = new ArrayList<String>();
        String[] whereArgs = new String[]{idEmpresa};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query("modulo" + idTabla,null, SQLConstantesTablas.WHERE_CLAUSE_ID_EMPRESA,whereArgs,null,null,null);
            while(cursor.moveToNext()){
                String idFila = cursor.getString(cursor.getColumnIndex("_id"));
                filas.add(idFila);
            }
        }finally {
            if(cursor != null) cursor.close();
        }
        return filas;
    }

    public void actualizarVisita(String nModulo, String id, ContentValues valores){
        String[] whereArgs = new String[]{id};
        sqLiteDatabase.update("modulo" + nModulo,valores,SQLConstantesTablas.WHERE_CLAUSE_id,whereArgs);
    }

    public void deleteVisita(String nModulo, String id){
        String[] whereArgs = new String[]{String.valueOf(id)};
        sqLiteDatabase.delete("modulo" + nModulo,SQLConstantesTablas.WHERE_CLAUSE_id,whereArgs);
    }

    public String[] getNombreColumnas(String idModulo, String idEmpresa){
        Cursor cursor = null;
        String[] columnNames = null;
        String[] whereArgs = new String[]{idEmpresa};
        try{cursor = sqLiteDatabase.query("modulo" + idModulo, null, SQLConstantesTablas.WHERE_CLAUSE_ID_EMPRESA,whereArgs, null, null, null);
        }finally {
            if(cursor != null) {
                cursor.moveToFirst();
                columnNames = cursor.getColumnNames();
                cursor.close();
            }
        }
        return columnNames;
    }


}
