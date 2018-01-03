package pe.com.ricindigus.generadorinei.componentes.componente_caratula;

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

public class DataCaratula {
    Context contexto;
    SQLiteOpenHelper sqLiteOpenHelper;
    SQLiteDatabase sqLiteDatabase;

    public DataCaratula(Context contexto) {
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
    
    public long getNumeroItemsCaratula(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase,SQLCaratula.tableCaratulas);
    }

    
    public void insertarCaratula(POJOCaratula POJOCaratula){
        ContentValues contentValues = POJOCaratula.toValues();
        sqLiteDatabase.insert(SQLCaratula.tableCaratulas,null,contentValues);
    }
    public void InsertarCaratulas(ArrayList<POJOCaratula> POJOCaratulas){
        long items = getNumeroItemsCaratula();
        if(items == 0){
            for (POJOCaratula POJOCaratula : POJOCaratulas) {
                try {
                    insertarCaratula(POJOCaratula);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public void actualizarCaratula(String idEmpresa, ContentValues contentValues){
        String[] whereArgs = new String[]{idEmpresa};
        sqLiteDatabase.update(SQLCaratula.tableCaratulas,contentValues,SQLCaratula.WHERE_CLAUSE_ID_EMPRESA,whereArgs);
    }
    public boolean existeCaratula(String idEmpresa){
        boolean encontrado = false;
        String[] whereArgs = new String[]{idEmpresa};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLCaratula.tableCaratulas,
                    SQLCaratula.ALL_COLUMNS_CARATULA,SQLCaratula.WHERE_CLAUSE_ID_EMPRESA,whereArgs,null,null,null);
            if(cursor.getCount() == 1) encontrado = true;
        }finally {
            if(cursor != null)cursor.close();
        }
        return encontrado;
    }
    public POJOCaratula getCaratula(String idEmpresa){
        POJOCaratula POJOCaratula = new POJOCaratula();
        String[] whereArgs = new String[]{idEmpresa};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLCaratula.tableCaratulas,
                    SQLCaratula.ALL_COLUMNS_CARATULA,SQLCaratula.WHERE_CLAUSE_ID_EMPRESA,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                POJOCaratula.setID(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_ID)));
                POJOCaratula.setCAMBIO(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_CAMBIO)));
                POJOCaratula.setNOMBREDD(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_DEPARTAMENTO)));
                POJOCaratula.setCCDD(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_DEPARTAMENTO_COD)));
                POJOCaratula.setNOMBREPV(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_PROVINCIA)));
                POJOCaratula.setCCPP(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_PROVINCIA_COD)));
                POJOCaratula.setNOMBREDI(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_DISTRITO)));
                POJOCaratula.setCCDI(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_DISTRITO_COD)));
                POJOCaratula.setGPSLATITUD(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_GPSLATITUD)));
                POJOCaratula.setGPSALTITUD(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_GPSALTITUD)));
                POJOCaratula.setGPSLONGITUD(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_GPSLONGITUD)));
                POJOCaratula.setCCST(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_SECTOR)));
                POJOCaratula.setCCAT(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_AREA)));
                POJOCaratula.setZON_NUM(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_ZONA)));
                POJOCaratula.setMZ_ID(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_MANZANA_MUESTRA)));
                POJOCaratula.setFRENTE(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_FRENTE)));
                POJOCaratula.setTIPVIA(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_TIPVIA)));
                POJOCaratula.setNOMVIA(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_NOMVIA)));
                POJOCaratula.setNROPTA(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_NPUERTA)));
                POJOCaratula.setBLOCK(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_BLOCK)));
                POJOCaratula.setINT(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_INTERIOR)));
                POJOCaratula.setPISO(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_PISO)));
                POJOCaratula.setMZA(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_MANZANA_VIA)));
                POJOCaratula.setLOTE(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_LOTE)));
                POJOCaratula.setKM(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_KM)));
                POJOCaratula.setREF_DIREC(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_REFERENCIA)));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return POJOCaratula;
    }
    public ArrayList<POJOCaratula> getAllCaratulas(){
        ArrayList<POJOCaratula> POJOCaratulas = new ArrayList<POJOCaratula>();
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLCaratula.tableCaratulas,
                    SQLCaratula.ALL_COLUMNS_CARATULA,null,null,null,null,null);
            while(cursor.moveToNext()) {
                POJOCaratula POJOCaratula = new POJOCaratula();
                POJOCaratula.setID(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_ID)));
                POJOCaratula.setCAMBIO(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_CAMBIO)));
                POJOCaratula.setNOMBREDD(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_DEPARTAMENTO)));
                POJOCaratula.setCCDD(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_DEPARTAMENTO_COD)));
                POJOCaratula.setNOMBREPV(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_PROVINCIA)));
                POJOCaratula.setCCPP(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_PROVINCIA_COD)));
                POJOCaratula.setNOMBREDI(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_DISTRITO)));
                POJOCaratula.setCCDI(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_DISTRITO_COD)));
                POJOCaratula.setGPSLATITUD(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_GPSLATITUD)));
                POJOCaratula.setGPSALTITUD(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_GPSALTITUD)));
                POJOCaratula.setGPSLONGITUD(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_GPSLONGITUD)));
                POJOCaratula.setCCST(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_SECTOR)));
                POJOCaratula.setCCAT(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_AREA)));
                POJOCaratula.setZON_NUM(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_ZONA)));
                POJOCaratula.setMZ_ID(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_MANZANA_MUESTRA)));
                POJOCaratula.setFRENTE(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_FRENTE)));
                POJOCaratula.setTIPVIA(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_TIPVIA)));
                POJOCaratula.setNOMVIA(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_NOMVIA)));
                POJOCaratula.setNROPTA(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_NPUERTA)));
                POJOCaratula.setBLOCK(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_BLOCK)));
                POJOCaratula.setINT(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_INTERIOR)));
                POJOCaratula.setPISO(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_PISO)));
                POJOCaratula.setMZA(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_MANZANA_VIA)));
                POJOCaratula.setLOTE(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_LOTE)));
                POJOCaratula.setKM(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_KM)));
                POJOCaratula.setREF_DIREC(cursor.getString(cursor.getColumnIndex(SQLCaratula.CARATULA_REFERENCIA)));
                POJOCaratulas.add(POJOCaratula);
            }
        }finally {
            if(cursor!=null) cursor.close();
        }
        return POJOCaratulas;
    }
    public void deleteCaratula(String idEmpresa){
        String[] whereArgs = new String[]{idEmpresa};
        sqLiteDatabase.delete(SQLCaratula.tableCaratulas,SQLCaratula.WHERE_CLAUSE_ID_EMPRESA,whereArgs);
    }

//-----------------------------------------FIN CARATULA-------------------------------------------------------------------------------


}
