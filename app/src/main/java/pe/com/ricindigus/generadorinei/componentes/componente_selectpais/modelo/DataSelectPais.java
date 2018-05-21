package pe.com.ricindigus.generadorinei.componentes.componente_selectpais.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


import pe.com.ricindigus.generadorinei.componentes.componente_selectpais.pojos.PSelectPais;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.DBHelperComponente;

public class DataSelectPais {
    Context contexto;
    SQLiteOpenHelper sqLiteOpenHelper;
    SQLiteDatabase sqLiteDatabase;

    public DataSelectPais(Context contexto) {
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

    public long getNumeroItemsPSelectPais(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, SQLSelectPais.tablaSelectPais);
    }

    public void insertarPSelectPais(PSelectPais pSelectPais){
        ContentValues contentValues = pSelectPais.toValues();
        sqLiteDatabase.insert(SQLSelectPais.tablaSelectPais,null,contentValues);
    }

    public PSelectPais getPSelectPais(String idPOJOSelectPais){
        PSelectPais pSelectPais = new PSelectPais();
        String[] whereArgs = new String[]{idPOJOSelectPais};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLSelectPais.tablaSelectPais,
                    SQLSelectPais.ALL_COLUMNS_SELECTPAIS, SQLSelectPais.WHERE_CLAUSE_ID,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                pSelectPais.setID(cursor.getString(cursor.getColumnIndex(SQLSelectPais.SELECTPAIS_ID)));
                pSelectPais.setMODULO(cursor.getString(cursor.getColumnIndex(SQLSelectPais.SELECTPAIS_MODULO)));
                pSelectPais.setNUMERO(cursor.getString(cursor.getColumnIndex(SQLSelectPais.SELECTPAIS_NUMERO)));
                pSelectPais.setPREGUNTA(cursor.getString(cursor.getColumnIndex(SQLSelectPais.SELECTPAIS_PREGUNTA)));
                pSelectPais.setVARPAIS(cursor.getString(cursor.getColumnIndex(SQLSelectPais.SELECTPAIS_VARPAIS)));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return pSelectPais;
    }

    public ArrayList<PSelectPais> getAllPSelectPais(){
        ArrayList<PSelectPais> pSelectPaiss = new ArrayList<>();
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLSelectPais.tablaSelectPais, null,null,null,null,null,null);
            while(cursor.moveToNext()){
                PSelectPais pSelectPais = new PSelectPais();
                pSelectPais.setID(cursor.getString(cursor.getColumnIndex(SQLSelectPais.SELECTPAIS_ID)));
                pSelectPais.setMODULO(cursor.getString(cursor.getColumnIndex(SQLSelectPais.SELECTPAIS_MODULO)));
                pSelectPais.setNUMERO(cursor.getString(cursor.getColumnIndex(SQLSelectPais.SELECTPAIS_NUMERO)));
                pSelectPais.setPREGUNTA(cursor.getString(cursor.getColumnIndex(SQLSelectPais.SELECTPAIS_PREGUNTA)));
                pSelectPais.setPREGUNTA(cursor.getString(cursor.getColumnIndex(SQLSelectPais.SELECTPAIS_VARPAIS)));
                pSelectPaiss.add(pSelectPais);
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return pSelectPaiss;
    }





}
