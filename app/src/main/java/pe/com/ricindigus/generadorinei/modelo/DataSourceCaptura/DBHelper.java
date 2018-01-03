package pe.com.ricindigus.generadorinei.modelo.DataSourceCaptura;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import pe.com.ricindigus.generadorinei.componentes.componente_caratula.SQLCaratula;
import pe.com.ricindigus.generadorinei.componentes.componente_identificacion.SQLIdentificacion;
import pe.com.ricindigus.generadorinei.componentes.componente_visitas.SQLVisitas;

/**
 * Created by dmorales on 13/12/2017.
 */

public class DBHelper extends SQLiteOpenHelper{
    public static final int DB_VERSION = 1;
    public DBHelper(Context context) {
        super(context, SQLConstantes.DB, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_MARCO);
        sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_USUARIOS);
        sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_UBIGEOS);
        sqLiteDatabase.execSQL(SQLCaratula.SQL_CREATE_TABLA_CARATULAS);
        sqLiteDatabase.execSQL(SQLVisitas.SQL_CREATE_TABLA_VISITAS);
        sqLiteDatabase.execSQL(SQLVisitas.SQL_CREATE_TABLA_DATOS_ENTREVISTA);
        sqLiteDatabase.execSQL(SQLIdentificacion.SQL_CREATE_TABLA_IDENTIFICACIONES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQLConstantes.SQL_DELETE_MARCO);
        sqLiteDatabase.execSQL(SQLConstantes.SQL_DELETE_USUARIOS);
        sqLiteDatabase.execSQL(SQLConstantes.SQL_DELETE_UBIGEO);
        sqLiteDatabase.execSQL(SQLCaratula.SQL_DELETE_CARATULAS);
        sqLiteDatabase.execSQL(SQLVisitas.SQL_DELETE_DATOS_ENTREVISTA);
        sqLiteDatabase.execSQL(SQLVisitas.SQL_DELETE_VISITAS);
        sqLiteDatabase.execSQL(SQLIdentificacion.SQL_DELETE_IDENTIFICACIONES);
        onCreate(sqLiteDatabase);
    }
}
