package pe.com.ricindigus.generadorinei.modelo;

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
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
