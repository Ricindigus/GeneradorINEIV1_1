package pe.com.ricindigus.generadorinei.componentes.componente_formulario;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.componentes.componente_edittext.modelo.SQLEditText;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.DBHelperComponente;

/**
 * Created by dmorales on 30/01/2018.
 */

public class DataFormulario {
    Context contexto;
    SQLiteOpenHelper sqLiteOpenHelper;
    SQLiteDatabase sqLiteDatabase;

    public DataFormulario(Context contexto) {
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

    public long getNumeroItemsFormulario(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, SQLFormulario.tablaFormulario);
    }

    public long getNumeroItemsSPFormulario(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, SQLFormulario.tablaSPFormulario);
    }

    public void insertarFormulario(Formulario formulario){
        ContentValues contentValues = formulario.toValues();
        sqLiteDatabase.insert(SQLFormulario.tablaFormulario,null,contentValues);
    }
    public void insertarFomrularios(ArrayList<Formulario> formularios){
        long items = getNumeroItemsFormulario();
        if(items == 0){
            for (Formulario formulario : formularios) {
                try {
                    insertarFormulario(formulario);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public Formulario getFormulario(String idFormulario){
        Formulario formulario = new Formulario();
        String[] whereArgs = new String[]{idFormulario};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLFormulario.tablaFormulario,
                    SQLFormulario.ALL_COLUMNS_FORMULARIO, SQLEditText.WHERE_CLAUSE_ID,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                formulario.setID(cursor.getString(cursor.getColumnIndex(SQLFormulario.FORMULARIO_ID)));
                formulario.setMODULO(cursor.getString(cursor.getColumnIndex(SQLFormulario.FORMULARIO_MODULO)));
                formulario.setNUMERO(cursor.getString(cursor.getColumnIndex(SQLFormulario.FORMULARIO_NUMERO)));
                formulario.setTITULO(cursor.getString(cursor.getColumnIndex(SQLFormulario.FORMULARIO_TITULO)));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return formulario;
    }

    public void insertarSPFormulario(SPFormulario spFormulario){
        ContentValues contentValues = spFormulario.toValues();
        sqLiteDatabase.insert(SQLFormulario.tablaSPFormulario,null,contentValues);
    }
    public void insertarSPFormularios(ArrayList<SPFormulario> spFormularios){
        long items = getNumeroItemsSPFormulario();
        if(items == 0){
            for (SPFormulario spFormulario : spFormularios) {
                try {
                    insertarSPFormulario(spFormulario);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public ArrayList<SPFormulario> getSPFormularios(String idPregunta) {
        ArrayList<SPFormulario> spFormularios = new ArrayList<SPFormulario>();
        String[] whereArgs = new String[]{idPregunta};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLFormulario.tablaSPFormulario,
                    SQLFormulario.ALL_COLUMNS_SP_FORMULARIO, SQLFormulario.WHERE_CLAUSE_ID_PREGUNTA, whereArgs, null, null, null);
            while(cursor.moveToNext()){
                SPFormulario spFormulario = new SPFormulario();
                spFormulario.setID(cursor.getString(cursor.getColumnIndex(SQLFormulario.SP_FORMU_ID)));
                spFormulario.setID_PREGUNTA(cursor.getString(cursor.getColumnIndex(SQLFormulario.SP_FORMU_IDPREGUNTA)));
                spFormulario.setSUBPREGUNTA(cursor.getString(cursor.getColumnIndex(SQLFormulario.SP_FORMU_SUBPREGUNTA)));
                spFormulario.setVARE(cursor.getString(cursor.getColumnIndex(SQLFormulario.SP_FORMU_VARE)));
                spFormulario.setLONG(cursor.getString(cursor.getColumnIndex(SQLFormulario.SP_FORMU_LONG)));
                spFormulario.setTIPO(cursor.getString(cursor.getColumnIndex(SQLFormulario.SP_FORMU_TIPO)));
                spFormulario.setVARS(cursor.getString(cursor.getColumnIndex(SQLFormulario.SP_FORMU_VARS)));
                spFormulario.setVARESP(cursor.getString(cursor.getColumnIndex(SQLFormulario.SP_FORMU_VARESP)));
                spFormularios.add(spFormulario);
            }
        }finally {
            if(cursor != null) cursor.close();
        }
        return spFormularios;
    }
}
