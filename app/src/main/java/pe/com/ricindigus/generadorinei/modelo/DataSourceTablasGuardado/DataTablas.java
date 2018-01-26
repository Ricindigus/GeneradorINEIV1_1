package pe.com.ricindigus.generadorinei.modelo.DataSourceTablasGuardado;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.DBHelperComponente;

/**
 * Created by dmorales on 08/01/2018.
 */

public class DataTablas {
    private Context contexto;
    private SQLiteOpenHelper sqLiteOpenHelper;
    private SQLiteDatabase sqLiteDatabase;

    public DataTablas(Context contexto) {
        this.contexto = contexto;
        sqLiteOpenHelper = new DBHelperTablas(contexto);
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();

    }

    public void open(){
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    }

    public void close(){
        sqLiteOpenHelper.close();
    }


    public String[] getColumnasModulo(int nModulo){
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

    public boolean existenDatos(int nModulo, String idEmpresa){
        boolean encontrado = false;
        String[] columnas = {"ID_EMPRESA"};
        String[] whereArgs = new String[]{idEmpresa};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query("modulo" + nModulo, columnas,SQLConstantesTablas.WHERE_CLAUSE_ID_EMPRESA,whereArgs,null,null,null);
            if(cursor.getCount() == 1) encontrado = true;
        }finally {
            if(cursor != null)cursor.close();
        }
        return encontrado;
    }

    public void insertarValores(int nModulo, ContentValues valores){
        sqLiteDatabase.insert("modulo" + nModulo,null,valores);
    }

    public void actualizarValores(int nModulo, String idempresa, ContentValues valores){
        String[] whereArgs = new String[]{idempresa};
        sqLiteDatabase.update("modulo" + nModulo,valores,SQLConstantesTablas.WHERE_CLAUSE_ID_EMPRESA,whereArgs);
    }

    public String[] getValores(int nModulo, String[] variables, String idEmpresa){
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

    public String getValor(int nModulo, String variable, String idEmpresa){
        String valor = "";
        String[] whereArgs = new String[]{idEmpresa};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query("modulo" + nModulo, new String[]{variable},SQLConstantesTablas.WHERE_CLAUSE_ID_EMPRESA,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                valor = cursor.getString(cursor.getColumnIndex(variable));
            }
        }finally {
            if(cursor != null)cursor.close();
        }
        return valor;
    }

    public String[] getModulo(int nModulo, String idEmpresa){
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
}
