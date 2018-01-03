package pe.com.ricindigus.generadorinei.componentes.componente_visitas;

import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import pe.com.ricindigus.generadorinei.modelo.DataSourceCaptura.DBHelper;
import pe.com.ricindigus.generadorinei.modelo.DataSourceCaptura.SQLConstantes;

/**
 * Created by RICARDO on 1/01/2018.
 */

public class DataVisitas {
    Context contexto;
    SQLiteOpenHelper sqLiteOpenHelper;
    SQLiteDatabase sqLiteDatabase;

    public DataVisitas(Context contexto) {
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

    public long getNumeroItemsVisita(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase,SQLVisitas.tableVisitas);
    }

}
