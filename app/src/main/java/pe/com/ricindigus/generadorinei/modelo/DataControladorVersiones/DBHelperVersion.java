package pe.com.ricindigus.generadorinei.modelo.DataControladorVersiones;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import pe.com.ricindigus.generadorinei.modelo.DataSourceCaptura.SQLConstantes;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.SQLConstantesComponente;

/**
 * Created by dmorales on 16/03/2018.
 */

public class DBHelperVersion extends SQLiteOpenHelper {
    public static final int DB_VERSION = 1;

    public DBHelperVersion(Context context) {
        super(context, SQLVersion.DB, null, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQLVersion.SQL_CREATE_TABLA_VERSIONES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(SQLVersion.SQL_DELETE_VERSIONES);
        onCreate(sqLiteDatabase);
    }
}
