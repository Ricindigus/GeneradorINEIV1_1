package pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.componentes.componente_formulario.SPFormulario;
import pe.com.ricindigus.generadorinei.componentes.componente_formulario.SQLFormulario;
import pe.com.ricindigus.generadorinei.modelo.DataSourceCaptura.SQLConstantes;
import pe.com.ricindigus.generadorinei.pojos.Encuesta;
import pe.com.ricindigus.generadorinei.pojos.Modulo;
import pe.com.ricindigus.generadorinei.pojos.OpcionSpinner;
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

    public long getNumeroItemsOpciones(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, SQLConstantesComponente.tablaPaginas);
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
                pagina.setIDP2(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.PAGINA_IDP2)));
                pagina.setIDP3(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.PAGINA_IDP3)));
                pagina.setIDP4(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.PAGINA_IDP4)));
                pagina.setIDP5(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.PAGINA_IDP5)));
                pagina.setIDP6(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.PAGINA_IDP6)));
                pagina.setIDP7(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.PAGINA_IDP7)));
                pagina.setIDP8(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.PAGINA_IDP8)));
                pagina.setIDP9(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.PAGINA_IDP9)));
                pagina.setIDP10(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.PAGINA_IDP10)));
                pagina.setTIPO1(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.PAGINA_TP1)));
                pagina.setTIPO2(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.PAGINA_TP2)));
                pagina.setTIPO3(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.PAGINA_TP3)));
                pagina.setTIPO4(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.PAGINA_TP4)));
                pagina.setTIPO5(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.PAGINA_TP5)));
                pagina.setTIPO6(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.PAGINA_TP6)));
                pagina.setTIPO7(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.PAGINA_TP7)));
                pagina.setTIPO8(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.PAGINA_TP8)));
                pagina.setTIPO9(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.PAGINA_TP9)));
                pagina.setTIPO10(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.PAGINA_TP10)));
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


    //INICIO OPCIONES
    public void insertarOpcion(OpcionSpinner opcionSpinner){
        ContentValues contentValues = opcionSpinner.toValues();
        sqLiteDatabase.insert(SQLConstantesComponente.tablaOpcionSpinner,null,contentValues);
    }

    public void InsertarOpciones(ArrayList<OpcionSpinner> opcionSpinners){
        long items = getNumeroItemsOpciones();
        if(items == 0){
            for (OpcionSpinner opcionSpinner : opcionSpinners) {
                try {
                    insertarOpcion(opcionSpinner);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }


    public ArrayList<OpcionSpinner> getOpcionesSpinner(String idSpinner) {
        ArrayList<OpcionSpinner> opcionSpinners = new ArrayList<OpcionSpinner>();
        String[] whereArgs = new String[]{idSpinner};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantesComponente.tablaOpcionSpinner,
                    SQLConstantesComponente.ALL_COLUMNS_OPCION_SPINNER, SQLConstantesComponente.WHERE_CLAUSE_ID_VARIABLE, whereArgs, null, null, null);
            while(cursor.moveToNext()){
                OpcionSpinner opcionSpinner = new OpcionSpinner();
                opcionSpinner.setID(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.OPCION_SPINNER_ID)));
                opcionSpinner.setIDVARIABLE(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.OPCION_SPINNER_IDVARIABLE)));
                opcionSpinner.setNOPCION(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.OPCION_SPINNER_NOPCION)));
                opcionSpinner.setOPCION(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.OPCION_SPINNER_OPCION)));
                opcionSpinners.add(opcionSpinner);
            }
        }finally {
            if(cursor != null) cursor.close();
        }
        return opcionSpinners;
    }
}
