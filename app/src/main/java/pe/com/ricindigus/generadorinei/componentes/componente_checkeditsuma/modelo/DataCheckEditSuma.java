package pe.com.ricindigus.generadorinei.componentes.componente_checkeditsuma.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.componentes.componente_checkeditsuma.pojos.PCheckEditSuma;
import pe.com.ricindigus.generadorinei.componentes.componente_checkeditsuma.pojos.SPCheckEditSuma;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.DBHelperComponente;

/**
 * Created by RICARDO on 1/01/2018.
 */

public class DataCheckEditSuma {
    Context contexto;
    SQLiteOpenHelper sqLiteOpenHelper;
    SQLiteDatabase sqLiteDatabase;

    public DataCheckEditSuma(Context contexto) {
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

    public long getNumeroItemsPCheckEditSuma(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, SQLCheckEditSuma.tablaCheckEditSuma);
    }

    public long getNumeroItemsSPCheckEditSuma(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, SQLCheckEditSuma.tablaSPCheckEditSuma);
    }

    public void insertarPCheckEditSuma(PCheckEditSuma pEditSuma){
        ContentValues contentValues = pEditSuma.toValues();
        sqLiteDatabase.insert(SQLCheckEditSuma.tablaCheckEditSuma,null,contentValues);
    }

    public void insertarPCheckEditSumas(ArrayList<PCheckEditSuma> pEditSumas){
        long items = getNumeroItemsPCheckEditSuma();
        if(items == 0){
            for (PCheckEditSuma pEditSuma : pEditSumas) {
                try {
                    insertarPCheckEditSuma(pEditSuma);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public PCheckEditSuma getPCheckEditSuma(String idPCheckEditSuma){
        PCheckEditSuma pEditSuma = new PCheckEditSuma();
        String[] whereArgs = new String[]{idPCheckEditSuma};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLCheckEditSuma.tablaCheckEditSuma,
                    SQLCheckEditSuma.ALL_COLUMNS_CHECKEDITSUMA, SQLCheckEditSuma.WHERE_CLAUSE_ID,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                pEditSuma.setID(cursor.getString(cursor.getColumnIndex(SQLCheckEditSuma.CHECKEDITSUMA_ID)));
                pEditSuma.setMODULO(cursor.getString(cursor.getColumnIndex(SQLCheckEditSuma.CHECKEDITSUMA_MODULO)));
                pEditSuma.setNUMERO(cursor.getString(cursor.getColumnIndex(SQLCheckEditSuma.CHECKEDITSUMA_NUMERO)));
                pEditSuma.setPREGUNTA(cursor.getString(cursor.getColumnIndex(SQLCheckEditSuma.CHECKEDITSUMA_PREGUNTA)));
                pEditSuma.setCABPREG(cursor.getString(cursor.getColumnIndex(SQLCheckEditSuma.CHECKEDITSUMA_CABPREG)));
                pEditSuma.setCABRES(cursor.getString(cursor.getColumnIndex(SQLCheckEditSuma.CHECKEDITSUMA_CABRES)));
                pEditSuma.setVALSUMA(cursor.getString(cursor.getColumnIndex(SQLCheckEditSuma.CHECKEDITSUMA_VALSUMA)));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return pEditSuma;
    }

    public ArrayList<PCheckEditSuma> getAllPCheckEditSuma(){
        ArrayList<PCheckEditSuma> pEditSumas = new ArrayList<>();
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLCheckEditSuma.tablaCheckEditSuma, null,null,null,null,null,null);
            while(cursor.moveToNext()){
                PCheckEditSuma pEditSuma = new PCheckEditSuma();
                pEditSuma.setID(cursor.getString(cursor.getColumnIndex(SQLCheckEditSuma.CHECKEDITSUMA_ID)));
                pEditSuma.setMODULO(cursor.getString(cursor.getColumnIndex(SQLCheckEditSuma.CHECKEDITSUMA_MODULO)));
                pEditSuma.setNUMERO(cursor.getString(cursor.getColumnIndex(SQLCheckEditSuma.CHECKEDITSUMA_NUMERO)));
                pEditSuma.setPREGUNTA(cursor.getString(cursor.getColumnIndex(SQLCheckEditSuma.CHECKEDITSUMA_PREGUNTA)));
                pEditSuma.setCABPREG(cursor.getString(cursor.getColumnIndex(SQLCheckEditSuma.CHECKEDITSUMA_CABPREG)));
                pEditSuma.setCABRES(cursor.getString(cursor.getColumnIndex(SQLCheckEditSuma.CHECKEDITSUMA_CABRES)));
                pEditSuma.setVALSUMA(cursor.getString(cursor.getColumnIndex(SQLCheckEditSuma.CHECKEDITSUMA_VALSUMA)));
                pEditSumas.add(pEditSuma);
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return pEditSumas;
    }
    public void insertarSPCheckEditSuma(SPCheckEditSuma spCheckEditSuma){
        ContentValues contentValues = spCheckEditSuma.toValues();
        sqLiteDatabase.insert(SQLCheckEditSuma.tablaSPCheckEditSuma,null,contentValues);
    }
    public void insertarSPCheckEditSumas(ArrayList<SPCheckEditSuma> spEditSumas){
        long items = getNumeroItemsSPCheckEditSuma();
        if(items == 0){
            for (SPCheckEditSuma spEditSuma : spEditSumas) {
                try {
                    insertarSPCheckEditSuma(spEditSuma);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public ArrayList<SPCheckEditSuma> getSPCheckEditSuma(String idPregunta) {
        ArrayList<SPCheckEditSuma> spCheckEditSumas = new ArrayList<SPCheckEditSuma>();
        String[] whereArgs = new String[]{idPregunta};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLCheckEditSuma.tablaSPCheckEditSuma,
                    SQLCheckEditSuma.ALL_COLUMNS_SPCHECKEDITSUMA, SQLCheckEditSuma.WHERE_CLAUSE_ID_PREGUNTA, whereArgs, null, null, null);
            while(cursor.moveToNext()){
                SPCheckEditSuma spCheckEditSuma = new SPCheckEditSuma();
                spCheckEditSuma.setID(cursor.getString(cursor.getColumnIndex(SQLCheckEditSuma.SPCHECKEDITSUMA_ID)));
                spCheckEditSuma.setID_PREGUNTA(cursor.getString(cursor.getColumnIndex(SQLCheckEditSuma.SPCHECKEDITSUMA_ID_PREGUNTA)));
                spCheckEditSuma.setSUBPREGUNTA(cursor.getString(cursor.getColumnIndex(SQLCheckEditSuma.SPCHECKEDITSUMA_SUBPREGUNTA)));
                spCheckEditSuma.setVARIABLE(cursor.getString(cursor.getColumnIndex(SQLCheckEditSuma.SPCHECKEDITSUMA_VARIABLE)));
                spCheckEditSuma.setVARESP(cursor.getString(cursor.getColumnIndex(SQLCheckEditSuma.SPCHECKEDITSUMA_VARESP)));
                spCheckEditSuma.setLONGITUD(cursor.getString(cursor.getColumnIndex(SQLCheckEditSuma.SPCHECKEDITSUMA_LONGITUD)));
                spCheckEditSumas.add(spCheckEditSuma);
            }
        }finally {
            if(cursor != null) cursor.close();
        }
        return spCheckEditSumas;
    }

    public ArrayList<SPCheckEditSuma> getAllSPCheckEditSumas() {
        ArrayList<SPCheckEditSuma> spEditSumas = new ArrayList<SPCheckEditSuma>();
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLCheckEditSuma.tablaSPCheckEditSuma,
                   null,null,null, null, null, null);
            while(cursor.moveToNext()){
                SPCheckEditSuma spEditSuma = new SPCheckEditSuma();
                spEditSuma.setID(cursor.getString(cursor.getColumnIndex(SQLCheckEditSuma.SPCHECKEDITSUMA_ID)));
                spEditSuma.setID_PREGUNTA(cursor.getString(cursor.getColumnIndex(SQLCheckEditSuma.SPCHECKEDITSUMA_ID_PREGUNTA)));
                spEditSuma.setSUBPREGUNTA(cursor.getString(cursor.getColumnIndex(SQLCheckEditSuma.SPCHECKEDITSUMA_SUBPREGUNTA)));
                spEditSuma.setVARIABLE(cursor.getString(cursor.getColumnIndex(SQLCheckEditSuma.SPCHECKEDITSUMA_VARIABLE)));
                spEditSuma.setVARESP(cursor.getString(cursor.getColumnIndex(SQLCheckEditSuma.SPCHECKEDITSUMA_VARESP)));
                spEditSuma.setLONGITUD(cursor.getString(cursor.getColumnIndex(SQLCheckEditSuma.SPCHECKEDITSUMA_LONGITUD)));
                spEditSumas.add(spEditSuma);
            }
        }finally {
            if(cursor != null) cursor.close();
        }
        return spEditSumas;
    }
}
