package pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

import pe.com.ricindigus.generadorinei.modelo.DataSourceCaptura.DBHelper;
import pe.com.ricindigus.generadorinei.modelo.DataSourceCaptura.SQLConstantes;
import pe.com.ricindigus.generadorinei.pojos.CEditText;
import pe.com.ricindigus.generadorinei.pojos.Encuesta;
import pe.com.ricindigus.generadorinei.pojos.Marco;
import pe.com.ricindigus.generadorinei.pojos.Pregunta;

/**
 * Created by dmorales on 13/12/2017.
 */

public class DataComponentes {
    Context contexto;
    SQLiteOpenHelper sqLiteOpenHelper;
    SQLiteDatabase sqLiteDatabase;

    public DataComponentes(Context contexto) {
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

    public long getNumeroItemsEncuesta(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, SQLConstantesComponente.tablaEncuestas);
    }
    public long getNumeroItemsPreguntas(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, SQLConstantesComponente.tablaPreguntas);
    }
    public long getNumeroItemsEditText(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, SQLConstantesComponente.tablaEditText);
    }

    public Encuesta getEncuesta(){
        Encuesta encuesta = new Encuesta();
        String[] whereArgs = new String[]{"1"};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantesComponente.tablaEncuestas,
                    SQLConstantesComponente.ALL_COLUMNS_ENCUESTA,SQLConstantes.WHERE_CLAUSE_ID,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                encuesta.setID(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.ID_ENCUESTA)));
                encuesta.setTITULO(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.TITULO_ENCUESTA)));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return encuesta;
    }

    public void insertarEncuesta(Encuesta encuesta){
        ContentValues contentValues = encuesta.toValues();
        sqLiteDatabase.insert(SQLConstantesComponente.tablaEncuestas,null,contentValues);
    }

    public Pregunta getPregunta(String idPregunta){
        Pregunta pregunta = new Pregunta();
        String[] whereArgs = new String[]{idPregunta};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantesComponente.tablaPreguntas,
                    SQLConstantesComponente.ALL_COLUMNS_PREGUNTAS,SQLConstantes.WHERE_CLAUSE_ID,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                pregunta.setID(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.ID_PREGUNTA)));
                pregunta.setPREGUNTA(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.TEXTO_PREGUNTA)));
                pregunta.setTIPO(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.TIPO_PREGUNTA)));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return pregunta;
    }

    public void insertarPregunta(Pregunta pregunta){
        ContentValues contentValues = pregunta.toValues();
        sqLiteDatabase.insert(SQLConstantesComponente.tablaPreguntas,null,contentValues);
    }

    public CEditText getEditText(String idEditText){
        CEditText cEditText = new CEditText();
        String[] whereArgs = new String[]{idEditText};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantesComponente.tablaEditText,
                    SQLConstantesComponente.ALL_COLUMNS_EDITTEXT,SQLConstantes.WHERE_CLAUSE_ID,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                cEditText.setID(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.EDITTEXT_ID)));
                cEditText.setSP1(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.EDITTEXT_SP1)));
                cEditText.setSP2(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.EDITTEXT_SP2)));
                cEditText.setSP3(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.EDITTEXT_SP3)));
                cEditText.setVAR1(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.EDITTEXT_VAR1)));
                cEditText.setVAR2(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.EDITTEXT_VAR2)));
                cEditText.setVAR3(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.EDITTEXT_VAR3)));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return cEditText;
    }

    public void insertarEditText(CEditText cEditText){
        ContentValues contentValues = cEditText.toValues();
        sqLiteDatabase.insert(SQLConstantesComponente.tablaEditText,null,contentValues);
    }

}
