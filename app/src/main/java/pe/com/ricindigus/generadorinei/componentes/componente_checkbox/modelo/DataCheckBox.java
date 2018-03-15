package pe.com.ricindigus.generadorinei.componentes.componente_checkbox.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.componentes.componente_checkbox.pojos.PCheckBox;
import pe.com.ricindigus.generadorinei.componentes.componente_checkbox.pojos.SPCheckBox;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.DBHelperComponente;


/**
 * Created by RICARDO on 1/01/2018.
 */

public class DataCheckBox {
    Context contexto;
    SQLiteOpenHelper sqLiteOpenHelper;
    SQLiteDatabase sqLiteDatabase;

    public DataCheckBox(Context contexto) {
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

    public long getNumeroItemsPCheckBox(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, SQLCheckBox.tablaCheckBox);
    }
    public long getNumeroItemsSPCheckBox(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, SQLCheckBox.tablaSPCheckBox);
    }

    //INICIO CHECKBOX
    public void insertarPCheckBox(PCheckBox PCheckBox){
        ContentValues contentValues = PCheckBox.toValues();
        sqLiteDatabase.insert(SQLCheckBox.tablaCheckBox,null,contentValues);
    }
    public void insertarPCheckBoxs(ArrayList<PCheckBox> PCheckBoxes){
        long items = getNumeroItemsPCheckBox();
        if(items == 0){
            for (PCheckBox PCheckBox : PCheckBoxes) {
                try {
                    insertarPCheckBox(PCheckBox);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public PCheckBox getPCheckbox(String idCCheckbox){
        PCheckBox PCheckBox = new PCheckBox();
        String[] whereArgs = new String[]{idCCheckbox};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLCheckBox.tablaCheckBox,
                    SQLCheckBox.ALL_COLUMNS_CHECKBOX, SQLCheckBox.WHERE_CLAUSE_ID,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                PCheckBox.setID(cursor.getString(cursor.getColumnIndex(SQLCheckBox.CHECKBOX_ID)));
                PCheckBox.setMODULO(cursor.getString(cursor.getColumnIndex(SQLCheckBox.CHECKBOX_MODULO)));
                PCheckBox.setNUMERO(cursor.getString(cursor.getColumnIndex(SQLCheckBox.CHECKBOX_NUMERO)));
                PCheckBox.setPREGUNTA(cursor.getString(cursor.getColumnIndex(SQLCheckBox.CHECKBOX_PREGUNTA )));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return PCheckBox;
    }

    public ArrayList<PCheckBox> getAllPCheckbox(){
        ArrayList<PCheckBox> pCheckBoxes = new ArrayList<PCheckBox>();
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLCheckBox.tablaCheckBox,
                    null,null,null,null,null,null);
            if(cursor.moveToNext()){
                PCheckBox pCheckBox = new PCheckBox();
                pCheckBox.setID(cursor.getString(cursor.getColumnIndex(SQLCheckBox.CHECKBOX_ID)));
                pCheckBox.setMODULO(cursor.getString(cursor.getColumnIndex(SQLCheckBox.CHECKBOX_MODULO)));
                pCheckBox.setNUMERO(cursor.getString(cursor.getColumnIndex(SQLCheckBox.CHECKBOX_NUMERO)));
                pCheckBox.setPREGUNTA(cursor.getString(cursor.getColumnIndex(SQLCheckBox.CHECKBOX_PREGUNTA )));
                pCheckBoxes.add(pCheckBox);
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return pCheckBoxes;
    }
    //FIN CHECKBOX

    public void insertarSPCheckBox(SPCheckBox spCheckBox){
        ContentValues contentValues = spCheckBox.toValues();
        sqLiteDatabase.insert(SQLCheckBox.tablaSPCheckBox,null,contentValues);
    }
    public void insertarSPCheckBoxs(ArrayList<SPCheckBox> spCheckBoxs){
        long items = getNumeroItemsSPCheckBox();
        if(items == 0){
            for (SPCheckBox spCheckBox : spCheckBoxs) {
                try {
                    insertarSPCheckBox(spCheckBox);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public ArrayList<SPCheckBox> getSPCheckBoxs(String idPregunta) {
        ArrayList<SPCheckBox> spCheckBoxs = new ArrayList<SPCheckBox>();
        String[] whereArgs = new String[]{idPregunta};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLCheckBox.tablaSPCheckBox,
                    SQLCheckBox.ALL_COLUMNS_SPCHECKBOX, SQLCheckBox.WHERE_CLAUSE_ID_PREGUNTA, whereArgs, null, null, null);
            while(cursor.moveToNext()){
                SPCheckBox spCheckBox = new SPCheckBox();
                spCheckBox.setID(cursor.getString(cursor.getColumnIndex(SQLCheckBox.SPCHECKBOX_ID)));
                spCheckBox.setID_PREGUNTA(cursor.getString(cursor.getColumnIndex(SQLCheckBox.SPCHECKBOX_ID_PREGUNTA)));
                spCheckBox.setSUBPREGUNTA(cursor.getString(cursor.getColumnIndex(SQLCheckBox.SPCHECKBOX_SUBPREGUNTA)));
                spCheckBox.setVARIABLE(cursor.getString(cursor.getColumnIndex(SQLCheckBox.SPCHECKBOX_VARIABLE)));
                spCheckBox.setVARDESC(cursor.getString(cursor.getColumnIndex(SQLCheckBox.SPCHECKBOX_VARDESC)));
                spCheckBox.setDESHAB(cursor.getString(cursor.getColumnIndex(SQLCheckBox.SPCHECKBOX_DESHAB)));
                spCheckBoxs.add(spCheckBox);
            }
        }finally {
            if(cursor != null) cursor.close();
        }
        return spCheckBoxs;
    }


    public ArrayList<SPCheckBox> getAllSPCheckBoxs() {
        ArrayList<SPCheckBox> spCheckBoxs = new ArrayList<SPCheckBox>();
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLCheckBox.tablaSPCheckBox,
                    null,null,null, null, null, null);
            while(cursor.moveToNext()){
                SPCheckBox spCheckBox = new SPCheckBox();
                spCheckBox.setID(cursor.getString(cursor.getColumnIndex(SQLCheckBox.SPCHECKBOX_ID)));
                spCheckBox.setID_PREGUNTA(cursor.getString(cursor.getColumnIndex(SQLCheckBox.SPCHECKBOX_ID_PREGUNTA)));
                spCheckBox.setSUBPREGUNTA(cursor.getString(cursor.getColumnIndex(SQLCheckBox.SPCHECKBOX_SUBPREGUNTA)));
                spCheckBox.setVARIABLE(cursor.getString(cursor.getColumnIndex(SQLCheckBox.SPCHECKBOX_VARIABLE)));
                spCheckBox.setVARDESC(cursor.getString(cursor.getColumnIndex(SQLCheckBox.SPCHECKBOX_VARDESC)));
                spCheckBox.setDESHAB(cursor.getString(cursor.getColumnIndex(SQLCheckBox.SPCHECKBOX_DESHAB)));
                spCheckBoxs.add(spCheckBox);
            }
        }finally {
            if(cursor != null) cursor.close();
        }
        return spCheckBoxs;
    }

}
