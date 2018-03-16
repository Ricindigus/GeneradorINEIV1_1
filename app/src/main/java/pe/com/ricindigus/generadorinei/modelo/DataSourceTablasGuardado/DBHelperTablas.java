package pe.com.ricindigus.generadorinei.modelo.DataSourceTablasGuardado;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.modelo.DataControladorVersiones.DataVersion;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.DataComponentes;
import pe.com.ricindigus.generadorinei.parser.InfoTablasPullParser;
import pe.com.ricindigus.generadorinei.pojos.InfoTabla;
import pe.com.ricindigus.generadorinei.pojos.Variable;


/**
 * Created by dmorales on 08/01/2018.
 */

public class DBHelperTablas extends SQLiteOpenHelper {
    private Context contexto;
    ArrayList<InfoTabla> infoTablas;
    ArrayList<Variable> variables;

    public DBHelperTablas(Context context, int version) {
        super(context, SQLConstantesTablas.NOMBRE_DB, null, version);
        this.contexto = context;

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        DataComponentes dataComponentes = new DataComponentes(contexto);
        dataComponentes.open();
        infoTablas = dataComponentes.getAllInfoTablas();
        for (InfoTabla infoTabla : infoTablas){
            String crearTabla = "";
            String idTabla= infoTabla.getID();
            crearTabla = crearTabla + "CREATE TABLE "+ "modulo" + idTabla + "(";
            if (infoTabla.getTIPO().equals("1")){
                crearTabla = crearTabla + "ID_EMPRESA" + " TEXT PRIMARY KEY";
            }else{
                crearTabla = crearTabla + "_id" + " TEXT PRIMARY KEY,"
                            + "ID_EMPRESA" + " TEXT";
            }
            variables = dataComponentes.getVariablesxTabla(idTabla);
            for (Variable variable : variables){
                crearTabla = crearTabla + "," + variable.getID() + " TEXT";
            }
            crearTabla = crearTabla + ");";
            sqLiteDatabase.execSQL(crearTabla);
        }
        dataComponentes.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        DataComponentes dataComponentes = new DataComponentes(contexto);
        dataComponentes.open();
        infoTablas = dataComponentes.getAllInfoTablas();
        for (InfoTabla infoTabla:infoTablas) {
            sqLiteDatabase.execSQL("DROP TABLE modulo" + infoTabla.getID());
        }
        dataComponentes.close();
        onCreate(sqLiteDatabase);
    }

}
