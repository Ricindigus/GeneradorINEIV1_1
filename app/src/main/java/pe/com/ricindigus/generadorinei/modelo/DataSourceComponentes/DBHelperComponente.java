package pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by dmorales on 23/11/2017.
 */

public class DBHelperComponente extends SQLiteOpenHelper{
    public static final int DB_VERSION = 1;

    public DBHelperComponente(Context context) {
        super(context, SQLConstantesComponente.NOMBRE_DB, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQLConstantesComponente.SQL_CREATE_TABLA_ENCUESTAS);
        sqLiteDatabase.execSQL(SQLConstantesComponente.SQL_CREATE_TABLA_MODULOS);
        sqLiteDatabase.execSQL(SQLConstantesComponente.SQL_CREATE_TABLA_PAGINAS);
        sqLiteDatabase.execSQL(SQLConstantesComponente.SQL_CREATE_TABLA_EDITTEXT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(SQLConstantesComponente.SQL_DELETE_ENCUESTAS);
        sqLiteDatabase.execSQL(SQLConstantesComponente.SQL_DELETE_MODULOS);
        sqLiteDatabase.execSQL(SQLConstantesComponente.SQL_DELETE_PAGINAS);
        sqLiteDatabase.execSQL(SQLConstantesComponente.SQL_DELETE_EDITTEXT);
        onCreate(sqLiteDatabase);
    }
}
