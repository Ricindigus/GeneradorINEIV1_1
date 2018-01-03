package pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import pe.com.ricindigus.generadorinei.componentes.componente_checkbox.SQLCheckBox;
import pe.com.ricindigus.generadorinei.componentes.componente_edittext.SQLEditText;
import pe.com.ricindigus.generadorinei.componentes.componente_radio.SQLRadio;

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
        sqLiteDatabase.execSQL(SQLEditText.SQL_CREATE_TABLA_EDITTEXT);
        sqLiteDatabase.execSQL(SQLEditText.SQL_CREATE_TABLA_SPEDITTEXT);
        sqLiteDatabase.execSQL(SQLCheckBox.SQL_CREATE_TABLA_CHECKBOX);
        sqLiteDatabase.execSQL(SQLCheckBox.SQL_CREATE_TABLA_SPCHECKBOX);
        sqLiteDatabase.execSQL(SQLRadio.SQL_CREATE_TABLA_RADIO);
        sqLiteDatabase.execSQL(SQLRadio.SQL_CREATE_TABLA_SPRADIO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(SQLConstantesComponente.SQL_DELETE_ENCUESTAS);
        sqLiteDatabase.execSQL(SQLConstantesComponente.SQL_DELETE_MODULOS);
        sqLiteDatabase.execSQL(SQLConstantesComponente.SQL_DELETE_PAGINAS);
        sqLiteDatabase.execSQL(SQLEditText.SQL_DELETE_EDITTEXT);
        sqLiteDatabase.execSQL(SQLEditText.SQL_DELETE_SPEDITTEXT);
        sqLiteDatabase.execSQL(SQLCheckBox.SQL_DELETE_CHECKBOX);
        sqLiteDatabase.execSQL(SQLCheckBox.SQL_DELETE_SPCHECKBOX);
        sqLiteDatabase.execSQL(SQLRadio.SQL_DELETE_RADIO);
        sqLiteDatabase.execSQL(SQLRadio.SQL_DELETE_SPRADIO);
        onCreate(sqLiteDatabase);
    }
}
