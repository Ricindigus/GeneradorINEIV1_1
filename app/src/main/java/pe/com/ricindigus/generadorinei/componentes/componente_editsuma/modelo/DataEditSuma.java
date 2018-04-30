package pe.com.ricindigus.generadorinei.componentes.componente_editsuma.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.componentes.componente_editsuma.pojos.PEditSuma;
import pe.com.ricindigus.generadorinei.componentes.componente_editsuma.pojos.SPEditSuma;
import pe.com.ricindigus.generadorinei.componentes.componente_edittext.pojos.PEditText;
import pe.com.ricindigus.generadorinei.componentes.componente_edittext.pojos.SPEditText;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.DBHelperComponente;

/**
 * Created by RICARDO on 1/01/2018.
 */

public class DataEditSuma {
    Context contexto;
    SQLiteOpenHelper sqLiteOpenHelper;
    SQLiteDatabase sqLiteDatabase;

    public DataEditSuma(Context contexto) {
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

    public long getNumeroItemsPEditSuma(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, SQLEditSuma.tablaEditSuma);
    }

    public long getNumeroItemsSPEditSuma(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, SQLEditSuma.tablaSPEditSuma);
    }

    public void insertarPEditSuma(PEditSuma pEditSuma){
        ContentValues contentValues = pEditSuma.toValues();
        sqLiteDatabase.insert(SQLEditSuma.tablaEditSuma,null,contentValues);
    }

    public void insertarPEditSumas(ArrayList<PEditSuma> pEditSumas){
        long items = getNumeroItemsPEditSuma();
        if(items == 0){
            for (PEditSuma pEditSuma : pEditSumas) {
                try {
                    insertarPEditSuma(pEditSuma);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public PEditSuma getPEditSuma(String idPEditSuma){
        PEditSuma pEditSuma = new PEditSuma();
        String[] whereArgs = new String[]{idPEditSuma};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLEditSuma.tablaEditSuma,
                    SQLEditSuma.ALL_COLUMNS_EDITSUMA, SQLEditSuma.WHERE_CLAUSE_ID,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                pEditSuma.setID(cursor.getString(cursor.getColumnIndex(SQLEditSuma.EDITSUMA_ID)));
                pEditSuma.setMODULO(cursor.getString(cursor.getColumnIndex(SQLEditSuma.EDITSUMA_MODULO)));
                pEditSuma.setNUMERO(cursor.getString(cursor.getColumnIndex(SQLEditSuma.EDITSUMA_NUMERO)));
                pEditSuma.setPREGUNTA(cursor.getString(cursor.getColumnIndex(SQLEditSuma.EDITSUMA_PREGUNTA)));
                pEditSuma.setCABPREG(cursor.getString(cursor.getColumnIndex(SQLEditSuma.EDITSUMA_CABPREG)));
                pEditSuma.setCABRES(cursor.getString(cursor.getColumnIndex(SQLEditSuma.EDITSUMA_CABRES)));
                pEditSuma.setVALSUMA(cursor.getString(cursor.getColumnIndex(SQLEditSuma.EDITSUMA_VALSUMA)));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return pEditSuma;
    }

    public ArrayList<PEditSuma> getAllPEditSuma(){
        ArrayList<PEditSuma> pEditSumas = new ArrayList<>();
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLEditSuma.tablaEditSuma, null,null,null,null,null,null);
            while(cursor.moveToNext()){
                PEditSuma pEditSuma = new PEditSuma();
                pEditSuma.setID(cursor.getString(cursor.getColumnIndex(SQLEditSuma.EDITSUMA_ID)));
                pEditSuma.setMODULO(cursor.getString(cursor.getColumnIndex(SQLEditSuma.EDITSUMA_MODULO)));
                pEditSuma.setNUMERO(cursor.getString(cursor.getColumnIndex(SQLEditSuma.EDITSUMA_NUMERO)));
                pEditSuma.setPREGUNTA(cursor.getString(cursor.getColumnIndex(SQLEditSuma.EDITSUMA_PREGUNTA)));
                pEditSuma.setCABPREG(cursor.getString(cursor.getColumnIndex(SQLEditSuma.EDITSUMA_CABPREG)));
                pEditSuma.setCABRES(cursor.getString(cursor.getColumnIndex(SQLEditSuma.EDITSUMA_CABRES)));
                pEditSuma.setVALSUMA(cursor.getString(cursor.getColumnIndex(SQLEditSuma.EDITSUMA_VALSUMA)));
                pEditSumas.add(pEditSuma);
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return pEditSumas;
    }
    public void insertarSPEditSuma(SPEditSuma spEditSuma){
        ContentValues contentValues = spEditSuma.toValues();
        sqLiteDatabase.insert(SQLEditSuma.tablaSPEditSuma,null,contentValues);
    }
    public void insertarSPEditSumas(ArrayList<SPEditSuma> spEditSumas){
        long items = getNumeroItemsSPEditSuma();
        if(items == 0){
            for (SPEditSuma spEditSuma : spEditSumas) {
                try {
                    insertarSPEditSuma(spEditSuma);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public ArrayList<SPEditSuma> getSPEditSuma(String idPregunta) {
        ArrayList<SPEditSuma> spEditSumas = new ArrayList<SPEditSuma>();
        String[] whereArgs = new String[]{idPregunta};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLEditSuma.tablaSPEditSuma,
                    SQLEditSuma.ALL_COLUMNS_SPEDITSUMA, SQLEditSuma.WHERE_CLAUSE_ID_PREGUNTA, whereArgs, null, null, null);
            while(cursor.moveToNext()){
                SPEditSuma spEditSuma = new SPEditSuma();
                spEditSuma.setID(cursor.getString(cursor.getColumnIndex(SQLEditSuma.SPEDITSUMA_ID)));
                spEditSuma.setID_PREGUNTA(cursor.getString(cursor.getColumnIndex(SQLEditSuma.SPEDITSUMA_ID_PREGUNTA)));
                spEditSuma.setSUBPREGUNTA(cursor.getString(cursor.getColumnIndex(SQLEditSuma.SPEDITSUMA_SUBPREGUNTA)));
                spEditSuma.setVARIABLE(cursor.getString(cursor.getColumnIndex(SQLEditSuma.SPEDITSUMA_VARIABLE)));
                spEditSuma.setLONGITUD(cursor.getString(cursor.getColumnIndex(SQLEditSuma.SPEDITSUMA_LONGITUD)));
                spEditSumas.add(spEditSuma);
            }
        }finally {
            if(cursor != null) cursor.close();
        }
        return spEditSumas;
    }

    public ArrayList<SPEditSuma> getAllSPEditSumas() {
        ArrayList<SPEditSuma> spEditSumas = new ArrayList<SPEditSuma>();
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLEditSuma.tablaSPEditSuma,
                   null,null,null, null, null, null);
            while(cursor.moveToNext()){
                SPEditSuma spEditSuma = new SPEditSuma();
                spEditSuma.setID(cursor.getString(cursor.getColumnIndex(SQLEditSuma.SPEDITSUMA_ID)));
                spEditSuma.setID_PREGUNTA(cursor.getString(cursor.getColumnIndex(SQLEditSuma.SPEDITSUMA_ID_PREGUNTA)));
                spEditSuma.setSUBPREGUNTA(cursor.getString(cursor.getColumnIndex(SQLEditSuma.SPEDITSUMA_SUBPREGUNTA)));
                spEditSuma.setVARIABLE(cursor.getString(cursor.getColumnIndex(SQLEditSuma.SPEDITSUMA_VARIABLE)));
                spEditSuma.setLONGITUD(cursor.getString(cursor.getColumnIndex(SQLEditSuma.SPEDITSUMA_LONGITUD)));
                spEditSumas.add(spEditSuma);
            }
        }finally {
            if(cursor != null) cursor.close();
        }
        return spEditSumas;
    }
}
