package pe.com.ricindigus.generadorinei.componentes.componente_radio.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.componentes.componente_radio.pojos.PRadio;
import pe.com.ricindigus.generadorinei.componentes.componente_radio.pojos.SPRadio;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.DBHelperComponente;

/**
 * Created by RICARDO on 1/01/2018.
 */

public class DataRadio {
    Context contexto;
    SQLiteOpenHelper sqLiteOpenHelper;
    SQLiteDatabase sqLiteDatabase;

    public DataRadio(Context contexto) {
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

    public long getNumeroItemsPRadio(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, SQLRadio.tablaRadio);
    }

    public long getNumeroItemsSPRadio(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, SQLRadio.tablaSPRadio);
    }

    //INICIO RADIO
    public void insertarPRadio(PRadio PRadio){
        ContentValues contentValues = PRadio.toValues();
        sqLiteDatabase.insert(SQLRadio.tablaRadio,null,contentValues);
    }
    public void insertarPRadios(ArrayList<PRadio> PRadios){
        long items = getNumeroItemsPRadio();
        if(items == 0){
            for (PRadio PRadio : PRadios) {
                try {
                    insertarPRadio(PRadio);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public PRadio getPRadio(String idCRadio){
        PRadio PRadio = new PRadio();
        String[] whereArgs = new String[]{idCRadio};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLRadio.tablaRadio,
                    SQLRadio.ALL_COLUMNS_RADIO, SQLRadio.WHERE_CLAUSE_ID,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                PRadio.setID(cursor.getString(cursor.getColumnIndex(SQLRadio.RADIO_ID )));
                PRadio.setMODULO(cursor.getString(cursor.getColumnIndex(SQLRadio.RADIO_MODULO)));
                PRadio.setNUMERO(cursor.getString(cursor.getColumnIndex(SQLRadio.RADIO_NUMERO )));
                PRadio.setPREGUNTA(cursor.getString(cursor.getColumnIndex(SQLRadio.RADIO_PREGUNTA )));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return PRadio;
    }
    public ArrayList<PRadio> getAllPRadio(){
        ArrayList<PRadio> pRadios = new ArrayList<>();
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLRadio.tablaRadio,
                    null,null,null,null,null,null);
            while(cursor.moveToNext()){
                PRadio pRadio = new PRadio();
                pRadio.setID(cursor.getString(cursor.getColumnIndex(SQLRadio.RADIO_ID )));
                pRadio.setMODULO(cursor.getString(cursor.getColumnIndex(SQLRadio.RADIO_MODULO)));
                pRadio.setNUMERO(cursor.getString(cursor.getColumnIndex(SQLRadio.RADIO_NUMERO )));
                pRadio.setPREGUNTA(cursor.getString(cursor.getColumnIndex(SQLRadio.RADIO_PREGUNTA )));
                pRadios.add(pRadio);
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return pRadios;
    }
    //FIN RADIO

    public void insertarSPRadio(SPRadio spRadio){
        ContentValues contentValues = spRadio.toValues();
        sqLiteDatabase.insert(SQLRadio.tablaSPRadio,null,contentValues);
    }
    public void insertarSPRadios(ArrayList<SPRadio> spRadios){
        long items = getNumeroItemsSPRadio();
        if(items == 0){
            for (SPRadio spRadio : spRadios) {
                try {
                    insertarSPRadio(spRadio);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public ArrayList<SPRadio> getSPRadios(String idPregunta) {
        ArrayList<SPRadio> spRadios = new ArrayList<SPRadio>();
        String[] whereArgs = new String[]{idPregunta};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLRadio.tablaSPRadio,
                    SQLRadio.ALL_COLUMNS_SPRADIO, SQLRadio.WHERE_CLAUSE_ID_PREGUNTA, whereArgs, null, null, null);
            while(cursor.moveToNext()){
                SPRadio spRadio = new SPRadio();
                spRadio.setID(cursor.getString(cursor.getColumnIndex(SQLRadio.SPRADIO_ID)));
                spRadio.setID_PREGUNTA(cursor.getString(cursor.getColumnIndex(SQLRadio.SPRADIO_ID_PREGUNTA)));
                spRadio.setSUBPREGUNTA(cursor.getString(cursor.getColumnIndex(SQLRadio.SPRADIO_SUBPREGUNTA)));
                spRadio.setVARIABLE(cursor.getString(cursor.getColumnIndex(SQLRadio.SPRADIO_VARIABLE)));
                spRadio.setVARDESC(cursor.getString(cursor.getColumnIndex(SQLRadio.SPRADIO_VARDESC)));
                spRadios.add(spRadio);
            }
        }finally {
            if(cursor != null) cursor.close();
        }
        return spRadios;
    }

    public ArrayList<SPRadio> getAllSPRadios() {
        ArrayList<SPRadio> spRadios = new ArrayList<SPRadio>();
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLRadio.tablaSPRadio,
                    null,null,null, null, null, null);
            while(cursor.moveToNext()){
                SPRadio spRadio = new SPRadio();
                spRadio.setID(cursor.getString(cursor.getColumnIndex(SQLRadio.SPRADIO_ID)));
                spRadio.setID_PREGUNTA(cursor.getString(cursor.getColumnIndex(SQLRadio.SPRADIO_ID_PREGUNTA)));
                spRadio.setSUBPREGUNTA(cursor.getString(cursor.getColumnIndex(SQLRadio.SPRADIO_SUBPREGUNTA)));
                spRadio.setVARIABLE(cursor.getString(cursor.getColumnIndex(SQLRadio.SPRADIO_VARIABLE)));
                spRadio.setVARDESC(cursor.getString(cursor.getColumnIndex(SQLRadio.SPRADIO_VARDESC)));
                spRadios.add(spRadio);
            }
        }finally {
            if(cursor != null) cursor.close();
        }
        return spRadios;
    }
}
