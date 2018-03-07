package pe.com.ricindigus.generadorinei.modelo.DataSourceCaptura;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.DataComponentes;

/**
 * Created by dmorales on 13/12/2017.
 */

public class DBHelper extends SQLiteOpenHelper{
    public static final int DB_VERSION = 1;
    private Context contexto;
    public DBHelper(Context context) {
        super(context, SQLConstantes.DB, null, DB_VERSION);
        this.contexto = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_MARCO);
        sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_USUARIOS);
        sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_UBIGEOS);
        sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_TABLAS);
        sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_CONTROLADOR);


        DataComponentes dataComponentes = new DataComponentes(contexto);
        dataComponentes.open();
        long nPaginas = dataComponentes.getNumeroItemsPaginas();
        String crearControladorPaginas = "CREATE TABLE " + SQLConstantes.tablaPaginador+ "(" +
                "ID_EMPRESA" + " TEXT PRIMARY KEY";
        for (int i = 1; i <= nPaginas; i++) {
            crearControladorPaginas = crearControladorPaginas + "," + "p"+ i + " TEXT";
        }
        crearControladorPaginas = crearControladorPaginas + ");";
        sqLiteDatabase.execSQL(crearControladorPaginas);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQLConstantes.SQL_DELETE_MARCO);
        sqLiteDatabase.execSQL(SQLConstantes.SQL_DELETE_USUARIOS);
        sqLiteDatabase.execSQL(SQLConstantes.SQL_DELETE_UBIGEO);
        sqLiteDatabase.execSQL(SQLConstantes.SQL_DELETE_TABLA);
        sqLiteDatabase.execSQL(SQLConstantes.SQL_DELETE_CONTROLADOR);
        sqLiteDatabase.execSQL(SQLConstantes.SQL_DELETE_PAGINADOR);
        onCreate(sqLiteDatabase);
    }
}
