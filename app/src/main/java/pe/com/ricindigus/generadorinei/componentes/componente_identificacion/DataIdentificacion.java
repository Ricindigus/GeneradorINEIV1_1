package pe.com.ricindigus.generadorinei.componentes.componente_identificacion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.modelo.DataSourceCaptura.DBHelper;

/**
 * Created by RICARDO on 1/01/2018.
 */

public class DataIdentificacion {
    Context contexto;
    SQLiteOpenHelper sqLiteOpenHelper;
    SQLiteDatabase sqLiteDatabase;

    public DataIdentificacion(Context contexto) {
        this.contexto = contexto;
        sqLiteOpenHelper = new DBHelper(contexto);
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    }

    public void open(){
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    }

    public void close(){
        sqLiteOpenHelper.close();
    }
    
    public long getNumeroItemsIdentificacion(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase,SQLIdentificacion.tableIdentificaciones);
    }

    public void insertarIdentificacion(POJOIdentificacion POJOIdentificacion){
        ContentValues contentValues = POJOIdentificacion.toValues();
        sqLiteDatabase.insert(SQLIdentificacion.tableIdentificaciones,null,contentValues);
    }

    public void InsertarIdentificaciones(ArrayList<POJOIdentificacion> identificaciones){
        long items = getNumeroItemsIdentificacion();
        if(items == 0){
            for (POJOIdentificacion POJOIdentificacion : identificaciones) {
                try {
                    insertarIdentificacion(POJOIdentificacion);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean existeIdentificacion(String idEmpresa){
        boolean encontrado = false;
        String[] whereArgs = new String[]{idEmpresa};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLIdentificacion.tableIdentificaciones,
                    SQLIdentificacion.ALL_COLUMNS_IDENTIFICACIONES,SQLIdentificacion.WHERE_CLAUSE_ID_EMPRESA,whereArgs,null,null,null);
            if(cursor.getCount() == 1) encontrado = true;
        }finally {
            if(cursor != null)cursor.close();
        }
        return encontrado;
    }

    public void actualizarIdentificacion(String idEmpresa, ContentValues contentValues){
        String[] whereArgs = new String[]{idEmpresa};
        sqLiteDatabase.update(SQLIdentificacion.tableIdentificaciones,contentValues,SQLIdentificacion.WHERE_CLAUSE_ID_EMPRESA,whereArgs);
    }

    public POJOIdentificacion getIdentificacion(String idEmpresa){
        POJOIdentificacion POJOIdentificacion = new POJOIdentificacion();
        String[] whereArgs = new String[]{idEmpresa};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLIdentificacion.tableIdentificaciones,
                    SQLIdentificacion.ALL_COLUMNS_IDENTIFICACIONES,SQLIdentificacion.WHERE_CLAUSE_ID_EMPRESA,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                POJOIdentificacion.setID(cursor.getString(cursor.getColumnIndex(SQLIdentificacion.IDENTIFICACION_ID)));
                POJOIdentificacion.setNUM_RUC(cursor.getString(cursor.getColumnIndex(SQLIdentificacion.IDENTIFICACION_RUC)));
                POJOIdentificacion.setRAZON_SOCIAL(cursor.getString(cursor.getColumnIndex(SQLIdentificacion.IDENTIFICACION_RAZON)));
                POJOIdentificacion.setNOM_COMER_COOP(cursor.getString(cursor.getColumnIndex(SQLIdentificacion.IDENTIFICACION_NOMBRE)));
                POJOIdentificacion.setPAG_WEB(cursor.getString(cursor.getColumnIndex(SQLIdentificacion.IDENTIFICACION_WEB)));
                POJOIdentificacion.setPAG_WEB_NO(cursor.getString(cursor.getColumnIndex(SQLIdentificacion.IDENTIFICACION_WEBNO)));
                POJOIdentificacion.setCORREO(cursor.getString(cursor.getColumnIndex(SQLIdentificacion.IDENTIFICACION_CORREO)));
                POJOIdentificacion.setCORREO_NO(cursor.getString(cursor.getColumnIndex(SQLIdentificacion.IDENTIFICACION_CORREONO)));
                POJOIdentificacion.setTEL_FIJO(cursor.getString(cursor.getColumnIndex(SQLIdentificacion.IDENTIFICACION_FIJO)));
                POJOIdentificacion.setTEL_FIJO_NO(cursor.getString(cursor.getColumnIndex(SQLIdentificacion.IDENTIFICACION_FIJONO)));
                POJOIdentificacion.setTEL_MOVIL(cursor.getString(cursor.getColumnIndex(SQLIdentificacion.IDENTIFICACION_MOVIL)));
                POJOIdentificacion.setTEL_MOVIL_NO(cursor.getString(cursor.getColumnIndex(SQLIdentificacion.IDENTIFICACION_MOVILNO)));
                POJOIdentificacion.setANIO_OPERACION(cursor.getString(cursor.getColumnIndex(SQLIdentificacion.IDENTIFICACION_ANIO_FUNCIONAMIENTO)));
                POJOIdentificacion.setNOM_INFORMANTE(cursor.getString(cursor.getColumnIndex(SQLIdentificacion.IDENTIFICACION_CONDUCTOR_NOMBRE)));
                POJOIdentificacion.setSEXO_INFORMANTE(cursor.getString(cursor.getColumnIndex(SQLIdentificacion.IDENTIFICACION_CONDUCTOR_SEXO)));
                POJOIdentificacion.setEDAD_INFORMANTE(cursor.getString(cursor.getColumnIndex(SQLIdentificacion.IDENTIFICACION_CONDUCTOR_EDAD)));
                POJOIdentificacion.setACAD_INFORMANTE(cursor.getString(cursor.getColumnIndex(SQLIdentificacion.IDENTIFICACION_CONDUCTOR_ESTUDIOS)));
                POJOIdentificacion.setCARGO_INFORMANTE(cursor.getString(cursor.getColumnIndex(SQLIdentificacion.IDENTIFICACION_CONDUCTOR_CARGO)));
                POJOIdentificacion.setCARGO_INFORMANTE_ESP(cursor.getString(cursor.getColumnIndex(SQLIdentificacion.IDENTIFICACION_CONDUCTOR_CARGO_ESP)));
            }
        }finally {
            if(cursor != null) cursor.close();
        }
        return POJOIdentificacion;
    }
    public ArrayList<POJOIdentificacion> getAllIdentificaciones(){
        ArrayList<POJOIdentificacion> identificaciones = new ArrayList<POJOIdentificacion>();
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLIdentificacion.tableIdentificaciones,
                    SQLIdentificacion.ALL_COLUMNS_IDENTIFICACIONES,null,null,null,null,null);
            while(cursor.moveToNext()){
                POJOIdentificacion POJOIdentificacion = new POJOIdentificacion();
                POJOIdentificacion.setID(cursor.getString(cursor.getColumnIndex(SQLIdentificacion.IDENTIFICACION_ID)));
                POJOIdentificacion.setNUM_RUC(cursor.getString(cursor.getColumnIndex(SQLIdentificacion.IDENTIFICACION_RUC)));
                POJOIdentificacion.setRAZON_SOCIAL(cursor.getString(cursor.getColumnIndex(SQLIdentificacion.IDENTIFICACION_RAZON)));
                POJOIdentificacion.setNOM_COMER_COOP(cursor.getString(cursor.getColumnIndex(SQLIdentificacion.IDENTIFICACION_NOMBRE)));
                POJOIdentificacion.setPAG_WEB(cursor.getString(cursor.getColumnIndex(SQLIdentificacion.IDENTIFICACION_WEB)));
                POJOIdentificacion.setPAG_WEB_NO(cursor.getString(cursor.getColumnIndex(SQLIdentificacion.IDENTIFICACION_WEBNO)));
                POJOIdentificacion.setCORREO(cursor.getString(cursor.getColumnIndex(SQLIdentificacion.IDENTIFICACION_CORREO)));
                POJOIdentificacion.setCORREO_NO(cursor.getString(cursor.getColumnIndex(SQLIdentificacion.IDENTIFICACION_CORREONO)));
                POJOIdentificacion.setTEL_FIJO(cursor.getString(cursor.getColumnIndex(SQLIdentificacion.IDENTIFICACION_FIJO)));
                POJOIdentificacion.setTEL_FIJO_NO(cursor.getString(cursor.getColumnIndex(SQLIdentificacion.IDENTIFICACION_FIJONO)));
                POJOIdentificacion.setTEL_MOVIL(cursor.getString(cursor.getColumnIndex(SQLIdentificacion.IDENTIFICACION_MOVIL)));
                POJOIdentificacion.setTEL_MOVIL_NO(cursor.getString(cursor.getColumnIndex(SQLIdentificacion.IDENTIFICACION_MOVILNO)));
                POJOIdentificacion.setANIO_OPERACION(cursor.getString(cursor.getColumnIndex(SQLIdentificacion.IDENTIFICACION_ANIO_FUNCIONAMIENTO)));
                POJOIdentificacion.setNOM_INFORMANTE(cursor.getString(cursor.getColumnIndex(SQLIdentificacion.IDENTIFICACION_CONDUCTOR_NOMBRE)));
                POJOIdentificacion.setSEXO_INFORMANTE(cursor.getString(cursor.getColumnIndex(SQLIdentificacion.IDENTIFICACION_CONDUCTOR_SEXO)));
                POJOIdentificacion.setEDAD_INFORMANTE(cursor.getString(cursor.getColumnIndex(SQLIdentificacion.IDENTIFICACION_CONDUCTOR_EDAD)));
                POJOIdentificacion.setACAD_INFORMANTE(cursor.getString(cursor.getColumnIndex(SQLIdentificacion.IDENTIFICACION_CONDUCTOR_ESTUDIOS)));
                POJOIdentificacion.setCARGO_INFORMANTE(cursor.getString(cursor.getColumnIndex(SQLIdentificacion.IDENTIFICACION_CONDUCTOR_CARGO)));
                POJOIdentificacion.setCARGO_INFORMANTE_ESP(cursor.getString(cursor.getColumnIndex(SQLIdentificacion.IDENTIFICACION_CONDUCTOR_CARGO_ESP)));
                identificaciones.add(POJOIdentificacion);
            }
        }finally {
            if(cursor != null) cursor.close();
        }
        return identificaciones;
    }
    public void deleteIdentificacion(String idEmpresa){
        String[] whereArgs = new String[]{idEmpresa};
        sqLiteDatabase.delete(SQLIdentificacion.tableIdentificaciones,SQLIdentificacion.WHERE_CLAUSE_ID_EMPRESA,whereArgs);
    }
}
