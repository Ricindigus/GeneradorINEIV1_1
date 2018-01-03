package pe.com.ricindigus.generadorinei.componentes.componente_radio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.componentes.componente_checkbox.SPCheckBox;
import pe.com.ricindigus.generadorinei.componentes.componente_checkbox.SQLCheckBox;
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

    public long getNumeroItemsPOJORadio(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, SQLRadio.tablaRadio);
    }

    public long getNumeroItemsSPRadio(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, SQLRadio.tablaSPRadio);
    }

    //INICIO RADIO
    public void insertarPOJORadio(POJORadio POJORadio){
        ContentValues contentValues = POJORadio.toValues();
        sqLiteDatabase.insert(SQLRadio.tablaRadio,null,contentValues);
    }
    public void insertarPOJORadios(ArrayList<POJORadio> POJORadios){
        long items = getNumeroItemsPOJORadio();
        if(items == 0){
            for (POJORadio POJORadio : POJORadios) {
                try {
                    insertarPOJORadio(POJORadio);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public POJORadio getPOJORadio(String idCRadio){
        POJORadio POJORadio = new POJORadio();
        String[] whereArgs = new String[]{idCRadio};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLRadio.tablaRadio,
                    SQLRadio.ALL_COLUMNS_RADIO, SQLRadio.WHERE_CLAUSE_ID,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                POJORadio.setID(cursor.getString(cursor.getColumnIndex(SQLRadio.RADIO_ID )));
                POJORadio.setMODULO(cursor.getString(cursor.getColumnIndex(SQLRadio.RADIO_MODULO)));
                POJORadio.setNUMERO(cursor.getString(cursor.getColumnIndex(SQLRadio.RADIO_NUMERO )));
                POJORadio.setPREGUNTA(cursor.getString(cursor.getColumnIndex(SQLRadio.RADIO_PREGUNTA )));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return POJORadio;
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
}
