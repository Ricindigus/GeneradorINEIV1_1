package pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.modelo.DataSourceCaptura.SQLConstantes;
import pe.com.ricindigus.generadorinei.modelo.DataSourceTablasGuardado.SQLConstantesTablas;
import pe.com.ricindigus.generadorinei.pojos.Encuesta;
import pe.com.ricindigus.generadorinei.pojos.Evento;
import pe.com.ricindigus.generadorinei.pojos.InfoTabla;
import pe.com.ricindigus.generadorinei.pojos.Modulo;
import pe.com.ricindigus.generadorinei.pojos.OpcionSpinner;
import pe.com.ricindigus.generadorinei.pojos.Pagina;
import pe.com.ricindigus.generadorinei.pojos.Variable;

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

    public long getNumeroItemsEventos(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, SQLConstantesComponente.tablaEventos);
    }


    public String[] getNombreColumnasTabla(String nombreTabla){
        Cursor cursor = null;
        String[] columnNames = null;
        try{cursor = sqLiteDatabase.query(nombreTabla, null, null,null, null, null, null);
        }finally {
            if(cursor != null) {
                cursor.moveToFirst();
                columnNames = cursor.getColumnNames();
                cursor.close();
            }
        }
        return columnNames;
    }


    public String getValorFromTabla(String nombreTabla, String variable, String id){
        String valor = "";
        String[] whereArgs = new String[]{id};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(nombreTabla, new String[]{variable},SQLConstantesComponente.WHERE_CLAUSE_ID,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                valor = cursor.getString(cursor.getColumnIndex(variable));
            }
        }finally {
            if(cursor != null)cursor.close();
        }
        if(valor == null) valor = "";
        return valor;
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

    public ArrayList<Encuesta> getEncuestas(){
        ArrayList<Encuesta> encuestas = new ArrayList<>();
        String[] whereArgs = new String[]{"1"};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantesComponente.tablaEncuestas,
                    null,null,null,null,null,null);
            while(cursor.moveToNext()){
                Encuesta encuesta = new Encuesta();
                encuesta.setID(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.ENCUESTA_ID)));
                encuesta.setTITULO(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.ENCUESTA_TITULO)));
                encuestas.add(encuesta);
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return encuestas;
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

    public ArrayList<Pagina> getAllPaginas(){
        ArrayList<Pagina> paginas = new ArrayList<>();
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantesComponente.tablaPaginas,
                    null,null,null,null,null,null);
            while (cursor.moveToNext()){
                Pagina pagina = new Pagina();
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
                paginas.add(pagina);
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return paginas;
    }

    public ArrayList<Pagina> getPaginasxModulo(String idModulo){
        ArrayList<Pagina> paginas =  new ArrayList<Pagina>();
        String[] whereArgs = new String[]{idModulo};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantesComponente.tablaPaginas,
                    SQLConstantesComponente.ALL_COLUMNS_PAGINAS,SQLConstantesComponente.WHERE_CLAUSE_MODULO_PAGINA,whereArgs,null,null,null);
            while(cursor.moveToNext()){
                Pagina pagina = new Pagina();
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
                paginas.add(pagina);
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return paginas;
    }
    public ArrayList<String> getIdsPagina(String idPagina){
        ArrayList<String> pags = new ArrayList<String>();
        String[] whereArgs = new String[]{idPagina};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantesComponente.tablaPaginas,
                    SQLConstantesComponente.ALL_COLUMNS_PAGINAS,SQLConstantes.WHERE_CLAUSE_ID,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                String paginas[] = {
                        cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.PAGINA_IDP1)),
                        cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.PAGINA_IDP2)),
                        cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.PAGINA_IDP3)),
                        cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.PAGINA_IDP4)),
                        cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.PAGINA_IDP5)),
                        cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.PAGINA_IDP6)),
                        cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.PAGINA_IDP7)),
                        cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.PAGINA_IDP8)),
                        cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.PAGINA_IDP9)),
                        cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.PAGINA_IDP10))
                };
                for (int i = 0; i < paginas.length; i++) if(!paginas[i].equals("")) pags.add(paginas[i]);
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return pags;
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
                modulo.setCABECERA(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.MODULO_CABECERA)));
                modulo.setNTABLA(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.MODULO_NTABLA)));
            }
        }finally {
            if(cursor != null) cursor.close();
        }
        return modulo;
    }

    public ArrayList<Modulo> getAllModulos(){
        ArrayList<Modulo> modulos = new ArrayList<Modulo>();
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantesComponente.tablaModulos,
                    SQLConstantesComponente.ALL_COLUMNS_MODULOS,null,null,null,null,null);
            while(cursor.moveToNext()){
                Modulo modulo = new Modulo();
                modulo.setID(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.MODULO_ID)));
                modulo.setTITULO(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.MODULO_TITULO)));
                modulo.setCABECERA(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.MODULO_CABECERA)));
                modulo.setNTABLA(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.MODULO_NTABLA)));

                modulos.add(modulo);
            }
        }finally {
            if(cursor != null) cursor.close();
        }
        return modulos;
    }

    public Cursor getCursorModulos(){
        Cursor cursor = null;
        cursor = sqLiteDatabase.query(SQLConstantesComponente.tablaModulos,
                    SQLConstantesComponente.ALL_COLUMNS_MODULOS,null,null,null,null,null);
        if(cursor != null) cursor.moveToFirst();
        return cursor;
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


    public ArrayList<String> getOpcionesSpinner(String idVarSpinner) {
        ArrayList<String> opcionSpinners = new ArrayList<String>();
        opcionSpinners.add("SELECCIONE...");
        String[] whereArgs = new String[]{idVarSpinner};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantesComponente.tablaOpcionSpinner,
                    SQLConstantesComponente.ALL_COLUMNS_OPCION_SPINNER, SQLConstantesComponente.WHERE_CLAUSE_ID_VARIABLE, whereArgs, null, null, null);
            while(cursor.moveToNext()){
                String opcionSpinner = "";
                opcionSpinner = opcionSpinner + cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.OPCION_SPINNER_NDATO)) + "."
                + cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.OPCION_SPINNER_DATO));
                opcionSpinners.add(opcionSpinner);
            }
        }finally {
            if(cursor != null) cursor.close();
        }
        return opcionSpinners;
    }


    public ArrayList<OpcionSpinner> getAllOpcionesSpinner() {
        ArrayList<OpcionSpinner> opcionSpinners = new ArrayList<OpcionSpinner>();
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantesComponente.tablaOpcionSpinner, null,null,null, null, null, null);
            while(cursor.moveToNext()){
                OpcionSpinner opcionSpinner = new OpcionSpinner();
                opcionSpinner.setID(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.OPCION_SPINNER_ID)));
                opcionSpinner.setIDVARIABLE(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.OPCION_SPINNER_IDVARIABLE)));
                opcionSpinner.setNDATO(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.OPCION_SPINNER_NDATO)));
                opcionSpinner.setDATO(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.OPCION_SPINNER_DATO)));
                opcionSpinners.add(opcionSpinner);
            }
        }finally {
            if(cursor != null) cursor.close();
        }
        return opcionSpinners;
    }

    //FIN OPCIONES

    //INICIO EVENTOS
    public void insertarEvento(Evento evento){
        ContentValues contentValues = evento.toValues();
        sqLiteDatabase.insert(SQLConstantesComponente.tablaEventos,null,contentValues);
    }

    public void InsertarEventos(ArrayList<Evento> eventos){
        long items = getNumeroItemsEventos();
        if(items == 0){
            for (Evento evento : eventos) {
                try {
                    insertarEvento(evento);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }



    public ArrayList<Evento> getEventos(String idPagina) {
        ArrayList<Evento> eventos = new ArrayList<Evento>();
        String[] whereArgs = new String[]{idPagina};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantesComponente.tablaEventos, SQLConstantesComponente.ALL_COLUMNS_EVENTOS,
                    SQLConstantesComponente.WHERE_CLAUSE_IDPAGB, whereArgs, null, null, null);
            while(cursor.moveToNext()){
                Evento evento = new Evento();
                evento.setID(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.EVENTO_ID)));
                evento.setVAR(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.EVENTO_VAR)));
                evento.setVAL(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.EVENTO_VAL)));
                evento.setIDPREGA(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.EVENTO_IDPREGA)));
                evento.setIDPREGB(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.EVENTO_IDPREGB)));
                evento.setIDPAGA(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.EVENTO_IDPAGA)));
                evento.setIDPAGB(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.EVENTO_IDPAGB)));
                evento.setACCION(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.EVENTO_ACCION)));
                eventos.add(evento);
            }
        }finally {
            if(cursor != null) cursor.close();
        }
        return eventos;
    }

    public ArrayList<Evento> getAllEventos() {
        ArrayList<Evento> eventos = new ArrayList<Evento>();
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantesComponente.tablaEventos, null,null,null, null, null, null);
            while(cursor.moveToNext()){
                Evento evento = new Evento();
                evento.setID(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.EVENTO_ID)));
                evento.setVAR(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.EVENTO_VAR)));
                evento.setVAL(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.EVENTO_VAL)));
                evento.setIDPREGA(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.EVENTO_IDPREGA)));
                evento.setIDPREGB(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.EVENTO_IDPREGB)));
                evento.setIDPAGA(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.EVENTO_IDPAGA)));
                evento.setIDPAGB(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.EVENTO_IDPAGB)));
                evento.setACCION(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.EVENTO_ACCION)));
                eventos.add(evento);
            }
        }finally {
            if(cursor != null) cursor.close();
        }
        return eventos;
    }

    public ArrayList<Evento> getEventosInhabilitar(String idPagina) {
        ArrayList<Evento> eventos = new ArrayList<Evento>();
        String[] whereArgs = new String[]{idPagina};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantesComponente.tablaEventos, SQLConstantesComponente.ALL_COLUMNS_EVENTOS,
                    SQLConstantesComponente.WHERE_CLAUSE_IDPAGB, whereArgs, null, null, null);
            while(cursor.moveToNext()){
                if(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.EVENTO_ACCION)).equals("0")){
                    Evento evento = new Evento();
                    evento.setID(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.EVENTO_ID)));
                    evento.setVAR(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.EVENTO_VAR)));
                    evento.setVAL(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.EVENTO_VAL)));
                    evento.setIDPREGA(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.EVENTO_IDPREGA)));
                    evento.setIDPREGB(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.EVENTO_IDPREGB)));
                    evento.setIDPAGA(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.EVENTO_IDPAGA)));
                    evento.setIDPAGB(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.EVENTO_IDPAGB)));
                    evento.setACCION(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.EVENTO_ACCION)));
                    eventos.add(evento);
                }
            }
        }finally {
            if(cursor != null) cursor.close();
        }
        return eventos;
    }

    public ArrayList<Evento> getEventos(String variable, String valor) {
        ArrayList<Evento> eventos = new ArrayList<Evento>();
        String[] whereArgs = new String[]{variable, valor};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantesComponente.tablaEventos,
                    SQLConstantesComponente.ALL_COLUMNS_EVENTOS, SQLConstantesComponente.WHERE_CLAUSE_VAR + " AND " + SQLConstantesComponente.WHERE_CLAUSE_VAL
                    , whereArgs, null, null, null);
            while(cursor.moveToNext()){
                Evento evento = new Evento();
                evento.setID(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.EVENTO_ID)));
                evento.setVAR(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.EVENTO_VAR)));
                evento.setVAL(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.EVENTO_VAL)));
                evento.setIDPREGA(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.EVENTO_IDPREGA)));
                evento.setIDPREGB(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.EVENTO_IDPREGB)));
                evento.setIDPAGA(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.EVENTO_IDPAGA)));
                evento.setIDPAGB(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.EVENTO_IDPAGB)));
                evento.setACCION(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.EVENTO_ACCION)));

                eventos.add(evento);
            }
        }finally {
            if(cursor != null) cursor.close();
        }
        return eventos;
    }

    public boolean existeEvento(String variable){
        boolean encontrado = false;
        String[] whereArgs = new String[]{variable};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantesComponente.tablaEventos,
                    SQLConstantesComponente.ALL_COLUMNS_EVENTOS, SQLConstantesComponente.WHERE_CLAUSE_VAR
                    , whereArgs, null, null, null);
            if(cursor.getCount() > 0) encontrado = true;
        }finally {
            if(cursor != null)cursor.close();
        }
        return encontrado;
    }
    //FIN EVENTOS



    public void insertarVariable(Variable variable){
        ContentValues contentValues = variable.toValues();
        sqLiteDatabase.insert(SQLConstantesComponente.tablaVariables,null,contentValues);
    }

    public ArrayList<Variable> getVariablesxPregunta(String idPregunta) {
        ArrayList<Variable> variables = new ArrayList<Variable>();
        String[] whereArgs = new String[]{idPregunta};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantesComponente.tablaVariables, SQLConstantesComponente.ALL_COLUMNS_VARIABLES,
                    SQLConstantesComponente.WHERE_CLAUSE_PREGUNTA, whereArgs, null, null, null);
            while(cursor.moveToNext()){
                Variable variable = new Variable();
                variable.setID(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.VARIABLE_ID)));
                variable.setTABLA(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.VARIABLE_TABLA)));
                variable.setPREGUNTA(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.VARIABLE_PREGUNTA)));
                variable.setPAGINA(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.VARIABLE_PAGINA)));
                variable.setMODULO(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.VARIABLE_MODULO)));
                variables.add(variable);
            }
        }finally {
            if(cursor != null) cursor.close();
        }
        return variables;
    }

    public ArrayList<Variable> getVariablesxTabla(String idTabla) {
        ArrayList<Variable> variables = new ArrayList<Variable>();
        String[] whereArgs = new String[]{idTabla};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantesComponente.tablaVariables, SQLConstantesComponente.ALL_COLUMNS_VARIABLES,
                    SQLConstantesComponente.WHERE_CLAUSE_TABLA, whereArgs, null, null, null);
            while(cursor.moveToNext()){
                Variable variable = new Variable();
                variable.setID(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.VARIABLE_ID)));
                variable.setTABLA(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.VARIABLE_TABLA)));
                variable.setPREGUNTA(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.VARIABLE_PREGUNTA)));
                variable.setPAGINA(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.VARIABLE_PAGINA)));
                variable.setMODULO(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.VARIABLE_MODULO)));
                variables.add(variable);
            }
        }finally {
            if(cursor != null) cursor.close();
        }
        return variables;
    }

    public ArrayList<Variable> getVariablesxPagina(String idPagina) {
        ArrayList<Variable> variables = new ArrayList<Variable>();
        String[] whereArgs = new String[]{idPagina};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantesComponente.tablaVariables, SQLConstantesComponente.ALL_COLUMNS_VARIABLES,
                    SQLConstantesComponente.WHERE_CLAUSE_PAGINA, whereArgs, null, null, null);
            while(cursor.moveToNext()){
                Variable variable = new Variable();
                variable.setID(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.VARIABLE_ID)));
                variable.setTABLA(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.VARIABLE_TABLA)));
                variable.setPREGUNTA(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.VARIABLE_PREGUNTA)));
                variable.setPAGINA(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.VARIABLE_PAGINA)));
                variable.setMODULO(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.VARIABLE_MODULO)));
                variables.add(variable);
            }
        }finally {
            if(cursor != null) cursor.close();
        }
        return variables;
    }

    public ArrayList<Variable> getAllVariables() {
        ArrayList<Variable> variables = new ArrayList<Variable>();
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantesComponente.tablaVariables, null,null,null, null, null, null);
            while(cursor.moveToNext()){
                Variable variable = new Variable();
                variable.setID(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.VARIABLE_ID)));
                variable.setTABLA(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.VARIABLE_TABLA)));
                variable.setPREGUNTA(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.VARIABLE_PREGUNTA)));
                variable.setPAGINA(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.VARIABLE_PAGINA)));
                variable.setMODULO(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.VARIABLE_MODULO)));
                variables.add(variable);
            }
        }finally {
            if(cursor != null) cursor.close();
        }
        return variables;
    }

    public void insertarInfoTablas(InfoTabla infoTabla){
        ContentValues contentValues = infoTabla.toValues();
        sqLiteDatabase.insert(SQLConstantesComponente.tablaInfoTablas,null,contentValues);
    }


    public InfoTabla getInfoTablas(String idTabla) {
        InfoTabla infoTabla = new InfoTabla();
        String[] whereArgs = new String[]{idTabla};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantesComponente.tablaInfoTablas, SQLConstantesComponente.ALL_COLUMNS_INFOTABLAS,
                    SQLConstantesComponente.WHERE_CLAUSE_ID,whereArgs, null, null, null);
            if(cursor.getCount() == 1){
                infoTabla.setID(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.INFOTABLAS_ID)));
                infoTabla.setMODULO(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.INFOTABLAS_MODULO)));
                infoTabla.setNOMBRE(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.INFOTABLAS_NOMBRE)));
                infoTabla.setPARTE(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.INFOTABLAS_PARTE)));
                infoTabla.setTIPO(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.INFOTABLAS_TIPO)));
            }
        }finally {
            if(cursor != null) cursor.close();
        }
        return infoTabla;
    }

    public InfoTabla getInfoTablaxNombre(String nombreTabla){
        InfoTabla infoTabla = new InfoTabla();
        String[] whereArgs = new String[]{nombreTabla};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantesComponente.tablaInfoTablas,
                    SQLConstantesComponente.ALL_COLUMNS_INFOTABLAS,SQLConstantes.WHERE_CLAUSE_TABLA_NOMBRE,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                infoTabla.setID(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.INFOTABLAS_ID)));
                infoTabla.setMODULO(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.INFOTABLAS_MODULO)));
                infoTabla.setNOMBRE(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.INFOTABLAS_NOMBRE)));
                infoTabla.setPARTE(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.INFOTABLAS_PARTE)));
                infoTabla.setTIPO(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.INFOTABLAS_TIPO)));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return infoTabla;
    }



    public InfoTabla getInfoTablaxModulo(String idModulo){
        InfoTabla infoTabla = new InfoTabla();
        String[] whereArgs = new String[]{idModulo};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantesComponente.tablaInfoTablas,
                    SQLConstantesComponente.ALL_COLUMNS_INFOTABLAS,SQLConstantesComponente.WHERE_CLAUSE_MODULO,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                infoTabla.setID(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.INFOTABLAS_ID)));
                infoTabla.setMODULO(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.INFOTABLAS_MODULO)));
                infoTabla.setNOMBRE(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.INFOTABLAS_NOMBRE)));
                infoTabla.setPARTE(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.INFOTABLAS_PARTE)));
                infoTabla.setTIPO(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.INFOTABLAS_TIPO)));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return infoTabla;
    }


        public ArrayList<InfoTabla> getAllInfoTablas() {
        ArrayList<InfoTabla> infoTablas = new ArrayList<InfoTabla>();
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantesComponente.tablaInfoTablas, null,null,null, null, null, null);
            while(cursor.moveToNext()){
                InfoTabla infoTabla = new InfoTabla();
                infoTabla.setID(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.INFOTABLAS_ID)));
                infoTabla.setMODULO(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.INFOTABLAS_MODULO)));
                infoTabla.setNOMBRE(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.INFOTABLAS_NOMBRE)));
                infoTabla.setPARTE(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.INFOTABLAS_PARTE)));
                infoTabla.setTIPO(cursor.getString(cursor.getColumnIndex(SQLConstantesComponente.INFOTABLAS_TIPO)));
                infoTablas.add(infoTabla);
            }
        }finally {
            if(cursor != null) cursor.close();
        }
        return infoTablas;
    }


    public void deleteAllElementosFromTabla(String nombreTabla){
        sqLiteDatabase.execSQL("delete from "+ nombreTabla);
    }

}
