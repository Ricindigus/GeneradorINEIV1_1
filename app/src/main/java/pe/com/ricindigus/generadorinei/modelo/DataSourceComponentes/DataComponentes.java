package pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.componentes.componente_checkbox.CCheckBox;
import pe.com.ricindigus.generadorinei.modelo.DataSourceCaptura.SQLConstantes;
import pe.com.ricindigus.generadorinei.componentes.componente_edittext.CEditText;
import pe.com.ricindigus.generadorinei.pojos.Encuesta;
import pe.com.ricindigus.generadorinei.pojos.Modulo;
import pe.com.ricindigus.generadorinei.pojos.Pagina;

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
    public long getNumeroItemsModulos(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, SQLConstantesComponente.tablaModulos);
    }
    public long getNumeroItemsPaginas(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, SQLConstantesComponente.tablaPaginas);
    }
    public long getNumeroItemsCEditText(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, SQLConstantesComponente.tablaEditText);
    }
    public long getNumeroItemsCCheckBox(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, SQLConstantesComponente.tablaCheckBox);
    }


    //INICIO ENCUESTA
    public void insertarEncuesta(Encuesta encuesta){
        ContentValues contentValues = encuesta.toValues();
        sqLiteDatabase.insert(SQLConstantesComponente.tablaEncuestas,null,contentValues);
    }

    public void InsertarEncuestas(ArrayList<Encuesta> encuestas){
        long items = getNumeroItemsEncuesta();
        if(items == 0){
            for (Encuesta encuesta : encuestas) {
                try {
                    insertarEncuesta(encuesta);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
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
                encuesta.setID(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.ENCUESTA_ID)));
                encuesta.setTITULO(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.ENCUESTA_TITULO)));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return encuesta;
    }
    //FIN ENCUESTA


    //INICIO PAGINAS
    public void insertarPagina(Pagina pagina){
        ContentValues contentValues = pagina.toValues();
        sqLiteDatabase.insert(SQLConstantesComponente.tablaPaginas,null,contentValues);
    }
    public void insertarPaginas(ArrayList<Pagina> paginas){
        long items = getNumeroItemsPaginas();
        if(items == 0){
            for (Pagina pagina : paginas) {
                try {
                    insertarPagina(pagina);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public Pagina getPagina(String idPagina){
        Pagina pagina = new Pagina();
        String[] whereArgs = new String[]{idPagina};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantesComponente.tablaPaginas,
                    SQLConstantesComponente.ALL_COLUMNS_PAGINAS,SQLConstantes.WHERE_CLAUSE_ID,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                pagina.setID(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.PAGINA_ID)));
                pagina.setMODULO(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.PAGINA_MODULO)));
                pagina.setIDP1(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.PAGINA_IDP1)));
                pagina.setTIPO1(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.PAGINA_TP1)));
                pagina.setIDP2(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.PAGINA_IDP2)));
                pagina.setTIPO2(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.PAGINA_TP2)));
                pagina.setIDP3(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.PAGINA_IDP3)));
                pagina.setTIPO3(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.PAGINA_TP3)));
                pagina.setIDP4(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.PAGINA_IDP4)));
                pagina.setTIPO4(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.PAGINA_TP4)));
                pagina.setIDP5(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.PAGINA_IDP5)));
                pagina.setTIPO5(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.PAGINA_TP5)));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return pagina;
    }
    //FIN PAGINAS


    //INICIO MODULOS
    public void insertarModulo(Modulo modulo){
        ContentValues contentValues = modulo.toValues();
        sqLiteDatabase.insert(SQLConstantesComponente.tablaModulos,null,contentValues);
    }

    public void insertarModulos(ArrayList<Modulo> modulos){
        long items = getNumeroItemsModulos();
        if(items == 0){
            for (Modulo modulo : modulos) {
                try {
                    insertarModulo(modulo);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public Modulo getModulo(String idModulo){
        Modulo modulo = new Modulo();
        String[] whereArgs = new String[]{idModulo};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantesComponente.tablaModulos,
                    SQLConstantesComponente.ALL_COLUMNS_MODULOS,SQLConstantesComponente.WHERE_CLAUSE_ID,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                modulo.setID(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.MODULO_ID)));
                modulo.setTITULO(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.MODULO_TITULO)));
            }
        }finally {
            if(cursor != null) cursor.close();
        }
        return modulo;
    }
    //FIN MODULOS

    //INICIO EDITTEXT
    public void insertarCEditText(CEditText cEditText){
        ContentValues contentValues = cEditText.toValues();
        sqLiteDatabase.insert(SQLConstantesComponente.tablaEditText,null,contentValues);
    }
    public void insertarCEditTexts(ArrayList<CEditText> editTexts){
        long items = getNumeroItemsCEditText();
        if(items == 0){
            for (CEditText cEditText : editTexts) {
                try {
                    insertarCEditText(cEditText);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public CEditText getCEditText(String idCEditText){
        CEditText cEditText = new CEditText();
        String[] whereArgs = new String[]{idCEditText};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantesComponente.tablaEditText,
                    SQLConstantesComponente.ALL_COLUMNS_EDITTEXT,SQLConstantes.WHERE_CLAUSE_ID,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                cEditText.setID(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.EDITTEXT_ID)));
                cEditText.setMODULO(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.EDITTEXT_MODULO)));
                cEditText.setNUMERO(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.EDITTEXT_NUMERO)));
                cEditText.setPREGUNTA(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.EDITTEXT_PREGUNTA)));
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
    //FIN EDITTEXT

    //INICIO CHECKBOX
    public void insertarCCheckBox(CCheckBox cCheckBox){
        ContentValues contentValues = cCheckBox.toValues();
        sqLiteDatabase.insert(SQLConstantesComponente.tablaCheckBox,null,contentValues);
    }
    public void insertarCCheckBoxs(ArrayList<CCheckBox> cCheckBoxes){
        long items = getNumeroItemsCCheckBox();
        if(items == 0){
            for (CCheckBox cCheckBox : cCheckBoxes) {
                try {
                    insertarCCheckBox(cCheckBox);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public CCheckBox getCCheckbox(String idCCheckbox){
        CCheckBox cCheckBox = new CCheckBox();
        String[] whereArgs = new String[]{idCCheckbox};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantesComponente.tablaCheckBox,
                    SQLConstantesComponente.ALL_COLUMNS_CHECKBOX,SQLConstantes.WHERE_CLAUSE_ID,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                cCheckBox.setID(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.CHECKBOX_ID)));
                cCheckBox.setMODULO(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.CHECKBOX_MODULO)));
                cCheckBox.setNUMERO(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.CHECKBOX_NUMERO)));
                cCheckBox.setPREGUNTA(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.CHECKBOX_PREGUNTA )));
                cCheckBox.setSP1(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.CHECKBOX_SP1 )));
                cCheckBox.setSP2(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.CHECKBOX_SP2 )));
                cCheckBox.setSP3(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.CHECKBOX_SP3 )));
                cCheckBox.setSP4(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.CHECKBOX_SP4 )));
                cCheckBox.setSP5(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.CHECKBOX_SP5 )));
                cCheckBox.setSP6(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.CHECKBOX_SP6 )));
                cCheckBox.setSP7(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.CHECKBOX_SP7 )));
                cCheckBox.setSP8(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.CHECKBOX_SP8 )));
                cCheckBox.setSP9(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.CHECKBOX_SP9 )));
                cCheckBox.setSP10(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.CHECKBOX_SP10 )));
                cCheckBox.setSP11(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.CHECKBOX_SP11 )));
                cCheckBox.setSP12(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.CHECKBOX_SP12 )));
                cCheckBox.setSP13(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.CHECKBOX_SP13 )));
                cCheckBox.setSP14(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.CHECKBOX_SP14 )));
                cCheckBox.setSP15(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.CHECKBOX_SP15 )));
                cCheckBox.setSP16(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.CHECKBOX_SP16 )));
                cCheckBox.setSP17(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.CHECKBOX_SP17 )));
                cCheckBox.setSP18(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.CHECKBOX_SP18 )));
                cCheckBox.setSP19(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.CHECKBOX_SP19 )));
                cCheckBox.setVAR1(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.CHECKBOX_VAR1 )));
                cCheckBox.setVAR2(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.CHECKBOX_VAR2 )));
                cCheckBox.setVAR3(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.CHECKBOX_VAR3 )));
                cCheckBox.setVAR4(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.CHECKBOX_VAR4 )));
                cCheckBox.setVAR5(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.CHECKBOX_VAR5 )));
                cCheckBox.setVAR6(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.CHECKBOX_VAR6 )));
                cCheckBox.setVAR7(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.CHECKBOX_VAR7 )));
                cCheckBox.setVAR8(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.CHECKBOX_VAR8)));
                cCheckBox.setVAR9(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.CHECKBOX_VAR9 )));
                cCheckBox.setVAR10(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.CHECKBOX_VAR10 )));
                cCheckBox.setVAR11(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.CHECKBOX_VAR11 )));
                cCheckBox.setVAR12(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.CHECKBOX_VAR12 )));
                cCheckBox.setVAR13(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.CHECKBOX_VAR13 )));
                cCheckBox.setVAR14(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.CHECKBOX_VAR14 )));
                cCheckBox.setVAR15(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.CHECKBOX_VAR15 )));
                cCheckBox.setVAR16(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.CHECKBOX_VAR16 )));
                cCheckBox.setVAR17(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.CHECKBOX_VAR17 )));
                cCheckBox.setVAR18(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.CHECKBOX_VAR18 )));
                cCheckBox.setVAR19(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.CHECKBOX_VAR19 )));
                cCheckBox.setVARESP(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.CHECKBOX_VARESP )));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return cCheckBox;
    }
    //FIN CHECKBOX
}
