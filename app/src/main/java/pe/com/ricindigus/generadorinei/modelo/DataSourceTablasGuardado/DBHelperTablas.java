package pe.com.ricindigus.generadorinei.modelo.DataSourceTablasGuardado;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by dmorales on 08/01/2018.
 */

public class DBHelperTablas extends SQLiteOpenHelper {
    public static final int DB_VERSION = 1;

    public DBHelperTablas(Context context) {
        super(context, SQLConstantesTablas.NOMBRE_DB, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        for (String createTabla : SQLConstantesTablas.SQL_CREATE_TABLA_MODULO){
            sqLiteDatabase.execSQL(createTabla);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        for (String deleteTabla : SQLConstantesTablas.SQL_DELETE_TABLA_MODULO){
            sqLiteDatabase.execSQL(deleteTabla);
        }
        onCreate(sqLiteDatabase);
    }
}
