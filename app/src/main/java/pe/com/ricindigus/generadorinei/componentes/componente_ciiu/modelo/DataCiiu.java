package pe.com.ricindigus.generadorinei.componentes.componente_ciiu.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.componentes.componente_ciiu.pojos.PCiiu;
import pe.com.ricindigus.generadorinei.componentes.componente_ciiu.pojos.SPCiiu;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.DBHelperComponente;

/**
 * Created by dmorales on 19/04/2018.
 */

public class DataCiiu {
    Context contexto;
    SQLiteOpenHelper sqLiteOpenHelper;
    SQLiteDatabase sqLiteDatabase;

    public DataCiiu(Context contexto) {
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

    public long getNumeroItemsPCiiu(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, SQLCiiu.tablaPCiius);
    }

    public long getNumeroItemsSPCiiu(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, SQLCiiu.tablaSPCiius);
    }

    public void insertarPCiiu(PCiiu PCiiu){
        ContentValues contentValues = PCiiu.toValues();
        sqLiteDatabase.insert(SQLCiiu.tablaPCiius,null,contentValues);
    }
    public void insertarPCiius(ArrayList<PCiiu> pCiius){
        long items = getNumeroItemsPCiiu();
        if(items == 0){
            for (PCiiu pCiiu : pCiius) {
                try {
                    insertarPCiiu(pCiiu);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public PCiiu getPCiiu(String idPCiiu){
        PCiiu pCiiu = new PCiiu();
        String[] whereArgs = new String[]{idPCiiu};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLCiiu.tablaPCiius,
                    SQLCiiu.ALL_COLUMNS_CIIU, SQLCiiu.WHERE_CLAUSE_ID,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                pCiiu.setID(cursor.getString(cursor.getColumnIndex(SQLCiiu.PCIIU_ID)));
                pCiiu.setMODULO(cursor.getString(cursor.getColumnIndex(SQLCiiu.PCIIU_MODULO)));
                pCiiu.setNUMERO(cursor.getString(cursor.getColumnIndex(SQLCiiu.PCIIU_NUMERO)));
                pCiiu.setPREGUNTA(cursor.getString(cursor.getColumnIndex(SQLCiiu.PCIIU_PREGUNTA)));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return pCiiu;
    }

    public ArrayList<PCiiu> getAllPCiiu(){
        ArrayList<PCiiu> pCiius = new ArrayList<>();
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLCiiu.tablaPCiius, null,null,null,null,null,null);
            while(cursor.moveToNext()){
                PCiiu pCiiu = new PCiiu();
                pCiiu.setID(cursor.getString(cursor.getColumnIndex(SQLCiiu.PCIIU_ID)));
                pCiiu.setMODULO(cursor.getString(cursor.getColumnIndex(SQLCiiu.PCIIU_MODULO)));
                pCiiu.setNUMERO(cursor.getString(cursor.getColumnIndex(SQLCiiu.PCIIU_NUMERO)));
                pCiiu.setPREGUNTA(cursor.getString(cursor.getColumnIndex(SQLCiiu.PCIIU_PREGUNTA)));
                pCiius.add(pCiiu);
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return pCiius;
    }
    public void insertarSPCiiu(SPCiiu spCiiu){
        ContentValues contentValues = spCiiu.toValues();
        sqLiteDatabase.insert(SQLCiiu.tablaSPCiius,null,contentValues);
    }
    public void insertarSPCiius(ArrayList<SPCiiu> spCiius){
        long items = getNumeroItemsSPCiiu();
        if(items == 0){
            for (SPCiiu spCiiu : spCiius) {
                try {
                    insertarSPCiiu(spCiiu);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public ArrayList<SPCiiu> getSPCiius(String idPregunta) {
        ArrayList<SPCiiu> spCiius = new ArrayList<SPCiiu>();
        String[] whereArgs = new String[]{idPregunta};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLCiiu.tablaSPCiius,
                    SQLCiiu.ALL_COLUMNS_SPCIIU, SQLCiiu.WHERE_CLAUSE_ID_PREGUNTA, whereArgs, null, null, null);
            while(cursor.moveToNext()){
                SPCiiu spCiiu = new SPCiiu();
                spCiiu.setID(cursor.getString(cursor.getColumnIndex(SQLCiiu.SPCIIU_ID)));
                spCiiu.setID_PREGUNTA(cursor.getString(cursor.getColumnIndex(SQLCiiu.SPCIIU_ID_PREGUNTA)));
                spCiiu.setSUBPREGUNTA(cursor.getString(cursor.getColumnIndex(SQLCiiu.SPCIIU_SUBPREGUNTA)));
                spCiiu.setVARACT(cursor.getString(cursor.getColumnIndex(SQLCiiu.SPCIIU_VARACT)));
                spCiiu.setVARCIIU(cursor.getString(cursor.getColumnIndex(SQLCiiu.SPCIIU_VARCIIU)));
                spCiiu.setVARCK(cursor.getString(cursor.getColumnIndex(SQLCiiu.SPCIIU_VARCK)));
                spCiius.add(spCiiu);
            }
        }finally {
            if(cursor != null) cursor.close();
        }
        return spCiius;
    }

    public ArrayList<SPCiiu> getAllSPCiius() {
        ArrayList<SPCiiu> spCiius = new ArrayList<SPCiiu>();
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLCiiu.tablaSPCiius,
                    null,null,null, null, null, null);
            while(cursor.moveToNext()){
                SPCiiu spCiiu = new SPCiiu();
                spCiiu.setID(cursor.getString(cursor.getColumnIndex(SQLCiiu.SPCIIU_ID)));
                spCiiu.setID_PREGUNTA(cursor.getString(cursor.getColumnIndex(SQLCiiu.SPCIIU_ID_PREGUNTA)));
                spCiiu.setSUBPREGUNTA(cursor.getString(cursor.getColumnIndex(SQLCiiu.SPCIIU_SUBPREGUNTA)));
                spCiiu.setVARACT(cursor.getString(cursor.getColumnIndex(SQLCiiu.SPCIIU_VARACT)));
                spCiiu.setVARCIIU(cursor.getString(cursor.getColumnIndex(SQLCiiu.SPCIIU_VARCIIU)));
                spCiiu.setVARCK(cursor.getString(cursor.getColumnIndex(SQLCiiu.SPCIIU_VARCK)));
                spCiius.add(spCiiu);
            }
        }finally {
            if(cursor != null) cursor.close();
        }
        return spCiius;
    }
}
