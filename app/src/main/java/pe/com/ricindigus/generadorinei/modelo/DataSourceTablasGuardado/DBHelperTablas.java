package pe.com.ricindigus.generadorinei.modelo.DataSourceTablasGuardado;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.DataComponentes;
import pe.com.ricindigus.generadorinei.parser.TablaGuardadoPullParser;


/**
 * Created by dmorales on 08/01/2018.
 */

public class DBHelperTablas extends SQLiteOpenHelper {
    public static final int DB_VERSION = 1;
    private Context contexto;
    TablaGuardadoPullParser tablaGuardadoPullParser;
    ArrayList<String> tablas;

    public DBHelperTablas(Context context) {
        super(context, SQLConstantesTablas.NOMBRE_DB, null, DB_VERSION);
        this.contexto = context;

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        tablaGuardadoPullParser = new TablaGuardadoPullParser();
        tablas = tablaGuardadoPullParser.parseXML(contexto);
        for (String createTabla : tablas){
            sqLiteDatabase.execSQL(createTabla);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        tablaGuardadoPullParser = new TablaGuardadoPullParser();
        tablas = tablaGuardadoPullParser.parseXML(contexto);
        sqLiteDatabase.execSQL("DROP TABLE moduloA1");
        sqLiteDatabase.execSQL("DROP TABLE moduloA2");
        sqLiteDatabase.execSQL("DROP TABLE moduloB");
        sqLiteDatabase.execSQL("DROP TABLE moduloC");
        for (int i = 1; i <= tablas.size()-2; i++) {
            sqLiteDatabase.execSQL("DROP TABLE modulo" + i);
        }
        onCreate(sqLiteDatabase);
    }
}
