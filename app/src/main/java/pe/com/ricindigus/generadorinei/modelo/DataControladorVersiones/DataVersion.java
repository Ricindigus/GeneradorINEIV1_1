package pe.com.ricindigus.generadorinei.modelo.DataControladorVersiones;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.modelo.DataSourceCaptura.DBHelper;
import pe.com.ricindigus.generadorinei.modelo.DataSourceCaptura.SQLConstantes;
import pe.com.ricindigus.generadorinei.modelo.DataSourceTablasGuardado.SQLConstantesTablas;
import pe.com.ricindigus.generadorinei.pojos.Ubigeo;
import pe.com.ricindigus.generadorinei.pojos.Version;

/**
 * Created by dmorales on 16/03/2018.
 */

public class DataVersion {
    Context contexto;
    SQLiteOpenHelper sqLiteOpenHelper;
    SQLiteDatabase sqLiteDatabase;

    public DataVersion(Context contexto) {
        this.contexto = contexto;
        sqLiteOpenHelper = new DBHelperVersion(contexto);
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    }

    public void open(){
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    }

    public void close(){
        sqLiteOpenHelper.close();
    }

    public void insertarVersionesIniciales(){
        Version version = new Version("1","1","1","1");
        ContentValues contentValues = version.toValues();
        sqLiteDatabase.insert(SQLVersion.tablaVersiones,null,contentValues);
    }

    public void actualizarVersion(String idBD, String version){
        ContentValues contentValues = new ContentValues();
        contentValues.put(idBD,version);
        String[] whereArgs = new String[]{"1"};
        sqLiteDatabase.update(SQLVersion.tablaVersiones,contentValues, SQLVersion.WHERE_CLAUSE_ID,whereArgs);
    }

    public String getVersion(String idDB){
        String version = "";
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLVersion.tablaVersiones, null,null,null,null,null,null);
            cursor.moveToFirst();
            version = cursor.getString(cursor.getColumnIndex(idDB));
        }finally{
            if(cursor != null) cursor.close();
        }
        return version;
    }
}
