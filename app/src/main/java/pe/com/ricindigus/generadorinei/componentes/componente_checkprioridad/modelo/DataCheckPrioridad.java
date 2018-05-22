package pe.com.ricindigus.generadorinei.componentes.componente_checkprioridad.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.componentes.componente_checkprioridad.pojos.PCheckPrioridad;
import pe.com.ricindigus.generadorinei.componentes.componente_checkprioridad.pojos.SPCheckPrioridad;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.DBHelperComponente;

/**
 * Created by RICARDO on 1/01/2018.
 */

public class DataCheckPrioridad {
    Context contexto;
    SQLiteOpenHelper sqLiteOpenHelper;
    SQLiteDatabase sqLiteDatabase;

    public DataCheckPrioridad(Context contexto) {
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

    public long getNumeroItemsPCheckPrioridad(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, SQLCheckPrioridad.tablaCheckPrioridad);
    }

    public long getNumeroItemsSPCheckPrioridad(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, SQLCheckPrioridad.tablaSPCheckPrioridad);
    }

    public void insertarPCheckPrioridad(PCheckPrioridad pEditSuma){
        ContentValues contentValues = pEditSuma.toValues();
        sqLiteDatabase.insert(SQLCheckPrioridad.tablaCheckPrioridad,null,contentValues);
    }

    public void insertarPCheckPrioridads(ArrayList<PCheckPrioridad> pEditSumas){
        long items = getNumeroItemsPCheckPrioridad();
        if(items == 0){
            for (PCheckPrioridad pEditSuma : pEditSumas) {
                try {
                    insertarPCheckPrioridad(pEditSuma);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public PCheckPrioridad getPCheckPrioridad(String idPCheckPrioridad){
        PCheckPrioridad pEditSuma = new PCheckPrioridad();
        String[] whereArgs = new String[]{idPCheckPrioridad};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLCheckPrioridad.tablaCheckPrioridad,
                    SQLCheckPrioridad.ALL_COLUMNS_CHECKPRIORIDAD, SQLCheckPrioridad.WHERE_CLAUSE_ID,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                pEditSuma.setID(cursor.getString(cursor.getColumnIndex(SQLCheckPrioridad.CHECKPRIORIDAD_ID)));
                pEditSuma.setMODULO(cursor.getString(cursor.getColumnIndex(SQLCheckPrioridad.CHECKPRIORIDAD_MODULO)));
                pEditSuma.setNUMERO(cursor.getString(cursor.getColumnIndex(SQLCheckPrioridad.CHECKPRIORIDAD_NUMERO)));
                pEditSuma.setPREGUNTA(cursor.getString(cursor.getColumnIndex(SQLCheckPrioridad.CHECKPRIORIDAD_PREGUNTA)));
                pEditSuma.setCAB1(cursor.getString(cursor.getColumnIndex(SQLCheckPrioridad.CHECKPRIORIDAD_CAB1)));
                pEditSuma.setCAB2(cursor.getString(cursor.getColumnIndex(SQLCheckPrioridad.CHECKPRIORIDAD_CAB2)));
                pEditSuma.setPRIORIDAD(cursor.getString(cursor.getColumnIndex(SQLCheckPrioridad.CHECKPRIORIDAD_PRIORIDAD)));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return pEditSuma;
    }

    public ArrayList<PCheckPrioridad> getAllPCheckPrioridad(){
        ArrayList<PCheckPrioridad> pEditSumas = new ArrayList<>();
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLCheckPrioridad.tablaCheckPrioridad, null,null,null,null,null,null);
            while(cursor.moveToNext()){
                PCheckPrioridad pEditSuma = new PCheckPrioridad();
                pEditSuma.setID(cursor.getString(cursor.getColumnIndex(SQLCheckPrioridad.CHECKPRIORIDAD_ID)));
                pEditSuma.setMODULO(cursor.getString(cursor.getColumnIndex(SQLCheckPrioridad.CHECKPRIORIDAD_MODULO)));
                pEditSuma.setNUMERO(cursor.getString(cursor.getColumnIndex(SQLCheckPrioridad.CHECKPRIORIDAD_NUMERO)));
                pEditSuma.setPREGUNTA(cursor.getString(cursor.getColumnIndex(SQLCheckPrioridad.CHECKPRIORIDAD_PREGUNTA)));
                pEditSuma.setCAB1(cursor.getString(cursor.getColumnIndex(SQLCheckPrioridad.CHECKPRIORIDAD_CAB1)));
                pEditSuma.setCAB2(cursor.getString(cursor.getColumnIndex(SQLCheckPrioridad.CHECKPRIORIDAD_CAB2)));
                pEditSuma.setPRIORIDAD(cursor.getString(cursor.getColumnIndex(SQLCheckPrioridad.CHECKPRIORIDAD_PRIORIDAD)));
                pEditSumas.add(pEditSuma);
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return pEditSumas;
    }
    public void insertarSPCheckPrioridad(SPCheckPrioridad spCheckPrioridad){
        ContentValues contentValues = spCheckPrioridad.toValues();
        sqLiteDatabase.insert(SQLCheckPrioridad.tablaSPCheckPrioridad,null,contentValues);
    }
    public void insertarSPCheckPrioridads(ArrayList<SPCheckPrioridad> spEditSumas){
        long items = getNumeroItemsSPCheckPrioridad();
        if(items == 0){
            for (SPCheckPrioridad spEditSuma : spEditSumas) {
                try {
                    insertarSPCheckPrioridad(spEditSuma);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public ArrayList<SPCheckPrioridad> getSPCheckPrioridad(String idPregunta) {
        ArrayList<SPCheckPrioridad> spCheckPrioridads = new ArrayList<SPCheckPrioridad>();
        String[] whereArgs = new String[]{idPregunta};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLCheckPrioridad.tablaSPCheckPrioridad,
                    SQLCheckPrioridad.ALL_COLUMNS_SPCHECKPRIORIDAD, SQLCheckPrioridad.WHERE_CLAUSE_ID_PREGUNTA, whereArgs, null, null, null);
            while(cursor.moveToNext()){
                SPCheckPrioridad spCheckPrioridad = new SPCheckPrioridad();
                spCheckPrioridad.setID(cursor.getString(cursor.getColumnIndex(SQLCheckPrioridad.SPCHECKPRIORIDAD_ID)));
                spCheckPrioridad.setID_PREGUNTA(cursor.getString(cursor.getColumnIndex(SQLCheckPrioridad.SPCHECKPRIORIDAD_ID_PREGUNTA)));
                spCheckPrioridad.setSUBPREGUNTA(cursor.getString(cursor.getColumnIndex(SQLCheckPrioridad.SPCHECKPRIORIDAD_SUBPREGUNTA)));
                spCheckPrioridad.setVARCK(cursor.getString(cursor.getColumnIndex(SQLCheckPrioridad.SPCHECKPRIORIDAD_VARCK)));
                spCheckPrioridad.setVARESP(cursor.getString(cursor.getColumnIndex(SQLCheckPrioridad.SPCHECKPRIORIDAD_VARESP)));
                spCheckPrioridad.setVARSP(cursor.getString(cursor.getColumnIndex(SQLCheckPrioridad.SPCHECKPRIORIDAD_VARSP)));
                spCheckPrioridad.setDESHAB(cursor.getString(cursor.getColumnIndex(SQLCheckPrioridad.SPCHECKPRIORIDAD_DESHAB)));
                spCheckPrioridads.add(spCheckPrioridad);
            }
        }finally {
            if(cursor != null) cursor.close();
        }
        return spCheckPrioridads;
    }

    public ArrayList<SPCheckPrioridad> getAllSPCheckPrioridads() {
        ArrayList<SPCheckPrioridad> spEditSumas = new ArrayList<SPCheckPrioridad>();
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLCheckPrioridad.tablaSPCheckPrioridad,
                   null,null,null, null, null, null);
            while(cursor.moveToNext()){
                SPCheckPrioridad spEditSuma = new SPCheckPrioridad();
                spEditSuma.setID(cursor.getString(cursor.getColumnIndex(SQLCheckPrioridad.SPCHECKPRIORIDAD_ID)));
                spEditSuma.setID_PREGUNTA(cursor.getString(cursor.getColumnIndex(SQLCheckPrioridad.SPCHECKPRIORIDAD_ID_PREGUNTA)));
                spEditSuma.setSUBPREGUNTA(cursor.getString(cursor.getColumnIndex(SQLCheckPrioridad.SPCHECKPRIORIDAD_SUBPREGUNTA)));
                spEditSuma.setVARCK(cursor.getString(cursor.getColumnIndex(SQLCheckPrioridad.SPCHECKPRIORIDAD_VARCK)));
                spEditSuma.setVARESP(cursor.getString(cursor.getColumnIndex(SQLCheckPrioridad.SPCHECKPRIORIDAD_VARESP)));
                spEditSuma.setVARSP(cursor.getString(cursor.getColumnIndex(SQLCheckPrioridad.SPCHECKPRIORIDAD_VARSP)));
                spEditSuma.setDESHAB(cursor.getString(cursor.getColumnIndex(SQLCheckPrioridad.SPCHECKPRIORIDAD_DESHAB)));
                spEditSumas.add(spEditSuma);
            }
        }finally {
            if(cursor != null) cursor.close();
        }
        return spEditSumas;
    }
}
