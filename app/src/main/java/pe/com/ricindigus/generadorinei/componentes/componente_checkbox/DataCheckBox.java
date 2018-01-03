package pe.com.ricindigus.generadorinei.componentes.componente_checkbox;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

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

    public long getNumeroItemsPOJOCheckBox(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, SQLCheckBox.tablaCheckBox);
    }
    public long getNumeroItemsSPCheckBox(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, SQLCheckBox.tablaSPCheckBox);
    }

    //INICIO CHECKBOX
    public void insertarPOJOCheckBox(POJOCheckBox POJOCheckBox){
        ContentValues contentValues = POJOCheckBox.toValues();
        sqLiteDatabase.insert(SQLCheckBox.tablaCheckBox,null,contentValues);
    }
    public void insertarPOJOCheckBoxs(ArrayList<POJOCheckBox> POJOCheckBoxes){
        long items = getNumeroItemsPOJOCheckBox();
        if(items == 0){
            for (POJOCheckBox POJOCheckBox : POJOCheckBoxes) {
                try {
                    insertarPOJOCheckBox(POJOCheckBox);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public POJOCheckBox getPOJOCheckbox(String idCCheckbox){
        POJOCheckBox POJOCheckBox = new POJOCheckBox();
        String[] whereArgs = new String[]{idCCheckbox};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLCheckBox.tablaCheckBox,
                    SQLCheckBox.ALL_COLUMNS_CHECKBOX, SQLCheckBox.WHERE_CLAUSE_ID,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                POJOCheckBox.setID(cursor.getString(cursor.getColumnIndex(SQLCheckBox.CHECKBOX_ID)));
                POJOCheckBox.setMODULO(cursor.getString(cursor.getColumnIndex(SQLCheckBox.CHECKBOX_MODULO)));
                POJOCheckBox.setNUMERO(cursor.getString(cursor.getColumnIndex(SQLCheckBox.CHECKBOX_NUMERO)));
                POJOCheckBox.setPREGUNTA(cursor.getString(cursor.getColumnIndex(SQLCheckBox.CHECKBOX_PREGUNTA )));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return POJOCheckBox;
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
                spCheckBoxs.add(spCheckBox);
            }
        }finally {
            if(cursor != null) cursor.close();
        }
        return spCheckBoxs;
    }

}
